FROM openjdk:11-jre-slim
EXPOSE 8082
VOLUME /tmp
COPY . .
ENTRYPOINT ["java","-jar","target/education-service-0.0.1-SNAPSHOT.jar"]