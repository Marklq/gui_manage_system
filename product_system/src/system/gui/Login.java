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

//��¼����
@SuppressWarnings("serial")
public class Login extends JFrame{ 

	//��ť(loginbtn=��¼��regbtn=ע��)
	private JButton loginbtn;  
	private JButton regbtn;

	//�û��������ǩ
	private JLabel lab1,lab2,bg_label;

	//2�������
	private JTextField name; 
	private JPasswordField pass;

	//����
	private ImageIcon bground;

	JPanel jp=(JPanel) super.getContentPane();//��������  

	public Login(){  
		this.init();
	} 


	//�����ʼ��
	private void init() {
		
		Font black = new Font("����", Font.LAYOUT_LEFT_TO_RIGHT, 18);

		lab1=new JLabel("�û�����");  
		lab1.setBounds(170,98,120,60);
		name=new JTextField(20);  
		name.setBounds(250,110,210,33);  

		lab2=new JLabel("��  �룺");  
		lab2.setBounds(170,178,120,60);  
		pass=new JPasswordField(20);  
		pass.setBounds(250,190,210,33);  

		loginbtn=new JButton("��¼");  
		loginbtn.setBounds(240,280,80,35);  

		regbtn=new JButton("ע��");  
		regbtn.setBounds(380,280,80,35);  

		
		//���ð�ť����ʽ
		loginbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//��������ƶ�����ť�ϵ���ʽ
		regbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginbtn.setContentAreaFilled(false);//���ð�ť�Ƿ�͸��
		regbtn.setContentAreaFilled(false);
		loginbtn.setBackground(Color.LIGHT_GRAY);//���ñ���ɫ
		regbtn.setBackground(Color.LIGHT_GRAY);
		loginbtn.setBorder(BorderFactory.createRaisedBevelBorder());//���ð�ť͹��
		regbtn.setBorder(BorderFactory.createRaisedBevelBorder());

		//�����������ʽ 
		lab1.setFont(black);//���ñ�ǩ��ʽ
		lab2.setFont(black);
		loginbtn.setForeground(Color.WHITE);//�����������ɫ
		regbtn.setForeground(Color.white);
		loginbtn.setFont(black);//���ð�ť��������ʽ
		regbtn.setFont(black);
		

		//����GUI���ڵı�־
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("icons/dog.png");
		setIconImage(image);


		//���õ�¼���汳��
		bground = new ImageIcon("bgimgs/bg_login.jpg");
		bg_label = new JLabel(bground);
		bg_label.setBounds(0, 0, bground.getIconWidth(), bground.getIconHeight());

		jp.setOpaque(false);
		jp.setLayout(null);
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(bg_label, new Integer(Integer.MIN_VALUE));


		//����������
		jp.add(lab1);  
		jp.add(lab2);  
		jp.add(name);  

		jp.add(pass);  
		jp.add(loginbtn);  
		jp.add(regbtn);


		//�������������
		super.setTitle("�ҹ��������ϵͳ");
		super.setSize( bground.getIconWidth(), bground.getIconHeight());
		super.setLocation(600, 200);
		super.setResizable(false);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible(true);  

		//��2����ť��Ӽ���
		ButtonListener mainListener=new ButtonListener();  
		regbtn.addActionListener(mainListener);  
		loginbtn.addActionListener(mainListener); 
	}

	
	
	//�¼��������ӿ�  
	class ButtonListener implements ActionListener{  
		
		public void actionPerformed(ActionEvent e){  
			
			Object source=e.getSource();  
			if(source instanceof JButton ){
				//ʵ����User��
				User user =new User();
				Loj loj = new Loj();
				JButton jb=(JButton)source;//��ť 
				Container cont=(Container)source;
				
				String txt=jb.getText();  
				String userName=name.getText();//��ȡ�û���  
				String password=new String(pass.getPassword());;//��ȡ����  
				
				//��ȡ��¼��ʱ��
			     Date date1=new Date();                             
			     SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
			     String date=temp.format(date1);  

				
				//������Ϣ�����ͼ�����
				ImageIcon err_icon = new ImageIcon("icons/err.jpg");
				ImageIcon cor_icon = new ImageIcon("icons/correct.jpg");
				ImageIcon void_icon = new ImageIcon("icons/void.png");


				if(txt.equals("��¼")){  
					//������־���ж�����
					if(user.isLogin(userName, password)&&loj.setLog(userName, "�û���¼",date)){                    
						JOptionPane.showMessageDialog(jp, "��ӭʹ�ûҹ��������ϵͳ!", "��½�ɹ�!", JOptionPane.INFORMATION_MESSAGE,cor_icon );

						cont.setVisible(true);
						//cont.setVisible(false);  //���õ�¼���¼��ť��ʧ����ֹ�ظ���¼
						new Product_Management();
					}else if(userName==null||password==null) {
						JOptionPane.showMessageDialog(jp, "���벻��Ϊ��!", "��¼����", JOptionPane.ERROR_MESSAGE,void_icon );

					}else{  
						JOptionPane.showMessageDialog(jp, "�û����������д���!", "��¼����", JOptionPane.ERROR_MESSAGE,err_icon );
					}  
				}else if(txt.equals("ע��")){  
					new Regist();  
				}  
			}     
		}  
	} 

	//����
	public static void main(String [] args){  
		@SuppressWarnings("unused")
		Login mainLogin=new Login();  
	}  
}

