create user victim@localhost identified by 'calineczka';
create database victim_resource;
create database victim_connect;
grant create view on victim_connect.* to 'victim'@'localhost';
revoke all privileges on test.* from 'victim'@'localhost';

CREATE TABLE `victim_resource`.`vict_users` (
  `login` VARCHAR(100) NOT NULL,
  `pass_encryption_method` ENUM('NONE', 'MD5', 'SHA1', 'BCRYPT') NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `full_name` VARCHAR(100) NULL,
  `pass_reminder` VARCHAR(1000) NULL,
  PRIMARY KEY (`login`))
ENGINE = MyISAM;

CREATE TABLE `victim_resource`.`public_items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `name` VARCHAR(1000) NOT NULL,
  `content` VARCHAR(4000) NULL,
  `link` VARCHAR(1000) NULL,
  `picture` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM;

CREATE TABLE `victim_resource`.`portfolio` (
  `mode` VARCHAR(10) NOT NULL,
  `text` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`mode`))
ENGINE = MyISAM;

grant select on public_items to 'victim'@'localhost';
grant select on vict_users to 'victim'@'localhost';
grant select on portfolio to 'victim'@'localhost';