package main;

import superAgil.SuperController;
import superAgil.VistaCliente;
import cliente.Cliente;

public class Main {
	
	@SuppressWarnings("deprecation")
	
	public void run() {
		SuperController ctrl = new SuperController();
		VistaCliente view = new VistaCliente();
		view.show();
		
		ctrl.startCajas();
		ctrl.queueClient(new Cliente(6));
		ctrl.queueClient(new Cliente(4));
		ctrl.queueClient(new Cliente(9));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main app = new Main();
		app.run();

	}

}
