<template>
  <div>
    <div class="search">
      <el-input placeholder="请输入教师姓名" style="width: 200px" v-model="laoshi"></el-input>
      <el-input placeholder="请输入评教内容" style="width: 200px; margin-left: 5px" v-model="neirong"></el-input>
      <el-button type="info" plain style="margin-left: 10px" @click="load(1)">查询</el-button>
      <el-button type="warning" plain style="margin-left: 10px" @click="reset">重置</el-button>
    </div>

    <div class="table">
      <el-table :data="tableData" stripe>
        <el-table-column prop="id" label="序号" width="80" align="center" sortable></el-table-column>
        <el-table-column prop="name" label="课程名称" show-overflow-tooltip width="200px"></el-table-column>
        <el-table-column prop="laoshi" label="授课教师" width="100px"></el-table-column>
        <el-table-column prop="neirong" label="评教内容"></el-table-column>
        <el-table-column prop="time" label="评教时间" width="250px"></el-table-column>
      </el-table>

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

  </div>
</template>

<script>
export default {
  name: "Comment",
  data() {
    return {
      tableData: [],  // 所有的数据
      pageNum: 1,   // 当前的页码
      pageSize: 10,  // 每页显示的个数
      total: 0,
      laoshi: null,
      neirong: null,
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      rules: {},
      ids: []
    }
  },
  created() {
    this.load(1)
  },
  methods: {
    load(pageNum) {  // 分页查询
      if (pageNum) this.pageNum = pageNum
      this.$request.get('/pingjia/selectPage', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          laoshi: this.laoshi,
          neirong: this.neirong,
        }
      }).then(res => {
        this.tableData = res.data?.list
        this.total = res.data?.total
      })
    },
    reset() {
      this.laoshi = null
      this.neirong = null
      this.load(1)
    },
    handleCurrentChange(pageNum) {
      this.load(pageNum)
    },
  }
}
</script>

<style scoped>
.guanliyuan-container {
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 10px;
}

.search, .operation {
  margin-bottom: 20px;
}

.search .el-input {
  background-color: #fff;
  border-radius: 5px;
}

.search-btn, .reset-btn {
  margin-left: 10px;
  border-radius: 5px;
}

.operation-btn {
  border-radius: 5px;
}

.table .custom-table {
  background-color: #fff;
  box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
}

.table .avatar-container {
  display: flex;
  align-items: center;
}

.table .el-image {
  border-radius: 50%;
}

.dialog-footer {
  display: flex;
  justify-neirong: flex-end;
  gap: 10px;
}

.el-dialog {
  border-radius: 8px;
  padding: 20px;
}

.el-button {
  border-radius: 5px;
  transition: background-color 0.3s;
}

.el-button:hover {
  background-color: #f5f5f5;
}
</style>
