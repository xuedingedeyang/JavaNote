delimeter  //  把sql语句结束符更换为指定字符，次处换为了//，即以后sql语句必须输入//后才会执行

insert 子查询

insert table_name set col_name={expr|DEFAULT},...

可以将查询到的结果插入指定的表中

insert into tble_name [col_name,...] select... 

ex:insert test02(username) select username from users where age>=30;

查询某列的平均值

ex:select AVG(goods_price) from tdb_goods;

对平均值结果进行小数点精确度控制，如保留到小数点后两位

ex:select round(avg(goods_price),2) from tdb_goods;

any some all修饰符

any some 表示只要符合其中某一个就行

all 表示要符合全部

ex: SELECT goods_id,goods_name,goods_price FROM tdb_goods WHERE goods_price> all (SELECT goods_price FROM tdb_goods WHERE goods_cate='超级本');

上述语句表示查询价格大于超级本的价格的商品，其中'>'后面为一个子查询

<strong>表连接</strong>

inner join 表示两个集合重和部分

left join 表示两个集合重合部分及左边集合所有的元素

right join 表示两个集合重合部分及右边集合所有的元素

可以用on做连接条件

ex:SELECT goods_id,goods_name,cate_name FROM tdb_goods right JOIN tdb_goods_cates ON tdb_goods.cate_id = tdb_goods_cates.cate_id;

sql函数

字符函数

concat() 字符连接，可以连接多个字符

concat_ws()  使用指定的分割符进行字符串连接，第一个参数为分隔符

format() 数字格式化

lower() upper()  分别完成字符大小写转换

left()  right() 分别获取左，右侧字符

length() 取得字符串长度

ltrim()  rtrim 分别表示去掉前，后导空格，也可以删除指定前导字符

replace() 将字符串中子串用指定字符串代替

substring() 截取字符串

like 模式匹配

ex：select concat('_'.'liu','yang');  结果liu_yang

ex:select format(9897.43,1);  结果:9897.4

ex:select left('mysql'); 结果：my

ex:select ltrim(leading '?' from '??MySQL??'); 结果:MySQL??

ex:select replace('??My??SQL???','??','!'); 结果:!My!SQL!?

ex:select * from test where first_name like '%1%%' escape '1';此处用1和escape转义，escape表示1后面%不再是通配符 <strong>%</strong>代表<strong>任意个字符</strong>,而<strong> _</strong> 代表<strong>任意一个字符</strong>

数值运算函数

ceil()  floor() 向上，下取整

div() 整数除法  类似C语言中的int型进行除法运算

mod() 取余 与%等价

power() 幂运算

round() 四舍五入

truncate() 数字截断

ex:select power(2,3); 结果：8

ex:select round(39.76,1); 结果:39.8

比较运算符与函数

[not] between ... and ... [不]在范围内，返回0(真)，1(假)

[not] in [不]在列出值范围内

is [not] null [不]为空

日期时间函数

now() 当前日期和时间  

curdate()  当前日期

curtime 当前时间

date_add() 日期变化

datediff 日期差值

date_formate() 日期格式化 

ex:select date_add('2018-1-20',interval 365 day); 结果:2019-1-20

ex:select datediff('2018-1-20','2020-2-15'); 结果，-756

聚合函数

avg() 平均值

count() 计数

max() min() sum() 最大值，最小值，和

加密函数

md5() 信息摘要算法

password() 密码算法



mysql自定义函数

create function function_name returns {string|integer|real|decimal} routine_body

ex: create function f1() returns varchar(30) return date_format(now(),'%Y年%m月%d日%H点:%i分:%s秒');

select f1();

结果2018年01月21日13点:08分:27秒

创建存储过程
(注意：创建存储过程或自定义函数时经常需要通过delimiter语句修改定界符，如果函数体或过程体有多个语句，需要包含在begin ... end 语句块中，存储过程通过call来调用)

create [definer = {user|current_user}] procedure sp_name ([proc_parameter[,...]]) [characteristic ...] routine_body

ex:create procedure sp1() select version();

ex:

delimeter //

create procedure removeUserById(IN p_id int unsigned)

begin 

delete from users where id = p_id;

end

//

ex:delimiter //

create procedure removeUserAndReturnUserNums(in p_id int unsigned,out userNums int unsigned)

begin 

delete from users where id=p_id;

select count(id) from users into userNums;

end 

//


调用

call sp_name(parameter[,...])

call sp_name[()]

ex:call removeUserById(11);

ex:call removeUserAndReturnUserNums(27,@nums);

修改存储过程

alter procedure sp_name[characteristic ...]

comment 'string'

|{containt sql|no sql|reads sql data|modifies sql data} | sql security{definer|invoker}

row_count()函数为得到插入，删除，更新受影响的行数

续存储过程

ex:

delimiter //

create procedure removeUserByAgeAndReturnInfos(in p_age smallint unsigned,out deleteUsers smallint unsigned,out userCounts smallint unsigned)

begin

delete from users where age = p_age;

select row_count() into deleteUsers;

select count(id) userCounts;

end

//

调用

ex:call removeUserByAgeAndReturnInfos(32,@a,@b);

<strong>存储过程与自定义函数的区别</strong>

- 存储过程实现的功能要复杂一些，而函数针对性更强
- 存储过程可以返回多个值，函数只能有一个返回值
- 存储过程一般独立执行，而函数可以作为其他sql语句的组成部分来出现
- 平时很少使用函数，但存储过程经常使用，通过api调用来实现存过程没有直接使用sql存储过程来得快



存储引擎:MySQL可以将数据以不同的技术存储在文件(内存)中，这种技术就称为存储引擎，每一种存储引擎使用不同的存储机制，索引技巧，锁定水平，最终提供广泛且不同的功能

MySQL有如下几种存储引擎

- MyISAM
- InnoDB
- Memory
- CSV
- Archive

锁

- 共享锁(读锁)：在同一时间内，多个用户可以读取同一个资源，读取过程中数据不会发生任何变化。
- 排它锁(写锁)：在任何时候只有一个用户能写入资源，当进行写锁时会阻塞其他读锁或写锁操作

![](https://img3.mukewang.com/5a643a3100016a4512800720.jpg)

创建数据表时指定存储引擎

ex:create table tb1(s1 varchar(24)) engine = MyISAM;

也可以通过修改数据表命令实现设置存储引擎

ex:alter table tb1 engine = InnoDB;







