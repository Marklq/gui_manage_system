package system.gui;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import system.sql.Loj;
import system.sql.User;  

//登录界面
@SuppressWarnings("serial")
public class Login extends JFrame{ 

	//按钮(loginbtn=登录，regbtn=注册)
	private JButton loginbtn;  
	private JButton regbtn;

	//用户与密码标签
	private JLabel lab1,lab2,bg_label;

	//2个输入框
	private JTextField name; 
	private JPasswordField pass;

	//背景
	private ImageIcon bground;

	JPanel jp=(JPanel) super.getContentPane();//顶级容器  

	public Login(){  
		this.init();
	} 


	//界面初始化
	private void init() {
		
		Font black = new Font("黑体", Font.LAYOUT_LEFT_TO_RIGHT, 18);

		lab1=new JLabel("用户名：");  
		lab1.setBounds(170,98,120,60);
		name=new JTextField(20);  
		name.setBounds(250,110,210,33);  

		lab2=new JLabel("密  码：");  
		lab2.setBounds(170,178,120,60);  
		pass=new JPasswordField(20);  
		pass.setBounds(250,190,210,33);  

		loginbtn=new JButton("登录");  
		loginbtn.setBounds(240,280,80,35);  

		regbtn=new JButton("注册");  
		regbtn.setBounds(380,280,80,35);  

		
		//设置按钮的样式
		loginbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移动到按钮上的样式
		regbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginbtn.setContentAreaFilled(false);//设置按钮是否透明
		regbtn.setContentAreaFilled(false);
		loginbtn.setBackground(Color.LIGHT_GRAY);//设置背景色
		regbtn.setBackground(Color.LIGHT_GRAY);
		loginbtn.setBorder(BorderFactory.createRaisedBevelBorder());//设置按钮凸起
		regbtn.setBorder(BorderFactory.createRaisedBevelBorder());

		//设置字体的样式 
		lab1.setFont(black);//设置标签样式
		lab2.setFont(black);
		loginbtn.setForeground(Color.WHITE);//设置字体的颜色
		regbtn.setForeground(Color.white);
		loginbtn.setFont(black);//设置按钮中字体样式
		regbtn.setFont(black);
		

		//更改GUI窗口的标志
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("icons/dog.png");
		setIconImage(image);


		//设置登录界面背景
		bground = new ImageIcon("bgimgs/bg_login.jpg");
		bg_label = new JLabel(bground);
		bg_label.setBounds(0, 0, bground.getIconWidth(), bground.getIconHeight());

		jp.setOpaque(false);
		jp.setLayout(null);
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(bg_label, new Integer(Integer.MIN_VALUE));


		//依次添加组件
		jp.add(lab1);  
		jp.add(lab2);  
		jp.add(name);  

		jp.add(pass);  
		jp.add(loginbtn);  
		jp.add(regbtn);


		//设置主框的属性
		super.setTitle("灰狗货物管理系统");
		super.setSize( bground.getIconWidth(), bground.getIconHeight());
		super.setLocation(600, 200);
		super.setResizable(false);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible(true);  

		//给2个按钮添加监听
		ButtonListener mainListener=new ButtonListener();  
		regbtn.addActionListener(mainListener);  
		loginbtn.addActionListener(mainListener); 
	}

	
	
	//事件监听器接口  
	class ButtonListener implements ActionListener{  
		
		public void actionPerformed(ActionEvent e){  
			
			Object source=e.getSource();  
			if(source instanceof JButton ){
				//实例化User类
				User user =new User();
				Loj loj = new Loj();
				JButton jb=(JButton)source;//按钮 
				Container cont=(Container)source;
				
				String txt=jb.getText();  
				String userName=name.getText();//获取用户名  
				String password=new String(pass.getPassword());;//获取密码  
				
				//获取登录的时间
			     Date date1=new Date();                             
			     SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
			     String date=temp.format(date1);  

				
				//设置消息弹框的图标对象
				ImageIcon err_icon = new ImageIcon("icons/err.jpg");
				ImageIcon cor_icon = new ImageIcon("icons/correct.jpg");
				ImageIcon void_icon = new ImageIcon("icons/void.png");


				if(txt.equals("登录")){  
					//插入日志且判断密码
					if(user.isLogin(userName, password)&&loj.setLog(userName, "用户登录",date)){                    
						JOptionPane.showMessageDialog(jp, "欢迎使用灰狗货物管理系统!", "登陆成功!", JOptionPane.INFORMATION_MESSAGE,cor_icon );

						cont.setVisible(true);
						//cont.setVisible(false);  //设置登录后登录按钮消失，防止重复登录
						new Product_Management();
					}else if(userName==null||password==null) {
						JOptionPane.showMessageDialog(jp, "输入不能为空!", "登录错误", JOptionPane.ERROR_MESSAGE,void_icon );

					}else{  
						JOptionPane.showMessageDialog(jp, "用户名或密码有错误!", "登录错误", JOptionPane.ERROR_MESSAGE,err_icon );
					}  
				}else if(txt.equals("注册")){  
					new Regist();  
				}  
			}     
		}  
	} 

	//运行
	public static void main(String [] args){  
		@SuppressWarnings("unused")
		Login mainLogin=new Login();  
	}  
}

