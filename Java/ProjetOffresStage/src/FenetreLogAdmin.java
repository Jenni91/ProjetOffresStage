import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class FenetreLogAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textIdentifiant;
	private JPasswordField passwordField;

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
	public FenetreLogAdmin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textIdentifiant = new JTextField();
		textIdentifiant.setBounds(167, 85, 123, 20);
		contentPane.add(textIdentifiant);
		textIdentifiant.setColumns(10);
		
		JLabel lblIdentifiant = new JLabel("Identifiant");
		lblIdentifiant.setBounds(167, 60, 123, 14);
		contentPane.add(lblIdentifiant);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(167, 116, 123, 14);
		contentPane.add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(167, 141, 123, 20);
		contentPane.add(passwordField);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				if(textIdentifiant.getText().equals("admin")&&passwordField.getText().equals("admin")){
					dispose();
					FenetreAdmin fa = new FenetreAdmin();
					fa.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Vos identifiants sont incorrectes.");
				}

			}
		});
		btnValider.setBounds(137, 194, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				dispose();
				FenetreLog fl = new FenetreLog();
				fl.setVisible(true);
			}
		});
		btnAnnuler.setBounds(236, 194, 89, 23);
		contentPane.add(btnAnnuler);
	}
}
