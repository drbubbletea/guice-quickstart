Moduile
API

Jobs

Webapp

Vagrant


# IntelliJ Remote Tomcat Server
Application server local: Tomcat 9.0.80

JMX Port: 7999

Remote Staging
- type: sftp
- host: GQS 192.168.56.10
- Path from root: /
- Mapped as: /home/tomcat

Remote Connection Settings
- Host: 192.168.56.10
- Port: 8080


GQS 192.168.56.10
- type: sftp
- ssh config: 182.168.56.10 tomcat/tomcat
- root path: /home/tomcat


## Applications
Vaadin webapp:
- `mvn clean install -Pproduction`