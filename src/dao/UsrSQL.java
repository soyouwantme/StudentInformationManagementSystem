package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class UsrSQL {
	public static Vector<Vector<String>> getRows(){  
        String sql_url = "jdbc:mysql://localhost:3306/学生学籍管理?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";    //数据库路径（一般都是这样写），test是数据库名称  
        String name = "root";       //用户名  
        String password = "983400"; //密码  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //连接驱动  
            conn = DriverManager.getConnection(sql_url, name, password);    //连接数据库  
           // if(!conn.isClosed())  
           //   System.out.println("成功连接数据库");  
            preparedStatement = conn.prepareStatement("select * from 用户表");  
            ResultSet result1 = preparedStatement.executeQuery();  
                            
            rows = new Vector<Vector<String>>();  
              
            ResultSetMetaData rsmd = result1.getMetaData();  
                      
            while(result1.next()){  
                rows.addElement(getNextRow(result1,rsmd));
                
            }  
            //System.out.println("成功while");    
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功加载驱动。");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return rows;  
    }  
      
    // 得到数据库表头  
    public static Vector<String> getHead(){  
        String sql_url = "jdbc:mysql://localhost:3306/学生学籍管理?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";    //数据库路径（一般都是这样写），test是数据库名称  
        String name = "root";       //用户名  
        String password = "983400"; //密码  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<String> columnHeads = null;  
          
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //连接驱动  
            conn = DriverManager.getConnection(sql_url, name, password);    //连接数据库  
//          if(!conn.isClosed())  
//              System.out.println("成功连接数据库");  
            preparedStatement = conn.prepareStatement("select * from 用户表");  
            ResultSet result1 = preparedStatement.executeQuery();  
              
            columnHeads = new Vector<String>();  
            
            ResultSetMetaData rsmd = result1.getMetaData();  
            
            for(int i = 1; i <= rsmd.getColumnCount(); i++)  
                columnHeads.addElement(rsmd.getColumnName(i));  
              
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功加载驱动。");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return columnHeads;  
    }  
    
    // 得到数据库中下一行数据  
    private static Vector<String> getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{  
        Vector<String> currentRow = new Vector<String>();  
        for(int i = 1; i <= rsmd.getColumnCount(); i++){  
            currentRow.addElement(rs.getString(i));  
        }  
        return currentRow;  
    }
    //编辑用户数据
    public static int edit(String item,String id,String ty,String pwd){  
        String sql_url = "jdbc:mysql://localhost:3306/学生学籍管理?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";    //数据库路径（一般都是这样写），test是数据库名称  
        String name = "root";       //用户名  
        String password = "983400"; //密码  
        Connection conn;  
        PreparedStatement sql = null;      
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //连接驱动  
            conn = DriverManager.getConnection(sql_url, name, password);    //连接数据库  
              
            if (item=="add") {
            	//System.out.println("insert into 学生信息表(学号,姓名,性别,班级,系别,出生年月,籍贯) values('"+id+"','"+na+"','"+se+"','"+cl+"','"+ma+"','"+bi+"','"+ad+"')");
            	sql = conn.prepareStatement("insert into 用户表 values('"+id+"','"+ty+"','"+pwd+"')");  
            } 
            else if(item=="edi")
            	//System.out.println("update 学生信息表 set '姓名'='"+na+"','性别'='"+se+"','系别'='"+ma+"','班级'='"+cl+"','出生年月'='"+bi+"','籍贯'='"+ad+"' where '学号'='"+id+"'");    
            	sql = conn.prepareStatement("update 用户表 set 用户类型='"+ty+"' where 用户名='"+id+"'"); 
                sql.executeUpdate();
            
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功加载驱动。");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return 0;  
    }
    //判断用户是否存在
    public static boolean getRows(String usr1){  
        String sql_url = "jdbc:mysql://localhost:3306/学生学籍管理?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";    //数据库路径（一般都是这样写），test是数据库名称  
        String name = "root";       //用户名  
        String password = "983400"; //密码  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //连接驱动  
            conn = DriverManager.getConnection(sql_url, name, password);    //连接数据库  
            preparedStatement = conn.prepareStatement("select 用户名 from 用户表_视图 where 用户名='"+usr1+"'");  
            ResultSet result1 = preparedStatement.executeQuery();               
            if(result1.next()==true)
            	return true; 
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功加载驱动。");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }
        return false;  
    }
    
  //查找区域功能的实现
    public static Vector<Vector<String>> search(String item,String n){  
        String sql_url = "jdbc:mysql://localhost:3306/学生学籍管理?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";    //数据库路径（一般都是这样写），test是数据库名称  
        String name = "root";       //用户名  
        String password = "983400"; //密码  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //连接驱动  
            conn = DriverManager.getConnection(sql_url, name, password);    //连接数据库   
            if (item=="usr")
            	preparedStatement = conn.prepareStatement("select * from 用户表 where 用户名='" + n + "'");  
            else if(item=="ty")
            	preparedStatement = conn.prepareStatement("select * from 用户表 where 用户类型='" + n + "'"); 
            ResultSet result1 = preparedStatement.executeQuery();  
                            
            rows = new Vector<Vector<String>>();  
              
            ResultSetMetaData rsmd = result1.getMetaData();  
                      
            while(result1.next()){  
                rows.addElement(getNextRow(result1,rsmd));
                
            }  
            //System.out.println("成功while");    
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功加载驱动。");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return rows;  
    }
    
    

    
    
  //删除函数
    public static int del(String id){  
        String sql_url = "jdbc:mysql://localhost:3306/学生学籍管理?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";    //数据库路径（一般都是这样写），test是数据库名称  
        String name = "root";       //用户名  
        String password = "983400"; //密码  
        Connection conn;  
        PreparedStatement sql = null;  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //连接驱动  
            conn = DriverManager.getConnection(sql_url, name, password);    //连接数据库  
            sql = conn.prepareStatement("delete from 用户表 where 用户名='"+id+"'"); 
            sql.executeUpdate();
            
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功加载驱动。");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return 0;  
    }
    //修改密码
    public static int cdpwd(String id,String pwd){  
        String sql_url = "jdbc:mysql://localhost:3306/学生学籍管理?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";    //数据库路径（一般都是这样写），test是数据库名称  
        String name = "root";       //用户名  
        String password = "983400"; //密码  
        Connection conn;  
        PreparedStatement sql = null;      
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //连接驱动  
            conn = DriverManager.getConnection(sql_url, name, password);   
            sql = conn.prepareStatement("update 用户表 set 密码='"+pwd+"' where 用户名='"+id+"'");
            sql.executeUpdate();
            
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功加载驱动。");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return 0;  
    }
    
}
