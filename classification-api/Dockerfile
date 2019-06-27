FROM openjdk:11-jre-slim
ADD target/classification-api-0.1.jar classification-api-0.1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "classification-api-0.1.jar"]
