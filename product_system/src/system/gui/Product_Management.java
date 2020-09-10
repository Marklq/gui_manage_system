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
	String headText ="货物ID"+"\t"+ "货物名称"+"\t"+"货物数目"+"\t"+"货物价格"+"\t"+"货物类型 "+"\t"+"货物产地"+"\t"+"进货时间";
	String line = "\n"+"-----------------------------------------------------"
			+ "----------------------------------------------------"+ 
			"---------------------------------------------";
	String info;
	String PassWord1 = "123456";

	public void init() { // 界面设置

		Font south = new Font("叶根友毛笔行书2.0版", Font.ITALIC, 20);
		Font black = new Font("黑体", Font.PLAIN, 15);

		text = new JLabel("欢  迎  使  用  灰  狗  货  物  管  理  系  统  ！  ！");
		area = new JTextArea();

		text.setFont(south);
		text.setForeground(Color.black);

		area.setEditable(false);//设置中间的area不可编辑
		area.setText(line);
		area.setRows(18);
		area.setColumns(55);

		menubar = new JMenuBar();

		//给菜单组件命名
		addmenu = new JMenu("增 加 货 物");
		findmenu = new JMenu("查 看 货 物");
		changemenu = new JMenu("更 改 货 物");
		delmenu = new JMenu("删 除 货 物");
		lojmenu = new JMenu("登 录 记 录");
		managemenu =  new JMenu("管 理 名 单");
		moremenu = new JMenu("更 多 ");

		//设置菜单组件样式
		//		addmenu.setBorder(BorderFactory.createRaisedBevelBorder());//凸起
		//		findmenu.setBorder(BorderFactory.createRaisedBevelBorder());
		//		delmenu.setBorder(BorderFactory.createRaisedBevelBorder());
		//		lojmenu.setBorder(BorderFactory.createRaisedBevelBorder());
		//		managemenu.setBorder(BorderFactory.createRaisedBevelBorder());
		//		changemenu.setBorder(BorderFactory.createRaisedBevelBorder());

		addmenu.setBorder(BorderFactory.createLoweredBevelBorder());//凹下
		findmenu.setBorder(BorderFactory.createLoweredBevelBorder());
		delmenu.setBorder(BorderFactory.createLoweredBevelBorder());
		findmenu   .setBorder(BorderFactory.createLoweredBevelBorder());
		lojmenu    .setBorder(BorderFactory.createLoweredBevelBorder());
		managemenu.setBorder(BorderFactory.createLoweredBevelBorder());
		changemenu.setBorder(BorderFactory.createLoweredBevelBorder());
		moremenu.setBorder(BorderFactory.createLoweredBevelBorder());

		//设置菜单组件的背景色
		addmenu.setBackground(Color.GRAY);
		findmenu  .setBackground(Color.GRAY);
		delmenu   .setBackground(Color.GRAY);
		findmenu  .setBackground(Color.GRAY);
		lojmenu   .setBackground(Color.GRAY);
		managemenu.setBackground(Color.GRAY);
		changemenu.setBackground(Color.GRAY);
		moremenu.setBackground(Color.GRAY);

		//鼠标移动到菜单按钮上的样式
		addmenu .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		findmenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delmenu .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		findmenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lojmenu .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		managemenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changemenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		moremenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


		//设置字体形式
		menubar.setFont(black);
		addmenu.setFont(black);
		findmenu.setFont(black);
		changemenu.setFont(black);
		delmenu.setFont(black);
		lojmenu.setFont(black);
		managemenu.setFont(black);
		moremenu.setFont(black);

		//给菜单子类组件命名
		addPro = new JMenuItem("增 加 货 物");
		onlyPro = new JMenuItem("单 一 查 找");
		clazzPro = new JMenuItem("类 型 查 找");
		allPro = new JMenuItem("查 看 库 存");
		PPro = new JMenuItem("产 地 查 找");
		onlyDel = new JMenuItem("单个货物删除");
		batchDel = new JMenuItem("货物类型删除");
		Alldel = new JMenuItem("清空货物库存");
		onlyChange = new JMenuItem("单 一 更 改");
		batchChange = new JMenuItem("更 改 类 型");
		lojItem = new JMenuItem("查 看 记 录");
		delloj = new JMenuItem("删 除 记 录");
		delAllloj = new JMenuItem("清 空 记 录");

		manageitem = new JMenuItem("查看用户名单");
		delmanage = new JMenuItem("删除单个用户");
		delAllManage = new JMenuItem("删除所有用户");

		moremenuitem = new JMenuItem("更多功能");


		//设置子类按钮的样式
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


		//设置子类按钮的背景色
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


		//设置鼠标移动按钮上的样式
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




		//设置字体形式
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


		//添加组件
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

		//添加菜单组件到大的菜单栏中去
		menubar.add(addmenu);
		menubar.add(delmenu);
		menubar.add(changemenu);
		menubar.add(findmenu);
		menubar.add(lojmenu);
		menubar.add(managemenu);
		menubar.add(moremenu);

		add(menubar, BorderLayout.NORTH);

		//创建并添加panel面板到文本域最下面
		jp = new JPanel();
		jp.add(text);
		jp.setBackground(Color.LIGHT_GRAY);
		add(jp, BorderLayout.SOUTH);
		add(area,BorderLayout.CENTER);

		scpanel = new JPanel();

		JScrollPane scroll = new JScrollPane(area);//给area添加滚条
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setWheelScrollingEnabled(true);
		scpanel.add(scroll);
		add(scpanel, BorderLayout.WEST);

	}



	//事物监听器	

	//添加商品
	public void addAction() { 
		addPro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				AddPro addpro = new AddPro();
			}
		});


		//单一查找
		onlyPro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String proName = JOptionPane.showInputDialog(area,"查找：输入货物名称");
				info = product.getProInfo(proName);
				area.setText(headText+line+"\n"+info);
			}
		});

		
		//按照产地查找
		PPro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String pproduce = JOptionPane.showInputDialog(area,"查找：输入货物产地");
				List<String> allInfo = product.getproduceInfo(pproduce);
				String proInfo = "";
				for(String i:allInfo) {
					proInfo = proInfo+i;
				}
				area.setText(headText+line+"\n"+proInfo);
			}
		});
		

		//查看库存
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


		//类型查找
		clazzPro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String proClass = JOptionPane.showInputDialog(area,"查找：输入货物类型");
				List<String> allInfo = product.getAllInfo(proClass);
				String proInfo = "";
				for(String i:allInfo) {
					proInfo = proInfo+i;
				}
				area.setText(headText+line+"\n"+proInfo);
			}
		});


		//单一删除
		onlyDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String proName = JOptionPane.showInputDialog(area,"删除：输入货物名称");
				if(product.delPro(proName)) {
					JOptionPane.showMessageDialog(area, "删除成功!");
				}
			}
		});


		//类型删除
		batchDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String proClass = JOptionPane.showInputDialog(area,"删除：输入货物类型");
				if(product.delBatchPro(proClass)) {
					JOptionPane.showMessageDialog(area, "删除成功!");
				}else {
					JOptionPane.showMessageDialog(area, "已取消删除");
				}
			}
		});


		//删除所有货物
		Alldel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String PassWord2 = JOptionPane.showInputDialog(area, "请输入管理密码：");
				if (PassWord1.equals(PassWord2)) {
					int i = JOptionPane.showConfirmDialog(area, "是否确认清空所有货物", "确认删除？", JOptionPane.YES_NO_CANCEL_OPTION);
					if ( i == JOptionPane.YES_OPTION) {
						product.delAllPro();
						JOptionPane.showMessageDialog(area, "删除成功!");
					}else {
						JOptionPane.showMessageDialog(area, "取消删除!");
					}
				}else {
					JOptionPane.showMessageDialog(area, "密码错误或未输入密码！"+"\n"+"请核对后再次输入！");
				}
			}

		});


		//单一更改
		onlyChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				AddPro addpro = new AddPro();
			}
		});


		//批量更改
		batchChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String oldClass = JOptionPane.showInputDialog(area,"输入原来货物的类型");
				String newClass = JOptionPane.showInputDialog(area,"输入新的货物的类型");
				if(product.changePro(newClass,oldClass)) {
					JOptionPane.showMessageDialog(area, "修改成功!");
				}
			}
		});



		//查看日志
		lojItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Loj loj = new Loj();
				String lojHead = "用户名单"+"\t"+"使用情况"+"\t"+"使用时间"+"\t"+line+"\n";
				List<String> allInfo = loj.getAllLoj();
				String lojInfo = "";
				for(String i:allInfo) {
					lojInfo = lojInfo+i;
				}
				area.setText(lojHead+lojInfo);
			}
		});


		//删除日志
		delloj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String PassWord2 = JOptionPane.showInputDialog(area, "请输入管理密码：");
				if (PassWord1.equals(PassWord2)) {
					Loj manage = new Loj();

					String name = JOptionPane.showInputDialog(area,"删除：输入要删除的记录的用户名");
					if(manage.delLoj(name)) {
						JOptionPane.showMessageDialog(area, "删除成功!");
					}
				}else {
					JOptionPane.showMessageDialog(area, "密码错误或未输入密码！"+"\n"+"请核对后再次输入！");
				}
			}


		});


		//删除所有记录
		delAllloj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String PassWord2 = JOptionPane.showInputDialog(area, "请输入管理密码：");
				
				if (PassWord1.equals(PassWord2)) {

					int i = JOptionPane.showConfirmDialog(area, "是否确认删除所有登录记录", "确认清空？", JOptionPane.YES_NO_CANCEL_OPTION);
					Loj manage = new Loj();

					if ( i == JOptionPane.YES_OPTION) {
						manage.delAllLoj();
						JOptionPane.showMessageDialog(area, "删除成功!");
					}else {
						JOptionPane.showMessageDialog(area, "取消删除!");
					}
					
				}else {
					JOptionPane.showMessageDialog(area, "密码错误或未输入密码！"+"\n"+"请核对后再次输入！");
				}
			}
		});


		//查看管理人员
		manageitem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Loj manage = new Loj();
				String manangeHead = "用户名单"+"\t"+line+"\n";
				List<String> allInfo =  manage.getmanageInfo();
				String manageInfo = "";
				for(String i:allInfo) {
					manageInfo = manageInfo+i;
				}
				area.setText(manangeHead+manageInfo);
			}
		});


		//删除管理人员信息
		delmanage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String PassWord2 = JOptionPane.showInputDialog(area, "请输入管理密码：");
				if (PassWord1.equals(PassWord2)) {

					Loj manage = new Loj();

					String manageName = JOptionPane.showInputDialog(area,"删除：输入要删除的用户名");
					if(manage.delmanageInfo(manageName)) {
						JOptionPane.showMessageDialog(area, "删除成功!");
					}else {
						JOptionPane.showMessageDialog(area, "取消删除！");
					}
				}else {
					JOptionPane.showMessageDialog(area, "密码错误或未输入密码！"+"\n"+"请核对后再次输入！");
				}
			}
		});

		//删除所有管理人员
		delAllManage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String PassWord2 = JOptionPane.showInputDialog(area, "请输入管理密码：");
				if (PassWord1.equals(PassWord2)) {

					Loj manage = new Loj();
					int i = JOptionPane.showConfirmDialog(area, "是否确认删除所有登录记录", "确认清空？", JOptionPane.YES_NO_CANCEL_OPTION);
					if ( i == JOptionPane.YES_OPTION) {
						manage.delAllManage();
						JOptionPane.showMessageDialog(area, "删除成功!");
					}else {
						JOptionPane.showMessageDialog(area, "取消删除!");
					}
				}else {
					JOptionPane.showMessageDialog(area, "密码错误或未输入密码！"+"\n"+"请核对后再次输入！");
				}
			}
		});


		//更多功能
		moremenuitem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(area, "更多功能还在研发中......"+"\n"+"敬请期待......");

			}
		});

	}


	public Product_Management() {
		//界面初始化
		this.init();
		addAction();

		//更改GUI窗口的标志
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("icons/management.png");
		setIconImage(image);

		//设置主窗体的大小
		super.setSize( 650, 430);
		super.setLocation(600, 200);
		super.setResizable(false);
		setTitle("灰狗货物管理系统");
		setVisible(true);
	}

}