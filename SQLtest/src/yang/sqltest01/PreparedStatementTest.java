package yang.sqltest01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PreparedStatementTest {
	
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
	
	public void insertUseStatement()
	{
		long start = System.currentTimeMillis();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			{
				for(int  i = 0 ; i < 100 ; i++)
				{
					stmt.executeUpdate("insert into student values( "
							+ "null , '姓名" + i + "' , 1);");
				}
				System.out.println("使用Statement费时:" + (System.currentTimeMillis() - start));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertUsePrepare()
	{
		long start = System.currentTimeMillis();
		try {
			Connection conn = DriverManager.getConnection(url,user,pass);
			//使用Connection来创建一个PreparedStatement对象
			PreparedStatement pstmt = conn.prepareStatement("insert into student values(null,?,2)");
			{
				//100次为PreparedStatement的参数设值，就可以插入100条数据
				for(int i = 0 ; i < 100 ; i++)
				{
					pstmt.setString(1,"姓名" + i);
					pstmt.executeUpdate();
				}
				System.out.println("使用PreparedStatement费时:" + (System.currentTimeMillis()-start));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		PreparedStatementTest pt = new PreparedStatementTest();
		pt.initParam("my.ini");
		pt.insertUseStatement();
		pt.insertUsePrepare();

	}

}
