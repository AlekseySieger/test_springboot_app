delete from public.car;

ALTER TABLE public.car ADD engine_power int8 NOT NULL;
ALTER TABLE public.car ADD fuel_consumption int8 NOT NULL;
ALTER TABLE public.car ADD acceleration int8 NOT NULL;
ALTER TABLE public.car ADD max_speed int8 NOT NULL;
ALTER TABLE public.car ADD complectation Varchar(255) NOT NULL;
ALTER TABLE public.car ADD type_of_fuel Varchar(255) NOT NULL;

