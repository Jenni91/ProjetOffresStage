package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Entreprise;
import Model.EntrepriseModel;
import Model.Etudiant;
import Model.EtudiantModel;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

/**
 * Fenetre d'accueil pour s'identifier en tant qu'entreprise ou étudiant
 */

public class FenetreLog extends JFrame {

	private JPanel contentPane;
	private JTextField textMailEtu;
	private JTextField textMailEnt;
	private JPasswordField passwordFieldEtu;
	private JPasswordField passwordFieldEnt;

	private EtudiantModel etum = new EtudiantModel();
	private EntrepriseModel entm = new EntrepriseModel();
	
	public Etudiant etudiant;
	public Entreprise entreprise;
	
	static FenetreLog frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FenetreLog();
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
	public FenetreLog() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(275, 60, 2, 188);
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblEtudiant = new JLabel("ETUDIANT");
		lblEtudiant.setBounds(80, 19, 127, 17);
		lblEtudiant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEtudiant.setForeground(Color.WHITE);
		lblEtudiant.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblEntreprise = new JLabel("ENTREPRISE");
		lblEntreprise.setBounds(356, 19, 127, 17);
		lblEntreprise.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntreprise.setForeground(Color.WHITE);
		lblEntreprise.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblIdentifiant = new JLabel("Adresse mail");
		lblIdentifiant.setBounds(55, 68, 101, 14);
		lblIdentifiant.setForeground(Color.WHITE);
		
		JLabel lblAdresseMail = new JLabel("Adresse mail");
		lblAdresseMail.setBounds(330, 68, 101, 14);
		lblAdresseMail.setForeground(Color.WHITE);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(55, 129, 101, 14);
		lblMotDePasse.setForeground(Color.WHITE);
		
		JLabel lblMotDePasse_1 = new JLabel("Mot de passe");
		lblMotDePasse_1.setBounds(330, 131, 101, 14);
		lblMotDePasse_1.setForeground(Color.WHITE);
		
		textMailEtu = new JTextField();
		textMailEtu.setBounds(55, 88, 174, 20);
		textMailEtu.setColumns(10);
		
		textMailEnt = new JTextField();
		textMailEnt.setBounds(330, 88, 174, 20);
		textMailEnt.setColumns(10);
		
		JButton btnCrerEtu = new JButton("Cr\u00E9er");
		btnCrerEtu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenetreCreaEtudiant fet = new FenetreCreaEtudiant();
				fet.setVisible(true);
			}
		});
		btnCrerEtu.setBounds(154, 205, 75, 23);
		
		JButton buttonCrerEnt = new JButton("Cr\u00E9er");
		buttonCrerEnt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenetreCreaEntreprise fe = new FenetreCreaEntreprise();
				fe.setVisible(true);
			}
		});
		buttonCrerEnt.setBounds(429, 205, 75, 23);
		contentPane.setLayout(null);
		contentPane.add(separator);
		contentPane.add(lblEtudiant);
		contentPane.add(lblEntreprise);
		contentPane.add(lblIdentifiant);
		contentPane.add(lblAdresseMail);
		contentPane.add(lblMotDePasse);
		contentPane.add(lblMotDePasse_1);
		contentPane.add(textMailEtu);
		contentPane.add(textMailEnt);
		contentPane.add(btnCrerEtu);
		contentPane.add(buttonCrerEnt);
		
		passwordFieldEtu = new JPasswordField();
		passwordFieldEtu.setBounds(55, 154, 174, 21);
		contentPane.add(passwordFieldEtu);
		
		passwordFieldEnt = new JPasswordField();
		passwordFieldEnt.setBounds(330, 156, 174, 21);
		contentPane.add(passwordFieldEnt);
		
		JButton btnParametres = new JButton("Parametres");
		btnParametres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenetreConnection fc = new FenetreConnection();
				fc.setVisible(true);
			}
		});
		btnParametres.setBounds(154, 274, 112, 23);
		contentPane.add(btnParametres);
		
		JButton btnValiderEtu = new JButton("Valider");
		btnValiderEtu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				etudiant = etum.login(textMailEtu.getText(), passwordFieldEtu.getText());
				
				if(etudiant!=null){
					FenetreEtudiant fet = new FenetreEtudiant(etudiant);
					dispose();
					fet.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Vos identifiants sont incorrectes. Vérifiez que vous êtes bien sur la bonne base de donnée.");
				}
				
			}
		});
		btnValiderEtu.setBounds(55, 205, 75, 23);
		contentPane.add(btnValiderEtu);
		

		JButton buttonValiderEnt = new JButton("Valider");
		buttonValiderEnt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				entreprise = entm.login(textMailEnt.getText(), passwordFieldEnt.getText());
				
				if(entreprise!=null){
					FenetreEntreprise fent = new FenetreEntreprise(entreprise);
					fent.setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Vos identifiants sont incorrectes. Vérifiez que vous êtes bien sur la bonne base de donnée.");
				}
				
			}
		});
		buttonValiderEnt.setBounds(330, 205, 75, 23);
		contentPane.add(buttonValiderEnt);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				FenetreLogAdmin fa = new FenetreLogAdmin();
				fa.setVisible(true);
			}
		});
		btnAdmin.setBounds(287, 274, 112, 23);
		contentPane.add(btnAdmin);
	}
}
