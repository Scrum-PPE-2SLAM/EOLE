import java.util.ArrayList;
import java.sql.*;


public class Bdd {
	ArrayList<String> listeParticipant = new ArrayList<String>();
	ArrayList<String> listeRegate = new ArrayList<String>();
	ArrayList<String> listeType= new ArrayList<String>();
	ArrayList<String> listeDateRegate= new ArrayList<String>();
	ArrayList<String> listeLieuDepart= new ArrayList<String>();
	ArrayList<String> listeLieuArrivee= new ArrayList<String>();
	ArrayList<Integer> listeDistance= new ArrayList<Integer>();
	private static String url ="jdbc:mysql://localhost:3306/eole";
	private static String user ="root";
	private static String password = "";
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	private static int res;
	
	
	
	
	public Bdd() throws SQLException{
		Connexion();
		
	}

	public void Connexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			System.out.println("connexion établie");
			st = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialisation() throws SQLException{
		String sql = "SELECT * FROM participant";
		rs = st.executeQuery(sql);
		listeParticipant = new ArrayList<String>();
		while (rs.next()){
			listeParticipant.add(rs.getString(2));
		}
		
		String sql2 = "SELECT * FROM regate";
		rs = st.executeQuery(sql2);
		listeRegate = new ArrayList<String>();
		
		while (rs.next()){
			listeRegate.add(rs.getString(2));
			listeDateRegate.add(rs.getString(3));
			listeLieuDepart.add(rs.getString(4));
			listeLieuArrivee.add(rs.getString(5));
			listeDistance.add(rs.getInt(6)); 
		}
		deconnexion();
		System.out.println("regates : " + listeRegate.size() + "; participants : " + listeParticipant.size());
		
		
	}
	
	public void miseAJour(){
		
		try {
			
			String sql = "SELECT * FROM participant";
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				listeParticipant.add(rs.getString(2));
			}
			
			/////// fonction remove
			remove(listeParticipant);
			remove(listeRegate);
			remove(listeDateRegate);
			remove(listeLieuDepart);
			remove(listeLieuArrivee);
			remove(listeDistance);
			
			
			
			String sql2 = "SELECT * FROM regate";
			rs = st.executeQuery(sql2);
			
			while (rs.next()){
				
				listeRegate.add(rs.getString(2));
				listeDateRegate.add(rs.getString(3));
				listeLieuDepart.add(rs.getString(4));
				listeLieuArrivee.add(rs.getString(5));
				listeDistance.add(rs.getInt(6)); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void remove(ArrayList maListe){
		while (maListe.size() > 0){
			maListe.remove(0);
		}
		
	}
		
	public void deconnexion(){
		try {
			con.close();
			st.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connexion fermé");
	}
		
	public void reqAjoutParticipant(String nomParticipant, String prenomParticipant, String nomBateau, String typeBateau, int rating ) throws SQLException{
		Connexion();
		int id = listeParticipant.size();
		try{
		     PreparedStatement prepare = con.prepareStatement("INSERT INTO `eole`.`participant` (`ID_PARTICIPANT`, `NOM_PARTICIPANT`, `PRENOM_PARTICIPANT`, `NOM_VOILIER`, `CATEGORIE_VOILIER`, `RATING`)VALUES (?, ?, ?, ?, ?, ?); ");
		     prepare.setInt (1, id);
		     prepare.setString (2, nomParticipant);
		     prepare.setString (3, prenomParticipant);
		     prepare.setString (4, nomBateau);
		     prepare.setString (5, typeBateau);
		     prepare.setInt    (6, rating);
		 
		     prepare.executeUpdate();
		     id++;
		     System.out.println("requête envoyé correctement");
		
		} catch (Exception e){
			e.printStackTrace();
		}
		
		miseAJour();
		deconnexion();
	}
	
	public void reqAjoutRegate(String nomRegate, String dateRegate, String lieuDepart, String lieuArrive, int distance ) throws SQLException{
		
		Connexion();
		 
		 int id = listeRegate.size();
		 try {
			 PreparedStatement prepare = con.prepareStatement("INSERT INTO `eole`.`regate` (`ID_REGATE`, `NOM_REGATE`, `DATE_REGATE`, `LIEU_DEPART`, `LIEU_ARRIVEE`, `DISTANCE`)VALUES (?, ?, ?, ?, ?, ?); ");
			 prepare.setInt(1, id);
			 prepare.setString (2, nomRegate);
		     prepare.setString (3, dateRegate);
		     prepare.setString (4, lieuDepart);
		     prepare.setString (5, lieuArrive);
		     prepare.setInt(6, distance);
		 
		     prepare.executeUpdate();
		     
		     System.out.println("requête envoye correctement");
		     
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }

		miseAJour();
		deconnexion();
	}
	
	public ArrayList<String> getlisteRegate(){
		return listeRegate;
	}
	
	public ArrayList<String> getListeType(){
		return listeType;
	}
	
	public ArrayList<String> getParticipant(){
		return listeType;
	}

	public ArrayList<String> getListeDateRegate() {
		return listeDateRegate;
	}

	public ArrayList<String> getListeLieuDepart() {
		return listeLieuDepart;
	}

	public ArrayList<String> getListeLieuArrivee() {
		return listeLieuArrivee;
	}

	public ArrayList<Integer> getListeDistance() {
		return listeDistance;
	}
	
	
}
