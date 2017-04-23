package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Model.Etudiant;
import Model.EtudiantModel;
import Model.StageModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Fenetre permettant de gerer les etudiants par l'administrateur
 */

public class FenetreAdminEtudiant extends JFrame {

	private JPanel contentPane;

	private JTextField textEtabl;
	private JTextField textFiliere;
	private JTextField textMail;
	private JTextField textNom;
	private JTextField textVille;
	private JTextField textNiveau;
	private JTextField textPrenom;
	private JTextField textTel;
	
	private JButton btnPrecedent;
	private JButton btnSuivant;

	EtudiantModel em = new EtudiantModel();
	StageModel sm = new StageModel();
	
	private List<Etudiant> listeEtudiants;
	private int i=0;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private JLabel lblListeDesEtudiants;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAdminEtudiant frame = new FenetreAdminEtudiant();
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
	public FenetreAdminEtudiant() {
		
		listeEtudiants = em.findAll();
		
		setBounds(100, 100, 591, 335);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomDeLentreprise = new JLabel("Nom de l'\u00E9tudiant");
		lblNomDeLentreprise.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomDeLentreprise.setForeground(Color.WHITE);
		lblNomDeLentreprise.setBounds(0, 61, 138, 14);
		contentPane.add(lblNomDeLentreprise);
		
		JLabel lblAdressenumroEt = new JLabel("Ville");
		lblAdressenumroEt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressenumroEt.setForeground(Color.WHITE);
		lblAdressenumroEt.setBounds(292, 92, 109, 14);
		contentPane.add(lblAdressenumroEt);
		
		JLabel lblAdressecodePostal = new JLabel("Etablissement");
		lblAdressecodePostal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressecodePostal.setForeground(Color.WHITE);
		lblAdressecodePostal.setBounds(0, 117, 138, 14);
		contentPane.add(lblAdressecodePostal);
		
		JLabel lblAdresseville = new JLabel("Filiere");
		lblAdresseville.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresseville.setForeground(Color.WHITE);
		lblAdresseville.setBounds(0, 145, 138, 14);
		contentPane.add(lblAdresseville);
		
		JLabel lblMailDuContact = new JLabel("Mail");
		lblMailDuContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMailDuContact.setForeground(Color.WHITE);
		lblMailDuContact.setBounds(304, 120, 97, 14);
		contentPane.add(lblMailDuContact);
		
		textEtabl = new JTextField();
		textEtabl.setColumns(10);
		textEtabl.setBounds(148, 114, 131, 20);
		contentPane.add(textEtabl);
		
		textFiliere = new JTextField();
		textFiliere.setColumns(10);
		textFiliere.setBounds(148, 142, 121, 20);
		contentPane.add(textFiliere);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(411, 117, 109, 20);
		contentPane.add(textMail);
		
		textNom = new JTextField();
		textNom.setColumns(10);
		textNom.setBounds(148, 58, 131, 20);
		contentPane.add(textNom);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnFermer.setBounds(354, 431, 115, 23);
		contentPane.add(btnFermer);
		
		textVille = new JTextField();
		textVille.setBounds(411, 89, 109, 20);
		contentPane.add(textVille);
		textVille.setColumns(10);
		
		JLabel lblVille = new JLabel("Niveau");
		lblVille.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVille.setForeground(Color.WHITE);
		lblVille.setBounds(304, 64, 97, 14);
		contentPane.add(lblVille);
		
		textNiveau = new JTextField();
		textNiveau.setBounds(411, 61, 109, 20);
		contentPane.add(textNiveau);
		textNiveau.setColumns(10);
		
		JLabel lblMail = new JLabel("Prenom de l'\u00E9tudiant");
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMail.setForeground(Color.WHITE);
		lblMail.setBounds(10, 89, 128, 14);
		contentPane.add(lblMail);
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		textPrenom.setBounds(148, 86, 131, 20);
		contentPane.add(textPrenom);
		
		btnPrecedent = new JButton("Pr\u00E9c\u00E9dent");	
		btnPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i--;
				btnSuivant.setEnabled(true);
				
				textNom.setText(listeEtudiants.get(i).getNom());
				textPrenom.setText(listeEtudiants.get(i).getPrenom());
				textEtabl.setText(listeEtudiants.get(i).getEtabl());
				textFiliere.setText(listeEtudiants.get(i).getFiliere());
				textNiveau.setText(listeEtudiants.get(i).getNiveau());
				textVille.setText(listeEtudiants.get(i).getVille());
				textMail.setText(listeEtudiants.get(i).getMail());
				textTel.setText(listeEtudiants.get(i).getTel());
				
				if(i==0){
					btnPrecedent.setEnabled(false);
				}
				
				/*if(em.findAll().listIterator().hasPrevious()){
					textNom.setText(em.findAll().get(i).getNom());
					textLibelle.setText(sm.findAll().get(i).getLibelle());
				}else{
					
				}*/
			}
		});
		btnPrecedent.setBounds(185, 250, 115, 23);
		contentPane.add(btnPrecedent);
		btnPrecedent.setEnabled(false);
		
		btnSuivant = new JButton("Suivant");
		btnSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i++;
				btnPrecedent.setEnabled(true);
				
				textNom.setText(listeEtudiants.get(i).getNom());
				textPrenom.setText(listeEtudiants.get(i).getPrenom());
				textEtabl.setText(listeEtudiants.get(i).getEtabl());
				textFiliere.setText(listeEtudiants.get(i).getFiliere());
				textNiveau.setText(listeEtudiants.get(i).getNiveau());
				textVille.setText(listeEtudiants.get(i).getVille());
				textMail.setText(listeEtudiants.get(i).getMail());
				textTel.setText(listeEtudiants.get(i).getTel());
				
				if(i==listeEtudiants.size()-1){
					btnSuivant.setEnabled(false);
				}
				
				/*if(em.findAll().listIterator().hasNext()){
					textNom.setText(em.findAll().get(i).getNom());
					textLibelle.setText(sm.findAll().get(i).getLibelle());
				}else{
					
				}*/
			}
		});
		btnSuivant.setBounds(330, 250, 115, 23);
		contentPane.add(btnSuivant);
		
		textTel = new JTextField();
		textTel.setColumns(10);
		textTel.setBounds(411, 145, 109, 20);
		contentPane.add(textTel);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone");
		lblTlphone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTlphone.setForeground(Color.WHITE);
		lblTlphone.setBounds(304, 148, 97, 14);
		contentPane.add(lblTlphone);
		
		//Gestion du premier de la liste
		if(i==listeEtudiants.size()-1){
			btnSuivant.setEnabled(false);
		}
		textNom.setText(listeEtudiants.get(i).getNom());
		textPrenom.setText(listeEtudiants.get(i).getPrenom());
		textEtabl.setText(listeEtudiants.get(i).getEtabl());
		textFiliere.setText(listeEtudiants.get(i).getFiliere());
		textNiveau.setText(listeEtudiants.get(i).getNiveau());
		textVille.setText(listeEtudiants.get(i).getVille());
		textMail.setText(listeEtudiants.get(i).getMail());
		textTel.setText(listeEtudiants.get(i).getTel());
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int response = JOptionPane.showConfirmDialog(null,"Vous êtes sur le point de supprimer cette étudiant de façon définitive. \nEtes vous sur de vouloir continuer ?","Attention",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				
				if (response == JOptionPane.YES_OPTION) {
					Etudiant etu = listeEtudiants.get(i);
					em.delete(etu);
					sm.deleteCandidatureByEtudiant(etu);
					
					i--;
					if(i<0){
						dispose();
					}else if(i==0){
						btnPrecedent.setEnabled(false);
						btnSuivant.setEnabled(false);
						textNom.setText(listeEtudiants.get(i).getNom());
						textPrenom.setText(listeEtudiants.get(i).getPrenom());
						textEtabl.setText(listeEtudiants.get(i).getEtabl());
						textFiliere.setText(listeEtudiants.get(i).getFiliere());
						textNiveau.setText(listeEtudiants.get(i).getNiveau());
						textVille.setText(listeEtudiants.get(i).getVille());
						textMail.setText(listeEtudiants.get(i).getMail());
						textTel.setText(listeEtudiants.get(i).getTel());
					}else{
						textNom.setText(listeEtudiants.get(i).getNom());
						textPrenom.setText(listeEtudiants.get(i).getPrenom());
						textEtabl.setText(listeEtudiants.get(i).getEtabl());
						textFiliere.setText(listeEtudiants.get(i).getFiliere());
						textNiveau.setText(listeEtudiants.get(i).getNiveau());
						textVille.setText(listeEtudiants.get(i).getVille());
						textMail.setText(listeEtudiants.get(i).getMail());
						textTel.setText(listeEtudiants.get(i).getTel());
					}
				}else{
					
				}
			}
		});
		btnSupprimer.setBounds(330, 213, 115, 23);
		contentPane.add(btnSupprimer);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Etudiant newEtu = new Etudiant();
				newEtu.setId(listeEtudiants.get(i).getId());
				newEtu.setNom(textNom.getText());
				newEtu.setPrenom(textPrenom.getText());
				newEtu.setEtabl(textEtabl.getText());
				newEtu.setFiliere(textFiliere.getText());
				newEtu.setNiveau(textNiveau.getText());
				newEtu.setVille(textVille.getText());
				newEtu.setMail(textMail.getText());
				newEtu.setTel(textTel.getText());
				
				if(em.updateAdmin(newEtu)){
					JOptionPane.showMessageDialog(null, "Les informations ont été mise à jour");
				}
				else{
					JOptionPane.showMessageDialog(null, "Echec de la mise à jour des informations");
				}
							
			}
			
		});
		btnModifier.setBounds(185, 213, 115, 23);
		contentPane.add(btnModifier);
		
		lblListeDesEtudiants = new JLabel("LISTE DES ETUDIANTS");
		lblListeDesEtudiants.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDesEtudiants.setForeground(Color.WHITE);
		lblListeDesEtudiants.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListeDesEtudiants.setBounds(121, 11, 399, 20);
		contentPane.add(lblListeDesEtudiants);
		
	}

}
