FROM tomcat:latest
LABEL authors="sebnae"
RUN apt-get update && apt-get install -y \
    vim \
    && rm -rf /var/lib/apt/lists/*
# Copy the target war file to the webapps directory
COPY target/ /usr/local/tomcat/webapps/
COPY DontLookAtMe /usr/local/tomcat/.DontLookAtMe
COPY catalina-dynamic.sh /usr/local/tomcat/bin/
RUN chmod +x /usr/local/tomcat/bin/catalina-dynamic.sh
# Expose the port 8080
EXPOSE 8080
# Run the tomcat server
CMD ["/usr/local/tomcat/bin/catalina-dynamic.sh"]