# Stage 1: Build the application
FROM maven:3.8.8-eclipse-temurin-17-alpine AS buildWORKDIR /app
# Copy Maven/Gradle wrapper and config
COPY .mvn/ .mvn/
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
