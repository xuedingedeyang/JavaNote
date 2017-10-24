package yang.sqltest01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ExcuteSQL {

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
	
	public void executeSql(String sql) throws ClassNotFoundException
	{
		Class.forName(driver);
		try {
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			
			{
				//ִ��sql��䣬����booleanֵ��ʾ�Ƿ����ResultSet
				boolean hasResult = stmt.execute(sql);
				//���ִ�к���ResultSet�����
				if(hasResult)
				{
					ResultSet rs = stmt.getResultSet();
					{
						//ResultSetMetaData�����ڷ����������Դ���ݽӿ�
						ResultSetMetaData rsmd = rs.getMetaData();
						
						int columnCount = rsmd.getColumnCount();
						
						while(rs.next())
						{
							for(int i = 0 ; i < columnCount ; i++)
							{
								System.out.println(rs.getString(i + 1) + "\t");
							}
							System.out.println("\n");
						}
					}
				}
				else
				{
					System.out.println("��sql���Ӱ��ļ�¼��" + stmt.getUpdateCount() + "��");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		ExcuteSQL es = new ExcuteSQL();
		es.initParam("my.ini");
		System.out.println("----ִ��ɾ�����DDL���------");
		es.executeSql("drop table if exists aa");
		System.out.println("-------ִ�н����DDL���------");
		es.executeSql("create table my_test( "
				+ "test_id int auto_increment primary key, "
				+ "test_name varchar(255));");
		System.out.println("-------ִ�в������ݵ�DML���--------");
		es.executeSql("insert into my_test(test_name) "
				+ "select student_name from student");
		System.out.println("---------ִ�в������ݵ����----------");
		es.executeSql("select * from my_test");
	}

}
