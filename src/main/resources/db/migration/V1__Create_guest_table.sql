create table Guest (
	id integer constraint pk PRIMARY KEY,
	name varchar(40) not null,
	signingDate date
);

create SEQUENCE guest_id_generator START 10000;