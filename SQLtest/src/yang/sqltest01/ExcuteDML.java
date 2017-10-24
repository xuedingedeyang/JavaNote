package yang.sqltest01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ExcuteDML {
	
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
	
	public int insertData(String sql) throws ClassNotFoundException
	{
		//��������
		Class.forName(driver);
		try {
			//��ȡ���ݿ�����
			Connection conn = DriverManager.getConnection(url,user,pass);
			//ʹ��Connection������һ��Statement����
			Statement stmt = conn.createStatement();
			{
				//ִ��DML��䣬������Ӱ��ļ�¼����
				return stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ExcuteDML ed = new ExcuteDML();
		ed.initParam("my.ini");
		int result = ed.insertData("insert into jdbc_test(id,jdbc_name,j_teacher) "
				+ "select s.student_id,s.student_name,s.java_teacher "
				+ "from student s;");
		System.out.println(result + " ����¼��Ӱ��");
	}

}
