
CREATE DATABASE IF NOT EXISTS mini_project_1;

USE mini_project_1;

CREATE TABLE IF NOT EXISTS customers (
    customer_id INT NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    PRIMARY KEY (customer_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS transactions (
    transaction_id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    transaction_amount DECIMAL(10,2) NOT NULL,
    transaction_date DATE NOT NULL,
    PRIMARY KEY (transaction_id),
    KEY customer_id (customer_id),
    CONSTRAINT fk_transaction_customer
        FOREIGN KEY (customer_id)
        REFERENCES customers(customer_id)
) ENGINE=InnoDB;
