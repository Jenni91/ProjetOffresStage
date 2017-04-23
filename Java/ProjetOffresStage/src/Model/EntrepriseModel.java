package Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EntrepriseModel {

	private StageModel sm = new StageModel();
	
	/**
	 * Creer une nouvelle entreprise dans la table Entreprise d'après un objet Entreprise
	 * @param e
	 * @return
	 */
	public boolean create(Entreprise e){
		
		try{
			PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("INSERT into Entreprise(Nom, AdrRue, AdrCP, AdrVille, Mail, Tel, Secteur, Mdp) values (?,?,?,?,?,?,?,MD5(?))");
			ps.setString(1,e.getNom());
			ps.setString(2,e.getAdrRue());
			ps.setString(3,e.getAdrCP());
			ps.setString(4,e.getAdrVille());
			ps.setString(5,e.getMail());
			ps.setString(6,e.getTel());
			ps.setString(7,e.getSecteur());
			ps.setString(8,e.getMdp());
			
			return ps.executeUpdate()>0;
			
		}catch (Exception err){
			System.out.println(err.getMessage());
			return false;
		}
	}
	
	/**
	 * Liste les stages d'une entreprises et stock dans un array les donnees concernant l'entreprise
	 * @return Un array contenant des Entreprises
	 */
		public List<Entreprise> findAll(){
			
			try{
				
				List<Entreprise> listStage = new ArrayList<>();
				PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("SELECT * FROM Entreprise, Stage WHERE Entreprise.ID = Stage.IDE");
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					Entreprise ent = new Entreprise();
					
					ent.setId(rs.getInt("id"));
					ent.setNom(rs.getString("Nom"));
					ent.setAdrRue(rs.getString("AdrRue"));
					ent.setAdrCP(rs.getString("AdrCP"));
					ent.setAdrVille(rs.getString("AdrVille"));
					ent.setMail(rs.getString("Mail"));
					ent.setTel(rs.getString("Tel"));
					ent.setSecteur(rs.getString("Secteur"));
					
					listStage.add(ent);
					
				}
				return listStage;
				
			}catch (Exception err){
				System.out.println(err.getMessage());
				return null;
			}
		}
		
		/**
		 * Verifier que le couple mail,mot de passe qui ont été entré existe dans la base de donnée
		 * @return L'objet entreprise qui a réussi à se connecter
		 */
		public Entreprise login(String mail, String mdp){
			
			Entreprise entreprise = new Entreprise();
			
			try{
				
				PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("SELECT * FROM Entreprise WHERE Entreprise.mail = ? AND Entreprise.mdp = MD5(?)");
				ps.setString(1,mail);
				ps.setString(2,mdp);			
				ResultSet rs = ps.executeQuery();
				
				if(!rs.next()){
					return null;
				}			
				else{
					entreprise.setId(rs.getInt(1));
					entreprise.setNom(rs.getString(2));
					entreprise.setAdrRue(rs.getString(3));
					entreprise.setAdrCP(rs.getString(4));
					entreprise.setAdrVille(rs.getString(5));
					entreprise.setMail(rs.getString(6));
					entreprise.setTel(rs.getString(7));
					entreprise.setSecteur(rs.getString(8));
					entreprise.setMdp(rs.getString(9));
					entreprise.setListeStages(new StageModel().findAllByIde(entreprise.getId()));
					
					System.out.println("ID : "+entreprise.getId() + " Nom : "+entreprise.getNom()+" Secteur : "+entreprise.getSecteur()+" Mail : "+entreprise.getMail()+" Mdp : "+entreprise.getMdp());								
				}			
				return entreprise;
				
			}catch (Exception err){
				System.out.println(err.getMessage());
				return null;
			}
			
		}
		
		/**
		 * Mettre à jour les informations de l'entreprise dans la base de donnée
		 * @return 
		 */
		public boolean update(Entreprise newE){
				try{
				PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("UPDATE Entreprise SET nom = ?, adrRue = ?, adrCP = ?, adrVille = ?, mail = ?, tel = ?, secteur = ?, mdp = MD5(?) WHERE ID = ?");
				ps.setString(1,newE.getNom());
				ps.setString(2,newE.getAdrRue());
				ps.setString(3,newE.getAdrCP());
				ps.setString(4,newE.getAdrVille());
				ps.setString(5,newE.getMail());
				ps.setString(6,newE.getTel());
				ps.setString(7,newE.getSecteur());
				ps.setString(8,newE.getMdp());
				ps.setInt(9,newE.getId());
				
				return ps.executeUpdate()>0;
				
			}catch (Exception err){
				System.out.println(err.getMessage());
				return false;
			}
		}
		
		/**
		 * Mettre à jour les informations de l'entreprise dans la base de donnée sans changer le mot de passe
		 * @return 
		 */
		public boolean updateAdmin(Entreprise newE){
				try{
				PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("UPDATE Entreprise SET nom = ?, adrRue = ?, adrCP = ?, adrVille = ?, mail = ?, tel = ?, secteur = ? WHERE ID = ?");
				ps.setString(1,newE.getNom());
				ps.setString(2,newE.getAdrRue());
				ps.setString(3,newE.getAdrCP());
				ps.setString(4,newE.getAdrVille());
				ps.setString(5,newE.getMail());
				ps.setString(6,newE.getTel());
				ps.setString(7,newE.getSecteur());
				ps.setInt(8,newE.getId());
				
				return ps.executeUpdate()>0;
				
			}catch (Exception err){
				System.out.println(err.getMessage());
				return false;
			}
		}

		/**
		 * Supprimer l'entreprise de la base de donnée d'après son id
		 * @return 
		 */
		public boolean delete(Entreprise entreprise){
			try{
				PreparedStatement ps = ConnectionPostgresql.getConnection().prepareStatement("DELETE FROM Entreprise WHERE id = ?");

				ps.setInt(1,entreprise.getId());
				ps.executeUpdate();
				
				sm.deleteByIde(entreprise);
				
				return true;
			
			}catch (Exception err){
				System.out.println(err.getMessage());
				return false;
			}
		}
}
