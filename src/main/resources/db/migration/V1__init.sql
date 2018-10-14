CREATE TABLE pwned_passwords (
  prefix INT  NOT NULL,
  suffix BYTEA   NOT NULL,
  count  INTEGER NOT NULL
)
-- CREATE INDEX ON pwned_passwords (prefix);
-- Create index after data set ends
-- It takes much less time to build an index in one pass