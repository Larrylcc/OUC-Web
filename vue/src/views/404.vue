<template>
  <div class="not-found-container">
    <div class="not-found-content">
      <div class="error-message">
        <span class="error-code">404</span>
        <span class="error-text">找不到页面</span>
      </div>
      <router-link to="/" class="back-home-button">返回首页</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "404",
  data() {
    return {};
  },
  created() {},
  methods: {},
};
</script>

<style scoped>
.not-found-container {
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background: linear-gradient(135deg, #74b9ff, #a29bfe);
}

.not-found-content {
  text-align: center;
  color: #fff;
}

.error-message {
  font-size: 70px;
  font-weight: bold;
  margin-bottom: 20px;
}

.error-code {
  color: #ff6b81;
}

.error-text {
  font-size: 24px;
  color: #ffeaa7;
}

.back-home-button {
  display: inline-block;
  padding: 10px 20px;
  font-size: 18px;
  background-color: #0984e3;
  color: white;
  border-radius: 5px;
  text-decoration: none;
  transition: background-color 0.3s ease;
}

.back-home-button:hover {
  background-color: #74b9ff;
}

@media (max-width: 768px) {
  .error-message {
    font-size: 50px;
  }

  .error-text {
    font-size: 18px;
  }

  .back-home-button {
    font-size: 16px;
    padding: 8px 15px;
  }
}
</style>
