create table Picture (
	id serial primary key,
	name varchar(40) not null,
	description varchar(100) not null
);

create SEQUENCE picture_id_generator START 10000;