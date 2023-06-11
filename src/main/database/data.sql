create table if not exists "users"
(
    user_id serial
        primary key
        unique
                          not null,
    name      varchar(20) not null,
    user_name varchar(20) not null unique ,
    email       varchar(70)     not null unique ,
    password       varchar     not null
);

alter table "users"
    owner to postgres;