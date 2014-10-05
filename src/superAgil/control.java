package superAgil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class control {
	static List<Thread> _cajas;
	static boolean EstadoCliente;
	static Random velocidad;
	static VistaCliente view;
	
	static public synchronized void addCaja (String referencia) {
		Thread temp = new Thread(new Caja(referencia, velocidad.nextInt(12)));
		_cajas.add(temp);
		temp.start();
	}
	
	static public synchronized void inizializar() {
		_cajas = new ArrayList<Thread>();
		EstadoCliente = false;
		velocidad = new Random();
		addCaja("Caja 1");
		
		view = new VistaCliente();
		view.open();
	}
	
	public synchronized void CajaEstado (Caja caja, CajasEstados estado) {
		
	}
	
	public synchronized Caja Queue () {
		
		return null;
	}
	
}
