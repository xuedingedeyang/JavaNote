package yang.sqltest01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class ConnMySql {

	public static void main(String[] args) throws ClassNotFoundException {
		// 1、加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			//2、使用DriverManager获取数据库连接
			//其中返回的Connection就代表了Java程序和数据库的连接
			//不同数据库的URL写法需要查驱动文档
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?useSSL=false","root","1909227160");
			//3、使用Connection来创建一个Statement对象
			Statement stmt = conn.createStatement();
			//4、执行sql语句
			ResultSet rs = stmt.executeQuery("select s.* ,teacher_name "
					+ "from student s, teacher t "
					+ "where t.teacher_id = s.java_teacher");
			{
				while(rs.next())
				{
					System.out.println(rs.getInt(1) + "\t"
							+ rs.getString(2) + "\t"
							+ rs.getString(3) + "\t"
							+ rs.getString(4));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
