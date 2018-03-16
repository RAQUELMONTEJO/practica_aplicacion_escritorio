package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Cliente;

public class ClientesDAOImpl implements ClientesDAO {

	private Connection miConexion = null;

	public ClientesDAOImpl() {
		// Preparo driver y conexion
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/practica_escritorio";
			miConexion = DriverManager
					.getConnection(url, "root", "jeveris");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver-libreria de mysql.");
		} catch (SQLException e) {
			System.out.println("Error de conexion o la sql esta mal.");
		}
	}

	@Override
	public void registrarCliente(Cliente c) {
		String sqlInsercionCliente = "insert into tabla_clientes(nombre, domicilio"
				+ ", poblacion, codigo_postal, telefono) values("
				+ "?, ?, ?, ?, ?);";

		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(sqlInsercionCliente);

			ps.setString(1, c.getNombre());
			ps.setString(2, c.getDomicilio());
			ps.setString(3, c.getPoblacion());
			ps.setString(4, c.getCodigoPostal());
			ps.setString(5, c.getTelefono());

			ps.execute();
			ps.close();

			System.out.println("Cliente insertado correctamente");
			JOptionPane.showMessageDialog(null, "Cliente insertado correctamente.", "Bien hecho ", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {
			System.out.println("Fallo en la sql.");
			JOptionPane.showMessageDialog(null, "Fallo en la sql.", "Mensaje de error ", JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void borrarCliente(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente[] obtenerClientes() {
		Cliente[] clientes = null;
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.sqlSeleccionCliente);
			ResultSet resultado = ps.executeQuery();
			List<Cliente> listClientes = new ArrayList<Cliente>();
			while(resultado.next()){
				Cliente c = new Cliente();
				c.setNombre(resultado.getString("nombre"));
				c.setDomicilio(resultado.getString("domicilio"));
				c.setPoblacion(resultado.getString("Poblacion"));
				c.setCodigoPostal(resultado.getString("codigo_postal"));
				c.setTelefono(resultado.getString("telefono"));
				listClientes.add(c);
				
				clientes=listClientes.toArray(new Cliente[listClientes.size()]);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("error sql listar");
			System.out.println(e.getMessage());
		}

		return clientes;
	}

}
