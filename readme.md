本项目为spring-boot 简单教程项目

## 目录
### json-web-token 
使用spring security 结合jwt 组件完成jwt的验证 
### mongoDb
使用spring data mongodb 完成对 mongodb的操作
### spring security
提供以下功能
- 认证
- 授权
- 攻击防护

#### 基本原理
基于过滤器链来进行验证
- Username Password Authentication Filter
- Basic Authentication Filter
- Exception Translation Filter 处理spring security异常
- Filter Security Interceptor
