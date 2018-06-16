package dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.sql.SQLException;  
import java.util.Vector;  
  
public class CourseSQL {  
    // 得到数据库表数据  
    public static Vector<Vector<String>> getRows(){  
        String sql_url = "jdbc:mysql://localhost:3306/学生学籍管理?serverTimezone=UTC&useSSL=false";    //数据库路径（一般都是这样写），test是数据库名称  
        String name = "root";       //用户名  
        String password = "983400"; //密码  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //连接驱动  
            conn = DriverManager.getConnection(sql_url, name, password);    //连接数据库  
            if(!conn.isClosed())  
              System.out.println("成功连接数据库");  
            preparedStatement = conn.prepareStatement("select * from 课程信息表");  
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
        String sql_url = "jdbc:mysql://localhost:3306/学生学籍管理?serverTimezone=UTC&useSSL=false";    //数据库路径（一般都是这样写），test是数据库名称  
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
            preparedStatement = conn.prepareStatement("select * from 课程信息表");  
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
    //查找区域功能的实现
    public static Vector<Vector<String>> search(String item,String n){  
        String sql_url = "jdbc:mysql://localhost:3306/学生学籍管理?serverTimezone=UTC&useSSL=false";    //数据库路径（一般都是这样写），test是数据库名称  
        String name = "root";       //用户名  
        String password = "983400"; //密码  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //连接驱动  
            conn = DriverManager.getConnection(sql_url, name, password);    //连接数据库   
            if (item=="name") 
            	preparedStatement = conn.prepareStatement("select * from 课程信息表 where 课程名='" + n + "'");  
            else if(item=="id") 
            	preparedStatement = conn.prepareStatement("select * from 课程信息表 where 课程号='" + n + "'"); 
            
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
  //编辑区域功能的实现
    public static int edit(String item,String id,String na,String ty,String te,String ti,String sc){  
        String sql_url = "jdbc:mysql://localhost:3306/学生学籍管理?serverTimezone=UTC&useSSL=false";    //数据库路径（一般都是这样写），test是数据库名称  
        String name = "root";       //用户名  
        String password = "983400"; //密码  
        Connection conn;  
        PreparedStatement sql = null;  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //连接驱动  
            conn = DriverManager.getConnection(sql_url, name, password);    //连接数据库  
              
            if (item=="add") {
            	//System.out.println("insert into 课程信息表 values('"+id+"','"+na+"','"+te+"','"+ti+"','"+sc+"','"+ty+"')");
            	sql = conn.prepareStatement("insert into 课程信息表 values('"+id+"','"+na+"','"+te+"','"+ti+"','"+sc+"','"+ty+"')");  
            }
            else if(item=="edi")
            	//System.out.println("update 课程信息表 set 课程名='"+na+"',课程类型='"+ty+"',授课老师='"+te+"',课时='"+ti+"',学分='"+sc+"' where 课程号='"+id+"'");    
            	sql = conn.prepareStatement("update 课程信息表 set 课程名='"+na+"',课程类型='"+ty+"',授课老师='"+te+"',课时='"+ti+"',学分='"+sc+"' where 课程号='"+id+"'"); 
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
    //删除部分
    public static int del(String id){  
        String sql_url = "jdbc:mysql://localhost:3306/学生学籍管理?serverTimezone=UTC&useSSL=false";    //数据库路径（一般都是这样写），test是数据库名称  
        String name = "root";       //用户名  
        String password = "983400"; //密码  
        Connection conn;  
        PreparedStatement sql = null;  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //连接驱动  
            conn = DriverManager.getConnection(sql_url, name, password);    //连接数据库  
            sql = conn.prepareStatement("delete from 课程信息表 where 课程号='"+id+"'"); 
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