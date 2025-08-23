<template>
  <div id="app">
    <h1 class="title">学生个人档案</h1>

    <!-- 学生个人信息 -->
    <div class="profile-card">
      <h2>个人信息</h2>
      <div class="profile-details">
        <p><strong>学号:</strong> {{ student.id }}</p>
        <p><strong>姓名:</strong>
          <span v-if="isEditing">
            <input v-model="student.name" type="text" />
          </span>
          <span v-else>{{ student.name }}</span>
        </p>
        <p><strong>性别:</strong>
          <span v-if="isEditing">
            <select v-model="student.gender">
              <option value="男">男</option>
              <option value="女">女</option>
            </select>
          </span>
          <span v-else>{{ student.gender }}</span>
        </p>
        <p><strong>出生日期:</strong>
          <span v-if="isEditing">
            <input v-model="student.birthdate" type="date" />
          </span>
          <span v-else>{{ student.birthdate }}</span>
        </p>
        <p><strong>联系方式:</strong>
          <span v-if="isEditing">
            <input v-model="student.contact" type="text" />
          </span>
          <span v-else>{{ student.contact }}</span>
        </p>
      </div>

      <div class="actions">
        <button v-if="isEditing" @click="saveProfile" class="save-btn">保存</button>
        <button v-else @click="toggleEdit" class="edit-btn">编辑</button>
      </div>
    </div>

    <!-- 成绩和课程 -->
    <div class="courses-section">
      <h2>成绩与课程</h2>
      <div class="courses-list">
        <div v-for="(course, index) in student.courses" :key="index" class="course-item">
          <p><strong>课程名:</strong> {{ course.name }}</p>
          <p><strong>成绩:</strong>
            <span v-if="isEditing">
              <input v-model="course.grade" type="text" />
            </span>
            <span v-else>{{ course.grade }}</span>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      // 学生个人信息
      isEditing: false,  // 编辑模式
      student: {
        id: '20230001',
        name: '李雷',
        gender: '男',
        birthdate: '2000-01-01',
        contact: '13800138000',
        courses: [
          { name: '数学', grade: 'A' },
          { name: '英语', grade: 'B' },
          { name: '编程', grade: 'A+' },
        ],
      },
    };
  },
  methods: {
    // 切换编辑模式
    toggleEdit() {
      this.isEditing = !this.isEditing;
    },
    // 保存编辑后的个人信息
    saveProfile() {
      this.isEditing = false;
      alert('个人信息已保存');
    },
  },
};
</script>

<style scoped>
/* 页面布局 */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: Arial, sans-serif;
  background-color: #f5f5f5;
  padding: 20px;
}

.title {
  text-align: center;
  color: #333;
  margin-bottom: 40px;
}

/* 学生个人信息卡片 */
.profile-card {
  background-color: white;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  margin-bottom: 40px;
}

.profile-details p {
  margin: 10px 0;
}

.actions {
  display: flex;
  justify-content: flex-start;
  gap: 15px;
}

button {
  padding: 10px;
  border: none;
  border-radius: 4px;
  font-size: 14px;
  cursor: pointer;
}

.edit-btn {
  background-color: #007bff;
  color: white;
}

.edit-btn:hover {
  background-color: #0056b3;
}

.save-btn {
  background-color: #28a745;
  color: white;
}

.save-btn:hover {
  background-color: #218838;
}

/* 课程与成绩 */
.courses-section {
  background-color: white;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.courses-list .course-item {
  margin-bottom: 20px;
}

.courses-list p {
  margin: 5px 0;
}

input, select {
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

input[type="date"] {
  padding: 6px;
}

input[type="text"] {
  width: 150px;
}
</style>
fuxiu.vue