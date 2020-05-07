# [数据库](./DATASOURCE.md)

## [多数据源的配置](https://app.yinxiang.com/Home.action?login=true#n=46962cf5-4516-40ee-9206-6294bfa6762e&s=s51&ses=4&sh=2&sds=5&)

# [EPUB查看器](https://www.fviewer.com/zh/view-epub)
> 整合和集成：
  可以把云查看器集成到你的项目或网站里。本服务提供一个API，只要按照以下方式调用，传入文件URL，不需要编写任何代码，就可以在线查看文件内容。

测试：http://www.ofoct.com/viewer/viewer_url.php?&quality=low-resolution&fileurl=ftp%3A%2F%2F122.51.214.35%2Fpub%2Ftest.epub&filetype=epub


SpringBoot中mybatis配置mybatis.configuration.map-underscore-to-camel-case=true自动转换驼峰标识没有生效
查找原来是项目中使用了多数据源导致配置没有生效
解决方法：
http://yayihouse.com/yayishuwu/chapter/2338