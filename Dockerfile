FROM openjdk:21

LABEL authors="alexey"

ADD . /src

WORKDIR /src

RUN ./mvnw package -DskipTests

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "target/petproject-0.0.1-SNAPSHOT.jar"]