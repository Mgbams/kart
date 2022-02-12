package fr.orsys.fx.kart.business;

public class Client {

	private Long id;
	private String prenom;
	private String nom;
	private static Long counter = 0L;

	public Client() {
		super();
		id = ++counter;
	}

	public Client(String prenom, String nom) {
		this();
		this.prenom = prenom;
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Client [prenom=" + prenom + ", nom=" + nom + "]";
	}

}
