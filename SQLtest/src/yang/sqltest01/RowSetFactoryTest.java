package yang.sqltest01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowSetFactoryTest {
	
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

	public void update(String sql) throws Exception
	{
		Class.forName(driver);
		//使用RowSetProvider创建RowSetFactory实例
		RowSetFactory factory = RowSetProvider.newFactory();
		JdbcRowSet jdbcRs = factory.createJdbcRowSet();
		jdbcRs.setUrl(url);
		jdbcRs.setUsername(user);
		jdbcRs.setPassword(pass);
		jdbcRs.setCommand(sql);
		jdbcRs.execute();
		jdbcRs.afterLast();
		//向前滚动结果集
		while(jdbcRs.previous())
		{
			System.out.println(jdbcRs.getString(1) + "\t" + jdbcRs.getString(2) + "\t"
					+ jdbcRs.getShort(3));
			if(jdbcRs.getInt("student_id") == 3)
			{
				jdbcRs.updateString("student_name", "梅超风");
				jdbcRs.updateRow();
			}
		}
	}
	
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		RowSetFactoryTest test = new RowSetFactoryTest();
		test.initParam("my.ini");
		test.update("select * from student");
	}

}
