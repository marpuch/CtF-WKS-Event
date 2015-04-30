CREATE TABLE vict_users (
  login VARCHAR(100) NOT NULL,
  pass_encryption_method VARCHAR(10) NOT NULL,
  password VARCHAR(100) NOT NULL,
  full_name VARCHAR(100) NULL,
  pass_reminder VARCHAR(1000) NULL,
  PRIMARY KEY (login))
;