Database quickcartdb;

Create table users(
Username varchar(100) primary key,
password varchar(100) NOT NULL,
email varchar(100) NOT NULL,
number varchar(11) UNIQUE,
cnic varchar(13) UNIQUE,
address text IS NULL
); 
tahoor, usmara, maham, rahim, ali, ahmad, umer, amna, fatima and ayesha

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
('Mobile cover', '657949743101101', 68, 1000.00),
('Rio Biscuit', '896002755202', 100, 25.00),
('Oreo Biscuit', '7622210462534', 87, 25.00),
('Lip Balm', '3616302970858', 80, 450.00),
('Lotion', '4005900011817', 47, 2500.00),
('Lipstick 1', '8681217236325', 75, 950.00),
('Lipstick 2', '8681217225169', 65, 1300.00),
('Headphones', '812887018449', 15, 12000.00),
('Pigmented Blush 1', '6902395828327', 80, 1580.00),
('Setting Spray', '8681217229839', 30, 3500.00),
('Lipstick 3', '3600531363864', 59, 1160.00),
('Wrist Watch', '194866387358', 25, 2300.00),
('Gel Pen', '6941501514716', 100, 150.00),
('Lip and Cheek Tint', '602004070432', 60, 1200.00),
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
('tahoor', 150.50, 3, '2023-10-15 08:30:45.000'),
('usmara', 200.75, 2, '2023-11-03 14:22:10.000'),
('rahim', 75.20, 1, '2023-12-12 17:45:30.000'),
('maham', 300.00, 5, '2023-11-08 09:55:22.000'),
('ali', 120.80, 4, '2023-12-05 20:18:05.000'),
('ahmad', 50.30, 2, '2023-10-18 11:40:15.000'),
('umer', 180.60, 3, '2023-11-23 16:07:55.000'),
('amna', 90.25, 2, '2023-12-02 13:10:28.000'),
('fatima', 250.00, 6, '2023-10-09 22:36:40.000'),
('ayesha', 120.50, 4, '2023-11-14 18:59:12.000'),
('tahoor', 175.20, 3, '2023-12-20 07:15:33.000'),
('usmara', 90.50, 2, '2023-10-04 14:40:20.000'),
('rahim', 60.75, 1, '2023-11-11 16:25:45.000'),
('maham', 280.40, 4, '2023-12-07 10:10:18.000'),
('ali', 110.00, 3, '2023-11-06 19:42:30.000'),
('ahmad', 45.80, 1, '2023-12-17 11:50:25.000'),
('umer', 195.30, 2, '2023-10-22 14:08:10.000'),
('amna', 85.60, 1, '2023-11-01 13:55:22.000'),
('fatima', 230.25, 5, '2023-12-10 21:20:35.000'),
('ayesha', 110.75, 3, '2023-10-13 17:45:50.000'),
('tahoor', 140.00, 2, '2023-01-05 09:15:30.000'),
('usmara', 180.50, 3, '2023-02-12 14:30:45.000'),
('rahim', 90.20, 1, '2023-03-18 18:45:15.000'),
('maham', 220.00, 4, '2023-04-02 07:30:22.000'),
('ali', 130.80, 3, '2023-05-21 12:15:35.000'),
('ahmad', 75.30, 2, '2023-06-09 16:40:50.000'),
('umer', 160.60, 3, '2023-07-15 20:55:10.000'),
('amna', 110.25, 4, '2023-08-28 11:10:28.000'),
('fatima', 200.00, 5, '2023-09-03 14:22:10.000'),
('ayesha', 90.50, 2, '2023-01-17 16:35:45.000'),
('tahoor', 130.25, 2, '2023-02-08 21:45:18.000'),
('usmara', 95.30, 1, '2023-03-23 10:30:25.000'),
('rahim', 180.40, 3, '2023-04-14 13:50:55.000'),
('maham', 120.00, 2, '2023-05-30 06:20:12.000'),
('ali', 50.75, 1, '2023-06-16 19:55:30.000'),
('ahmad', 70.60, 3, '2023-07-07 08:10:45.000'),
('umer', 200.50, 4, '2023-08-19 16:28:22.000'),
('amna', 110.20, 2, '2023-09-26 11:42:18.000'),
('fatima', 140.75, 3, '2023-01-12 14:55:40.000'),
('ayesha', 70.25, 1, '2023-02-25 17:30:10.000');

INSERT INTO orders (seller, amount, products, datetime) VALUES
('tahoor', 150.50, 3, '2023-11-26 08:30:45.000'),
('usmara', 200.75, 2, '2023-11-26 14:22:10.000'),
('rahim', 75.20, 1, '2023-11-26 17:45:30.000'),
('maham', 300.00, 5, '2023-11-26 09:55:22.000'),
('ali', 120.80, 4, '2023-11-26 20:18:05.000'),
('ahmad', 50.30, 2, '2023-11-26 11:40:15.000'),
('umer', 180.60, 3, '2023-11-26 16:07:55.000'),
('amna', 90.25, 2, '2023-11-26 13:10:28.000'),
('fatima', 250.00, 6, '2023-11-26 22:36:40.000'),
('ayesha', 120.50, 4, '2023-11-26 18:59:12.000'),
('tahoor', 175.20, 3, '2023-11-26 07:15:33.000'),
('usmara', 90.50, 2, '2023-11-26 14:40:20.000'),
('rahim', 60.75, 1, '2023-11-26 16:25:45.000'),
('maham', 280.40, 4, '2023-11-26 10:10:18.000'),
('ali', 110.00, 3, '2023-11-26 19:42:30.000'),
('ahmad', 45.80, 1, '2023-11-26 11:50:25.000'),
('umer', 195.30, 2, '2023-11-26 14:08:10.000'),
('amna', 85.60, 1, '2023-11-26 13:55:22.000'),
('fatima', 230.25, 5, '2023-11-26 21:20:35.000'),
('ayesha', 110.75, 3, '2023-11-26 17:45:50.000'),
('tahoor', 140.00, 2, '2023-11-26 09:15:30.000'),
('usmara', 180.50, 3, '2023-11-26 14:30:45.000'),
('rahim', 90.20, 1, '2023-11-26 18:45:15.000'),
('maham', 220.00, 4, '2023-11-26 07:30:22.000'),
('ali', 130.80, 3, '2023-11-26 12:15:35.000'),
('ahmad', 75.30, 2, '2023-11-26 16:40:50.000'),
('umer', 160.60, 3, '2023-11-26 20:55:10.000'),
('amna', 110.25, 4, '2023-11-26 11:10:28.000'),
('fatima', 200.00, 5, '2023-11-26 14:22:10.000'),
('ayesha', 90.50, 2, '2023-11-26 16:35:45.000'),
('tahoor', 130.25, 2, '2023-11-26 21:45:18.000'),
('usmara', 95.30, 1, '2023-11-26 10:30:25.000'),
('rahim', 180.40, 3, '2023-11-26 13:50:55.000'),
('maham', 120.00, 2, '2023-11-26 06:20:12.000'),
('ali', 50.75, 1, '2023-11-26 19:55:30.000'),
('ahmad', 70.60, 3, '2023-11-26 08:10:45.000'),
('umer', 200.50, 4, '2023-11-26 16:28:22.000'),
('amna', 110.20, 2, '2023-11-26 11:42:18.000'),
('fatima', 140.75, 3, '2023-11-26 14:55:40.000'),
('ayesha', 70.25, 1, '2023-11-26 17:30:10.000');