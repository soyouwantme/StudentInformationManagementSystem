package dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.sql.SQLException;  
import java.util.Vector;  
  
public class StuSQL {  
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
           // if(!conn.isClosed())  
           //   System.out.println("�ɹ��������ݿ�");  
            preparedStatement = conn.prepareStatement("select * from ѧ����Ϣ��");  
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
            preparedStatement = conn.prepareStatement("select * from ѧ����Ϣ��");  
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
            	preparedStatement = conn.prepareStatement("select * from ѧ����Ϣ�� where ����='" + n + "'");  
            else if(item=="id")
            	preparedStatement = conn.prepareStatement("select * from ѧ����Ϣ�� where ѧ��='" + n + "'"); 
            else if(item=="cla")
            	preparedStatement = conn.prepareStatement("select * from ѧ����Ϣ�� where �༶='" + n + "'"); 
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
    public static int edit(String item,String id,String na,String se,String ma,String cl,String bi,String ad){  
        String sql_url = "jdbc:mysql://localhost:3306/ѧ��ѧ������?serverTimezone=UTC&useSSL=false";    //���ݿ�·����һ�㶼������д����test�����ݿ�����  
        String name = "root";       //�û���  
        String password = "983400"; //����  
        Connection conn;  
        PreparedStatement sql = null;  
        
  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");     //��������  
            conn = DriverManager.getConnection(sql_url, name, password);    //�������ݿ�  
              
            if (item=="add") {
            	//System.out.println("insert into ѧ����Ϣ��(ѧ��,����,�Ա�,�༶,ϵ��,��������,����) values('"+id+"','"+na+"','"+se+"','"+cl+"','"+ma+"','"+bi+"','"+ad+"')");
            	sql = conn.prepareStatement("insert into ѧ����Ϣ��(ѧ��,����,�Ա�,�༶,ϵ��,��������,����) values('"+id+"','"+na+"','"+se+"','"+cl+"','"+ma+"','"+bi+"','"+ad+"')");  
            } 
            else if(item=="edi")
            	//System.out.println("update ѧ����Ϣ�� set '����'='"+na+"','�Ա�'='"+se+"','ϵ��'='"+ma+"','�༶'='"+cl+"','��������'='"+bi+"','����'='"+ad+"' where 'ѧ��'='"+id+"'");    
            	sql = conn.prepareStatement("update ѧ����Ϣ�� set ����='"+na+"',�Ա�='"+se+"',ϵ��='"+ma+"',�༶='"+cl+"',��������='"+bi+"',����='"+ad+"' where ѧ��='"+id+"'"); 
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
            sql = conn.prepareStatement("delete from ѧ����Ϣ�� where ѧ��='"+id+"'"); 
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