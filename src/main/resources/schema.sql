-- Creación de la tabla de productos
CREATE TABLE product (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cost FLOAT NOT NULL,
    stock INT NOT NULL
);

-- Creación de la tabla de órdenes
CREATE TABLE orders (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    order_date TIMESTAMP NOT NULL,
    total FLOAT NOT NULL
);

-- Creación de la tabla de artículos de órdenes
CREATE TABLE order_item (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product_id INT,
    amount INT NOT NULL,
    total FLOAT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);


