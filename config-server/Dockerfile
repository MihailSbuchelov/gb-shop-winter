FROM openjdk:11.0.8-jre
ENV FOO=/tmp
WORKDIR ${FOO}
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "app.jar"]