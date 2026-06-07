# week6作业
学号：42435014  
姓名：唐小欢

## 项目简介
基于SpringBoot+JdbcTemplate+MySQL实现学生信息管理系统，完成学生数据的增删改查与基础查询统计。

## 实现功能
1. 搭建SpringBoot项目，配置MySQL数据库连接与JdbcTemplate
2. 使用Navicat执行SQL脚本，创建学生表并初始化测试数据
3. 通过Controller、Service、Repository分层实现依赖注入
4. 使用JdbcTemplate完成学生信息新增、查询、修改、删除操作
5. 提供前端页面和REST接口，支持浏览器访问与数据管理

## 启动
先执行`sql/schema.sql`和`sql/data.sql`初始化数据库，修改`application.yml`中的数据库用户名和密码后启动项目，访问`http://localhost:8080`进入学生信息管理系统。
