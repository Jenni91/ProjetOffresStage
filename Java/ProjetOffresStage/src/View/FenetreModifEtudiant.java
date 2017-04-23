package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Etudiant;
import Model.EtudiantModel;
import Model.StageModel;

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
 * Fenetre permettant de modifier les informations de l'etudiant connecté
 */

public class FenetreModifEtudiant extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textEtabl;
	private JTextField textFiliere;
	private JTextField textNiveau;
	private JTextField textVille;
	private JTextField textMail;
	private JTextField textTel;
	
	EtudiantModel em = new EtudiantModel();
	StageModel sm = new StageModel();
	
	private JPasswordField passwordField;
	private JTextField textPrenom;
	
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
	public FenetreModifEtudiant(Etudiant etudiant) {
		setTitle("Mes informations");
		setBounds(100, 100, 506, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreationDuneEntreprise = new JLabel("MES INFORMATIONS");
		lblCreationDuneEntreprise.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreationDuneEntreprise.setBounds(109, 5, 272, 20);
		lblCreationDuneEntreprise.setForeground(Color.WHITE);
		lblCreationDuneEntreprise.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblCreationDuneEntreprise);
		
		JLabel lblNomDeLentreprise = new JLabel("Nom");
		lblNomDeLentreprise.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomDeLentreprise.setForeground(Color.WHITE);
		lblNomDeLentreprise.setBounds(79, 60, 160, 14);
		contentPane.add(lblNomDeLentreprise);
		
		JLabel lblAdressenumroEt = new JLabel("Etablissement");
		lblAdressenumroEt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressenumroEt.setForeground(Color.WHITE);
		lblAdressenumroEt.setBounds(78, 122, 161, 14);
		contentPane.add(lblAdressenumroEt);
		
		JLabel lblAdressecodePostal = new JLabel("Filiere");
		lblAdressecodePostal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressecodePostal.setForeground(Color.WHITE);
		lblAdressecodePostal.setBounds(78, 153, 161, 14);
		contentPane.add(lblAdressecodePostal);
		
		JLabel lblAdresseville = new JLabel("Niveau");
		lblAdresseville.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresseville.setForeground(Color.WHITE);
		lblAdresseville.setBounds(78, 184, 161, 14);
		contentPane.add(lblAdresseville);
		
		JLabel lblMailDuContact = new JLabel("Ville");
		lblMailDuContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMailDuContact.setForeground(Color.WHITE);
		lblMailDuContact.setBounds(78, 215, 161, 14);
		contentPane.add(lblMailDuContact);
		
		JLabel lblTlphoneDuContact = new JLabel("Mail");
		lblTlphoneDuContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTlphoneDuContact.setForeground(Color.WHITE);
		lblTlphoneDuContact.setBounds(78, 246, 161, 14);
		contentPane.add(lblTlphoneDuContact);
		
		JLabel lblSecteurDactivitDe = new JLabel("T\u00E9l\u00E9phone");
		lblSecteurDactivitDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSecteurDactivitDe.setForeground(Color.WHITE);
		lblSecteurDactivitDe.setBounds(45, 277, 194, 14);
		contentPane.add(lblSecteurDactivitDe);
		
		textNom = new JTextField();
		textNom.setBounds(249, 57, 121, 20);
		contentPane.add(textNom);
		textNom.setColumns(10);
		textNom.setText(etudiant.getNom());
		
		textEtabl = new JTextField();
		textEtabl.setColumns(10);
		textEtabl.setBounds(249, 119, 177, 20);
		contentPane.add(textEtabl);
		textEtabl.setText(etudiant.getEtabl());
		
		textFiliere = new JTextField();
		textFiliere.setColumns(10);
		textFiliere.setBounds(249, 150, 70, 20);
		contentPane.add(textFiliere);
		textFiliere.setText(etudiant.getFiliere());
		
		textNiveau = new JTextField();
		textNiveau.setColumns(10);
		textNiveau.setBounds(249, 181, 121, 20);
		contentPane.add(textNiveau);
		textNiveau.setText(etudiant.getNiveau());
		
		textVille = new JTextField();
		textVille.setColumns(10);
		textVille.setBounds(249, 212, 148, 20);
		contentPane.add(textVille);
		textVille.setText(etudiant.getVille());
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(250, 243, 98, 20);
		contentPane.add(textMail);
		textMail.setText(etudiant.getMail());
		
		textTel = new JTextField();
		textTel.setColumns(10);
		textTel.setBounds(249, 274, 121, 20);
		contentPane.add(textTel);
		textTel.setText(etudiant.getTel());
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				FenetreEtudiant fe = new FenetreEtudiant(etudiant);
				fe.setVisible(true);
			}
		});
		btnAnnuler.setBounds(249, 395, 89, 23);
		contentPane.add(btnAnnuler);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe (ancien ou nouveau)");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMotDePasse.setForeground(Color.WHITE);
		lblMotDePasse.setBounds(45, 308, 194, 14);
		contentPane.add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(249, 305, 148, 20);
		contentPane.add(passwordField);
		
		textPrenom = new JTextField();
		textPrenom.setText((String) null);
		textPrenom.setColumns(10);
		textPrenom.setBounds(249, 88, 121, 20);
		contentPane.add(textPrenom);
		textPrenom.setText(etudiant.getPrenom());
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrnom.setForeground(Color.WHITE);
		lblPrnom.setBounds(79, 91, 160, 14);
		contentPane.add(lblPrnom);

		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Enregistrer les données dans la BDD
				Etudiant newEtu = new Etudiant();
				newEtu.setId(etudiant.getId());
				newEtu.setNom(textNom.getText());
				newEtu.setPrenom(textPrenom.getText());
				newEtu.setEtabl(textEtabl.getText());
				newEtu.setFiliere(textFiliere.getText());
				newEtu.setNiveau(textNiveau.getText());
				newEtu.setVille(textVille.getText());
				newEtu.setMail(textMail.getText());
				newEtu.setTel(textTel.getText());
				newEtu.setMdp(passwordField.getText());
				
				if(em.update(newEtu)){
					JOptionPane.showMessageDialog(null, "Vos informations ont été mise à jour");
					dispose();
					FenetreEtudiant fe = new FenetreEtudiant(newEtu);
					fe.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Echec de la mise à jour de vos informations");
					FenetreEtudiant fe = new FenetreEtudiant(etudiant);
					fe.setVisible(true);
				}
			
				setVisible(false);
			}
		});
		btnEnvoyer.setBounds(150, 395, 89, 23);
		contentPane.add(btnEnvoyer);
		
		JButton btnSupprimerMonCompte = new JButton("Supprimer mon compte");
		btnSupprimerMonCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int response = JOptionPane.showConfirmDialog(null,"Vous êtes sur le point de supprimer votre compte de façon définitive. \nEtes vous sur de vouloir continuer ?","Attention",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				
				if (response == JOptionPane.YES_OPTION) {
				      em.delete(etudiant);
				      sm.deleteCandidatureByEtudiant(etudiant);
				      
				      dispose();
				      FenetreLog fl = new FenetreLog();
				      fl.setVisible(true);
				} else {
				      FenetreEtudiant fe = new FenetreEtudiant(etudiant);
				      fe.setVisible(true);
				}
			}
		});
		btnSupprimerMonCompte.setBounds(150, 350, 188, 23);
		contentPane.add(btnSupprimerMonCompte);
		
	}
}
