FROM openjdk:8-jdk-alpine
MAINTAINER baraka
COPY target/docker-baraka-assignment-0.0.1-SNAPSHOT.jar baraka-assignment-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/baraka-assignment-0.0.1-SNAPSHOT.jar"]