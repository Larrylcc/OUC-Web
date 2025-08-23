<template>
  <div class="speciality-container">
    <!-- 搜索框和按钮 -->
    <div class="search">
      <el-input
          placeholder="请输入学院名称"
          v-model="name"
          class="search-input"
      ></el-input>
      <el-button
          type="info"
          plain
          class="action-btn"
          @click="load(1)"
      >
        查询
      </el-button>
      <el-button
          type="warning"
          plain
          class="action-btn"
          @click="reset"
      >
        重置
      </el-button>
    </div>

    <!-- 表格展示 -->
    <div class="table">
      <el-table
          :data="tableData"
          stripe
          @selection-change="handleSelectionChange"
          class="custom-table"
      >
        <el-table-column
            type="selection"
            width="55"
            align="center"
            v-if="user.role === 'GUANLIYUAN'"
        ></el-table-column>
        <el-table-column
            prop="id"
            label="序号"
            width="80"
            align="center"
            sortable
        ></el-table-column>
        <el-table-column
            prop="name"
            label="专业名称"
            show-overflow-tooltip
        ></el-table-column>
        <el-table-column
            prop="neirong"
            label="专业描述"
            show-overflow-tooltip
        ></el-table-column>
        <el-table-column
            prop="collegeName"
            label="所属学院"
            show-overflow-tooltip
        ></el-table-column>
      </el-table>

      <!-- 分页 -->
      <div class="pagination">
        <el-pagination
            background
            @current-change="handleCurrentChange"
            :current-page="pageNum"
            :page-sizes="[5, 10, 20]"
            :page-size="pageSize"
            layout="total, prev, pager, next"
            :total="total"
        />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Speciality",
  data() {
    return {
      tableData: [],
      pageNum: 1,
      pageSize: 10,
      total: 0,
      name: null,
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
    };
  },
  created() {
    this.load(1);
  },
  methods: {
    load(pageNum) {
      if (pageNum) this.pageNum = pageNum;
      this.$request.get('/speciality/selectPage', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          name: this.name,
        }
      }).then(res => {
        this.tableData = res.data?.list;
        this.total = res.data?.total;
      });
    },
    reset() {
      this.name = null;
      this.load(1);
    },
    handleCurrentChange(pageNum) {
      this.load(pageNum);
    },
  }
}
</script>

<style scoped>
.speciality-container {
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 10px;
}

.search {
  margin-bottom: 20px;
  display: flex;
  align-items: center;
  gap: 10px;
}

.search-input {
  width: 200px;
  border-radius: 5px;
}

.action-btn {
  border-radius: 5px;
  padding: 6px 12px;
}

.table .custom-table {
  background-color: #fff;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
}

.pagination {
  margin-top: 20px;
  display: flex;
  justify-neirong: center;
  padding: 10px;
}

.el-table th, .el-table td {
  font-size: 14px;
  padding: 10px;
}

.el-table .el-table__body {
  font-size: 13px;
}

</style>
