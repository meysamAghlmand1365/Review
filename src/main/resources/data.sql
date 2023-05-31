INSERT INTO provider_tbl (name,city) VALUES ('diji_kala', 'Tehran');
INSERT INTO provider_tbl (name,city) VALUES ('Golrang', 'Tehran');

INSERT INTO product_tbl (provider_id,name,description,representable,public_comment_active,public_rate_active) VALUES (1,'cell phone', 'smart phone',true,true,true);
INSERT INTO product_tbl (provider_id,name,description,representable,public_comment_active,public_rate_active) VALUES (1,'cell phone 2', 'smart phone,foldable',true,true,true);




INSERT INTO user_tbl (username,password,first_name,last_name) VALUES ('ma_agh', '12345','meysam','aghlmand');
INSERT INTO user_tbl (username,password,first_name,last_name) VALUES ('mh_dfc', '12345','hamid','torabi');

INSERT INTO rate_tbl (product_id,confirm_status,rate_number,user_id,created_date,created_time) VALUES (1, false,3,2, '2020-09-17' ,'17:45:52');
INSERT INTO rate_tbl (product_id,confirm_status,rate_number,user_id,created_date,created_time) VALUES (1, true,3,2, '2020-09-17' ,' 19:47:52');
INSERT INTO rate_tbl (product_id,confirm_status,rate_number,user_id,created_date,created_time) VALUES (1, true,5,1, '2022-09-15','18:47:52');
INSERT INTO rate_tbl (product_id,confirm_status,rate_number,user_id,created_date,created_time) VALUES (1, true,3,2, '2021-09-17', '10:47:52');
INSERT INTO rate_tbl (product_id,confirm_status,rate_number,user_id,created_date,created_time) VALUES (1, true,4,2, '2021-09-17', '18:47:52');
INSERT INTO rate_tbl (product_id,confirm_status,rate_number,user_id,created_date,created_time) VALUES (1, true,3,1, '2021-04-15' ,'18:47:52');
INSERT INTO rate_tbl (product_id,confirm_status,rate_number,user_id,created_date,created_time) VALUES (2, false,3,1, '2023-04-15' ,'18:47:52');



INSERT INTO comment_tbl (product_id,confirm_status,content,user_id,created_date,created_time) VALUES (1, false,'Hi there what r u doing',2, '2020-09-17','17:45:52');
INSERT INTO comment_tbl (product_id,confirm_status,content,user_id,created_date,created_time) VALUES (1, true,'this is me.....',2, '2020-09-17','19:47:52');
INSERT INTO comment_tbl (product_id,confirm_status,content,user_id,created_date,created_time) VALUES (1, true,'what are you talking about man?',1, '2022-09-15','18:47:52');
INSERT INTO comment_tbl (product_id,confirm_status,content,user_id,created_date,created_time) VALUES (1, true,'when you see the product at first glance',2, '2021-09-17','10:47:52');
INSERT INTO comment_tbl (product_id,confirm_status,content,user_id,created_date,created_time) VALUES (2, true,'spring boot project',2, '2021-09-17','18:47:52');
INSERT INTO comment_tbl (product_id,confirm_status,content,user_id,created_date,created_time) VALUES (1, true,'every lie will be revealed.....',1, '2021-04-15','18:47:52');
INSERT INTO comment_tbl (product_id,confirm_status,content,user_id,created_date,created_time) VALUES (2, false,'so who is reading my message to confirm???',1, '2023-04-15','18:47:52');








