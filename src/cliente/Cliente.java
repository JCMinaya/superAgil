package cliente;

public class Cliente {
	
	int cantArticulos;
	
	public Cliente(int cantArticulos) {
		this.cantArticulos = cantArticulos;
	}
	
	public int countArticulos() {
		// TODO Auto-generated method stub
		return cantArticulos;
	}

	public int getArticulo() {
		cantArticulos--;
		return 1;
	}


}
