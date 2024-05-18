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
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class DlgNoviIzvodac extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Sifra_izvodaca;
	private JTextField textField_Ime_izvodaca;
	private JTextField textField_Prezime_izvodaca;
	private JTextField textField_UmjetnickoIme_izvodaca;
	private JTextField textField_Kontakt_izvodaca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgNoviIzvodac dialog = new DlgNoviIzvodac();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgNoviIzvodac() {
		setTitle("Novi izvođač");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSifra_izvodaca = new JLabel("Šifra izvođača:");
			lblSifra_izvodaca.setBounds(21, 60, 92, 25);
			contentPanel.add(lblSifra_izvodaca);
		}
		{
			JLabel lblIme_izvodaca = new JLabel("Ime izvođača:");
			lblIme_izvodaca.setBounds(21, 95, 92, 13);
			contentPanel.add(lblIme_izvodaca);
		}
		{
			JLabel lblTekst = new JLabel("Molimo vas da ispunite sva polja!");
			lblTekst.setVerticalAlignment(SwingConstants.TOP);
			lblTekst.setBounds(21, 25, 220, 25);
			contentPanel.add(lblTekst);
		}
		{
			JLabel lblPrezime_izvodaca = new JLabel("Prezime izvođača:");
			lblPrezime_izvodaca.setBounds(21, 126, 92, 13);
			contentPanel.add(lblPrezime_izvodaca);
		}
		{
			JLabel lblUmjetnickoIme_izvodaca = new JLabel("Umjetničko ime:");
			lblUmjetnickoIme_izvodaca.setBounds(21, 156, 92, 13);
			contentPanel.add(lblUmjetnickoIme_izvodaca);
		}
		{
			JLabel lblKontakt_izvodaca = new JLabel("Kontakt izvođača:");
			lblKontakt_izvodaca.setBounds(21, 186, 80, 13);
			contentPanel.add(lblKontakt_izvodaca);
		}
		{
			textField_Sifra_izvodaca = new JTextField();
			textField_Sifra_izvodaca.setBounds(147, 63, 172, 19);
			contentPanel.add(textField_Sifra_izvodaca);
			textField_Sifra_izvodaca.setColumns(10);
		}
		{
			textField_Ime_izvodaca = new JTextField();
			textField_Ime_izvodaca.setBounds(147, 92, 172, 19);
			contentPanel.add(textField_Ime_izvodaca);
			textField_Ime_izvodaca.setColumns(10);
		}
		{
			textField_Prezime_izvodaca = new JTextField();
			textField_Prezime_izvodaca.setBounds(147, 123, 172, 19);
			contentPanel.add(textField_Prezime_izvodaca);
			textField_Prezime_izvodaca.setColumns(10);
		}
		{
			textField_UmjetnickoIme_izvodaca = new JTextField();
			textField_UmjetnickoIme_izvodaca.setBounds(147, 153, 172, 19);
			contentPanel.add(textField_UmjetnickoIme_izvodaca);
			textField_UmjetnickoIme_izvodaca.setColumns(10);
		}
		{
			textField_Kontakt_izvodaca = new JTextField();
			textField_Kontakt_izvodaca.setBounds(147, 183, 172, 19);
			contentPanel.add(textField_Kontakt_izvodaca);
			textField_Kontakt_izvodaca.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String Sifra_izvodaca = textField_Sifra_izvodaca.getText();
						String Ime_izvodaca = textField_Ime_izvodaca.getText();
						String Prezime_izvodaca = textField_Prezime_izvodaca.getText();  
						String UmjetnickoIme_izvodaca = textField_UmjetnickoIme_izvodaca.getText();
						String Kontakt_izvodaca = textField_Kontakt_izvodaca.getText();
						
						if (Sifra_izvodaca.equals("")||Ime_izvodaca.equals("")||Prezime_izvodaca.equals("")||Kontakt_izvodaca.equals("")) {
							JOptionPane.showMessageDialog(null,  "Sva polja moraju biti popunjena", "Greška", JOptionPane.WARNING_MESSAGE);
							return; 
		
						}
						
						try {						
						 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							  Connection conn = DriverManager.getConnection 
				("jdbc:mysql://ucka.veleri.hr/mroncevic?" +
				 "user=mroncevic&password=11");
							  //Sifra_izvodaca, Ime_izvodaca, Prezime_izvodaca, UmjetnickoIme_izvodaca, Kontakt_izvodaca
							 //String sql = "INSERT INTO Izvodac (Sifra_izvodaca, Ime_izvodaca, Prezime_izvodaca,UmjetnickoIme_izvodaca,Kontakt_izvodaca) VALUES(36925814,'Taylor','Swift','Taylor Swift',0998745665);";
							  String sql = "INSERT INTO Izvodac (Sifra_izvodaca, Ime_izvodaca, Prezime_izvodaca,UmjetnickoIme_izvodaca,Kontakt_izvodaca) VALUES(?,?,?,?,?);";
							  PreparedStatement stmt = conn.prepareStatement(sql);
							  stmt.setString(1, Sifra_izvodaca);
							  stmt.setString(2, Ime_izvodaca);
							  stmt.setString(3, Prezime_izvodaca);
							  stmt.setString(4, UmjetnickoIme_izvodaca);
							  stmt.setString(5, Kontakt_izvodaca);
				  			  stmt.execute();
											
							  conn.close();
										
							  textField_Sifra_izvodaca.setText("");
							  textField_Ime_izvodaca.setText("");
							  textField_Prezime_izvodaca.setText("");
							  textField_UmjetnickoIme_izvodaca.setText("");
							  textField_Kontakt_izvodaca.setText("");
							  
											
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
