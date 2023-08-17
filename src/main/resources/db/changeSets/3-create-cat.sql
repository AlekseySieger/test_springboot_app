DROP TABLE IF EXISTS public.cat;

CREATE TABLE public.cat(
id serial,
breed varchar(255) NOT NULL,
color varchar(255) NOT NULL,
type_of_wool varchar(256) NOT NULL,
weight_kg decimal NOT NULL,
price int8 NOT NULL,
age int8  NULL,
owners_number varchar(55) NOT NULL,
active boolean NOT NULL,
PRIMARY KEY (id)
);
