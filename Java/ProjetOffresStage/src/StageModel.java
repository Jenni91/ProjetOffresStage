import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class StageModel {

	/**
	 * Creer un nouveau stage dans la table Stage d'après un objet Stage
	 * @param s
	 * @return
	 */
	public boolean create(Stage s){
			
			try{
				PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("INSERT into Stage(IDE, Domaine, Libelle, DateDeb, Duree, Descr) values (?,?,?,?,?,?)");
				ps.setInt(1,s.getIdE());
				ps.setString(2,s.getDomaine());
				ps.setString(3,s.getLibelle());
				ps.setDate(4,s.getDateDeb());
				ps.setInt(5,s.getDuree());
				ps.setString(6,s.getDesc());
				
				return ps.executeUpdate()>0;
				
			}catch (Exception err){
				System.out.println(err.getMessage());
				return false;
			}
	}
	
	
	/**
	 * Liste les offres et stock dans un array les donnees concernant le stage
	 * @return Un array contenant des Stages
	 */
	public List<Stage> findAll(){
		
		try{
			
			List<Stage> listStage = new ArrayList<>();
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("SELECT * FROM Stage s,Entreprise e WHERE e.id = s.ide");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Stage s = new Stage();
				
				s.setId(rs.getInt("id"));
				s.setIdE(rs.getInt("idE"));
				s.setNomE(rs.getString("nom"));
				s.setVille(rs.getString("adrVille"));
				s.setMail(rs.getString("mail"));
				s.setDomaine(rs.getString("domaine"));
				s.setLibelle(rs.getString("libelle"));
				s.setDateDeb(rs.getDate("dateDeb"));
				s.setDuree(rs.getInt("duree"));
				s.setDesc(rs.getString("descr"));	
				
				listStage.add(s);

			}
			return listStage;
			
		}catch (Exception err){
			System.out.println(err.getMessage());
			return null;
		}
	}
	
	/**
	 * Liste les offres d'une entreprise d'après son id et stock dans un array les donnees concernant le stage
	 * @return Un array contenant des Stages
	 */
	public List<Stage> findAllByIde(int idEntreprise){
		
		try{
			
			List<Stage> listStage = new ArrayList<>();
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("SELECT * FROM Stage WHERE ide = ?");
			ps.setInt(1,idEntreprise);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Stage s = new Stage();
				
				s.setId(rs.getInt("id"));
				s.setDomaine(rs.getString("domaine"));
				s.setLibelle(rs.getString("libelle"));
				s.setDateDeb(rs.getDate("dateDeb"));
				s.setDuree(rs.getInt("duree"));
				s.setDesc(rs.getString("descr"));	
				
				listStage.add(s);

			}
			return listStage;
			
		}catch (Exception err){
			System.out.println(err.getMessage());
			return null;
		}
	}
	
	/**
	 * Mettre à jour les informations d'un stage dans la base de donnée
	 * @return 
	 */
	public boolean update(Stage newS){
			try{
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("UPDATE Stage SET Domaine = ?, Libelle = ?, DateDeb = ?, Duree = ?, Descr = ? WHERE ID = ?");
			ps.setString(1,newS.getDomaine());
			ps.setString(2,newS.getLibelle());
			ps.setDate(3,newS.getDateDeb());
			ps.setInt(4,newS.getDuree());
			ps.setString(5,newS.getDesc());
			ps.setInt(6,newS.getId());
			
			return ps.executeUpdate()>0;
			
		}catch (Exception err){
			System.out.println(err.getMessage());
			return false;
		}
	}

	/**
	 * Supprimer le stage de la base de donnée d'après son id
	 * @return 
	 */
	public boolean delete(Stage stage){
		try{
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("DELETE FROM Stage WHERE id = ?");

			ps.setInt(1,stage.getId());
			
			return ps.executeUpdate()>0;
		
		}catch (Exception err){
			System.out.println(err.getMessage());
			return false;
		}
	}
	
	/**
	 * Supprimer le stage de la base de donnée d'après l'id de l'entreprise
	 * @return 
	 */
	public boolean deleteByIde(Entreprise entreprise){
		try{
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("DELETE FROM Stage WHERE ide = ?");

			ps.setInt(1,entreprise.getId());
			
			return ps.executeUpdate()>0;
		
		}catch (Exception err){
			System.out.println(err.getMessage());
			return false;
		}
	}
	
	/**
	 * Supprimer les stages expirés de la base de donnée 
	 * @return 
	 */
	public boolean deleteExpire(){
		try{
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("DELETE FROM Stage WHERE DateDeb < NOW() RETURNING id");
			ResultSet rs = ps.executeQuery();
					
			while(rs.next()){
				ps = ConnectionPostgresql.getConnection().prepareStatement("DELETE FROM Candidature WHERE ID_Stage = ?");
				ps.setInt(1,rs.getInt("id"));
				ps.executeUpdate();
			}
			
			return true;
		
		}catch (Exception err){
			System.out.println(err.getMessage());
			return false;
		}
	}
	
	/**
	 * Creer une nouvelle candidature
	 * @return 
	 */
	public boolean candidater(Stage stage, Etudiant etudiant){
		try{
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("INSERT INTO Candidature (ID_Stage, ID_Etudiant) SELECT ? , ? WHERE NOT EXISTS (SELECT ID_Stage ID_Etudiant FROM Candidature WHERE ID_Stage = ? AND ID_Etudiant = ?)");
		
			ps.setInt(1,stage.getId());
			ps.setInt(2,etudiant.getId());
			ps.setInt(3,stage.getId());
			ps.setInt(4,etudiant.getId());
			
			return ps.executeUpdate()>0;
		
		}catch (Exception err){
			System.out.println(err.getMessage());
			return false;
		}
	}
	
	/**
	 * Supprimer la candidature de la base de donnée d'après un stage et un etudiant
	 * @return 
	 */
	public boolean deleteCandidature(Stage stage, Etudiant etudiant){
		try{
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("DELETE FROM Candidature WHERE ID_Stage = ? AND ID_Etudiant = ?");
		
			ps.setInt(1,stage.getId());
			ps.setInt(2,etudiant.getId());
			
			return ps.executeUpdate()>0;
		
		}catch (Exception err){
			System.out.println(err.getMessage());
			return false;
		}
	}
	
	/**
	 * Liste les candidatures et stock dans un array les donnees concernant les stages
	 * @return Un array contenant des Stages
	 */
	public List<Stage> findAllCandidature(Etudiant etudiant){
		
		try{
			
			List<Stage> listStage = new ArrayList<>();
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("SELECT * FROM Stage s, Entreprise e, Candidature c WHERE c.ID_Etudiant = ? AND c.ID_Stage = s.id AND s.ide = e.id");
			ps.setInt(1,etudiant.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Stage s = new Stage();
				
				s.setId(rs.getInt("id"));
				s.setId(rs.getInt("id"));
				s.setIdE(rs.getInt("idE"));
				s.setNomE(rs.getString("nom"));
				s.setVille(rs.getString("adrVille"));
				s.setMail(rs.getString("mail"));
				s.setDomaine(rs.getString("domaine"));
				s.setLibelle(rs.getString("libelle"));
				s.setDateDeb(rs.getDate("dateDeb"));
				s.setDuree(rs.getInt("duree"));
				s.setDesc(rs.getString("descr"));	
				
				listStage.add(s);

			}
			return listStage;
			
		}catch (Exception err){
			System.out.println(err.getMessage());
			return null;
		}
	}
	
	/**
	 * Supprimer la candidature de la base de donnée d'après un stage
	 * @return 
	 */
	public boolean deleteCandidatureByStage(Stage stage){
		try{
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("DELETE FROM Candidature WHERE ID_Stage = ?");
		
			ps.setInt(1,stage.getId());
			
			return ps.executeUpdate()>0;
		
		}catch (Exception err){
			System.out.println(err.getMessage());
			return false;
		}
	}
	
	/**
	 * Supprimer la candidature de la base de donnée d'après un etudiant
	 * @return 
	 */
	public boolean deleteCandidatureByEtudiant(Etudiant etudiant){
		try{
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("DELETE FROM Candidature WHERE ID_Etudiant = ?");
		
			ps.setInt(1,etudiant.getId());
			
			return ps.executeUpdate()>0;
		
		}catch (Exception err){
			System.out.println(err.getMessage());
			return false;
		}
	}
}
