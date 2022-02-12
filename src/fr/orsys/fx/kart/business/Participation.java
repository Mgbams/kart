package fr.orsys.fx.kart.business;

public class Participation {

	private Client Client;
	private Kart kart;
	private Repas repas;

	public Participation() {
	}
	
	public Participation(Client Client, Kart kart, Repas repas) {
		super();
		this.Client = Client;
		this.kart = kart;
		this.repas = repas;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client Client) {
		this.Client = Client;
	}

	public Kart getKart() {
		return kart;
	}

	public void setKart(Kart kart) {
		this.kart = kart;
	}
	
	public Repas getRepas() {
		return repas;
	}

	public void setRepas(Repas repas) {
		this.repas = repas;
	}

	@Override
	public String toString() {
		return "Participation [Client=" + Client + ", kart=" + kart + ", repas="
				+ repas + "]";
	}
		
}