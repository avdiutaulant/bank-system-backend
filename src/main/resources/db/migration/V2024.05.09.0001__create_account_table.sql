CREATE TABLE account
(
    id         UUID             NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    balance    DOUBLE PRECISION NOT NULL,
    bank_id    UUID,
    CONSTRAINT pk_account PRIMARY KEY (id)
);

