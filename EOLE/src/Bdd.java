import java.util.ArrayList;
import java.sql.*;


public class Bdd {
	ArrayList<String> listeParticipant;
	ArrayList<String> listeRegate;
	ArrayList<String> listeType;
	private static String url ="jdbc:mysql://http://localhost:4040/eole";
	private static String user ="root";
	private static String password = "";
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	
	
	public Bdd(){
		Connexion();
	}

	public void Connexion(){
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			System.out.println("connexion établie");
			st = con.createStatement();
			
			String sql = "SELECT * FROM participants";
			rs = st.executeQuery(sql);
			listeParticipant = new ArrayList<String>();
			
			while (rs.next()){
				listeParticipant.add(rs.getString(2));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			con.close();
			st.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connexion fermé");
		
		listeRegate = new ArrayList<String>();
		listeRegate.add("test");
		listeRegate.add("test2");
		listeRegate.add("test2");
		listeRegate.add("test2");
		
		listeType = new ArrayList<String>();
		listeType.add("volier");
		listeType.add("multicoque");
		listeType.add("quillard");
		listeType.add("dériveur");
		listeType.add("catamaran");
		
		
	}
	/*
	
		
	}
	
		*/
		
	
	public ArrayList<String> getListeRegate(){
		return listeRegate;
	}
	
	public ArrayList<String> getListeType(){
		return listeType;
	}
}
