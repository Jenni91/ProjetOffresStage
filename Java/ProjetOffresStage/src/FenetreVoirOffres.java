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
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;

/**
 * Fenetre permettant à un étudiant de consulter toutes les offres de la BDD
 */

public class FenetreVoirOffres extends JFrame {

	private JPanel contentPane;
	private JTextField textLibelle;
	private JTextField textDateDeb;
	private JTextField textDuree;
	private JTextField textNom;
	private JTextField textDomaine;
	private JTextField textVille;
	private JTextField textMail;
	
	private JButton btnPrecedent;
	private JButton btnSuivant;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
	
	StageModel sm = new StageModel();
	private List<Stage> listeStage;
	int i=0;
	
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
	public FenetreVoirOffres(Etudiant etudiant) {
		
		listeStage = sm.findAll();
		
		setTitle("Consultation des offres de stage");
		setBounds(100, 100, 589, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreationDuneEntreprise = new JLabel("CONSULTATION DES OFFRES DE STAGE");
		lblCreationDuneEntreprise.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreationDuneEntreprise.setBounds(87, 5, 399, 20);
		lblCreationDuneEntreprise.setForeground(Color.WHITE);
		lblCreationDuneEntreprise.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblCreationDuneEntreprise);
		
		JLabel lblNomDeLentreprise = new JLabel("Nom de l'entreprise");
		lblNomDeLentreprise.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomDeLentreprise.setForeground(Color.WHITE);
		lblNomDeLentreprise.setBounds(0, 61, 138, 14);
		contentPane.add(lblNomDeLentreprise);
		
		JLabel lblAdressenumroEt = new JLabel("Domaine de l'offre");
		lblAdressenumroEt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressenumroEt.setForeground(Color.WHITE);
		lblAdressenumroEt.setBounds(308, 89, 109, 14);
		contentPane.add(lblAdressenumroEt);
		
		JLabel lblAdressecodePostal = new JLabel("Libell\u00E9 de l'offre");
		lblAdressecodePostal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressecodePostal.setForeground(Color.WHITE);
		lblAdressecodePostal.setBounds(0, 117, 138, 14);
		contentPane.add(lblAdressecodePostal);
		
		JLabel lblAdresseville = new JLabel("Date de d\u00E9but de stage");
		lblAdresseville.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresseville.setForeground(Color.WHITE);
		lblAdresseville.setBounds(0, 145, 138, 14);
		contentPane.add(lblAdresseville);
		
		JLabel lblMailDuContact = new JLabel("Dur\u00E9e en mois");
		lblMailDuContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMailDuContact.setForeground(Color.WHITE);
		lblMailDuContact.setBounds(286, 145, 131, 14);
		contentPane.add(lblMailDuContact);
		
		JLabel lblSecteurDactivitDe = new JLabel("Description de l'offre");
		lblSecteurDactivitDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSecteurDactivitDe.setForeground(Color.WHITE);
		lblSecteurDactivitDe.setBounds(0, 274, 194, 14);
		contentPane.add(lblSecteurDactivitDe);
		
		textLibelle = new JTextField();
		textLibelle.setColumns(10);
		textLibelle.setBounds(148, 114, 229, 20);
		contentPane.add(textLibelle);
		
		textDateDeb = new JTextField();
		textDateDeb.setColumns(10);
		textDateDeb.setBounds(148, 142, 121, 20);
		contentPane.add(textDateDeb);
		
		textDuree = new JTextField();
		textDuree.setColumns(10);
		textDuree.setBounds(427, 142, 109, 20);
		contentPane.add(textDuree);
		
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
		
		JEditorPane paneDescr = new JEditorPane();
		paneDescr.setBounds(226, 203, 229, 168);
		contentPane.add(paneDescr);
		
		textDomaine = new JTextField();
		textDomaine.setBounds(427, 86, 109, 20);
		contentPane.add(textDomaine);
		textDomaine.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVille.setForeground(Color.WHITE);
		lblVille.setBounds(320, 61, 97, 14);
		contentPane.add(lblVille);
		
		textVille = new JTextField();
		textVille.setBounds(427, 58, 109, 20);
		contentPane.add(textVille);
		textVille.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMail.setForeground(Color.WHITE);
		lblMail.setBounds(41, 89, 97, 14);
		contentPane.add(lblMail);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(148, 86, 131, 20);
		contentPane.add(textMail);
		
		btnPrecedent = new JButton("Pr\u00E9c\u00E9dent");
		btnSuivant = new JButton("Suivant");
		
		btnSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i++;
				btnPrecedent.setEnabled(true);
				
				textNom.setText(listeStage.get(i).getNomE());
				textVille.setText(listeStage.get(i).getVille());
				textMail.setText(listeStage.get(i).getMail());
				textDomaine.setText(listeStage.get(i).getDomaine());
				textLibelle.setText(listeStage.get(i).getLibelle());
				textDomaine.setText(dateFormat.format(listeStage.get(i).getDateDeb()));
				textDuree.setText(String.valueOf(listeStage.get(i).getDuree()));
				paneDescr.setText(listeStage.get(i).getDesc());
				
				if(i==listeStage.size()-1){
					btnSuivant.setEnabled(false);
				}
				
			}
		});
		btnSuivant.setBounds(229, 431, 115, 23);
		contentPane.add(btnSuivant);
		
		btnPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i--;
				btnSuivant.setEnabled(true);
				
				textNom.setText(listeStage.get(i).getNomE());
				textVille.setText(listeStage.get(i).getVille());
				textMail.setText(listeStage.get(i).getMail());
				textDomaine.setText(listeStage.get(i).getDomaine());
				textLibelle.setText(listeStage.get(i).getLibelle());
				textDateDeb.setText(dateFormat.format(listeStage.get(i).getDateDeb()));
				textDuree.setText(String.valueOf(listeStage.get(i).getDuree()));
				paneDescr.setText(listeStage.get(i).getDesc());

				if(i==0){
					btnPrecedent.setEnabled(false);
				}
			}
		});
		btnPrecedent.setBounds(104, 431, 115, 23);
		btnPrecedent.setEnabled(false);
		contentPane.add(btnPrecedent);
		
		//Gestion du premier de la liste
		if(i==listeStage.size()-1){
			btnSuivant.setEnabled(false);
		}
		textNom.setText(listeStage.get(i).getNomE());
		textVille.setText(listeStage.get(i).getVille());
		textMail.setText(listeStage.get(i).getMail());
		textDomaine.setText(listeStage.get(i).getDomaine());
		textLibelle.setText(listeStage.get(i).getLibelle());
		textDateDeb.setText(dateFormat.format(listeStage.get(i).getDateDeb()));
		textDuree.setText(String.valueOf(listeStage.get(i).getDuree()));
		paneDescr.setText(listeStage.get(i).getDesc());
		
		JButton btnPostuler = new JButton("Postuler");
		btnPostuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stage s = listeStage.get(i);
				System.out.println(s.getId());
				
				if(sm.candidater(s,etudiant)){
					JOptionPane.showMessageDialog(null, "Votre candidature a été pris en compte");
				}else{
					JOptionPane.showMessageDialog(null, "Echec, vous êtes déjà candidat à cette offre");
				}
			}
		});
		btnPostuler.setBounds(223, 382, 121, 23);
		contentPane.add(btnPostuler);
		
	}
}
