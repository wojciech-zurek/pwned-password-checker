CREATE TABLE pwned_passwords(
  id bigserial PRIMARY KEY ,
  prefix VARCHAR (5) NOT NULL,
  suffix VARCHAR (15) NOT NULL,
  count bigint NOT NULL
);
CREATE INDEX ON pwned_passwords (prefix);