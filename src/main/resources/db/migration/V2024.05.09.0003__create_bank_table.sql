CREATE TABLE bank
(
    id             UUID             NOT NULL,
    name           VARCHAR(255),
    total_fee      NUMERIC(10,2) NOT NULL DEFAULT 0.0,
    total_transfer NUMERIC(10,2) NOT NULL DEFAULT 0.0,
    flat_fee       NUMERIC(10,2),
    percent_fee    NUMERIC(10,2),
    CONSTRAINT pk_bank PRIMARY KEY (id)
);

ALTER TABLE account
    ADD CONSTRAINT FK_ACCOUNT_ON_BANK FOREIGN KEY (bank_id) REFERENCES bank (id);