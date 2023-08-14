CREATE DATABASE IF NOT EXISTS swisslub;
USE swisslub;
-- Tabla: movement
CREATE TABLE movement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    company_id BIGINT,
    description VARCHAR(255),
    winery_origin_code VARCHAR(255),
    winery_destination_code VARCHAR(255),
    creation_date DATE,
    delivery_date DATE,
    status VARCHAR(255)
);

-- Tabla: movement_detail
CREATE TABLE movement_detail (
    id INT AUTO_INCREMENT PRIMARY KEY,
    movement_id INT,
    FOREIGN KEY (movement_id) REFERENCES movement(id),
    item_code VARCHAR(20),
    quantity_sent INT
);





