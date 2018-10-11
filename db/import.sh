#!/usr/bin/env sh

DB_NAME=pwned-passwords
DB_USER=pwned-passwords-db-owner
TABLE_NAME=pwned_passwords
FILE_PATH=download/pwned-passwords-ordered-by-count.txt

psql -U $DB_USER -c "\COPY $TABLE_NAME(prefix, suffix, count) FROM PROGRAM 'sed \"s/.\{5\}/&:/\" $FILE_PATH' delimiter ':' csv;" $DB_NAME