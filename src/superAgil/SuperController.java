package superAgil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import cliente.Cliente;

public class SuperController {
	
	ArrayList<Caja> cajasList;
	public Stack<Cliente> cola;
	
	
	public SuperController() {
		cajasList = new ArrayList<Caja>();
		cola = new Stack<Cliente>();
		
		for ( int i = 1; i <= 10; i++ ) {
			cajasList.add(new Caja("Caja " + i, this));
		}
		
	}
	
	public void queueClient(Cliente cl) {
		cola.push(cl);
	}
	
	public void startCajas() {
		Iterator<Caja> it = cajasList.iterator();
		while ( it.hasNext() ) {
			(new Thread(it.next())).start();
		}
	}

	public void output() {

		Iterator<Caja> it = cajasList.iterator();
		while ( it.hasNext() ) {
			Caja curr = it.next();
			System.out.println(curr.toString() + " " + curr.getEstado());
		}
	}

}
