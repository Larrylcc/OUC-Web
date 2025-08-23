<!-- src/components/AdminReviewForm.vue -->
<template>
  <div class="admin-container">
    <h1>交换生申请审核</h1>

    <div v-if="applications.length === 0" class="no-applications">
      <p>当前没有待审核的申请。</p>
    </div>

    <div v-else>
      <div class="application" v-for="(application, index) in applications" :key="application.id">
        <div class="application-details">
          <h2>{{ application.name }} - {{ application.university }}</h2>
          <p><strong>邮箱:</strong> {{ application.email }}</p>
          <p><strong>出生日期:</strong> {{ application.dob }}</p>
          <p><strong>学习项目:</strong> {{ application.studyProgram }}</p>
          <p><strong>语言能力:</strong> {{ application.languageProficiency }}</p>
          <p><strong>动机信:</strong> {{ application.motivation }}</p>
        </div>

        <div class="application-actions">
          <button @click="approveApplication(application.id, index)" class="approve-btn">通过申请</button>
          <button @click="rejectApplication(application.id, index)" class="reject-btn">拒绝申请</button>
        </div>

        <div v-if="application.status" class="status-message">
          <p><strong>审核结果:</strong> {{ application.status }}</p>
        </div>

        <hr />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      applications: [
        {
          id: 1,
          name: "张三",
          email: "zhangsan@example.com",
          dob: "2000-05-15",
          university: "清华大学",
          studyProgram: "科学",
          languageProficiency: "高级",
          motivation: "我希望能够提升我的英语能力，并与世界各地的同学交流合作。",
          status: null, // null表示未审核
        },
        {
          id: 2,
          name: "李四",
          email: "lisi@example.com",
          dob: "1999-09-22",
          university: "北京大学",
          studyProgram: "商业",
          languageProficiency: "中级",
          motivation: "我想学习更多关于商业管理的知识，提升自己在国际舞台上的竞争力。",
          status: null,
        },
        // 你可以继续添加更多模拟的申请数据
      ],
    };
  },
  methods: {
    approveApplication(applicationId, index) {
      // 更新申请状态为“通过”
      this.applications[index].status = "通过";
      console.log(`申请ID ${applicationId} 通过`);
    },
    rejectApplication(applicationId, index) {
      // 更新申请状态为“拒绝”
      this.applications[index].status = "拒绝";
      console.log(`申请ID ${applicationId} 被拒绝`);
    },
  },
};
</script>

<style scoped>
.admin-container {
  max-width: 800px;
  margin: 20px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
  background-color: #f9f9f9;
}

h1 {
  text-align: center;
  margin-bottom: 20px;
}

.application {
  padding: 15px;
  background-color: #f4f4f4;
  border-radius: 8px;
  margin-bottom: 20px;
}

.application-details {
  margin-bottom: 10px;
}

.application-actions {
  margin-top: 10px;
}

button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
  margin-right: 10px;
}

.approve-btn {
  background-color: #4CAF50;
  color: white;
}

.reject-btn {
  background-color: #f44336;
  color: white;
}

button:hover {
  opacity: 0.9;
}

.status-message {
  margin-top: 10px;
  padding: 10px;
  background-color: #e8f5e9;
  border: 1px solid #4CAF50;
  border-radius: 5px;
}

hr {
  border: 1px solid #ddd;
}

.no-applications {
  text-align: center;
  padding: 20px;
  background-color: #fff;
  border-radius: 8px;
  border: 1px dashed #ddd;
}
</style>
