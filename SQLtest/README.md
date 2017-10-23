创建新的数据库:

create database [if not exists] 数据库名     

删除数据库名:

drop database 数据库名   

进入指定数据库:

use 数据库名  

查看当前数据库的数据表:

show tables  

查看数据库结构:

desc 表名  

建表:

create table [模式名.] 表名(column1 datatype [default expr], ...);  

如：create table  test( test_id int,test_price decimal,test_name varchar(255) default 'xxx',test_desc text,test_imag blob,test_date datetime);

建表同时插入数据:

create table [模式名.] 表名 [column [,column ...]] as subquery

如：create table hehe as select * from user_inf;

修改表结构:

alter table 表名
add
(
 column_name1 datatype [default expr],
 ...  
)

如：alter table hehe add hehe_id int;
如：
alter table hehe
add
(
    aaa varchar(255) default 'xxx',
    bbb varchar(255)
);

修改列定义:

alter table 表名
modify column_name datatype [default expr] [first|after col_name];

如:alter table hehe
   modify hehe_id varchar(255);

从数据表中删除列:

alter table 表名
drop column_name

如：
alter table hehe drop aaa;

重命名数据表:

alter table 表名
rename to 新表名;

如：
alter table hehe rename to wawa;

改变列名:

alter table 表名
change old_column_name new_cloumn_name datatype [default expr] [first|after col_name]

如：
alter table wawa change bbb ddd int;

删除表:
drop table 表名;

删除表的数据单不删除表的结构:

truncate 表名;



约束:
not null 约束：
如：
create table hehe
(
    hehe_id int not null;
    hehe_name varchar(255) default 'xyz' not null,
    hehe_gender varchar(2) null
);

增加非空约束:

如：alter table hehe modify hehe_gender varchar not null;

取消非空约束

如:alter table hehe modify hehe_name varchar(2) null;

unique约束
如：
create table unique_test
(
    test_id int not null,
    test_name varchar(255) unique
);

建表时创建唯一约束，使用表级约束语法建立约束

如：
create table unique_test2
(
    test_id int not null,
    test_name varchar(255),
    test_pass varchar(255),
    unique (test_name),
    constraint test2_uk unique(test_pass)
);  其中test2_uk 为指定的约束名

或:
create table unique_test3
(
    test_id int not null,
    test_name varchar(255),
    test_pass varchar(255),
    constraint test_uk unique(test_name,test_pass)
);
也可以在修改表结构时使用add关键字来增加唯一约束

如：
alter table unique_test3 add unique(test_name,test_pass);

或修改表时用modify关键字

ex:
alter table unique_test3 modify test_name varchar(255) unique;

删除约束

drop index 约束名;

ex:
alter table unique_test3 drop index test3_uk;

列级primary key 约束

ex:
create table primary_test
(
    test_id int primary key,
    test_name varchar(255)
);

表级primary key 约束

ex:
create table primary_test2
(
    test_id int not null,
    test_name varchar(255),
    test_pass varchar(255),
    constraint test_pk primary key(test_id)
);

多列组合建立primary key约束

ex:
create table primary_test3
(
  test_name varchar(255),
  test_pass varchar(255),
  primary key(test_name,test_pass)
);

删除主键约束

ex:
alter table primary_test3 drop primary key;

增加主键约束

ex:
alter table primary_test3 add primary key(test_name,test_pass);

ex:
alter table primary_test3 modify test_name varchar(255) primary key;

auto_increment 约束

ex:
create table primary_test4
(
    test_id int auto_increment primary key,
    test_name varchar(255),
    test_pass varchar(255)
);

foreign key约束(即参照外表)

ex:
create table teacher_table
(
  teacher_id int auto_increment,
  teacher_name varchar(255),
  primary key(teacher_id)
);

create table student_table
(
  student_id int auto_increment primary key,
  student_name varchar(255),
  java_teacher int references teacher_table(teacher_id)
);

（但上述方法在MySQL中无效，MySQL应使用表级约束法，如下）

ex:
create table student_table1
(
  student_id int auto_increment,
  student_name varchar(255),
  java_teacher int,
  foregin key(java_teacher) references teacher_table(teacher_id)
);

如果需显式指定外键约束名,或建立多列组合的外键约束，可使用constraint

ex:
create table teacher_table2
(
    teacher_id int auto_increment,
    teacher_name varchar(255),
    primary key(teacher_id)
    teacher_pass varchar(255),
    #primary key(teacher_name,teacher_pass)
);

