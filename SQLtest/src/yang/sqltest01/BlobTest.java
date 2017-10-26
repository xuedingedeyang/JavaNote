package yang.sqltest01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BlobTest {
	
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
		
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url,user,pass);
		
		insert = conn.prepareStatement("insert into image_table "
				+ "values(null,?)",Statement.RETURN_GENERATED_KEYS);
		query = conn.prepareStatement("select  file from image_table where image_id = ?");
	}
	
	public void insert(int id,String fileName)
	{
		File file = new File(fileName);
		try {
			InputStream is = new FileInputStream(file);
			insert.setInt(1, id);
			insert.setBinaryStream(1, is, (int)file.length());
			int affect = insert.executeUpdate();
			if(affect == 1)
			{
				System.out.println("插入数据成功！");
			}
			else
			{
				System.out.println("插入失败!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showFileContent(int id) throws SQLException
	{
		query.setInt(1, id);
		ResultSet rs = query.executeQuery();
		if(rs.next())
		{
			Blob blob = rs.getBlob(1);
			showContentFromStream(blob.getBinaryStream());
		}
	}
	
	public void showContentFromStream(InputStream is)
	{
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		System.out.println("打印从数据库中读取的文件内容:\n");
		try {
			while((line = br.readLine())!=null)
			{
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BlobTest b = new BlobTest();
		b.initParam("my.ini");
//		b.insert(1,"新建文本文档.txt");
		b.showFileContent(1);
	}

}
