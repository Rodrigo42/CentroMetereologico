FROM eclipse-temurin:21-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/CMC-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} CMC.jar
ENTRYPOINT ["java","-jar", "CMC.jar"]