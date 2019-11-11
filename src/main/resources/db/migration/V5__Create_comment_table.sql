drop table if exists community1.comment;
create table community1.comment
(
	id bigint auto_increment primary key,
	parent_id bigint not null,
	type int not null,
	commentator int not null,
	gmt_create bigint not null,
	gmt_modified bigint not null,
	like_count bigint default 0,
	content varchar(1024)
);

