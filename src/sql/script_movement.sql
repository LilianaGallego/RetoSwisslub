-- Insertar registros de ejemplo en la tabla movement
INSERT INTO movement (company_id, description, winery_origin_code, winery_destination_code, creation_date, delivery_date, status)
VALUES
    (1, 'Movimiento 1', 'ORIGIN01', 'DEST01', '2023-08-01', '2023-08-10', 'T'),
    (1, 'Movimiento 2', 'ORIGIN02', 'DEST02', '2023-08-02', '2023-08-12', 'E'),
    (2, 'Movimiento 3', 'ORIGIN03', 'DEST03', '2023-08-03', '2023-08-15', 'T'),
    (2, 'Movimiento 4', 'ORIGIN04', 'DEST04', '2023-08-04', '2023-08-18', 'P'),
    (3, 'Movimiento 5', 'ORIGIN05', 'DEST05', '2023-08-05', '2023-08-20', 'E');