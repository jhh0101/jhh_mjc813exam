<template>
  <div>
  <HelloWorld/>
    <div v-for="item in list" :key="item.id">
      {{ item.title }}
    </div>
    
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import axios from "axios";

export default {
  name: 'App',
  components: {
    HelloWorld
  },
  data(){
    return{
      list:[]
    }
  },
  async mounted(){
    const result = await axios.get('http://localhost:8084/api/v1/user');
    this.list = result.data.data;
    
  }
  
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
