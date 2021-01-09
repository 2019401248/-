package cn.edu.jsu.llx.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.llx.dao.Admsql;
import cn.edu.jsu.llx.util.AdmOperate;
import cn.edu.jsu.llx.vo.Administrators;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtzh;
	private JTextField txtmm1;
	private JTextField txtmm2;
	private JLabel lblMsgmm;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setTitle("\u6CE8\u518C\u4E2D\u5FC3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblzh = new JLabel("\u8D26\u53F7");
		lblzh.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lblzh.setBounds(36, 100, 66, 23);
		contentPane.add(lblzh);
		
		txtzh = new JTextField();
		txtzh.setBounds(133, 101, 95, 21);
		contentPane.add(txtzh);
		txtzh.setColumns(10);
		
		JLabel lblzh_1 = new JLabel("\u5BC6\u7801");
		lblzh_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lblzh_1.setBounds(36, 156, 66, 23);
		contentPane.add(lblzh_1);
		
		txtmm1 = new JTextField();
		txtmm1.setColumns(10);
		txtmm1.setBounds(133, 159, 95, 21);
		contentPane.add(txtmm1);
		
		txtmm2 = new JTextField();
		txtmm2.setColumns(10);
		txtmm2.setBounds(133, 200, 95, 21);
		contentPane.add(txtmm2);
		
		JLabel lblzh_1_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblzh_1_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lblzh_1_1.setBounds(36, 203, 66, 23);
		contentPane.add(lblzh_1_1);
		
		 lblMsgmm = new JLabel("");
		lblMsgmm.setForeground(Color.RED);
		lblMsgmm.setBounds(254, 200, 96, 21);
		contentPane.add(lblMsgmm);
		
		JButton btnqr = new JButton("\u786E\u8BA4");
		btnqr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(confirmmm())
				{
					String stu=txtzh.getText()+"\t"+txtmm1.getText()+"\r\n";
					if(AdmOperate.addAdm(stu, txtmm1.getText()))
					{
						Admsql.insertAdm(txtzh.getText(), txtmm1.getText());
						JOptionPane.showMessageDialog(null, "◊¢≤·≥…π¶");
						
					} 
					 else
						  JOptionPane.showMessageDialog(null, "∏√√‹¬Î“—¥Ê‘⁄,«Î÷ÿ–¬…Ë÷√√‹¬Î");  
				}
			}
		});
		btnqr.setBounds(65, 231, 97, 23);
		contentPane.add(btnqr);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/cn/edu/jsu/llx/ui/1.jpg")));
		lblNewLabel.setBounds(10, 0, 494, 263);
		contentPane.add(lblNewLabel);
	}

     public boolean  confirmmm() {
    	 if(txtmm1.getText().equals(txtmm2.getText())) 
    	  return true;
			lblMsgmm.setText("«Î ‰»Îœ‡Õ¨√‹¬Î");
			txtmm2.requestFocus();
			txtmm1.selectAll();
    	 return false;
     }
}
