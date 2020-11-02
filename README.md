### springboot、security、mybatis-plus单体项目脚手架

#### 核心依赖

依赖 | 版本
---|---
Spring Boot |  2.3.4.RELEASE
Mybatis Plus | 3.3.2
hutool | 4.5.7

#### 目的
网上找了一圈，没有找到只用security的简单脚手架，就自己搭一个。可以直接启动填充业务代码。

#### 版本迭代记录：
1. 初始版本只使用security，重新定义了login接口，路径：/admin/login，返回token

TODO:
    
    1. 集成oauth2
    
    2. 添加一些基础数据增删改接口
