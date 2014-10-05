package superAgil;


public class Caja implements Runnable{
	int _velocidad;
	Enum<CajasEstados> _estado;
	String _referencia;
	
	public Caja (String referencia) {
		_referencia = referencia;
		inicializar();
	}
	
	public Caja (String referencia, int velocidad) {
		_velocidad = velocidad;
		_referencia = referencia;
		inicializar();
	}
	
	private void inicializar () {
		_estado = CajasEstados.Ocupada;
	}
	
	public String getEstado () {
		return _estado.toString();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
