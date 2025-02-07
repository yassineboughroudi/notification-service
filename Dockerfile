# Stage 1: Build the application
FROM maven:3.8.6-openjdk-17-slim AS build
WORKDIR /app
# Copy Maven/Gradle wrapper and config
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Copy the source code
COPY src ./src

# Build the application (skip tests if you prefer fast builds)
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the jar built in the previous stage. Adjust the jar name as necessary.


COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
