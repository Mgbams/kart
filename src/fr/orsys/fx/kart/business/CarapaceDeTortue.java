package fr.orsys.fx.kart.business;

public class CarapaceDeTortue extends KartDecorator {

	private static final float PRIX = 3;
	
	public CarapaceDeTortue(Kart kart) {
		super(kart);
		super.setNom(kart.getNom() + ", Carapace");
		super.setPrix(kart.getPrix() + PRIX);
		super.setImmatriculation(kart.getImmatriculation());
	}
	
}
