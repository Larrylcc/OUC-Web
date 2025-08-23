<template>
  <div>
    <div class="search">
      <el-input placeholder="请输入课程名称" style="width: 200px" v-model="name"></el-input>
      <el-button type="info" plain style="margin-left: 10px" @click="load(1)">查询</el-button>
      <el-button type="warning" plain style="margin-left: 10px" @click="reset">重置</el-button>
    </div>
    <div class="table">
      <el-table :data="tableData" stripe>
        <el-table-column type="selection" width="55" align="center" v-if="user.role === 'GUANLIYUAN'"></el-table-column>
        <el-table-column prop="name" label="课程名称" show-overflow-tooltip></el-table-column>
        <el-table-column prop="type" label="课程类型" show-overflow-tooltip></el-table-column>
        <el-table-column prop="jiaoshimingcheng" label="授课教师" show-overflow-tooltip></el-table-column>
        <el-table-column prop="xuefen" label="学分" show-overflow-tooltip></el-table-column>
        <el-table-column prop="renshu" label="上课人数" show-overflow-tooltip></el-table-column>
        <el-table-column prop="jiaoshi" label="上课教室" show-overflow-tooltip></el-table-column>
        <el-table-column prop="xingqi" label="周几" show-overflow-tooltip></el-table-column>
        <el-table-column prop="segment" label="第几大节" show-overflow-tooltip></el-table-column>
        <el-table-column prop="status" label="上课状态" show-overflow-tooltip></el-table-column>
        <el-table-column prop="xueshengxingcheng" label="选课学生" show-overflow-tooltip></el-table-column>
        <el-table-column prop="scorec" label="成绩" show-overflow-tooltip></el-table-column>
        <el-table-column label="操作" width="180" align="center" v-if="user.role === 'XUESHENG'">
          <template v-slot="scope">
            <el-button plain type="danger" size="mini" @click=del(scope.row.id) :disabled="scope.row.status !== '未开课'">取消选课</el-button>
            <el-button plain type="primary" size="mini" @click="initComment(scope.row)" :disabled="scope.row.status !== '已结课'">评教</el-button>
          </template>
        </el-table-column>
      </el-table>

      <div class="pagination">
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
    <el-dialog title="请填写评教信息" :visible.sync="fromVisible" width="40%" :close-on-click-modal="false" destroy-on-close>
      <el-form label-width="100px" style="padding-right: 50px" :model="form" :rules="rules" ref="formRef">
        <el-form-item prop="neirong" label="评教内容">
          <el-input type="textarea" :rows="5" v-model="form.neirong" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="fromVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "Choice",
  data() {
    return {
      tableData: [],  // 所有的数据
      pageNum: 1,   // 当前的页码
      pageSize: 10,  // 每页显示的个数
      total: 0,
      name:null,
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      rules: {
        neirong: [
          {required: true, message: '请输入内容', trigger: 'blur'},
        ]
      },
      ids: [],
      form: {},
      fromVisible: false
    }
  },
  created() {
    this.load(1)
  },
  methods: {
    initComment(row) {
      this.form = JSON.parse(JSON.stringify(row))
      this.fromVisible = true
    },
    save() {
      let data = {
        name: this.form.name,
        xuesheng: this.user.name,
        neirong: this.form.neirong
      }
      this.$request.post('/pingjia/add', data).then(res => {
        if (res.code === '200') {
          this.$message.success('评教成功')
          this.fromVisible = false
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    del(id) {   // 单个删除
      this.$confirm('您确定取消选这门课吗？', '取消', {type: "warning"}).then(response => {
        this.$request.delete('/xuanke/delete/' + id).then(res => {
          if (res.code === '200') {   // 表示操作成功
            this.$message.success('操作成功')
            this.load(1)
          } else {
            this.$message.error(res.msg)  // 弹出错误的信息
          }
        })
      }).catch(() => {
      })
    },
    load(pageNum) {  // 分页查询
      if (pageNum) this.pageNum = pageNum
      this.$request.get('/xuanke/selectPage', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          name: this.name,
        }
      }).then(res => {
        this.tableData = res.data?.list
        this.total = res.data?.total
      })
    },
    reset() {
      this.name = null
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
