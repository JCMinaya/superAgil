package cliente;

public class Cliente implements superAgil.Cliente {
	float tiempodePago;
	
	@Override
	public int countArticulos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getArticulo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean recibirPago() {
		// TODO Auto-generated method stub
		if (tiempodePago == 0.0f) tiempodePago = 5;
		try {
			wait ((int)(tiempodePago * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		return true;
	}
	
}
