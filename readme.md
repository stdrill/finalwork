# 1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).

```
cat > 'Домашние животные'
nano 'Домашние животные'
	Собаки
	Кошки
	Хомяки

cat > 'Вьючные животные'
nano 'Вьючные животные'
	Лошади
	Верблюды
	Ослы

cat 'Домашние животные' 'Вьючные животные' > file
cat file
```

![](D:\images\1.png)<img width="188" alt="1" src="https://github.com/stdrill/finalwork/assets/109695593/7ed90c5e-7cd4-4c74-b6af-8a2b609dbe58">


```
mv file 'Друзья человека'
```

# 2. Создать директорию, переместить файл туда.
```
mkdir work_dir
mv 'Друзья человека' work_dir/
```
# 3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
```
wget -c https://dev.mysql.com/get/mysql-apt-config_0.8.10-1_all.deb
sudo dpkg -i mysql-apt-config_0.8.10-1_all.deb
sudo apt update
sudo apt-get install mysql-server

```

# 4. Установить и удалить deb-пакет с помощью dpkg
```
wget -O ~/google-earth.deb https://dl.google.com/dl/earth/client/current/google-earth-pro-stable_current_amd64.deb
sudo dpkg -i ~/google-earth.deb
sudo dpkg-query -l | grep google
```
![](D:\images\4.png)<img width="831" alt="4" src="https://github.com/stdrill/finalwork/assets/109695593/e7542134-306e-4f0f-b383-26512ec602d9">


Удалим пакет:
```
sudo dpkg -r google-earth-pro-stable
```

# 5. Выложить историю команд в терминале ubuntu
![](D:\images\5.png)<img width="721" alt="5" src="https://github.com/stdrill/finalwork/assets/109695593/d952a732-ce63-4b22-a0ba-2fcb6662b3a6">


