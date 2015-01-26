create table User_Basic (
    id serial primary key,
    firstName varchar(20) not null,
    lastName varchar(20) not null,
    email varchar(80) not null,
    password varchar(200) not null,
    status varchar(20),
    createDate timestamp not null,
    modifyDate timestamp not null
);

create SEQUENCE user_id_generator START 10000;

