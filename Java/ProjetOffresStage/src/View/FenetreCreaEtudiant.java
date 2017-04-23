package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Etudiant;
import Model.EtudiantModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

/**
 * Fenetre permettant de créer un compte étudiant
 */

public class FenetreCreaEtudiant extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textEtabl;
	private JTextField textFiliere;
	private JTextField textNiveau;
	private JTextField textVille;
	private JTextField textMail;
	private JPasswordField passwordField;
	private JTextField textTel;
	
	EtudiantModel etm = new EtudiantModel();
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreCreaEntreprise frame = new FenetreCreaEntreprise();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FenetreCreaEtudiant() {
		setTitle("Cr\u00E9ation d'un étudiant");
		setBounds(100, 100, 506, 437);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreationDuneEntreprise = new JLabel("CREATION D'UN ETUDIANT");
		lblCreationDuneEntreprise.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreationDuneEntreprise.setBounds(109, 5, 272, 20);
		lblCreationDuneEntreprise.setForeground(Color.WHITE);
		lblCreationDuneEntreprise.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblCreationDuneEntreprise);
		
		JLabel lblNomDeLentreprise = new JLabel("Nom");
		lblNomDeLentreprise.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomDeLentreprise.setForeground(Color.WHITE);
		lblNomDeLentreprise.setBounds(81, 64, 160, 14);
		contentPane.add(lblNomDeLentreprise);
		
		JLabel lblAdressenumroEt = new JLabel("Pr\u00E9nom");
		lblAdressenumroEt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressenumroEt.setForeground(Color.WHITE);
		lblAdressenumroEt.setBounds(80, 95, 161, 14);
		contentPane.add(lblAdressenumroEt);
		
		JLabel lblAdressecodePostal = new JLabel("Etablissement");
		lblAdressecodePostal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressecodePostal.setForeground(Color.WHITE);
		lblAdressecodePostal.setBounds(80, 126, 161, 14);
		contentPane.add(lblAdressecodePostal);
		
		JLabel lblAdresseville = new JLabel("Filiere");
		lblAdresseville.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresseville.setForeground(Color.WHITE);
		lblAdresseville.setBounds(80, 157, 161, 14);
		contentPane.add(lblAdresseville);
		
		JLabel lblMailDuContact = new JLabel("Niveau");
		lblMailDuContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMailDuContact.setForeground(Color.WHITE);
		lblMailDuContact.setBounds(80, 188, 161, 14);
		contentPane.add(lblMailDuContact);
		
		JLabel lblTlphoneDuContact = new JLabel("Ville de r\u00E9sidence");
		lblTlphoneDuContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTlphoneDuContact.setForeground(Color.WHITE);
		lblTlphoneDuContact.setBounds(80, 219, 161, 14);
		contentPane.add(lblTlphoneDuContact);
		
		JLabel lblSecteurDactivitDe = new JLabel("Mail");
		lblSecteurDactivitDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSecteurDactivitDe.setForeground(Color.WHITE);
		lblSecteurDactivitDe.setBounds(47, 250, 194, 14);
		contentPane.add(lblSecteurDactivitDe);
		
		textNom = new JTextField();
		textNom.setBounds(251, 61, 121, 20);
		contentPane.add(textNom);
		textNom.setColumns(10);
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		textPrenom.setBounds(251, 92, 177, 20);
		contentPane.add(textPrenom);
		
		textEtabl = new JTextField();
		textEtabl.setColumns(10);
		textEtabl.setBounds(251, 123, 70, 20);
		contentPane.add(textEtabl);
		
		textFiliere = new JTextField();
		textFiliere.setColumns(10);
		textFiliere.setBounds(251, 154, 121, 20);
		contentPane.add(textFiliere);
		
		textNiveau = new JTextField();
		textNiveau.setColumns(10);
		textNiveau.setBounds(251, 185, 148, 20);
		contentPane.add(textNiveau);
		
		textVille = new JTextField();
		textVille.setColumns(10);
		textVille.setBounds(252, 216, 98, 20);
		contentPane.add(textVille);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(251, 247, 121, 20);
		contentPane.add(textMail);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnAnnuler.setBounds(251, 348, 89, 23);
		contentPane.add(btnAnnuler);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMotDePasse.setForeground(Color.WHITE);
		lblMotDePasse.setBounds(47, 312, 194, 14);
		contentPane.add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(251, 309, 148, 20);
		contentPane.add(passwordField);
		
		textTel = new JTextField();
		textTel.setColumns(10);
		textTel.setBounds(251, 278, 121, 20);
		contentPane.add(textTel);
		
		JLabel lblTel = new JLabel("T\u00E9l\u00E9phone");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setForeground(Color.WHITE);
		lblTel.setBounds(47, 281, 194, 14);
		contentPane.add(lblTel);
		
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Enregistrer les données dans la BDD
				Etudiant et = new Etudiant();
				et.setNom(textNom.getText());
				et.setPrenom(textPrenom.getText());
				et.setEtabl(textEtabl.getText());
				et.setFiliere(textFiliere.getText());
				et.setNiveau(textNiveau.getText());
				et.setVille(textVille.getText());
				et.setMail(textMail.getText());
				et.setTel(textTel.getText());
				et.setMdp(passwordField.getText());
				
				if(etm.create(et)){
					JOptionPane.showMessageDialog(null, "Vous avez été ajouté");
				}
				else
					JOptionPane.showMessageDialog(null, "Echec de l'ajout");
			
				setVisible(false);
			}
		});
		btnEnvoyer.setBounds(152, 348, 89, 23);
		contentPane.add(btnEnvoyer);
	}
}
