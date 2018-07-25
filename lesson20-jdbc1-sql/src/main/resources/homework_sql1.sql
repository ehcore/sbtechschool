--создание базы данных
create schema store;

use store;
--создание таблиц базы данных
--таблица пользователей
create table user (id int auto_increment not null, name varchar(50) not null, age int not null, primary key(id));
--таблица товаров
create table item(id int auto_increment not null, name varchar(50) not null, price decimal(16,2) not null, primary key(id));
--таблица заказов
create table orders(id int auto_increment not null, date datetime not null, user_id int not null, primary key(id), foreign key (user_id) references user (id) on delete cascade);
--таблица товаров и заказов
create table order_items(orders_id int, item_id int, primary key (orders_id, item_id) ,foreign key (orders_id) references orders (id) on delete cascade, foreign key (item_id) references item (id) on delete cascade);

--добавление данных в таблицу пользователей
insert into user values(1,'Паша', 27);
insert into user values(2,'Саша', 29);
insert into user values(3,'Маша', 24);
insert into user values(4,'Петя', 22);
insert into user values(5,'Аня', 34);
insert into user values(6,'Катя', 30);

select * from user;

--добавление данных в таблицу товаров
insert into item (name,price) values('Картофель', 19);
insert into item (name, price) values ('Томат',25);
insert into item (name, price) values ('Огурцы', 35);
insert into item (name, price) values ('Капуста', 26);
insert into item (name, price) values ('Бананы', 50);
insert into item (name, price) values ('Персики', 80);
insert into item (name, price) values ('Яблоки', 95);
insert into item (name, price) values ('Лук', 18);
insert into item (name, price) values ('Перец', 60);

select * from item;

--добавление поля в таблицу товаров и заказов
alter table order_items add (amount decimal(8,2));

--добавление данных в таблицу заказов
insert into orders (date, user_id) values ('2018-07-19',1);
insert into orders (date, user_id) values ('2018-07-19',2);
insert into orders (date, user_id) values ('2018-07-19',4);
insert into orders (date, user_id) values ('2018-07-19',6);
insert into orders (date, user_id) values ('2018-07-19',3);

select * from orders;

--добавление данных в таблицу товаров и заказов
insert into order_items values (1,1,2.5);
insert into order_items values (1,2,1.3);
insert into order_items values (1,3,1);
insert into order_items values (1,5,1);
insert into order_items values (2,2,1);
insert into order_items values (2,3,1.2);
insert into order_items values (3,6,1.5);
insert into order_items values (4,9,0.6);
insert into order_items values (4,2,1.3);
insert into order_items values (5,1,3);
insert into order_items values (5,2,1.5);
insert into order_items values (5,3,1.2);

select * from order_items;

--выбор имени и возраста пользователя, а также номера и даты его заказа для определенного пользователя
select u.name, u.age, o.id as order_number ,o.date from user as u join orders as o on u.id = o.user_id where u.name = 'Паша' ;

--изменение даты заказа для определенных заказов
update orders set date = '2018-07-15' where id in (1,2,3);

--выбор имени и возраста пользователя, а также номера и даты его заказа для заказов сделанных после определенной даты
select u.name, u.age, o.id as order_number ,o.date from user as u join orders as o on u.id = o.user_id where date > '2018-07-15';


select o_i.item_id, o_i.amount, temp.name, temp.age, temp.date from (select u.name, u.age, o.id as order_number ,o.date from user as u join orders as o on u.id = o.user_id where date = '2018-07-15') temp left join order_items as o_i on temp.order_number = o_i.orders_id ;

select temp2.name, temp2.age, temp2.date, temp2.amount, item.name, item.price from (select o_i.item_id, o_i.amount, temp.name, temp.age, temp.date from (select u.name, u.age, o.id as order_number ,o.date from user as u join orders as o on u.id = o.user_id where date = '2018-07-15') temp left join order_items as o_i on temp.order_number = o_i.orders_id ) temp2 left join item on temp2.item_id = item.id;

--создание представления (view)
create view test_view as (select temp2.name, temp2.age, temp2.date, temp2.amount, item.name as item_name, item.price, temp2.amount * item.price as cost from (select o_i.item_id, o_i.amount, temp.name, temp.age, temp.date from (select u.name, u.age, o.id as order_number ,o.date from user as u join orders as o on u.id = o.user_id where date = '2018-07-15') temp left join order_items as o_i on temp.order_number = o_i.orders_id ) temp2 left join item on temp2.item_id = item.id);

select * from store.test_view as temp where  temp.name = 'Паша' ;

select temp.name, sum(temp.cost) as final_cost from store.test_view as temp where  temp.name = 'Паша' ;