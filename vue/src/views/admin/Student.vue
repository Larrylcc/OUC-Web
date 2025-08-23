<template>
  <div class="guanliyuan-container">
    <!-- 搜索区域 -->
    <div class="search">
      <el-input placeholder="请输入账号查询" style="width: 220px; border-radius: 10px" v-model="username"></el-input>
      <el-button type="info" plain class="search-btn" @click="load(1)">查询</el-button>
      <el-button type="warning" plain class="reset-btn" @click="reset">重置</el-button>
    </div>

    <!-- 操作区域 -->
    <div class="operation">
      <el-button type="primary" plain class="operation-btn" @click="handleAdd">新增</el-button>
      <el-button type="danger" plain class="operation-btn" @click="delBatch">批量删除</el-button>
    </div>


    <!-- 数据表格 -->
    <div class="table">
      <el-table :data="tableData" stripe @selection-change="handleSelectionChange" class="custom-table">
        <el-table-column type="selection" width="55" align="center"></el-table-column>
        <el-table-column prop="id" label="序号" width="70" align="center" sortable></el-table-column>
        <el-table-column label="头像">
          <template v-slot="scope">
            <div class="avatar-container">
              <el-image v-if="scope.row.avatar" :src="scope.row.avatar" :preview-src-list="[scope.row.avatar]" class="avatar-image"></el-image>
            </div>
          </template>
        </el-table-column>
        <el-table-column prop="username" label="账号"></el-table-column>
        <el-table-column prop="name" label="姓名"></el-table-column>
        <el-table-column prop="collegeName" label="学院"></el-table-column>
        <el-table-column prop="specialitymingcheng" label="专业"></el-table-column>
        <el-table-column prop="className" label="班级"></el-table-column>
        <el-table-column label="操作" align="center" width="180">
          <template v-slot="scope">
            <el-button size="mini" type="primary" plain @click="handleEdit(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" plain @click="del(scope.row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页 -->
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

    <!-- 教师信息弹窗 -->
    <el-dialog title="教师信息" :visible.sync="fromVisible" width="50%" :close-on-click-modal="false" destroy-on-close>
      <el-form :model="form" label-width="100px" style="padding-right: 50px" :rules="rules" ref="formRef">
        <el-form-item label="头像">
          <el-upload
              class="avatar-uploader"
              :action="$baseUrl + '/files/upload'"
              :headers="{ token: user.token }"
              list-type="picture"
              :on-success="handleAvatarSuccess"
          >
            <el-button type="primary">上传头像</el-button>
          </el-upload>
        </el-form-item>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名" class="input-field"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" class="input-field"></el-input>
        </el-form-item>
        <el-form-item label="学院" prop="collegeId">
          <el-select v-model="form.collegeId" placeholder="请选择学院" class="input-field">
            <el-option v-for="item in collegeData" :label="item.name" :value="item.id" :key="item.id"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="专业" prop="specialityId">
          <el-select v-model="form.specialityId" placeholder="请选择专业" class="input-field">
            <el-option v-for="item in specialityData" :label="item.name" :value="item.id" :key="item.id"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="班级" prop="classId">
          <el-select v-model="form.classId" placeholder="请选择班级" class="input-field">
            <el-option v-for="item in classData" :label="item.name" :value="item.id" :key="item.id"></el-option>
          </el-select>
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
  name: "Student",
  data() {
    return {
      tableData: [],  // 所有的数据
      pageNum: 1,   // 当前的页码
      pageSize: 10,  // 每页显示的个数
      total: 0,
      username: null,
      fromVisible: false,
      form: {},
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      rules: {
        username: [
          {required: true, message: '请输入账号', trigger: 'blur'},
        ]
      },
      ids: [],
      collegeData: [],
      specialityData: [],
      classData: []
    }
  },
  created() {
    this.load(1)
    this.loadCollege()
    this.loadSpeciality()
    this.loadBanji()
  },
  methods: {
    loadCollege() {
      this.$request.get('/xueyuan/selectAll').then(res => {
        if (res.code ==='200') {
          this.collegeData = res.data
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    loadSpeciality() {
      this.$request.get('/speciality/selectAll').then(res => {
        if (res.code === '200') {
          this.specialityData = res.data
        } else {
          this.$message.error(res.data)
        }
      })
    },
    loadBanji() {
      this.$request.get('/banji/selectAll').then(res => {
        if (res.code === '200') {
          this.classData = res.data
        } else {
          this.$message.error(res.data)
        }
      })
    },
    handleAdd() {   // 新增数据
      this.form = {}  // 新增数据的时候清空数据
      this.fromVisible = true   // 打开弹窗
    },
    handleEdit(row) {   // 编辑数据
      this.form = JSON.parse(JSON.stringify(row))  // 给form对象赋值  注意要深拷贝数据
      this.fromVisible = true   // 打开弹窗
    },
    save() {   // 保存按钮触发的逻辑  它会触发新增或者更新
      this.$refs.formRef.validate((valid) => {
        if (valid) {
          this.$request({
            url: this.form.id ? '/xuesheng/update' : '/xuesheng/add',
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
    del(id) {   // 单个删除
      this.$confirm('您确定删除吗？', '确认删除', {type: "warning"}).then(response => {
        this.$request.delete('/xuesheng/delete/' + id).then(res => {
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
    handleSelectionChange(rows) {   // 当前选中的所有的行数据
      this.ids = rows.map(v => v.id)
    },
    delBatch() {   // 批量删除
      if (!this.ids.length) {
        this.$message.warning('请选择数据')
        return
      }
      this.$confirm('您确定批量删除这些数据吗？', '确认删除', {type: "warning"}).then(response => {
        this.$request.delete('/xuesheng/delete/batch', {data: this.ids}).then(res => {
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
      this.$request.get('/xuesheng/selectPage', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          username: this.username,
        }
      }).then(res => {
        this.tableData = res.data?.list
        this.total = res.data?.total
      })
    },
    reset() {
      this.username = null
      this.load(1)
    },
    handleCurrentChange(pageNum) {
      this.load(pageNum)
    },
    handleAvatarSuccess(response, file, fileList) {
      // 把头像属性换成上传的图片的链接
      this.form.avatar = response.data
    },
  }
}
</script>

<style scoped>
.guanliyuan-container {
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 10px;
}

.search, .operation {
  margin-bottom: 20px;
}

.search .el-input {
  background-color: #fff;
  border-radius: 5px;
}

.search-btn, .reset-btn {
  margin-left: 10px;
  border-radius: 5px;
}

.operation-btn {
  border-radius: 5px;
}

.table .custom-table {
  background-color: #fff;
  box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
}

.table .avatar-container {
  display: flex;
  align-items: center;
}

.table .el-image {
  border-radius: 50%;
}

.dialog-footer {
  display: flex;
  justify-neirong: flex-end;
  gap: 10px;
}

.el-dialog {
  border-radius: 8px;
  padding: 20px;
}

.el-button {
  border-radius: 5px;
  transition: background-color 0.3s;
}

.el-button:hover {
  background-color: #f5f5f5;
}
</style>
