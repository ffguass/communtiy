drop table if exists community1.QUESTION;
create table community1.QUESTION(
    id bigint auto_increment primary key ,
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
