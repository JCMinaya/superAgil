package superAgil;

import java.util.EmptyStackException;

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

		while ( _estado == CajasEstados.Disponible ) {
			try {
				clienteActual = ctrl.cola.pop();
				
				if ( clienteActual != null )
					_estado = CajasEstados.Ocupada;
				
			} catch( EmptyStackException e ) {
			}
		}
		atiendeCliente();
		run();
	}
	
	private synchronized void atiendeCliente() {
		if ( clienteActual != null ) {
			try {
				wait(clienteActual.countArticulos() * ( 1000 ));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		_estado = CajasEstados.Disponible;
		System.out.println(this.toString() + " termino con un cliente");
	}
	
}
