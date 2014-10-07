package superAgil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import cliente.Cliente;

public class SuperController {
	VistaCliente view;
	ArrayList<Caja> cajasList;
	public Stack<Cliente> cola;
	
	
	public SuperController(int countCajas, VistaCliente _view) {
		cajasList = new ArrayList<Caja>();
		cola = new Stack<Cliente>();
		view = _view;
		
		for ( int i = 1; i <= countCajas; i++ ) {
			cajasList.add(new Caja("Caja " + i, this));
		}
		
	}
	
	public void queueClient(Cliente cl) {
		cola.push(cl);
		//view.updateCola(cola.size());
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
			view.updateCaja(cajasList.indexOf(curr), curr.getEstado());
			//System.out.println(curr.toString() + " " + curr.getEstado());
		}
	}
	
	public void updateCaja (Caja curr) {
		String estado =  curr.getEstado();
		if (estado == "Ocupada") estado += "(" + curr.clienteActual.countArticulos() + ")";
		
		view.updateCaja(cajasList.indexOf(curr), estado);
	}
	
	public Cliente colaPop() {
		Cliente pop = null; 
		if (cola.size() > 0) {
			pop = cola.pop();
			view.updateCola(cola.size());
		}
		
		return pop;
	}

}
