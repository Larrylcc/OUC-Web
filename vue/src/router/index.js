import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

// 解决导航栏或者底部导航tabBar中的vue-router在3.0版本以上频繁点击菜单报错的问题。
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

const routes = [
  {
    path: '/',
    name: 'Manager',
    component: () => import('../views/Manager.vue'),
    children: [
      { path: 'password', name: 'Password', meta: { name: '修改密码' }, component: () => import('../views/manager/Password') },
      { path: 'curriculum', name: 'Curriculum', meta: { name: '我的课表' }, component: () => import('../views/manager/Curriculum') },
      { path: 'pingjia', name: 'Comment', meta: { name: '网上评教' }, component: () => import('../views/manager/Comment') },
      { path: 'schoolNotice', name: 'schoolNotice', meta: { name: '教务通知' }, component: () => import('../views/manager/StudentNotice.vue') },
      { path: 'examNotice', name: 'examNotice', meta: { name: '考试通知' }, component: () => import('../views/manager/StudentExamNotice.vue') },
      { path: 'Calendar', name: 'Calendar', meta: { name: '校历' }, component: () => import('../views/manager/Calendar.vue') },
    ]
  },
  {
    path: '/student',
    name: 'Student',
    meta: { role: 'student' },
    component: () => import('../views/Manager.vue'),
    children: [
      { path: 'studentSystemHome', name: 'studentSystemHome', meta: { name: '学生主页' }, component: () => import('../views/student/SystemHomepage.vue') },
      { path: 'chooseClass', name: 'chooseClass', meta: { name: '选课中心' }, component: () => import('../views/student/ChooseClass.vue') },
      { path: 'StudentMassage', name: 'StudentMassage', meta: { name: '个人信息' }, component: () => import('../views/student/StudentMassage.vue') },
      { path: 'Choice', name: 'Choice', meta: { name: '选课中心' }, component: () => import('../views/student/Choice.vue') },
      { path: 'jiaoliusheng', name: 'jiaoliusheng', meta: { name: 'jiaoliusheng' }, component: () => import('../views/student/jiaoliusheng.vue') },
      { path: 'jingsaiguanli', name: 'jingsaiguanli', meta: { name: 'jingsaiguanli' }, component: () => import('../views/student/jingsaiguanli.vue') },
      { path: 'jiaoxuejihua', name: 'jiaoxuejihua', meta: { name: 'jiaoxuejihua' }, component: () => import('../views/student/jiaoxuejihua.vue') },
      { path: 'fuxiu', name: 'fuxiu', meta: { name: 'fuxiu' }, component: () => import('../views/student/fuxiu.vue') },
      { path: 'gerendangan', name: 'gerendangan', meta: { name: 'gerendangan' }, component: () => import('../views/student/gerendangan.vue') },

    ]
  },
  {
    path: '/admin',
    name: 'Admin',
    meta: { role: 'guanliyuan' },
    component: () => import('../views/Manager.vue'),
    children: [
      { path: 'SystemHomepage', name: 'SystemHomepage', meta: { name: '管理员主页' }, component: () => import('../views/admin/SystemHomepage.vue') },
      { path: 'Course', name: 'Course', meta: { name: '选课管理' }, component: () => import('../views/admin/Course.vue') },
      { path: 'Student', name: 'Student', meta: { name: '学生管理' }, component: () => import('../views/admin/Student.vue') },
      { path: 'Teacher', name: 'Teacher', meta: { name: '教师管理' }, component: () => import('../views/admin/Teacher.vue') },
      { path: 'Admin', name: 'Admin', meta: { name: '管理员管理' }, component: () => import('../views/admin/Admin.vue') },
      { path: 'AdminPerson', name: 'AdminPerson', meta: { name: '管理员信息' }, component: () => import('../views/admin/AdminPerson.vue') },
      { path: 'notice', name: 'notice', meta: { name: '发布通知' }, component: () => import('../views/admin/Notice.vue') },
      { path: 'examPlan', name: 'examPlan', meta: { name: '发布考试通知' }, component: () => import('../views/admin/ExamPlan.vue') },
      { path: 'roomPlan', name: 'roomPlan', meta: { name: '教授安排' }, component: () => import('../views/admin/RoomPlan.vue') },
      { path: 'college', name: 'college', meta: { name: '管理学院信息' }, component: () => import('../views/admin/College.vue') },
      { path: 'speciality', name: 'speciality', meta: { name: '管理专业信息' }, component: () => import('../views/admin/Speciality.vue') },
      { path: 'banji', name: 'banji', meta: { name: '管理班级信息' }, component: () => import('../views/admin/Classes.vue') },
      { path: 'jiaoliusheng', name: 'jiaoliusheng', meta: { name: 'jiaoliusheng' }, component: () => import('../views/admin/jiaoliusheng.vue') },
      { path: 'jingsaiguanli', name: 'jingsaiguanli', meta: { name: 'jingsaiguanli' }, component: () => import('../views/admin/jingsaiguanli.vue') },
      { path: 'fuxiu', name: 'fuxiu', meta: { name: 'fuxiu' }, component: () => import('../views/admin/fuxiu.vue') },

    ]
  },
  {
    path: '/teacher',
    name: 'Teacher',
    meta: { role: 'Teacher' },
    component: () => import('../views/Manager.vue'),
    children: [
      { path: 'SystemHomepage', name: 'SystemHomepage', meta: { name: '教师主页' }, component: () => import('../views/teacher/SystemHomepage.vue') },
      { path: 'Choice', name: 'Choice', meta: { name: '教授课程' }, component: () => import('../views/teacher/Choice.vue') },
      { path: 'MyStudent', name: 'MyStudent', meta: { name: '我的学生' }, component: () => import('../views/teacher/MyStudent.vue') },
      { path: 'Teacher', name: 'Teacher', meta: { name: '教师管理' }, component: () => import('../views/admin/Teacher.vue') },
      { path: 'Admin', name: 'Admin', meta: { name: '管理员管理' }, component: () => import('../views/admin/Admin.vue') },
      { path: 'TeacherPerson', name: 'TeacherPerson', meta: { name: '老师信息' }, component: () => import('../views/teacher/TeacherPerson.vue') },
      { path: 'college', name: 'college', meta: { name: '学院信息' }, component: () => import('../views/teacher/College.vue') },
      { path: 'speciality', name: 'speciality', meta: { name: '专业信息' }, component: () => import('../views/teacher/Speciality.vue') },
      { path: 'banji', name: 'banji', meta: { name: '班级信息' }, component: () => import('../views/teacher/Classes.vue') },
      { path: 'jiaoliusheng', name: 'jiaoliusheng', meta: { name: 'jiaoliusheng' }, component: () => import('../views/teacher/jiaoliusheng.vue') },
      { path: 'jingsaiguanli', name: 'jingsaiguanli', meta: { name: 'jingsaiguanli' }, component: () => import('../views/teacher/jingsaiguanli.vue') },
      { path: 'fuxiu', name: 'fuxiu', meta: { name: 'fuxiu' }, component: () => import('../views/teacher/fuxiu.vue') },

    ]
  },
  { path: '/login', name: 'Login', meta: { name: '登录' }, component: () => import('../views/Login.vue') },
  { path: '/register', name: 'Register', meta: { name: '注册' }, component: () => import('../views/Register.vue') },
  { path: '*', name: 'NotFound', meta: { name: '无法访问' }, component: () => import('../views/404.vue') },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


export default router
