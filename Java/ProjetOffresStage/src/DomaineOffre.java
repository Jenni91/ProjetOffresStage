
/**
 * Enumeration des domaines afin de les afficher sous forme de liste dans l'interface
 *
 */
public enum DomaineOffre {
	
	Agroalimentaire("Agroalimentaire"), 
	BanqueAssu("Banque / Assurance"), 
	BTP("BTP / Matériaux de construction"),
	Chimie("Chimie"),
	Commerce("Commerce / Négoce / Distribution"),
	Edition("Edition / Communication / Multimédia"),
	Elec("Electronique / Electricité"),
	Etude("Etudes et conseils"),
	Sante("Santé"),
	Info("Informatique / Télécom"),
	Metal("Métalurgie"),
	Plact("Plastique"),
	Services("Services aux entreprises"),
	Textile("Textile / Habillement / Chaussure"),
	Logi("Logistique / Transport");
	
	private String nom = "";
	
	DomaineOffre(String nom){
		this.nom = nom;
	}
	
	public String toString(){
	    return nom;
	}
}
