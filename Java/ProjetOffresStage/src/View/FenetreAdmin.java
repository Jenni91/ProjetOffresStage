package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.StageModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

/**
 * Fenetre d'accueil de l'administrateur
 */

public class FenetreAdmin extends JFrame {

	private JPanel contentPane;
	private StageModel sm = new StageModel();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAdmin frame = new FenetreAdmin();
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
	public FenetreAdmin() {
		setTitle("Espace administrateur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 285);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSupprimerLesOffres = new JButton("Supprimer les offres d\u00E9pass\u00E9es");
		btnSupprimerLesOffres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				
				int response = JOptionPane.showConfirmDialog(null,"Vous êtes sur le point de nettoyer la base de données des offres de stages dépassées. \nEtes vous sur de vouloir continuer ?","Attention",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				
				if (response == JOptionPane.YES_OPTION) {
					if(sm.deleteExpire()){
						JOptionPane.showMessageDialog(null, "Les offres dépassées ont été supprimé");
					}else{
						JOptionPane.showMessageDialog(null, "Echec des suppressions");
					}
				}

			}
		});
		btnSupprimerLesOffres.setBounds(324, 127, 237, 23);
		contentPane.add(btnSupprimerLesOffres);
		
		JButton btnConsulterLaListe = new JButton("Consulter la liste des entreprises");
		btnConsulterLaListe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				FenetreAdminEntreprise fae = new FenetreAdminEntreprise();
				fae.setVisible(true);
			}
		});
		btnConsulterLaListe.setBounds(57, 93, 242, 23);
		contentPane.add(btnConsulterLaListe);
		
		JButton btnConsulterLaListe_1 = new JButton("Consulter la liste des \u00E9tudiants");
		btnConsulterLaListe_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				FenetreAdminEtudiant fae = new FenetreAdminEtudiant();
				fae.setVisible(true);
			}
		});
		btnConsulterLaListe_1.setBounds(324, 93, 237, 23);
		contentPane.add(btnConsulterLaListe_1);
		
		JButton btnConsulterLaListe_2 = new JButton("Consulter la liste des stages");
		btnConsulterLaListe_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				FenetreAdminStage fas = new FenetreAdminStage();
				fas.setVisible(true);
			}
		});
		btnConsulterLaListe_2.setBounds(57, 127, 242, 23);
		contentPane.add(btnConsulterLaListe_2);
		
		JButton btnSeDconnecter = new JButton("Se d\u00E9connecter");
		btnSeDconnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				FenetreLog fl = new FenetreLog();
				fl.setVisible(true);
			}
		});
		btnSeDconnecter.setBounds(158, 212, 140, 23);
		contentPane.add(btnSeDconnecter);
		
		JButton button_1 = new JButton("Quitter");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		button_1.setBounds(324, 212, 140, 23);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("CONSULTATION DE MES CANDIDATURES");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(94, 11, 399, 20);
		contentPane.add(label);
		
		
	}
}
