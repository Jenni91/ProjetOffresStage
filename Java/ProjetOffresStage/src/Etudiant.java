import java.util.ArrayList;
import java.util.List;

/**
 * Etudiant est la classe repr�sentant l'objet etudiant.
 * 
 */
public class Etudiant {

	private int id;
	private String nom;
	private String prenom;
	private String etabl;
	private String filiere;
	private String niveau;
	private String ville;
	private String mail;
	private String tel;
	private String mdp;
	private List<Stage> listeStages;
	
	/**
	 * Constructeur de l'objet Etudiant
	 * @param id	Id de l'etudiant
	 * @param nom	Nom de l'etudiant
	 * @param prenom	Rue de l'adresse de l'entreprise
	 * @param etabl	Nom de l'�tablissement de l'�tudiant
	 * @param filiere	Filiere de l'�tudiant
	 * @param niveau	Niveau d'�tude de l'�tudiant
	 * @param ville	Ville de l'�tudiant
	 * @param mail	Mail de l'�tudiant
	 * @param tel	Numero de telephone de l'�tudiant
	 * @param mdp	Mot de passe de l'�tudiant connect�
	 * @param listeStages	Listes des offres o� l'�tudiant a postul�
	 */
	
	public Etudiant(String nom, String prenom, String etabl, String filiere, String niveau, String ville, String mail, String tel, String mdp){
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.etabl = etabl;
		this.filiere = filiere;
		this.niveau = niveau;
		this.ville = ville;
		this.mail = mail;
		this.tel = tel;
		this.mdp = mdp;
	}
	
	public Etudiant(){
		
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEtabl() {
		return etabl;
	}

	public void setEtabl(String etabl) {
		this.etabl = etabl;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Stage> getListeStages() {
		return listeStages;
	}

	public void setListeStages(List<Stage> listeStages) {
		this.listeStages = listeStages;
	}
}
