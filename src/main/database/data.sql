create table if not exists "users"
(
    user_id   serial
        primary key
        unique
                          not null,
    name      varchar(20) not null,
    user_name varchar(20) not null unique,
    email     varchar(70) not null unique,
    password  varchar     not null
);

alter table "users"
    owner to postgres;
------------------------------
create table if not exists "category"
(
        category_id serial primary key  unique  not null ,
        name varchar(30) not null unique ,
        description varchar(30) not null
);
alter table  "category"
owner to postgres;
----------------------------
create table if not exists brand
(
    brand_id serial primary key unique not null ,
    name varchar(20) unique not null ,
    website varchar(60) not null ,
    description varchar(60) not null
);
alter table brand owner to postgres;
----------------------------
