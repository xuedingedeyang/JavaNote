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
		//ʹ��Properties����������ļ�
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	
	public void createTable(String sql) throws ClassNotFoundException
	{
		//��������
		Class.forName(driver);
		try {
			//��ȡ���ݿ�����
			Connection conn = DriverManager.getConnection(url,user,pass);
			//ʹ��Connection������һ��Statement����
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
		System.out.println("-----------����ɹ�------------");
	}

}
