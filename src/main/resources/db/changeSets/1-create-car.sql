DROP TABLE IF EXISTS public.car;

CREATE TABLE public.car(
id serial,
model varchar(255) NOT NULL,
color varchar(256) NOT NULL,
price int8 NOT NULL,
active boolean NOT NULL,
PRIMARY KEY (id)
);