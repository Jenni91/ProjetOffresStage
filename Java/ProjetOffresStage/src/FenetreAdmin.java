import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 300);
		contentPane = new JPanel();
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
		btnSupprimerLesOffres.setBounds(216, 210, 242, 23);
		contentPane.add(btnSupprimerLesOffres);
		
		JButton btnConsulterLaListe = new JButton("Consulter la liste des entreprises");
		btnConsulterLaListe.setBounds(20, 143, 214, 23);
		contentPane.add(btnConsulterLaListe);
		
		JButton btnConsulterLaListe_1 = new JButton("Consulter la liste des \u00E9tudiants");
		btnConsulterLaListe_1.setBounds(244, 143, 214, 23);
		contentPane.add(btnConsulterLaListe_1);
		
		JButton btnConsulterLaListe_2 = new JButton("Consulter la liste des stages");
		btnConsulterLaListe_2.setBounds(368, 91, 214, 23);
		contentPane.add(btnConsulterLaListe_2);
		
		
	}
}
