FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/database-service-1.0.0.jar app.jar
CMD java -jar app.jar
EXPOSE 8090