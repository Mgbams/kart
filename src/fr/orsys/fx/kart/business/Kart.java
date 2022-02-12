package fr.orsys.fx.kart.business;

public class Kart {

	private String immatriculation;
	private float prix;
	private String nom;
	private static final float PRIX_DE_DEPART = 50;
	
	public Kart() {
		nom = "Kart";
		prix = PRIX_DE_DEPART;
	}
	
	public Kart(String immatriculation) {
		this();
		this.immatriculation = immatriculation;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Kart [immatriculation=" + immatriculation + ", prix=" + prix + ", nom=" + nom + "]";
	}

}
