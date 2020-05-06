import VueRouter from 'vue-router'
import Vue from 'vue'

Vue.use(VueRouter);

const routes = [{
    path: '',
    component: () => import('@/views/index')
}];

const router = new VueRouter({
    routes
});

export default router
