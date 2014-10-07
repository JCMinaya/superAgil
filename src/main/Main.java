package main;

import superAgil.SuperController;
import superAgil.VistaCliente;
import cliente.Cliente;

public class Main {
	
	@SuppressWarnings("deprecation")
	
	public void run() {
		VistaCliente view = new VistaCliente(3);
		view.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main app = new Main();
		app.run();

	}

}
