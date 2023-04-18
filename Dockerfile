FROM tomcat:latest
LABEL authors="sebnae"
RUN apt-get update && apt-get install -y \
    vim \
    && rm -rf /var/lib/apt/lists/*
# Copy the target war file to the webapps directory
COPY target/ /usr/local/tomcat/webapps/
# Expose the port 8080
EXPOSE 8080
# Run the tomcat server
CMD ["catalina.sh", "run"]