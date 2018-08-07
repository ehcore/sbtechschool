--create schema recipes;
--drop table tr_ingredients ;
--use recipes;

--CREATE TABLE IF NOT EXISTS ingredients ( id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, name varchar(60) NOT NULL) ;
--CREATE TABLE IF NOT EXISTS units ( id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, name varchar(30) NOT NULL) ;
--CREATE TABLE IF NOT EXISTS recipes ( id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, name varchar(60) NOT NULL);

--CREATE TABLE IF NOT EXISTS ingredients_recipes ( id_recipes int(10) NOT NULL, id_ingredients int(10) NOT NULL, amount decimal(8,3) NOT NULL, id_unit int(10) NOT NULL, PRIMARY KEY (id_recipes, id_ingredients),  FOREIGN KEY (id_recipes) REFERENCES recipes (id) on delete cascade,  FOREIGN KEY (id_ingredients) REFERENCES ingredients (id),  FOREIGN KEY (id_unit) REFERENCES units (id)) ;