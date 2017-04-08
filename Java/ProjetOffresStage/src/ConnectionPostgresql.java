import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionPostgresql {

	private static String url = "//localhost:5432/gestionStages";
	private static String identifiant = "postgres";
	private static String mdp = "1234";
	
	
	public static Connection getConnection(){

		Connection con = null;
		
		try{
			
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:postgresql:"+url,identifiant,mdp);
			
			Statement st = con.createStatement();

			//Verifie si la table Entreprise existe sinon on la crée
            st.executeUpdate( "CREATE TABLE if not exists Entreprise (ID serial not null primary key, Nom varchar(50), AdrRue varchar(50), AdrCP varchar(10), AdrVille varchar(50), Mail varchar(50), Tel varchar(20), Secteur varchar(50), Mdp varchar(50))" );
			//Verifie si la table Stage existe sinon on la crée
            st.executeUpdate( "CREATE TABLE if not exists Stage (ID serial not null primary key, IDE int, Domaine varchar(50), Libelle varchar(50), DateDeb date, Duree int, Descr varchar(50))" );
            //Verifie si la table Stage existe sinon on la crée 
            st.executeUpdate( "CREATE TABLE if not exists Etudiant (ID serial not null primary key, Nom varchar(50), Prenom varchar(50), Etabl varchar(50), Filiere varchar(50), Niveau varchar(50), Ville varchar(50), Mail varchar(50), Tel varchar(50), Mdp varchar(50))" );
            //Verifie si la table Candidature existe sinon on la crée
            st.executeUpdate( "CREATE TABLE if not exists Candidature (ID_Stage int, ID_Etudiant int)" );
            
		}catch(Exception e){
			System.err.println(e);
			con = null;
		}
		return con;
	}

	
	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		ConnectionPostgresql.url = url;
	}

	public static String getIdentifiant() {
		return identifiant;
	}

	public static void setIdentifiant(String identifiant) {
		ConnectionPostgresql.identifiant = identifiant;
	}

	public static String getMdp() {
		return mdp;
	}

	public static void setMdp(String mdp) {
		ConnectionPostgresql.mdp = mdp;
	}
	
	
	
}
