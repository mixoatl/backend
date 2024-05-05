INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('mixoatl', '$2a$10$bsnt1G8/WUnwrSDIBX/x3ujemxN50Z4MGvtFQ4tBlMO8kzPBJhcBS', 1, 'Monserrat', 'Fernández', 'monserrat@uanl.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('nissan', '$2a$10$KsAVZOBZDoOWk5SnbgMFbOrGuCQyBMoUvTlGCUJdvNpBzGNhqDc2m', 1, 'Nissan', 'Gtr', 'nissan@uanl.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('toyota', '$2a$10$JMazjxs3J599tU/KBpjVp.XMLYqXwmsjMBjHxcjSB2Y3wSmeIRete', 1, 'Toyota', 'A', 'toyota@uanl.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (1, 1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2, 2);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2, 1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (3, 1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (3, 2);