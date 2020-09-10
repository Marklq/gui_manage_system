package system.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import system.sql.Loj;
import system.sql.User;

//注册界面
@SuppressWarnings("serial")
public class Regist extends JFrame {
	
	//按钮(loginbtn=登录，regbtn=注册)
	private JButton btn;  
	
	//用户与密码标签
	private JLabel lab1,lab2,lab3,bg_label;
	
	//背景
	private ImageIcon bground;
	
	//3个输入框
	private JTextField name; 
	private JPasswordField pass;
	private JPasswordField pass2;
	private JPanel jp=null;
	
	public Regist(){  
		this.init();
	} 
	
	//界面初始化
	@SuppressWarnings("static-access")
	private void init() {
		jp=(JPanel) super.getContentPane();//顶级容器  

		lab1=new JLabel("用 户 名：");  
		lab1.setBounds(170,100,100,60);
		name=new JTextField(20);  
		name.setBounds(260,115,200,30);  
		
		
		lab2=new JLabel("密    码：");  
		lab2.setBounds(170,145,100,60);  
		pass=new JPasswordField(20);  
		pass.setBounds(260,165,200,30);  
		
		lab3=new JLabel("重复密码：");  
		lab3.setBounds(170,200,100,60);  
		pass2=new JPasswordField(20);  
		pass2.setBounds(260,215,200,30);

		btn=new JButton("注册用户");  
		btn.setBounds(310,300,100,40);  
		
		//设置标签样式
		Font black = new Font("黑体", Font.PLAIN, 17);
		lab1.setFont(black);
		lab2.setFont(black);
		lab3.setFont(black);
		btn.setFont(black);
		lab1.setForeground(Color.WHITE);
		lab2.setForeground(Color.WHITE);
		lab3.setForeground(Color.WHITE);
		
		//设置按钮样式
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setBorder(BorderFactory.createRaisedBevelBorder());
		btn.setContentAreaFilled(false);
//		btn.setForeground(Color.WHITE);
		
		//设置登录界面背景
		bground = new ImageIcon("bgimgs/bg_regist.jpg");
		bg_label = new JLabel(bground);
		bg_label.setBounds(0, 0, bground.getIconWidth(), bground.getIconHeight());
		
		jp.setOpaque(false);//面板设置为不可视
		jp.setLayout(null);
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(bg_label, new Integer(Integer.MIN_VALUE));
		
		
		//依次添加组件
		jp.add(lab1);  
		jp.add(lab2); 
		jp.add(lab3);
		jp.add(name);  

		jp.add(pass);
		jp.add(pass2);
		jp.add(btn);  
		
		//更改GUI窗口的标志
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("icons/register.png");
		setIconImage(image);
		
		//设置主框的属性
		super.setTitle("灰狗管理系统--注册");
		super.setSize( bground.getIconWidth(), bground.getIconHeight());
		super.setLocation(600, 200);
		super.setResizable(false);
		super.setDefaultCloseOperation(super.DISPOSE_ON_CLOSE);
		super.setVisible(true);  
		
		//给2个按钮添加监听
		ButtonListener regListener=new ButtonListener();  
		btn.addActionListener(regListener);  
		
	
	}
	
	//事件监听器接口  
		class ButtonListener implements ActionListener{  
			
			public void actionPerformed(ActionEvent e){  
			
				Object source=e.getSource();  
				if(source instanceof JButton ){
					//实例化User类
					User user =new User();
					Loj loj =new Loj();
					JButton jb=(JButton)source;//按钮  
					String txt=jb.getText();  
					String userName = name.getText();//获取用户名  
					String password = new String(pass.getPassword());//获取密码  
					String password2 = new String(pass2.getPassword());
					
					//获取注册的时间
				     Date date1=new Date();                             
				     SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
				     String date=temp.format(date1);  
					
					
					if(txt.equals("注册用户")){
						if(password.equals(password2)) {
							if(!(password.equals("")&&password2.equals("")&&userName.equals(""))) {
								if(user.isReg(userName, password)&&loj.setLog(userName, "用户注册",date)) {
									JOptionPane.showMessageDialog(jp, "注册成功!"+"\n"+"请返回登录界面进行登录"+"\n"+"\n"+"您的密码是:"+password+"\n"+"请勿告诉他人您的密码信息！");//提示
								}
							}
						}else {
							JOptionPane.showMessageDialog(jp, "密码输入错误!"+"\n"+"请保持两次输入的密码一致");//提示  
						}
					} 
				}     
			}  
		} 
	
}
