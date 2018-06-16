package login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

import dao.UsrSQL;
import main.MainFrame;


public class LoginDialog extends JPanel{
	public LoginDialog() {
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void frame(String title) {
		try {
			String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(lookAndFeel);
		}
		catch(ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException e) {
		}
		JFrame jf = new JFrame(title);
		Container c = jf.getContentPane();

		
		JPanel p = new JPanel(new GridLayout(5,1,0,0));
		JPanel p1 = new JPanel(new FlowLayout(1,10,10));
		JPanel p11 = new JPanel(new FlowLayout(1,10,10));
		JPanel p2 = new JPanel(new FlowLayout(1,50,15));
		JPanel p3 = new JPanel();


		JLabel jl = new JLabel("学生信息管理系统",0);
		jl.setFont(new Font("微软雅黑",1,20));
		jl.setForeground(Color.blue);
		
		JLabel jlusr = new JLabel("用户名",0);
		JTextField jtusr = new JTextField(15);
		
		JLabel jlpwd = new JLabel("密  码",0);
		JPasswordField jtpwd = new JPasswordField(15);
		jtpwd.setEchoChar('*');//设置回显字符*
		
		JButton jb1 = new JButton("登陆");
		jtpwd.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n')
					jb1.doClick();
			}
		});//回车登陆功能
		
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usrStr = jtusr.getText();
				String pwdStr = new String(jtpwd.getPassword());
				if(usrStr.trim().length() == 0||pwdStr.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
					return;
				}	
				try {
					if(!UsrSQL.getRows(usrStr)) {
        				JOptionPane.showMessageDialog(null, "用户不存在", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
        			else if (!CheckRol.CheckRole(usrStr,pwdStr)){
							//System.out.printf(usrStr +","+ pwdStr);
							JOptionPane.showMessageDialog(null, "用户名或密码错误","错误",JOptionPane.ERROR_MESSAGE);
							return;
						
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				//} catch (SQLException e1) {
					// TODO Auto-generated catch block
			//		e1.printStackTrace();
				}
				jf.setVisible(false);
				new MainFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			}
		});//登陆按钮监听器。trim()的作用是:去掉字符串左右的空格
		
		JButton jb2 = new JButton("退出");
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
			}
		});

		JLabel jl2 = new JLabel();
		jl2.setText("Designed by 2016060202011");
		jl2.setFont(new Font("微软雅黑",0,10));
		jl2.setForeground(Color.GRAY);

		p1.add(jlusr);
		p1.add(jtusr);
		p11.add(jlpwd);
		p11.add(jtpwd);
		
		p2.add(jb1);
		p2.add(jb2);
		
		p3.add(jl2);
		
		p.add(jl);
		p.add(p1);
		p.add(p11);
		p.add(p2);
		p.add(p3);
		
		c.add(p); 
		jf.setVisible(true);
		jf.setSize(320,300);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setIconImage(new ImageIcon("src/logo.png").getImage());
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}		
	public static void main(String[] agrs){
		new LoginDialog().frame("系统登陆");
	}
}



