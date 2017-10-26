package yang.sqltest01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseMetaDataTest {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String pass;
	
	
	public void initParam(String paramFile) throws FileNotFoundException, IOException
	{
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	
	public void info() throws Exception
	{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,pass);
		//��ȡDatabaseMetaData����
		DatabaseMetaData dbmd = conn.getMetaData();
		//��ȡMySql֧�ֵ����б�����
		ResultSet rs = dbmd.getTableTypes();
		System.out.println("--------MySQL֧�ֵı�������-----");
		printResultSet(rs);
		//��ȡ��ǰ���ݿ���������ݱ�
		rs = dbmd.getTables(null, null, "%", new String[]{"TABLE"});
		System.out.println("����������������������ǰ���ݿ�����ݱ���Ϣ---------");
		printResultSet(rs);
		//��ȡstudent�������
		rs = dbmd.getPrimaryKeys(null, null, "student");
		System.out.println("-------student���������Ϣ--------");
		printResultSet(rs);
	}

	private void printResultSet(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		//��ӡResultSet�����б���
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			System.out.println(rsmd.getColumnName(1 + i) + "\t");
		}
		System.out.println("\n");
		while(rs.next())
		{
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				System.out.println(rs.getString(i + 1) + "\t");
			}
			System.out.println("\n");
		}
		
	}

	public static void main(String[] args) throws Exception {
		DatabaseMetaDataTest dt = new DatabaseMetaDataTest();
		dt.initParam("my.ini");
		dt.info();
	}

}
