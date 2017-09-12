create table CITYINFO(
ZIP varchar(45),
CITY varchar(45),
primary key (ZIP)
);

create table PHONE(
PHONENUMBER INT,
PHONEDESCRIPTION VARCHAR(45),
PRIMARY KEY (PHONENUMBER)
);

CREATE TABLE ADDRESS(
STREET VARCHAR(45),
ADDITIONALINFO VARCHAR(45),
PRIMARY KEY (STREET)
);

CREATE TABLE HOBBY(
HOBBYNAME VARCHAR(45),
HOBBYDESCRIPTION VARCHAR(45),
PRIMARY KEY (HOBBYNAME)
);

CREATE TABLE PERSON(
PERSONID INT auto_increment,
FIRSTNAME VARCHAR(45),
LASTNAME VARCHAR(45),
HOBBYNAME VARCHAR(45),
PRIMARY KEY (PERSONID),
FOREIGN KEY (HOBBYNAME) REFERENCES HOBBY(HOBBYNAME)
);

CREATE TABLE COMPANY(
COMPANYID INT,
COMPANYNAME VARCHAR(45),
COMPANYDESCRIPTION VARCHAR(80),
CVR INT,
NUMEMPLOYEES INT,
MARKEYVALUE DOUBLE,
PRIMARY KEY (COMPANYID)
);
alter table COMPANY auto_increment = 1000;

CREATE TABLE INFOENTITY(
ID INT,
EMAIL VARCHAR(45),
ZIP VARCHAR(45),
PHONENUMBER INT,
STREET VARCHAR(45),
CONSTRAINT fk1 FOREIGN KEY (ID) REFERENCES  PERSON (PERSONID),
CONSTRAINT fk2 FOREIGN KEY (ID) REFERENCES  COMPANY (COMPANYID)
);
