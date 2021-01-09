package cn.edu.jsu.llx.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.llx.dao.Possql;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Incar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcar;
	private JTextField txtname;
	private JTextField txtphone;
	private JTextField txtintime;
	private JTextField txtpos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Incar dialog = new Incar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Incar() {
		setTitle("\u8F66\u8F86\u5165\u573A");
		setBounds(100, 100, 542, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblcar = new JLabel("\u8F66\u724C\u53F7");
			lblcar.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
			lblcar.setBounds(28, 42, 67, 15);
			contentPanel.add(lblcar);
		}
		{
			txtcar = new JTextField();
			txtcar.setBounds(118, 39, 105, 21);
			contentPanel.add(txtcar);
			txtcar.setColumns(10);
		}
		{
			JLabel lblname = new JLabel("\u8F66\u4E3B");
			lblname.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
			lblname.setBounds(28, 81, 67, 15);
			contentPanel.add(lblname);
		}
		{
			JLabel lblNewLabel = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
			lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
			lblNewLabel.setBounds(266, 42, 67, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("\u8FDB\u573A\u65F6\u95F4");
			lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
			lblNewLabel.setBounds(266, 81, 67, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			txtname = new JTextField();
			txtname.setColumns(10);
			txtname.setBounds(118, 78, 105, 21);
			contentPanel.add(txtname);
		}
		{
			txtphone = new JTextField();
			txtphone.setColumns(10);
			txtphone.setBounds(342, 41, 105, 21);
			contentPanel.add(txtphone);
		}
		{
			txtintime = new JTextField();
			txtintime.setColumns(10);
			txtintime.setBounds(342, 80, 105, 21);
			contentPanel.add(txtintime);
		}
		{
			JLabel lblpos = new JLabel("\u8F66\u4F4D");
			lblpos.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
			lblpos.setBounds(266, 126, 67, 15);
			contentPanel.add(lblpos);
		}
		{
			txtpos = new JTextField();
			txtpos.setColumns(10);
			txtpos.setBounds(342, 125, 105, 21);
			contentPanel.add(txtpos);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon(Incar.class.getResource("/cn/edu/jsu/llx/ui/749QBWORT_{6E`UCXVP%I79.JPG")));
			lblNewLabel_2.setBounds(0, 0, 528, 270);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u8FDB\u573A");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Possql.insert(Integer.parseInt(txtpos.getText()), txtcar.getText(), txtname.getText(), txtphone.getText(), txtintime.getText());
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
