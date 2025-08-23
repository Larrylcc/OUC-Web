<template>
  <div>
    <el-card style="width: 50%">
      <el-form :model="user" label-width="100px" style="padding-right: 50px">
        <div style="margin: 15px; text-align: center">

          <img v-if="user.avatar" :src="user.avatar" class="avatar" />
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>

        </div>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="user.username" placeholder="用户名" ></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="user.name" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item label="学分" prop="xuefen">
          <el-input v-model="user.xuefen" ></el-input>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "StudentMassage",
  data() {
    return {
      user: JSON.parse(localStorage.getItem('xm-user') || '{}')
    }
  },
  created() {
    const userData = localStorage.getItem('xm-user');
    if (userData) {
      this.user = JSON.parse(userData);
    }
    console.log(this.user);  // 打印出 user 对象，查看数据是否正确
  }

}
</script>

<style scoped>
</style>