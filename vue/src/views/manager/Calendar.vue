<!-- src/components/SchoolCalendar.vue -->
<template>
  <div class="calendar-container">
    <h1>2025年 校历</h1>

    <div class="semester">
      <h2>第一学期</h2>
      <ul>
        <li><strong>开学时间:</strong> 2025年9月1日</li>
        <li><strong>中秋节放假:</strong> 2025年9月15日</li>
        <li><strong>国庆节放假:</strong> 2025年10月1日 - 10月7日</li>
        <li><strong>期中考试:</strong> 2025年11月10日 - 11月14日</li>
        <li><strong>寒假放假:</strong> 2025年12月20日 - 2026年2月1日</li>
      </ul>
    </div>

    <div class="semester">
      <h2>第二学期</h2>
      <ul>
        <li><strong>开学时间:</strong> 2026年3月1日</li>
        <li><strong>劳动节放假:</strong> 2026年5月1日 - 5月3日</li>
        <li><strong>期末考试:</strong> 2026年6月15日 - 6月20日</li>
        <li><strong>暑假放假:</strong> 2026年7月1日 - 2026年8月31日</li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "SchoolCalendar",
};
</script>

<style scoped>
.calendar-container {
  font-family: Arial, sans-serif;
  padding: 20px;
  max-width: 800px;
  margin: 0 auto;
  text-align: center;
}

h1 {
  font-size: 2rem;
  margin-bottom: 20px;
}

.semester {
  background-color: #f4f4f4;
  padding: 15px;
  margin: 10px 0;
  border-radius: 8px;
}

h2 {
  font-size: 1.5rem;
  margin-bottom: 10px;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin: 8px 0;
  font-size: 1.1rem;
}

strong {
  font-weight: bold;
}
</style>
