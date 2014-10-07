package superAgil;

import java.util.EmptyStackException;
import java.util.Random;

import cliente.Cliente;


public class Caja implements Runnable{
	int _velocidad;
	Enum<CajasEstados> _estado;
	String _referencia;
	Cliente clienteActual;
	SuperController ctrl;
	
	public Caja (String referencia, SuperController ctrl) {
		_referencia = referencia;
		this.ctrl = ctrl;
		inicializar();
	}
	
	public Caja (String referencia, int velocidad) {
		_velocidad = velocidad;
		_referencia = referencia;
		inicializar();
	}
	
	private void inicializar () {
		_estado = CajasEstados.Disponible;
	}
	
	public String getEstado () {
		return _estado.toString();
	}
	
	public String toString() {
		return _referencia;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			while ( _estado == CajasEstados.Disponible ) {
				try {
					clienteActual = ctrl.colaPop();
					
					if ( clienteActual != null )
						setEstado (CajasEstados.Ocupada);
					
				} catch( EmptyStackException e ) {
				}
			}
			atiendeCliente();
		}
	}
	
	private synchronized void atiendeCliente() {
		if ( clienteActual != null ) {
			try {
				while (clienteActual.countArticulos() > 0) {
					wait(clienteActual.getArticulo() * (900 + new Random().nextInt(3000)));
					setEstado(null);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		setEstado (CajasEstados.Disponible);
		System.out.println(this.toString() + " termino con un cliente");
	}
	
	private void setEstado (CajasEstados estado) {
		if (estado != null) _estado = estado;
		ctrl.updateCaja(this);
	}
	
}
