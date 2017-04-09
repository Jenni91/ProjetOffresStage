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

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import com.toedter.calendar.JDateChooser;

/**
 * Fenetre permettant de créer une offre de stage
 */

public class FenetreCreaOffre extends JFrame {

	private JPanel contentPane;
	private JTextField textLibelle;
	private JTextField textDuree;

	StageModel sm = new StageModel();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
	
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
	public FenetreCreaOffre(Entreprise entreprise) {
		setTitle("Saisie d'une offre de stage");
		setBounds(100, 100, 518, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreationDuneEntreprise = new JLabel("SAISIE D'UNE OFFRE DE STAGE");
		lblCreationDuneEntreprise.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreationDuneEntreprise.setBounds(109, 5, 272, 20);
		lblCreationDuneEntreprise.setForeground(Color.WHITE);
		lblCreationDuneEntreprise.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblCreationDuneEntreprise);
		
		JLabel lblAdressenumroEt = new JLabel("Domaine de l'offre");
		lblAdressenumroEt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdressenumroEt.setForeground(Color.WHITE);
		lblAdressenumroEt.setBounds(80, 64, 161, 14);
		contentPane.add(lblAdressenumroEt);
		
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
		lblSecteurDactivitDe.setBounds(47, 191, 194, 14);
		contentPane.add(lblSecteurDactivitDe);
		
		textLibelle = new JTextField();
		textLibelle.setColumns(10);
		textLibelle.setBounds(251, 92, 229, 20);
		contentPane.add(textLibelle);
		
		textDuree = new JTextField();
		textDuree.setColumns(10);
		textDuree.setBounds(251, 154, 148, 20);
		contentPane.add(textDuree);
		
		JComboBox cbDomaine = new JComboBox(DomaineOffre.values());
		cbDomaine.setBounds(251, 61, 229, 20);
		contentPane.add(cbDomaine);
		
		JEditorPane paneDescr = new JEditorPane();
		paneDescr.setBounds(251, 188, 229, 168);
		contentPane.add(paneDescr);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(251, 123, 172, 20);
		dateChooser.setDateFormatString("d MMMM yyyy");
		contentPane.add(dateChooser);
		
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Enregistrer les données dans la BDD
				Stage s = new Stage();
				
				s.setIdE(entreprise.getId());
				s.setDomaine(cbDomaine.getSelectedItem().toString());
				s.setLibelle(textLibelle.getText());
				s.setDateDeb(new java.sql.Date(dateChooser.getDate().getTime()));
				s.setDuree(Integer.parseInt(textDuree.getText()));
				s.setDesc(paneDescr.getText());
				
				if(sm.create(s)){
					JOptionPane.showMessageDialog(null, "Votre offre a été ajouté");
				}
				else
					JOptionPane.showMessageDialog(null, "Echec de l'ajout de l'offre");
			
				setVisible(false);
			}
		});
		btnEnvoyer.setBounds(150, 400, 89, 23);
		contentPane.add(btnEnvoyer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnAnnuler.setBounds(249, 400, 89, 23);
		contentPane.add(btnAnnuler);
		
	}
}