# 6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы).
![](D:\images\6.png)![6](https://github.com/stdrill/finalwork/assets/109695593/88be2359-39eb-4aa5-9753-3d3039cff118)


# 7.  В подключенном MySQL репозитории создать базу данных “Друзья человека”

```
mysql
```
```
DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE human_friends;
```
![](D:\images\7.png)![7](https://github.com/stdrill/finalwork/assets/109695593/16edd5d8-e0b8-4bbb-a3a4-632e01df14dc)


# 8. Создать таблицы с иерархией из диаграммы в БД
```
USE human_friends;
 
 CREATE TABLE animals
 (
	id INT NOT NULL PRIMARY KEY,
   	name VARCHAR(45)
 );
 
 CREATE TABLE home_animals
 (
	id INT NOT NULL PRIMARY KEY,
   	name VARCHAR(45),
    	id_animal INT,
   	CONSTRAINT fk_animals_id_home_animals 
    	FOREIGN KEY (id_animal)  REFERENCES animals (id)
 );
 
 CREATE TABLE pack_animals
 (
	id INT NOT NULL PRIMARY KEY,
    	name VARCHAR(45),
   	id_animal INT,
    	CONSTRAINT fk_animals_id_pack_animals 
    	FOREIGN KEY (id_animal)  REFERENCES animals (id)
 );
 
 CREATE TABLE dogs
 (
	id INT NOT NULL PRIMARY KEY,
    	name VARCHAR(45),
    	id_home_animals INT,
    	CONSTRAINT fk_home_animals_id_dogs 
    	FOREIGN KEY (id_home_animals)  REFERENCES home_animals (id)
 );
 
 CREATE TABLE cats
 (
	id INT NOT NULL PRIMARY KEY,
   	name VARCHAR(45),
    	id_home_animals INT,
    	CONSTRAINT fk_home_animals_id_cats 
    	FOREIGN KEY (id_home_animals)  REFERENCES home_animals (id)
 ); 
 
CREATE TABLE hamsters
 (
	id INT NOT NULL PRIMARY KEY,
    	name VARCHAR(45),
    	id_home_animals INT,
    	CONSTRAINT fk_home_animals_id_hamsters 
    	FOREIGN KEY (id_home_animals)  REFERENCES home_animals (id)
 ); 
 
CREATE TABLE horses
 (
	id INT NOT NULL PRIMARY KEY,
    	name VARCHAR(45),
    	id_pack_animals INT,
    	CONSTRAINT fk_pack_animals_id_horses 
    	FOREIGN KEY (id_pack_animals)  REFERENCES pack_animals (id)
 ); 
 
CREATE TABLE camels
 (
	id INT NOT NULL PRIMARY KEY,
   	name VARCHAR(45),
    	id_pack_animals INT,
    	CONSTRAINT fk_pack_animals_id_camels 
    	FOREIGN KEY (id_pack_animals)  REFERENCES pack_animals (id)
 ); 
 
CREATE TABLE donkeys
 (
	id INT NOT NULL PRIMARY KEY,
    	name VARCHAR(45),
   	id_pack_animals INT,
    	CONSTRAINT fk_pack_animals_id_donkeys 
    	FOREIGN KEY (id_pack_animals)  REFERENCES pack_animals (id)
 );
```
![](D:\images\8.png)![8](https://github.com/stdrill/finalwork/assets/109695593/0cb01e48-a6cc-45c9-a36b-6ad961f82bc9)


# 9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
```
INSERT INTO animals
VALUES
(1, 'Домашние животные'),
(2, 'Вьючные животные');

INSERT INTO home_animals
VALUES
(1, "Собаки", 1),
(2, "Кошки", 1),
(3, "Хомяки", 1);

INSERT INTO pack_animals
VALUES
(1, "Лошади", 2),
(2, "Жирафы", 2),
(3, "Ослы", 2);

ALTER TABLE dogs
ADD commands VARCHAR(50) NULL,
ADD birth_date DATETIME;

INSERT INTO dogs
VALUES
(1, "dog 1", 1, "comands 1, 2, 3", '2020-01-01'),
(2, "dog 2", 1, "comands 1, 2, 5", '2020-08-25');

ALTER TABLE cats
ADD commands VARCHAR(50) NULL,
ADD birth_date DATETIME;

INSERT INTO cats
VALUES
(1, "cat 1", 2, "comands 1, 1, 1", '2022-01-01'),
(2, "cat 2", 2, "comands 1, 2, 1", '2022-08-25');

ALTER TABLE hamsters
ADD commands VARCHAR(50) NULL,
ADD birth_date DATETIME;

INSERT INTO hamsters
VALUES
(1, "hamster 1", 3, "comands 1, 1, 1", '2022-05-01'),
(2, "hamster 2", 3, "comands 1, 2, 1", '2022-09-19');

ALTER TABLE horses
ADD commands VARCHAR(50) NULL,
ADD birth_date DATETIME;

INSERT INTO horses
VALUES
(1, "horse 1", 1, "comands 1, 1, 1", '2022-05-01'),
(2, "horse 2", 1, "comands 1, 2, 1", '2022-09-19');

ALTER TABLE camels
ADD commands VARCHAR(50) NULL,
ADD birth_date DATETIME;

INSERT INTO camels
VALUES
(1, "camel 1", 2, "comands 1, 1, 1", '2022-05-01'),
(2, "camel 2", 2, "comands 1, 2, 1", '2022-09-19');

ALTER TABLE donkeys
ADD commands VARCHAR(50) NULL,
ADD birth_date DATETIME;

INSERT INTO donkeys
VALUES
(1, "donkey 1", 3, "comands 1, 1, 1", '2022-05-01'),
(2, "donkey 2", 3, "comands 1, 2, 1", '2022-09-19');
```
![](D:\images\9.png)![9](https://github.com/stdrill/finalwork/assets/109695593/8e848887-16e6-4e9b-aa22-d7c8c5c975f7)


# 10. Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу
```
DROP TABLE camels;
```
![](D:\images\10_1.png)![10_1](https://github.com/stdrill/finalwork/assets/109695593/30250746-22fb-4172-be4f-2490b9959dfb)

```
SELECT *
FROM horses
UNION
SELECT *
FROM donkeys;
```
![](D:\images\10_2.png)![10_2](https://github.com/stdrill/finalwork/assets/109695593/f954bb23-0ae9-48a2-9b38-2c9c16f0e006)


# 11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
```
CREATE TABLE young_animals
 (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45),
	commands VARCHAR(50) NULL,
	birth_date DATETIME,
    age VARCHAR(50) NULL
 );

INSERT INTO young_animals(name, commands, birth_date, age)

SELECT 
	name, 
	commands, 
    birth_date,
    CONCAT(TIMESTAMPDIFF(YEAR, birth_date, NOW()), ' лет ', MOD(TIMESTAMPDIFF(MONTH, birth_date, NOW()), 12), " месяцев") AS age
FROM 
(
	SELECT name, commands, birth_date
	FROM dogs
	WHERE DATEDIFF(NOW(), birth_date) BETWEEN 365 AND 365 * 3
	UNION
	SELECT name, commands, birth_date
	FROM cats
	WHERE DATEDIFF(NOW(), birth_date) BETWEEN 365 AND 365 * 3
	UNION
	SELECT name, commands, birth_date
	FROM hamsters
	WHERE DATEDIFF(NOW(), birth_date) BETWEEN 365 AND 365 * 3
	UNION
	SELECT name, commands, birth_date
	FROM horses
	WHERE DATEDIFF(NOW(), birth_date) BETWEEN 365 AND 365 * 3
	UNION
	SELECT name, commands, birth_date
	FROM donkeys
	WHERE DATEDIFF(NOW(), birth_date) BETWEEN 365 AND 365 * 3
) as t_animals;
```
![](D:\images\11.png)![11](https://github.com/stdrill/finalwork/assets/109695593/0d2633b0-926a-43e3-b8b1-1abf08ab8347)


# 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
```
CREATE VIEW view_home_animals AS
	SELECT 
		ha.id as id,
		ha.name as name,
		a.name as name_animal
	FROM home_animals as ha
	LEFT JOIN animals as a
	ON ha.id_animal = a.id;
    
CREATE VIEW view_pack_animals AS
	SELECT 
		pa.id as id,
		pa.name as name,
		a.name as name_animal
	FROM pack_animals as pa
	LEFT JOIN animals as a
	ON pa.id_animal = a.id;

SELECT t_home_animals.*,
	view_home_animals.name as type_animal,
    view_home_animals.name_animal as kind_animal
FROM 
(    
	SELECT *
	FROM dogs
	UNION
	SELECT *
	FROM cats
	UNION
	SELECT *
	FROM hamsters
) as t_home_animals
INNER JOIN view_home_animals
ON t_home_animals.id_home_animals = view_home_animals.id
UNION
SELECT t_pack_animals.*,
	view_pack_animals.name as type_animal,
    view_pack_animals.name_animal as kind_animal
FROM 
(    
	SELECT *
	FROM horses
	UNION
	SELECT *
	FROM donkeys
) as t_pack_animals
INNER JOIN view_pack_animals
ON t_pack_animals.id_pack_animals = view_pack_animals.id;
```
![](D:\images\12.png)![12](https://github.com/stdrill/finalwork/assets/109695593/710bc0a7-2c26-498b-8691-651c06f50c33)


