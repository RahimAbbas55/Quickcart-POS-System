Database quickcartdb;

Create table users(
Username varchar(100) primary key,
password varchar(100) NOT NULL,
email varchar(100) NOT NULL,
number varchar(11) UNIQUE,
cnic varchar(13) UNIQUE,
address text IS NULL
); 

INSERT INTO users (Username, password, email, number, cnic, address)
VALUES 
('fatima', '845845', 'fatima@gmail.com', '7373927103', '2345678901', 'Karachi'),
('umer', '901901', 'umer@gmail.com', '03214567891', '6789012345', 'Islamabad');


CREATE TABLE Inventory (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    barcode VARCHAR(255) UNIQUE NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);  

INSERT INTO Inventory (name, barcode, quantity, price) VALUES
('Oil', '5028197972530', 24, 5500.00),
('Serum', '769915190311', 44, 3500.00),
('Moisturizing Cream', '5028197916145', 54, 4590.00),
('Pigmented Blush 2', '6902395828334', 65, 1590.00);

CREATE TABLE orders (
    orderID INT PRIMARY KEY AUTO_INCREMENT,
    seller VARCHAR(255),
    amount DECIMAL(10, 2),
    products INT,
    datetime DATETIME
);
INSERT INTO orders (seller, amount, products, datetime) VALUES
('umer', 160.60, 3, '2023-07-15 20:55:10.000'),
('fatima', 200.00, 5, '2023-09-03 14:22:10.000'),
('fatima', 140.75, 3, '2023-01-12 14:55:40.000'),
('umer', 180.60, 3, '2023-11-26 16:07:55.000'),
('umer', 200.50, 4, '2023-11-26 16:28:22.000');
