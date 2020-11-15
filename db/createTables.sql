
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

CREATE TABLE FINITE_GROUPS (
 GROUP_CODE VARCHAR (25) PRIMARY KEY ,
 GROUP_DESC VARCHAR (100)
);

CREATE TABLE FINITE_VALUES (
  VALUE_CODE VARCHAR (25) PRIMARY KEY ,
  VALUE_DESC VARCHAR (200) NOT NULL,
  GROUP_CODE VARCHAR (25) NOT NULL,
  FOREIGN KEY (GROUP_CODE) REFERENCES FINITE_GROUPS(GROUP_CODE)

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


CREATE TABLE ENTITIES(
ENTITY_NAME VARCHAR(50) PRIMARY KEY,
HAS_SUB BOOLEAN DEFAULT FALSE,
CLASSNAME VARCHAR(200),
SERVICENAME VARCHAR(200),
VALIDATORNAME VARCHAR(200),
PK_TYPE VARCHAR(30),
PARENT_ENTITY VARCHAR(50),
DESCRIPTION VARCHAR(200),
CREATED_DATE DATETIME,
LAST_UPDATED_DATE DATETIME,
CREATED_BY VARCHAR(50),
LAST_UPDATED_BY VARCHAR(50),
FOREIGN KEY (PARENT_ENTITY) REFERENCES ENTITIES(ENTITY_NAME)
)


CREATE TABLE ENTITY_FIELDS(
ID INT PRIMARY KEY AUTO_INCREMENT,
ENTITY_NAME VARCHAR(50) NOT NULL,
FIELD_NAME VARCHAR(50) NOT NULL,
IS_PK BOOLEAN DEFAULT FALSE,
IS_BK BOOLEAN DEFAULT FALSE,
IS_MANDATORY BOOLEAN DEFAULT FALSE,
DESCRIPTION VARCHAR(200),
LIST_PAGE_BV VARCHAR(50),
EDIT_PAGE_BV VARCHAR(50),
ADD_PAGE_BV VARCHAR(50),
UI_LABEL_KEY VARCHAR(50),
UI_LABEL_VALUE VARCHAR(50),
JSON_TAG VARCHAR(50),
SHOW_INFILTER BOOLEAN DEFAULT FALSE,
DISPLAY_CONTROL VARCHAR(50),
VALUE_POPULATOR VARCHAR(750),
SCREEN_WIDTH INT,
SEQ_POS INT,
CREATED_DATE DATETIME,
LAST_UPDATED_DATE DATETIME,
CREATED_BY VARCHAR(50),
LAST_UPDATED_BY VARCHAR(50),
FOREIGN KEY (ENTITY_NAME) REFERENCES ENTITIES(ENTITY_NAME)
);

CREATE TABLE ENTITY_VALIDATIONS
(
ID INT PRIMARY KEY AUTO_INCREMENT,
ENTITY_NAME VARCHAR(50) NOT NULL,
FIELD_NAME VARCHAR(50) NOT NULL,
VALIDATION_TYPE VARCHAR(50) NOT NULL,
FV_GROUP  VARCHAR (25),
REF_ENTITY VARCHAR(50),
REF_FIELD VARCHAR(50),
PARAMS VARCHAR(250),
CREATED_DATE DATETIME,
LAST_UPDATED_DATE DATETIME,
CREATED_BY VARCHAR(50),
LAST_UPDATED_BY VARCHAR(50),
FOREIGN KEY (ENTITY_NAME) REFERENCES ENTITIES(ENTITY_NAME)
);

)
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

 CREATE TABLE SCHEME_TYPES
 (
 ID INT PRIMARY KEY AUTO_INCREMENT,
 CODE VARCHAR(50) NOT NULL,
 DESCRIPTION VARCHAR(250) NOT NULL,
 FREQUENCY VARCHAR(25) NOT NULL,
 PRICE_MONEY NUMERIC(8,2) NOT NULL,
 NO_PARTICIPANTS NUMERIC(6) NOT NULL,
 IS_DELETED BOOLEAN DEFAULT FALSE,
 CREATED_DATE DATETIME,
 LAST_UPDATED_DATE DATETIME,
 CREATED_BY VARCHAR(50),
 LAST_UPDATED_BY VARCHAR(50),
 VERSION INT DEFAULT 1,
 FOREIGN KEY (FREQUENCY) REFERENCES FINITE_VALUES(VALUE_CODE)
 );

 CREATE TABLE SCHEMES
 (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  CODE VARCHAR(50) NOT NULL,
  DESCRIPTION VARCHAR(250) NOT NULL,
  SCHEME_TYPE INT NOT NULL,
  STATUS VARCHAR(25) NOT NULL,
  START_DATE DATETIME NOT NULL,
  END_DATE DATETIME NOT NULL,
  NEXT_AUCTION_DATE DATETIME ,
  COMMENTS BLOB,
  IS_DELETED BOOLEAN DEFAULT FALSE,
  CREATED_DATE DATETIME,
  LAST_UPDATED_DATE DATETIME,
  CREATED_BY VARCHAR(50),
  LAST_UPDATED_BY VARCHAR(50),
  VERSION INT DEFAULT 1,
  FOREIGN KEY (STATUS) REFERENCES FINITE_VALUES(VALUE_CODE) ,
  FOREIGN KEY (SCHEME_TYPE) REFERENCES SCHEME_TYPES(ID)
 );