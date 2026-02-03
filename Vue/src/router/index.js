import { createRouter, createWebHistory } from 'vue-router'
import CodeConversion from '../components/CodeConversion.vue'
import HelloWorld from '../components/HelloWorld.vue'
// 今後ツールが増えたらここにインポートを追加
// import AnotherTool from '../components/AnotherTool.vue'

const routes = [
  {
    path: '/',
    name: 'CodeConversion',
    component: CodeConversion
  },
  {
    path: '/HelloWorld',
    name: 'HelloWorld',
    component: HelloWorld
  },
  /* {
    path: '/another',
    name: 'Another',
    component: AnotherTool
  } 
  */
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router