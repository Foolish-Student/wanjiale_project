import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
// import EditUser from '../views/member/EditUser.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/add',
    name: 'Add',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Add.vue')
  }
  ,
  {
    path: '/user',
    name: 'User',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/member/User.vue')
  },
  {
    path: '/addUser',
    name: 'AddUser',
    component: () => import(/* webpackChunkName: "about" */ '../views/member/AddUser.vue')
  },
  {
    path: '/editUser',
    name: 'EditUser',
    component: () => import(/* webpackChunkName: "about" */ '../views/member/EditUser.vue')
  },

  {
    path: '/role',
    name: 'Role',
    component: () => import(/* webpackChunkName: "about" */ '../views/member/Role.vue')
  },
  {
    path: '/addRole',
    name: 'AddRole',
    component: () => import(/* webpackChunkName: "about" */ '../views/member/AddRole.vue')
  },



  {
    path: '/shop',
    name: 'Shop',
    component: () => import(/* webpackChunkName: "about" */ '../views/shop/Shop.vue')
  },

  {
    path: '/addshop',
    name: 'AddShop',
    component: () => import(/* webpackChunkName: "about" */ '../views/shop/AddShop.vue')
  },
  {
    path: '/update',
    name: 'Update',
    component: () => import(/* webpackChunkName: "about" */ '../views/shop/UpDate.vue')
  },
    {
        path: '/product',
        name: 'Product',
        component: () => import(/* webpackChunkName: "about" */ '../views/product/Product.vue')
    },
    {
        path: '/addproduct',
        name: 'AddProduct',
        component: () => import(/* webpackChunkName: "about" */ '../views/product/AddProduct')
    },
    {
        path: '/upproduct',
        name: 'UpProduct',
        component: () => import(/* webpackChunkName: "about" */ '../views/product/UpProduct')
    },
    {
        path: '/info',
        name: 'Info',
        component: () => import(/* webpackChunkName: "about" */ '../views/product/Info')
    },
    {
        path: '/editRole',
        name:'EditRole',
        component:()=>import(/*webpackChunkName:"about"*/'../views/member/EditRole.vue')
    },
    {
        path:'/updatePassword',
        name:'UpdatePassword',
        component:()=>import(/*webpackChunkName:"about"*/'../views/member/UpdatePassword.vue')
    },
    {
        path:'/editUser',
        name:'EditUser',
        component:()=>import(/*webpackChunkName:"about"*/'../views/member/EditUser.vue')
    }


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
