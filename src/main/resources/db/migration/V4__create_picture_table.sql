create table Picture (
	id varchar(40) primary key,
	user_id integer not null,
	caption varchar(40) ,
	location varchar(40),
	keyword varchar(20),
	price integer,
	visibility boolean,
	createDate timestamp not null,
    modifyDate timestamp not null
);
ALTER TABLE Picture ADD UNIQUE (id);
