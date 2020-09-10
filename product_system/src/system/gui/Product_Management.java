package system.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import system.sql.Loj;
import system.sql.Product;

@SuppressWarnings("serial")
public class Product_Management extends JFrame {
	Product product = new Product();

	JTextArea area;
	JMenuBar menubar;

	JMenu addmenu;
	JMenu findmenu;
	JMenu delmenu;
	JMenu changemenu;
	JMenu lojmenu;
	JMenu managemenu;
	JMenu moremenu;

	JPanel jp,scpanel,bgpane;

	JMenuItem addPro;
	JMenuItem onlyPro;
	JMenuItem onlyDel;
	JMenuItem batchDel;
	JMenuItem Alldel;
	JMenuItem clazzPro;
	JMenuItem PPro;	
	JMenuItem allPro;
	JMenuItem onlyChange;
	JMenuItem batchChange;
	JMenuItem lojItem;
	JMenuItem delloj;
	JMenuItem delAllloj;
	JMenuItem manageitem;
	JMenuItem delmanage;
	JMenuItem delAllManage;
	JMenuItem moremenuitem;


	JLabel text;
	String headText ="����ID"+"\t"+ "��������"+"\t"+"������Ŀ"+"\t"+"����۸�"+"\t"+"�������� "+"\t"+"�������"+"\t"+"����ʱ��";
	String line = "\n"+"-----------------------------------------------------"
			+ "----------------------------------------------------"+ 
			"---------------------------------------------";
	String info;
	String PassWord1 = "123456";

