create database aspire_user;
use aspire_user;
drop table if exists user;
create table user (
id char(32) not null
, username varchar(50) not null
, password varchar(32) not null
, phone char(11) not null
, nickname varchar(50) not null
, email varchar(50)
, isObsolete tinyint(1) not null
, createdOn datetime not null
, createdBy varchar(50) not null
, updatedOn datetime not null
, updatedBy varchar(50) not null
, version int not null
, primary key (id)
) engine=Innodb, charset=utf8;