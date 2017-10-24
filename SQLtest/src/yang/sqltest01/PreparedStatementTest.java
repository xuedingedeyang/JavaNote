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
							+ "null , '����" + i + "' , 1);");
				}
				System.out.println("ʹ��Statement��ʱ:" + (System.currentTimeMillis() - start));
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
			//ʹ��Connection������һ��PreparedStatement����
			PreparedStatement pstmt = conn.prepareStatement("insert into student values(null,?,2)");
			{
				//100��ΪPreparedStatement�Ĳ�����ֵ���Ϳ��Բ���100������
				for(int i = 0 ; i < 100 ; i++)
				{
					pstmt.setString(1,"����" + i);
					pstmt.executeUpdate();
				}
				System.out.println("ʹ��PreparedStatement��ʱ:" + (System.currentTimeMillis()-start));
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
