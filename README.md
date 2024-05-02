# redis-begin
Learning about redis...

## redis setup done...
 - I have used docker to host redis
> $ sudo docker run -d -p 6379:6379 redis redis_begin
 - After that I have monitored redis cache
> $ sudo docker exec -it redis_begin redis-cli monitor
 - Finally, I followed a tutorial from medium.
>[Spring Boot Caching with Redis](https://medium.com/simform-engineering/spring-boot-caching-with-redis-1a36f719309f)
 - The caching system working fine :)
 - My **application.yml** file below...

```application.yml
spring:
  application:
    name: redis-begin

  cache:
    type: redis
    redis:
      host: localhost
      port: 6379
      time-to-live: 60000

  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/inventory
    username: postgres
    password: *********

  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
    show-sql: true 
    ```

