FROM openjdk:14-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} KnjizaraFrontendJava-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/KnjizaraFrontendJava-0.0.1-SNAPSHOT.war"]