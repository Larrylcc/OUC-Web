<template>
  <div class="flex flex-col h-screen bg-gray-100">
    <!-- Header -->
    <header class="bg-blue-600 text-white p-4 flex items-center justify-between">
      <div class="flex items-center space-x-4">
        <h1 class="text-xl font-bold">北京科技大学 | 本科教务管理系统</h1>
      </div>
      <div class="flex items-center space-x-4">
        <Bell class="h-5 w-5" />
        <Calendar class="h-5 w-5" />
        <span>2024-2025-1 第9周</span>
        <User class="h-5 w-5" />
        <span>姓名</span>
      </div>
    </header>

    <div class="flex flex-1">
      <!-- Sidebar -->
      <aside class="w-64 bg-white border-r">
        <div class="p-4">
          <div class="relative">
            <Search class="absolute left-3 top-2.5 h-5 w-5 text-gray-400" />
            <input
              type="text"
              placeholder="输入功能名称搜索"
              class="pl-10 pr-4 py-2 w-full rounded-lg border border-gray-200 focus:outline-none focus:border-blue-500"
            />
          </div>
        </div>

        <nav class="mt-2">
          <div
            v-for="(item, index) in menuItems"
            :key="index"
            class="flex items-center px-4 py-3 hover:bg-blue-50 cursor-pointer"
          >
            <span class="mr-3">{{ item.icon }}</span>
            <span>{{ item.label }}</span>
          </div>
        </nav>
      </aside>

      <!-- Main Content -->
      <main class="flex-1 p-6">
        <div class="bg-white rounded-lg shadow">
          <div class="p-4 border-b flex items-center justify-between">
            <div class="flex items-center space-x-4">
              <h2 class="font-semibold">我的课表</h2>
              <select class="border rounded px-2 py-1">
                <option>2024-2025-1</option>
              </select>
              <select class="border rounded px-2 py-1">
                <option>全部</option>
              </select>
            </div>
            <div class="flex space-x-2">
              <span class="px-2 py-1 bg-blue-100 text-blue-600 rounded">必修</span>
              <span class="px-2 py-1 bg-gray-100 text-gray-600 rounded">选修</span>
              <span class="px-2 py-1 bg-orange-100 text-orange-600 rounded">任选</span>
            </div>
          </div>

          <!-- Schedule Grid -->
          <div class="grid grid-cols-8 gap-px bg-gray-200">
            <div class="bg-white p-4 font-medium">节次</div>
            <div
              v-for="day in weekDays"
              :key="day"
              class="bg-white p-4 font-medium text-center"
            >
              {{ day }}
            </div>

            <template v-for="(item, index) in scheduleItems" :key="index">
              <div class="bg-white p-4">
                <div class="text-sm">
                  <div>{{ item.period }}</div>
                  <div class="text-gray-500">{{ item.time }}</div>
                  <div class="text-gray-500">{{ item.timeRange }}</div>
                </div>
              </div>
              <div
                v-for="i in 7"
                :key="i"
                class="bg-white p-4 min-h-[100px]"
              ></div>
            </template>
          </div>
        </div>
      </main>

      <!-- Right Sidebar -->
      <aside class="w-80 bg-white border-l p-4">
        <div class="mb-6">
          <h3 class="font-semibold mb-4">学业进展</h3>
          <div class="relative pt-1">
            <div class="flex mb-2 items-center justify-between">
              <div class="text-xs text-blue-600 font-semibold">
                课程得分: 65.5
              </div>
            </div>
            <div class="flex space-x-2">
              <div class="w-full bg-gray-200 rounded-full">
                <div class="w-[90%] bg-blue-600 h-2 rounded-full"></div>
              </div>
              <span class="text-sm">90.97%</span>
            </div>
          </div>
        </div>

        <div>
          <h3 class="font-semibold mb-4">通知</h3>
          <div class="flex space-x-4 border-b pb-2">
            <span class="text-blue-600">通知</span>
            <span class="text-gray-500">公告</span>
            <span class="text-gray-500">待办消息</span>
          </div>
        </div>
      </aside>
    </div>
  </div>
</template>

<script setup>
import { Search, Bell, User, Calendar } from 'lucide-vue-next'

const menuItems = [
  { icon: "📊", label: "我的课面" },
  { icon: "📘", label: "学籍成绩" },
  { icon: "🎓", label: "培养管理" },
  { icon: "📝", label: "考试报名" },
  { icon: "💡", label: "实践环节" },
  { icon: "⭐", label: "教学评价" },
  { icon: "🔄", label: "国内交流生" }
]

const weekDays = ['周一', '周二', '周三', '周四', '周五', '周六', '周日']

const scheduleItems = [
  { period: "第一大节", time: "(01/02小节)", timeRange: "08:00~09:45" },
  { period: "第二大节", time: "(03/04小节)", timeRange: "09:55~11:35" },
  { period: "第三大节", time: "(05/06小节)", timeRange: "13:30~15:05" },
  { period: "第四大节", time: "(07/08小节)", timeRange: "15:20~16:55" },
  { period: "第五大节", time: "(09/10小节)", timeRange: "17:10~18:45" }
]
</script>

<style scoped>
/* Add any component-specific styles here if needed */
</style>
