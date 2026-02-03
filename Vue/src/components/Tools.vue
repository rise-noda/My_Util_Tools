<script setup>
import { ref } from 'vue'

defineProps({
  msg: String,
})

const count = ref(0)
</script>

<template>
    <nav class="side-menu">
        <ul>
            <li>・<router-link to="/">エンコード・デコード</router-link></li>
            <router-link to="/HelloWorld"><p style="color: black;">今後追加予定</p></router-link>
        </ul>
    </nav>
</template>

<style scoped>
ul { list-style: none; padding: 0; }
li {
    margin-bottom: 15px;
}
a { color: blue; text-decoration: none; font-size: 0.9rem; }
a:hover { text-decoration: underline; }
.side-menu {
    text-align: left;
}
</style>
