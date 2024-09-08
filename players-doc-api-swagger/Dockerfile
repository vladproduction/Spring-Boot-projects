FROM eclipse-temurin:17

LABEL mentainer="vladproduction.net@gmail.com"

WORKDIR /app

COPY target/players-doc-api-swagger-0.0.1-SNAPSHOT.jar /app/player-clubs.jar

ENTRYPOINT ["java", "-jar", "player-clubs.jar"]