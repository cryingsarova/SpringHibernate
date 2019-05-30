Create table Customers(
customer_id  serial PRIMARY KEY,
last_name varchar not null,
living_area varchar not null,
sale real not null
);

Create table Shops(
shop_id  serial PRIMARY KEY,
name varchar not null,
location_area  varchar not null,
commission real not null
);
 
Create table Books(
book_id  serial PRIMARY KEY,
title varchar not null,
price real not null,
warehouse varchar not null,
quantity int not null);

Create table Purchases(
order_number  serial PRIMARY KEY,
purchase_date date not null,
shop_id int not null,
customer_id int not null,
book_id int not null,
quantity int not null,
FOREIGN KEY (shop_id) REFERENCES Shops(shop_id),
FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

INSERT INTO Customers (last_name,living_area,sale) VALUES ( 'Петров','Автозаводский',0.00 ),
							( 'Иванова','Приокский',0.10 ),
							('Круглова','Нижегородский',0.05),
							('Сидоров','Канавинский',0.15);
							
INSERT INTO Shops (name,location_area,commission) VALUES  ( 'Дом книги','Московский',0.02 ),
							( 'Читай-город','Нижегородский',0.5),
							( 'Лабиринт','Канавинский',0.03),
							('Твоя книга','Приокский',0.10);
							
														
INSERT INTO Books (title,price,warehouse,quantity) VALUES ( 'Война и мир',1502.00,'Автозаводский',15 ),
							('Преступление и наказание',465.50,'Приокский',7),
							( 'Коллекционер',398.00,'Нижегородский',3),
							('Бойня №5',478.70,'Канавинский',4),
							('Шоколад',336.00,'Нижегородский',5),
							('Над кукушкиным гнездом',521.00,'Автозаводский',6),
							('Кысь',403.00,'Канавинский',2),
							('О любви',442.30,'Нижегородский',5);
							
INSERT INTO Purchases (purchase_date, shop_id,customer_id,book_id,quantity) VALUES ( to_date('20190125','YYYYMMDD'),2,1,5,1),
								( to_date('20190202','YYYYMMDD'),1,1,1,2),
								( to_date('20190209','YYYYMMDD'),1,4,7,1),
								( to_date('20190214','YYYYMMDD'),2,3,2,1),
								( to_date('20190217','YYYYMMDD'),3,2,4,3),
								( to_date('20190224','YYYYMMDD'),4,4,5,1),
								( to_date('20190227','YYYYMMDD'),1,3,6,1),
								( to_date('20190301','YYYYMMDD'),4,2,8,2);
							

