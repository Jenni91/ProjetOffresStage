import java.util.ArrayList;
import java.util.List;

/**
 * Entreprise est la classe représentant l'objet entreprise.
 * 
 */
public class Entreprise {

	private int id;
	private String nom;
	private String adrRue;
	private String adrCP;
	private String adrVille;
	private String mail;
	private String tel;
	private String secteur;
	private String mdp;
	private List<Stage> listeStages;
	
	/**
	 * Constructeur de l'objet Entreprise
	 * @param id	Id de l'entreprise
	 * @param nom	Nom de l'entreprise
	 * @param adrRue	Rue de l'adresse de l'entreprise
	 * @param adrCP	Code postal de l'adresse de l'entreprise
	 * @param adrVille	Ville de l'adresse de l'entreprise
	 * @param mail	Mail de l'entreprise
	 * @param tel	Numero de telephone de l'entreprise
	 * @param secteur	Secteur d'activité de l'entreprise
	 * @param mdp	Mot de passe de l'entreprise connecté
	 * @param listeStages	Liste des offres de stages de l'entreprise
	 */
	
	public Entreprise(String nom, String adrRue, String adrCP, String adrVille, String mail, String tel, String secteur, String mdp){
		super();
		this.nom = nom;
		this.adrRue = adrRue;
		this.adrCP = adrCP;
		this.adrVille = adrVille;
		this.mail = mail;
		this.tel = tel;
		this.secteur = secteur;
		this.mdp = mdp;
	}
	
	public Entreprise(){
		
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

	public String getAdrRue() {
		return adrRue;
	}

	public void setAdrRue(String adrRue) {
		this.adrRue = adrRue;
	}

	public String getAdrCP() {
		return adrCP;
	}

	public void setAdrCP(String adrCP) {
		this.adrCP = adrCP;
	}

	public String getAdrVille() {
		return adrVille;
	}

	public void setAdrVille(String adrVille) {
		this.adrVille = adrVille;
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

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
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
