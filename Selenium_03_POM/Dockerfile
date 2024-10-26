Certainly! Below is the corrected version of your Dockerfile. The main changes include using relative paths for the COPY command and ensuring that the syntax is compatible with the Docker environment.

Corrected Dockerfile
# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the application JAR file into the container
COPY Selenium_03_POM/target/Selenium_03_POM-0.0.1-SNAPSHOT.jar /app/Selenium_03_POM-0.0.1-SNAPSHOT.jar

# Install Tomcat
RUN apt-get update && \
    apt-get install -y wget && \
    wget https://downloads.apache.org/tomcat/tomcat-10/v10.1.0/bin/apache-tomcat-10.1.0.tar.gz && \
    tar -xvzf apache-tomcat-10.1.0.tar.gz && \
    mv apache-tomcat-10.1.0 tomcat && \
    rm apache-tomcat-10.1.0.tar.gz

# Expose the port Tomcat runs on
EXPOSE 10400

# Start Tomcat
CMD ["sh", "/app/tomcat/bin/catalina.sh", "run"]