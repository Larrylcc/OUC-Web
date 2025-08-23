<template>
  <div>
    <div class="search">
      <el-input placeholder="请输入课程名称" style="width: 200px" v-model="name"></el-input>
      <el-button type="info" plain style="margin-left: 10px" @click="load(1)">查询</el-button>
      <el-input placeholder="请输入课程序号" style="width: 200px" v-model="id"></el-input>
      <el-button type="info" plain style="margin-left: 10px" @click="load(1)">查询</el-button>

      <el-button type="warning" plain style="margin-left: 10px" @click="reset">重置</el-button>
    </div>

    <div class="table">
      <el-table :data="tableData" stripe  @selection-change="handleSelectionChange">
        <el-table-column prop="id" label="序号" width="80" align="center" sortable></el-table-column>
        <el-table-column prop="name" label="课程名称" show-overflow-tooltip></el-table-column>
        <el-table-column prop="type" label="课程类型" show-overflow-tooltip></el-table-column>
        <el-table-column prop="jiaoshimingcheng" label="授课教师" show-overflow-tooltip></el-table-column>
        <el-table-column prop="xuefen" label="学分" show-overflow-tooltip></el-table-column>
        <el-table-column prop="renshu" label="上课人数" show-overflow-tooltip></el-table-column>
        <el-table-column prop="jiaoshi" label="上课教室" show-overflow-tooltip></el-table-column>
        <el-table-column prop="xingqi" label="周几" show-overflow-tooltip></el-table-column>
        <el-table-column prop="segment" label="第几大节" show-overflow-tooltip></el-table-column>
        <el-table-column prop="status" label="上课状态" show-overflow-tooltip></el-table-column>

        <el-table-column label="操作" width="180" align="center">
          <template v-slot="scope">
            <el-button plain type="primary" @click="choiceCourse(scope.row)" size="mini" v-if="user.role === 'XUESHENG'" :disabled="scope.row.status !== '未开课'">选课</el-button>
          </template>
        </el-table-column>
      </el-table>

      <div class="pagination-container" style="text-align: center;">
        <el-pagination
            background
            @current-change="handleCurrentChange"
            :current-page="pageNum"
            :page-sizes="[5, 10, 20]"
            :page-size="pageSize"
            layout="total, prev, pager, next"
            :total="total">
        </el-pagination>
      </div>
    </div>


  </div>
</template>

<script>
export default {
  name: "Course",
  data() {
    return {
      tableData: [],  // 所有的数据
      pageNum: 1,   // 当前的页码
      pageSize: 10,  // 每页显示的个数
      total: 0,
      name: null,
      id: null,
      fromVisible: false,
      form: {},
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      ids: [],
      teacherData: []
    }
  },
  created() {
    this.load(1)
    this.loadTeacher()
  },
  methods: {
    choiceCourse(row) {
      let data = {
        studentId: this.user.id,
        teacherId: row.teacherId,
        courseId: row.id
      }
      this.$request.post('/xuanke/add', data).then(res => {
        if (res.code === '200') {
          this.$message.success('选课成功')
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    load(pageNum) {  // 分页查询
      if (pageNum) this.pageNum = pageNum
      this.$request.get('/course/selectPage', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          id: this.id,
          name: this.name,
        }
      }).then(res => {
        this.tableData = res.data?.list
        this.total = res.data?.total
      })
    },
    reset() {
      this.name = null
      this.id=null
      this.load(1)
    },
    handleCurrentChange(pageNum) {
      this.load(pageNum)
    },
  }
}
</script>

<style scoped>

</style>
