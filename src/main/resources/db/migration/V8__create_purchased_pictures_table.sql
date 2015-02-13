create table Purchased_Pictures{
    id serial primary key unique,
    userId integer not null,
    picId varchar(40) not null,
    createDate timestamp not null,
    modifyDate timestamp not null
};
