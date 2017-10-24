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
		//加载驱动
		Class.forName(driver);
		try {
			//获取数据库连接
			Connection conn = DriverManager.getConnection(url,user,pass);
			//使用Connection来创建一个Statement对象
			Statement stmt = conn.createStatement();
			{
				//执行DML语句，返回受影响的记录条数
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
		System.out.println(result + " 条记录受影响");
	}

}
