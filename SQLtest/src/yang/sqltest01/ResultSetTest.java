package yang.sqltest01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class ResultSetTest {
	
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
	
	public void query(String sql) throws ClassNotFoundException
	{
		Class.forName(driver);
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			{
				rs.last();
				int rowCount = rs.getRow();
				for (int i = rowCount; i > 0; i--)
				{
					rs.absolute(i);
					System.out.println(rs.getString(1) + "\t" + rs.getString(2)
					 + "\t" + rs.getShort(3));
					//修改记录指针所指记录第二列的值
					rs.updateString(2,"学生名" + i);
					//提交修改
					rs.updateRow();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showResult(String sql) throws ClassNotFoundException
	{
		Class.forName(driver);
		try {
			Connection conn = DriverManager.getConnection(url,user,pass);
			PreparedStatement prstmt = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			boolean hasResult = prstmt.execute();
			if(hasResult)
			{
				ResultSet rs = prstmt.getResultSet();
				ResultSetMetaData rsmd = rs.getMetaData();
				while(rs.next())
				{
					for(int i = 0 ; i < rsmd.getColumnCount() ; i++)
					{
						System.out.println(rs.getString(i+1) + "\t");
					}
					System.out.println("\n");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ResultSetTest rt = new ResultSetTest();
		rt.initParam("my.ini");
		rt.query("select * from student");
//		rt.showResult("select * from student");
	}

}
