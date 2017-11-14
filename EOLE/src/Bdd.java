import java.util.ArrayList;

public class Bdd {
	ArrayList<String> listeRegate;
	ArrayList<String> listeType;
	public Bdd(){
		Connexion();
	}

	public void Connexion(){
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
	
	public ArrayList<String> getListeRegate(){
		return listeRegate;
	}
	
	public ArrayList<String> getListeType(){
		return listeType;
	}
}
