set names utf8;
set foreign_key_checks = 0;
drop database if exists fansite;

create database if not exists fansite;
use fansite;

drop table if exists login_user_info;

create table login_user_info(
id int not null primary key auto_increment,
user_name varchar(255)unique,
sex varchar(255),
user_password varchar(255),
insert_date datetime
);

drop table if exists item_buy_transaction;

create table item_buy_transaction(
id int not null primary key auto_increment,
item_transaction_id varchar(255),
total_price varchar(255),
total_count varchar(255),
user_master_id varchar(255),
buy_complete_Flg varchar(10),
insert_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
item_id int not null primary key auto_increment,
item_name varchar(255),
item_price varchar(255),
item_image_path varchar(255),
item_stock varchar(255),
insert_date datetime,
delete_date datetime
);

drop table if exists chat;

create table chat(
id int not null primary key auto_increment,
name varchar(255),
comment varchar(255),
insert_date datetime
);

INSERT INTO item_info_transaction(item_name, item_image_path, item_price, item_stock) VALUES("T-シャツ","./img/T-shits.png",1500,50);
INSERT INTO item_info_transaction(item_name, item_image_path, item_price, item_stock) VALUES("ステッカー","./img/stacker.PNG",800,50);
INSERT INTO item_info_transaction(item_name, item_image_path, item_price, item_stock) VALUES("キャップ","./img/cap.png",800,50);
INSERT INTO item_info_transaction(item_name, item_image_path, item_price, item_stock) VALUES("缶バッジ","./img/pin.PNG",200,50);
INSERT INTO item_info_transaction(item_name, item_image_path, item_price, item_stock) VALUES("ダミー1","./img/dummy.png",200,50);
INSERT INTO item_info_transaction(item_name, item_image_path, item_price, item_stock) VALUES("ダミー2","./img/dummy.png",200,50);
INSERT INTO item_info_transaction(item_name, item_image_path, item_price, item_stock) VALUES("ダミー3","./img/dummy.png",200,50);
INSERT INTO item_info_transaction(item_name, item_image_path, item_price, item_stock) VALUES("ダミー4","./img/dummy.png",200,50);
INSERT INTO item_info_transaction(item_name, item_image_path, item_price, item_stock) VALUES("ダミー5","./img/dummy.png",200,50);
INSERT INTO item_info_transaction(item_name, item_image_path, item_price, item_stock) VALUES("ダミー6","./img/dummy.png",200,50);
INSERT INTO item_info_transaction(item_name, item_image_path, item_price, item_stock) VALUES("ダミー7","./img/dummy.png",200,50);
INSERT INTO item_info_transaction(item_name, item_image_path, item_price, item_stock) VALUES("ダミー8","./img/dummy.png",200,50);
INSERT INTO item_info_transaction(item_name, item_image_path, item_price, item_stock) VALUES("ダミー9","./img/dummy.png",200,50);



