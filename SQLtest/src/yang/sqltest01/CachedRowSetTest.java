package yang.sqltest01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetTest {
	
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
	
	public CachedRowSet query(String sql) throws Exception
	{
		Class.forName(driver);
		
		try {
			Connection conn = DriverManager.getConnection(url,user,pass);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				//ʹ��RowSetProvider����RowSetFactory;
				RowSetFactory factory = RowSetProvider.newFactory();
				//����Ĭ�ϵ�CachedRowSetʵ��
				CachedRowSet cachedRs = factory.createCachedRowSet();
				//ʹ��ResultSet��װRowSet
				cachedRs.populate(rs);
				//�ر���Դ
				rs.close();
				stmt.close();
				conn.close();
				return cachedRs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		CachedRowSetTest ct = new CachedRowSetTest();
		
		ct.initParam("my.ini");
		CachedRowSet rs =ct.query("select * from student");
		rs.afterLast();
		//��ǰ���������
		while(rs.previous())
		{
			System.out.println(rs.getString(1) + "\t"
					+rs.getString(2) + "\t"
					+rs.getString(3));
			if(rs.getInt("student_id") == 3)
			{
				//�޸�ָ���еļ�¼
				rs.updateString("student_name", "������");
				rs.updateRow();
			}
		}
	
		//���»�ȡ���������
		Connection conn = DriverManager.getConnection(url,user,pass);
		conn.setAutoCommit(false);
		//�Ѷ�RowSet�����޸�ͬ�����ײ����ݿ�
		rs.acceptChanges(conn);
	}

}