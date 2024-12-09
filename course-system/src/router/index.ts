import { createRouter, createWebHistory } from 'vue-router'
import CourseManagementSystem from '../components/CourseManagementSystem.vue'
import CourseGrades from '../components/CourseGrades.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: CourseManagementSystem
  },
  {
    path: '/grades',
    name: 'CourseGrades',
    component: CourseGrades
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router