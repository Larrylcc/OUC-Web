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
      <el-table :data="tableData" strip @selection-change="handleSelectionChange" class="custom-table">
        <el-table-column type="selection" width="55" align="center"></el-table-column>
        <el-table-column prop="id" label="序号" width="70" align="center" sortable></el-table-column>
        <el-table-column prop="username" label="账号"></el-table-column>
        <el-table-column prop="name" label="姓名"></el-table-column>
        <el-table-column prop="phone" label="电话"></el-table-column>
        <el-table-column prop="email" label="邮箱"></el-table-column>
        <el-table-column label="头像">
          <template v-slot="scope">
            <div class="avatar-container">
              <el-image v-if="scope.row.avatar" :src="scope.row.avatar" :preview-src-list="[scope.row.avatar]"></el-image>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" width="180">
          <template v-slot="scope">
            <el-button size="mini" type="primary" plain @click="handleEdit(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" plain @click="del(scope.row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页组件 -->
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

    <!-- 管理员弹窗 -->
    <el-dialog title="管理员" :visible.sync="fromVisible" width="40%" :close-on-click-modal="false" destroy-on-close>
      <el-form :model="form" label-width="100px" style="padding-right: 50px" :rules="rules" ref="formRef">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="form.phone" placeholder="电话"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="邮箱"></el-input>
        </el-form-item>
        <el-form-item label="头像">
          <el-upload
              class="avatar-uploader"
              :action="$baseUrl + '/files/upload'"
              :headers="{ token: user.token }"
              list-type="picture"
              :on-success="handleAvatarSuccess">
            <el-button type="primary">上传头像</el-button>
          </el-upload>
        </el-form-item>
      </el-form>

      <!-- 弹窗底部操作 -->
      <div slot="footer" class="dialog-footer">
        <el-button @click="fromVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>


<script>
export default {
  name: "GUANLIYUAN",
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
        username: [{required: true, message: '请输入账号', trigger: 'blur'}]
      },
      ids: []
    };
  },
  created() {
    this.load(1);
  },
  methods: {
    // 表单字段通用处理方法
    formHandler() {
      return [
        {label: '用户名', prop: 'username'},
        {label: '姓名', prop: 'name'},
        {label: '电话', prop: 'phone'},
        {label: '邮箱', prop: 'email'}
      ];
    },

    // 新增
    handleAdd() {
      this.form = {};
      this.fromVisible = true;
    },

    // 编辑
    handleEdit(row) {
      this.form = { ...row };  // 深拷贝数据
      this.fromVisible = true;
    },

    // 保存
    save() {
      this.$refs.formRef.validate(valid => {
        if (valid) {
          this.$request({
            url: this.form.id ? '/guanliyuan/update' : '/guanliyuan/add',
            method: this.form.id ? 'PUT' : 'POST',
            data: this.form
          }).then(res => {
            if (res.code === '200') {
              this.$message.success('保存成功');
              this.load(1);
              this.fromVisible = false;
            } else {
              this.$message.error(res.msg);
            }
          });
        }
      });
    },

    // 删除
    del(id) {
      this.$confirm('您确定删除吗？', '确认删除', {type: "warning"}).then(() => {
        this.$request.delete('/guanliyuan/delete/' + id).then(res => {
          if (res.code === '200') {
            this.$message.success('操作成功');
            this.load(1);
          } else {
            this.$message.error(res.msg);
          }
        });
      });
    },

    // 分页查询
    load(pageNum) {
      if (pageNum) this.pageNum = pageNum;
      this.$request.get('/guanliyuan/selectPage', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          username: this.username
        }
      }).then(res => {
        this.tableData = res.data?.list;
        this.total = res.data?.total;
      });
    },

    // 选择行数据
    handleSelectionChange(rows) {
      this.ids = rows.map(v => v.id);
    },

    // 批量删除
    delBatch() {
      if (!this.ids.length) {
        this.$message.warning('请选择数据');
        return;
      }
      this.$confirm('您确定批量删除这些数据吗？', '确认删除', {type: "warning"}).then(() => {
        this.$request.delete('/guanliyuan/delete/batch', {data: this.ids}).then(res => {
          if (res.code === '200') {
            this.$message.success('操作成功');
            this.load(1);
          } else {
            this.$message.error(res.msg);
          }
        });
      });
    },

    // 处理分页变化
    handleCurrentChange(pageNum) {
      this.load(pageNum);
    },

    // 头像上传成功回调
    handleAvatarSuccess(response) {
      this.form.avatar = response.data;
    },

    // 重置查询条件
    reset() {
      this.username = null;
      this.load(1);
    }
  }
};
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
  justify-content: flex-end;
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
