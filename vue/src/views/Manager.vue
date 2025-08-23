<template>
  <div class="manager-container">
    <!-- 头部 -->
    <div class="manager-header">
      <div class="manager-header-left">
        <img src="@/assets/imgs/logo.png" alt="Logo" />
        <div class="title">教务管理系统</div>
      </div>

      <div class="manager-header-center">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: $route.path }">{{ $route.meta.name }}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>

      <div class="manager-header-right">
        <el-dropdown placement="bottom">
          <div class="avatar">
            <img :src="user.avatar || 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'" />
            <div>{{ user.name || '管理员' }}</div>
          </div>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="$router.push('/password')">
              <i class="el-icon-lock"></i> 修改密码
            </el-dropdown-item>
            <el-dropdown-item @click.native="logout">
              <i class="el-icon-switch-button"></i> 退出登录
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>

    <!-- 主体 -->
    <div class="manager-main">
      <!-- 侧边栏 -->
      <div class="manager-main-left">
        <el-menu router style="border: none" :default-active="$route.path" class="menu">
          <el-menu-item index="/student/studentSystemHome" v-if="user.role === 'XUESHENG'">
            <i class="el-icon-s-home"></i>
            <span slot="title">学生首页</span>
          </el-menu-item>
          <el-menu-item index="/teacher/SystemHomepage" v-if="user.role === 'LAOSHI'">
            <i class="el-icon-s-home"></i>
            <span slot="title">教师首页</span>
          </el-menu-item>
          <el-menu-item index="/admin/SystemHomepage" v-if="user.role === 'GUANLIYUAN'">
            <i class="el-icon-s-home"></i>
            <span slot="title">管理员首页</span>
          </el-menu-item>
          <el-menu-item index="/Calendar" >
            <i class="el-icon-s-home"></i>
            <span slot="title">校历</span>
          </el-menu-item>
          <el-menu-item index="/student/StudentMassage" v-if="user.role === 'XUESHENG'">
            <i class="el-icon-chat-line-round"></i> 个人信息
          </el-menu-item>
          <el-menu-item index="/Admin/AdminPerson" v-if="user.role === 'GUANLIYUAN'">
            <i class="el-icon-chat-line-round"></i> 个人信息
          </el-menu-item>
          <el-menu-item index="/teacher/TeacherPerson" v-if="user.role === 'LAOSHI'">
            <i class="el-icon-chat-line-round"></i> 个人信息
          </el-menu-item>
          <el-submenu index="info">
            <template slot="title">
              <i class="el-icon-notebook-1"></i><span>信息公告</span>
            </template>
            <el-menu-item index="/admin/notice" v-if="user.role === 'GUANLIYUAN'">
              <i class="el-icon-document"></i> 发布教务通知
            </el-menu-item>
            <el-menu-item index="/admin/examPlan" v-if="user.role === 'GUANLIYUAN'">
              <i class="el-icon-date"></i> 发布考试安排
            </el-menu-item>
            <el-menu-item index="/admin/roomPlan">
              <i class="el-icon-office-building"></i> 教室安排
            </el-menu-item>
            <el-menu-item index="/schoolNotice" v-if="user.role === 'XUESHENG' || user.role === 'LAOSHI'">
              <i class="el-icon-document"></i> 教务通知
            </el-menu-item>
            <el-menu-item index="/examNotice" v-if="user.role === 'XUESHENG' || user.role === 'LAOSHI'">
              <i class="el-icon-document"></i> 考试通知
            </el-menu-item>
          </el-submenu>
          <el-submenu index="administration">
            <template slot="title">
              <i class="el-icon-notebook-1"></i><span>学院专业班级信息</span>
            </template>
            <el-menu-item index="/admin/college" v-if="user.role === 'GUANLIYUAN'">
              <i class="el-icon-school"></i> 管理学院信息
            </el-menu-item>
            <el-menu-item index="/admin/speciality" v-if="user.role === 'GUANLIYUAN'">
              <i class="el-icon-s-flag"></i> 管理专业信息
            </el-menu-item>
            <el-menu-item index="/admin/banji" v-if="user.role === 'GUANLIYUAN'">
              <i class="el-icon-s-grid"></i> 管理班级信息
            </el-menu-item>
            <el-menu-item index="/teacher/college" v-if="user.role === 'XUESHENG' || user.role === 'LAOSHI'">
              <i class="el-icon-school"></i> 学院信息
            </el-menu-item>
            <el-menu-item index="/teacher/speciality" v-if="user.role === 'XUESHENG' || user.role === 'LAOSHI'">
              <i class="el-icon-s-flag"></i> 专业信息
            </el-menu-item>
            <el-menu-item index="/teacher/banji" v-if="user.role === 'XUESHENG' || user.role === 'LAOSHI'">
              <i class="el-icon-s-grid"></i> 班级信息
            </el-menu-item>
          </el-submenu>
          <el-submenu index="teach">
            <template slot="title">
              <i class="el-icon-s-operation"></i><span>教学管理</span>
            </template>
            <el-menu-item index="/admin/Course" v-if="user.role === 'GUANLIYUAN'">
              <i class="el-icon-reading"></i> 选课管理
            </el-menu-item>
            <el-menu-item index="/student/chooseClass" v-if="user.role === 'XUESHENG'">
              <i class="el-icon-reading"></i> 选课中心
            </el-menu-item>
            <el-menu-item index="/student/Choice" v-if="user.role === 'XUESHENG'">
              <i class="el-icon-notebook-2"></i> 我的选课
            </el-menu-item>
            <el-menu-item index="/teacher/Choice" v-if="user.role === 'LAOSHI'">
              <i class="el-icon-notebook-2"></i> 教授课程
            </el-menu-item>
            <el-menu-item index="/teacher/MyStudent" v-if="user.role === 'LAOSHI'">
              <i class="el-icon-notebook-2"></i> 我的学生
            </el-menu-item>
            <el-menu-item index="/curriculum" v-if="user.role === 'XUESHENG'">
              <i class="el-icon-tickets"></i> 我的课表
            </el-menu-item>
            <el-menu-item index="/pingjia" v-if="user.role !== 'XUESHENG'">
              <i class="el-icon-chat-line-round"></i> 查看网上评教
            </el-menu-item>
            <el-menu-item index="/student/jiaoxuejihua" v-if="user.role === 'XUESHENG'">
              <i class="el-icon-notebook-2"></i> 教学计划
            </el-menu-item>
            <el-menu-item index="/student/fuxiu" v-if="user.role === 'XUESHENG'">
              <i class="el-icon-notebook-2"></i> 辅修申请
            </el-menu-item>
            <el-menu-item index="/teacher/fuxiu" v-if="user.role === 'LAOSHI'">
              <i class="el-icon-tickets"></i> 辅修查看
            </el-menu-item>
            <el-menu-item index="/admin/fuxiu" v-if="user.role === 'GUANLIYUAN'">
              <i class="el-icon-notebook-2"></i> 辅修管理
            </el-menu-item>
            <el-menu-item index="/student/gerendangan" v-if="user.role === 'XUESHENG'">
              <i class="el-icon-notebook-2"></i> 个人档案
            </el-menu-item>
          </el-submenu>
          <el-submenu index="user" v-if="user.role === 'GUANLIYUAN'">
            <template slot="title">
              <i class="el-icon-user-solid"></i><span>用户管理</span>
            </template>
            <el-menu-item index="/admin/Admin">
              <i class="el-icon-s-custom"></i> 管理员信息
            </el-menu-item>
            <el-menu-item index="/admin/Teacher">
              <i class="el-icon-s-cooperation"></i> 教师信息
            </el-menu-item>
            <el-menu-item index="/admin/Student">
              <i class="el-icon-s-check"></i> 学生信息
            </el-menu-item>
          </el-submenu>
          <el-submenu index="jiaoliusheng" >
            <template slot="title">
              <i class="el-icon-user-solid"></i><span>交流生管理</span>
            </template>
            <el-menu-item index="/admin/jiaoliusheng" v-if="user.role === 'GUANLIYUAN'">
              <i class="el-icon-s-custom"></i> 交流生审核
            </el-menu-item>
            <el-menu-item index="/teacher/jiaoliusheng" v-if="user.role === 'LAOSHI'">
              <i class="el-icon-s-cooperation"></i> 交流生查看
            </el-menu-item>
            <el-menu-item index="/student/jiaoliusheng" v-if="user.role === 'XUESHENG'">
              <i class="el-icon-s-check"></i> 交流生报名
            </el-menu-item>
          </el-submenu>
          <el-submenu index="jingsaiguanli" >
            <template slot="title">
              <i class="el-icon-user-solid"></i><span>竞赛管理</span>
            </template>
            <el-menu-item index="/admin/jingsaiguanli" v-if="user.role === 'GUANLIYUAN'">
              <i class="el-icon-s-custom"></i> 竞赛审核
            </el-menu-item>
            <el-menu-item index="/teacher/jingsaiguanli" v-if="user.role === 'LAOSHI'">
              <i class="el-icon-s-cooperation"></i> 竞赛查看
            </el-menu-item>
            <el-menu-item index="/student/jingsaiguanli" v-if="user.role === 'XUESHENG'">
              <i class="el-icon-s-check"></i> 竞赛报名
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </div>

      <!-- 数据表格 -->
      <div class="manager-main-right">
        <router-view @update:user="updateUser" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Manager",
  data() {
    return {
      user: JSON.parse(localStorage.getItem("xm-user") || "{}"),
    };
  },
  created() {
    if (!this.user.id) {
      this.$router.push("/login");
    }
  },
  methods: {
    logout() {
      localStorage.removeItem("xm-user");
      this.$router.push("/login");
    },
    updateUser(updatedUser) {
      this.user = updatedUser;
    }
  }
};
</script>

