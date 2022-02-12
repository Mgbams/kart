package fr.orsys.fx.kart.factories;

public class ImmatriculationFactory {

	private static ImmatriculationFactory immatriculationFactory;
	private int compteur = 0;

	// Constructeur privé
	private ImmatriculationFactory() {
	}

	public static ImmatriculationFactory getInstance() {
		if (immatriculationFactory == null) {
			synchronized (ImmatriculationFactory.class) {
				// Code critique
				if (immatriculationFactory == null) {
					immatriculationFactory = new ImmatriculationFactory();
				}
			}
		}
		return immatriculationFactory;
	}

	public String genererImmatriculation() {
		StringBuilder immatriculation = new StringBuilder("HB");
		compteur++;
		if (compteur < 10) {
			immatriculation.append("0");
		}
		immatriculation.append(compteur);
		return immatriculation.toString();
	}

}