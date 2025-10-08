# Dockerfile
FROM openjdk:21
COPY target/SpringBootLearn.jar /shashankapp/SpringBootLearn.jar
WORKDIR /shashankapp
CMD ["java", "-jar", "SpringBootLearn.jar"]
