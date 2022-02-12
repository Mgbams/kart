package fr.orsys.fx.kart.business;

public class LanceRoquette extends KartDecorator {

	private static final float PRIX = 2;
	
	public LanceRoquette(Kart kart) {
		super(kart);
		super.setNom(kart.getNom() + ", Lance Roquette");
		super.setPrix(kart.getPrix() + PRIX);
		super.setImmatriculation(kart.getImmatriculation());
	}
}
