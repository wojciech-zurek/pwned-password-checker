#!/usr/bin/env sh

./gradlew clean check assemble
docker build -t eu.wojciechzurek/pwned-password-checker:1.0.0 -t eu.wojciechzurek/pwned-password-checker:latest -f Dockerfile .