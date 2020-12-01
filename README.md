Demo for spring-cloud

## consul

Run consul locally
```
docker run --rm -p 8500:8500 -p 8600:8600/udp consul
```

```
# in consul
mvn spring-boot:run

curl localhost:8080
curl localhost:8080/actuator/health
```