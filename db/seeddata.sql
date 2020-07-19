insert into companies (ID,COMPANY_CODE,COMPANY_NAME)  values (1,'DMCHIT','Demo Chit Funds');

insert into bo_users (user_id,company_id,password,phone,email) values( 'boadmin',1,'password','77869591','unnidev1978@gmail.com')
update bo_users set first_name = 'Alok' , last_name = 'Singh' where user_id = 'boadmin'

INSERT INTO APPLICATION (APP_NAME,APP_DISPLAY) VALUES ('BOCHIT','Backoffice-OnlineChits');

INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Dashboard','./bodashboard.html',
'fas fa-home text-light fa-lg mr-3');

INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Scheme Types','./autocode.html',
'fas fa-address-card text-light fa-lg mr-3');
INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Brands','./autocode.html',
'fas fa-gopuram text-light fa-lg mr-3');
INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Schemes','./autocode.html',
'fas fa-envelope text-light fa-lg mr-3');
INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Customers','./autocode.html',
'fas fa-user text-light fa-lg mr-3');
INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Reports','./autocode.html',
'fas fa-file-alt text-light fa-lg mr-3');
INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Analytics','./autocode.html',
'fas fa-chart-bar text-light fa-lg mr-3');
INSERT INTO APPLICATION_MENUS (APP_NAME,MENU_TITLE,HTML_FILE,DISPLAY_CLASS) VALUES ('BOCHIT','Configuration','./autocode.html',
'fas fa-wrench text-light fa-lg mr-3');