CREATE table public.garage
(
    id            serial,
    material      varchar(255) not null,
    price         int8         not null,
    size          int8         not null,
    parking_space int8         not null,
    PRIMARY KEY (id)
);

CREATE table public.owner
(
    id          serial,
    name        varchar(255),
    second_name varchar(255) not null,
    age         int4,
    PRIMARY KEY (id)
);
ALTER TABLE car
    ADD COLUMN owner_id BIGINT,
ADD CONSTRAINT fk_owner
FOREIGN KEY (owner_id) REFERENCES owner(id);

