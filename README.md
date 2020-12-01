Demo for spring-cloud

## consul

Run consul locally
```
docker run --rm -p 8500:8500 -p 8600:8600/udp consul
```

```
# in consul
mvn spring-boot:run
# debug
mvn spring-boot:run -Dspring-boot.run.arguments=--logging.level.root=DEBUG
# enable heartbeat
# https://docs.spring.io/spring-cloud-consul/docs/2.2.4.RELEASE/reference/html/appendix.html
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.cloud.consul.discovery.heartbeat.enabled=true

curl localhost:8080
curl localhost:8080/actuator/health
```