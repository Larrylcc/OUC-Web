<template>
  <div class="banji-container">
    <!-- 搜索框和按钮 -->
    <div class="search">
      <el-input
          placeholder="请输入班级名称"
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
            label="班级名称"
            show-overflow-tooltip
        ></el-table-column>
        <el-table-column
            prop="neirong"
            label="班级描述"
            show-overflow-tooltip
        ></el-table-column>
        <el-table-column
            prop="specialitymingcheng"
            label="所属专业"
            show-overflow-tooltip
        ></el-table-column>
        <el-table-column
            prop="jiaoshimingcheng"
            label="班主任"
            show-overflow-tooltip
        ></el-table-column>

        <el-table-column
            label="操作"
            width="180"
            align="center"
            v-if="user.role === 'GUANLIYUAN'"
        >
        </el-table-column>
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
  name: "Banji",
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
      this.$request.get('/banji/selectPage', {
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
/* 外容器 */
.banji-container {
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 10px;
}

/* 搜索框样式 */
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
  transition: background-color 0.3s ease;
}

.action-btn:hover {
  background-color: #f0f0f0;
}

/* 表格样式 */
.table .custom-table {
  background-color: #fff;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  margin-top: 20px;
}

/* 表格内容样式 */
.el-table th, .el-table td {
  font-size: 14px;
  padding: 10px;
}

.el-table__cell {
  word-break: break-word;
}

.el-table-column {
  min-width: 120px;
}

/* 分页样式 */
.pagination {
  margin-top: 20px;
  display: flex;
  justify-neirong: center;
}

.el-pagination {
  font-size: 14px;
  padding: 10px;
}

/* 操作按钮悬停样式 */
.el-button {
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.el-button:hover {
  background-color: #f5f5f5;
}
</style>
