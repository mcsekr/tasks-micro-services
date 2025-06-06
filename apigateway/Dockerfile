FROM openjdk:8-jdk-alpine

COPY target/*.jar /usr/local/application/app.jar

ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8091","-Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true","-jar","/usr/local/application/app.jar"]
