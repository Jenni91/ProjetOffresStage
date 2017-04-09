import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPasswordField;

/**
 * Fenetre permettant de modifier les informations de l'entreprise connectée
 */

public class FenetreModifEntreprise extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textAdrRue;
	private JTextField textAdrCP;
	private JTextField textAdrVille;
	private JTextField textMail;
	private JTextField textTel;
	private JTextField textSecteur;
	
	EntrepriseModel em = new EntrepriseModel();
	StageModel sm = new StageModel();
	
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
	public FenetreModifEntreprise(Entreprise entreprise) {
		setTitle("Mes informations");
		setBounds(100, 100, 506, 442);
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
		textNom.setText(entreprise.getNom());
		
		textAdrRue = new JTextField();
		textAdrRue.setColumns(10);
		textAdrRue.setBounds(251, 92, 177, 20);
		contentPane.add(textAdrRue);
		textAdrRue.setText(entreprise.getAdrRue());
		
		textAdrCP = new JTextField();
		textAdrCP.setColumns(10);
		textAdrCP.setBounds(251, 123, 70, 20);
		contentPane.add(textAdrCP);
		textAdrCP.setText(entreprise.getAdrCP());
		
		textAdrVille = new JTextField();
		textAdrVille.setColumns(10);
		textAdrVille.setBounds(251, 154, 121, 20);
		contentPane.add(textAdrVille);
		textAdrVille.setText(entreprise.getAdrVille());
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(251, 185, 148, 20);
		contentPane.add(textMail);
		textMail.setText(entreprise.getMail());
		
		textTel = new JTextField();
		textTel.setColumns(10);
		textTel.setBounds(252, 216, 98, 20);
		contentPane.add(textTel);
		textTel.setText(entreprise.getTel());
		
		textSecteur = new JTextField();
		textSecteur.setColumns(10);
		textSecteur.setBounds(251, 247, 121, 20);
		contentPane.add(textSecteur);
		textSecteur.setText(entreprise.getSecteur());
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				FenetreEntreprise fe = new FenetreEntreprise(entreprise);
				fe.setVisible(true);
			}
		});
		btnAnnuler.setBounds(250, 369, 89, 23);
		contentPane.add(btnAnnuler);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe (ancien ou nouveau)");
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
				Entreprise newEnt = new Entreprise();
				newEnt.setId(entreprise.getId());
				newEnt.setNom(textNom.getText());
				newEnt.setAdrRue(textAdrRue.getText());
				newEnt.setAdrCP(textAdrCP.getText());
				newEnt.setAdrVille(textAdrVille.getText());
				newEnt.setMail(textMail.getText());
				newEnt.setTel(textTel.getText());
				newEnt.setSecteur(textSecteur.getText());
				newEnt.setMdp(passwordField.getText());
				
				if(em.update(newEnt)){
					JOptionPane.showMessageDialog(null, "Vos informations ont été mise à jour");
					dispose();
					FenetreEntreprise fe = new FenetreEntreprise(newEnt);
					fe.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Echec de la mise à jour de vos informations");
					FenetreEntreprise fe = new FenetreEntreprise(entreprise);
					fe.setVisible(true);
				}
			
				setVisible(false);
			}
		});
		btnEnvoyer.setBounds(151, 369, 89, 23);
		contentPane.add(btnEnvoyer);
		
		JButton button = new JButton("Supprimer mon compte");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int response = JOptionPane.showConfirmDialog(null,"Vous êtes sur le point de supprimer votre compte de façon définitive. \nEtes vous sur de vouloir continuer ?","Attention",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				
				if (response == JOptionPane.YES_OPTION) {
				      em.delete(entreprise);
				      
				      List<Stage> listeStage = sm.findAllByIde(entreprise.getId());
				      
				      for(Stage stage : listeStage){
				    	  sm.deleteCandidatureByStage(stage);
				      }				      			      
				      sm.deleteByIde(entreprise);
				      
				      
				      dispose();
				      FenetreLog fl = new FenetreLog();
				      fl.setVisible(true);
				} else {
				      FenetreEntreprise fe = new FenetreEntreprise(entreprise);
				      fe.setVisible(true);
				}
			}
		});
		button.setBounds(151, 324, 188, 23);
		contentPane.add(button);
	}
}
