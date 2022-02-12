package fr.orsys.fx.kart.builders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.orsys.fx.kart.business.Burger;
import fr.orsys.fx.kart.business.Client;
import fr.orsys.fx.kart.business.Kart;
import fr.orsys.fx.kart.business.LinguineAuxFruitsDeMer;
import fr.orsys.fx.kart.business.Participation;
import fr.orsys.fx.kart.business.Repas;
import fr.orsys.fx.kart.factories.ImmatriculationFactory;

public class ParticipationBuilder {

	private static List<Kart> karts = new ArrayList<>();
	Participation participation = null;

	public ParticipationBuilder(Date date) {
		ImmatriculationFactory immatriculationFactory = ImmatriculationFactory.getInstance();

		for (int i = 0; i < 10; i++) {
			karts.add(new Kart(immatriculationFactory.genererImmatriculation()));
		}

		participation = new Participation();

	}

	public ParticipationBuilder definirParticipant(Client participant) {
		participation.setClient(participant);
		return this;
	}

	public ParticipationBuilder definirKart(Kart kart) {
		participation.setKart(kart);
		return this;
	}

	public ParticipationBuilder definirRepas(String nom) {
		Repas repas = null;
		if (nom.equals("Burger")) {
			repas = new Burger();
		} else if (nom.equals("Linguine aux fruits de mer")) {
			repas = new LinguineAuxFruitsDeMer();
		}
		participation.setRepas(repas);
		return this;
	}

	public Participation build() {
		return participation;
	}

	public List<Kart> getKarts() {
		return karts;
	}

}
