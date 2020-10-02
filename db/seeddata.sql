insert into companies (ID,COMPANY_CODE,COMPANY_NAME)  values (1,'DMCHIT','Demo Chit Funds');

insert into bo_users (user_id,company_id,password,phone,email) values( 'boadmin',1,'password','77869591','unnidev1978@gmail.com')
update bo_users set first_name = 'Alok' , last_name = 'Singh' where user_id = 'boadmin'

INSERT INTO APPLICATION (APP_NAME,APP_DISPLAY) VALUES ('BOCHIT','Backoffice-OnlineChits');

INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Dashboard','./bodashboard.html',
'fas fa-home text-light fa-lg mr-3');

INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Scheme Types','./autocode.html',
'fas fa-address-card text-light fa-lg mr-3');
INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Brands','./autocode.html?entity=Brand',
'fas fa-gopuram text-light fa-lg mr-3');
INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Schemes','./autocode.html?entity=Scheme',
'fas fa-envelope text-light fa-lg mr-3');
INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Customers','./autocode.html?entity=Customer',
'fas fa-user text-light fa-lg mr-3');
INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Reports','./autocode.html',
'fas fa-file-alt text-light fa-lg mr-3');
INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Analytics','./autocode.html',
'fas fa-chart-bar text-light fa-lg mr-3');
INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Configuration','./autocode.html',
'fas fa-wrench text-light fa-lg mr-3');

INSERT INTO ENTITIES (ENTITY_NAME,HAS_SUB,CLASSNAME,PK_TYPE) VALUES ('Brand',false,'com.primus.brands.model.Brand','ID')

INSERT INTO entity_fields (ENTITY_NAME,FIELD_NAME,IS_PK, IS_BK, IS_MANDATORY, LIST_PAGE_BV, EDIT_PAGE_BV,  ADD_PAGE_BV, UI_LABEL_KEY,UI_LABEL_VALUE,JSON_TAG,DISPLAY_CONTROL,VALUE_POPULATOR,SCREEN_WIDTH,SEQ_POS)
VALUES( 'Brand','Id',true,false,false,'IGNORE','HIDE','IGNORE','Id','Id','Id','Hidden',null,20,1)
INSERT INTO entity_fields (ENTITY_NAME,FIELD_NAME,IS_PK, IS_BK, IS_MANDATORY, LIST_PAGE_BV, EDIT_PAGE_BV,  ADD_PAGE_BV, UI_LABEL_KEY,UI_LABEL_VALUE,JSON_TAG,DISPLAY_CONTROL,VALUE_POPULATOR,SCREEN_WIDTH,SEQ_POS)
VALUES( 'Brand','Code',false,true,true,'SHOW','READONLY','SHOW','Code','Code','Code','Text',null,20,2)
INSERT INTO entity_fields (ENTITY_NAME,FIELD_NAME,IS_PK, IS_BK, IS_MANDATORY, LIST_PAGE_BV, EDIT_PAGE_BV,  ADD_PAGE_BV, UI_LABEL_KEY,UI_LABEL_VALUE,JSON_TAG,DISPLAY_CONTROL,VALUE_POPULATOR,SCREEN_WIDTH,SEQ_POS)
VALUES( 'Brand','Name',false,false,true,'SHOW','SHOW','SHOW','Brand','Brand','Name','Text',null,50,3)
INSERT INTO entity_fields (ENTITY_NAME,FIELD_NAME,IS_PK, IS_BK, IS_MANDATORY, LIST_PAGE_BV, EDIT_PAGE_BV,  ADD_PAGE_BV, UI_LABEL_KEY,UI_LABEL_VALUE,JSON_TAG,DISPLAY_CONTROL,VALUE_POPULATOR,SCREEN_WIDTH,SEQ_POS)
VALUES( 'Brand','Description', false,false,false,'SHOW','SHOW','SHOW','Description','Description','Description','Text',null,100,4)
INSERT INTO entity_fields (ENTITY_NAME,FIELD_NAME,IS_PK, IS_BK, IS_MANDATORY, LIST_PAGE_BV, EDIT_PAGE_BV,  ADD_PAGE_BV, UI_LABEL_KEY,UI_LABEL_VALUE,JSON_TAG,DISPLAY_CONTROL,VALUE_POPULATOR,SCREEN_WIDTH,SEQ_POS)
VALUES( 'Brand','Email',false,false,true,'SHOW','SHOW','SHOW','Email','Email','Email','Email',null,30,5)
INSERT INTO entity_fields (ENTITY_NAME,FIELD_NAME,IS_PK, IS_BK, IS_MANDATORY, LIST_PAGE_BV, EDIT_PAGE_BV,  ADD_PAGE_BV, UI_LABEL_KEY,UI_LABEL_VALUE,JSON_TAG,DISPLAY_CONTROL,VALUE_POPULATOR,SCREEN_WIDTH,SEQ_POS)
VALUES( 'Brand','Phone',false,false,true,'SHOW','SHOW','SHOW','Phone','Phone','Phone','Text',null,30,6)
INSERT INTO entity_fields (ENTITY_NAME,FIELD_NAME,IS_PK, IS_BK, IS_MANDATORY, LIST_PAGE_BV, EDIT_PAGE_BV,  ADD_PAGE_BV, UI_LABEL_KEY,UI_LABEL_VALUE,JSON_TAG,DISPLAY_CONTROL,VALUE_POPULATOR,SCREEN_WIDTH,SEQ_POS)
VALUES( 'Brand','Version',false,false,true,'IGNORE','HIDE','IGNORE','','','Version','Hidden',null,30,8)