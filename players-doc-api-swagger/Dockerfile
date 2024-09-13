FROM eclipse-temurin:17

WORKDIR /app

COPY target/players-doc-api-swagger-0.0.1-SNAPSHOT.jar /app/players-doc-api-swagger.jar

ENTRYPOINT ["java", "-jar", "players-doc-api-swagger.jar"]