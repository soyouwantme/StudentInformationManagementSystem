package main;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import dao.CourseSQL;
import dao.StuSQL;
import dao.UsrSQL;

import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;

public class MainFrame extends JFrame {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pane;
    private JPanel p;
    private CardLayout card = null;    
    private JButton exit;
    private JButton usr;
    private JButton course;
    private JButton std;
    private JPanel stdpan=null;   
    private JPanel stdtool;
    private JPanel stdsearch;
    private JPanel stdedit;
    private JRadioButton idrad;
    private JRadioButton clarad;
    private JButton searchbut;
    private JButton backbut;
    private JTextField IdText;
    private JTextPane textPane_2;
    private JTextPane textPane_3;
    private JTextPane textPane_4;
    private JTextField NameText;
    private JTextField ClassText;
    private JTextField AddText;
    private JTextField NoteText;
    private JPanel coursepan;
    private JPanel coursesearch;
    private JRadioButton CouRad;
    private JRadioButton CorIdRad;
    private JRadioButton AllRad;
    private JButton searchbut2;
    private JPanel courseedit;
    private JTextField CidTextf;
    private JTextPane CnameText;
    private JTextPane CharText;
    private JTextField CnameTextf;
    private JTextPane TimeText;
    private JTextPane textPane_17;
    private JTextField TimTextf;
    private JTextField ScoTextf;
    private JComboBox<?> charcomboBox;
    private JPanel coursetool;
    private JButton Caddbut;
    private JButton Cdelbut;
    private JButton Cedibut;
    private JPanel usrpan;
    private JPanel usredit;
    private JRadioButton tearb;
    private JRadioButton stdrb;
    private JRadioButton admrb;
    private JButton button_5;
    private JButton cdpwd;
    private JPanel usrpwdcd;
    private JTextPane textPane_21;
    private JTextPane textPane_22;
    private JTextPane textPane_23;
    private JTextPane textPane_24;
    private JRadioButton usrrb;
    private JRadioButton usrtyperb;
    private JPanel usrtool;
    private JButton button_7;
    private JTextField usrtext1;
    private JPasswordField pwd1;
    private JTable stdtable;
    private JScrollPane couscrollPane;
    private JTable coutable;
    private JTextField TecTextf;
    private JTable usrtable;
    private JTextField usrtext2;
    private JTextPane textPane_12;
    private JTextField usrtext3;
    private JButton button;
    private JPasswordField oldpwd;
    private JPasswordField newpwd;
    private JPasswordField newpwd2;
    private JButton button_1;
    private JTextField usrtypetext;
    private JTextField usrtext4;
    public MainFrame(){  
        card = new CardLayout(5,5);  
        pane = new JPanel(card);
        
        stdpan = new JPanel();
        stdpan.setBackground(SystemColor.menu);
        stdpan.setLayout(null);

        // 取得学生学籍管理数据库的学生信息表的各行数据  
        Vector<?> rowData = StuSQL.getRows();  
        // 取得学生学籍管理数据库的学生信息表的表头数据  
        Vector<?> columnNames = StuSQL.getHead();  
        
        DefaultTableModel tableModel = new DefaultTableModel(rowData,columnNames);
        
        // 取得学生学籍管理数据库的课程信息表的各行数据  
        Vector<?> rowData2 = CourseSQL.getRows();  
        // 取得学生学籍管理数据库的课程信息表的表头数据  
        Vector<?> columnNames2 = CourseSQL.getHead();  
        
        DefaultTableModel tableModel2 = new DefaultTableModel(rowData2,columnNames2);
        
     // 取得学生学籍管理数据库的用户信息表的各行数据  
        Vector<?> rowData3 = UsrSQL.getRows();  
        // 取得学生学籍管理数据库的用户信息表的表头数据  
        Vector<?> columnNames3 = UsrSQL.getHead();  
        
        DefaultTableModel tableModel3 = new DefaultTableModel(rowData3,columnNames3);
        

        //学生信息查找区
        stdsearch = new JPanel();
        stdsearch.setBounds(656, 0, 128, 261);
        stdsearch.setBorder(BorderFactory.createTitledBorder ("查找"));
        stdsearch.setToolTipText("");
        stdsearch.setLayout(null);
        stdpan.add(stdsearch);        
        JRadioButton namerad = new JRadioButton("\u59D3\u540D");
        namerad.setMargin(new Insets(1, 1, 1, 1));
        namerad.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        namerad.setBounds(32, 61, 63, 35);
        stdsearch.add(namerad);
        
        idrad = new JRadioButton("\u5B66\u53F7");
        idrad.setMargin(new Insets(1, 1, 1, 1));
        idrad.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        idrad.setBounds(32, 13, 63, 35);
        stdsearch.add(idrad);
        
        clarad = new JRadioButton("\u73ED\u7EA7");
        clarad.setMargin(new Insets(1, 1, 1, 1));
        clarad.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        clarad.setBounds(32, 109, 63, 35);
        stdsearch.add(clarad);
        //学生信息查找监听器
        searchbut = new JButton("\u67E5\u627E");
        searchbut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(namerad.isSelected()==true) {
        			String n = NameText.getText();
        			Vector<?> rowDatan = StuSQL.search("name",n);
        			tableModel.setDataVector(rowDatan,columnNames);//设置新内容
        			tableModel.fireTableStructureChanged();
        		}
        		if(idrad.isSelected()==true) {
        			String n = IdText.getText();
        			Vector<?> rowDatan = StuSQL.search("id",n);
        			tableModel.setDataVector(rowDatan,columnNames);//设置新内容
        			tableModel.fireTableStructureChanged();
        		}
        		if(clarad.isSelected()==true) {
        			String n = ClassText.getText();
        			Vector<?> rowDatan = StuSQL.search("cla",n);
        			tableModel.setDataVector(rowDatan,columnNames);//设置新内容
        			tableModel.fireTableStructureChanged();
        		}
        	}
        });
        searchbut.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        searchbut.setBounds(26, 157, 75, 37);
        stdsearch.add(searchbut);
        //复原按钮监听器
        backbut = new JButton("\u8FD4\u56DE");
        backbut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		tableModel.setDataVector(rowData,columnNames);//设置新内容
    			tableModel.fireTableStructureChanged();
        	}
        });
        backbut.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        backbut.setBounds(26, 207, 75, 37);
        stdsearch.add(backbut);
        
        ButtonGroup group = new ButtonGroup();
        group.add(idrad);
        group.add(clarad);
        group.add(namerad);

        
        stdedit = new JPanel();
        stdedit.setBounds(0, 266, 651, 272);
        stdedit.setBorder(BorderFactory.createTitledBorder ("编辑区"));
        stdedit.setLayout(null);
        stdpan.add(stdedit);
        
        IdText = new JTextField();
        IdText.setBounds(97, 40, 177, 27);
        stdedit.add(IdText);
        IdText.setColumns(10);
        
        JTextPane textPane = new JTextPane();
        textPane.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane.setContentType("*/");
        textPane.setBackground(SystemColor.menu);
        textPane.setText("\u5B66\u53F7");
        textPane.setBounds(32, 33, 46, 34);
        textPane.setEditable(false);
        stdedit.add(textPane);
        
        JTextPane textPane_1 = new JTextPane();
        textPane_1.setBackground(SystemColor.menu);
        textPane_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_1.setText("\u59D3\u540D");
        textPane_1.setBounds(32, 75, 46, 34);
        textPane_1.setEditable(false);
        stdedit.add(textPane_1);
        
        textPane_2 = new JTextPane();
        textPane_2.setText("\u6027\u522B");
        textPane_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_2.setBackground(SystemColor.menu);
        textPane_2.setBounds(32, 119, 46, 34);
        textPane_2.setEditable(false);
        stdedit.add(textPane_2);
        
        textPane_3 = new JTextPane();
        textPane_3.setText("\u7CFB\u522B");
        textPane_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_3.setBackground(SystemColor.menu);
        textPane_3.setBounds(32, 168, 46, 34);
        textPane_3.setEditable(false);
        stdedit.add(textPane_3);
        
        textPane_4 = new JTextPane();
        textPane_4.setText("\u73ED\u7EA7");
        textPane_4.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_4.setBackground(SystemColor.menu);
        textPane_4.setBounds(32, 212, 46, 34);
        textPane_4.setEditable(false);
        stdedit.add(textPane_4);
        
        NameText = new JTextField();
        NameText.setColumns(10);
        NameText.setBounds(97, 82, 177, 27);
        stdedit.add(NameText);
        
        
        ClassText = new JTextField();
        ClassText.setColumns(10);
        ClassText.setBounds(97, 219, 177, 27);
        stdedit.add(ClassText);
        
        JTextPane textPane_5 = new JTextPane();
        textPane_5.setText("\u51FA\u751F\u65E5\u671F");
        textPane_5.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_5.setBackground(SystemColor.menu);
        textPane_5.setBounds(302, 33, 86, 34);
        textPane_5.setEditable(false);
        stdedit.add(textPane_5);
        
        JTextPane textPane_6 = new JTextPane();
        textPane_6.setText("\u7C4D   \u8D2F");
        textPane_6.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_6.setBackground(SystemColor.menu);
        textPane_6.setBounds(324, 75, 64, 34);
        textPane_6.setEditable(false);
        stdedit.add(textPane_6);
        
        JTextPane textPane_7 = new JTextPane();
        textPane_7.setText("\u5907   \u6CE8");
        textPane_7.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_7.setBackground(SystemColor.menu);
        textPane_7.setBounds(324, 119, 64, 34);
        textPane_7.setEditable(false);
        stdedit.add(textPane_7);
        
        AddText = new JTextField();
        AddText.setColumns(10);
        AddText.setBounds(410, 82, 177, 27);
        stdedit.add(AddText);
        
        NoteText = new JTextField();
        NoteText.setColumns(10);
        NoteText.setBounds(410, 126, 177, 120);
        stdedit.add(NoteText);
        
        String[] Majors = {"计算机科学与技术","信息安全","数字媒体与技术","互联网+","金融","会计","计本"};
        JComboBox<?> MajorBox = new JComboBox<Object>(Majors);
        MajorBox.setBounds(97, 175, 177, 27);
        stdedit.add(MajorBox);
        
        String[] Years = {"1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003"}; 
        JComboBox<?> YearBox = new JComboBox<Object>(Years);
        YearBox.setBounds(410, 40, 65, 27);
        stdedit.add(YearBox);
        
        String[] Months = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        JComboBox<?> MonthBox = new JComboBox<Object>(Months);
        MonthBox.setBounds(485, 40, 46, 27);
        stdedit.add(MonthBox);
        
        JRadioButton m3rb = new JRadioButton("\u7537");
        m3rb.setMargin(new Insets(1, 1, 1, 1));
        m3rb.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        m3rb.setBounds(97, 118, 63, 35);
        stdedit.add(m3rb);
        
        JRadioButton w3rb = new JRadioButton("\u5973");
        w3rb.setMargin(new Insets(1, 1, 1, 1));
        w3rb.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        w3rb.setBounds(197, 118, 63, 35);
        stdedit.add(w3rb);
        
        ButtonGroup group1 = new ButtonGroup();
        group1.add(m3rb);
        group1.add(w3rb);
        
        String[] Days = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        JComboBox<?> DayBox = new JComboBox<Object>(Days);
        DayBox.setBounds(541, 40, 46, 27);
        stdedit.add(DayBox);

        
        stdtool = new JPanel();
        stdtool.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u7F16\u8F91\u9009\u9879", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        stdtool.setBounds(656, 266, 128, 272);
        stdtool.setLayout(null);
        stdpan.add(stdtool);
        

		
        //学生信息添加监听器
        JButton addbut = new JButton("\u6DFB\u52A0");
        addbut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
                //编辑区输入信息的获取
        		String id = IdText.getText();
        		String na = NameText.getText();
        		String se;
        		if (m3rb.isSelected()==true)
        			se = m3rb.getText();
        		else
        			se =w3rb.getText();
        		String ma = (String) MajorBox.getSelectedItem();
        		//System.out.println(ma);  
        		String cl = ClassText.getText();
        		String bi1 = (String) YearBox.getSelectedItem();
        		String bi2 = (String) MonthBox.getSelectedItem();
        		String bi3 = (String) DayBox.getSelectedItem();
        		String bi = bi1 +"-"+ bi2 +"-"+ bi3;
        		//System.out.println(bi);  
        		String ad = AddText.getText();
        		if (IdText.getText().trim().equals("")|NameText.getText().trim().equals("")|AddText.getText().trim().equals("")|ClassText.getText().trim().equals("")|(m3rb.isSelected()!=true&w3rb.isSelected()!=true))
        			JOptionPane.showMessageDialog(null, "请输入完整的学生信息（备注可为空）", "错误",JOptionPane.ERROR_MESSAGE);
        		else {
        			System.out.println("执行添加操作"); 
        			StuSQL.edit("add",id,na,se,ma,cl,bi,ad);
        			Vector<?> rowData = StuSQL.getRows(); 
        	    	tableModel.setDataVector(rowData,columnNames);//设置新内容
        			tableModel.fireTableStructureChanged();
        		}
        	}
        });
        addbut.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        addbut.setBounds(26, 40, 75, 37);
        stdtool.add(addbut);
        //学生信息删除操作监听器
        JButton delbut = new JButton("\u5220\u9664");
        delbut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String id = IdText.getText();
        		if (IdText.getText().trim().equals(""))
        			JOptionPane.showMessageDialog(null, "请输入需要删除学生对应的学号", "错误",JOptionPane.ERROR_MESSAGE);
        		else {
        			System.out.println("执行删除操作"); 
        			StuSQL.del(id);
        			Vector<?> rowData = StuSQL.getRows(); 
        	    	tableModel.setDataVector(rowData,columnNames);//设置新内容
        			tableModel.fireTableStructureChanged();
        		}
        	}
        });
        delbut.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        delbut.setBounds(26, 117, 75, 37);
        stdtool.add(delbut);
        //学生修改按钮监听器
        JButton altbut = new JButton("\u4FEE\u6539");
        altbut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 //编辑区输入信息的获取
        		String id = IdText.getText();
        		String na = NameText.getText();
        		String se;
        		if (m3rb.isSelected()==true)
        			se = m3rb.getText();
        		else
        			se =w3rb.getText();
        		String ma = (String) MajorBox.getSelectedItem();
        		//System.out.println(ma);  
        		String cl = ClassText.getText();
        		String bi1 = (String) YearBox.getSelectedItem();
        		String bi2 = (String) MonthBox.getSelectedItem();
        		String bi3 = (String) DayBox.getSelectedItem();
        		String bi = bi1 +"-"+ bi2 +"-"+ bi3;
        		//System.out.println(bi);  
        		String ad = AddText.getText();
        		if (IdText.getText().trim().equals("")|NameText.getText().trim().equals("")|(AddText.getText().trim().equals("")&ClassText.getText().trim().equals("")&(m3rb.isSelected()!=true&w3rb.isSelected()!=true)))
        			JOptionPane.showMessageDialog(null, "请最少保留学生的学号和姓名）", "错误",JOptionPane.ERROR_MESSAGE);
        		else {
        			System.out.println("执行修改操作"); 
        			StuSQL.edit("edi",id,na,se,ma,cl,bi,ad);
        			Vector<?> rowData = StuSQL.getRows(); 
        	    	tableModel.setDataVector(rowData,columnNames);//设置新内容
        			tableModel.fireTableStructureChanged();	
        		}
        	}
        });
        altbut.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        altbut.setBounds(26, 194, 75, 37);
        stdtool.add(altbut);
        
        coursepan = new JPanel();
        coursepan.setLayout(null);
        coursepan.setBackground(SystemColor.menu);
        
        coursesearch = new JPanel();
        coursesearch.setLayout(null);
        coursesearch.setToolTipText("");
        coursesearch.setBorder(BorderFactory.createTitledBorder ("查找"));
        coursesearch.setBounds(656, 0, 128, 261);
        coursepan.add(coursesearch);
        
        CouRad = new JRadioButton("\u540D\u79F0");
        CouRad.setMargin(new Insets(1, 1, 1, 1));
        CouRad.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        CouRad.setBounds(32, 81, 63, 35);
        coursesearch.add(CouRad);
        
        CorIdRad = new JRadioButton("\u8BFE\u53F7");
        CorIdRad.setMargin(new Insets(1, 1, 1, 1));
        CorIdRad.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        CorIdRad.setBounds(32, 23, 63, 35);
        coursesearch.add(CorIdRad);
        
        AllRad = new JRadioButton("\u5168\u90E8");
        AllRad.setMargin(new Insets(1, 1, 1, 1));
        AllRad.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        AllRad.setBounds(32, 139, 63, 35);
        coursesearch.add(AllRad);
        //课程查找功能的监听器
        searchbut2 = new JButton("\u67E5\u627E");
        searchbut2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(CouRad.isSelected()==true) {
        			String n = CnameTextf.getText();
        			//System.out.println(n);  
        			Vector<?> rowDatan2 = CourseSQL.search("name",n);
        			tableModel2.setDataVector(rowDatan2,columnNames2);//设置新内容
        			tableModel2.fireTableStructureChanged();
        		}
        		if(CorIdRad.isSelected()==true) {
        			String n = CidTextf.getText();
        			Vector<?> rowDatan2 = CourseSQL.search("id",n);
        			tableModel2.setDataVector(rowDatan2,columnNames2);//设置新内容
        			tableModel2.fireTableStructureChanged();
        		}
        		if(AllRad.isSelected()==true) {
        			tableModel2.setDataVector(rowData2,columnNames2);//设置新内容
        			tableModel2.fireTableStructureChanged();
        		}
        	}
        });
        searchbut2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        searchbut2.setBounds(26, 197, 75, 37);
        coursesearch.add(searchbut2);
        
        courseedit = new JPanel();
        courseedit.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        courseedit.setLayout(null);
        courseedit.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u7F16\u8F91\u533A", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        courseedit.setBounds(0, 266, 651, 272);
        coursepan.add(courseedit);
        
        CidTextf = new JTextField();
        CidTextf.setColumns(10);
        CidTextf.setBounds(132, 49, 153, 27);
        courseedit.add(CidTextf);
        
        CnameText = new JTextPane();
        CnameText.setText("\u8BFE\u7A0B\u540D");
        CnameText.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        CnameText.setBackground(SystemColor.menu);
        CnameText.setBounds(52, 118, 66, 34);
        CnameText.setEditable(false);
        courseedit.add(CnameText);
        
        CharText = new JTextPane();
        CharText.setText("\u8BFE\u7A0B\u7C7B\u578B");
        CharText.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        CharText.setBackground(SystemColor.menu);
        CharText.setBounds(32, 194, 86, 34);
        CharText.setEditable(false);
        courseedit.add(CharText);
        
        CnameTextf = new JTextField();
        CnameTextf.setColumns(10);
        CnameTextf.setBounds(132, 125, 153, 27);
        courseedit.add(CnameTextf);
        
        TimeText = new JTextPane();
        TimeText.setText("\u8BFE   \u65F6");
        TimeText.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        TimeText.setBackground(SystemColor.menu);
        TimeText.setBounds(364, 118, 64, 34);
        TimeText.setEditable(false);
        courseedit.add(TimeText);
        
        textPane_17 = new JTextPane();
        textPane_17.setText("\u5B66   \u5206");
        textPane_17.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_17.setBackground(SystemColor.menu);
        textPane_17.setBounds(364, 194, 64, 34);
        textPane_17.setEditable(false);
        courseedit.add(textPane_17);
        
        TimTextf = new JTextField();
        TimTextf.setColumns(10);
        TimTextf.setBounds(434, 121, 153, 27);
        courseedit.add(TimTextf);
        
        ScoTextf = new JTextField();
        ScoTextf.setColumns(10);
        ScoTextf.setBounds(434, 195, 153, 27);
        courseedit.add(ScoTextf);
        
        String[] Types = {"必修","选修"};
        charcomboBox = new JComboBox<Object>(Types);
        charcomboBox.setBounds(132, 194, 153, 27);
        courseedit.add(charcomboBox);
        
        JTextPane CidText = new JTextPane();
        CidText.setText("\u8BFE\u7A0B\u53F7");
        CidText.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        CidText.setBackground(SystemColor.menu);
        CidText.setBounds(52, 42, 66, 34);
        CidText.setEditable(false);
        courseedit.add(CidText);
        
        JTextPane textPane_8 = new JTextPane();
        textPane_8.setText("\u6388\u8BFE\u8001\u5E08");
        textPane_8.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_8.setBackground(SystemColor.menu);
        textPane_8.setBounds(342, 42, 86, 34);
        textPane_8.setEditable(false);
        courseedit.add(textPane_8);
        
        TecTextf = new JTextField();
        TecTextf.setColumns(10);
        TecTextf.setBounds(434, 47, 153, 27);
        courseedit.add(TecTextf);
        
        coursetool = new JPanel();
        coursetool.setBorder(new TitledBorder(null, "\u7F16\u8F91\u9009\u9879", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        coursetool.setLayout(null);
        coursetool.setBounds(656, 266, 128, 272);
        coursepan.add(coursetool);
        //课程添加监听器
        Caddbut = new JButton("\u6DFB\u52A0");
        Caddbut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//编辑区输入信息的获取
        		String id = CidTextf.getText();
        		String na = CnameTextf.getText();
         		String ty = (String) charcomboBox.getSelectedItem();
        		String te = TecTextf.getText();
        		String ti = TimTextf.getText();
        		String sc = ScoTextf.getText();
        		if (CidTextf.getText().trim().equals("")|CnameTextf.getText().trim().equals("")|TecTextf.getText().trim().equals("") | TimTextf.getText().trim().equals("") | ScoTextf.getText().trim().equals(""))
        			JOptionPane.showMessageDialog(null, "请输入完整的课程信息", "错误",JOptionPane.ERROR_MESSAGE);
        		else {
        			System.out.println("执行添加操作"); 
        			CourseSQL.edit("add",id,na,ty,te,ti,sc);
        			Vector<?> rowDatan2 = CourseSQL.getRows(); 
        	    	tableModel2.setDataVector(rowDatan2,columnNames2);//设置新内容
        			tableModel2.fireTableStructureChanged();
        		}
        	}
        });
        Caddbut.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        Caddbut.setBounds(26, 40, 75, 37);
        coursetool.add(Caddbut);
        //课程删除监听器
        Cdelbut = new JButton("\u5220\u9664");
        Cdelbut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String id = CidTextf.getText();
        		if (CidTextf.getText().trim().equals(""))
        			JOptionPane.showMessageDialog(null, "请输入需要删除课程对应的课程号", "错误",JOptionPane.ERROR_MESSAGE);
        		else {
        			System.out.println("执行删除操作"); 
        			CourseSQL.del(id);
        			Vector<?> rowDatan2 = CourseSQL.getRows(); 
        	    	tableModel2.setDataVector(rowDatan2,columnNames2);//设置新内容
        			tableModel2.fireTableStructureChanged();
        		}
        	}
        });
        Cdelbut.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        Cdelbut.setBounds(26, 117, 75, 37);
        coursetool.add(Cdelbut);
        //修改课程信息监听器
        Cedibut = new JButton("\u4FEE\u6539");
        Cedibut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 //编辑区输入信息的获取
        		String id = CidTextf.getText();
        		String na = CnameTextf.getText();
         		String ty = (String) charcomboBox.getSelectedItem();
        		String te = TecTextf.getText();
        		String ti = TimTextf.getText();
        		String sc = ScoTextf.getText();
        		if (CidTextf.getText().trim().equals("")|CnameTextf.getText().trim().equals("")|TecTextf.getText().trim().equals("") | TimTextf.getText().trim().equals("") | ScoTextf.getText().trim().equals(""))
        			JOptionPane.showMessageDialog(null, "请保持信息完整）", "错误",JOptionPane.ERROR_MESSAGE);
        		else {
        			System.out.println("执行课程修改操作"); 
        			CourseSQL.edit("edi",id,na,ty,te,ti,sc);
        			Vector<?> rowDatan2 = CourseSQL.getRows(); 
        	    	tableModel2.setDataVector(rowDatan2,columnNames2);//设置新内容
        			tableModel2.fireTableStructureChanged();	
        		}
        	}
        });
        Cedibut.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        Cedibut.setBounds(26, 194, 75, 37);
        coursetool.add(Cedibut);
        
        usrpan = new JPanel();
        usrpan.setLayout(null);
        usrpan.setBackground(SystemColor.menu);
        
        usredit = new JPanel();
        usredit.setLayout(null);
        usredit.setToolTipText("");
        usredit.setBorder(BorderFactory.createTitledBorder ("编辑数据"));
        usredit.setBounds(394, 0, 390, 261);
        usrpan.add(usredit);
        
        tearb = new JRadioButton("\u8001   \u5E08");
        tearb.setMargin(new Insets(1, 1, 1, 1));
        tearb.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        tearb.setBounds(244, 118, 95, 35);
        usredit.add(tearb);
        
        stdrb = new JRadioButton("\u5B66   \u751F");
        stdrb.setMargin(new Insets(1, 1, 1, 1));
        stdrb.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        stdrb.setBounds(143, 118, 95, 35);
        usredit.add(stdrb);
        
        admrb = new JRadioButton("\u7BA1\u7406\u5458");
        admrb.setMargin(new Insets(1, 1, 1, 1));
        admrb.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        admrb.setBounds(143, 157, 95, 35);
        usredit.add(admrb);
        
        ButtonGroup group4 = new ButtonGroup();
        group4.add(stdrb);
        group4.add(tearb);
        group4.add(admrb);
        
        textPane_21 = new JTextPane();
        textPane_21.setBounds(37, 118, 86, 34);
        usredit.add(textPane_21);
        textPane_21.setText("\u7528\u6237\u7C7B\u578B");
        textPane_21.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_21.setEditable(false);
        textPane_21.setBackground(SystemColor.menu);
        
        usrtext1 = new JTextField();
        usrtext1.setColumns(10);
        usrtext1.setBounds(133, 36, 177, 27);
        usredit.add(usrtext1);
        
        JTextPane textPane_10 = new JTextPane();
        textPane_10.setText("\u7528\u6237\u540D");
        textPane_10.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_10.setBackground(SystemColor.menu);
        textPane_10.setBounds(57, 30, 66, 34);
        textPane_10.setEditable(false);
        usredit.add(textPane_10);
        
        JTextPane textPane_11 = new JTextPane();
        textPane_11.setText("\u5BC6   \u7801");
        textPane_11.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_11.setBackground(SystemColor.menu);
        textPane_11.setBounds(59, 74, 64, 34);
        textPane_11.setEditable(false);
        usredit.add(textPane_11);
        
        pwd1 = new JPasswordField(10);
        pwd1.setColumns(10);
        pwd1.setBounds(133, 78, 177, 27);
        pwd1.setEchoChar('*');
        usredit.add(pwd1);
        
        usrpwdcd = new JPanel();
        usrpwdcd.setLayout(null);
        usrpwdcd.setBorder(BorderFactory.createTitledBorder ("修改密码"));
        usrpwdcd.setBounds(0, 266, 392, 272);
        usrpan.add(usrpwdcd);
        
        textPane_22 = new JTextPane();
        textPane_22.setText("\u539F\u5BC6\u7801");
        textPane_22.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_22.setBackground(SystemColor.menu);
        textPane_22.setBounds(52, 64, 66, 37);
        textPane_22.setEditable(false);
        usrpwdcd.add(textPane_22);
        
        textPane_23 = new JTextPane();
        textPane_23.setText("\u65B0\u5BC6\u7801");
        textPane_23.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_23.setBackground(SystemColor.menu);
        textPane_23.setBounds(52, 112, 66, 37);
        textPane_23.setEditable(false);
        usrpwdcd.add(textPane_23);
        
        textPane_24 = new JTextPane();
        textPane_24.setText("\u786E\u8BA4\u5BC6\u7801");
        textPane_24.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_24.setBackground(SystemColor.menu);
        textPane_24.setBounds(32, 163, 86, 30);
        textPane_24.setEditable(false);
        usrpwdcd.add(textPane_24);
        
        cdpwd = new JButton("\u4FEE\u6539\u5BC6\u7801");
        cdpwd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String id = usrtext2.getText();
        		String oldpwds =new String(oldpwd.getPassword());
        		String newpwds =new String(newpwd.getPassword());
        		String newpwd2s =new String(newpwd2.getPassword());
        		int row = usrtable.getSelectedRow(); 
        		if(row==-1)
        			JOptionPane.showMessageDialog(null, "请选中需要修改密码的用户", "错误",JOptionPane.ERROR_MESSAGE);
        		else{
        			Object truepwd = usrtable.getModel().getValueAt(row,2);
        			truepwd=(String)truepwd;
        			if (id.trim().equals("")|oldpwds.trim().equals("")|newpwds.trim().equals("")|newpwd2s.trim().equals(""))
        				JOptionPane.showMessageDialog(null, "请输入完整的用户信息", "错误",JOptionPane.ERROR_MESSAGE);
        			//用户不存在
        			else if(!UsrSQL.getRows(id)) {
        				JOptionPane.showMessageDialog(null, "用户不存在", "错误",JOptionPane.ERROR_MESSAGE);
        			}
        			//原密码不对
        			else if(!oldpwds.equals(truepwd)) {
        				JOptionPane.showMessageDialog(null, "原密码错误", "错误",JOptionPane.ERROR_MESSAGE);
        			}
        			//新密码不对
        			else if(!newpwds.equals(newpwd2s)) {
        				JOptionPane.showMessageDialog(null, "新密码两次输入不同", "错误",JOptionPane.ERROR_MESSAGE);
        			}
        			//改密码
        			else {
        				System.out.println("执行用户编辑操作"); 
        				UsrSQL.cdpwd(id,newpwds);
        				Vector<?> rowDatan3 = UsrSQL.getRows(); 
        				tableModel3.setDataVector(rowDatan3,columnNames3);//设置新内容
        				tableModel3.fireTableStructureChanged();    
        				TableColumnModel tcm = usrtable.getColumnModel();  
        		        TableColumn tc = tcm.getColumn(2) ; 
        		        tcm.removeColumn(tc);
        	        	JOptionPane.showMessageDialog(null, "修改密码成功");
        			}
				}
        	}
        });
        cdpwd.setBounds(134, 213, 123, 37);
        usrpwdcd.add(cdpwd);
        cdpwd.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        
        JTextPane textPane_9 = new JTextPane();
        textPane_9.setText("\u7528\u6237\u540D");
        textPane_9.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_9.setEditable(false);
        textPane_9.setBackground(SystemColor.menu);
        textPane_9.setBounds(52, 17, 66, 34);
        usrpwdcd.add(textPane_9);
        
        usrtext2 = new JTextField();
        usrtext2.setColumns(10);
        usrtext2.setBounds(147, 21, 177, 27);
        usrpwdcd.add(usrtext2);
        
        oldpwd = new JPasswordField(10);
        oldpwd.setBounds(147, 69, 177, 27);
        oldpwd.setEchoChar('*');
        usrpwdcd.add(oldpwd);
        
        newpwd = new JPasswordField(10);
        newpwd.setBounds(147, 117, 177, 27);
        newpwd.setEchoChar('*');
        usrpwdcd.add(newpwd);
        
        newpwd2 = new JPasswordField(10);
        newpwd2.setBounds(147, 165, 177, 27);
        newpwd2.setEchoChar('*');
        usrpwdcd.add(newpwd2);
        p = new JPanel();
        exit = new JButton("退出");  
        std = new JButton("学生信息");  
        course = new JButton("课程信息");  
        usr = new JButton("\u7528\u6237\u7BA1\u7406");  	
        std.setMargin(new Insets(2,2,2,2));  
        course.setMargin(new Insets(2,2,2,2));  
        usr.setMargin(new Insets(2,2,2,2));
        p.setLayout(new GridLayout(0, 4, 0, 0));
        p.add(std);  
        p.add(course);  
        p.add(usr);  
        p.add(exit);  
        pane.add(stdpan,"p1");
        //学生信息管理表格的显示
        JScrollPane stdscrollPane = new JScrollPane();
        stdscrollPane.setBackground(SystemColor.menu);
        stdscrollPane.setForeground(Color.WHITE);
        stdscrollPane.setBorder(new TitledBorder(null, "\u5B66\u751F\u4FE1\u606F\u8868", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        stdscrollPane.setBounds(0, 0, 651, 261);
        stdpan.add(stdscrollPane);
        stdtable = new JTable(tableModel){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
            {
                       return false;}//表格不允许被编辑
            };
        stdtable.setBackground(Color.WHITE);
        stdtable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		int a = stdtable.getSelectedRow();
        		Object o0 = stdtable.getValueAt(a,0);
        		IdText.setText((String) o0);
        		//System.out.println(o0); 
        		
        		Object o1 = stdtable.getValueAt(a,1);
        		NameText.setText((String) o1);
        		//System.out.println(o1);  
        		
        		Object o2 = stdtable.getValueAt(a,2);
        		o2=(String)o2;
        		//System.out.println(o2);
        		if (o2.equals("男")) 
        			m3rb.setSelected(true);
        		//	System.out.println(o2); 
        		else if(o2.equals("女")) 
        			w3rb.setSelected(true);
        		//	System.out.println(o2); 
        		//System.out.println(o2); 
        		
        		Object o3 = stdtable.getValueAt(a,4);
        		MajorBox.setSelectedItem(o3);
        		//System.out.println(o3); 
        		
        		Object o4 = stdtable.getValueAt(a,3);
        		ClassText.setText((String) o4);
        		//System.out.println(o4); 
        		
        		Object o = stdtable.getValueAt(a,5);
        		String o5=(String)o;
        		String o51 = o5.substring(0,4);
        		String o52 = o5.substring(5,7);
        		String o53 = o5.substring(8,10);
        		YearBox.setSelectedItem(o51);
        		MonthBox.setSelectedItem(o52);
        		DayBox.setSelectedItem(o53);
        		//System.out.println(o5+o51+o52+o53);
        		
        		Object o7 = stdtable.getValueAt(a,7);
        		AddText.setText((String) o7);
        		//System.out.println(07); 
        		
        	}
        });
        //stdtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        stdscrollPane.setViewportView(stdtable);
        pane.add(coursepan, "p2");
        pane.add(usrpan, "p3");
        
        JPanel usrsearch = new JPanel();
        usrsearch.setBounds(394, 266, 390, 192);
        usrsearch.setBorder(BorderFactory.createTitledBorder ("查询条件"));
        usrpan.add(usrsearch);
        usrsearch.setLayout(null);
        
        button_5 = new JButton("\u67E5\u627E");
        button_5.setBounds(86, 209, 88, 37);
        usrsearch.add(button_5);
        button_5.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        
        usrrb = new JRadioButton("\u7528\u6237\u540D");
        usrrb.setBounds(30, 35, 83, 35);
        usrsearch.add(usrrb);
        usrrb.setMargin(new Insets(1, 1, 1, 1));
        usrrb.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        
        usrtyperb = new JRadioButton("\u7528\u6237\u7C7B\u578B");
        usrtyperb.setBounds(30, 87, 103, 35);
        usrsearch.add(usrtyperb);
        usrtyperb.setMargin(new Insets(1, 1, 1, 1));
        usrtyperb.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        
        ButtonGroup group3 = new ButtonGroup();
        group3.add(CouRad);
        group3.add(CorIdRad);
        group3.add(AllRad);
        
        couscrollPane = new JScrollPane();
        couscrollPane.setBorder(new TitledBorder(null, "\u8BFE\u7A0B\u4FE1\u606F\u8868", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        couscrollPane.setBounds(0, 0, 651, 261);
        coursepan.add(couscrollPane);
        //课程管理表格的显示
        coutable = new JTable(tableModel2){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
            	return false;
            }//表格不允许被编辑
        };
        coutable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		int a = coutable.getSelectedRow();
        		Object o0 = coutable.getValueAt(a,0);
        		CidTextf.setText((String) o0);
        		//System.out.println(o0); 
        		
        		Object o1 = coutable.getValueAt(a,1);
        		CnameTextf.setText((String) o1);
        		//System.out.println(o1);  
        		       		
        		Object o2 = coutable.getValueAt(a,5);
        		charcomboBox.setSelectedItem(o2);
        		//System.out.println(o3); 
        		
        		Object o3 = coutable.getValueAt(a,2);
        		TecTextf.setText((String) o3);
        		
        		Object o4 = coutable.getValueAt(a,3);
        		TimTextf.setText((String) o4);
        		
        		Object o5 = coutable.getValueAt(a,4);
        		ScoTextf.setText((String) o5);
        		//System.out.println(07); 
        	}
        });
        couscrollPane.setViewportView(coutable);
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(stdrb);
        group2.add(tearb);
        group2.add(admrb);
        //用户注册
        button_7 = new JButton("\u6CE8\u518C");
        button_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//编辑区输入信息的获取
        		String id = usrtext1.getText();
        		String ty = null;
        		if (stdrb.isSelected()==true)
        			ty = "学生";
        		else if(tearb.isSelected()==true)
        			ty = "老师";
        		else if(admrb.isSelected()==true)
        			ty = "管理员";
        		//System.out.println(UsrSQL.getRows(id));
				String pwd =new String(pwd1.getPassword());
        		if (id.trim().equals("")|pwd.trim().equals("")|(stdrb.isSelected()!=true&admrb.isSelected()!=true&tearb.isSelected()!=true))
        			JOptionPane.showMessageDialog(null, "请输入完整的用户信息", "错误",JOptionPane.ERROR_MESSAGE);
        		else if(UsrSQL.getRows(id))      			
        			JOptionPane.showMessageDialog(null, "用户名已存在", "错误",JOptionPane.ERROR_MESSAGE);
        		else {
        			System.out.println("执行用户添加操作"); 
        			UsrSQL.edit("add",id,ty,pwd);
        			Vector<?> rowDatan3 = UsrSQL.getRows(); 
        	    	tableModel3.setDataVector(rowDatan3,columnNames3);//设置新内容
        			tableModel3.fireTableStructureChanged();
        			TableColumnModel tcm = usrtable.getColumnModel();  
        	        TableColumn tc = tcm.getColumn(2) ; 
        	        tcm.removeColumn(tc);
        		}
        	}
        });
        button_7.setBounds(72, 199, 86, 37);
        usredit.add(button_7);
        button_7.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        //用户编辑
        button_1 = new JButton("\u4FEE\u6539");
        button_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		//编辑区输入信息的获取
        		String id = usrtext1.getText();
        		String ty = null;
        		if (stdrb.isSelected()==true)
        			ty = "学生";
        		else if(tearb.isSelected()==true)
        			ty = "老师";
        		else if(admrb.isSelected()==true)
        			ty = "管理员";
        		//验证密码
        		int row = usrtable.getSelectedRow();
        		if(row==-1)
        			JOptionPane.showMessageDialog(null, "请选中需要修改的用户", "错误",JOptionPane.ERROR_MESSAGE);
        		else{
        				String pwd =new String(pwd1.getPassword());
        			Object truepwd = usrtable.getModel().getValueAt(row,2);
					truepwd=(String)truepwd;
					//验证权限变化
					Object truety = usrtable.getModel().getValueAt(row,1);
					truety=(String)truety;
				
					//System.out.println(truepwd+pwd);
					//System.out.println(truepwd==pwd);
        			if (id.trim().equals("")|pwd.trim().equals("")|(stdrb.isSelected()!=true&admrb.isSelected()!=true&tearb.isSelected()!=true))
        				JOptionPane.showMessageDialog(null, "请输入完整的用户信息", "错误",JOptionPane.ERROR_MESSAGE);
        			else if(!pwd.equals(truepwd)) {
        				JOptionPane.showMessageDialog(null, "密码错误", "错误",JOptionPane.ERROR_MESSAGE);
        			}
        			else if(ty.equals(truety))
        				JOptionPane.showMessageDialog(null, "无改变", "错误",JOptionPane.ERROR_MESSAGE);
        			else {
        				System.out.println("执行用户编辑操作"); 
        				UsrSQL.edit("edi",id,ty,pwd);
        				Vector<?> rowDatan3 = UsrSQL.getRows(); 
        	    		tableModel3.setDataVector(rowDatan3,columnNames3);//设置新内容
        				tableModel3.fireTableStructureChanged();
        				TableColumnModel tcm = usrtable.getColumnModel();  
        	        	TableColumn tc = tcm.getColumn(2) ; 
        	        	tcm.removeColumn(tc);
        	        	JOptionPane.showMessageDialog(null, "修改成功");
        			}
        		}
        	}
        });
        button_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        button_1.setBounds(230, 199, 86, 37);
        usredit.add(button_1);
        
        ButtonGroup group5 = new ButtonGroup();
        group5.add(usrrb);
        group5.add(usrtyperb);
        
        JButton Seabut = new JButton("\u67E5\u8BE2");
        Seabut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(usrrb.isSelected()==true) {
        			String n = usrtext4.getText();
        			//System.out.println(n);  
        			Vector<?> rowDatan3 = UsrSQL.search("usr",n);
        			tableModel3.setDataVector(rowDatan3,columnNames3);//设置新内容
        			tableModel3.fireTableStructureChanged();
        			TableColumnModel tcm = usrtable.getColumnModel();  
        	        TableColumn tc = tcm.getColumn(2) ; 
        	        tcm.removeColumn(tc);
        		}
        		if(usrtyperb.isSelected()==true) {
        			String n = usrtypetext.getText();
        			if(!n.equals("学生")&!n.equals("老师")&!n.equals("管理员"))
        				JOptionPane.showMessageDialog(null, "输入的用户类型错误", "错误",JOptionPane.ERROR_MESSAGE);
            		Vector<?> rowDatan3 = UsrSQL.search("ty",n);
        			tableModel3.setDataVector(rowDatan3,columnNames3);//设置新内容
        			tableModel3.fireTableStructureChanged();
        			TableColumnModel tcm = usrtable.getColumnModel();  
        	        TableColumn tc = tcm.getColumn(2) ; 
        	        tcm.removeColumn(tc);
        		}
        	}
        });
        Seabut.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        Seabut.setBounds(74, 129, 83, 37);
        usrsearch.add(Seabut);
        
        usrtypetext = new JTextField();
        usrtypetext.setColumns(10);
        usrtypetext.setBounds(169, 91, 177, 27);
        usrsearch.add(usrtypetext);
        
        usrtext4 = new JTextField();
        usrtext4.setColumns(10);
        usrtext4.setBounds(169, 39, 177, 27);
        usrsearch.add(usrtext4);
        
        JButton backbut2 = new JButton("\u8FD4\u56DE");
        backbut2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		tableModel3.setDataVector(rowData3,columnNames3);//设置新内容
    			tableModel3.fireTableStructureChanged();
    			TableColumnModel tcm = usrtable.getColumnModel();  
    	        TableColumn tc = tcm.getColumn(2) ; 
    	        tcm.removeColumn(tc);
        	}
        });
        backbut2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        backbut2.setBounds(231, 129, 83, 37);
        usrsearch.add(backbut2);
        
        JScrollPane UsrscrollPane = new JScrollPane();
        UsrscrollPane.setBorder(new TitledBorder(null, "\u7528\u6237\u5217\u8868", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        UsrscrollPane.setBounds(0, 0, 390, 260);
        usrpan.add(UsrscrollPane);
        
        usrtable = new JTable(tableModel3){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
            	return false;
            }//表格不允许被编辑
        };
        usrtable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int a = usrtable.getSelectedRow();
        		Object o0 = usrtable.getValueAt(a,0);
        		Object o1 = usrtable.getValueAt(a,1);
        		usrtext1.setText((String) o0);
        		usrtext2.setText((String) o0);
        		usrtext3.setText((String) o0);
        		usrtext4.setText((String) o0);
        		usrtypetext.setText((String) o1);
        		//System.out.println(o0); 
        		o1=(String)o1;
        		//System.out.println(o2);
        		if (o1.equals("学生")) 
        			stdrb.setSelected(true);
        		//	System.out.println(o2); 
        		else if(o1.equals("老师")) 
        			tearb.setSelected(true);
        		else if(o1.equals("管理员")) 
        			admrb.setSelected(true);
        		//	System.out.println(o2); 
        		//System.out.println(o2); 
        	}
        });
        UsrscrollPane.setViewportView(usrtable);
        //隐藏密码列
        TableColumnModel tcm = usrtable.getColumnModel();  
        TableColumn tc = tcm.getColumn(2) ; 
        tcm.removeColumn(tc);
        
        usrtool = new JPanel();
        usrtool.setBorder(new TitledBorder(null, "\u7528\u6237\u5220\u9664", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        usrtool.setBounds(394, 458, 390, 80);
        usrpan.add(usrtool);
        usrtool.setLayout(null);
        
        textPane_12 = new JTextPane();
        textPane_12.setText("\u7528\u6237\u540D");
        textPane_12.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        textPane_12.setEditable(false);
        textPane_12.setBackground(SystemColor.menu);
        textPane_12.setBounds(18, 23, 66, 34);
        usrtool.add(textPane_12);
        
        usrtext3 = new JTextField();
        usrtext3.setColumns(10);
        usrtext3.setBounds(102, 27, 177, 27);
        usrtool.add(usrtext3);
        //删除用户
        button = new JButton("\u5220\u9664");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String id = usrtext3.getText();
        		if (id.trim().equals(""))
        			JOptionPane.showMessageDialog(null, "请输入需要删除的用户名", "错误",JOptionPane.ERROR_MESSAGE);
        		else {
        			System.out.println("执行删除操作"); 
        			UsrSQL.del(id);
        			Vector<?> rowDatan3 = UsrSQL.getRows(); 
        	    	tableModel3.setDataVector(rowDatan3,columnNames3);//设置新内容
        			tableModel3.fireTableStructureChanged();
        			TableColumnModel tcm = usrtable.getColumnModel();  
        	        TableColumn tc = tcm.getColumn(2) ; 
        	        tcm.removeColumn(tc);
        		}
        	}
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        button.setBounds(297, 22, 75, 37);
        usrtool.add(button);
        
        exit.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	dispose();
            }  
        });  
        std.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                card.show(pane,"p1");  
            }  
        });   
        course.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                card.show(pane,"p2");  
            }  
        });  
        usr.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                card.show(pane,"p3");   
            }  
        }); 
        this.getContentPane().add(pane);
        this.getContentPane().add(p,BorderLayout.NORTH);
        this.setIconImage(new ImageIcon("src/logo.png").getImage());
    	this.setTitle("学生信息管理系统 v0.9");
        this.setSize(800, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);  
    }  
}