import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException {
		Bdd maBdd = new Bdd();
		maBdd.initialisation();
		
		Window window = new Window("Regate Manager 2017",800,600, maBdd.getlisteRegate().toArray(new String[0]), maBdd.getListeType().toArray(new String[0]));
		window.createWindow();
		window.createMenu();
		window.ajouteAccueil();
		window.setVisible(true);
		
	}
}
