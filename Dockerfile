# Stage 1: Build the Spring Boot app
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY fooddelivery/pom.xml .
COPY fooddelivery/src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
