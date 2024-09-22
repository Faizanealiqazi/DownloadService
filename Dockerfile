# Use Ubuntu as the base image
FROM ubuntu:22.04

# Install OpenJDK 17
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get clean;

# Set environment variable for the JAR file
ARG JAR_FILE=target/DownloadService-0.0.1-SNAPSHOT.jar

# Create app directory
RUN mkdir /app

# Copy JAR file into the app directory
COPY ${JAR_FILE} /app/DownloadService.jar

# Set working directory
WORKDIR /app

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "DownloadService.jar"]
