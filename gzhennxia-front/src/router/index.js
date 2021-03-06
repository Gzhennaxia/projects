import VueRouter from 'vue-router'
import Vue from 'vue'

Vue.use(VueRouter)

const routes = [{
  path: '',
  component: () => import('@/views/index')
}, {
  path: '/ebook',
  component: () => import('@/views/ebook/index')
}, {
  path: '/ebook/library',
  component: () => import('@/views/ebook/library')
}, {
  path: '/ebook/:bookId/note',
  component: () => import('@/views/ebook/note')
}]

const router = new VueRouter({
  routes
})

export default router
