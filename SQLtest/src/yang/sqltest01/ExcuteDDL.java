package yang.sqltest01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ExcuteDDL {
	
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	public void initParam(String paramFile) throws FileNotFoundException, IOException
	{
		//使用Properties类加载属性文件
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	
	public void createTable(String sql) throws ClassNotFoundException
	{
		//加载驱动
		Class.forName(driver);
		try {
			//获取数据库连接
			Connection conn = DriverManager.getConnection(url,user,pass);
			//使用Connection来创建一个Statement对象
			Statement stmt = conn.createStatement();
			{
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ExcuteDDL ed = new ExcuteDDL();
		ed.initParam("my.ini");
		ed.createTable("create table bb"
				+ "(jdbc_id int auto_increment primary key, "
				+ "jdbc_name varchar(255), "
				+ "jdbc_desc text);");
		System.out.println("-----------建表成功------------");
	}

}
