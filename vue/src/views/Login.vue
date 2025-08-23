<template>
  <div class="container">
    <div class="login-card">
      <div class="title">欢迎登录教务管理系统</div>
      <el-form :model="form" :rules="rules" ref="formRef">
        <el-form-item prop="username">
          <el-input prefix-icon="el-icon-user" placeholder="请输入账号" v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input prefix-icon="el-icon-lock" placeholder="请输入密码" show-password v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item label>
          <el-radio-group v-model="form.role">
            <el-radio label="GUANLIYUAN">管理员</el-radio>
            <el-radio label="LAOSHI">教师</el-radio>
            <el-radio label="XUESHENG">学生</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item>
          <el-button
              class="login-btn"
              style="width: 100%"
              @click="login"
          >
            登 录
          </el-button>
        </el-form-item>
        <div class="footer">
          <span>还没有账号？请 <a href="/register">注册</a></span>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      form: {
        role: "XUESHENG", // 默认角色为学生
      },
      dialogVisible: true,
      rules: {
        username: [{ required: true, message: "请输入账号", trigger: "blur" }],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
      },
    };
  },
  methods: {
    login() {
      this.$refs["formRef"].validate((valid) => {
        if (valid) {
          this.$request.post("/login", this.form).then((res) => {
            if (res.code === "200") {
              localStorage.setItem("xm-user", JSON.stringify(res.data)); // 存储用户数据
              this.$router.push("/"); // 跳转主页
              this.$message.success("登录成功");
            } else {
              this.$message.error(res.msg);
            }
          });
        }
      });
    },
  },
};
</script>

<style scoped>
.container {
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background: linear-gradient(135deg, #74b9ff, #a29bfe);
}

.login-card {
  width: 400px;
  padding: 30px;
  background: white;
  border-radius: 15px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
  align-items: center;
}

.title {
  font-size: 22px;
  font-weight: bold;
  margin-bottom: 20px;
  color: #333;
  text-align: center;
  font-family: "Helvetica Neue", Arial, sans-serif;
}

.el-input {
  font-size: 14px;
}

.el-radio-group {
  display: flex;
  justify-content: space-between;
}

.el-radio {
  font-size: 14px;
}

.login-btn {
  background: #0984e3;
  border-color: #0984e3;
  color: white;
  transition: all 0.3s;
}

.login-btn:hover {
  background: #74b9ff;
  border-color: #74b9ff;
  color: white;
}

.footer {
  text-align: right;
  margin-top: 10px;
  font-size: 13px;
  color: #666;
}

.footer a {
  color: #2d9cdb;
  text-decoration: none;
  font-weight: bold;
}

.footer a:hover {
  text-decoration: underline;
}
</style>
