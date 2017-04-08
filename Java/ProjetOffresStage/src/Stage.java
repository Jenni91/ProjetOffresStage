import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Stage est la classe représentant l'objet stage.
 * 
 */
public class Stage {

	private int id;
	private int idE;
	private String nomE;
	private String ville;
	private String mail;
	private String domaine;
	private String libelle;
	private Date dateDeb;
	private int duree;
	private String desc;
	
	/**
	 * Constructeur de l'objet Stage
	 * @param id	ID de l'offre de stage
	 * @param idE	ID de l'entreprise qui soumet l'offre de stage
	 * @param nomE	Nom de l'entreprise
	 * @param ville	Ville de l'entreprise
	 * @param domaine	Domaine de l'offre de stage
	 * @param libelle	Titre de l'offre de stage
	 * @param dateDeb	Date du début de stage
	 * @param duree 	Duree du stage
	 * @param desc  	Description de l'offre de stage
	 */
	
	public Stage(int idE, String domaine, String libelle, Date dateDeb, int duree, String desc){
		
		super();
		this.idE = idE;
		this.domaine = domaine;
		this.libelle = libelle;
		this.dateDeb = dateDeb;
		this.duree = duree;
		this.desc = desc;
	}
	
	public Stage(){
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomE() {
		return nomE;
	}

	public void setNomE(String nomE) {
		this.nomE = nomE;
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
	
	public int getIdE() {
		return idE;
	}

	public void setIdE(int idE) {
		this.idE = idE;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
