# multi-swagger-demo

#### 介绍
展示多Swagger文档的Demo，包括：
* 静态文件显示
* 数据库动态拼接生成（展示重点，可利用其进行动态文档生成）
* 代码扫描生成

#### 主要依赖
* springfox-swagger：spring boot指定包，用于代码扫描
* swagger-models: swagger官方包，用以构造Swagger对象来拼接生成

#### 使用说明
1.  将代码下载至本地
2.  运行SpringBootWebApplication
3.  浏览器打开localhost:8080/swagger-ui.html进行查看

#### 注意事项
该项目虽提到数据库，但没有真正使用，目前是以模拟数据为例，若应用于生产，建议使用MongoDB之类的NoSQL数据库进行Swagger存储

#### 资料
* OpenAPI规范：https://openapi-map.apihandyman.io/

#### 参与贡献
1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request