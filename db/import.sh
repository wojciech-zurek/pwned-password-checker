#!/usr/bin/env sh

DB_NAME=pwned-passwords
DB_USER=pwned-passwords-db-owner
TABLE_NAME=pwned_passwords
FILE_PATH=download/pwned-passwords-ordered-by-count.txt

psql -U $DB_USER -c "TRUNCATE TABLE pwned_passwords;" $DB_NAME
psql -U $DB_USER -c "DROP INDEX IF EXISTS pwned_passwords_prefix_idx;" $DB_NAME
psql -U $DB_USER -c "SET synchronous_commit TO OFF;" $DB_NAME
psql -U $DB_USER -c "ALTER TABLE pwned_passwords SET ( autovacuum_enabled = false, toast.autovacuum_enabled = false );" $DB_NAME
psql -U $DB_USER -c "\COPY $TABLE_NAME(prefix, suffix, count) FROM PROGRAM 'sed \"s/.\{5\}/&:/\" $FILE_PATH' delimiter ':' csv;" $DB_NAME
psql -U $DB_USER -c "ALTER TABLE pwned_passwords SET ( autovacuum_enabled = true, toast.autovacuum_enabled = true );" $DB_NAME
psql -U $DB_USER -c "CREATE INDEX ON pwned_passwords (prefix);" $DB_NAME
psql -U $DB_USER -c "SET synchronous_commit TO DEFAULT;" $DB_NAME