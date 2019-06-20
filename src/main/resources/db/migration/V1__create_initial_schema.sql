create extension if not exists "uuid-ossp";

create table COW
(
    cow_id     uuid primary key,
    nick_name  text not null,
    parent_id  uuid,
    date_birth timestamp default current_timestamp,
    date_death timestamp,
    constraint parent_constraint foreign key (parent_id) references cow (cow_id)
);