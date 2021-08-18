FROM openjdk:11-slim
MAINTAINER matheuscarv69

ARG JAR_FILE=target/poc-java-graphql-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]