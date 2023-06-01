INSERT INTO provider_tbl (name,city) VALUES ('diji_kala', 'Tehran');
INSERT INTO provider_tbl (name,city) VALUES ('Golrang', 'Tehran');

INSERT INTO product_tbl (provider_id,name,description,representable,public_comment_active,public_rate_active) VALUES (1,'cell phone', 'smart phone',true,true,true);
INSERT INTO product_tbl (provider_id,name,description,representable,public_comment_active,public_rate_active) VALUES (1,'cell phone 2', 'smart phone,foldable',true,true,true);
INSERT INTO product_tbl (provider_id,name,description,representable,public_comment_active,public_rate_active) VALUES (2,'smart watch', 'watch',true,false,true);




INSERT INTO user_tbl (username,password,first_name,last_name) VALUES ('ma_agh', '12345','meysam','aghlmand');
INSERT INTO user_tbl (username,password,first_name,last_name) VALUES ('mh_dfc', '12345','hamid','torabi');
INSERT INTO user_tbl (username,password,first_name,last_name) VALUES ('fgfdf_tuv', '3453','ali','hamidi');


INSERT INTO order_tbl (user_id,order_status,created_date) VALUES (3, 1,'2021-09-17');
INSERT INTO order_item_tbl (order_id,product_id,quantity) VALUES (1, 2,6);




INSERT INTO rate_tbl (product_id,status,rate_number,user_id,created_date,created_time) VALUES (1, 2,3,2, '2020-09-17' ,'17:45:52');
INSERT INTO rate_tbl (product_id,status,rate_number,user_id,created_date,created_time) VALUES (1, 1,3,2, '2020-09-17' ,'19:47:52');
INSERT INTO rate_tbl (product_id,status,rate_number,user_id,created_date,created_time) VALUES (2, 1,5,1, '2022-09-15','18:47:52');
INSERT INTO rate_tbl (product_id,status,rate_number,user_id,created_date,created_time) VALUES (3, 1,3,2, '2018-01-20', '10:47:52');
INSERT INTO rate_tbl (product_id,status,rate_number,user_id,created_date,created_time) VALUES (1, 1,4,2, '2021-09-17', '18:47:52');
INSERT INTO rate_tbl (product_id,status,rate_number,user_id,created_date,created_time) VALUES (1, 1,3,1, '2021-04-15' ,'18:47:52');
INSERT INTO rate_tbl (product_id,status,rate_number,user_id,created_date,created_time) VALUES (2, 2,3,1, '2023-04-15' ,'18:47:52');
INSERT INTO rate_tbl (product_id,status,rate_number,user_id,created_date,created_time) VALUES (1, 0,3,2, '2020-09-17' ,' 19:47:52');
INSERT INTO rate_tbl (product_id,status,rate_number,user_id,created_date,created_time) VALUES (3, 0,5,1, '2022-09-15','18:47:52');
INSERT INTO rate_tbl (product_id,status,rate_number,user_id,created_date,created_time) VALUES (1, 0,3,2, '2021-09-17', '10:47:52');
INSERT INTO rate_tbl (product_id,status,rate_number,user_id,created_date,created_time) VALUES (3, 2,4,2, '2021-09-17', '18:47:52');
INSERT INTO rate_tbl (product_id,status,rate_number,user_id,created_date,created_time) VALUES (1, 1,5,1, '2021-04-15' ,'18:47:52');
INSERT INTO rate_tbl (product_id,status,rate_number,user_id,created_date,created_time) VALUES (2, 1,3,1, '2023-04-15' ,'18:47:52');



INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (1, 2,'Hi there what r u doing',2, '2020-09-17','17:45:52');
INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (1, 0,'this is me.....',2, '2020-09-17','19:47:52');
INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (1, 1,'what are you talking about man?',1, '2022-09-15','18:47:52');
INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (1, 1,'when you see the product at first glance',2, '2021-09-17','10:47:52');
INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (2, 0,'spring boot project',2, '2021-09-17','18:47:52');
INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (1, 1,'every lie will be revealed.....',1, '2021-04-15','18:47:52');
INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (2, 2,'so who is reading my message to confirm???',1, '2023-04-15','18:47:52');
INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (2, 2,'Hi there what r u doing',2, '2020-09-17','17:45:52');
INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (1, 0,'this is me.....',2, '2022-09-17','19:47:52');
INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (2, 0,'what are you talking about man?',1, '2022-09-15','18:47:52');
INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (1, 1,'when you see the product at first glance',2, '2021-09-17','10:47:52');
INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (3, 0,'spring boot project',2, '2015-09-17','18:47:52');
INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (1, 1,'every lie will be revealed.....',1, '2021-04-15','18:47:52');
INSERT INTO comment_tbl (product_id,status,content,user_id,created_date,created_time) VALUES (2, 0,'fhghdgfgfghj???',1, '2023-04-15','18:47:52');








