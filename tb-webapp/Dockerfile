FROM tomcat:10.1.20-jdk21-temurin-jammy
ADD https://dlm.mariadb.com/3700566/Connectors/java/connector-java-3.3.2/mariadb-java-client-3.3.2.jar /usr/local/tomcat/lib/
COPY docker/tomcat/web.xml /usr/local/tomcat/conf/Catalina/localhost/
COPY ./target/*web*.war /usr/local/tomcat/webapps/web.war