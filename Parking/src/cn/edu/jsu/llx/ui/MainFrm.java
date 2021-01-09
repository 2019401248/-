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

	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private JTextField txtKey;//������ҹؼ����ı���
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;//����������
	private ArrayList<RowSorter.SortKey> sortKeys;//�����������
	
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
	 *///String[] titles = { "��λ", "״̬", "����","����","�绰","����ʱ��","����ʱ��"};
	public MainFrm() {
		setTitle("\u505C\u8F66\u573A\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô���رհ�ť
		setBounds(100, 100, 1049, 403);// ���ô���λ�����С
		contentPane = new JPanel();// ʵ�����������
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(44, 82, 940, 210);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		Vector<String> titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "��λ", "״̬", "����","����","�绰","����ʱ��","����ʱ��");
		Vector<Vector> posInfo = new PageController().getPaegData();//��ȡ��һҳ������

//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		//model = new DefaultTableModel(); 
		model = new DefaultTableModel(posInfo, titles) ;
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		sorter = new TableRowSorter<DefaultTableModel>(model);//����������
		table.setAutoCreateRowSorter(true);;//���ñ���Զ�����
   
		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
		JButton btnPre = new JButton("��һҳ");
		btnPre.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController().prePage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
				
			}
		});
		btnPre.setBounds(44, 302, 95, 25);
		contentPane.add(btnPre);
		
		JButton btnNext = new JButton("��һҳ");
		btnNext.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController().nextPage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
			}
		});
		btnNext.setBounds(149, 302, 95, 25);
		contentPane.add(btnNext);
		
		JLabel lblMsg = new JLabel("ÿҳ��ʾ��");
		lblMsg.setBounds(254, 307, 87, 15);
		contentPane.add(lblMsg);
		
		JComboBox comboBox = new JComboBox(new Integer[] {3,5,10,15,20});
		comboBox.addItemListener(new ItemListener() {//ҳ��������ѡ��ı��¼�
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//��ȡ��������ѡ��ֵ
				PageController pcl=new PageController();
				pcl.setCountPerpage(pageSize);//����ÿҳ��ʾ��¼����
				model=new DefaultTableModel(pcl.getPaegData(),titles);//��������ģ��
				table.setModel(model);//���ñ������ģ��
			}
		});
		comboBox.setSelectedIndex(1);//����������Ĭ��ֵ
		comboBox.setBounds(318, 303, 55, 23);
		contentPane.add(comboBox);
		txtcp = new JTextField();
		txtcp.setBounds(443, 51, 107, 21);
		contentPane.add(txtcp);
		txtcp.setColumns(10);
		
		JButton btncz = new JButton("\u67E5\u627E");
		btncz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=txtcp.getText().trim();//��ȡ����ؼ����ı����ֵ
				//System.out.println("ok");
				if(key.length()!=0) {
					model = new DefaultTableModel(PageController.getBigList(), titles) ;
					sorter = new TableRowSorter<DefaultTableModel>(model);//����������
					sorter.setRowFilter(RowFilter.regexFilter(key));//�Ƿ����������ֵ
					table.setModel(model);
					table.setRowSorter(sorter);
				}else {
					sorter.setRowFilter(null);//�����ˣ���ʾ��������
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

