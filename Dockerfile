FROM openjdk:8-jdk-alpine
VOLUME /app
EXPOSE 8080
RUN mkdir -p /app/
ADD target/employee-0.0.1-SNAPSHOT.jar /app/employee.jar
ENTRYPOINT ["java", "-jar", "/app/employee.jar"]

