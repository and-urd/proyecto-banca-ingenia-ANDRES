

--CUENTAS
INSERT INTO cuentas(id, numero_cuenta, tipo_cuenta, saldo) VALUES (1, "23984238947", "Corriente", 2150);
INSERT INTO cuentas(id, numero_cuenta, tipo_cuenta, saldo) VALUES (2, "65165778947", "Pensiones", 1000);
INSERT INTO cuentas(id, numero_cuenta, tipo_cuenta, saldo) VALUES (3, "16116515947", "Pensiones", 2000);

--USERS
INSERT INTO usuarios(id, username, email, direccion, telefono) VALUES (1, "rafa", "rafa@email.com", "Calle Falsa 123 Malaga", "654123987");
INSERT INTO usuarios(id, username, email, direccion, telefono) VALUES (2, "andres", "andres@email.com", "Calle Loquesea 268 Malaga", "665165187");
INSERT INTO usuarios(id, username, email, direccion, telefono) VALUES (3, "joaquin", "joaquin@email.com", "Calle Flores 2 Malaga", "665342211");

--RELACIÓN CUENTAS-USERS
INSERT INTO cuentas_users(cuenta_id, user_id) VALUES (1, 1);
INSERT INTO cuentas_users(cuenta_id, user_id) VALUES (1, 2);
INSERT INTO cuentas_users(cuenta_id, user_id) VALUES (2, 3);
INSERT INTO cuentas_users(cuenta_id, user_id) VALUES (3, 3);


--TARJETAS
INSERT INTO tarjetas(id, cvv, numero_tarjeta, fecha_caducidad, limite_maximo, tipo_tarjeta, id_cuenta) VALUES (1, 356, "15165165", "2022-05-16", 500, "Debito", 1);
INSERT INTO tarjetas(id, cvv, numero_tarjeta, fecha_caducidad, limite_maximo, tipo_tarjeta, id_cuenta) VALUES (2, 586, "56161665", "2022-05-13", 300, "Debito", 1);
INSERT INTO tarjetas(id, cvv, numero_tarjeta, fecha_caducidad, limite_maximo, tipo_tarjeta, id_cuenta) VALUES (3, 834, "23432433", "2022-03-03" , 500 , "Credito", 2);
INSERT INTO tarjetas(id, cvv, numero_tarjeta, fecha_caducidad, limite_maximo, tipo_tarjeta, id_cuenta) VALUES (4, 443, "89789873", "2022-01-29", 500, "Débito", 3);



--CATEGORIAS
INSERT INTO categorias(id,tipo_categoria) VALUES (1, "Restaurantes");
INSERT INTO categorias(id,tipo_categoria) VALUES (2, "Combustible");
INSERT INTO categorias(id,tipo_categoria) VALUES (3, "Viajes");
INSERT INTO categorias(id,tipo_categoria) VALUES (4, "Hoteles");
INSERT INTO categorias(id,tipo_categoria) VALUES (5, "Compras");
INSERT INTO categorias(id,tipo_categoria) VALUES (6, "Regalos");
INSERT INTO categorias(id,tipo_categoria) VALUES (7, "Varios");
INSERT INTO categorias(id,tipo_categoria) VALUES (8, "Domiciliacion");


--MOVIMIENTOS
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (1, "ingreso", "2021-05-1", "2021-05-1", 50, 50,"15165165", 1, 1);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (2, "ingreso", "2021-05-5", "2021-05-5", 50, 100,"15165165", 1, 1);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (3, "nomina", "2021-05-16", "2021-05-16", 1500, 1600,"", 1, 7);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (4, "Mercadona", "2021-05-20", "2021-05-20", -100, 1500,"", 1, 5);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (5, "Electricidad", "2021-05-20", "2021-05-20", -50, 1450,"", 1, 8);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (6, "Emasa Agua", "2021-05-21", "2021-05-21", -50, 1400,"", 1, 8);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (7, "Hotel Florida", "2021-05-22", "2021-05-22", -100, 1350,"15165165", 1, 4);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (8, "El corte ingles", "2021-05-23", "2021-05-23", -100, 1250,"", 1, 6);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (9, "Hotel Marina", "2021-05-22", "2021-05-22", -100, 1350,"56161665", 1, 4);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (10, "Repsol", "2021-05-23", "2021-05-23", -50, 1300,"56161665", 1, 2);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (11, "Mediamarkt", "2021-05-24", "2021-05-24", -200, 1050,"", 1, 6);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (12, "Movistar", "2021-05-25", "2021-05-25", -50, 1350,"", 1, 8);

INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (13, "ingreso", "2021-06-1", "2021-06-1", 50, 1400,"15165165", 1, 1);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (14, "ingreso", "2021-06-5", "2021-06-5", 50, 1450,"15165165", 1, 1);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (15, "nomina", "2021-06-16", "2021-06-16", 1500, 2950,"", 1, 7);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (16, "Mercadona", "2021-06-20", "2021-06-20", -100, 2850,"", 1, 5);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (17, "Electricidad", "2021-06-20", "2021-06-20", -50, 2800,"", 1, 8);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (18, "Emasa Agua", "2021-06-21", "2021-06-21", -50, 2750,"", 1, 8);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (19, "Hotel Florida", "2021-06-22", "2021-06-22", -100, 2650,"15165165", 1, 4);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (20, "El corte ingles", "2021-06-23", "2021-06-23", -100, 2550,"", 1, 6);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (21, "Hotel Marina", "2021-06-22", "2021-06-22", -100, 2450,"15165165", 1, 4);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (22, "Repsol", "2021-06-23", "2021-06-23", -50, 2400,"15165165", 1, 2);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (23, "Mediamarkt", "2021-06-24", "2021-06-24", -200, 2200,"", 1, 6);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (24, "Movistar", "2021-06-25", "2021-06-25", -50, 2150,"", 1, 8);


INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (25, "Repsol", "2021-07-23", "2021-07-23", -50, 2400,"23432433", 2, 2);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (26, "Mediamarkt", "2021-07-24", "2021-07-24", -200, 2200,"", 2, 6);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (27, "Movistar", "2021-07-25", "2021-07-25", -50, 2150,"", 2, 8);

INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (28, "ingreso", "2021-08-1", "2021-08-1", 50, 1400,"89789873", 3, 1);
INSERT INTO movimientos (id, concepto, fecha_operacion, fecha_valor, cantidad, saldo_actual, num_tarjeta, id_cuenta, id_categoria) VALUES (29, "ingreso", "2021-08-5", "2021-08-5", 50, 1450,"89789873", 3, 1);
