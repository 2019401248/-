package cn.edu.jsu.llx.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.llx.util.AdmOperate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtzh;
	private JTextField txtmm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblzh = new JLabel("\u8D26\u53F7");
		lblzh.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lblzh.setBounds(93, 331, 58, 15);
		contentPane.add(lblzh);
		
		txtzh = new JTextField();
		txtzh.setBounds(171, 330, 143, 21);
		contentPane.add(txtzh);
		txtzh.setColumns(10);
		
		JLabel lblmm = new JLabel("\u5BC6\u7801");
		lblmm.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lblmm.setBounds(93, 368, 58, 15);
		contentPane.add(lblmm);
		
		txtmm = new JTextField();
		txtmm.setColumns(10);
		txtmm.setBounds(171, 367, 143, 21);
		contentPane.add(txtmm);
		
		JButton btndl = new JButton("\u767B\u5F55");
		btndl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AdmOperate.inter(txtzh.getText().trim(), txtmm.getText().trim()))
				{
					MainFrm frame = new MainFrm();
					frame.setVisible(true);
					setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
			}
		});
		btndl.setBounds(64, 404, 97, 23);
		contentPane.add(btndl);
		
		JButton btnzc = new JButton("\u6CE8\u518C");
		btnzc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register rg=new Register();
				rg.setVisible(true);
				setVisible(false);
			}
		});
		btnzc.setBounds(268, 404, 97, 23);
		contentPane.add(btnzc);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/cn/edu/jsu/llx/ui/1.jpg")));
		lblNewLabel.setBounds(10, 0, 565, 303);
		contentPane.add(lblNewLabel);
	}

}
