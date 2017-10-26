package yang.sqltest01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetPage {
	
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

	public CachedRowSet query(String sql,int pageSize,int page) throws Exception
	{
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			{
				RowSetFactory factory = RowSetProvider.newFactory();
				CachedRowSet cachedRs = factory.createCachedRowSet();
				cachedRs.setPageSize(pageSize);
				//使用ResultSet装填RowSet，设置从第几条记录开始
				cachedRs.populate(rs,(page-1)*pageSize + 1);
				return cachedRs;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CachedRowSetPage cp = new CachedRowSetPage();
		cp.initParam("my.ini");
		CachedRowSet rs = cp.query("select * from student", 3, 2);
		while(rs.next())
		{
			System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
		}
	}

}
