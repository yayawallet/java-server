FROM openjdk:11

VOLUME /tmp
EXPOSE 8080

WORKDIR /app

COPY build.gradle pom.xml ./

RUN gradle build

COPY app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]