	public void init() { // ��������

		Font south = new Font("Ҷ����ë������2.0��", Font.ITALIC, 20);
		Font black = new Font("����", Font.PLAIN, 15);

		text = new JLabel("��  ӭ  ʹ  ��  ��  ��  ��  ��  ��  ��  ϵ  ͳ  ��  ��");
		area = new JTextArea();

		text.setFont(south);
		text.setForeground(Color.black);

		area.setEditable(false);//�����м��area���ɱ༭
		area.setText(line);
		area.setRows(18);
		area.setColumns(55);

		menubar = new JMenuBar();

		//���˵��������
		addmenu = new JMenu("�� �� �� ��");
		findmenu = new JMenu("�� �� �� ��");
		changemenu = new JMenu("�� �� �� ��");
		delmenu = new JMenu("ɾ �� �� ��");
		lojmenu = new JMenu("�� ¼ �� ¼");
		managemenu =  new JMenu("�� �� �� ��");
		moremenu = new JMenu("�� �� ");

		//���ò˵������ʽ
		//		addmenu.setBorder(BorderFactory.createRaisedBevelBorder());//͹��
		//		findmenu.setBorder(BorderFactory.createRaisedBevelBorder());
		//		delmenu.setBorder(BorderFactory.createRaisedBevelBorder());
		//		lojmenu.setBorder(BorderFactory.createRaisedBevelBorder());
		//		managemenu.setBorder(BorderFactory.createRaisedBevelBorder());
		//		changemenu.setBorder(BorderFactory.createRaisedBevelBorder());

		addmenu.setBorder(BorderFactory.createLoweredBevelBorder());//����
		findmenu.setBorder(BorderFactory.createLoweredBevelBorder());
		delmenu.setBorder(BorderFactory.createLoweredBevelBorder());
		findmenu   .setBorder(BorderFactory.createLoweredBevelBorder());
		lojmenu    .setBorder(BorderFactory.createLoweredBevelBorder());
		managemenu.setBorder(BorderFactory.createLoweredBevelBorder());
		changemenu.setBorder(BorderFactory.createLoweredBevelBorder());
		moremenu.setBorder(BorderFactory.createLoweredBevelBorder());

		//���ò˵�����ı���ɫ
		addmenu.setBackground(Color.GRAY);
		findmenu  .setBackground(Color.GRAY);
		delmenu   .setBackground(Color.GRAY);
		findmenu  .setBackground(Color.GRAY);
		lojmenu   .setBackground(Color.GRAY);
		managemenu.setBackground(Color.GRAY);
		changemenu.setBackground(Color.GRAY);
		moremenu.setBackground(Color.GRAY);

		//����ƶ����˵���ť�ϵ���ʽ
		addmenu .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		findmenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delmenu .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		findmenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lojmenu .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		managemenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changemenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		moremenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


		//����������ʽ
		menubar.setFont(black);
		addmenu.setFont(black);
		findmenu.setFont(black);
		changemenu.setFont(black);
		delmenu.setFont(black);
		lojmenu.setFont(black);
		managemenu.setFont(black);
		moremenu.setFont(black);

		//���˵������������
		addPro = new JMenuItem("�� �� �� ��");
		onlyPro = new JMenuItem("�� һ �� ��");
		clazzPro = new JMenuItem("�� �� �� ��");
		allPro = new JMenuItem("�� �� �� ��");
		PPro = new JMenuItem("�� �� �� ��");
		onlyDel = new JMenuItem("��������ɾ��");
		batchDel = new JMenuItem("��������ɾ��");
		Alldel = new JMenuItem("��ջ�����");
		onlyChange = new JMenuItem("�� һ �� ��");
		batchChange = new JMenuItem("�� �� �� ��");
		lojItem = new JMenuItem("�� �� �� ¼");
		delloj = new JMenuItem("ɾ �� �� ¼");
		delAllloj = new JMenuItem("�� �� �� ¼");

		manageitem = new JMenuItem("�鿴�û�����");
		delmanage = new JMenuItem("ɾ�������û�");
		delAllManage = new JMenuItem("ɾ�������û�");

		moremenuitem = new JMenuItem("���๦��");


		//�������ఴť����ʽ
		addPro.setBorder(BorderFactory.createRaisedBevelBorder());
		onlyPro.setBorder(BorderFactory.createRaisedBevelBorder());
		clazzPro.setBorder(BorderFactory.createRaisedBevelBorder());
		allPro.setBorder(BorderFactory.createRaisedBevelBorder());
		onlyChange.setBorder(BorderFactory.createRaisedBevelBorder());
		batchChange.setBorder(BorderFactory.createRaisedBevelBorder());
		lojItem   .setBorder(BorderFactory.createRaisedBevelBorder());
		manageitem.setBorder(BorderFactory.createRaisedBevelBorder());
		onlyDel   .setBorder(BorderFactory.createRaisedBevelBorder());
		batchDel  .setBorder(BorderFactory.createRaisedBevelBorder());
		delmanage.setBorder(BorderFactory.createRaisedBevelBorder());
		delloj.setBorder(BorderFactory.createRaisedBevelBorder());
		Alldel.setBorder(BorderFactory.createRaisedBevelBorder());
		delAllManage.setBorder(BorderFactory.createRaisedBevelBorder());
		delAllloj.setBorder(BorderFactory.createRaisedBevelBorder());
		moremenuitem.setBorder(BorderFactory.createRaisedBevelBorder());
		PPro.setBorder(BorderFactory.createRaisedBevelBorder());


		//�������ఴť�ı���ɫ
		addPro.setBackground(Color.WHITE);
		onlyPro    .setBackground(Color.WHITE);
		clazzPro   .setBackground(Color.WHITE);
		allPro     .setBackground(Color.WHITE);
		onlyChange .setBackground(Color.WHITE);
		batchChange.setBackground(Color.WHITE);
		lojItem    .setBackground(Color.WHITE);
		manageitem .setBackground(Color.WHITE);
		onlyDel    .setBackground(Color.WHITE);
		batchDel   .setBackground(Color.WHITE);
		delmanage.setBackground(Color.WHITE);
		delloj.setBackground(Color.WHITE);
		Alldel      .setBackground(Color.WHITE);
		delAllManage.setBackground(Color.WHITE);
		delAllloj   .setBackground(Color.WHITE);
		moremenuitem   .setBackground(Color.WHITE);
		PPro   .setBackground(Color.WHITE);


		//��������ƶ���ť�ϵ���ʽ
		addPro.    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		onlyPro.   setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clazzPro.  setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allPro.    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		onlyChange.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		batchChange.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lojItem   .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		manageitem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		onlyDel   .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		batchDel  .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delmanage  .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delloj  .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Alldel      .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delAllManage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delAllloj   .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		moremenuitem   .setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		PPro   .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));




		//����������ʽ
		addPro.setFont(black);
		onlyPro.setFont(black);
		clazzPro.setFont(black);
		allPro.setFont(black);
		onlyDel.setFont(black);
		batchDel.setFont(black);
		lojItem.setFont(black);
		manageitem.setFont(black);
		onlyChange.setFont(black);
		batchChange.setFont(black);
		delmanage.setFont(black);
		delloj.setFont(black);
		Alldel      .setFont(black);
		delAllManage.setFont(black);
		delAllloj   .setFont(black);
		moremenuitem   .setFont(black);
		PPro   .setFont(black);


		//������
		addmenu.add(addPro);

		findmenu.add(onlyPro);
		findmenu.addSeparator();
		findmenu.add(clazzPro);
		findmenu.addSeparator();
		findmenu.add(PPro);
		findmenu.addSeparator();
		findmenu.add(allPro);

		delmenu.add(onlyDel);
		delmenu.addSeparator();
		delmenu.add(batchDel);
		delmenu.addSeparator();
		delmenu.add(Alldel);

		changemenu.add(onlyChange);
		changemenu.addSeparator();
		changemenu.add(batchChange);

		lojmenu.add(lojItem);
		lojmenu.addSeparator();
		lojmenu.add(delloj);
		lojmenu.addSeparator();
		lojmenu.add(delAllloj);

		managemenu.add(manageitem);
		managemenu.addSeparator();
		managemenu.add(delmanage);
		managemenu.addSeparator();
		managemenu.add(delAllManage);

		moremenu.add(moremenuitem);

		//��Ӳ˵��������Ĳ˵�����ȥ
		menubar.add(addmenu);
		menubar.add(delmenu);
		menubar.add(changemenu);
		menubar.add(findmenu);
		menubar.add(lojmenu);
		menubar.add(managemenu);
		menubar.add(moremenu);

		add(menubar, BorderLayout.NORTH);

		//���������panel��嵽�ı���������
		jp = new JPanel();
		jp.add(text);
		jp.setBackground(Color.LIGHT_GRAY);
		add(jp, BorderLayout.SOUTH);
		add(area,BorderLayout.CENTER);

		scpanel = new JPanel();

		JScrollPane scroll = new JScrollPane(area);//��area��ӹ���
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setWheelScrollingEnabled(true);
		scpanel.add(scroll);
		add(scpanel, BorderLayout.WEST);

	}



	//���������	

	//�����Ʒ
	public void addAction() { 
		addPro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				AddPro addpro = new AddPro();
			}
		});


		//��һ����
		onlyPro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String proName = JOptionPane.showInputDialog(area,"���ң������������");
				info = product.getProInfo(proName);
				area.setText(headText+line+"\n"+info);
			}
		});

		
		//���ղ��ز���
		PPro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String pproduce = JOptionPane.showInputDialog(area,"���ң�����������");
				List<String> allInfo = product.getproduceInfo(pproduce);
				String proInfo = "";
				for(String i:allInfo) {
					proInfo = proInfo+i;
				}
				area.setText(headText+line+"\n"+proInfo);
			}
		});
		

		//�鿴���
		allPro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				List<String> allInfo = product.getAllPro();
				String proInfo = "";
				for(String i:allInfo) {
					proInfo = proInfo+i;
				}
				area.setText(headText+line+"\n"+proInfo);
			}
		});


		//���Ͳ���
		clazzPro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String proClass = JOptionPane.showInputDialog(area,"���ң������������");
				List<String> allInfo = product.getAllInfo(proClass);
				String proInfo = "";
				for(String i:allInfo) {
					proInfo = proInfo+i;
				}
				area.setText(headText+line+"\n"+proInfo);
			}
		});


		//��һɾ��
		onlyDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String proName = JOptionPane.showInputDialog(area,"ɾ���������������");
				if(product.delPro(proName)) {
					JOptionPane.showMessageDialog(area, "ɾ���ɹ�!");
				}
			}
		});


		//����ɾ��
		batchDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String proClass = JOptionPane.showInputDialog(area,"ɾ���������������");
				if(product.delBatchPro(proClass)) {
					JOptionPane.showMessageDialog(area, "ɾ���ɹ�!");
				}else {
					JOptionPane.showMessageDialog(area, "��ȡ��ɾ��");
				}
			}
		});


		//ɾ�����л���
		Alldel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String PassWord2 = JOptionPane.showInputDialog(area, "������������룺");
				if (PassWord1.equals(PassWord2)) {
					int i = JOptionPane.showConfirmDialog(area, "�Ƿ�ȷ��������л���", "ȷ��ɾ����", JOptionPane.YES_NO_CANCEL_OPTION);
					if ( i == JOptionPane.YES_OPTION) {
						product.delAllPro();
						JOptionPane.showMessageDialog(area, "ɾ���ɹ�!");
					}else {
						JOptionPane.showMessageDialog(area, "ȡ��ɾ��!");
					}
				}else {
					JOptionPane.showMessageDialog(area, "��������δ�������룡"+"\n"+"��˶Ժ��ٴ����룡");
				}
			}

		});


		//��һ����
		onlyChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				AddPro addpro = new AddPro();
			}
		});


		//��������
		batchChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String oldClass = JOptionPane.showInputDialog(area,"����ԭ�����������");
				String newClass = JOptionPane.showInputDialog(area,"�����µĻ��������");
				if(product.changePro(newClass,oldClass)) {
					JOptionPane.showMessageDialog(area, "�޸ĳɹ�!");
				}
			}
		});



		//�鿴��־
		lojItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Loj loj = new Loj();
				String lojHead = "�û�����"+"\t"+"ʹ�����"+"\t"+"ʹ��ʱ��"+"\t"+line+"\n";
				List<String> allInfo = loj.getAllLoj();
				String lojInfo = "";
				for(String i:allInfo) {
					lojInfo = lojInfo+i;
				}
				area.setText(lojHead+lojInfo);
			}
		});


		//ɾ����־
		delloj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String PassWord2 = JOptionPane.showInputDialog(area, "������������룺");
				if (PassWord1.equals(PassWord2)) {
					Loj manage = new Loj();

					String name = JOptionPane.showInputDialog(area,"ɾ��������Ҫɾ���ļ�¼���û���");
					if(manage.delLoj(name)) {
						JOptionPane.showMessageDialog(area, "ɾ���ɹ�!");
					}
				}else {
					JOptionPane.showMessageDialog(area, "��������δ�������룡"+"\n"+"��˶Ժ��ٴ����룡");
				}
			}


		});


		//ɾ�����м�¼
		delAllloj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String PassWord2 = JOptionPane.showInputDialog(area, "������������룺");
				
				if (PassWord1.equals(PassWord2)) {

					int i = JOptionPane.showConfirmDialog(area, "�Ƿ�ȷ��ɾ�����е�¼��¼", "ȷ����գ�", JOptionPane.YES_NO_CANCEL_OPTION);
					Loj manage = new Loj();

					if ( i == JOptionPane.YES_OPTION) {
						manage.delAllLoj();
						JOptionPane.showMessageDialog(area, "ɾ���ɹ�!");
					}else {
						JOptionPane.showMessageDialog(area, "ȡ��ɾ��!");
					}
					
				}else {
					JOptionPane.showMessageDialog(area, "��������δ�������룡"+"\n"+"��˶Ժ��ٴ����룡");
				}
			}
		});


		//�鿴������Ա
		manageitem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Loj manage = new Loj();
				String manangeHead = "�û�����"+"\t"+line+"\n";
				List<String> allInfo =  manage.getmanageInfo();
				String manageInfo = "";
				for(String i:allInfo) {
					manageInfo = manageInfo+i;
				}
				area.setText(manangeHead+manageInfo);
			}
		});


		//ɾ��������Ա��Ϣ
		delmanage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String PassWord2 = JOptionPane.showInputDialog(area, "������������룺");
				if (PassWord1.equals(PassWord2)) {

					Loj manage = new Loj();

					String manageName = JOptionPane.showInputDialog(area,"ɾ��������Ҫɾ�����û���");
					if(manage.delmanageInfo(manageName)) {
						JOptionPane.showMessageDialog(area, "ɾ���ɹ�!");
					}else {
						JOptionPane.showMessageDialog(area, "ȡ��ɾ����");
					}
				}else {
					JOptionPane.showMessageDialog(area, "��������δ�������룡"+"\n"+"��˶Ժ��ٴ����룡");
				}
			}
		});

		//ɾ�����й�����Ա
		delAllManage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String PassWord2 = JOptionPane.showInputDialog(area, "������������룺");
				if (PassWord1.equals(PassWord2)) {

					Loj manage = new Loj();
					int i = JOptionPane.showConfirmDialog(area, "�Ƿ�ȷ��ɾ�����е�¼��¼", "ȷ����գ�", JOptionPane.YES_NO_CANCEL_OPTION);
					if ( i == JOptionPane.YES_OPTION) {
						manage.delAllManage();
						JOptionPane.showMessageDialog(area, "ɾ���ɹ�!");
					}else {
						JOptionPane.showMessageDialog(area, "ȡ��ɾ��!");
					}
				}else {
					JOptionPane.showMessageDialog(area, "��������δ�������룡"+"\n"+"��˶Ժ��ٴ����룡");
				}
			}
		});


		//���๦��
		moremenuitem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(area, "���๦�ܻ����з���......"+"\n"+"�����ڴ�......");

			}
		});

	}


	public Product_Management() {
		//�����ʼ��
		this.init();
		addAction();

		//����GUI���ڵı�־
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("icons/management.png");
		setIconImage(image);

		//����������Ĵ�С
		super.setSize( 650, 430);
		super.setLocation(600, 200);
		super.setResizable(false);
		setTitle("�ҹ��������ϵͳ");
		setVisible(true);
	}

}