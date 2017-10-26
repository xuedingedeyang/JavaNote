package yang.sqltest01;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class TransactionTest {
	
	private String driver;
	private String url;
	private String user;
	private String pass;
	private static PreparedStatement insert;
	private static PreparedStatement query;
	
	
	public void initParam(String paramFile) throws Exception
	{
		//使用Properties类加载属性文件
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	
	public void insertInTansaction(String[]  sqls) throws Exception
	{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,pass);
		conn.setAutoCommit(false);
		Statement statement =conn.createStatement();
		for(String sql : sqls)
		{
			statement.execute(sql);
		}
		
		conn.commit();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TransactionTest transaction = new TransactionTest();
		transaction.initParam("my.ini");
		
		String[] sqls = new String[]{
				"insert into student values(null,'张松溪',1)",
				"insert into student values(null,'莫声谷',2)",
				"insert into student values(null,'宋远桥',1)",
				//下面sql语句引发异常，从而导致事务自动回滚,因为teacher表中没有id为1000的记录
				"inser into stdudent values(null,'俞莲舟',1000)"
		};
		transaction.insertInTansaction(sqls);
	}

}
