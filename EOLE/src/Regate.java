
public class Regate {
	private int idRegate, distance;
	private String nomRegate, dateRegate, lieuDepart, lieuArrive;
	
	public Regate(int idRegate, int distance, String nomRegate, String dateRegate, String lieuDepart,
			String lieuArrive) {
		super();
		this.idRegate = idRegate;
		this.distance = distance;
		this.nomRegate = nomRegate;
		this.dateRegate = dateRegate;
		this.lieuDepart = lieuDepart;
		this.lieuArrive = lieuArrive;
	}

	public int getIdRegate() {
		return idRegate;
	}

	public int getDistance() {
		return distance;
	}

	public String getNomRegate() {
		return nomRegate;
	}

	public String getDateRegate() {
		return dateRegate;
	}

	public String getLieuDepart() {
		return lieuDepart;
	}

	public String getLieuArrive() {
		return lieuArrive;
	}
	
	
}
