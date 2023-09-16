FROM ubuntu:latest
LABEL authors="diego"

# Use an official OpenJDK image as the base image
FROM openjdk:17

# Set the working directory
WORKDIR app

# Copy the packaged Spring Boot JAR file into the container
COPY target/rinha_backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot application uses
EXPOSE 8080

# Defina variáveis de ambiente para configurar o banco de dados (substitua pelos valores corretos)
#ENV DB_URL=postgres://postgresql:RXWhBNTx0V2sSJAIUEnHinIuAAg6hXmz@dpg-ck2evjb6fquc73cahkpg-a/new_rinha_backend_efia
#ENV DB_USERNAME=postgresql
#ENV DB_PASSWORD=RXWhBNTx0V2sSJAIUEnHinIuAAg6hXmz
ENV DB_URL=${URL}
ENV DB_USERNAME=${USERNAME}
ENV DB_PASSWORD=${PASSWORD}

#Spring boot final build name and localization on target

#ADD target/the-pink-project.jar the-pink-project.jar

#Sprint entrypoint

#ENTRYPOINT ["java", "-jar", "/app.jar"]

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]

ENTRYPOINT ["top", "-b"]