FROM openjdk:21

LABEL authors="alexey"

WORKDIR /opt

COPY out/artifacts/petproject_jar/petproject.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]