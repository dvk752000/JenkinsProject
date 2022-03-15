FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar

# cd /opt/app
WORKDIR /build/libs

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080
# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]