create table item
(
    item_id SERIAL PRIMARY KEY,
    name    VARCHAR(100) NOT NULL,
    title   VARCHAR(300) NOT NULL,
    price   INT          NOT NULL
);

create table backet
(
    backet_id    SERIAL PRIMARY KEY,
    backet_items JSONB DEFAULT '[]'
);