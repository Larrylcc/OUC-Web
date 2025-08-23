<template>
  <div id="app">
    <h1 class="title">学生辅修申请表</h1>
    <div class="container">
      <table class="application-table">
        <thead>
        <tr>
          <th>学号</th>
          <th>姓名</th>
          <th>辅修专业</th>
          <th>选择课程</th>
          <th>个人陈述</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(student, index) in students" :key="index">
          <td>{{ student.studentId }}</td>
          <td>{{ student.name }}</td>
          <td>{{ student.minor }}</td>
          <td>{{ student.courses.join(', ') }}</td>
          <td>{{ student.statement }}</td>
          <td><button @click="viewDetails(student)">查看详情</button></td>
        </tr>
        </tbody>
      </table>
    </div>

    <!-- 学生详情弹窗 -->
    <div v-if="isModalOpen" class="modal">
      <div class="modal-content">
        <span class="close" @click="closeModal">&times;</span>
        <h2>学生详情</h2>
        <p><strong>学号：</strong>{{ selectedStudent.studentId }}</p>
        <p><strong>姓名：</strong>{{ selectedStudent.name }}</p>
        <p><strong>辅修专业：</strong>{{ selectedStudent.minor }}</p>
        <p><strong>选择课程：</strong>{{ selectedStudent.courses.join(', ') }}</p>
        <p><strong>个人陈述：</strong>{{ selectedStudent.statement }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      // 模拟的学生申请数据
      students: [
        {
          studentId: '2021001',
          name: '张三',
          minor: '计算机科学与技术',
          courses: ['编程基础', '数据结构'],
          statement: '我对计算机有浓厚兴趣，希望通过辅修提升自己的编程能力。',
        },
        {
          studentId: '2021002',
          name: '李四',
          minor: '金融学',
          courses: ['宏观经济学', '财务管理'],
          statement: '希望通过辅修金融学提升自己在金融领域的专业能力。',
        },
        {
          studentId: '2021003',
          name: '王五',
          minor: '法律学',
          courses: ['宪法', '民法'],
          statement: '我有法律兴趣，希望未来能从事法律工作。',
        },
      ],
      // 选中的学生数据
      selectedStudent: null,
      // 控制弹窗的显示与隐藏
      isModalOpen: false,
    };
  },
  methods: {
    // 查看学生详细信息
    viewDetails(student) {
      this.selectedStudent = student;
      this.isModalOpen = true;
    },
    // 关闭弹窗
    closeModal() {
      this.isModalOpen = false;
      this.selectedStudent = null;
    },
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  font-family: Arial, sans-serif;
  background-color: #f7f7f7;
}

h1.title {
  text-align: center;
  margin: 20px;
  color: #333;
}

.container {
  width: 80%;
  margin: 0 auto;
}

.application-table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
  background-color: #fff;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.application-table th,
.application-table td {
  padding: 12px;
  border: 1px solid #ddd;
  text-align: left;
}

.application-table th {
  background-color: #f4f4f4;
}

.application-table tr:nth-child(even) {
  background-color: #f9f9f9;
}

button {
  background-color: #007bff;
  color: white;
  border: none;
  padding: 6px 12px;
  cursor: pointer;
  border-radius: 4px;
}

button:hover {
  background-color: #0056b3;
}

/* 弹窗样式 */
.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal-content {
  background-color: white;
  padding: 20px;
  border-radius: 8px;
  width: 400px;
  max-width: 90%;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.close {
  font-size: 30px;
  color: #aaa;
  position: absolute;
  top: 10px;
  right: 10px;
  cursor: pointer;
}

.close:hover {
  color: #000;
}
</style>
