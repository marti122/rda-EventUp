package eventUpProjekt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DlgNoviNastup extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_SifraNastupa;
	private JTextField textField_DatumNastupa;
	private JTextField textField_MjestoNastupa;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgNoviNastup dialog = new DlgNoviNastup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DlgNoviNastup() {
		setTitle("Novi nastup");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSifraNastupa = new JLabel("Šifra nastupa:");
			lblSifraNastupa.setBounds(27, 35, 90, 13);
			contentPanel.add(lblSifraNastupa);
		}
		{
			textField_SifraNastupa = new JTextField();
			textField_SifraNastupa.setBounds(159, 32, 175, 19);
			contentPanel.add(textField_SifraNastupa);
			textField_SifraNastupa.setColumns(10);
		}
		{
			JLabel lblDatumNastupa = new JLabel("Datum nastupa:");
			lblDatumNastupa.setBounds(27, 83, 102, 13);
			contentPanel.add(lblDatumNastupa);
		}
		{
			textField_DatumNastupa = new JTextField();
			textField_DatumNastupa.setBounds(159, 80, 175, 19);
			contentPanel.add(textField_DatumNastupa);
			textField_DatumNastupa.setColumns(10);
		}
		{
			JLabel lblMjestoNastupa = new JLabel("Mjesto nastupa:");
			lblMjestoNastupa.setBounds(27, 131, 114, 13);
			contentPanel.add(lblMjestoNastupa);
		}
		{
			textField_MjestoNastupa = new JTextField();
			textField_MjestoNastupa.setBounds(159, 128, 175, 19);
			contentPanel.add(textField_MjestoNastupa);
			textField_MjestoNastupa.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String SifraNastupa = textField_SifraNastupa.getText();
						String DatumNastupa = textField_DatumNastupa.getText();
						String MjestoNastupa = textField_MjestoNastupa.getText();
						
						if (SifraNastupa.equals("")||DatumNastupa.equals("")||MjestoNastupa.equals("")) {
							JOptionPane.showMessageDialog(null,  "Sva polja moraju biti popunjena", "Greška", JOptionPane.WARNING_MESSAGE);
							return; 
		
						}
						
						try {						
						 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							  Connection conn = DriverManager.getConnection 
				("jdbc:mysql://ucka.veleri.hr/mroncevic?" +
				 "user=mroncevic&password=11");
							  //Sifra_nastupa, Datum_nastupa, Mjesto_nastupa
							 //String sql = "INSERT INTO Nastup (Sifra_nastupa, Datum_nastupa, Mjesto_nastupa) VALUES(60606060,28/06/2024,'Opatija');";
							  String sql = "INSERT INTO Nastup (Sifra_nastupa, Datum_nastupa, Mjesto_nastupa) VALUES(?,?,?);";
							  PreparedStatement stmt = conn.prepareStatement(sql);
							  stmt.setString(1, SifraNastupa); 
							  stmt.setString(2, DatumNastupa);
							  stmt.setString(3, MjestoNastupa);
							
				  			  stmt.execute();
											
							  conn.close();
										
							  textField_SifraNastupa.setText("");
							  textField_DatumNastupa.setText("");
							  textField_MjestoNastupa.setText("");
							  
											
							} catch(Exception ex) {
							  JOptionPane.showMessageDialog(null, 
				   ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
							}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
			}
		}
	}
}
