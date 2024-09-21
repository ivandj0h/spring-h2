# Start with a base image containing Java runtime
FROM openjdk:22-ea-10-jdk-slim as build

# Add Maintainer Info
LABEL maintainer="ivandi.djoh@gmail.com"

# Set the working directory in the Docker container
WORKDIR /app

# Copy the Maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Load all dependencies
RUN ./mvnw dependency:go-offline

# Copy your other files
COPY src src

# Build the application
RUN ./mvnw package -DskipTests

# Start with a new base image to create a clean image
FROM openjdk:22-ea-10-jdk-slim

WORKDIR /app

# Copy only the built jar and nothing else
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8000

# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]