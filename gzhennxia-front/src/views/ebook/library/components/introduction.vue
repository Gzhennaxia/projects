<template>
    <div class="wrapper">
        <div class="cover">
            <router-link :to="`/ebook/${book.id}/note/`">
                <img width="100%" :src="book.coverLink" :alt="book.title">
            </router-link>
        </div>
        <div class="title">
            <router-link :to="`/ebook/${book.id}/note/`">{{ book.title }}</router-link>
        </div>
        <div class="author">{{ book.author }}</div>
    </div>
</template>

<script>
export default {
  name: 'introduction',
  props: {
    book: Object
  },
  data () {
    return {}
  }
}
</script>

<style scoped>
    .wrapper {
        width: 12%;
        margin: 0 4%;
    }

    .cover {
        padding: 5px 10px 0;
    }

    .title {
        color: #333;
        text-decoration: none;
        font-size: 12px;
        text-align: center;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }

    a {
        color: #333;
        text-decoration: none;
    }

    .author {
        font-size: 12px;
        color: #777;
        text-align: center;
    }
</style>
