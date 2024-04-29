FROM gradle:4.7.0-jdk8-alpine AS build
COPY . /temp
RUN gradle build --no-daemon

COPY build/libs /tmp/build/libs

FROM  java:8-jdk AS TEMP_BUILD_IMAGE
COPY . /tmp
EXPOSE 8080
ENTRYPOINT  ["java", "-jar", "/app.jar"]