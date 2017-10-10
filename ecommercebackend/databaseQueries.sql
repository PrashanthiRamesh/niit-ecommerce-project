CREATE table category(
 id IDENTITY,
 name VARCHAR(50),
 description VARCHAR(255),
 image_url VARCHAR(50),
 is_active BOOLEAN,
 CONSTRAINT pk_category_id PRIMARY KEY(id)
);

CREATE TABLE user_detail (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);


CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),	
);	

CREATE TABLE supplier (
	id IDENTITY,
	name VARCHAR(50),
	address VARCHAR(255),
	city VARCHAR(30),
	region VARCHAR(30),
	postalcode INT,
	country VARCHAR(30),
	phone VARCHAR(15),
	is_active BOOLEAN,
	CONSTRAINT pk_supplier_id PRIMARY KEY (id),
);	

-- add 3 suppliers
INSERT INTO supplier (name, address, city, region, postalcode, country, phone, is_active) VALUES ('Vogue','Main Street Garden St', 'Coimbatore','TN','641044','India','2564856',true);
INSERT INTO supplier (name, address, city, region, postalcode, country, phone, is_active) VALUES ('Max','No 45 Winterfell Cross rd', 'Banglore','Karnataka','563254','India','45689525',true);
INSERT INTO supplier (name, address, city, region, postalcode, country, phone, is_active) VALUES ('Drapers','2GF 24A Bravos DragonStone', 'Cochin','Kerala','458756','India','2589654',true);

-- adding three categories
INSERT INTO category (name, description,image_url,is_active) VALUES ('Western Wear', 'Western wear is a category of mens and womens clothing which derives its unique style from the clothes worn in the 19th-century American West', 'CAT_1.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Sports Wear', 'Sportswear is an American fashion term originally used to describe separates, but which, since the 1930s, has come to be applied to day and evening fashions of varying degrees of formality', 'CAT_2.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Casual Wear', 'In the European tradition, casual is the dress code that emphasizes comfort and personal expression over presentation, formality and conformity.', 'CAT_3.png', true);
-- adding three users 
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Arya', 'Stark', 'ADMIN', true, '$2a$06$ORtBskA2g5Wg0HDgRE5ZsOQNDHUZSdpJqJ2.PGXv0mKyEvLnKP7SW', 'aryastark@gmail.com', '9584756321');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Jon', 'Snow', 'SUPPLIER', true, '$2a$06$bzYMivkRjSxTK2LPD8W4te6jjJa795OwJR1Of5n95myFsu3hgUnm6', 'jonsnow@gmail.com', '9563258745');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Dany', 'Targarean', 'SUPPLIER', true, '$2a$06$i1dLNlXj2uY.UBIb9kUcAOxCigGHUZRKBtpRlmNtL5xtgD6bcVNOK', 'danytargarean@gmail.com', '7589642563');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Cercei', 'Lannister', 'USER', true, '$2a$06$4mvvyO0h7vnUiKV57IW3oudNEaKPpH1xVSdbie1k6Ni2jfjwwminq', 'cerceilannister@gmail.com', '9568741236');

-- adding five products
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'Little Black Dress', 'Vera Moda', 'long-lasting, versatile, affordable, accessible to the widest market ', 18000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Tank Top', 'Polo', 'sleeveless shirt with low neck and different shoulder straps width', 32000, 2, true, 2, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Bodycon Dress', 'Chanel', 'one-piece figure hugging garment that clings tightly to the body', 57000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Palazzo', 'Mango', 'long womens trousers cut with a loose, extremely wide leg that flares out from the waist', 54000, 3, true, 2, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'Track Pants', 'Levis', 'Ripped jeans are denim jeans with tear or rips, often on the knees', 48000, 5, true, 5, 3, 0, 0 );

