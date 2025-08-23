<template>
  <div>
    <!-- 教务通知和考试安排并排展示 -->
    <div style="display: flex; margin-bottom: 20px;">
      <!-- 教务通知 -->
      <div style="width: 50%; margin-right: 10px; padding: 15px;" class="card">
        <div style="margin-bottom: 20px; font-size: 18px; font-weight: bold">教务通知</div>
        <el-timeline reverse>
          <el-timeline-item
              v-for="item in notices"
              :key="item.id"
              :timestamp="item.time">
            <el-popover
                placement="right"
                width="200"
                trigger="hover"
                :neirong="item.neirong">
              <span slot="reference">{{ item.title }}</span>
            </el-popover>
          </el-timeline-item>
        </el-timeline>
      </div>

      <!-- 考试安排 -->
      <div style="width: 50%; margin-left: 10px; padding: 15px;" class="card">
        <div style="margin-bottom: 20px; font-size: 18px; font-weight: bold">考试安排</div>
        <el-timeline reverse>
          <el-timeline-item
              v-for="item in examplans"
              :key="item.id"
              :timestamp="item.time">
            <el-popover
                placement="right"
                width="200"
                trigger="hover"
                :neirong="item.neirong">
              <span slot="reference">{{ item.name }}</span>
            </el-popover>
          </el-timeline-item>
        </el-timeline>
      </div>
    </div>

    <!-- 课表展示 -->
    <div style="padding: 15px;" class="card">
      <div style="margin-bottom: 30px; font-size: 20px; font-weight: bold">课表</div>
      <el-table :data="tableData" stripe border>
        <el-table-column prop="segment" label="时间" width="200"></el-table-column>
        <el-table-column
            v-for="day in days"
            :key="day"
            :prop="day.prop"
            :label="day.label"
            show-overflow-tooltip>
          <template #default="scope">
            <div
                v-if="scope.row[day.prop]"
                style="background-color: #e6f7ff; color: #1890ff; text-align: center; border-radius: 4px; padding: 4px;">
              {{ scope.row[day.prop] }}
            </div>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      user: JSON.parse(localStorage.getItem("xm-user") || "{}"),
      notices: [],
      examplans: [],
      tableData: [],
      days: [
        { label: "星期一", prop: "monday" },
        { label: "星期二", prop: "tuesday" },
        { label: "星期三", prop: "wednesday" },
        { label: "星期四", prop: "thursday" },
        { label: "星期五", prop: "friday" },
        { label: "星期六", prop: "saturday" },
        { label: "星期日", prop: "sunday" },
      ],
    };
  },
  created() {
    this.loadNotices();
    this.loadExamPlans();
    this.loadCurriculum();
  },
  methods: {
    // 加载教务通知
    loadNotices() {
      this.$request.get("/notice/selectAll").then((res) => {
        if (res.code === "200") {
          this.notices = res.data || [];
        } else {
          this.$message.error(res.msg);
        }
      });
    },
    // 加载考试安排
    loadExamPlans() {
      this.$request.get("/examplan/selectAll").then((res) => {
        if (res.code === "200") {
          this.examplans = res.data || [];
        } else {
          this.$message.error(res.msg);
        }
      });
    },
    // 加载课表
    loadCurriculum() {
      this.$request.get("/xuanke/getCurriculum").then((res) => {
        if (res.code === "200") {
          this.tableData = res.data || [];
        } else {
          this.$message.error(res.msg);
        }
      });
    },
  },
};
</script>

<style scoped>
.card {
  background-color: #fff;
  border: 1px solid #ebeef5;
  border-radius: 6px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
</style>
