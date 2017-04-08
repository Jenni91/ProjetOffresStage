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

public class FenetreEtudiant extends JFrame {

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
	public FenetreEtudiant(Etudiant etudiant) {
		setTitle("Espace \u00E9tudiant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 284);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Bienvenue "+etudiant.getPrenom());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(155, 28, 271, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Fait par TESTU Jennifer, FOUDA Myriam, SUNNER Sema");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(106, 54, 369, 14);
		contentPane.add(label_1);
		
		JButton btnModifierMesInformations = new JButton("Modifier mes informations");
		btnModifierMesInformations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenetreModifEtudiant fme = new FenetreModifEtudiant(etudiant);
				dispose();
				fme.setVisible(true);
			}
		});
		btnModifierMesInformations.setBounds(95, 122, 184, 23);
		contentPane.add(btnModifierMesInformations);
		
		JButton buttonVoir = new JButton("Consulter les offres");
		buttonVoir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenetreVoirOffres fvo = new FenetreVoirOffres(etudiant);
				fvo.setVisible(true);
			}
		});
		buttonVoir.setBounds(303, 122, 184, 23);
		contentPane.add(buttonVoir);
		
		JButton button_3 = new JButton("Quitter");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		button_3.setBounds(305, 211, 140, 23);
		contentPane.add(button_3);
		
		JButton btnConsulterMesCandidatures = new JButton("Consulter mes candidatures");
		btnConsulterMesCandidatures.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenetreVoirCandidatures fvc = new FenetreVoirCandidatures(etudiant);
				fvc.setVisible(true);
			}
		});
		btnConsulterMesCandidatures.setBounds(186, 156, 208, 23);
		contentPane.add(btnConsulterMesCandidatures);
		
		JButton btnSeDconnecter = new JButton("Se d\u00E9connecter");
		btnSeDconnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				FenetreLog fl = new FenetreLog();
				fl.setVisible(true);
			}
		});
		btnSeDconnecter.setBounds(139, 211, 140, 23);
		contentPane.add(btnSeDconnecter);
	}
}
