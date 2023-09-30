/*table for admin registration */
create table register(name varchar(30),password varchar(30),contactNo varchar(30),email varchar(30));
/*table for student registeration*/
create table student(sname varchar(30),sroll varchar(30),pmarks varchar(30),cmarks varchar(30),mmarks varchar(30),hmarks varchar(30),emarks varchar(30),grade varchar(30));

/*insertion in register table*/
insert into register values('abc','123','6576537887','abc@gmail.com');
insert into register values('xyz','111','8673537898','xyz@yahoo.com');
insert into register values('sita','123','7986538653','abc@gamil.com');
insert into register values('pooja','123','657653757','p@hamil.com');

/*insertion into student table*/

insert into student values('ramji','1','90','91','92','93','94','95');
insert into student values('sita','2','89','90','91','92','93','A+');