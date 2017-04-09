import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window;

/**
 * Fenetre permettant de modifier les informations de la base de données
 */

public class FenetreConnection extends JFrame {

	private JPanel contentPane;
	private JTextField textUrl;
	private JTextField textIdentifiant;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreConnection frame = new FenetreConnection();
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
	public FenetreConnection() {
		setTitle("Connection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 333);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setForeground(Color.WHITE);
		lblUrl.setBounds(93, 82, 82, 14);
		contentPane.add(lblUrl);
		
		JLabel lblIdentifiant = new JLabel("Identifiant");
		lblIdentifiant.setForeground(Color.WHITE);
		lblIdentifiant.setBounds(93, 128, 82, 14);
		contentPane.add(lblIdentifiant);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setForeground(Color.WHITE);
		lblMotDePasse.setBounds(93, 175, 82, 14);
		contentPane.add(lblMotDePasse);
		
		textUrl = new JTextField();
		textUrl.setBounds(185, 79, 247, 20);
		contentPane.add(textUrl);
		textUrl.setColumns(10);
		textUrl.setText(ConnectionPostgresql.getUrl());
		
		textIdentifiant = new JTextField();
		textIdentifiant.setBounds(185, 125, 247, 20);
		contentPane.add(textIdentifiant);
		textIdentifiant.setColumns(10);
		textIdentifiant.setText(ConnectionPostgresql.getIdentifiant());
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnAnnuler.setBounds(114, 232, 110, 23);
		contentPane.add(btnAnnuler);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(185, 172, 247, 20);
		contentPane.add(passwordField);
		passwordField.setText(ConnectionPostgresql.getMdp());
		
		JButton btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConnectionPostgresql.setUrl(textUrl.getText());
				ConnectionPostgresql.setIdentifiant(textIdentifiant.getText());
				ConnectionPostgresql.setMdp(passwordField.getText());
				setVisible(false);
			}
		});
		btnValider.setBounds(299, 232, 110, 23);
		contentPane.add(btnValider);
		
		
		JLabel lblConnection = new JLabel("Connection");
		lblConnection.setForeground(Color.WHITE);
		lblConnection.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnection.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConnection.setBounds(93, 31, 339, 14);
		contentPane.add(lblConnection);
	}
}
