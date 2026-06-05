CREATE TABLE IF NOT EXISTS products(
    id varchar(255) not null primary key,
    name varchar(90) not null unique,
    description text,
    price numeric(18,2) not null
);