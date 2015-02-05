create table Shopping_Car (
	id serial primary key unique,
	user_id integer not null,
	pic_id varchar(40) not null,
	createDate timestamp not null,
  modifyDate timestamp not null
);

create SEQUENCE sc_id_generator START 600000;
