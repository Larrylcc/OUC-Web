<template>
  <div>
    <el-card style="width: 50%">
      <el-form :model="user" label-width="100px" style="padding-right: 50px">
        <div style="margin: 15px; text-align: center">
          <el-upload
              class="avatar-uploader"
              :action="$baseUrl + '/files/upload'"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
          >
            <img v-if="user.avatar" :src="user.avatar" class="avatar" />
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </div>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="user.username" placeholder="用户名" ></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="user.name" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item label="学院" prop="collegeName">
          <el-input v-model="user.collegeName" placeholder="电话"></el-input>
        </el-form-item>
        <el-form-item label="专业" prop="specialitymingcheng">
          <el-input v-model="user.specialitymingcheng" placeholder="邮箱"></el-input>
        </el-form-item>
        <el-form-item label="班级" prop="className">
          <el-input v-model="user.className" ></el-input>
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
      user: JSON.parse(localStorage.getItem('xm-user') || '{}')
    }
  },
  created() {

  },

}
</script>

<style scoped>
</style>