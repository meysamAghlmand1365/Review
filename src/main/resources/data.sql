INSERT INTO provider_tbl (id,name,city) VALUES (1,'diji_kala', 'Tehran');
INSERT INTO provider_tbl (id,name,city) VALUES (2,'Golrang', 'Tehran');

INSERT INTO product_tbl (id,provider_id,name,description,representable,public_comment_active,public_rate_active) VALUES (1,1,'cell phone', 'smart phone',true,true,true);
INSERT INTO product_tbl (id,provider_id,name,description,representable,public_comment_active,public_rate_active) VALUES (2,1,'cell phone 2', 'smart phone,foldable',true,true,true);




INSERT INTO user_tbl (id,username,password,first_name,last_name) VALUES (1,'ma_agh', '12345','meysam','aghlmand');
INSERT INTO user_tbl (id,username,password,first_name,last_name) VALUES (2,'mh_dfc', '12345','hamid','torabi');

INSERT INTO rate_tbl (id,product_id,confirm_status,rate_number,user_id,created_date) VALUES (1,1, false,3,2,{ts '2020-09-17 17:45:52'});
INSERT INTO rate_tbl (id,product_id,confirm_status,rate_number,user_id,created_date) VALUES (2,1, true,3,2,{ts '2020-09-17 19:47:52'});
INSERT INTO rate_tbl (id,product_id,confirm_status,rate_number,user_id,created_date) VALUES (3,1, true,5,1,{ts '2022-09-15 18:47:52'});
INSERT INTO rate_tbl (id,product_id,confirm_status,rate_number,user_id,created_date) VALUES (4,1, true,3,2,{ts '2021-09-17 10:47:52'});
INSERT INTO rate_tbl (id,product_id,confirm_status,rate_number,user_id,created_date) VALUES (5,1, true,4,2,{ts '2021-09-17 18:47:52'});
INSERT INTO rate_tbl (id,product_id,confirm_status,rate_number,user_id,created_date) VALUES (6,1, true,3,1,{ts '2021-04-15 18:47:52'});
INSERT INTO rate_tbl (id,product_id,confirm_status,rate_number,user_id,created_date) VALUES (7,2, false,3,1,{ts '2023-04-15 18:47:52'});



INSERT INTO comment_tbl (id,product_id,confirm_status,content,user_id,created_date) VALUES (1,1, false,'Hi there what r u doing',2,{ts '2020-09-17 17:45:52'});
INSERT INTO comment_tbl (id,product_id,confirm_status,content,user_id,created_date) VALUES (2,1, true,'this is me.....',2,{ts '2020-09-17 19:47:52'});
INSERT INTO comment_tbl (id,product_id,confirm_status,content,user_id,created_date) VALUES (3,1, true,'what are you talking about man?',1,{ts '2022-09-15 18:47:52'});
INSERT INTO comment_tbl (id,product_id,confirm_status,content,user_id,created_date) VALUES (4,1, true,'when you see the product at first glance',2,{ts '2021-09-17 10:47:52'});
INSERT INTO comment_tbl (id,product_id,confirm_status,content,user_id,created_date) VALUES (5,2, true,'spring boot project',2,{ts '2021-09-17 18:47:52'});
INSERT INTO comment_tbl (id,product_id,confirm_status,content,user_id,created_date) VALUES (6,1, true,'every lie will be revealed.....',1,{ts '2021-04-15 18:47:52'});
INSERT INTO comment_tbl (id,product_id,confirm_status,content,user_id,created_date) VALUES (7,2, false,'so who is reading my message to confirm???',1,{ts '2023-04-15 18:47:52'});








