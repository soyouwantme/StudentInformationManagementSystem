package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckRol {
	public static boolean CheckRole(String usr,String pwd){  
		String sql_url = "jdbc:mysql://localhost:3306/ѧ��ѧ������?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";    //���ݿ�·����һ�㶼������д����test�����ݿ�����  
        String name = "root";       //�û���  
        String password = "983400"; //����  
        Connection conn;  
        PreparedStatement preparedStatement = null; 
        try{  
        	Class.forName("com.mysql.cj.jdbc.Driver");     //��������  
            conn = DriverManager.getConnection(sql_url, name, password);    //�������ݿ�  
            preparedStatement = conn.prepareStatement("select * from �û��� where �û���='"+usr+"' and ����='"+pwd+"'");  
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
