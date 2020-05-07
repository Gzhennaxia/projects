<template>
    <div class="wrapper">
        <div class="cover">
            <img width="100%" :src="book.coverLink" :alt="book.title">
        </div>
        <div class="title">{{ book.title }}</div>
        <div class="author">{{ book.author }}</div>
    </div>
<!--    <div class="wrapper">-->
<!--        <div class="cover">-->
<!--            <img width="100%" src="https://www.sxpdf.com/wp-content/uploads/2020/01/1578705429-111.jpg" alt="搞定">-->
<!--        </div>-->
<!--        <div class="title">-->
<!--            搞定：无压工作的艺术时间管理+提升工作+平衡工作与生活的艺术美（共三册）-->
<!--        </div>-->
<!--        <div class="author">戴维·艾伦</div>-->
<!--    </div>-->
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
        font-size: 12px;
        text-align: center;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }

    .author {
        font-size: 12px;
        color: #777;
        text-align: center;
    }
</style>
