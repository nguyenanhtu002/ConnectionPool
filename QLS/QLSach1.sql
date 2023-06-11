create database QLSach1
drop database QLSach
use QLSach1
use master
drop database QLSach
create table Sach
(
id int IDENTITY(1,1) primary key,
name nvarchar(100),
price decimal,
author nvarchar(100),
quantity int
)
select * from Sach

