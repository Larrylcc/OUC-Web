<!-- src/components/CompetitionRegistration.vue -->
<template>
  <div class="registration-container">
    <h1>学生竞赛报名</h1>

    <form @submit.prevent="submitForm" class="registration-form">
      <div class="form-group">
        <label for="studentName">学生姓名</label>
        <input
            v-model="form.studentName"
            type="text"
            id="studentName"
            placeholder="请输入姓名"
            required
        />
      </div>

      <div class="form-group">
        <label for="studentId">学号</label>
        <input
            v-model="form.studentId"
            type="text"
            id="studentId"
            placeholder="请输入学号"
            required
        />
      </div>

      <div class="form-group">
        <label for="college">学院</label>
        <input
            v-model="form.college"
            type="text"
            id="college"
            placeholder="请输入学院名称"
            required
        />
      </div>

      <div class="form-group">
        <label for="competition">选择竞赛</label>
        <select v-model="form.competition" id="competition" required>
          <option value="">请选择竞赛</option>
          <option value="programming">编程竞赛</option>
          <option value="robotics">机器人竞赛</option>
          <option value="mathematics">数学建模</option>
          <option value="english">英语竞赛</option>
          <option value="innovation">创新创业大赛</option>
        </select>
      </div>

      <div class="form-group">
        <label for="teamMember">是否有团队成员</label>
        <input
            type="checkbox"
            id="hasTeam"
            v-model="form.hasTeam"
        />
        <span v-if="form.hasTeam">请输入团队成员信息</span>
      </div>

      <div v-if="form.hasTeam" class="form-group">
        <label for="teamMemberNames">团队成员姓名（若有）</label>
        <textarea
            v-model="form.teamMemberNames"
            id="teamMemberNames"
            placeholder="请输入团队成员姓名，用逗号分隔"
        ></textarea>
      </div>

      <div class="form-group">
        <label for="contactNumber">联系电话</label>
        <input
            v-model="form.contactNumber"
            type="tel"
            id="contactNumber"
            placeholder="请输入联系电话"
            required
        />
      </div>

      <div class="form-group">
        <label for="email">电子邮箱</label>
        <input
            v-model="form.email"
            type="email"
            id="email"
            placeholder="请输入电子邮箱"
            required
        />
      </div>

      <button type="submit" class="submit-btn">提交报名</button>
    </form>

    <div v-if="submissionStatus" class="submission-status">
      <p>{{ submissionStatus }}</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        studentName: "",
        studentId: "",
        college: "",
        competition: "",
        hasTeam: false,
        teamMemberNames: "",
        contactNumber: "",
        email: "",
      },
      submissionStatus: "",
    };
  },
  methods: {
    submitForm() {
      // 这里可以添加表单验证逻辑，如果数据完整则模拟提交
      if (this.validateForm()) {
        this.submissionStatus = "报名成功！我们将在收到您的信息后与您联系。";
        // 这里可以将表单数据发送到服务器，实际项目中应该是通过 API 提交数据
        console.log("提交的报名信息:", this.form);
        this.resetForm();  // 重置表单
      } else {
        this.submissionStatus = "请填写完整的报名信息。";
      }
    },
    validateForm() {
      return (
          this.form.studentName &&
          this.form.studentId &&
          this.form.college &&
          this.form.competition &&
          this.form.contactNumber &&
          this.form.email
      );
    },
    resetForm() {
      // 清空表单数据
      this.form = {
        studentName: "",
        studentId: "",
        college: "",
        competition: "",
        hasTeam: false,
        teamMemberNames: "",
        contactNumber: "",
        email: "",
      };
    },
  },
};
</script>

<style scoped>
.registration-container {
  width: 80%;
  margin: 0 auto;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

h1 {
  text-align: center;
  font-size: 24px;
  margin-bottom: 20px;
}

.registration-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 20px;
}

label {
  font-size: 16px;
  margin-bottom: 8px;
  display: block;
}

input,
select,
textarea {
  width: 100%;
  padding: 10px;
  font-size: 14px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

textarea {
  height: 100px;
}

button.submit-btn {
  padding: 12px 20px;
  font-size: 16px;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button.submit-btn:hover {
  background-color: #45a049;
}

.submission-status {
  margin-top: 20px;
  text-align: center;
  font-size: 18px;
  font-weight: bold;
}
</style>
