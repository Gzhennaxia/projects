<template>
    <div>
        <span>Hi, there is gzhennaxia.</span>
        <div>
            <input type="button" value="Sync Books" @click="syncBooks"/>
        </div>
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
