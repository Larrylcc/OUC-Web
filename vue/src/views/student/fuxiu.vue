<template>
  <div id="app">
    <h1 class="title">学生辅修申请表</h1>
    <form @submit.prevent="submitForm" class="form-container">
      <div class="form-group">
        <label for="studentId">学号</label>
        <input
            v-model="formData.studentId"
            type="text"
            id="studentId"
            required
        />
      </div>

      <div class="form-group">
        <label for="name">姓名</label>
        <input
            v-model="formData.name"
            type="text"
            id="name"
            required
        />
      </div>

      <div class="form-group">
        <label for="minor">辅修专业</label>
        <select v-model="formData.minor" id="minor" required>
          <option value="" disabled selected>请选择辅修专业</option>
          <option value="计算机科学与技术">计算机科学与技术</option>
          <option value="金融学">金融学</option>
          <option value="法律学">法律学</option>
          <option value="市场营销">市场营销</option>
        </select>
      </div>

      <div class="form-group">
        <label for="courses">选择课程（可多选）</label>
        <select
            v-model="formData.courses"
            id="courses"
            multiple
            required
        >
          <option value="编程基础">编程基础</option>
          <option value="数据结构">数据结构</option>
          <option value="宏观经济学">宏观经济学</option>
          <option value="财务管理">财务管理</option>
          <option value="宪法">宪法</option>
          <option value="民法">民法</option>
        </select>
      </div>

      <div class="form-group">
        <label for="statement">个人陈述</label>
        <textarea
            v-model="formData.statement"
            id="statement"
            rows="4"
            placeholder="请输入个人陈述"
            required
        ></textarea>
      </div>

      <div class="form-actions">
        <button type="submit">提交申请</button>
      </div>
    </form>

    <!-- 提交成功信息 -->
    <div v-if="isSubmitted" class="success-message">
      <h3>申请已成功提交！</h3>
      <p>学号：{{ formData.studentId }}</p>
      <p>姓名：{{ formData.name }}</p>
      <p>辅修专业：{{ formData.minor }}</p>
      <p>选择课程：{{ formData.courses.join(', ') }}</p>
      <p>个人陈述：{{ formData.statement }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      // 表单数据
      formData: {
        studentId: '',
        name: '',
        minor: '',
        courses: [],
        statement: '',
      },
      // 表单是否已提交
      isSubmitted: false,
    };
  },
  methods: {
    // 提交表单
    submitForm() {
      this.isSubmitted = true;
      // 在这里可以进行后端请求，或保存到本地存储等
      // 清空表单数据
      this.resetForm();
    },

    // 重置表单数据
    resetForm() {
      this.formData = {
        studentId: '',
        name: '',
        minor: '',
        courses: [],
        statement: '',
      };
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
}

/* 标题 */
.title {
  text-align: center;
  margin: 20px;
  color: #333;
}

/* 表单容器 */
.form-container {
  width: 50%;
  margin: 0 auto;
  padding: 20px;
  background-color: #fff;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
}

/* 表单项 */
.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 8px;
  font-weight: bold;
}

input,
select,
textarea {
  width: 100%;
  padding: 8px;
  font-size: 14px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

select {
  height: 36px;
}

textarea {
  resize: vertical;
}

/* 提交按钮 */
button {
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}

/* 提交成功信息 */
.success-message {
  margin-top: 30px;
  padding: 20px;
  background-color: #d4edda;
  color: #155724;
  border-radius: 8px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}
</style>
