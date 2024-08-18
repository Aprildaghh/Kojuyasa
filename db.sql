drop schema if exists `kojuyasa`;
create schema `kojuyasa`;
use `kojuyasa`;

drop table if exists `game`;

create table `game` (
	id int primary key auto_increment not null,
    title varchar(100) not null,
	finished boolean
);

drop table if exists `anime`;

create table `anime` (
	id int primary key auto_increment not null,
    title varchar(100) not null,
	release_date date,
    finished boolean
);

drop table if exists `movies`;

create table `movies` (
	id int primary key auto_increment not null,
    title varchar(100) not null,
	release_date date,
    finished boolean
);

drop table if exists `series`;

create table `series` (
	id int primary key auto_increment not null,
    title varchar(100) not null,
	release_date date,
    season_count int,
    finished boolean
);