# Pwned Password Checker
In progress. Readme file not ready.

## Requirements
- wget
- p7zip
```
Centos: yum install p7zip p7zip-plugins
Arch: pacman -S p7zip
```
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