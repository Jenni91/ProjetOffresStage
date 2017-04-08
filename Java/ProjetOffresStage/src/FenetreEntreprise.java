import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class FenetreEntreprise extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreEtudiant frame = new FenetreEtudiant();
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
	public FenetreEntreprise(Entreprise entreprise) {
		setTitle("Espace entreprise");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 312);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Bienvenue "+ entreprise.getNom());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(170, 28, 271, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Fait par TESTU Jennifer, FOUDA Myriam, SUNNER Sema");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(121, 54, 369, 14);
		contentPane.add(label_1);
		
		JButton btnModifierMesInformations = new JButton("Modifier mes informations");
		btnModifierMesInformations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				FenetreModifEntreprise fment = new FenetreModifEntreprise(entreprise);
				fment.setVisible(true);
			}
		});
		btnModifierMesInformations.setBounds(10, 122, 212, 23);
		contentPane.add(btnModifierMesInformations);
		
		JButton btnMesStages = new JButton("Cr\u00E9er une offre");
		btnMesStages.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenetreCreaOffre fco = new FenetreCreaOffre(entreprise);
				fco.setVisible(true);
			}
		});
		btnMesStages.setBounds(243, 122, 125, 23);
		contentPane.add(btnMesStages);
		
		JButton btnConsulterLestudiants = new JButton("Consulter la liste des \u00E9tudiants");
		btnConsulterLestudiants.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenetreVoirEtudiants fve = new FenetreVoirEtudiants();
				fve.setVisible(true);
			}
		});
		btnConsulterLestudiants.setBounds(392, 122, 212, 23);
		contentPane.add(btnConsulterLestudiants);
		
		JButton button_3 = new JButton("Quitter");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		button_3.setBounds(317, 221, 140, 23);
		contentPane.add(button_3);
		
		JButton btnConsulterLaListe = new JButton("Consulter la liste de mes offres");
		btnConsulterLaListe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenetreVoirMesOffres fvmo = new FenetreVoirMesOffres(entreprise);
				fvmo.setVisible(true);
			}
		});
		btnConsulterLaListe.setBounds(200, 156, 212, 23);
		contentPane.add(btnConsulterLaListe);
		
		JButton btnSeDconnecter = new JButton("Se d\u00E9connecter");
		btnSeDconnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				FenetreLog fl = new FenetreLog();
				fl.setVisible(true);
			}
		});
		btnSeDconnecter.setBounds(155, 221, 140, 23);
		contentPane.add(btnSeDconnecter);
	}
}
