FROM tomcat:9.0.10
EXPOSE 9090:90
COPY target/*.war /opt/apache-tomcat-9.0.10/webapps/
CMD ["sh", "bin/startup.sh"]
