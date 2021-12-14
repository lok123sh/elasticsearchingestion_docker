FROM openjdk:11
MAINTAINER Lokesh kumar
ARG JAR_FILE=build/libs/ES-ingestion-docker-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ES-ingestion-docker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ES-ingestion-docker-0.0.1-SNAPSHOT.jar"]