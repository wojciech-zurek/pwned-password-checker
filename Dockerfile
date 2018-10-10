FROM openjdk:8-jdk-alpine
MAINTAINER Wojciech Żurek <mail@wojciechzurek.eu>

ENV APP_HOME /app
ENV APP pwned-password-checker.jar
ENV HTTPS true
ENV KEYSTORE_PASS "changeit"
ENV SPRING_PROFILES_ACTIVE = "development"

EXPOSE 8080

RUN mkdir -p $APP_HOME/cert

VOLUME /tmp
VOLUME $APP_HOME/cert

COPY build/libs/pwned-password-checker*.jar $APP_HOME/

WORKDIR $APP_HOME
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","$APP_HOME/$APP"]