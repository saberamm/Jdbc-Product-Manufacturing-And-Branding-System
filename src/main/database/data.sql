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
create table if not exists product
(
    product_id serial primary key unique not null ,
    name varchar(20) not null ,
    create_date date not null ,
    category_id integer not null constraint category_id references "category",
    brand_id integer not null constraint brand_id references brand
);
alter table product owner to postgres;
----------------------------
create table if not exists shareholder
(
    shareholder_id serial primary key not null unique ,
    name varchar(20) not null ,
    phone_number varchar(11) not null ,
    national_code varchar(20) unique not null
);
alter table shareholder owner to postgres;
----------------------------
create table if not exists shareholder_brand
(
    shareholder_id integer not null constraint shareholder_id references shareholder,
    brand_id integer not null constraint brand_id references brand
);
alter table shareholder_brand owner to postgres;