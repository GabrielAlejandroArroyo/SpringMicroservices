-- Para países
INSERT INTO countries (name) VALUES ('Argentina');
INSERT INTO countries (name) VALUES ('EEUU');
INSERT INTO countries (name) VALUES ('Spain');

-- Para estados (Argentina)
INSERT INTO states (name, country_id) VALUES ('Buenos Aires', (SELECT id FROM countries WHERE name = 'Argentina'));
INSERT INTO states (name, country_id) VALUES ('Córdoba', (SELECT id FROM countries WHERE name = 'Argentina'));
INSERT INTO states (name, country_id) VALUES ('Santa Fe', (SELECT id FROM countries WHERE name = 'Argentina'));
INSERT INTO states (name, country_id) VALUES ('Entr Rios', (SELECT id FROM countries WHERE name = 'Argentina'));
INSERT INTO states (name, country_id) VALUES ('Tucuman', (SELECT id FROM countries WHERE name = 'Argentina'));
INSERT INTO states (name, country_id) VALUES ('Salta', (SELECT id FROM countries WHERE name = 'Argentina'));
INSERT INTO states (name, country_id) VALUES ('Chubut', (SELECT id FROM countries WHERE name = 'Argentina'));
INSERT INTO states (name, country_id) VALUES ('Jujuy', (SELECT id FROM countries WHERE name = 'Argentina'));
INSERT INTO states (name, country_id) VALUES ('Formosa', (SELECT id FROM countries WHERE name = 'Argentina'));
INSERT INTO states (name, country_id) VALUES ('Misiones', (SELECT id FROM countries WHERE name = 'Argentina'));

-- Para estados (EEUU)
INSERT INTO states (name, country_id) VALUES ('California', (SELECT id FROM countries WHERE name = 'EEUU'));
INSERT INTO states (name, country_id) VALUES ('New York', (SELECT id FROM countries WHERE name = 'EEUU'));
INSERT INTO states (name, country_id) VALUES ('Texas', (SELECT id FROM countries WHERE name = 'EEUU'));
INSERT INTO states (name, country_id) VALUES ('Florida', (SELECT id FROM countries WHERE name = 'EEUU'));
INSERT INTO states (name, country_id) VALUES ('Illinois', (SELECT id FROM countries WHERE name = 'EEUU'));
INSERT INTO states (name, country_id) VALUES ('Pennsylvania', (SELECT id FROM countries WHERE name = 'EEUU'));
INSERT INTO states (name, country_id) VALUES ('Ohio', (SELECT id FROM countries WHERE name = 'EEUU'));
INSERT INTO states (name, country_id) VALUES ('Georgia', (SELECT id FROM countries WHERE name = 'EEUU'));
INSERT INTO states (name, country_id) VALUES ('North Carolina', (SELECT id FROM countries WHERE name = 'EEUU'));
INSERT INTO states (name, country_id) VALUES ('Michigan', (SELECT id FROM countries WHERE name = 'EEUU'));

-- Para estados (Spain)
INSERT INTO states (name, country_id) VALUES ('Madrid', (SELECT id FROM countries WHERE name = 'Spain'));
INSERT INTO states (name, country_id) VALUES ('Barcelona', (SELECT id FROM countries WHERE name = 'Spain'));
INSERT INTO states (name, country_id) VALUES ('Valencia', (SELECT id FROM countries WHERE name = 'Spain'));
INSERT INTO states (name, country_id) VALUES ('Andalucía', (SELECT id FROM countries WHERE name = 'Spain'));
INSERT INTO states (name, country_id) VALUES ('Galicia', (SELECT id FROM countries WHERE name = 'Spain'));
INSERT INTO states (name, country_id) VALUES ('Castilla y León', (SELECT id FROM countries WHERE name = 'Spain'));
INSERT INTO states (name, country_id) VALUES ('País Vasco', (SELECT id FROM countries WHERE name = 'Spain'));
INSERT INTO states (name, country_id) VALUES ('Canarias', (SELECT id FROM countries WHERE name = 'Spain'));
INSERT INTO states (name, country_id) VALUES ('Asturias', (SELECT id FROM countries WHERE name = 'Spain'));
INSERT INTO states (name, country_id) VALUES ('Murcia', (SELECT id FROM countries WHERE name = 'Spain'));


