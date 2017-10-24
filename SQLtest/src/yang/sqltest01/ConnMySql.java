package yang.sqltest01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class ConnMySql {

	public static void main(String[] args) throws ClassNotFoundException {
		// 1����������
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			//2��ʹ��DriverManager��ȡ���ݿ�����
			//���з��ص�Connection�ʹ�����Java��������ݿ������
			//��ͬ���ݿ��URLд����Ҫ�������ĵ�
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?useSSL=false","root","1909227160");
			//3��ʹ��Connection������һ��Statement����
			Statement stmt = conn.createStatement();
			//4��ִ��sql���
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
