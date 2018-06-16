package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckRol {
	public static boolean CheckRole(String usr,String pwd){  
		String sql_url = "jdbc:mysql://localhost:3306/学生学籍管理?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";    //数据库路径（一般都是这样写），test是数据库名称  
        String name = "root";       //用户名  
        String password = "983400"; //密码  
        Connection conn;  
        PreparedStatement preparedStatement = null; 
        try{  
        	Class.forName("com.mysql.cj.jdbc.Driver");     //连接驱动  
            conn = DriverManager.getConnection(sql_url, name, password);    //连接数据库  
            preparedStatement = conn.prepareStatement("select * from 用户表 where 用户名='"+usr+"' and 密码='"+pwd+"'");  
            ResultSet result1 = preparedStatement.executeQuery();               
            if(result1.next()==true)
            	return true; 
        }
        catch(Exception e1){  
            System.out.println(e1);  
        }  
            return false;  
    }  
}  
