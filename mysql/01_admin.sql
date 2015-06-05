create user victim@localhost identified by 'calineczka';
create database victim_resource;
create database victim_connect;
grant create view on victim_connect.* to 'victim'@'localhost';
revoke all privileges on test.* from 'victim'@'localhost';

CREATE TABLE `victim_resource`.`t_vict_users` (
  `login` VARCHAR(100) NOT NULL,
  `pass_encryption_method` ENUM('NONE', 'MD5', 'BCRYPT', 'BCRYPTP') NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `full_name` VARCHAR(100) NULL,
  `pass_reminder` VARCHAR(1000) NULL,
  PRIMARY KEY (`login`))
ENGINE = MyISAM;

CREATE TABLE `victim_resource`.`t_private_data` (
  `login` VARCHAR(100) NOT NULL,
  `text` VARCHAR(4000) NOT NULL,
  PRIMARY KEY (`login`))
ENGINE = MyISAM;

CREATE TABLE `victim_resource`.`t_portfolio` (
  `mode` VARCHAR(10) NOT NULL,
  `text` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`mode`))
ENGINE = MyISAM;

CREATE TABLE `victim_resource`.`t_blog_comments` (
  `tstmp` TIMESTAMP NOT NULL,
  `name` VARCHAR(100) NULL,
  `text` VARCHAR(4000) NULL)
ENGINE = MyISAM;

grant select on t_vict_users to 'victim'@'localhost';
grant select on t_portfolio to 'victim'@'localhost';
grant select on t_private_data to 'victim'@'localhost';
grant select, insert, delete on t_blog_comments to 'victim'@'localhost';
