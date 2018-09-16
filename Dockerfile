FROM tomcat:9.0.10
EXPOSE -p 9090:90
COPY target/*.war /opt/apache-tomcat-9.0.10/webapps/
