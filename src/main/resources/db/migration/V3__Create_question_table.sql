drop table if exists question;
create table question(
    id int auto_increment primary key NOT NULL,
	title varchar(50) null,
	description text null,
	gmt_create bigint null,
	gmt_modified bigint null,
	creator int null,
	comment_count int default 0 ,
	view_count int default 0,
	like_count int default 0,
	tag varchar(256) null
);
