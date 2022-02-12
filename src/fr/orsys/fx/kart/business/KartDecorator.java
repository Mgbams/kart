package fr.orsys.fx.kart.business;

public abstract class KartDecorator extends Kart {

	protected Kart kart;
	
	public KartDecorator(Kart kart) {
		super();
		this.kart = kart;
	}

//	public Kart getKart() {
//		return kart;
//	}
//
//	public void setKart(Kart kart) {
//		this.kart = kart;
//	}
	
	
}
