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

public class DlgNoviOrganizator extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_SifraOrganizatora;
	private JTextField textField_NazivOrganizatora;
	private JTextField textField_KontaktOrganizatora;
	private JTextField textField_LokacijaOrganizatora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgNoviOrganizator dialog = new DlgNoviOrganizator();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DlgNoviOrganizator() {
		setTitle("Novi organizator");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblUputa = new JLabel("Molimo vas da ispunite sva polja!");
			lblUputa.setBounds(20, 10, 161, 13);
			contentPanel.add(lblUputa);
		}
		{
			JLabel lblSifraOrganizatora = new JLabel("Šifra organizatora:");
			lblSifraOrganizatora.setBounds(20, 49, 107, 13);
			contentPanel.add(lblSifraOrganizatora);
		}
		{
			textField_SifraOrganizatora = new JTextField();
			textField_SifraOrganizatora.setBounds(137, 46, 174, 19);
			contentPanel.add(textField_SifraOrganizatora);
			textField_SifraOrganizatora.setColumns(10);
		}
		{
			JLabel lblNazivOrganizatora = new JLabel("Naziv organizatora:");
			lblNazivOrganizatora.setBounds(20, 89, 89, 13);
			contentPanel.add(lblNazivOrganizatora);
		}
		{
			textField_NazivOrganizatora = new JTextField();
			textField_NazivOrganizatora.setBounds(137, 86, 174, 19);
			contentPanel.add(textField_NazivOrganizatora);
			textField_NazivOrganizatora.setColumns(10);
		}
		{
			JLabel lblKontaktOrganizatora = new JLabel("Kontakt organizatora:");
			lblKontaktOrganizatora.setBounds(20, 127, 107, 13);
			contentPanel.add(lblKontaktOrganizatora);
		}
		{
			textField_KontaktOrganizatora = new JTextField();
			textField_KontaktOrganizatora.setBounds(137, 124, 174, 19);
			contentPanel.add(textField_KontaktOrganizatora);
			textField_KontaktOrganizatora.setColumns(10);
		}
		{
			JLabel lblLokacijaOrganizatora = new JLabel("Lokacija organizatora:");
			lblLokacijaOrganizatora.setBounds(20, 165, 102, 13);
			contentPanel.add(lblLokacijaOrganizatora);
		}
		{
			textField_LokacijaOrganizatora = new JTextField();
			textField_LokacijaOrganizatora.setBounds(137, 162, 174, 19);
			contentPanel.add(textField_LokacijaOrganizatora);
			textField_LokacijaOrganizatora.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String SifraOrganizatora = textField_SifraOrganizatora.getText();
						String NazivOrganizatora = textField_NazivOrganizatora.getText();
						String KontaktOrganizatora = textField_KontaktOrganizatora.getText();
						String LokacijaOrganizatora = textField_LokacijaOrganizatora.getText();
						
						if (SifraOrganizatora.equals("")||NazivOrganizatora.equals("")||KontaktOrganizatora.equals("")||LokacijaOrganizatora.equals("")) {
							JOptionPane.showMessageDialog(null,  "Sva polja moraju biti popunjena", "Greška", JOptionPane.WARNING_MESSAGE);
							return; 
		
						}
						
						try {						
						 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							  Connection conn = DriverManager.getConnection 
				("jdbc:mysql://ucka.veleri.hr/mroncevic?" +
				 "user=mroncevic&password=11");
							  //Sifra_organizatora, Naziv_organizatora, Kontakt_organizatora, Lokacija_organizatora
							 //String sql = "INSERT INTO Organizator (Sifra_organizatora, Naziv_organizatora, Kontakt_organizatora, Lokacija_organizatora) VALUES(54321876,'TZ Opatija',098898909,'Opatija');";
							  String sql = "INSERT INTO Organizator (Sifra_organizatora, Naziv_organizatora, Kontakt_organizatora, Lokacija_organizatora) VALUES(?,?,?,?);";
							  PreparedStatement stmt = conn.prepareStatement(sql);
							  stmt.setString(1, SifraOrganizatora); 
							  stmt.setString(2, NazivOrganizatora);
							  stmt.setString(3, KontaktOrganizatora);
							  stmt.setString(4, LokacijaOrganizatora);

				  			  stmt.execute();
											
							  conn.close();
										
							  textField_SifraOrganizatora.setText("");
							  textField_NazivOrganizatora.setText("");
							  textField_KontaktOrganizatora.setText("");
							  textField_LokacijaOrganizatora.setText("");
							  
											
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