create table student_table2
(
    student_id int auto_increment primary key,
    student_namr varchar(255),
    java_teacher int,
    constraint student_teacher_fk foreign key(java_teacher) references teacher_table2(teacher_id)
    #或foreign key(java_teacher_name,java_teacher_pass) references teacher_table3(teacher_name,teacher_pass)
);

删除外键约束

alter table 表名 drop foreign key 约束名

ex:删除student_table3表上名为student_table3_ibfk_1的外键约束
alter table student_table2 drop foreign key student_table3_ibfk_1;

增加外键

ex:
alter table student_table3
add foreign key (java_teacher_name,java_teacher_pass) references teacher_table3(teacher_name.teacher_pass);

自关联外键约束(外键参照自己)

ex:
create table foreign_test
(
    foreign_id int auto_increment primary key,
    foreign_name varchar(255),
    refer_id int,
    foreign key(refer_id) references foreign_test(foreign_id)
);

设置删除主表记录时，从表也删除

create table teacher_table4
(
    teacher_id int auto_increment,
    teacher_name varchar(255),
    primary key (teacher_id)
);

create table student_table4
(
    student_id int auto_increment primary key,
    student_name varchar(255),
    java_teacher int,
    foreign key (java_teacher) references teacher_table4 (teacher_id) on delete casecade(或 on delete set null)
);

check约束(MySQL不支持check约束)

ex:
creata table check_test
(
    emp_id auto_increment,
    amp_salary decimal,
    primary key(emp_id),
    check(emp_salary>0)
)



索引

创建索引:
create index index_name on table_name(column[,column]...);

ex:
create index emp_last_name on employees(last_name);

同时对多列创建索引

ex:
create index emp_last_name_index2 on employees (first_name,last_name);

删除索引:

ex:
drop index emp_last_name on employees;



DML语句

ex:
insert into teacher_table2(teacher_name) values('xyz');
insert into teacher_table2 values(null,'abc');

插入多列：

ex:
insert into student_table2 (student_name) select teacher_name from teacher_table2;

insert into teacher_table2 values (null,"yaya"),(null,"nana");

update语句

ex:
下面语句会改变teacher_table这一列的所有值

update teacher_table2 set teacher_name = '孙悟空';

修改特定条件

ex:
update teacher_table2 set teacher_name = '唐僧' where teacher_id > 1;

delete语句

ex:
delete from student_table;该句删除表里的所有记录

delete from teacher_table where teacher_id > 2;

(当定义外键约束没有定义级联删除on delete cascade 或 on delete set null 时，从表记录没删除就无法删除主表记录)


单表查询

select column1,column2 ... from 数据源 [where condition];

查询所有行:

ex:
select * from teacher_table;

查询特定行:

ex:
select student_name from student_table where java_teacher >= 3;

使用算术符

ex：
select teacher_id + 5 from teacher_table;

select 3*5 , 20 from teacher_table;

字符串连接函数

select concat(teacher_name , 'xx') from teacher_table;

修查询结果改列标题

select teacher_id + 5 as my_id from teacher_table;

select teacher_id + 5 "my id" , teacher_name 老师名 from teacher_table;

select ,where语句可以都不出现列名(where语句相当于if语句)

ex:
select 5 + 4 from teacher_table where 2 < 9;

distinct清除查询结果的重复行

ex:
select distinct student_name,java_teacher from student_table;

between 运算符

ex:
select * from teacher_table where teacher_id between 2 and 4; 查询student_id在2到4之间的结果

select * from student_table where 2 between java_teacher and studet_id;

select * from student_table where 2 in (student_id,java_teacher);

like模糊查询

ex:
select * from student_table where student_name like '孙%'; 查询学生姓名以‘孙’开头的的学生

select * from student_table where student_name like '__'; 查询名字为两个字的所有学生


转义

ex:
select * from student_table where student_name like '\_%' escape '\';（标准sql语句）
select * from student_table where student_name like '\_%';(MySQL支持)

and 和 or 组合条件 以及 not 否定

ex:
select * from student_table where student_name like '_%' and student_id > 3;

select * from student_table where not student_name like '\_%';

select * from student_table where (student_id > 3 or student_name > '张') and java_teacher > 1;

order by顺序

ex:
select * from student_table order by java_teacher; 按java_teacher升序排列

select * from student_table order by java_teacher desc , student_name 按java_teacher降序排列，同时按student_name升序排列



数据库函数

简单单行函数：


选出teacher_table中teacher_name列的字符长度

ex:
select char_length (teacher_name) from teacher_table;

