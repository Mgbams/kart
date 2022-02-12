package fr.orsys.fx.kart.business;

public class Banane extends KartDecorator {

	private static final float PRIX = 1;
	
	public Banane(Kart kart) {
		super(kart);
		super.setNom(kart.getNom() + ", Banane");
		super.setPrix(kart.getPrix() + PRIX);
		super.setImmatriculation(kart.getImmatriculation());
	}
}
