package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Model.Entreprise;
import Model.EntrepriseModel;

import java.awt.Font;

/**
 * Fenetre permettant de gerer les entreprises par l'administrateur
 */

public class FenetreAdminEntreprise extends JFrame {

	private JPanel contentPane;

	private EntrepriseModel em = new EntrepriseModel();
	
	private JTextField textNom;
	private JTextField textAdrRue;
	private JTextField textAdrCP;
	private JTextField textAdrVille;
	private JTextField textMail;
	private JTextField textTel;
	private JTextField textSecteur;
	
	private JButton btnPrecedent;
	private JButton btnSuivant;
	
	private List<Entreprise> listeEntreprises;
	private int i=0;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private JLabel lblListeDesEntreprises;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAdminEntreprise frame = new FenetreAdminEntreprise();
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
	public FenetreAdminEntreprise() {

		listeEntreprises = em.findAll();
		
		setBounds(100, 100, 591, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nom de l'entreprise");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setBounds(137, 60, 160, 14);
		contentPane.add(label);
		
		textNom = new JTextField();
		textNom.setText((String) null);
		textNom.setColumns(10);
		textNom.setBounds(307, 57, 121, 20);
		contentPane.add(textNom);
		
		JLabel label_1 = new JLabel("Adresse (Num\u00E9ro et rue)");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(136, 91, 161, 14);
		contentPane.add(label_1);
		
		textAdrRue = new JTextField();
		textAdrRue.setText((String) null);
		textAdrRue.setColumns(10);
		textAdrRue.setBounds(307, 88, 177, 20);
		contentPane.add(textAdrRue);
		
		JLabel label_2 = new JLabel("Adresse (Code postal)");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(136, 122, 161, 14);
		contentPane.add(label_2);
		
		textAdrCP = new JTextField();
		textAdrCP.setText((String) null);
		textAdrCP.setColumns(10);
		textAdrCP.setBounds(307, 119, 70, 20);
		contentPane.add(textAdrCP);
		
		JLabel label_3 = new JLabel("Adresse (Ville)");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(136, 153, 161, 14);
		contentPane.add(label_3);
		
		textAdrVille = new JTextField();
		textAdrVille.setText((String) null);
		textAdrVille.setColumns(10);
		textAdrVille.setBounds(307, 150, 121, 20);
		contentPane.add(textAdrVille);
		
		JLabel label_4 = new JLabel("Mail du contact");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(136, 184, 161, 14);
		contentPane.add(label_4);
		
		textMail = new JTextField();
		textMail.setText((String) null);
		textMail.setColumns(10);
		textMail.setBounds(307, 181, 148, 20);
		contentPane.add(textMail);
		
		JLabel label_5 = new JLabel("T\u00E9l\u00E9phone du contact");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(136, 215, 161, 14);
		contentPane.add(label_5);
		
		textTel = new JTextField();
		textTel.setText((String) null);
		textTel.setColumns(10);
		textTel.setBounds(308, 212, 98, 20);
		contentPane.add(textTel);
		
		JLabel label_6 = new JLabel("Secteur d'activit\u00E9 de l'entreprise");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(103, 246, 194, 14);
		contentPane.add(label_6);
		
		textSecteur = new JTextField();
		textSecteur.setText((String) null);
		textSecteur.setColumns(10);
		textSecteur.setBounds(307, 243, 121, 20);
		contentPane.add(textSecteur);
		
		btnPrecedent = new JButton("Pr\u00E9c\u00E9dent");	
		btnPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i--;
				btnSuivant.setEnabled(true);
				
				textNom.setText(listeEntreprises.get(i).getNom());
				textAdrRue.setText(listeEntreprises.get(i).getAdrRue());
				textAdrCP.setText(listeEntreprises.get(i).getAdrCP());
				textAdrVille.setText(listeEntreprises.get(i).getAdrVille());
				textMail.setText(listeEntreprises.get(i).getMail());
				textTel.setText(listeEntreprises.get(i).getTel());
				textSecteur.setText(listeEntreprises.get(i).getSecteur());
				
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
		btnPrecedent.setBounds(187, 347, 115, 23);
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
				
				textNom.setText(listeEntreprises.get(i).getNom());
				textAdrRue.setText(listeEntreprises.get(i).getAdrRue());
				textAdrCP.setText(listeEntreprises.get(i).getAdrCP());
				textAdrVille.setText(listeEntreprises.get(i).getAdrVille());
				textMail.setText(listeEntreprises.get(i).getMail());
				textTel.setText(listeEntreprises.get(i).getTel());
				textSecteur.setText(listeEntreprises.get(i).getSecteur());
				
				if(i==listeEntreprises.size()-1){
					btnSuivant.setEnabled(false);
				}
				
				/*if(em.findAll().listIterator().hasNext()){
					textNom.setText(em.findAll().get(i).getNom());
					textLibelle.setText(sm.findAll().get(i).getLibelle());
				}else{
					
				}*/
			}
		});
		btnSuivant.setBounds(332, 347, 115, 23);
		contentPane.add(btnSuivant);
		
		//Gestion du premier de la liste
		if(i==listeEntreprises.size()-1){
			btnSuivant.setEnabled(false);
		}
		textNom.setText(listeEntreprises.get(i).getNom());
		textAdrRue.setText(listeEntreprises.get(i).getAdrRue());
		textAdrCP.setText(listeEntreprises.get(i).getAdrCP());
		textAdrVille.setText(listeEntreprises.get(i).getAdrVille());
		textMail.setText(listeEntreprises.get(i).getMail());
		textTel.setText(listeEntreprises.get(i).getTel());
		textSecteur.setText(listeEntreprises.get(i).getSecteur());
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int response = JOptionPane.showConfirmDialog(null,"Vous êtes sur le point de supprimer cette étudiant de façon définitive. \nEtes vous sur de vouloir continuer ?","Attention",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				
				if (response == JOptionPane.YES_OPTION) {
					Entreprise ent = listeEntreprises.get(i);
					em.delete(ent);
					
					i--;
					if(i<0){
						dispose();
					}else if(i==0){
						btnPrecedent.setEnabled(false);
						btnSuivant.setEnabled(false);
						textNom.setText(listeEntreprises.get(i).getNom());
						textAdrRue.setText(listeEntreprises.get(i).getAdrRue());
						textAdrCP.setText(listeEntreprises.get(i).getAdrCP());
						textAdrVille.setText(listeEntreprises.get(i).getAdrVille());
						textMail.setText(listeEntreprises.get(i).getMail());
						textTel.setText(listeEntreprises.get(i).getTel());
						textSecteur.setText(listeEntreprises.get(i).getSecteur());
					}else{
						textNom.setText(listeEntreprises.get(i).getNom());
						textAdrRue.setText(listeEntreprises.get(i).getAdrRue());
						textAdrCP.setText(listeEntreprises.get(i).getAdrCP());
						textAdrVille.setText(listeEntreprises.get(i).getAdrVille());
						textMail.setText(listeEntreprises.get(i).getMail());
						textTel.setText(listeEntreprises.get(i).getTel());
						textSecteur.setText(listeEntreprises.get(i).getSecteur());
					}
				}else{
					
				}
			}
		});
		btnSupprimer.setBounds(332, 310, 115, 23);
		contentPane.add(btnSupprimer);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Entreprise newEnt = new Entreprise();
				newEnt.setId(listeEntreprises.get(i).getId());
				newEnt.setNom(textNom.getText());
				newEnt.setAdrRue(textAdrRue.getText());
				newEnt.setAdrCP(textAdrCP.getText());
				newEnt.setAdrVille(textAdrVille.getText());
				newEnt.setMail(textMail.getText());
				newEnt.setTel(textTel.getText());
				newEnt.setSecteur(textSecteur.getText());
				
				if(em.updateAdmin(newEnt)){
					JOptionPane.showMessageDialog(null, "Les informations ont été mise à jour");
				}
				else{
					JOptionPane.showMessageDialog(null, "Echec de la mise à jour des informations");
				}
							
			}
			
		});
		btnModifier.setBounds(187, 310, 115, 23);
		contentPane.add(btnModifier);
		
		lblListeDesEntreprises = new JLabel("LISTE DES ENTREPRISES");
		lblListeDesEntreprises.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDesEntreprises.setForeground(Color.WHITE);
		lblListeDesEntreprises.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListeDesEntreprises.setBounds(103, 11, 399, 20);
		contentPane.add(lblListeDesEntreprises);
		
		
	}
}
