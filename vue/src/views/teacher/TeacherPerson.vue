<template>
  <div class="form-container">
    <el-card class="user-card" :body-style="{ padding: '20px' }">
      <el-form :model="user" label-width="100px" class="user-form" ref="form" :rules="rules">
        <div class="avatar-section">
          <el-upload
              class="avatar-uploader"
              :action="$baseUrl + '/files/upload'"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload"
          >
            <img v-if="user.avatar" :src="user.avatar" class="avatar" />
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </div>

        <el-form-item label="用户名" prop="username">
          <el-input v-model="user.username" placeholder="请输入用户名" ></el-input>
        </el-form-item>

        <el-form-item label="姓名" prop="name">
          <el-input v-model="user.name" placeholder="请输入姓名"></el-input>
        </el-form-item>

        <el-form-item label="电话" prop="phone">
          <el-input v-model="user.phone" placeholder="请输入电话" ></el-input>
        </el-form-item>

        <el-form-item label="邮箱" prop="email">
          <el-input v-model="user.email" placeholder="请输入邮箱" ></el-input>
        </el-form-item>

        <el-form-item label="职称" prop="title">
          <el-input v-model="user.title" placeholder="请输入职称"></el-input>
        </el-form-item>

      </el-form>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "TeacherPerson",
  data() {
    return {
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
    };
  },
  methods: {
    handleAvatarSuccess(response, file) {
      this.user.avatar = URL.createObjectURL(file.raw);
      // You can also update avatar in the backend if needed
    },
    beforeAvatarUpload(file) {
      const isImage = file.type.startsWith('image/');
      if (!isImage) {
        this.$message.error('上传头像只能是图片格式!');
      }
      return isImage;
    },
    submitForm() {
      this.$refs.form.validate(valid => {
        if (valid) {
          // Submit the form data to backend
          console.log("Form Submitted", this.user);
        } else {
          console.log('error submit!');
          return false;
        }
      });
    }
  },
};
</script>

<style scoped>
.form-container {
  display: flex;
  justify-neirong: center;
  padding: 30px;
}

.user-card {
  width: 60%;
  max-width: 800px;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.user-form {
  padding: 10px;
}

.avatar-section {
  text-align: center;
  margin-bottom: 20px;
}

.avatar-uploader {
  display: inline-block;
  cursor: pointer;
  border-radius: 50%;
  overflow: hidden;
  width: 120px;
  height: 120px;
  line-height: 120px;
  background-color: #f0f2f5;
}

.avatar {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 50%;
}

.avatar-uploader-icon {
  font-size: 40px;
  color: #bdbdbd;
}

.form-footer {
  display: flex;
  justify-neirong: flex-end;
  margin-top: 20px;
}

@media (max-width: 768px) {
  .user-card {
    width: 90%;
  }
}
</style>
