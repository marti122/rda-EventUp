package servisnaLista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;

public class GUIservisna_lista {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIservisna_lista window = new GUIservisna_lista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIservisna_lista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 661, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(189, 183, 107));
		panel.setBounds(0, 0, 645, 469);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Serijski broj:");
		lblNewLabel.setBounds(10, 44, 114, 14);
		panel.add(lblNewLabel);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(10, 69, 114, 14);
		panel.add(lblModel);
		
		JLabel lblUlica = new JLabel("Ulica i broj:");
		lblUlica.setBounds(10, 94, 114, 14);
		panel.add(lblUlica);
		
		JLabel lblGrad = new JLabel("Grad:");
		lblGrad.setBounds(10, 119, 114, 14);
		panel.add(lblGrad);
		
		JLabel lblNewLabel_1 = new JLabel("GSM vlasnika:");
		lblNewLabel_1.setBounds(10, 144, 114, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Servisiranje solarnih panela");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 11, 478, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("UNOS");
		btnNewButton.setBounds(10, 208, 100, 23);
		panel.add(btnNewButton);
		
		JButton btnIzmjena = new JButton("IZMJENA");
		btnIzmjena.setBounds(132, 208, 100, 23);
		panel.add(btnIzmjena);
		
		JButton btnBrisanje = new JButton("BRISANJE");
		btnBrisanje.setBounds(10, 242, 100, 23);
		panel.add(btnBrisanje);
		
		JButton btnOisti = new JButton("O\u010CISTI");
		btnOisti.setBounds(132, 242, 100, 23);
		panel.add(btnOisti);
		
		textField = new JTextField();
		textField.setBounds(90, 44, 135, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(90, 69, 135, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(90, 94, 135, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(90, 119, 135, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(90, 144, 135, 20);
		panel.add(textField_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(242, 13, 393, 252);
		panel.add(scrollPane);
		
		table = new JTable();
		model=new DefaultTableModel();
		Object[]column= {"Serijski broj","Model","Ulica i broj","Grad","GSM Vlasnika"};
		Object[]row=new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
}
