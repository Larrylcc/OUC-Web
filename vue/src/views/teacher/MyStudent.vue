<template>
  <div>
    <div class="search">
      <el-input placeholder="请输入学生学号" style="width: 200px" v-model="studentId"></el-input>
      <el-button type="info" plain style="margin-left: 10px" @click="load(1)">查询</el-button>
      <el-button type="warning" plain style="margin-left: 10px" @click="reset">重置</el-button>
    </div>
    <div class="search">
      <el-input placeholder="请输入学生姓名" style="width: 200px" v-model="xueshengxingcheng"></el-input>
      <el-button type="info" plain style="margin-left: 10px" @click="load(1)">查询</el-button>
      <el-button type="warning" plain style="margin-left: 10px" @click="reset">重置</el-button>
    </div>

    <div class="table">
      <el-table :data="tableData" stripe>
        <el-table-column prop="id" label="序号" width="80" align="center" sortable></el-table-column>
        <el-table-column prop="name" label="课程名称" show-overflow-tooltip></el-table-column>
        <el-table-column prop="jiaoshimingcheng" label="授课教师" show-overflow-tooltip></el-table-column>
        <el-table-column prop="xueshengxingcheng" label="选课学生" show-overflow-tooltip></el-table-column>
        <el-table-column prop="studentId" label="学生学号" show-overflow-tooltip></el-table-column>
        <el-table-column prop="scorec" label="学生成绩" show-overflow-tooltip></el-table-column>


        <el-table-column label="添加成绩" width="180" align="center" >
          <template v-slot="scope">
            <el-button plain type="primary" @click="handleEdit(scope.row)" size="min">编辑</el-button>
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


    <el-dialog title="信息" :visible.sync="fromVisible" width="40%" :close-on-click-modal="false" destroy-on-close>
      <el-form label-width="100px" style="padding-right: 50px" :model="form" :rules="rules" ref="formRef">
        <el-form-item prop="scorec" label="分数">
          <el-input v-model="form.scorec" autocomplete="off"></el-input>
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
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      studentId:null,
      xueshengxingcheng:null,
      rules: {
        name: [
          {required: true, scorec: '请输入标题', trigger: 'blur'},
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
    handleEdit(row) {   // 编辑数据
      this.form = JSON.parse(JSON.stringify(row))  // 给form对象赋值  注意要深拷贝数据
      this.fromVisible = true   // 打开弹窗
    },
    save() {   // 保存按钮触发的逻辑  它会触发新增或者更新
      this.$refs.formRef.validate((valid) => {
        if (valid) {
          this.$request({
            url: this.form.id ? '/xuanke/update' : '/xuanke/add',
            method: this.form.id ? 'PUT' : 'POST',
            data: this.form
          }).then(res => {
            if (res.code === '200') {  // 表示成功保存
              this.$message.success('保存成功')
              this.load(1)
              this.fromVisible = false
            } else {
              this.$message.error(res.msg)  // 弹出错误的信息
            }
          })
        }
      })
    },
    load(pageNum) {  // 分页查询
      if (pageNum) this.pageNum = pageNum
      this.$request.get('/xuanke/selectPage', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          studentId: this.studentId,
          xueshengxingcheng: this.xueshengxingcheng,
        }
      }).then(res => {
        this.tableData = res.data?.list
        this.total = res.data?.total
      })
    },
    reset() {
      this.studentId = null
      this.xueshengxingcheng = null
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
