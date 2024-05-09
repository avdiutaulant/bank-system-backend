CREATE TABLE bank
(
    id             UUID             NOT NULL,
    name           VARCHAR(255),
    total_fee      DOUBLE PRECISION NOT NULL,
    total_transfer DOUBLE PRECISION NOT NULL,
    flat_fee       DOUBLE PRECISION,
    percent_fee    DOUBLE PRECISION,
    CONSTRAINT pk_bank PRIMARY KEY (id)
);