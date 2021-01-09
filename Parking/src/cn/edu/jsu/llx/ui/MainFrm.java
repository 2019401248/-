package cn.edu.jsu.llx.ui;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.edu.jsu.llx.dao.Possql;
import cn.edu.jsu.llx.util.PageController;
import cn.edu.jsu.llx.util.PosOpeate;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;



public class MainFrm extends JFrame {

	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private JTextField txtKey;//定义查找关键字文本框
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
	
	private Vector<String> titles;
	private JTextField txtcp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *///String[] titles = { "车位", "状态", "车牌","名字","电话","进场时间","出场时间"};
	public MainFrm() {
		setTitle("\u505C\u8F66\u573A\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭按钮
		setBounds(100, 100, 1049, 403);// 设置窗体位置与大小
		contentPane = new JPanel();// 实例化内容面板
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);// 将窗体默认面板

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(44, 82, 940, 210);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		// 使用动态数组数据（列标题与行数据）
		Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "车位", "状态", "车牌","名字","电话","进场时间","出场时间");
		Vector<Vector> posInfo = new PageController().getPaegData();//获取第一页的数据

//		使用静态数据创建DefaultTableModel数据模型
		//model = new DefaultTableModel(); 
		model = new DefaultTableModel(posInfo, titles) ;
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
		table.setAutoCreateRowSorter(true);;//设置表格自动排序
   
		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
		JButton btnPre = new JButton("上一页");
		btnPre.addActionListener(new ActionListener() {//上一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController().prePage(),titles);//设置数据模型中的数据为上一页内容
				table.setModel(model);//设置表格的数据模型
				
			}
		});
		btnPre.setBounds(44, 302, 95, 25);
		contentPane.add(btnPre);
		
		JButton btnNext = new JButton("下一页");
		btnNext.addActionListener(new ActionListener() {//下一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController().nextPage(),titles);//设置数据模型中的数据为下一页内容
				table.setModel(model);//设置表格的数据模型
			}
		});
		btnNext.setBounds(149, 302, 95, 25);
		contentPane.add(btnNext);
		
		JLabel lblMsg = new JLabel("每页显示：");
		lblMsg.setBounds(254, 307, 87, 15);
		contentPane.add(lblMsg);
		
		JComboBox comboBox = new JComboBox(new Integer[] {3,5,10,15,20});
		comboBox.addItemListener(new ItemListener() {//页数下拉框选择改变事件
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//获取下拉框所选的值
				PageController pcl=new PageController();
				pcl.setCountPerpage(pageSize);//设置每页显示记录条数
				model=new DefaultTableModel(pcl.getPaegData(),titles);//设置数据模型
				table.setModel(model);//设置表格数据模型
			}
		});
		comboBox.setSelectedIndex(1);//设置下拉框默认值
		comboBox.setBounds(318, 303, 55, 23);
		contentPane.add(comboBox);
		txtcp = new JTextField();
		txtcp.setBounds(443, 51, 107, 21);
		contentPane.add(txtcp);
		txtcp.setColumns(10);
		
		JButton btncz = new JButton("\u67E5\u627E");
		btncz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=txtcp.getText().trim();//获取输入关键字文本框的值
				//System.out.println("ok");
				if(key.length()!=0) {
					model = new DefaultTableModel(PageController.getBigList(), titles) ;
					sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
					sorter.setRowFilter(RowFilter.regexFilter(key));//是否包含输入框的值
					table.setModel(model);
					table.setRowSorter(sorter);
				}else {
					sorter.setRowFilter(null);//不过滤，显示所有数据
				}
			}
		});
		btncz.setBounds(593, 49, 97, 23);
		contentPane.add(btncz);
		
		JLabel lblcp = new JLabel("\u8BF7\u8F93\u5165\u5173\u952E\u5B57");
		lblcp.setBounds(283, 54, 90, 15);
		contentPane.add(lblcp);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 454, 23);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u8F66\u8F86\u7BA1\u7406");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u8F66\u8F86\u51FA\u573A");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Outcar dialog = new Outcar();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u8F66\u8F86\u8FDB\u573A");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Incar dialog = new Incar();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("\u8F66\u4F4D\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u589E\u52A0\u8F66\u4F4D");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addpos dialog = new Addpos();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true); 
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5220\u9664\u8F66\u4F4D");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deletepos dialog = new Deletepos();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("\u529F\u80FD");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u6E05\u7A7A\u505C\u8F66\u573A");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Possql.clear();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(0, 0, 1035, 379);
		contentPane.add(lblNewLabel);
		

	}
  }

