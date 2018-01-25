Oracle中表是基本存储单位，表存在表空间里


设置用户的默认或临时表空间

alter user username default|temporary tablespace tablespace_name

创建表空间

create [temporary] tablespace tablespace_name tempfile|datafile 'xx.dbf' size xx

ex:
永久表空间:create tablespace test1_tablespace datafile 'test1file.dbf' size 10m;

临时表空间:create temporary tablespace temptest1_tablespace tempfile 'tempfile1.dbf' size 10m;

dba_data_files表里存了数据文件相关信息，可以通过查询看到表空间文件相关信息

ex:select file_name from dba_data_files where tablespace_name='TEST1_TABLESPACE';注意表空间名字要大写

ex:select file_name from dba_temp_data_files where tablespace_name='TEST1_TABLESPACE';

修改表空间的状态

(设置脱机或联机状态)alter tablespace tablespace_name ONLINE|OFFLINE;

查看表空间状态

dba_tablespaces表里有一个status字段存储了表空间的状态，可以通过查询得到

ex:select status from dba_tablespaces where tablespace_name='TEST1_TABLESPACE';

(设置只读或可读写状态,必须在online状态下才能设置)alter tablespace tablespace_name read only|read write

增加|删除数据文件

alter tablespace table_spacename add|drop datafile 'xx.dbf' size xx;

ex:alter tablespace test1_tablespace add datafile 'test2_file.dbf' size 10m;


删除表空间

drop table_space tablespace_name [including contents]

Oracle数据类型

字符型

char(n), nchar(n) 固定长度，nchar是按Unicode来存放数据类型，一班用来存储汉字

varchar2(n),nvarchar2(n)

数值型

number(p,s) p是有效数字，s表示小数点后的位数

float(n)  

日期型

date

timestamp

其他类型

blob(二进制存放大文件)   clob(以字符串存储大文件)










