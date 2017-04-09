import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;

/**
 * Fenetre permettant de consulter la liste des étudiants
 */

public class FenetreVoirEtudiants extends JFrame {

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
	private List<Etudiant> listeEtudiants;
	private int i=0;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreCreaOffre frame = new FenetreCreaOffre();
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
	public FenetreVoirEtudiants() {
		
		listeEtudiants = em.findAll();
		
		setTitle("Consultation de la liste des \u00E9tudiants");
		setBounds(100, 100, 589, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreationDuneEntreprise = new JLabel("CONSULTATION DES ETUDIANTS INCRITS");
		lblCreationDuneEntreprise.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreationDuneEntreprise.setBounds(87, 5, 399, 20);
		lblCreationDuneEntreprise.setForeground(Color.WHITE);
		lblCreationDuneEntreprise.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblCreationDuneEntreprise);
		
		JLabel lblNomDeLentreprise = new JLabel("Nom de l'\u00E9tudiant");
		lblNomDeLentreprise.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomDeLentreprise.setForeground(Color.WHITE);
		lblNomDeLentreprise.setBounds(0, 61, 138, 14);
		contentPane.add(lblNomDeLentreprise);
		
		JLabel lblAdressenumroEt = new JLabel("Ville");
		lblAdressenumroEt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressenumroEt.setForeground(Color.WHITE);
		lblAdressenumroEt.setBounds(308, 89, 109, 14);
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
		lblMailDuContact.setBounds(320, 117, 97, 14);
		contentPane.add(lblMailDuContact);
		
		textEtabl = new JTextField();
		textEtabl.setEditable(false);
		textEtabl.setColumns(10);
		textEtabl.setBounds(148, 114, 131, 20);
		contentPane.add(textEtabl);
		
		textFiliere = new JTextField();
		textFiliere.setEditable(false);
		textFiliere.setColumns(10);
		textFiliere.setBounds(148, 142, 121, 20);
		contentPane.add(textFiliere);
		
		textMail = new JTextField();
		textMail.setEditable(false);
		textMail.setColumns(10);
		textMail.setBounds(427, 114, 109, 20);
		contentPane.add(textMail);
		
		textNom = new JTextField();
		textNom.setEditable(false);
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
		textVille.setEditable(false);
		textVille.setBounds(427, 86, 109, 20);
		contentPane.add(textVille);
		textVille.setColumns(10);
		
		JLabel lblVille = new JLabel("Niveau");
		lblVille.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVille.setForeground(Color.WHITE);
		lblVille.setBounds(320, 61, 97, 14);
		contentPane.add(lblVille);
		
		textNiveau = new JTextField();
		textNiveau.setEditable(false);
		textNiveau.setBounds(427, 58, 109, 20);
		contentPane.add(textNiveau);
		textNiveau.setColumns(10);
		
		JLabel lblMail = new JLabel("Prenom de l'\u00E9tudiant");
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMail.setForeground(Color.WHITE);
		lblMail.setBounds(10, 89, 128, 14);
		contentPane.add(lblMail);
		
		textPrenom = new JTextField();
		textPrenom.setEditable(false);
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
				
			}
		});
		btnPrecedent.setBounds(104, 431, 115, 23);
		contentPane.add(btnPrecedent);
		btnPrecedent.setEnabled(false);
		
		btnSuivant = new JButton("Suivant");
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
				
			}
		});
		btnSuivant.setBounds(229, 431, 115, 23);
		contentPane.add(btnSuivant);
		
		textTel = new JTextField();
		textTel.setEditable(false);
		textTel.setColumns(10);
		textTel.setBounds(427, 142, 109, 20);
		contentPane.add(textTel);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone");
		lblTlphone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTlphone.setForeground(Color.WHITE);
		lblTlphone.setBounds(320, 145, 97, 14);
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
		
	}
}
