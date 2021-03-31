// This tells Vue Route what paths it will handle and which views to display for those paths

import Vue from 'vue'                 // Give me access to the Vue code
import VueRouter from 'vue-router'    // Give me access to the Vue Router code
import Products from '@/views/Products.vue'   // include the Products.vue view code
import ProductDetail from '@/views/ProductDetail.vue'

Vue.use(VueRouter)                    // We want to use the VueRouter for this app

// routes that Vue will manage are defined in an array called routes
// a route is like a @RequestMapping in an MVC controller to assign a URL path to a process
const routes = [    
  { // an element in the routes array is an object with the attributes of the route - associate a path to a view
    path: '/',          // The URL path we want to associate with a router view 
    name: 'products',   // name for the path router view association
    component: Products // view router component associated with the path - stored in views folder
  },
  // we need to define a dynamic path that takes a path variable
  // a dynamic path has a path variable defined with a :variable-name
  {
    path: '/product/:id',       // this path has a path variable called id
    name: 'product-detail',     // name for the path-view association
    component: ProductDetail    // name is router view in the views folder
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
