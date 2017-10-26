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
		//ʹ��Properties����������ļ�
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
				"insert into student values(null,'����Ϫ',1)",
				"insert into student values(null,'Ī����',2)",
				"insert into student values(null,'��Զ��',1)",
				//����sql��������쳣���Ӷ����������Զ��ع�,��Ϊteacher����û��idΪ1000�ļ�¼
				"inser into stdudent values(null,'������',1000)"
		};
		transaction.insertInTansaction(sqls);
	}

}
