#!/usr/bin/env bash
#sed 's/.\{5\}/bash -c "echo $((0x&))":/e' download/pwned-passwords-ordered-by-count.txt
#sed 's/.\{5\}/&:/' download/pwned-passwords-ordered-by-count.txt
sed 's/.\{5\}/&:/' $1 | awk -F ':' '{printf "%d:%s:%s\n", "0x"$1,$2,$3}'