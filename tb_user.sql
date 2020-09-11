CREATE table tb_user(
	user_idx INT PRIMARY KEY auto_increment
	, user_id VARCHAR(25) NOT null
	, user_password VARCHAR(100) NOT null
	, user_name VARCHAR(10) NOT null
	, user_rank VARCHAR(10) NOT null
	, user_nickname VARCHAR(10) NOT null
	, user_email VARCHAR(30)
	, user_post_number VARCHAR(6) NOT null
	, user_address VARCHAR(30) NOT null
	, user_address_detail VARCHAR(30)
	, user_phone_number VARCHAR(12) NOT null
	, user_begin_date date
	)
