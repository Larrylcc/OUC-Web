<template>
  <div>
    <div class="table">
      <el-table :data="tableData" stripe border>
        <el-table-column prop="segment" label="时间" width="200"></el-table-column>

        <!-- 用 scoped-slot 自定义表格单元格显示 -->
        <el-table-column prop="monday" label="星期一" show-overflow-tooltip>
          <template slot-scope="scope">
            <div v-if="scope.row.monday" style="background-color: #e6f7ff; color: #1890ff; text-align: center; border-radius: 4px; padding: 4px;">
              {{ scope.row.monday }}
            </div>
          </template>
        </el-table-column>

        <el-table-column prop="tuesday" label="星期二" show-overflow-tooltip>
          <template slot-scope="scope">
            <div v-if="scope.row.tuesday" style="background-color: #e6f7ff; color: #1890ff; text-align: center; border-radius: 4px; padding: 4px;">
              {{ scope.row.tuesday }}
            </div>
          </template>
        </el-table-column>

        <el-table-column prop="wednesday" label="星期三" show-overflow-tooltip>
          <template slot-scope="scope">
            <div v-if="scope.row.wednesday" style="background-color: #e6f7ff; color: #1890ff; text-align: center; border-radius: 4px; padding: 4px;">
              {{ scope.row.wednesday }}
            </div>
          </template>
        </el-table-column>

        <el-table-column prop="thursday" label="星期四" show-overflow-tooltip>
          <template slot-scope="scope">
            <div v-if="scope.row.thursday" style="background-color: #e6f7ff; color: #1890ff; text-align: center; border-radius: 4px; padding: 4px;">
              {{ scope.row.thursday }}
            </div>
          </template>
        </el-table-column>

        <el-table-column prop="friday" label="星期五" show-overflow-tooltip>
          <template slot-scope="scope">
            <div v-if="scope.row.friday" style="background-color: #e6f7ff; color: #1890ff; text-align: center; border-radius: 4px; padding: 4px;">
              {{ scope.row.friday }}
            </div>
          </template>
        </el-table-column>

        <el-table-column prop="saturday" label="星期六" show-overflow-tooltip>
          <template slot-scope="scope">
            <div v-if="scope.row.saturday" style="background-color: #e6f7ff; color: #1890ff; text-align: center; border-radius: 4px; padding: 4px;">
              {{ scope.row.saturday }}
            </div>
          </template>
        </el-table-column>

        <el-table-column prop="sunday" label="星期日" show-overflow-tooltip>
          <template slot-scope="scope">
            <div v-if="scope.row.sunday" style="background-color: #e6f7ff; color: #1890ff; text-align: center; border-radius: 4px; padding: 4px;">
              {{ scope.row.sunday }}
            </div>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
export default {
  name: "Curriculum",
  data() {
    return {
      tableData: [],
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      this.$request.get('/xuanke/getCurriculum').then(res => {
        if (res.code === '200') {
          this.tableData = res.data
        } else {
          this.$message.error(res.msg)
        }
      })
    },
  }
}
</script>

<style scoped>
</style>
