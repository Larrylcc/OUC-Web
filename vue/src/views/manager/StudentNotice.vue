<template>
  <div class="container">
    <h1 class="title">通知公告</h1>

    <el-collapse v-model="activeNames">
      <el-collapse-item
          v-for="(item, index) in tableData"
          :key="item.id"
          :name="item.id.toString()"
      >
        <template #title>
          <div class="collapse-header">
            <el-row>
              <el-col :span="8" class="ellipsis">
                <strong>标题:</strong> {{ item.name }}
              </el-col>
              <el-col :span="16" class="ellipsis center">
                <strong>时间:</strong> {{ item.time }}
              </el-col>
            </el-row>
          </div>
        </template>

        <div class="neirong">
          <p>{{ item.neirong }}</p>
        </div>
      </el-collapse-item>
    </el-collapse>

    <div class="pagination">
      <el-pagination
          background
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[5, 10, 20]"
          :page-size="pageSize"
          layout="total, prev, pager, next"
          :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: "Notice",
  data() {
    return {
      tableData: [],  // 所有的数据
      pageNum: 1,   // 当前的页码
      pageSize: 10,  // 每页显示的个数
      total: 0,
      title: null,
      fromVisible: false,
      form: {},
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      ids: [],
      activeNames: []  // 控制展开的面板
    }
  },
  created() {
    this.load(1)
  },
  methods: {
    load(pageNum) {  // 分页查询
      if (pageNum) this.pageNum = pageNum
      this.$request.get('/examplan/selectPage', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          title: this.title,
        }
      }).then(res => {
        this.tableData = res.data?.list
        this.total = res.data?.total
      })
    },
    reset() {
      this.title = null
      this.load(1)
    },
    handleCurrentChange(pageNum) {
      this.load(pageNum)
    },
  }
}
</script>

<style scoped>
body {
  font-family: 'Arial', sans-serif;
  background: linear-gradient(to right, #f8f9fa, #e9ecef);
  margin: 0;
  padding: 20px;
}

.container {
  max-width: 800px;
  margin: 0 auto;
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  padding: 20px;
}

.title {
  color: #333;
  font-size: 24px;
  margin-bottom: 20px;
}

.collapse-header {
  background-color: #e9ecef;
  padding: 15px;
  border-radius: 6px;
  margin-bottom: 15px;
  display: flex;
  justify-neirong: space-between;
  align-items: center;
}

.collapse-header strong {
  color: #007bff;
}

.neirong {
  padding: 15px;
  background-color: #f8f9fa;
  border-radius: 6px;
  margin-bottom: 15px;
}

.center {
  text-align: center;
}

.pagination {
  margin-top: 20px;
  text-align: center;
}

.el-pagination button {
  background-color: #007bff;
  color: #fff;
  border: none;
  padding: 5px 10px;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.el-pagination button:hover {
  background-color: #0056b3;
}

.ellipsis {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
</style>
