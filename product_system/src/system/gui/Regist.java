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

//ע�����
@SuppressWarnings("serial")
public class Regist extends JFrame {
	
	//��ť(loginbtn=��¼��regbtn=ע��)
	private JButton btn;  
	
	//�û��������ǩ
	private JLabel lab1,lab2,lab3,bg_label;
	
	//����
	private ImageIcon bground;
	
	//3�������
	private JTextField name; 
	private JPasswordField pass;
	private JPasswordField pass2;
	private JPanel jp=null;
	
	public Regist(){  
		this.init();
	} 
	
	//�����ʼ��
	@SuppressWarnings("static-access")
	private void init() {
		jp=(JPanel) super.getContentPane();//��������  

		lab1=new JLabel("�� �� ����");  
		lab1.setBounds(170,100,100,60);
		name=new JTextField(20);  
		name.setBounds(260,115,200,30);  
		
		
		lab2=new JLabel("��    �룺");  
		lab2.setBounds(170,145,100,60);  
		pass=new JPasswordField(20);  
		pass.setBounds(260,165,200,30);  
		
		lab3=new JLabel("�ظ����룺");  
		lab3.setBounds(170,200,100,60);  
		pass2=new JPasswordField(20);  
		pass2.setBounds(260,215,200,30);

		btn=new JButton("ע���û�");  
		btn.setBounds(310,300,100,40);  
		
		//���ñ�ǩ��ʽ
		Font black = new Font("����", Font.PLAIN, 17);
		lab1.setFont(black);
		lab2.setFont(black);
		lab3.setFont(black);
		btn.setFont(black);
		lab1.setForeground(Color.WHITE);
		lab2.setForeground(Color.WHITE);
		lab3.setForeground(Color.WHITE);
		
		//���ð�ť��ʽ
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setBorder(BorderFactory.createRaisedBevelBorder());
		btn.setContentAreaFilled(false);
//		btn.setForeground(Color.WHITE);
		
		//���õ�¼���汳��
		bground = new ImageIcon("bgimgs/bg_regist.jpg");
		bg_label = new JLabel(bground);
		bg_label.setBounds(0, 0, bground.getIconWidth(), bground.getIconHeight());
		
		jp.setOpaque(false);//�������Ϊ������
		jp.setLayout(null);
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(bg_label, new Integer(Integer.MIN_VALUE));
		
		
		//����������
		jp.add(lab1);  
		jp.add(lab2); 
		jp.add(lab3);
		jp.add(name);  

		jp.add(pass);
		jp.add(pass2);
		jp.add(btn);  
		
		//����GUI���ڵı�־
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("icons/register.png");
		setIconImage(image);
		
		//�������������
		super.setTitle("�ҹ�����ϵͳ--ע��");
		super.setSize( bground.getIconWidth(), bground.getIconHeight());
		super.setLocation(600, 200);
		super.setResizable(false);
		super.setDefaultCloseOperation(super.DISPOSE_ON_CLOSE);
		super.setVisible(true);  
		
		//��2����ť��Ӽ���
		ButtonListener regListener=new ButtonListener();  
		btn.addActionListener(regListener);  
		
	
	}
	
	//�¼��������ӿ�  
		class ButtonListener implements ActionListener{  
			
			public void actionPerformed(ActionEvent e){  
			
				Object source=e.getSource();  
				if(source instanceof JButton ){
					//ʵ����User��
					User user =new User();
					Loj loj =new Loj();
					JButton jb=(JButton)source;//��ť  
					String txt=jb.getText();  
					String userName = name.getText();//��ȡ�û���  
					String password = new String(pass.getPassword());//��ȡ����  
					String password2 = new String(pass2.getPassword());
					
					//��ȡע���ʱ��
				     Date date1=new Date();                             
				     SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
				     String date=temp.format(date1);  
					
					
					if(txt.equals("ע���û�")){
						if(password.equals(password2)) {
							if(!(password.equals("")&&password2.equals("")&&userName.equals(""))) {
								if(user.isReg(userName, password)&&loj.setLog(userName, "�û�ע��",date)) {
									JOptionPane.showMessageDialog(jp, "ע��ɹ�!"+"\n"+"�뷵�ص�¼������е�¼"+"\n"+"\n"+"����������:"+password+"\n"+"���������������������Ϣ��");//��ʾ
								}
							}
						}else {
							JOptionPane.showMessageDialog(jp, "�����������!"+"\n"+"�뱣���������������һ��");//��ʾ  
						}
					} 
				}     
			}  
		} 
	
}
