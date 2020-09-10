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
import javax.swing.JTextField;

import system.sql.Product;

@SuppressWarnings("serial")
public class AddPro extends JFrame{
	private JButton addbtn; 
	private JButton changebtn; 

	//用户与密码标签 背景标签
	private JLabel lab1,lab2,lab3,lab4,lab5,lab6,bg_label;

	//背景
	private ImageIcon bground;

	//5个输入框
	JTextField pname; 
	JTextField pnum;
	JTextField pprice;
	JTextField pclass;
	JTextField pprduce;
	JTextField pid;
	
	public AddPro(){  
		this.init();
	} 

	@SuppressWarnings("static-access")
	public void init() {
		JPanel jp=(JPanel) super.getContentPane();//顶级容器  
		//		con.setLayout(null);

		Font black = new Font("黑体", Font.LAYOUT_LEFT_TO_RIGHT, 17);
		Font white = new Font("黑体", Font.BOLD, 16);
		
		
		
		lab6=new JLabel("商品ID：");  
		lab6.setBounds(180,40,100,60);
		pid=new JTextField(20);  
		pid.setBounds(260,55,210,30);  
		
		lab1=new JLabel("商品名：");  
		lab1.setBounds(180,80,100,60);
		pname=new JTextField(20);  
		pname.setBounds(260,95,210,30);  

		lab2=new JLabel("数  量：");  
		lab2.setBounds(180,120,100,60);  
		pnum=new JTextField(20);
		pnum.setBounds(260,135,210,30);  

		lab3=new JLabel("价  格：");  
		lab3.setBounds(180,160,100,60);
		pprice=new JTextField(20);  
		pprice.setBounds(260,175,210,30);

		lab4=new JLabel("种  类：");  
		lab4.setBounds(180,200,100,60);
		pclass=new JTextField(20);  
		pclass.setBounds(260,215,210,30); 

		
		lab5=new JLabel("产  地：");  
		lab5.setBounds(180,240,100,60);
		pprduce=new JTextField(20);  
		pprduce.setBounds(260,255,210,30); 
		
		
		
		
		addbtn=new JButton("添加");  
		addbtn.setBounds(210,320,70,35);  
		changebtn=new JButton("更改");  
		changebtn.setBounds(400,320,70,35);  

		//设置标签样式
		lab1.setFont(black);
		lab2.setFont(black);
		lab3.setFont(black);
		lab4.setFont(black);
		lab5.setFont(black);
		lab6.setFont(black);
		
		lab1.setForeground(Color.WHITE);
		lab2.setForeground(Color.WHITE);
		lab3.setForeground(Color.WHITE);
		lab4.setForeground(Color.WHITE);
		lab5.setForeground(Color.WHITE);
		lab6.setForeground(Color.WHITE);
		
		
		
		//设置按钮样式
		addbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addbtn.setBackground(Color.LIGHT_GRAY);
		addbtn.setBorder(BorderFactory.createRaisedBevelBorder());
		addbtn.setContentAreaFilled(false);
		changebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changebtn.setBackground(Color.LIGHT_GRAY);
		changebtn.setBorder(BorderFactory.createRaisedBevelBorder());
		changebtn.setContentAreaFilled(false);
		
		addbtn.setFont(white);
		changebtn.setFont(white);
		
		addbtn.setForeground(Color.WHITE);
		changebtn.setForeground(Color.WHITE);
		
		
		
		//设置界面背景
		bground = new ImageIcon("bgimgs/bg_add.jpg");
		bg_label = new JLabel(bground);
		bg_label.setBounds(0, 0, bground.getIconWidth(), bground.getIconHeight());

		jp.setOpaque(false);
		jp.setLayout(null);
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(bg_label, new Integer(Integer.MIN_VALUE));


		//依次添加组件
		jp.add(lab1);  
		jp.add(lab2);
		jp.add(lab3);
		jp.add(lab4);
		jp.add(lab5);
		jp.add(lab6);
		jp.add(pname);  
		jp.add(pnum); 
		jp.add(pprice);
		jp.add(pclass);
		jp.add(pprduce);
		jp.add(pid);
		
		jp.add(addbtn);
		jp.add(changebtn);

		//更改GUI窗口的标志
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("icons/add.png");
		setIconImage(image);

		//设置属性
		super.setTitle("添加商品");
		super.setSize( bground.getIconWidth(), bground.getIconHeight());
		super.setLocation(600, 200);
		super.setResizable(false);
		super.setDefaultCloseOperation(super.DISPOSE_ON_CLOSE);
		super.setVisible(true);  

		//给2个按钮添加监听
		ButtonListener listener1 = new ButtonListener();  
		addbtn.addActionListener(listener1);  
		changebtn.addActionListener(listener1); 
	}

	//事件监听器接口  
	class ButtonListener implements ActionListener{  
		public void actionPerformed(ActionEvent e){  
			Object source=e.getSource();  
			Product product = new Product();
			if(source instanceof JButton ){
				JButton jb=(JButton)source;//按钮  
				String txt=jb.getText();  
				
				String name = pname.getText();
				int num = Integer.parseInt(pnum.getText());
				int price = Integer.parseInt(pprice.getText());
				int id = Integer.parseInt(pid.getText());
				String pclazz = pclass.getText();
				String prduce = pprduce.getText();
			
				
				//获取添加商品的时间
				Date date1=new Date();                             
				SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd");  
				String time=temp.format(date1);  

				if(txt.equals("添加")){ 
					if(!(pid.getText().equals("")&&name.equals("")&&pnum.getText().equals("")&&pprice.getText().equals("")&&pclazz.equals("")&&prduce.equals(""))) {
						if(product.addPro(id, name,num,price,pclazz,prduce,time)) {
							JOptionPane.showMessageDialog(jb, "添加成功!"+"\n"+"如需再次添加请修改商品信息！");
						}
					}else {
						JOptionPane.showMessageDialog(jb, "添加失败!");
					}

				}else if(txt.equals("更改")){  
					if(!(name.equals("")&&pnum.getText().equals("")&&pprice.getText().equals("")&&pclazz.equals("")&&prduce.equals(""))) {
						if(product.changePro(num, price,  pclazz,name,prduce, id)) {
							JOptionPane.showMessageDialog(jb, "更改成功!");
						}
					}else {
						JOptionPane.showMessageDialog(jb, "更改失败!");
					}
				}  
			}     
		}  
	} 



}
