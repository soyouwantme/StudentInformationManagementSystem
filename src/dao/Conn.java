package dao;
import java.sql.*;

public class Conn {
	static Connection con;
	static Statement sql;
	static ResultSet res;
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/学生_课程","root", "983400");
			System.out.println("数据库连接成功");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
