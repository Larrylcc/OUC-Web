<!-- src/components/StudentDetails.vue -->
<template>
  <div class="student-container">
    <h1>交流生信息查看</h1>

    <div v-if="students.length === 0" class="no-students">
      <p>当前没有任何学生信息。</p>
    </div>

    <div v-else>
      <div class="student" v-for="(student, index) in students" :key="student.id">
        <div class="student-details">
          <h2>{{ student.name }} - {{ student.university }}</h2>
          <p><strong>邮箱:</strong> {{ student.email }}</p>
          <p><strong>出生日期:</strong> {{ student.dob }}</p>
          <p><strong>学习项目:</strong> {{ student.studyProgram }}</p>
          <p><strong>语言能力:</strong> {{ student.languageProficiency }}</p>
          <p><strong>动机信:</strong> {{ student.motivation }}</p>
          <p><strong>申请状态:</strong> {{ student.status || '未审核' }}</p>
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
      students: [
        {
          id: 1,
          name: "张三",
          email: "zhangsan@example.com",
          dob: "2000-05-15",
          university: "清华大学",
          studyProgram: "科学",
          languageProficiency: "高级",
          motivation: "我希望能够提升我的英语能力，并与世界各地的同学交流合作。",
          status: "通过", // 可以是“通过”或“拒绝”或null（未审核）
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
          status: "拒绝", // 可以是“通过”或“拒绝”或null（未审核）
        },
        // 你可以继续添加更多模拟的学生数据
      ],
    };
  },
};
</script>

<style scoped>
.student-container {
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

.student {
  padding: 15px;
  background-color: #f4f4f4;
  border-radius: 8px;
  margin-bottom: 20px;
}

.student-details {
  margin-bottom: 10px;
}

hr {
  border: 1px solid #ddd;
}

.no-students {
  text-align: center;
  padding: 20px;
  background-color: #fff;
  border-radius: 8px;
  border: 1px dashed #ddd;
}
</style>
