<template>
  <div id="app">
    <h1 class="title">管理员审核辅修申请</h1>

    <!-- 申请列表 -->
    <div v-if="applications.length > 0">
      <div v-for="(application, index) in applications" :key="application.studentId" class="application-card">
        <div class="application-details">
          <h2>学号: {{ application.studentId }}</h2>
          <p><strong>姓名:</strong> {{ application.name }}</p>
          <p><strong>辅修专业:</strong> {{ application.minor }}</p>
          <p><strong>选择课程:</strong> {{ application.courses.join(", ") }}</p>
          <p><strong>个人陈述:</strong> {{ application.statement }}</p>
        </div>

        <!-- 审核操作 -->
        <div class="actions">
          <button @click="approveApplication(index)" class="approve-btn">批准</button>
          <button @click="rejectApplication(index)" class="reject-btn">拒绝</button>
        </div>

        <!-- 审核结果 -->
        <div v-if="application.status" class="status">
          <p><strong>审核结果:</strong> {{ application.status }}</p>
        </div>
      </div>
    </div>

    <!-- 没有申请时的提示 -->
    <div v-else class="no-applications">
      <p>目前没有任何申请等待审核。</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      // 模拟的数据：所有提交的辅修申请
      applications: [
        {
          studentId: "20210001",
          name: "张三",
          minor: "计算机科学与技术",
          courses: ["编程基础", "数据结构"],
          statement: "我对编程非常感兴趣，希望通过辅修提高自己的技术能力。",
          status: null, // null表示未审核
        },
        {
          studentId: "20210002",
          name: "李四",
          minor: "金融学",
          courses: ["宏观经济学", "财务管理"],
          statement: "我有金融学的兴趣，计划未来从事金融相关的工作。",
          status: null,
        },
        {
          studentId: "20210003",
          name: "王五",
          minor: "法律学",
          courses: ["宪法", "民法"],
          statement: "我希望通过辅修法律学科，增加我的法律知识。",
          status: null,
        }
      ],
    };
  },
  methods: {
    // 审批通过
    approveApplication(index) {
      this.applications[index].status = '已批准';
    },

    // 审批拒绝
    rejectApplication(index) {
      this.applications[index].status = '已拒绝';
    },
  },
};
</script>

<style scoped>
/* 全局样式 */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: Arial, sans-serif;
  background-color: #f4f4f4;
  padding: 20px;
}

/* 标题 */
.title {
  text-align: center;
  margin-bottom: 30px;
  color: #333;
}

/* 申请卡片 */
.application-card {
  background-color: #fff;
  padding: 20px;
  margin-bottom: 20px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
}

.application-details {
  margin-bottom: 20px;
}

.application-details p {
  margin: 8px 0;
}

.actions {
  display: flex;
  justify-content: space-between;
}

button {
  padding: 10px;
  border: none;
  border-radius: 4px;
  font-size: 14px;
  cursor: pointer;
}

.approve-btn {
  background-color: #28a745;
  color: white;
}

.approve-btn:hover {
  background-color: #218838;
}

.reject-btn {
  background-color: #dc3545;
  color: white;
}

.reject-btn:hover {
  background-color: #c82333;
}

.status {
  margin-top: 10px;
  font-weight: bold;
}

.no-applications {
  text-align: center;
  font-size: 18px;
  color: #888;
}
</style>
