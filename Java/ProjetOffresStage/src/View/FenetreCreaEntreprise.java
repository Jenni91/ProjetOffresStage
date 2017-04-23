package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Entreprise;
import Model.EntrepriseModel;

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
 * Fenetre permettant de créer un compte entreprise
 */

public class FenetreCreaEntreprise extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textAdrRue;
	private JTextField textAdrCP;
	private JTextField textAdrVille;
	private JTextField textMail;
	private JTextField textTel;
	private JTextField textSecteur;
	
	EntrepriseModel em = new EntrepriseModel();
	private JPasswordField passwordField;
	
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
	public FenetreCreaEntreprise() {
		setTitle("Cr\u00E9ation d'une entreprise");
		setBounds(100, 100, 506, 399);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreationDuneEntreprise = new JLabel("CREATION D'UNE ENTREPRISE");
		lblCreationDuneEntreprise.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreationDuneEntreprise.setBounds(109, 5, 272, 20);
		lblCreationDuneEntreprise.setForeground(Color.WHITE);
		lblCreationDuneEntreprise.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblCreationDuneEntreprise);
		
		JLabel lblNomDeLentreprise = new JLabel("Nom de l'entreprise");
		lblNomDeLentreprise.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomDeLentreprise.setForeground(Color.WHITE);
		lblNomDeLentreprise.setBounds(81, 64, 160, 14);
		contentPane.add(lblNomDeLentreprise);
		
		JLabel lblAdressenumroEt = new JLabel("Adresse (Num\u00E9ro et rue)");
		lblAdressenumroEt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressenumroEt.setForeground(Color.WHITE);
		lblAdressenumroEt.setBounds(80, 95, 161, 14);
		contentPane.add(lblAdressenumroEt);
		
		JLabel lblAdressecodePostal = new JLabel("Adresse (Code postal)");
		lblAdressecodePostal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressecodePostal.setForeground(Color.WHITE);
		lblAdressecodePostal.setBounds(80, 126, 161, 14);
		contentPane.add(lblAdressecodePostal);
		
		JLabel lblAdresseville = new JLabel("Adresse (Ville)");
		lblAdresseville.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresseville.setForeground(Color.WHITE);
		lblAdresseville.setBounds(80, 157, 161, 14);
		contentPane.add(lblAdresseville);
		
		JLabel lblMailDuContact = new JLabel("Mail du contact");
		lblMailDuContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMailDuContact.setForeground(Color.WHITE);
		lblMailDuContact.setBounds(80, 188, 161, 14);
		contentPane.add(lblMailDuContact);
		
		JLabel lblTlphoneDuContact = new JLabel("T\u00E9l\u00E9phone du contact");
		lblTlphoneDuContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTlphoneDuContact.setForeground(Color.WHITE);
		lblTlphoneDuContact.setBounds(80, 219, 161, 14);
		contentPane.add(lblTlphoneDuContact);
		
		JLabel lblSecteurDactivitDe = new JLabel("Secteur d'activit\u00E9 de l'entreprise");
		lblSecteurDactivitDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSecteurDactivitDe.setForeground(Color.WHITE);
		lblSecteurDactivitDe.setBounds(47, 250, 194, 14);
		contentPane.add(lblSecteurDactivitDe);
		
		textNom = new JTextField();
		textNom.setBounds(251, 61, 121, 20);
		contentPane.add(textNom);
		textNom.setColumns(10);
		
		textAdrRue = new JTextField();
		textAdrRue.setColumns(10);
		textAdrRue.setBounds(251, 92, 177, 20);
		contentPane.add(textAdrRue);
		
		textAdrCP = new JTextField();
		textAdrCP.setColumns(10);
		textAdrCP.setBounds(251, 123, 70, 20);
		contentPane.add(textAdrCP);
		
		textAdrVille = new JTextField();
		textAdrVille.setColumns(10);
		textAdrVille.setBounds(251, 154, 121, 20);
		contentPane.add(textAdrVille);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(251, 185, 148, 20);
		contentPane.add(textMail);
		
		textTel = new JTextField();
		textTel.setColumns(10);
		textTel.setBounds(252, 216, 98, 20);
		contentPane.add(textTel);
		
		textSecteur = new JTextField();
		textSecteur.setColumns(10);
		textSecteur.setBounds(251, 247, 121, 20);
		contentPane.add(textSecteur);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnAnnuler.setBounds(251, 326, 89, 23);
		contentPane.add(btnAnnuler);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMotDePasse.setForeground(Color.WHITE);
		lblMotDePasse.setBounds(47, 281, 194, 14);
		contentPane.add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(251, 278, 148, 20);
		contentPane.add(passwordField);
		

		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Enregistrer les données dans la BDD
				Entreprise ent = new Entreprise();
				ent.setNom(textNom.getText());
				ent.setAdrRue(textAdrRue.getText());
				ent.setAdrCP(textAdrCP.getText());
				ent.setAdrVille(textAdrVille.getText());
				ent.setMail(textMail.getText());
				ent.setTel(textTel.getText());
				ent.setSecteur(textSecteur.getText());
				ent.setMdp(passwordField.getText());
				
				if(em.create(ent)){
					JOptionPane.showMessageDialog(null, "Votre entreprise a été ajouté");
				}
				else
					JOptionPane.showMessageDialog(null, "Echec de l'ajout de l'entreprise");
			
				setVisible(false);
			}
		});
		btnEnvoyer.setBounds(152, 326, 89, 23);
		contentPane.add(btnEnvoyer);
	}
}
