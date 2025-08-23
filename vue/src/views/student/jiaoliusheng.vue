<!-- src/components/ExchangeStudentForm.vue -->
<template>
  <div class="form-container">
    <h1>学生交流生申请表</h1>

    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="name">姓名:</label>
        <input type="text" id="name" v-model="formData.name" required />
      </div>

      <div class="form-group">
        <label for="email">邮箱:</label>
        <input type="email" id="email" v-model="formData.email" required />
      </div>

      <div class="form-group">
        <label for="dob">出生日期:</label>
        <input type="date" id="dob" v-model="formData.dob" required />
      </div>

      <div class="form-group">
        <label for="university">目标交流大学:</label>
        <input type="text" id="university" v-model="formData.university" required />
      </div>

      <div class="form-group">
        <label for="studyProgram">选择学习项目:</label>
        <select id="studyProgram" v-model="formData.studyProgram" required>
          <option value="Science">科学</option>
          <option value="Arts">艺术</option>
          <option value="Business">商业</option>
          <option value="Engineering">工程</option>
        </select>
      </div>

      <div class="form-group">
        <label for="languageProficiency">语言能力:</label>
        <select id="languageProficiency" v-model="formData.languageProficiency" required>
          <option value="Beginner">初学者</option>
          <option value="Intermediate">中级</option>
          <option value="Advanced">高级</option>
        </select>
      </div>

      <div class="form-group">
        <label for="motivation">动机信:</label>
        <textarea id="motivation" v-model="formData.motivation" rows="4" required></textarea>
      </div>

      <div class="form-group">
        <label for="agreement">
          <input type="checkbox" id="agreement" v-model="formData.agreement" />
          我同意申请条款
        </label>
      </div>

      <button type="submit" :disabled="!formData.agreement">提交申请</button>
    </form>

    <div v-if="submitted" class="submission-message">
      <h3>您的申请已提交！</h3>
      <p>姓名: {{ formData.name }}</p>
      <p>邮箱: {{ formData.email }}</p>
      <p>出生日期: {{ formData.dob }}</p>
      <p>目标大学: {{ formData.university }}</p>
      <p>学习项目: {{ formData.studyProgram }}</p>
      <p>语言能力: {{ formData.languageProficiency }}</p>
      <p>动机信: {{ formData.motivation }}</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      formData: {
        name: '',
        email: '',
        dob: '',
        university: '',
        studyProgram: '',
        languageProficiency: '',
        motivation: '',
        agreement: false,
      },
      submitted: false,
    };
  },
  methods: {
    handleSubmit() {
      console.log('申请提交成功！');
      console.log(this.formData);  // 在控制台输出提交的表单数据

      this.submitted = true;  // 显示提交后的信息
    },
  },
};
</script>

<style scoped>
.form-container {
  max-width: 600px;
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

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input, select, textarea {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

textarea {
  resize: vertical;
}

button {
  width: 100%;
  padding: 10px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
}

button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}

.submission-message {
  margin-top: 20px;
  padding: 20px;
  border: 1px solid #4CAF50;
  border-radius: 5px;
  background-color: #e8f5e9;
}
</style>
