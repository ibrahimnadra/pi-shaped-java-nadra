# Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the jar file from target/ to container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} playerService.jar

# Expose application port (update if not 8080)
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "playerService.jar"]
