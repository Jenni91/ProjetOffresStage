import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EtudiantModel {

	private StageModel sm = new StageModel();
	
	/**
	 * Creer un nouvel étudiant dans la table Etudiant d'après un objet Etudiant
	 * @param e
	 * @return
	 */
	public boolean create(Etudiant e){
		
		try{
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("INSERT into Etudiant(Nom, Prenom, Etabl, Filiere, Niveau, Ville, Mail, Tel, Mdp) values (?,?,?,?,?,?,?,?,MD5(?))");
			ps.setString(1,e.getNom());
			ps.setString(2,e.getPrenom());
			ps.setString(3,e.getEtabl());
			ps.setString(4,e.getFiliere());
			ps.setString(5,e.getNiveau());
			ps.setString(6,e.getVille());
			ps.setString(7,e.getMail());
			ps.setString(8,e.getTel());
			ps.setString(9,e.getMdp());
			
			return ps.executeUpdate()>0;
			
		}catch (Exception err){
			System.out.println(err.getMessage());
			return false;
		}
	}
	
	/**
	 * Liste les étudiants dispo et stock dans un array les donnees concernant l'étudiant
	 * @return Un array contenant des Etudiant
	 */
	public List<Etudiant> findAll(){
			
			try{
				
				List<Etudiant> listEtudiant = new ArrayList<>();
				PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("SELECT * FROM Etudiant");
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					Etudiant etu = new Etudiant();

					etu.setId(rs.getInt("id"));
					etu.setNom(rs.getString("nom"));
					etu.setPrenom(rs.getString("prenom"));
					etu.setEtabl(rs.getString("etabl"));
					etu.setFiliere(rs.getString("filiere"));
					etu.setNiveau(rs.getString("niveau"));
					etu.setVille(rs.getString("ville"));
					etu.setMail(rs.getString("mail"));
					etu.setTel(rs.getString("tel"));
					
					listEtudiant.add(etu);
					
				}
				return listEtudiant;
				
			}catch (Exception err){
				System.out.println(err.getMessage());
				return null;
			}
	}
	
	/**
	 * Verifier que le couple mail,mot de passe qui ont été entré existe dans la base de donnée
	 * @return L'objet étudiant qui a réussi à se connecter
	 */
	public Etudiant login(String mail, String mdp){
		
		Etudiant etudiant = new Etudiant();
		
		try{
			
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("SELECT * FROM Etudiant WHERE Etudiant.mail = ? AND Etudiant.mdp = MD5(?)");
			ps.setString(1,mail);
			ps.setString(2,mdp);			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next()){
				return null;
			}			
			else{
				etudiant.setId(rs.getInt(1));
				etudiant.setNom(rs.getString(2));
				etudiant.setPrenom(rs.getString(3));
				etudiant.setEtabl(rs.getString(4));
				etudiant.setFiliere(rs.getString(5));
				etudiant.setNiveau(rs.getString(6));
				etudiant.setVille(rs.getString(7));
				etudiant.setMail(rs.getString(8));
				etudiant.setTel(rs.getString(9));
				etudiant.setMdp(rs.getString(10));
				etudiant.setListeStages(new StageModel().findAllCandidature(etudiant));
				
				
				System.out.println("Nom : "+etudiant.getNom()+" Prenom : "+etudiant.getPrenom()+" Mail : "+etudiant.getMail()+" Mdp : "+etudiant.getMdp());								
			}			
			return etudiant;
			
		}catch (Exception err){
			System.out.println(err.getMessage());
			return null;
		}
		
	}
		
	/**
	 * Mettre à jour les informations de l'étudiant dans la base de donnée
	 * @return 
	 */
	public boolean update(Etudiant newE){
		try{
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("UPDATE Etudiant SET Nom = ?, Prenom = ?, Etabl = ?, Filiere = ?, Niveau = ?, Ville = ?, Mail = ?, Tel = ?, mdp = MD5(?) WHERE ID = ?");
			ps.setString(1,newE.getNom());
			ps.setString(2,newE.getPrenom());
			ps.setString(3,newE.getEtabl());
			ps.setString(4,newE.getFiliere());
			ps.setString(5,newE.getNiveau());
			ps.setString(6,newE.getVille());
			ps.setString(7,newE.getMail());
			ps.setString(8,newE.getTel());			
			ps.setString(9,newE.getMdp());
			ps.setInt(10,newE.getId());
			
			return ps.executeUpdate()>0;
		
		}catch (Exception err){
			System.out.println(err.getMessage());
			return false;
		}
	}
	
	/**
	 * Mettre à jour les informations de l'étudiant dans la base de donnée sans changer le mot de passe
	 * @return 
	 */
	public boolean updateAdmin(Etudiant newE){
		try{
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("UPDATE Etudiant SET Nom = ?, Prenom = ?, Etabl = ?, Filiere = ?, Niveau = ?, Ville = ?, Mail = ?, Tel = ? WHERE ID = ?");
			ps.setString(1,newE.getNom());
			ps.setString(2,newE.getPrenom());
			ps.setString(3,newE.getEtabl());
			ps.setString(4,newE.getFiliere());
			ps.setString(5,newE.getNiveau());
			ps.setString(6,newE.getVille());
			ps.setString(7,newE.getMail());
			ps.setString(8,newE.getTel());			
			ps.setInt(9,newE.getId());
			
			return ps.executeUpdate()>0;
		
		}catch (Exception err){
			System.out.println(err.getMessage());
			return false;
		}
	}
	
	/**
	 * Supprimer l'étudiant de la base de donnée d'après son id
	 * @return 
	 */
	public boolean delete(Etudiant etudiant){
		try{
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("DELETE FROM Etudiant WHERE id = ?");
			ps.setInt(1,etudiant.getId());
			
			ps.executeUpdate();
			
			sm.deleteCandidatureByEtudiant(etudiant);
			
			return true;
		
		}catch (Exception err){
			System.out.println(err.getMessage());
			return false;
		}
	}
	
}
