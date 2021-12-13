# SBMS-Resilience4j
Spring Boot Micro Services Resilience4j Example Resolve the fault tolerance problem/Circuit breaker problem


Run below spring boot project and use below mentioned url on browser or postman 
01-order-service
02-item-service

http://localhost:8181/itemService/item/watch
http://localhost:9191/orderService/order/watch

once you test these are communicate properly then you can down the the itemService server and then 
test the circuite breaker / resilience problem resolve or not and

check simultenously below url for health check and it show the status of your service and state many more details which is configured in application file.

http://localhost:9191/orderService/actuator/health


