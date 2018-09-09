FROM tomcat:9.0.10
EXPOSE 8090
COPY target/*.war /opt/apache-tomcat-9.0.10/webapps/