-- Para ciudades (Argentina - Buenos Aires)
INSERT INTO cities (name, state_id) VALUES ('Buenos Aires', (SELECT id FROM states WHERE name = 'Buenos Aires'));
INSERT INTO cities (name, state_id) VALUES ('La Plata', (SELECT id FROM states WHERE name = 'Buenos Aires'));
INSERT INTO cities (name, state_id) VALUES ('Mar del Plata', (SELECT id FROM states WHERE name = 'Buenos Aires'));
INSERT INTO cities (name, state_id) VALUES ('Quilmes', (SELECT id FROM states WHERE name = 'Buenos Aires'));
INSERT INTO cities (name, state_id) VALUES ('Bahía Blanca', (SELECT id FROM states WHERE name = 'Buenos Aires'));
INSERT INTO cities (name, state_id) VALUES ('Lomas de Zamora', (SELECT id FROM states WHERE name = 'Buenos Aires'));
INSERT INTO cities (name, state_id) VALUES ('San Isidro', (SELECT id FROM states WHERE name = 'Buenos Aires'));
INSERT INTO cities (name, state_id) VALUES ('Tandil', (SELECT id FROM states WHERE name = 'Buenos Aires'));
INSERT INTO cities (name, state_id) VALUES ('Pergamino', (SELECT id FROM states WHERE name = 'Buenos Aires'));
INSERT INTO cities (name, state_id) VALUES ('San Nicolás de los Arroyos', (SELECT id FROM states WHERE name = 'Buenos Aires'));
INSERT INTO cities (name, state_id) VALUES ('Junín', (SELECT id FROM states WHERE name = 'Buenos Aires'));

-- Para ciudades (Argentina - Cordoba)
INSERT INTO cities (name, state_id) VALUES ('Córdoba', (SELECT id FROM states WHERE name = 'Córdoba'));
INSERT INTO cities (name, state_id) VALUES ('Villa María', (SELECT id FROM states WHERE name = 'Córdoba'));
INSERT INTO cities (name, state_id) VALUES ('Río Cuarto', (SELECT id FROM states WHERE name = 'Córdoba'));
INSERT INTO cities (name, state_id) VALUES ('Alta Gracia', (SELECT id FROM states WHERE name = 'Córdoba'));
INSERT INTO cities (name, state_id) VALUES ('Villa Carlos Paz', (SELECT id FROM states WHERE name = 'Córdoba'));
INSERT INTO cities (name, state_id) VALUES ('Jesús María', (SELECT id FROM states WHERE name = 'Córdoba'));
INSERT INTO cities (name, state_id) VALUES ('San Francisco', (SELECT id FROM states WHERE name = 'Córdoba'));
INSERT INTO cities (name, state_id) VALUES ('Río Tercero', (SELECT id FROM states WHERE name = 'Córdoba'));
INSERT INTO cities (name, state_id) VALUES ('Bell Ville', (SELECT id FROM states WHERE name = 'Córdoba'));
INSERT INTO cities (name, state_id) VALUES ('Villa Dolores', (SELECT id FROM states WHERE name = 'Córdoba'));

-- Para ciudades (Argentina - Santa Fe)
INSERT INTO cities (name, state_id) VALUES ('Rosario', (SELECT id FROM states WHERE name = 'Santa Fe'));
INSERT INTO cities (name, state_id) VALUES ('Santa Fe', (SELECT id FROM states WHERE name = 'Santa Fe'));
INSERT INTO cities (name, state_id) VALUES ('Venado Tuerto', (SELECT id FROM states WHERE name = 'Santa Fe'));
INSERT INTO cities (name, state_id) VALUES ('Rafaela', (SELECT id FROM states WHERE name = 'Santa Fe'));
INSERT INTO cities (name, state_id) VALUES ('Reconquista', (SELECT id FROM states WHERE name = 'Santa Fe'));
INSERT INTO cities (name, state_id) VALUES ('San Lorenzo', (SELECT id FROM states WHERE name = 'Santa Fe'));
INSERT INTO cities (name, state_id) VALUES ('Firmat', (SELECT id FROM states WHERE name = 'Santa Fe'));
INSERT INTO cities (name, state_id) VALUES ('Casilda', (SELECT id FROM states WHERE name = 'Santa Fe'));
INSERT INTO cities (name, state_id) VALUES ('Cañada de Gómez', (SELECT id FROM states WHERE name = 'Santa Fe'));
INSERT INTO cities (name, state_id) VALUES ('Granadero Baigorria', (SELECT id FROM states WHERE name = 'Santa Fe'));


