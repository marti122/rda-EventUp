package eventUpProjekt;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Main {

	private JFrame frmEventUp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmEventUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventUp = new JFrame();
		frmEventUp.setTitle("EventUp");
		frmEventUp.setBounds(100, 100, 481, 334);
		frmEventUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventUp.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 457, 22);
		frmEventUp.getContentPane().add(menuBar);
		
		JMenu mnIzvođač = new JMenu("Izvođač");
		menuBar.add(mnIzvođač);
		
		JMenuItem mntmNoviIzvodac = new JMenuItem("Novi izvođač");
		mntmNoviIzvodac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgNoviIzvodac dlg = new DlgNoviIzvodac();
				dlg.setVisible(true);
			}
		});
		mnIzvođač.add(mntmNoviIzvodac);
		
		JMenuItem mntmPrikazIzvodaca = new JMenuItem("Prikaz svih izvođača");
		mnIzvođač.add(mntmPrikazIzvodaca);
		
		JMenu mnOrganizator = new JMenu("Organizator");
		menuBar.add(mnOrganizator);
		
		JMenuItem mntmNoviOrganizator = new JMenuItem("Novi organizator");
		mntmNoviOrganizator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgNoviOrganizator dlg = new DlgNoviOrganizator();
				dlg.setVisible(true);
			}
		});
		mnOrganizator.add(mntmNoviOrganizator);
		
		JMenuItem mntmPrikazOrganizatora = new JMenuItem("Prikaz svih organizatora");
		mnOrganizator.add(mntmPrikazOrganizatora);
		
		JMenu mnNastupi = new JMenu("Nastupi");
		menuBar.add(mnNastupi);
		
		JMenuItem mntmUnosNoviNastup = new JMenuItem("Novi nastup");
		mntmUnosNoviNastup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgNoviNastup dlg = new DlgNoviNastup();
				dlg.setVisible(true);
			}
		});
		mnNastupi.add(mntmUnosNoviNastup);
		
		JMenuItem mntmPrikazNastupa = new JMenuItem("Prikaz svih nastupa");
		mnNastupi.add(mntmPrikazNastupa);
		
		JMenu mnRacun = new JMenu("Račun");
		menuBar.add(mnRacun);
		
		JMenuItem mntmNoviRacun = new JMenuItem("Izradi novi račun");
		mntmNoviRacun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgNoviRacun dlg = new DlgNoviRacun();
				dlg.setVisible(true);
			}
		});
		mnRacun.add(mntmNoviRacun);
		
		JMenuItem mntmPrikazSvihRacuna = new JMenuItem("Prikaz svih računa");
		mnRacun.add(mntmPrikazSvihRacuna);
		
	
		
		JMenu mnPomoc = new JMenu("Pomoć");
		menuBar.add(mnPomoc);
		
		JMenuItem mntmPomoc = new JMenuItem("Pomoć");
		mntmPomoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgPomoc dlg = new DlgPomoc();
				dlg.setVisible(true);
			}
		});
		mnPomoc.add(mntmPomoc);
		
		JButton btnNoviIzvođač = new JButton("Novi izvođač");
		btnNoviIzvođač.setForeground(Color.BLUE);
		btnNoviIzvođač.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNoviIzvođač.setBackground(Color.LIGHT_GRAY);
		btnNoviIzvođač.setBounds(123, 43, 182, 47);
		frmEventUp.getContentPane().add(btnNoviIzvođač);
		btnNoviIzvođač.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgNoviIzvodac dlg = new DlgNoviIzvodac();
				dlg.setVisible(true);
			}
		});
		frmEventUp.setVisible(true);
		
		JButton btnNoviOrganizator = new JButton("Novi organizator");
		btnNoviOrganizator.setForeground(Color.BLUE);
		btnNoviOrganizator.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNoviOrganizator.setBackground(Color.LIGHT_GRAY);
		btnNoviOrganizator.setBounds(123, 101, 182, 47);
		frmEventUp.getContentPane().add(btnNoviOrganizator);
		btnNoviOrganizator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgNoviOrganizator dlg = new DlgNoviOrganizator();
				dlg.setVisible(true);
			}
		});
		frmEventUp.setVisible(true);
		
		JButton btnNoviNastup = new JButton("Novi nastup");
		btnNoviNastup.setBackground(Color.LIGHT_GRAY);
		btnNoviNastup.setForeground(Color.BLUE);
		btnNoviNastup.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNoviNastup.setBounds(123, 159, 182, 47);
		frmEventUp.getContentPane().add(btnNoviNastup);
		
		JButton btnNoviRacun = new JButton("Novi račun");
		btnNoviRacun.setForeground(Color.BLUE);
		btnNoviRacun.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNoviRacun.setBackground(Color.LIGHT_GRAY);
		btnNoviRacun.setBounds(121, 217, 184, 47);
		frmEventUp.getContentPane().add(btnNoviRacun);
		btnNoviRacun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgNoviRacun dlg = new DlgNoviRacun();
				dlg.setVisible(true);
			}
		});
		frmEventUp.setVisible(true);
		

	}
}
