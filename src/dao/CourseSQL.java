package dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.sql.SQLException;  
import java.util.Vector;  
  
public class CourseSQL {  
    // �õ����ݿ������  
    public static Vector<Vector<String>> getRows(){  
        String sql_url = "jdbc:mysql://localhost:3306/ѧ��ѧ������?serverTimezone=UTC&useSSL=false";    //���ݿ�·����һ�㶼������д����test�����ݿ�����  
        String name = "root";       //�û���  
        String password = "983400"; //����  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //��������  
            conn = DriverManager.getConnection(sql_url, name, password);    //�������ݿ�  
            if(!conn.isClosed())  
              System.out.println("�ɹ��������ݿ�");  
            preparedStatement = conn.prepareStatement("select * from �γ���Ϣ��");  
            ResultSet result1 = preparedStatement.executeQuery();  
                            
            rows = new Vector<Vector<String>>();  
              
            ResultSetMetaData rsmd = result1.getMetaData();  
                      
            while(result1.next()){  
                rows.addElement(getNextRow(result1,rsmd));
                
            }  
            //System.out.println("�ɹ�while");    
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ�����������");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }  
        return rows;  
    }  
      
    // �õ����ݿ��ͷ  
    public static Vector<String> getHead(){  
        String sql_url = "jdbc:mysql://localhost:3306/ѧ��ѧ������?serverTimezone=UTC&useSSL=false";    //���ݿ�·����һ�㶼������д����test�����ݿ�����  
        String name = "root";       //�û���  
        String password = "983400"; //����  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<String> columnHeads = null;  
          
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //��������  
            conn = DriverManager.getConnection(sql_url, name, password);    //�������ݿ�  
//          if(!conn.isClosed())  
//              System.out.println("�ɹ��������ݿ�");  
            preparedStatement = conn.prepareStatement("select * from �γ���Ϣ��");  
            ResultSet result1 = preparedStatement.executeQuery();  
              
            columnHeads = new Vector<String>();  
            
            ResultSetMetaData rsmd = result1.getMetaData();  
            
            for(int i = 1; i <= rsmd.getColumnCount(); i++)  
                columnHeads.addElement(rsmd.getColumnName(i));  
              
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ�����������");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }  
        return columnHeads;  
    }  
      
    // �õ����ݿ�����һ������  
    private static Vector<String> getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{  
        Vector<String> currentRow = new Vector<String>();  
        for(int i = 1; i <= rsmd.getColumnCount(); i++){  
            currentRow.addElement(rs.getString(i));  
        }  
        return currentRow;  
    }  
    //���������ܵ�ʵ��
    public static Vector<Vector<String>> search(String item,String n){  
        String sql_url = "jdbc:mysql://localhost:3306/ѧ��ѧ������?serverTimezone=UTC&useSSL=false";    //���ݿ�·����һ�㶼������д����test�����ݿ�����  
        String name = "root";       //�û���  
        String password = "983400"; //����  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //��������  
            conn = DriverManager.getConnection(sql_url, name, password);    //�������ݿ�   
            if (item=="name") 
            	preparedStatement = conn.prepareStatement("select * from �γ���Ϣ�� where �γ���='" + n + "'");  
            else if(item=="id") 
            	preparedStatement = conn.prepareStatement("select * from �γ���Ϣ�� where �γ̺�='" + n + "'"); 
            
            ResultSet result1 = preparedStatement.executeQuery();  
                            
            rows = new Vector<Vector<String>>();  
              
            ResultSetMetaData rsmd = result1.getMetaData();  
                      
            while(result1.next()){  
                rows.addElement(getNextRow(result1,rsmd));
                
            }  
            //System.out.println("�ɹ�while");    
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ�����������");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }  
        return rows;  
    }
  //�༭�����ܵ�ʵ��
    public static int edit(String item,String id,String na,String ty,String te,String ti,String sc){  
        String sql_url = "jdbc:mysql://localhost:3306/ѧ��ѧ������?serverTimezone=UTC&useSSL=false";    //���ݿ�·����һ�㶼������д����test�����ݿ�����  
        String name = "root";       //�û���  
        String password = "983400"; //����  
        Connection conn;  
        PreparedStatement sql = null;  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //��������  
            conn = DriverManager.getConnection(sql_url, name, password);    //�������ݿ�  
              
            if (item=="add") {
            	//System.out.println("insert into �γ���Ϣ�� values('"+id+"','"+na+"','"+te+"','"+ti+"','"+sc+"','"+ty+"')");
            	sql = conn.prepareStatement("insert into �γ���Ϣ�� values('"+id+"','"+na+"','"+te+"','"+ti+"','"+sc+"','"+ty+"')");  
            }
            else if(item=="edi")
            	//System.out.println("update �γ���Ϣ�� set �γ���='"+na+"',�γ�����='"+ty+"',�ڿ���ʦ='"+te+"',��ʱ='"+ti+"',ѧ��='"+sc+"' where �γ̺�='"+id+"'");    
            	sql = conn.prepareStatement("update �γ���Ϣ�� set �γ���='"+na+"',�γ�����='"+ty+"',�ڿ���ʦ='"+te+"',��ʱ='"+ti+"',ѧ��='"+sc+"' where �γ̺�='"+id+"'"); 
            sql.executeUpdate();
            
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ�����������");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }  
        return 0;  
    }
    //ɾ������
    public static int del(String id){  
        String sql_url = "jdbc:mysql://localhost:3306/ѧ��ѧ������?serverTimezone=UTC&useSSL=false";    //���ݿ�·����һ�㶼������д����test�����ݿ�����  
        String name = "root";       //�û���  
        String password = "983400"; //����  
        Connection conn;  
        PreparedStatement sql = null;  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //��������  
            conn = DriverManager.getConnection(sql_url, name, password);    //�������ݿ�  
            sql = conn.prepareStatement("delete from �γ���Ϣ�� where �γ̺�='"+id+"'"); 
            sql.executeUpdate();
            
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ�����������");  
            e.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }  
        return 0;  
    }
} 