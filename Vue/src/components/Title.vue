<script setup>
import { ref } from 'vue'

defineProps({
  msg: String,
})

const count = ref(0)
</script>

<template>
  <div class="home">
    <div class="header">
      <h2>My Util Tools</h2>
    </div>
  </div>
</template>

<style scoped>
.header {
  color: black ;
  font-family:'Courier New', Courier, monospace;
}

/* 
.home {
  display: inline-block;
  position: relative;
}

.header {
  display: inline-block;
  vertical-align: top;
  border-bottom: 5px;
  color: black;
}

.tools {
  display: inline-block;
  vertical-align: top;
  text-align: left;
} */
</style>
