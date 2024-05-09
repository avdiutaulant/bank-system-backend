CREATE TABLE account
(
    id         UUID             NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    balance    NUMERIC(10,2) NOT NULL DEFAULT 0,
    bank_id    UUID,
    CONSTRAINT pk_account PRIMARY KEY (id)
);

