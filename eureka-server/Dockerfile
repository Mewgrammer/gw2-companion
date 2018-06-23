FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/eureka-server-1.0.0.jar app.jar
CMD java -jar app.jar
EXPOSE 8761