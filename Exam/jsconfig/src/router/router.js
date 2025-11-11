import { createRouter, createWebHistory } from 'vue-router';

import Join from '../views/JoinPage.vue';
import Login from '../views/LoginPage.vue';
import BoardList from '../views/BoardList.vue';
import BoardWrite from '../views/BoardWrite.vue';
import BoardDetail from '../views/BoardDetail.vue';

const routes = [
  { path: '/', redirect: '/board' },
  { path: '/join', component: Join },
  { path: '/login', component: Login },
  { path: '/board', component: BoardList },
  { path: '/board/write', component: BoardWrite },
  { path: '/board/:id', component: BoardDetail, props: true },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
