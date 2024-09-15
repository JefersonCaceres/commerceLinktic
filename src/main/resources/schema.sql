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



-- Inserción de productos
INSERT INTO product (id, name, cost, stock) VALUES
(1, 'Sneakers Nike Air Max', 120.0, 50),
(2, 'Reebok Classic Leather', 85.0, 30),
(3, 'Adidas Ultraboost', 150.0, 20),
(4, 'Puma RS-X', 95.0, 40),
(5, 'New Balance 990v5', 175.0, 25);

-- Inserción de órdenes
INSERT INTO orders (id, order_date, total) VALUES
(1, CURRENT_TIMESTAMP, 600.0),
(2, CURRENT_TIMESTAMP, 320.0);

-- Inserción de artículos de orden
INSERT INTO order_item (id, order_id, product_id, amount, total) VALUES
(1, 1, 1, 2, 240.0),  -- Orden 1, Producto 1, Cantidad 2, Total 240.0
(2, 1, 2, 1, 85.0),
(3, 1, 3, 1, 150.0),
(4, 2, 4, 2, 190.0),
(5, 2, 5, 1, 175.0);