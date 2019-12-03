drop table if exists user;
create table user(
	id int auto_increment primary key NOT NULL,
	account_id varchar(100),
	name varchar(50),
	token char(50),
	gmt_create bigint,
	gmt_modified bigint
);