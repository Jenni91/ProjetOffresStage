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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import com.toedter.calendar.JDateChooser;

/**
 * Fenetre permettant à l'entreprise connectée de gerer ses offres de stages
 */

public class FenetreVoirMesOffres extends JFrame {

	private JPanel contentPane;
	private JTextField textLibelle;
	private JTextField textDuree;
	private JComboBox cbDomaine;
	
	private JButton btnPrecedent;
	private JButton btnSuivant;

	StageModel sm = new StageModel();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
	private List<Stage> listeStage;
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
	public FenetreVoirMesOffres(Entreprise entreprise) {
		
		entreprise.setListeStages(sm.findAllByIde(entreprise.getId()));
		listeStage = entreprise.getListeStages();
		
		setTitle("Consultation de mes offres de stage");
		setBounds(100, 100, 518, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreationDuneEntreprise = new JLabel("CONSULTATION DE MES OFFRES DE STAGE");
		lblCreationDuneEntreprise.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreationDuneEntreprise.setBounds(10, 5, 482, 20);
		lblCreationDuneEntreprise.setForeground(Color.WHITE);
		lblCreationDuneEntreprise.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblCreationDuneEntreprise);
		
		JLabel lblAdressecodePostal = new JLabel("Libell\u00E9 de l'offre");
		lblAdressecodePostal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressecodePostal.setForeground(Color.WHITE);
		lblAdressecodePostal.setBounds(80, 95, 161, 14);
		contentPane.add(lblAdressecodePostal);
		
		JLabel lblAdresseville = new JLabel("Date de d\u00E9but de stage");
		lblAdresseville.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresseville.setForeground(Color.WHITE);
		lblAdresseville.setBounds(80, 126, 161, 14);
		contentPane.add(lblAdresseville);
		
		JLabel lblMailDuContact = new JLabel("Dur\u00E9e en mois");
		lblMailDuContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMailDuContact.setForeground(Color.WHITE);
		lblMailDuContact.setBounds(80, 157, 161, 14);
		contentPane.add(lblMailDuContact);
		
		JLabel lblSecteurDactivitDe = new JLabel("Description de l'offre");
		lblSecteurDactivitDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSecteurDactivitDe.setForeground(Color.WHITE);
		lblSecteurDactivitDe.setBounds(47, 188, 194, 14);
		contentPane.add(lblSecteurDactivitDe);
		
		textLibelle = new JTextField();
		textLibelle.setColumns(10);
		textLibelle.setBounds(251, 92, 229, 20);
		contentPane.add(textLibelle);
		
		textDuree = new JTextField();
		textDuree.setColumns(10);
		textDuree.setBounds(251, 154, 148, 20);
		contentPane.add(textDuree);
		
		JEditorPane paneDescr = new JEditorPane();
		paneDescr.setBounds(251, 185, 229, 168);
		contentPane.add(paneDescr);
		
		JComboBox cbDomaine = new JComboBox(DomaineOffre.values());
		cbDomaine.setBounds(251, 64, 177, 20);
		contentPane.add(cbDomaine);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(251, 123, 148, 20);
		dateChooser.setDateFormatString("d MMMM yyyy");
		contentPane.add(dateChooser);
		
		JLabel label = new JLabel("Domaine de l'offre");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setBounds(132, 67, 109, 14);
		contentPane.add(label);
		
		JButton btnEnvoyer = new JButton("Modifier");
		btnEnvoyer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Stage newStage = new Stage();
				newStage.setId(listeStage.get(i).getId());
				newStage.setDomaine(cbDomaine.getSelectedItem().toString());
				newStage.setLibelle(textLibelle.getText());
				newStage.setDateDeb(new java.sql.Date(dateChooser.getDate().getTime()));
				newStage.setDuree(Integer.parseInt(textDuree.getText()));
				newStage.setDesc(paneDescr.getText());

				
				if(sm.update(newStage)){
					JOptionPane.showMessageDialog(null, "Les informations du stage ont été mise à jour");
					
					listeStage = sm.findAllByIde(entreprise.getId());
					
				}
				else{
					JOptionPane.showMessageDialog(null, "Echec de la mise à jou des informations du stage");
				}
							
			}
			
		});
		btnEnvoyer.setBounds(132, 404, 108, 23);
		contentPane.add(btnEnvoyer);
		
		JButton btnAnnuler = new JButton("Supprimer");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int response = JOptionPane.showConfirmDialog(null,"Vous êtes sur le point de supprimer cette offre de façon définitive. \nEtes vous sur de vouloir continuer ?","Attention",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				
				if (response == JOptionPane.YES_OPTION) {
					Stage s = listeStage.get(i);
					sm.delete(s);
					sm.deleteCandidatureByStage(s);
					
					i--;
					if(i<0){
						dispose();
					}else if(i==0){
						btnPrecedent.setEnabled(false);
						btnSuivant.setEnabled(false);
						cbDomaine.setSelectedItem(listeStage.get(i).getDomaine());
						textLibelle.setText(listeStage.get(i).getLibelle());
						dateChooser.setDate(listeStage.get(i).getDateDeb());
						textDuree.setText(String.valueOf(listeStage.get(i).getDuree()));
						paneDescr.setText(listeStage.get(i).getDesc());
					}else{
						cbDomaine.setSelectedItem(listeStage.get(i).getDomaine());
						textLibelle.setText(listeStage.get(i).getLibelle());
						dateChooser.setDate(listeStage.get(i).getDateDeb());
						textDuree.setText(String.valueOf(listeStage.get(i).getDuree()));
						paneDescr.setText(listeStage.get(i).getDesc());
					}
				}else{
					
				}
			}
		});
		btnAnnuler.setBounds(250, 404, 108, 23);
		contentPane.add(btnAnnuler);
		
		btnPrecedent = new JButton("Pr\u00E9c\u00E9dent");
		btnPrecedent.setEnabled(false);
		btnPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i--;
				btnSuivant.setEnabled(true);
				
				cbDomaine.getModel().setSelectedItem(listeStage.get(i).getDomaine());
				textLibelle.setText(listeStage.get(i).getLibelle());
				dateChooser.setDate(listeStage.get(i).getDateDeb());
				textDuree.setText(String.valueOf(listeStage.get(i).getDuree()));
				paneDescr.setText(listeStage.get(i).getDesc());
				
				if(i==0){
					btnPrecedent.setEnabled(false);
				}
				
			}
		});
		btnPrecedent.setBounds(63, 449, 115, 23);
		contentPane.add(btnPrecedent);
		
		btnSuivant = new JButton("Suivant");
		btnSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i++;
				btnPrecedent.setEnabled(true);
				
				cbDomaine.getModel().setSelectedItem(listeStage.get(i).getDomaine());
				textLibelle.setText(listeStage.get(i).getLibelle());
				dateChooser.setDate(listeStage.get(i).getDateDeb());
				textDuree.setText(String.valueOf(listeStage.get(i).getDuree()));
				paneDescr.setText(listeStage.get(i).getDesc());
				
				if(i==listeStage.size()-1){
					btnSuivant.setEnabled(false);
				}
				
			}
		});
		btnSuivant.setBounds(188, 449, 115, 23);
		contentPane.add(btnSuivant);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnFermer.setBounds(313, 449, 115, 23);
		contentPane.add(btnFermer);
		
		//Gestion du premier de la liste
		if(i==listeStage.size()-1){
			btnSuivant.setEnabled(false);
		}
		
		cbDomaine.getModel().setSelectedItem(listeStage.get(i).getDomaine());
		textLibelle.setText(listeStage.get(i).getLibelle());
		dateChooser.setDate(listeStage.get(i).getDateDeb());
		textDuree.setText(String.valueOf(listeStage.get(i).getDuree()));
		paneDescr.setText(listeStage.get(i).getDesc());
	}
}
