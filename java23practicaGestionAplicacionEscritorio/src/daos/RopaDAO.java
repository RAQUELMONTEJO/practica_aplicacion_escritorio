package daos;

import modelo.Ropa;

public interface RopaDAO {

	void registrarPrenda(Ropa r);

	void borrarPrenda(int id);

	Ropa[] obtenerPrenda();
	
}
