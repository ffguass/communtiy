drop table if exists community1.USER;
create table community1.USER(
	ID BIGINT auto_increment primary key,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN CHAR(50),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT
);