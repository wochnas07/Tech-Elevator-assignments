<!-- This is generated by vue create command                                  -->
<!-- We WILL be adding things to this file related to our Vue componenets     -->

<template>            <!-- html for the Vue component -->
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <!-- a Vue component is indicated as a tag in the html                    -->
    <!-- a Vue component is a custom html tag created by programmers          -->
    <product-review></product-review> <!-- use out new Vue component          -->
  </div>
</template>

<script>              // JavaScript for our Vue component
// the src folder in the Vue project is considered the root folder for the project
// references to any other files/folders in the project are relative to src folder

import ProductReview from './components/ProductReview.vue'  // Go get the ProductReview.vue component

// Export allows processes (like Vue) access to data defined in this JavaScript code
// default is the default name for an object shared outside the code
export default {    // export exposed data to things outside this component (like Vue) 
  name: 'App',      // name of the application - matches the name of the component
  components: {     // list of all the Vue components used in this file 
    ProductReview      // tells Vue we are using ProductReview component - must match the import name
  }
}
</script>

<style>               /* CSS for our Vue component */
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
