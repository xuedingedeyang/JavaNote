package yang.sqltest01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseMetaDataTest {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String pass;
	
	
	public void initParam(String paramFile) throws FileNotFoundException, IOException
	{
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	
	public void info() throws Exception
	{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,pass);
		//获取DatabaseMetaData对象
		DatabaseMetaData dbmd = conn.getMetaData();
		//获取MySql支持的所有表类型
		ResultSet rs = dbmd.getTableTypes();
		System.out.println("--------MySQL支持的表类类型-----");
		printResultSet(rs);
		//获取当前数据库的所有数据表
		rs = dbmd.getTables(null, null, "%", new String[]{"TABLE"});
		System.out.println("——————————当前数据库的数据表信息---------");
		printResultSet(rs);
		//获取student表的主键
		rs = dbmd.getPrimaryKeys(null, null, "student");
		System.out.println("-------student表的主键信息--------");
		printResultSet(rs);
	}

	private void printResultSet(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		//打印ResultSet的所有标题
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			System.out.println(rsmd.getColumnName(1 + i) + "\t");
		}
		System.out.println("\n");
		while(rs.next())
		{
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				System.out.println(rs.getString(i + 1) + "\t");
			}
			System.out.println("\n");
		}
		
	}

	public static void main(String[] args) throws Exception {
		DatabaseMetaDataTest dt = new DatabaseMetaDataTest();
		dt.initParam("my.ini");
		dt.info();
	}

}
