package cn.edu.jsu.llx.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.llx.dao.Admsql;
import cn.edu.jsu.llx.dao.Possql;
import cn.edu.jsu.llx.util.PosOpeate;
import cn.edu.jsu.llx.vo.Pos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Outcar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcp;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Outcar dialog = new Outcar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Outcar() {
		setTitle("\u8F66\u8F86\u51FA\u573A");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8F66\u724C\u53F7");
			lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
			lblNewLabel.setBounds(170, 118, 112, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			txtcp = new JTextField();
			txtcp.setBounds(286, 117, 97, 21);
			contentPanel.add(txtcp);
			txtcp.setColumns(10);
		}
		{
			String titles[]={"小型车","中型车","大型车"};
			 comboBox = new JComboBox(titles);
			

			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			comboBox.setBounds(286, 166, 95, 23);
			contentPanel.add(comboBox);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u8F66\u578B");
			lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
			lblNewLabel_1.setBounds(203, 166, 58, 19);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(Outcar.class.getResource("/cn/edu/jsu/llx/ui/MYH~~3K_P5SW1){_YW_~5RJ.JPG")));
			lblNewLabel_2.setBounds(0, 10, 436, 253);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String time="";
						long money= PosOpeate.fee(Possql.seachtime(txtcp.getText()),comboBox.getSelectedItem().toString(),time);
						JOptionPane.showMessageDialog(null, "共停留"+time+"需支付"+money);
						Possql.deleteuser(txtcp.getText());
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
