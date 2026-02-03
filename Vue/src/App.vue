<script setup>
import Title from './components/Title.vue'
// import CodeConversion from './components/CodeConversion.vue'
import Tools from './components/Tools.vue'

import { ref } from 'vue'

</script>

<template>
  <div class="all-block">
    <div class="left-block">
      <header class="title-section">
        <Title />
      </header>
      <main class="content-section">
        <router-view />
      </main>
    </div>
    <div class="right-block">
      <Tools />
    </div>
  </div>
</template>

<style scoped>

.all-block {
  display: flex;             /* 左右に並べる */
  min-height: 100vh;        /* 画面いっぱいの高さ */
  width: 100%;
}

.left-block {
  flex: 1;                  /* 残りの幅をすべて使う */
  display: flex;
  flex-direction: column;    /* タイトルとメインを縦に並べる */
  /* background-color: #5b7bbd; 画像の青色部分 */
}

.title-section {
  padding: 0px 0px 0px 50px;
  text-align: left;
  border-bottom: 2px solid blanchedalmond;
  background-color: ivory;
}

.content-section {
  padding: 40px;
  display: flex;
  justify-content: center;   /* コンテンツを中央寄せ */
}

.right-block {
  width: 170px;             /* サイドバーの幅を固定 */
  background-color: ghostwhite; /* 画像のオレンジ部分 */
  border-left: 2px solid blanchedalmond;
  padding: 20px;
}
/* .logo {
  height: 15em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
} */
</style>
