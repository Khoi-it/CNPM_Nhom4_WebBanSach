# Use a JDK base image
FROM openjdk:21-jdk-slim

# Add a volume for logs
VOLUME /tmp

# Set the working directory
WORKDIR /app

# Copy build jar into container
COPY build/libs/*.jar app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
