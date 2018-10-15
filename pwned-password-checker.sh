#!/bin/bash

echo -n "Password:"
read -s PASSWORD
echo

SHA_SUM=$(printf %s "$PASSWORD" | sha1sum)

PREFIX=$(echo $SHA_SUM | cut -c1-5 | awk '{print toupper($0)}')
SUFFIX=$(echo $SHA_SUM | cut -c6-40 | awk '{print toupper($0)}')

RESULT=$(curl -H "Accept: text/plain" -k -s https://localhost:8080/range/$PREFIX | grep $SUFFIX)

if [ ${#RESULT} -ge 36 ]; then
  PWND_TIMES=$(echo $RESULT | cut -c37- | xargs)

  printf "This password has been pwned several times: %s\n" "$PWND_TIMES"
  echo -n -e "\a"
  exit -1
else
  echo "Password not pwned - but there is no guarantee that it is a good password."
fi