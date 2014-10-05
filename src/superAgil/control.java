package superAgil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cliente.Cliente;

public class control {
	static List<Caja> _cajas;
	
	public static void addCaja (String referencia) {
		Random velocidad;
		velocidad = new Random();
		
		_cajas = new ArrayList<Caja>();
		_cajas.add(new Caja(referencia, velocidad.nextInt(12)));
	}
	
	public synchronized Cliente CajaDisponible (Caja caja) {
		
		return null;
	}

}
