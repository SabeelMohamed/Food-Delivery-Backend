# Stage 1: Build the Spring Boot app
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/Food_Delivery-0.0.1-SNAPSHOT.jar Food_Delivery.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Food_Delivery.jar"]
