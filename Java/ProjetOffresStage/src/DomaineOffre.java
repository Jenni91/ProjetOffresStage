
/**
 * Enumeration des domaines afin de les afficher sous forme de liste dans l'interface
 *
 */
public enum DomaineOffre {
	
	Agroalimentaire("Agroalimentaire"), 
	BanqueAssu("Banque / Assurance"), 
	BTP("BTP / Mat�riaux de construction"),
	Chimie("Chimie"),
	Commerce("Commerce / N�goce / Distribution"),
	Edition("Edition / Communication / Multim�dia"),
	Elec("Electronique / Electricit�"),
	Etude("Etudes et conseils"),
	Sante("Sant�"),
	Info("Informatique / T�l�com"),
	Metal("M�talurgie"),
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
