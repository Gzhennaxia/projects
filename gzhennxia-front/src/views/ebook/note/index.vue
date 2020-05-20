<template>
    <div>
        <h1 class="title">Here is note.</h1>
        <div>
            <div class="toc">
                <ul>
                    <li v-for="item of toc">{{ item }}</li>
                </ul>
            </div>
            <div class="main-body">
                <div class="body-wrapper">
                    <h2>第一章 在金先生家</h2>
                    <div class="note-label">
                        <div style="line-height: 28px">
                            2020-05-11 14:38
                        </div>
                        <div class="note-pos" title="epubcfi(/6/30[id145]!/4/86/1,:48,:100)">
                            POS
                        </div>
                    </div>
                    <div class="note-content">
                        <span>他向我解释道：“吉娅，</span>
                        <span style="color: #FECF0B;">大多数人都是这么想的，我曾经也这么想。可是请你告诉我，你为什么不能因为做了一件自己喜欢的事情而挣到钱呢？</span>
                        <span>”</span>
                    </div>
                    <div>
                        <p>吉雅因为金先生要给她 “钱钱” 的照顾飞而生气，说 “我愿意照顾钱钱是因为我一见到它就喜欢上了它，而不是为了挣什么钱。”，但金先生却告诉她这是她应得的。</p>
                        <p>对于我们喜欢的事物，我们总是情愿不计回报的付出，甚至会觉得与金钱相提并论会显得庸俗不堪，但其实金钱的本质本来就是用来衡量价值大小的。</p>
                        <p>
                            比如，生活中有些时候我帮了别人一个小忙，别人为了感谢给我发个红包什么的，我会很不好意思收这个红包，认为别人是不想欠这个人情。但其实换个思路，这个时候是可以大大方方的收下这个红包的。一方面这是你付出的合理回报，另一方面如果别人不想欠你人情，你也没有必要留着这份人情，你情我愿下的人情才弥足珍贵。</p>
                        <p>
                            再者，我们生活工作的目标不都是希望从事自己喜欢的行业，也希望能有较好的物质生活，两者结合起来不是更好吗，如果从这个角度想，是不是小时候因为不情愿把自己喜欢的事情和金钱相提并论这种思维方式，导致了我们一开始就没有将喜好作为以后从事的工作的参考标准，而工作之后又总是抱怨当前的工作并不是自己真心喜欢的行业呢？</p>
                    </div>
                    <div v-for="note of notes">
                        <div class="note-label">
                            <div style="line-height: 28px">
                                {{ note.createTime }}}
                            </div>
                            <div class="note-pos" :title="note.pos">
                                POS
                            </div>
                        </div>
                        <div class="note-content">
                            <span>{{ note.contentBefore }}</span>
                            <span style="color: #FECF0B;">
                                {{ note.contentMiddle }}
                            </span>
                            <span>{{ note.contentAfter }}</span>
                        </div>
                        <div v-html="note.comment"></div>
                    </div>

                    <div v-for="chapterNote of chapterNotes">
                        <h2>{{ chapterNote.chapterName || 'Unknown' }}</h2>
                        <div v-for="note of chapterNote.notes">
                            <div class="note-label">
                                <div style="line-height: 28px">
                                    {{ note.createTime }}}
                                </div>
                                <div class="note-pos" :title="note.pos">
                                    POS
                                </div>
                            </div>
                            <div class="note-content">
                                <span>{{ note.contentBefore }}</span>
                                <span style="color: #FECF0B;">
                                {{ note.contentMiddle }}
                            </span>
                                <span>{{ note.contentAfter }}</span>
                            </div>
                            <div v-html="note.comment"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'index',
  data () {
    return {
      toc1: [
        '第一章 在金先生家',
        '第二章 但发送的烦恼暗示法',
        '第三章 撒都爹路飞often'
      ],
      notes: [
        {
          createTime: '2020-05-11 14:38',
          pos: 'epubcfi(/6/30[id145]!/4/86/1,:48,:100)',
          contentBefore: '他向我解释道：“吉娅，',
          contentMiddle: '大多数人都是这么想的，我曾经也这么想。可是请你告诉我，你为什么不能因为做了一件自己喜欢的事情而挣到钱呢？',
          contentAfter: '”',
          comment: `<p>吉雅因为金先生要给她 “钱钱” 的照顾飞而生气，说 “我愿意照顾钱钱是因为我一见到它就喜欢上了它，而不是为了挣什么钱。”，但金先生却告诉她这是她应得的。</p>
                        <p>对于我们喜欢的事物，我们总是情愿不计回报的付出，甚至会觉得与金钱相提并论会显得庸俗不堪，但其实金钱的本质本来就是用来衡量价值大小的。</p>
                        <p>比如，生活中有些时候我帮了别人一个小忙，别人为了感谢给我发个红包什么的，我会很不好意思收这个红包，认为别人是不想欠这个人情。但其实换个思路，这个时候是可以大大方方的收下这个红包的。一方面这是你付出的合理回报，另一方面如果别人不想欠你人情，你也没有必要留着这份人情，你情我愿下的人情才弥足珍贵。</p>
                        <p>再者，我们生活工作的目标不都是希望从事自己喜欢的行业，也希望能有较好的物质生活，两者结合起来不是更好吗，如果从这个角度想，是不是小时候因为不情愿把自己喜欢的事情和金钱相提并论这种思维方式，导致了我们一开始就没有将喜好作为以后从事的工作的参考标准，而工作之后又总是抱怨当前的工作并不是自己真心喜欢的行业呢？</p>`
        }
      ],
      chapterNotes: []
    }
  },
  mounted () {
    this.getNotes()
  },
  computed: {
    toc () {
      return this.chapterNotes.map(o => o.chapterName ? o.chapterName : 'Unknown')
    }
  },
  methods: {
    getNotes () {
      console.log('this.$route.params', this.$route.params)
      const bookId = this.$route.params.bookId
      axios.get('http://localhost:9527/ebook/note/all/' + bookId).then(response => {
        if (response.data.code === 2000) {
          this.chapterNotes = response.data.data
          console.log(response.data.data)
        } else {
          console.log(response)
        }
      })
    }
  }
}
</script>

<style scoped>
    .title {
        position: fixed;
        top: 0;
        left: 0;
        margin: 0 auto;
        width: 100%;
        height: 3.5rem;
        line-height: 3.5rem;
        border-bottom: 1px solid #eee;
    }

    .toc {
        position: fixed;
        top: 3.6rem;
        left: 0;
        bottom: 0;
        width: 20rem;
        margin: 0;
        background-color: #fff;
        border-right: 1px solid #eaecef;
        text-align: left;
    }

    .main-body {
        padding-left: 20rem;
        text-align: left;
    }

    .body-wrapper {
        max-width: 740px;
        margin: 0 auto;
        padding: 2rem 2.5rem;
    }

    .note-label {
        display: flex;
        justify-content: space-between;
        padding: 4px 15px;
        border-top: 1px solid #eee;
    }

    .note-pos {
        margin: 6px 0;
        font-size: 0.6em;
        padding: 0 4px;
        border-radius: 5px;
        background-color: #ccc;
    }

    .note-content {
        border-radius: 3px;
        margin-bottom: 20px;
        padding: 15px;
        background: #f9f9f9;
        border-left: 3px solid #eee;
        text-align: left;
    }
</style>
