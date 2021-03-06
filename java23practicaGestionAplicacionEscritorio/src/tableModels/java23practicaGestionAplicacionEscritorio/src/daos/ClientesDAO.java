package daos;

import modelo.Cliente;

//El entorno corporativo, lo mas normal del mundo es definir operaciones que se van a poder hacer
//sobre bas de datos en un interfaz

//En este caso, para el interfaz actual, cada metodo dira que se puede hacer en base de datos
//de cara a clientes

public interface ClientesDAO {

	void registrarCliente(Cliente c);

	void borrarCliente(int id);

	Cliente[] obtenerClientes();
	// Un array es un conjunto de datos del mismo tipo

}
