<template>
  <div class="container">
    <div class="register-card">
      <div class="title">欢迎注册</div>
      <el-form :model="form" :rules="rules" ref="formRef">
        <el-form-item prop="username">
          <el-input prefix-icon="el-icon-user" placeholder="请输入账号" v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input prefix-icon="el-icon-lock" placeholder="请输入密码" show-password v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item prop="confirmPass">
          <el-input prefix-icon="el-icon-lock" placeholder="请确认密码" show-password v-model="form.confirmPass"></el-input>
        </el-form-item>
        <el-form-item >
          <el-radio-group v-model="form.role">
            <el-radio label="GUANLIYUAN">管理员</el-radio>
            <el-radio label="LAOSHI">教师</el-radio>
            <el-radio label="XUESHENG" >学生</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item>
          <el-button
              class="register-btn"
              style="width: 100%"
              @click="register"
          >
            注 册
          </el-button>
        </el-form-item>
        <div class="footer">
          已有账号？请 <a href="/login">登录</a>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Register",
  data() {
    // 验证确认密码是否一致
    const validatePassword = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请确认密码"));
      } else if (value !== this.form.password) {
        callback(new Error("两次输入的密码不一致"));
      } else {
        callback();
      }
    };
    return {
      form: {
        username: "",
        password: "",
        confirmPass: "",
        role: "XUESHENG", // 默认角色为学生
      },
      rules: {
        username: [{ required: true, message: "请输入账号", trigger: "blur" }],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
        confirmPass: [{ validator: validatePassword, trigger: "blur" }],
      },
    };
  },
  methods: {
    register() {
      this.$refs["formRef"].validate((valid) => {
        if (valid) {
          this.$request.post("/register", this.form).then((res) => {
            if (res.code === "200") {
              this.$router.push("/login"); // 跳转到登录页面
              this.$message.success("注册成功");
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

.register-card {
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

.register-btn {
  background: #0984e3;
  border-color: #0984e3;
  color: white;
  transition: all 0.3s;
}

.register-btn:hover {
  background: #74b9ff;
  border-color: #74b9ff;
  color: white;
}

.footer {
  text-align: center;
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
