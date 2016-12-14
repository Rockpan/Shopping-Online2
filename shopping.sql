create database shopping;
use shopping;
-- 用户详细表 --
-- 用户详细id，用户真实姓名，性别，身份证号，电话，用户地址 --
create table userDetail(
user_detailId int  auto_increment primary key,
 
user_realName varchar(10),

user_sex char(2),

user_IdCard char(18),

user_phone char(11),

user_address varchar(200)
);

insert into userDetail (user_realName,user_sex,user_IdCard,user_phone,user_address) values('a','男','371102199307182931','15864279602','上海');
select * from userdetail;
-- 用户登录表 --
-- 主键，登录名，密码，用户详细表的id--
create table userLogin(
user_id int auto_increment primary key,
user_name varchar(10) unique,
user_password varchar(20),
user_detailId int,
constraint fk_userDetail_userLogin foreign key (user_detailId) references userDetail (user_detailId)
);
insert into userLogin (user_name,user_password,user_detailId) values('123456','123456','1');
select * from userlogin;

select user_password from userLogin where user_name='123456';
-- 卖家详情表 --
-- 主键，商铺名字，卖家真实姓名，身份正好，电话，地址--
create table sellerDetail(
seller_detailId int auto_increment primary key,
 
store_name varchar(20),
 
seller_realName varchar(10),

seller_IdCard varchar(20),

seller_phone varchar(20),

seller_address varchar(200)
);
insert into sellerdetail(store_name,seller_realName,seller_IdCard,seller_phone,seller_address)values('运动鞋店','hehe','371102199307182931','15864279602','上海');

-- 卖家登录表 --
-- 主键，登录名，登录密码，外键：卖家详情表--
create table sellerLogin(
seller_id int auto_increment primary key,
seller_name varchar(10),
seller_password varchar(20),
seller_detailId int,
constraint fk_sellerDetail_sellerLogin foreign key (seller_detailId) references sellerDetail (seller_detailId )
);
insert into sellerlogin(seller_name,seller_password)values('123456','123456');
-- 商品表 --
-- 主键，商品名字，商品图片，原价，现价，分类，外键；卖家详情表--
create table product(
product_id int auto_increment primary key,

product_name varchar(20) not null,

product_price int not null,

product_category varchar(10) not null,
product_description varchar(100) not null,
seller_detailId int not null,
constraint fk_product_sellerDetail foreign key (seller_detailId) references sellerDetail(seller_detailId )
);

-- state 1代表未发货，2表示一发货--
-- 订单表 --
-- 主键，订单id，商品状态，总价格，商品外键：商品表，用户外键：用户详细表--
create table orderProduct(

order_id int auto_increment primary key,

order_card varchar(20) default null,

product_state int default 1,

product_id int,

user_id int,

constraint fk_order_product foreign key (product_id) references product(product_id),

constraint fk_order_userLogin foreign key (user_id) references userLogin(user_id)

);
-- 购物车--
-- 主键,某一个商品的总数,外键: 商品表,外键:用户登录表--
create table car(
 car_id int auto_increment primary key,
 product_count int,
 product_id int,
 user_id int,
 constraint fk_car_product foreign key (product_id) references product(product_id),
 constraint fk_car_userLogin foreign key (user_id) references userLogin(user_id)
);
-- create table managerLogin(
-- manager_id int auto_increment primary key,
-- manager_name varchar(10),
-- manager_password varchar(10)
-- ); 

create table comment(
comment_id int auto_increment primary key,
comment_content varchar(100),
product_id int not null,
user_id int not null,
 constraint fk_comment_product foreign key (product_id) references product(product_id),
 constraint fk_comment_userLogin foreign key (user_id) references userLogin(user_id)
);

insert into comment (comment_content,product_id,user_id) values('真好',1,1);
select * from comment;
select * from comment order by comment_id desc limit 1;

insert into managerLogin values (1,'rock','12345');
select * from managerLogin;


insert into sellerdetail(store_name,seller_realName,seller_IdCard,seller_phone,seller_address)
values('地方店','hehe','371102199307282931','15863479602','上海');
insert into sellerdetail(store_name,seller_realName,seller_IdCard,seller_phone,seller_address)
values('升水店','hehe','371102199407282931','15863479602','北京');
insert into sellerdetail(store_name,seller_realName,seller_IdCard,seller_phone,seller_address)
values('广告店','hehe','371103199307282931','15863479602','杭州');
insert into sellerdetail(store_name,seller_realName,seller_IdCard,seller_phone,seller_address)
values('恋恋店','hehe','371101199307282931','15863479602','上海');


insert into sellerlogin(seller_name,seller_password,seller_detailId)values('2','2',2);
insert into sellerlogin(seller_name,seller_password,seller_detailId)values('3','3',3);
insert into sellerlogin(seller_name,seller_password,seller_detailId)values('4','4',4);


insert into product(product_name,product_image,product_pre_price,product_now_price,product_category,product_description,seller_id)
values('阿迪鞋','2',800,700,'鞋','适合穿着打篮球',2);
insert into product(product_name,product_image,product_pre_price,product_now_price,product_category,product_description,seller_id)
values('美特斯邦威衣服','3',1800,1700,'衣服','休闲',2);
insert into product(product_name,product_image,product_pre_price,product_now_price,product_category,product_description,seller_id)
values('休闲裤','5',2800,2700,'裤子','休闲',2);


insert into  orderProduct values(1,'120414316629',2,700,1,1);
insert into  orderProduct values(2,'120414316629',1,700,1,1);
insert into  orderProduct values(3,'120414216629',2,600,1,1);
insert into  orderProduct values(4,'120514316629',2,700,4,1);
insert into  orderProduct values(5,'120414336629',1,1700,5,1);
insert into  orderProduct values(6,'120414316629',2,400,6,1);
insert into  orderProduct values(7,'120414316629',2,700,7,1);
insert into  orderProduct values(8,'120414316629',1,2700,8,1);