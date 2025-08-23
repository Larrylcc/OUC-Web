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

    <!-- 显示“尊敬的海大管理员，您好” -->
    <div style="text-align: -webkit-center; margin-top: 40px; font-size: 40px; color: #666; margin-left: 20px;">
      尊敬的海大管理员，您好
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
