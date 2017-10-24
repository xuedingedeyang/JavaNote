package yang.sqltest01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ExcuteSQL {

	private String driver;
	private String url;
	private String user;
	private String pass;
	
	public void initParam(String paramFile) throws FileNotFoundException, IOException
	{
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	
	public void executeSql(String sql) throws ClassNotFoundException
	{
		Class.forName(driver);
		try {
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			
			{
				//执行sql语句，返回boolean值表示是否包含ResultSet
				boolean hasResult = stmt.execute(sql);
				//如果执行后有ResultSet结果集
				if(hasResult)
				{
					ResultSet rs = stmt.getResultSet();
					{
						//ResultSetMetaData是用于分析结果集的源数据接口
						ResultSetMetaData rsmd = rs.getMetaData();
						
						int columnCount = rsmd.getColumnCount();
						
						while(rs.next())
						{
							for(int i = 0 ; i < columnCount ; i++)
							{
								System.out.println(rs.getString(i + 1) + "\t");
							}
							System.out.println("\n");
						}
					}
				}
				else
				{
					System.out.println("该sql语句影响的记录有" + stmt.getUpdateCount() + "条");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		ExcuteSQL es = new ExcuteSQL();
		es.initParam("my.ini");
		System.out.println("----执行删除表的DDL语句------");
		es.executeSql("drop table if exists aa");
		System.out.println("-------执行建表的DDL语句------");
		es.executeSql("create table my_test( "
				+ "test_id int auto_increment primary key, "
				+ "test_name varchar(255));");
		System.out.println("-------执行插入数据的DML语句--------");
		es.executeSql("insert into my_test(test_name) "
				+ "select student_name from student");
		System.out.println("---------执行插入数据的语句----------");
		es.executeSql("select * from my_test");
	}

}
