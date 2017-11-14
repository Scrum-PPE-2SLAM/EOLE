import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Bdd maBdd = new Bdd();
		Window window = new Window("Regate Manager 2017",800,600, maBdd.getListeRegate().toArray(new String[0]), maBdd.getListeType().toArray(new String[0]));
		window.createWindow();
		window.createMenu();
		
		
		window.setVisible(true);
		
	}
}
