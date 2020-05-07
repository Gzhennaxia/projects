<template>
    <div>
        <h1>Here is eBook!</h1>
        <div>
            <input type="button" value="Sync Books" @click="syncBooks"/>
        </div>
        <h2><router-link to="/ebook/library">Library</router-link></h2>
    </div>

</template>

<script>
import axios from 'axios'

export default {
  name: 'index',
  methods: {
    syncBooks () {
      axios.get('http://localhost:9527/ebook/book/syncBooks').then(response => { console.log(response) })
    }
  }
}
</script>

<style scoped>

</style>
