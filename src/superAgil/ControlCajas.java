package superAgil;

import java.util.*;

import cliente.Cliente;

public class ControlCajas {
	List<Caja> _cajas;
	
	Random velocidad; 
	
	public ControlCajas() {
		_cajas = new ArrayList<Caja>();
		velocidad = new Random();
	}
	
	public void NuevaCaja (String referencia) {
		_cajas.add(new Caja(referencia, velocidad.nextInt(10)));
	}
	
	public synchronized Cliente CajaDisponible (Caja caja) {
		
		return null;
	}
}