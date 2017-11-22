import java.util.ArrayList;
import java.sql.*;


public class Bdd {
	ArrayList<String> listeParticipant = new ArrayList<String>();;
	ArrayList<String> listeRegate = new ArrayList<String>();;
	ArrayList<String> listeType= new ArrayList<String>();;
	private static String url ="jdbc:mysql://localhost:3306/eole";
	private static String user ="root";
	private static String password = "";
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	private static int res;
	private static int id=8;
	
	
	
	public Bdd() throws SQLException{
		Connexion();
		
	}

	public void Connexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			System.out.println("connexion �tablie");
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
			listeRegate.add(rs.getString(1));
		}
		deconnexion();
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
		     System.out.println("requête envoy� correctement");
		
		} catch (Exception e){
			e.printStackTrace();
		}

		initialisation();
		deconnexion();
	}
	
	public void reqAjoutRegate(String nomRegate, String dateRegate, String lieuDepart, String lieuArrive, int distance ) throws SQLException{
		 PreparedStatement prepare;
		 try {
			 prepare = con.prepareStatement("INSERT INTO `eole`.`regate` (`ID_REGATE`, `NOM_REGATE`, `LIEU_DEPART`, `LIEU_ARRIVEE`, `DISTANCE`)VALUES (?, ?, ?, ?, ?, ?); ");
			 prepare.setInt(1, 1);
			 prepare.setString (2, nomRegate);
		     prepare.setString (3, dateRegate);
		     prepare.setString (4, lieuDepart);
		     prepare.setString (5, lieuArrive);
		     prepare.setInt(6, distance);
		 
		     prepare.executeUpdate();
		     
		     System.out.println("requ�te envoy� correctement");
		     
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }

		initialisation();
		deconnexion();
	}
	
	public ArrayList<String> getlisteRegate(){
		return listeRegate;
	}
	
	public ArrayList<String> getListeType(){
		return listeType;
	}
}
