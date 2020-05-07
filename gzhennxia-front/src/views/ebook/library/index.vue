<template>
    <div>
        <h1>Here is library!</h1>
        <div class="bookshelf">
            <introduction v-for="book in books" :key="book.id" :book="book"/>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
import Introduction from './components/introduction'

export default {
  name: 'index',
  components: {
    Introduction
  },
  data () {
    return {
      books: []
    }
  },
  mounted () {
    this.getBooks()
  },
  methods: {
    getBooks () {
      axios.get('http://localhost:9527/ebook/book/all')
        .then(response => {
          if (response.data.code === 2000) {
            this.books = response.data.data
          } else {
            console.log(response)
          }
        })
    }
  }
}
</script>

<style scoped>
    .bookshelf {
        width: 80%;
        margin: 0 auto;
        display: flex;
        flex-wrap: wrap;
    }
</style>
