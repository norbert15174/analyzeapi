FROM openjdk:17-jdk-slim
COPY target/analyzeapi-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["bash", "-c", "java -Dfile.encoding=utf8 -jar analyzeapi-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080