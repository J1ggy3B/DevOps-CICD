# Use Tomcat Container
FROM tomcat:latest

# Set the working directory
WORKDIR /app

# Copy the application JAR file into the container
COPY Selenium_03_POM/target/Selenium_03_POM-0.0.1-SNAPSHOT.jar /app/Selenium_03_POM-0.0.1-SNAPSHOT.jar

# Expose the port Tomcat runs on
EXPOSE 10400

# Start Tomcat
CMD ["catalina.sh", "run"]