import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.awt.List;
import java.sql.*;


public class Bdd {
	ArrayList<ArrayList> listeParticipant = new ArrayList<ArrayList>();
	ArrayList infoParticipant;
	ArrayList<Regate> listeRegate = new ArrayList<Regate>();
	ArrayList<String> listeType= new ArrayList<String>();
	ArrayList<String> listeDateRegate= new ArrayList<String>();
	ArrayList<String> listeLieuDepart= new ArrayList<String>();
	ArrayList<String> listeLieuArrivee= new ArrayList<String>();
	ArrayList<Integer> listeDistance= new ArrayList<Integer>();
	private ArrayList<String> listeNomRegate = new ArrayList<String>();
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
		listeParticipant = new ArrayList<ArrayList>();
		while (rs.next()){
			infoParticipant = new ArrayList();
			infoParticipant.add(rs.getString(1));
			infoParticipant.add(rs.getString(2));
			infoParticipant.add(rs.getString(3));
			infoParticipant.add(rs.getString(4));
			infoParticipant.add(rs.getString(5));
			infoParticipant.add(rs.getString(6));
			
			listeParticipant.add(infoParticipant);
		}
		
		
		
		String sql2 = "SELECT * FROM regate";
		rs = st.executeQuery(sql2);
		listeRegate = new ArrayList<Regate>();
		
		while (rs.next()){
			Regate regate = new Regate(rs.getInt(1),rs.getInt(6),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			listeRegate.add(regate);
			listeNomRegate.add(rs.getString(2));
		}
		deconnexion();
		System.out.println("regates : " + listeRegate.size() + "; participants : " + listeParticipant.size());
		
		
	}
	
	public void miseAJour(){
		
		try {
			
			
			
			/////// fonction remove
			remove(listeParticipant);
			remove(listeRegate);
			remove(listeDateRegate);
			remove(listeLieuDepart);
			remove(listeLieuArrivee);
			remove(listeDistance);
			
			String sql = "SELECT * FROM participant";
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				infoParticipant = new ArrayList();
				infoParticipant.add(rs.getString(1));
				infoParticipant.add(rs.getString(2));
				infoParticipant.add(rs.getString(3));
				infoParticipant.add(rs.getString(4));
				infoParticipant.add(rs.getString(5));
				infoParticipant.add(rs.getString(6));
				
				listeParticipant.add(infoParticipant);
			}
			
			String sql2 = "SELECT * FROM regate";
			rs = st.executeQuery(sql2);
			
			while (rs.next()){
				
				Regate regate = new Regate(rs.getInt(1),rs.getInt(6),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				listeRegate.add(regate);
				listeNomRegate.add(rs.getString(2));
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
	
	public void reqAjoutRegate(String nomRegate, String dateRegate, String lieuDepart, String lieuArrive, int distance, ArrayList<ArrayList> participantsRegate) throws SQLException{
		
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
		     System.out.println(participantsRegate.size());
		     for (int i=0; i < participantsRegate.size(); i++) {
		    	 System.out.println(Integer.parseInt(participantsRegate.get(i).get(0)+"") + 20);
		    	 reqAjoutParticipantReg(Integer.parseInt((String)participantsRegate.get(i).get(0)), id);
		     }
		     
		     System.out.println("requête envoye correctement");
		     
		 } catch (SQLException e) {
			e.printStackTrace();
		 }

		miseAJour();
		deconnexion();
	}
	
	public void reqAjoutParticipantReg(int idParticipant, int idRegate) throws SQLException{
		
		 try {
			 PreparedStatement prepare = con.prepareStatement("INSERT INTO `eole`.`classement` (`ID_PARTICIPANT`, `ID_REGATE`, `TEMPS_REEL`, `POSITION`)VALUES (?, ?, ?, ?); ");
			 prepare.setInt(1, idParticipant);
			 prepare.setInt (2, idRegate);
		     prepare.setString (3, null);
		     prepare.setInt (4, -1);
		 
		     prepare.executeUpdate();
		     
		 } catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Des doublons dans les participants ont été détéctés. Ils n'ont pas été pris en compte.", "Attention", JOptionPane.WARNING_MESSAGE);
		 }
	}
	
	public ArrayList<Regate> getlisteRegate(){
		return listeRegate;
	}
	
	public ArrayList<String> getListeType(){
		return listeType;
	}
	
	public ArrayList<ArrayList> getParticipant(){
		return listeParticipant;
	}
	
	

	
	public ArrayList<String> getListeNomRegate() {
		return listeNomRegate;
	}

	public ArrayList<ArrayList<String>> getParticipantRegate(int idRegate) {
		Connexion();
		String sqlListeParticipantRegate = "SELECT * FROM participant WHERE ID_PARTICIPANT IN (SELECT ID_PARTICIPANT FROM classement WHERE ID_REGATE = " + idRegate + ")";
		try {
			ArrayList<String> unParticipant;
			ArrayList<ArrayList<String>> participantCetteRegate = new ArrayList<ArrayList<String>>();
			rs = st.executeQuery(sqlListeParticipantRegate);
			
			while (rs.next()) {
				unParticipant = new ArrayList<String>();
				unParticipant.add(rs.getString(1));
				unParticipant.add(rs.getString(2));
				unParticipant.add(rs.getString(3));
				unParticipant.add(rs.getString(4));
				unParticipant.add(rs.getString(5));
				
				participantCetteRegate.add(unParticipant);
			}
			deconnexion();
			return participantCetteRegate;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		deconnexion();
		return null;
		
	}
	
}
