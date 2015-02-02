create table Shopping_Car (
	id serial primary key unique,
	user_id integer not null,
	pic_id varchar(40) not null,
	createDate timestamp not null,
  modifyDate timestamp not null
);

create SEQUENCE sc_id_generator START 600000;

insert into Shopping_Car(id, user_id, pic_id, createDate, modifyDate) values (1, 1, 'cfqhscDiSN8eo_cq_1','2015-01-23 17:28:31.758', '2015-01-23 17:28:31.758');