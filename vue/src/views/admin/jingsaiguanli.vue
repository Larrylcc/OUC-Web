<!-- src/components/CompetitionQualificationReview.vue -->
<template>
  <div class="qualification-review-container">
    <h1>竞赛资格审核</h1>

    <div class="search-bar">
      <input
          type="text"
          v-model="searchKeyword"
          placeholder="搜索报名人员"
          @input="searchApplicants"
      />
    </div>

    <table class="applicant-table">
      <thead>
      <tr>
        <th>姓名</th>
        <th>报名编号</th>
        <th>参赛项目</th>
        <th>报名日期</th>
        <th>资格状态</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="applicant in filteredApplicants" :key="applicant.id">
        <td>{{ applicant.name }}</td>
        <td>{{ applicant.registrationId }}</td>
        <td>{{ applicant.competitionType }}</td>
        <td>{{ formatDate(applicant.registrationDate) }}</td>
        <td>
            <span :class="getQualificationStatusClass(applicant.status)">
              {{ applicant.status }}
            </span>
        </td>
        <td>
          <button @click="approveQualification(applicant.id)" :disabled="applicant.status !== '待审核'">
            通过
          </button>
          <button @click="rejectQualification(applicant.id)" :disabled="applicant.status !== '待审核'">
            拒绝
          </button>
        </td>
      </tr>
      </tbody>
    </table>

    <div class="pagination">
      <button @click="goToPreviousPage" :disabled="currentPage === 1">上一页</button>
      <span>{{ currentPage }} / {{ totalPages }}</span>
      <button @click="goToNextPage" :disabled="currentPage === totalPages">下一页</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      applicants: [
        { id: 1, name: "张三", registrationId: "A001", competitionType: "编程", registrationDate: "2025-01-10", status: "待审核" },
        { id: 2, name: "李四", registrationId: "A002", competitionType: "机器人", registrationDate: "2025-01-12", status: "待审核" },
        { id: 3, name: "王五", registrationId: "A003", competitionType: "数学建模", registrationDate: "2025-01-15", status: "已通过" },
        { id: 4, name: "赵六", registrationId: "A004", competitionType: "编程", registrationDate: "2025-01-17", status: "已拒绝" },
        { id: 5, name: "孙七", registrationId: "A005", competitionType: "英语", registrationDate: "2025-01-18", status: "待审核" },
        { id: 6, name: "周八", registrationId: "A006", competitionType: "创新创业", registrationDate: "2025-01-20", status: "待审核" },
      ],
      searchKeyword: "",
      currentPage: 1,
      itemsPerPage: 5,
    };
  },
  computed: {
    totalPages() {
      return Math.ceil(this.filteredApplicants.length / this.itemsPerPage);
    },
    filteredApplicants() {
      let filtered = this.applicants.filter(applicant =>
          applicant.name.toLowerCase().includes(this.searchKeyword.toLowerCase())
      );
      const start = (this.currentPage - 1) * this.itemsPerPage;
      const end = start + this.itemsPerPage;
      return filtered.slice(start, end);
    },
  },
  methods: {
    formatDate(date) {
      return new Date(date).toLocaleDateString();
    },
    getQualificationStatusClass(status) {
      if (status === "待审核") return "status-pending";
      if (status === "已通过") return "status-approved";
      if (status === "已拒绝") return "status-rejected";
      return "";
    },
    approveQualification(id) {
      const applicant = this.applicants.find(a => a.id === id);
      if (applicant) {
        applicant.status = "已通过";
      }
    },
    rejectQualification(id) {
      const applicant = this.applicants.find(a => a.id === id);
      if (applicant) {
        applicant.status = "已拒绝";
      }
    },
    searchApplicants() {
      this.currentPage = 1; // 重置为第一页
    },
    goToPreviousPage() {
      if (this.currentPage > 1) this.currentPage--;
    },
    goToNextPage() {
      if (this.currentPage < this.totalPages) this.currentPage++;
    },
  },
};
</script>

<style scoped>
.qualification-review-container {
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

.search-bar {
  text-align: center;
  margin-bottom: 20px;
}

.search-bar input {
  padding: 8px;
  font-size: 14px;
  width: 80%;
  max-width: 300px;
}

.applicant-table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

.applicant-table th,
.applicant-table td {
  padding: 10px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

.applicant-table th {
  background-color: #4caf50;
  color: white;
}

button {
  padding: 6px 12px;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-right: 10px;
}

button:hover {
  background-color: #45a049;
}

.pagination {
  text-align: center;
  margin-top: 20px;
}

.pagination button {
  margin: 0 10px;
}

.status-pending {
  color: orange;
}

.status-approved {
  color: green;
}

.status-rejected {
  color: red;
}
</style>
