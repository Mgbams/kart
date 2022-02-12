package fr.orsys.fx.kart.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.orsys.fx.kart.business.Client;

public class CollectionDeParticipants implements Iterator<Client>, Iterable<Client> {

	List<Client> clients = new ArrayList<>();
	private int offset = 0;
	
	public void add(Client p) {
		clients.add(p);
	}
	
	@Override
	public Iterator<Client> iterator() {
		return clients.iterator();

	}

	@Override
	public boolean hasNext() {
		return offset < clients.size();

	}

	@Override
	public Client next() {
		return clients.get(offset++);
	}

	public int size() {
		return clients.size();
	}

	public Client get(int choix) {
		return clients.get(choix);
	}
}
