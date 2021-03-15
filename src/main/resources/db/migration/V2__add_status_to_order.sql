alter table orders
    add status varchar(50) default 'INIT' not null;
