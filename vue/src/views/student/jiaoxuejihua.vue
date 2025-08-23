<!-- src/components/ProgramOverview.vue -->
<template>
  <div class="program-overview-container">
    <h1>本科生培养方案</h1>

    <section class="section">
      <h2>一、培养目标</h2>
      <p>
        以培养德智体美劳全面发展的社会主义事业合格建设者和可靠接班人为总目标，面向国家战略方向、信息技术前沿与经济主战场行业信息化的人才需求，培养具有健全人格、良好人文修养和职业道德，掌握计算机科学与技术领域及物联网特色方向坚实的基础理论、系统的专业知识，具备国际视野和创新意识，能够跟踪相关领域新知识与新技术、开展有效团队交流与合作的高水平工程技术人才。
      </p>
      <h4>学生毕业5年后，预期达到下列要求：</h4>
      <ul>
        <li>遵守工程师的职业道德规范，在工程实践中能够履行社会责任、服务国家建设。</li>
        <li>能进行有效的交流与团队合作，综合运用所学知识和技能，解决实际工程问题。</li>
        <li>能承担物联网系统的研发和管理工作，成为信息技术产业与行业信息化领域的工程技术骨干。</li>
        <li>具有创新精神和终身学习意识，能够跟踪相关领域新知识与新技术，适应国家、社会和产业的发展需求。</li>
      </ul>
    </section>

    <section class="section">
      <h2>二、毕业要求</h2>
      <p>毕业要求对应以下通用标准：</p>
      <ul>
        <li>能够将数学、自然科学、信息科学基础与专业知识运用于解决物联网系统相关的复杂工程问题（对应通用标准1：工程知识）。</li>
        <li>能够应用数学、自然科学、计算机及相关信息领域的科学与技术的基本原理，识别、表达、并通过文献研究分析物联网系统的复杂工程问题，以获得有效结论（对应通用标准2：问题分析）。</li>
        <li>能够设计复杂应用问题的解决方案，设计满足特定需求的应用系统或模块，在设计环节中体现创新意识，并考虑社会、健康、安全、法律、文化以及环境等因素（对应通用标准3：设计/开发解决方案）。</li>
        <li>能够基于科学原理、运用科学思维和方法，对物联网系统复杂工程问题进行研究（对应通用标准4：研究）。</li>
        <li>能够基于工程相关背景知识进行合理分析，评价物联网专业工程实践和复杂工程问题解决方案对社会、健康、安全、法律以及文化的影响，并理解应承担的责任（对应通用标准6：工程与社会）。</li>
        <li>理解并掌握物联网领域相关的工程管理原理与经济决策方法（对应通用标准11：项目管理）。</li>
        <li>具有自主学习和终身学习的意识，有不断学习和适应发展的能力（对应通用标准12：终身学习）。</li>
      </ul>
    </section>

    <section class="section">
      <h2>三、课程安排</h2>
      <table class="course-table">
        <thead>
        <tr>
          <th>序号</th>
          <th>开课学期</th>
          <th>课程编号</th>
          <th>课程名称</th>
          <th>开课单位</th>
          <th>学分</th>
          <th>总学时</th>
          <th>考核方式</th>
          <th>课程性质</th>
          <th>是否考试</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="course in courses" :key="course.id">
          <td>{{ course.index }}</td>
          <td>{{ course.semester }}</td>
          <td>{{ course.courseCode }}</td>
          <td>{{ course.courseName }}</td>
          <td>{{ course.department }}</td>
          <td>{{ course.credit }}</td>
          <td>{{ course.totalHours }}</td>
          <td>{{ course.assessmentMethod }}</td>
          <td>{{ course.courseNature }}</td>
          <td>{{ course.isExam ? '是' : '否' }}</td>
        </tr>
        </tbody>
      </table>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      courses: [
        {
          id: 1,
          index: 1,
          semester: "2022-2023-1",
          courseCode: "10601831",
          courseName: "工科数学分析I",
          department: "数理学院",
          credit: 6,
          totalHours: 96,
          assessmentMethod: "考试",
          courseNature: "通识课程",
          isExam: true
        },
        {
          id: 2,
          index: 3,
          semester: "2022-2023-1",
          courseCode: "10903021",
          courseName: "基础外语I",
          department: "外国语学院",
          credit: 4,
          totalHours: 64,
          assessmentMethod: "考试",
          courseNature: "通识课程",
          isExam: true
        },
        {
          id: 3,
          index: 4,
          semester: "2022-2023-1",
          courseCode: "11101011",
          courseName: "体育I",
          department: "体育部",
          credit: 1,
          totalHours: 32,
          assessmentMethod: "考试",
          courseNature: "通识课程",
          isExam: true
        },
        {
          id: 4,
          index: 5,
          semester: "2022-2023-1",
          courseCode: "1120101",
          courseName: "军事理论",
          department: "军事",
          credit: 2,
          totalHours: 36,
          assessmentMethod: "考试",
          courseNature: "通识课程",
          isExam: true
        },
        {
          id: 5,
          index: 6,
          semester: "2022-2023-1",
          courseCode: "11501021",
          courseName: "大学生职业发展与就业指导I",
          department: "教务处",
          credit: 0,
          totalHours: 8,
          assessmentMethod: "考试",
          courseNature: "通识课程",
          isExam: true
        },
        // 其他课程数据
      ]
    };
  }
};
</script>

<style scoped>
.program-overview-container {
  max-width: 1000px;
  margin: 20px auto;
  padding: 20px;
  background-color: #f4f4f4;
  border-radius: 10px;
}

h1 {
  text-align: center;
  font-size: 28px;
  margin-bottom: 20px;
}

h2 {
  margin-top: 30px;
  font-size: 22px;
}

h4 {
  margin-top: 10px;
  font-size: 18px;
}

ul {
  margin-left: 20px;
  font-size: 16px;
}

.course-table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

.course-table th, .course-table td {
  border: 1px solid #ddd;
  padding: 10px;
  text-align: center;
}

.course-table th {
  background-color: #f0f0f0;
  font-weight: bold;
}

.course-table td {
  background-color: #fff;
}
</style>
