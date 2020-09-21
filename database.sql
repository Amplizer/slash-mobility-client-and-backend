CREATE DATABASE slashmobility_client_business CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE slashmobility_client_business;

CREATE TABLE products ( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(128), price FLOAT, country_currency INT NOT NULL, img_src_type INT, img_file TEXT, active BOOLEAN DEFAULT TRUE );
CREATE TABLE products_images_sources( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, http_protocol VARCHAR(8), ip VARCHAR(128), port INT, src_folder TEXT );
CREATE TABLE products_country_prices ( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, code VARCHAR(8), alias VARCHAR(8) );
CREATE TABLE users ( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, email VARCHAR(255) );
CREATE TABLE user_purchases ( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, product_id INT NOT NULL, user_id INT NOT NULL, date_purchase DATETIME, deleted BOOLEAN DEFAULT false );


ALTER TABLE products ADD FOREIGN KEY (img_src_type) REFERENCES products_images_sources(id);
ALTER TABLE user_purchases ADD FOREIGN KEY (product_id) REFERENCES products(id);
ALTER TABLE user_purchases ADD FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE products ADD FOREIGN KEY (country_currency) REFERENCES products_country_prices(id);

INSERT INTO products_images_sources ( http_protocol, ip, port, src_folder ) VALUES ( 'http', 'localhost', '4200', 'assets/imgs' );

INSERT INTO products_country_prices ( code, alias ) VALUES ( 'EUR', '€' );

INSERT INTO products ( name, img_src_type, img_file, active, price, country_currency ) VALUES ( 'Nutela', 1, 'chocolate.jpg', true, 10, 1 ), ( 'Nutela', 1, 'chocolate.jpg', true, 10, 1 ), ( 'Nutela', 1, 'chocolate.jpg', true, 10, 1 ), ( 'Nutela', 1, 'chocolate.jpg', true, 10, 1 ), ( 'Nutela', 1, 'chocolate.jpg', true, 10, 1 ), ( 'Nutela', 1, 'chocolate.jpg', true, 10, 1 );
