CREATE TABLE IF NOT EXISTS products
(
    id                 SERIAL PRIMARY KEY,
    product_id         VARCHAR(50)    NOT NULL,
    status             VARCHAR(20)    NOT NULL,
    fulfillment_center VARCHAR(20)    NOT NULL,
    quantity           INT            NOT NULL,
    value              DECIMAL(10, 2) NOT NULL
);

