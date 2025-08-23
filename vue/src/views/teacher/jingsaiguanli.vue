<!-- src/components/CompetitionList.vue -->
<template>
  <div class="competition-list-container">
    <h1>竞赛查看</h1>

    <div class="filters">
      <label for="searchKeyword">搜索竞赛：</label>
      <input
          type="text"
          v-model="searchKeyword"
          placeholder="搜索竞赛名称"
          @input="searchCompetition"
      />
    </div>

    <table class="competition-table">
      <thead>
      <tr>
        <th>竞赛名称</th>
        <th>竞赛类型</th>
        <th>报名截止日期</th>
        <th>状态</th>
        <th>查看详情</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="competition in filteredCompetitions" :key="competition.id">
        <td>{{ competition.name }}</td>
        <td>{{ competition.type }}</td>
        <td>{{ formatDate(competition.deadline) }}</td>
        <td>
            <span :class="getStatusClass(competition.status)">
              {{ competition.status }}
            </span>
        </td>
        <td>
          <button @click="viewDetails(competition.id)">查看详情</button>
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
      competitions: [
        { id: 1, name: "编程挑战赛", type: "编程", deadline: "2025-01-20", status: "进行中" },
        { id: 2, name: "机器人创新大赛", type: "机器人", deadline: "2025-02-15", status: "报名中" },
        { id: 3, name: "数学建模大赛", type: "数学建模", deadline: "2025-03-10", status: "已结束" },
        { id: 4, name: "英语口语大赛", type: "英语", deadline: "2025-01-25", status: "报名中" },
        { id: 5, name: "创新创业大赛", type: "创新", deadline: "2025-05-30", status: "进行中" },
        { id: 6, name: "编程挑战赛 II", type: "编程", deadline: "2025-06-20", status: "进行中" },
        { id: 7, name: "机器人赛事", type: "机器人", deadline: "2025-04-20", status: "报名中" },
        { id: 8, name: "物理竞赛", type: "物理", deadline: "2025-02-28", status: "已结束" },
      ],
      searchKeyword: "",
      currentPage: 1,
      itemsPerPage: 5,
    };
  },
  computed: {
    totalPages() {
      return Math.ceil(this.filteredCompetitions.length / this.itemsPerPage);
    },
    filteredCompetitions() {
      let filtered = this.competitions.filter(competition =>
          competition.name.toLowerCase().includes(this.searchKeyword.toLowerCase())
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
    getStatusClass(status) {
      if (status === "报名中") return "status-active";
      if (status === "进行中") return "status-ongoing";
      if (status === "已结束") return "status-ended";
      return "";
    },
    searchCompetition() {
      this.currentPage = 1; // 重置到第一页
    },
    viewDetails(id) {
      // 这里可以跳转到详情页面，或者显示详情信息
      alert(`查看竞赛ID: ${id} 的详情`);
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
.competition-list-container {
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

.filters {
  margin-bottom: 20px;
  text-align: center;
}

.filters input {
  padding: 8px;
  font-size: 14px;
  width: 80%;
  max-width: 300px;
  margin-top: 10px;
}

.competition-table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

.competition-table th,
.competition-table td {
  padding: 10px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

.competition-table th {
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

.status-active {
  color: green;
}

.status-ongoing {
  color: orange;
}

.status-ended {
  color: red;
}
</style>
