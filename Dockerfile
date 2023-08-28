FROM amazoncorretto:17-alpine-jdk
VOLUME /order-service
RUN mkdir microservices
WORKDIR microservices
COPY target/order-service-0.0.1-SNAPSHOT.jar order-service.jar
ENTRYPOINT ["java","-jar","order-service.jar"]
EXPOSE 8085