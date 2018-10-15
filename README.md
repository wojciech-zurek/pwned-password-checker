# Pwned Password Checker
In progress. Readme file not ready.

## Status

[![Build Status](https://travis-ci.org/wojciech-zurek/pwned-password-checker.svg?branch=master)](https://travis-ci.org/wojciech-zurek/pwned-password-checker)

## Requirements
- linux with bash ;)
- docker
- java 8 
- postgres with psql client (or postgres docker image)
- wget
- curl (for testing)
- p7zip
```
Centos: yum install p7zip p7zip-plugins
Arch: pacman -S p7zip
```
- awk
- sed
- make

## Status
Not completed

## Download

```bash
    git clone https://github.com/wojciech-zurek/pwned-password-checker.git
```

## Run with gradle

```bash
    cd pwned-password-checker/
    ./gradlew run
```

## Run as jar file

```bash
    cd pwned-password-checker/
    ./gradlew fatJar
    java -jar build/libs/pwned-password-checker-1.0.0.jar
```

## Test

```bash
    cd pwned-password-checker/
    ./gradlew clean test
```