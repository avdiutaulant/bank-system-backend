CREATE TABLE transaction
(
    id          UUID             NOT NULL,
    amount      NUMERIC(10,2) NOT NULL,
    sender_id   UUID             NOT NULL,
    receiver_id UUID             NOT NULL,
    type        VARCHAR(255),
    CONSTRAINT pk_transaction PRIMARY KEY (id)
);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_RECEIVER FOREIGN KEY (receiver_id) REFERENCES account (id);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_SENDER FOREIGN KEY (sender_id) REFERENCES account (id);