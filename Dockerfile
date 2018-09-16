FROM tomcat:9.0.10
EXPOSE 9090:90
COPY target/*.war /usr/local/tomcat/webapps/
ENTRYPOINT "bin/startup.sh && catalina.sh run"

