drop table if exists CITYINFO;
drop table if exists PHONE;
drop table if exists HOBBY;
drop table if exists ADDRESS;
drop table if exists INFOENTITY;
drop table if exists COMPANY;
drop table if exists PERSON;

create table PERSON(
PERSONID int auto_increment,
FIRSTNAME varchar(45),
LASTNAME varchar(45),
primary key (PERSONID)
);
create table COMPANY(
COMPANYID int,
COMPANYNAME varchar(45),
COMPANYDESCRIPTION varchar(80),
CVR int,
NUMEMPLOYEES int,
MARKETVALUE double,
primary key (COMPANYID)
);
alter table COMPANY auto_increment = 1000;

create table INFOENTITY(
ID int,
email varchar(45),
primary key (ID),
CONSTRAINT fk1 FOREIGN KEY (ID) REFERENCES  PERSON (PERSONID),
CONSTRAINT fk2 FOREIGN KEY (ID) REFERENCES  COMPANY (COMPANYID)
);

create table ADDRESS(
ADDRESSID int,
ID int,
STREET varchar(45),
STREETNUMBER int,
primary key (ADDRESSID),
foreign key (ID) references INFOENTITY(ID)
);

create table HOBBY(
HOBBYID int,
PERSONID int,
HOBBYNAME varchar(45),
HOBBYDESCRIPTION varchar(80),
primary key (HOBBYID),
foreign key (PERSONID) references PERSON(PERSONID)
);
create table PHONE(
PHONENUMBER int,
DESCRIPTION varchar(45),
primary key (PHONENUMBER)
);
create table CITYINFO(
ZIP int,
CITY varchar(45),
primary key (zip)
);
