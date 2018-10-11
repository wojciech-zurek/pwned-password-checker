FROM openjdk:8-jdk-alpine
MAINTAINER Wojciech Żurek <mail@wojciechzurek.eu>

ENV APP_HOME /app
ENV SPRING_PROFILES_ACTIVE = "docker, tls"
ENV JAVA_OPTS="-server -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -Xms128M -Xmx1024M"

EXPOSE 8080

RUN mkdir -p $APP_HOME/cert

VOLUME /tmp
VOLUME $APP_HOME/cert

COPY build/libs/pwned-password-checker-1.0.0.jar $APP_HOME/pwned-password-checker.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app/pwned-password-checker.jar"]