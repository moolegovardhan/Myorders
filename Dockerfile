FROM tomcat:9.0.10
EXPOSE 8080
COPY target/*.war /opt/apache-tomcat-9.0.10/webapps/
