server:
  port: ${config.port?c}
spring:
  datasource:
    type: com.zaxxer.hikari.HikariDataSource
    <#if config.type == 'H2'>
    driver-class-name: org.h2.Driver
    url: jdbc:h2:file:~/.halo/db/halo
    username: ${config.username!}
    password: ${config.password!}
    <#else>
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/halodb?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true
    username: ${config.username!}
    password: ${config.password!}
    </#if>

  # H2 Database 的控制台相关配置，如果你使用的是 MySQL ，请注释掉下方内容。
  h2:
    console:
      settings:
        web-allow-others: false
      path: /h2-console
      enabled: false
