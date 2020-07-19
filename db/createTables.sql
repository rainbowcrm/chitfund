
CREATE TABLE COMPANIES (
ID INT PRIMARY KEY AUTO_INCREMENT,
COMPANY_CODE VARCHAR(10) NOT NULL UNIQUE,
COMPANY_NAME VARCHAR(50) NOT NULL UNIQUE,
ADDRESS1 VARCHAR(50),
ADDRESS2 VARCHAR(50),
ZIPCODE VARCHAR(50),
CITY VARCHAR(50),
PHONE    VARCHAR(20),
IS_ACTIVE BOOLEAN DEFAULT TRUE ,
IS_DELETED BOOLEAN DEFAULT FALSE,
CREATED_DATE DATETIME,
LAST_UPDATED_DATE DATETIME,
CREATED_BY VARCHAR(50),
LAST_UPDATED_BY VARCHAR(50)
);


CREATE TABLE BO_USERS (
USER_ID VARCHAR(50) PRIMARY KEY,
COMPANY_ID INT,
PASSWORD VARCHAR(50) NOT NULL,
FIRST_NAME VARCHAR(50),
LAST_NAME VARCHAR(50),
PHONE VARCHAR(50) NOT NULL UNIQUE ,
EMAIL VARCHAR(50) NOT NULL UNIQUE,
CREATED_DATE DATETIME,
LAST_UPDATED_DATE DATETIME,
CREATED_BY VARCHAR(50),
LAST_UPDATED_BY VARCHAR(50)
);

CREATE TABLE APPLICATION (
APP_NAME VARCHAR(50) PRIMARY KEY,
APP_DISPLAY VARCHAR(50) NOT NULL
);

CREATE TABLE APPLICATION_MENUS
(
ID INT PRIMARY KEY AUTO_INCREMENT,
APP_NAME VARCHAR(50),
MENU_TITLE VARCHAR(50),
HTML_FILE VARCHAR(100),
DISPLAY_CLASS VARCHAR(100),
CREATED_DATE DATETIME,
LAST_UPDATED_DATE DATETIME,
CREATED_BY VARCHAR(50),
LAST_UPDATED_BY VARCHAR(50),
FOREIGN KEY (APP_NAME) REFERENCES APPLICATION(APP_NAME)
  );



  CREATE TABLE BRANDS
 (
 ID INT PRIMARY KEY AUTO_INCREMENT,
 CODE VARCHAR(50) NOT NULL,
 NAME VARCHAR (100) NOT NULL,
 DESCRIPTION VARCHAR(200),
 EMAIL VARCHAR(75),
 PHONE VARCHAR (50),
 IS_ACTIVE BOOLEAN DEFAULT FALSE,
 IS_PRODUCTION BOOLEAN DEFAULT FALSE,
 IS_DELETED BOOLEAN DEFAULT FALSE,
 CREATED_DATE DATETIME,
 LAST_UPDATED_DATE DATETIME,
 CREATED_BY VARCHAR(50),
 LAST_UPDATED_BY VARCHAR(50),
 VERSION INT DEFAULT 1
 );