# Use an official Tomcat image as the base
FROM tomcat:10.1

# Set the working directory
WORKDIR /usr/local/tomcat/webapps

# Copy the war file to the Tomcat webapps directory
COPY target/Selenium_03_POM-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]
