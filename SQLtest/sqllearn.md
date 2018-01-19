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



