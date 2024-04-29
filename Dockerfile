FROM gradle:4.7.0-jdk8-alpine AS build
COPY . /temp
RUN gradle build --no-daemon

COPY build/libs /tmp/build/libs

FROM openjdk:8-jdk
COPY . /tmp
EXPOSE 8080
ENTRYPOINT  ["java", "-jar", "/app.jar"]