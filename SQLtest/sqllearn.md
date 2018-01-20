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