-- Para ciudades (Argentina - Entre Ríos)
INSERT INTO cities (name, state_id) VALUES ('Paraná', (SELECT id FROM states WHERE name = 'Entre Ríos'));
INSERT INTO cities (name, state_id) VALUES ('Concordia', (SELECT id FROM states WHERE name = 'Entre Ríos'));
INSERT INTO cities (name, state_id) VALUES ('Gualeguaychú', (SELECT id FROM states WHERE name = 'Entre Ríos'));
INSERT INTO cities (name, state_id) VALUES ('Gualeguay', (SELECT id FROM states WHERE name = 'Entre Ríos'));
INSERT INTO cities (name, state_id) VALUES ('Victoria', (SELECT id FROM states WHERE name = 'Entre Ríos'));
INSERT INTO cities (name, state_id) VALUES ('Colón', (SELECT id FROM states WHERE name = 'Entre Ríos'));
INSERT INTO cities (name, state_id) VALUES ('Villaguay', (SELECT id FROM states WHERE name = 'Entre Ríos'));
INSERT INTO cities (name, state_id) VALUES ('La Paz', (SELECT id FROM states WHERE name = 'Entre Ríos'));
INSERT INTO cities (name, state_id) VALUES ('Diamante', (SELECT id FROM states WHERE name = 'Entre Ríos'));
INSERT INTO cities (name, state_id) VALUES ('Federal', (SELECT id FROM states WHERE name = 'Entre Ríos'));




-- Para barrios (Buenos Aires)
INSERT INTO neighborhoods (name, city_id) VALUES ('Palermo', (SELECT id FROM cities WHERE name = 'Buenos Aires'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Recoleta', (SELECT id FROM cities WHERE name = 'Buenos Aires'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Belgrano', (SELECT id FROM cities WHERE name = 'Buenos Aires'));
INSERT INTO neighborhoods (name, city_id) VALUES ('San Telmo', (SELECT id FROM cities WHERE name = 'Buenos Aires'));
INSERT INTO neighborhoods (name, city_id) VALUES ('La Boca', (SELECT id FROM cities WHERE name = 'Buenos Aires'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Puerto Madero', (SELECT id FROM cities WHERE name = 'Buenos Aires'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Caballito', (SELECT id FROM cities WHERE name = 'Buenos Aires'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Villa Crespo', (SELECT id FROM cities WHERE name = 'Buenos Aires'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Almagro', (SELECT id FROM cities WHERE name = 'Buenos Aires'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Balvanera', (SELECT id FROM cities WHERE name = 'Buenos Aires'));

-- Para barrios (La Plata)
INSERT INTO neighborhoods (name, city_id) VALUES ('Centro', (SELECT id FROM cities WHERE name = 'La Plata'));
INSERT INTO neighborhoods (name, city_id) VALUES ('La Loma', (SELECT id FROM cities WHERE name = 'La Plata'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Los Hornos', (SELECT id FROM cities WHERE name = 'La Plata'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Villa Elvira', (SELECT id FROM cities WHERE name = 'La Plata'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Tolosa', (SELECT id FROM cities WHERE name = 'La Plata'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Ringuelet', (SELECT id FROM cities WHERE name = 'La Plata'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Altos de San Lorenzo', (SELECT id FROM cities WHERE name = 'La Plata'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Villa Elisa', (SELECT id FROM cities WHERE name = 'La Plata'));
INSERT INTO neighborhoods (name, city_id) VALUES ('City Bell', (SELECT id FROM cities WHERE name = 'La Plata'));
INSERT INTO neighborhoods (name, city_id) VALUES ('Gonnet', (SELECT id FROM cities WHERE name = 'La Plata'));
