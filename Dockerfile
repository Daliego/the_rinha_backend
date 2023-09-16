# Use an official OpenJDK image as the base image
FROM openjdk:17

# Set the working directory
WORKDIR app

# Copy the packaged Spring Boot JAR file into the container
COPY target/rinha_backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot application uses
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

ENTRYPOINT ["top", "-b"]