<style scoped>
.manager-container {
  display: flex;
  flex-direction: column;
  height: 100%;
}

.manager-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px;
  background-color: #3c8dbc;
  color: white;
}

.manager-header-left {
  display: flex;
  align-items: center;
}

.manager-header-left img {
  height: 40px;
  margin-right: 10px;
}

.manager-header-center {
  flex-grow: 1;
}

.manager-header-right .avatar {
  display: flex;
  align-items: center;
}

.manager-header-right .avatar img {
  height: 30px;
  border-radius: 50%;
  margin-right: 10px;
}

.manager-main {
  display: flex;
  flex-grow: 1;
}

.manager-main-left {
  width: 220px;
  background-color: #f4f4f4;
  border-right: 1px solid #ddd;
}

.manager-main-left .menu {
  padding: 0;
}

.manager-main-right {
  flex-grow: 1;
  padding: 20px;
}

.manager-main-left .el-menu {
  height: 100%;
  padding-top: 20px;
}

.manager-main-left .el-menu-item,
.manager-main-left .el-submenu {
  font-size: 16px;
}

.manager-main-left .el-menu-item i {
  margin-right: 10px;
}

.manager-main-left .el-submenu .el-menu-item i {
  margin-left: 20px;
}

.manager-main-left .el-submenu > .el-menu-item {
  padding-left: 10px;
}

.manager-main-left .el-menu-item.active {
  background-color: #409eff;
  color: white;
}

.manager-main-left .el-submenu.is-opened > .el-menu-item {
  background-color: #409eff;
  color: white;
}

.manager-main-right .el-breadcrumb {
  margin-bottom: 20px;
}

.manager-main-left .el-menu .el-dropdown-menu {
  min-width: 180px;
}
</style>