计算teacher_name列的字符长度sin值

ex:
select sin(char_length(teacher_name)) from teacher_table;

计算sin（1.57）

ex:
select sin(1.57);

获取当前日期

ex:
select curdate();

获取当前时间

ex:
select curtime();

MD5函数

ex:
select md5("testing");

MySQL提供处理null的函数：

ifnull(expr1,expr2) 如果expr1为null，返回expr2，否则返回expr1;

nullif（expr1，expr2） 如果expr1与expr2相等，则返回null，否则返回expr1;

if(expr1,expr2,expr3) 类似三目运算符 ? :

isnull(expr1) expr1为null返回true，反之为false


case函数

ex:如果java_teacher 为 1，则返回‘java老师’，为2返回‘ruby老师’，否则返回‘其他老师’

select student_name ,case java_teacher
when 1 then 'java老师'
when 2 then 'ruby老师'
else '其他老师'
end from student_table;

ex2：
select student_name ,case java_teacher
when student_id < 3 then '初级班'
when student_id < 6 then '中极版'
else '高级班'
end from student_table;


分组和组函数

count({*|[distinct|all]expr}) 计算多行expr的总条数

ex:计算student_table表中记录的条数

select count(*) from student_table;


sum([distinct|all] expr) 计算多行expr的总和

ex:计算所有student_id的总和

select sum(student_id) from student_table;


max(expr) 和 min(expr)  分别是计算多行expr的最大值和最小值

ex:选出student_table 表中 student_id 最大值

select max(student_id) from student_table;


ex:计算java_teacher列所有记录的平均值

select avg(ifnull(java_teacher,0)) from student_table;


group by 子句

ex:将java_teachcer 列值相同记录当成一组

select count(*) from student_table group by java_teacher;

如果对多列进行分组，则要求多列的值完全相同才会当成同一组

ex:
select count(*) from student_table group by java_teacher,student_name;


having子句与where子句的区别：

1,不能在where子句中过滤组，where子句仅用于过滤行，过滤组必须使用having子句

2，不能在where子句中使用组函数，having子句中才可以使用组函数

ex:
select * from student_table group by java_teacher having count(*) > 2;



多表连接查询

SQL92的连接查询


ex：查询所有学生的资料以及对应老师的名字

select s.* , teacher_name from student_table s,teacher_table t where s.java_teacher = t.teacher_id;


ex:不使用连接条件，得到广义笛卡尔积

select s.* ,teacher_name from student_table s,teacher_table t;

select s.* , teacher_name from student_table s,teacher_table t where s.java_teacher > t.teacher_id;


自连接

ex:
create table emp_table
(
    emp_id int auto_increment primary key,
    emp_name varchar(255),
    manager_id int,
    foreign key(manager id) references emp_table (emp_id)
);

select emp.emp_id , emp.emp_name 员工名 ,mgr.emp_name 经理名 from emp_table emp,emp_table mgr where emp.manager_id = mgr.emp_id;


SQL99的连接查询

交叉连接

ex:
select s.*,teacher_name from student_table s cross join teacher_table t;

using子句连接

ex:
select s.*,teacher_name from student_table s join teacher_table t using(teacher_id);

on子句连接

ex:
select s.* , teacher_name from student_table s join teacher_table t on s.java_teacher = t.teacher_id;


下列语句就是sql99中的非等值连接

ex:
select s.* , teacher_name from student_table s join teacher_table t on s.java_teacher > t.teacher_id;

左、右、全外连接

ex:右外连接，连接条件是非等值连接

select s.*,teacher_name
from student_table s
right join teacher_table t
on s.java_teacher > t.teacher_id;

ex:左外连接，连接条件是非等值连接

select s.*,teacher_name
from student_table s
left join teacher_table t
on s.java_teacher > t.teacher_id;


子查询

把子查询当成数据表

ex:
select *
from (select * from student_table) t
where t.java_teacher > 1;

把子查询当成where条件中的值

select * from student_table where java_teacher > (select * from teacher_table where teacher_name = '唐僧');

=any结合与in作用相同：
select * from student_table where student_id = any(select teacher_id from teacher_table);

选出student_table表中student_id大于teacher_table表中所有teacher_id的记录

ex:
select * from student_table where student_id > all(select teacher_id from teacher_table);


集合运算

union（并）

select * from teacher_table union select student_id , student_name from student_table;

minus（MySQL不支持）

select student_id ,student_name from student_table

minus
select teacher_id ,teacher_name from teacher_table;
