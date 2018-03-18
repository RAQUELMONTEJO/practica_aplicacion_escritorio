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
import modelo.Ropa;

public class RopaDAOImpl implements RopaDAO{
	
	private Connection miConexion = null;

	public RopaDAOImpl() {
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
	public void registrarPrenda(Ropa r) {
		String sqlInsercionPrenda = "insert into tabla_ropa (tipo, color, precio, talla, sexo, referencia, descripcion) values("
				+ "?, ?, ?, ?, ?, ?, ?);";

		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(sqlInsercionPrenda);

			ps.setString(1, r.getTipo());
			ps.setString(2, r.getColor());
			ps.setString(3, r.getPrecio());
			ps.setString(4, r.getTalla());
			ps.setString(5, r.getSexo());
			ps.setString(6, r.getReferencia());
			ps.setString(7, r.getDescripcion());

			ps.execute();
			ps.close();

			System.out.println("Prenda insertado correctamente");
			JOptionPane.showMessageDialog(null, "Prenda insertado correctamente", "Bien hecho ", JOptionPane.PLAIN_MESSAGE);
			

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Fallo en la sql.", "Error de entrada ", JOptionPane.ERROR_MESSAGE);
			
			System.out.println("Fallo en la sql.");
		}

		
	}

	@Override
	public void borrarPrenda(int id) {
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlBorradoPrenda);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			System.out.println("Prenda borrado correctamente");
			JOptionPane.showMessageDialog(null, "Prenda borrada correctamente", "Bien hecho ", JOptionPane.PLAIN_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Fallo en la sql.", "Error de entrada ", JOptionPane.ERROR_MESSAGE);
			System.out.println("Fallo en la SQL de borrarPrenda");
			// Más info del error
			System.out.println(e.getMessage());
		}
	}
		

	@Override
	public Ropa[] obtenerPrenda() {
		Ropa[] ropa = null;
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.sqlSeleccionPrenda);
			ResultSet resultado = ps.executeQuery();
			List<Ropa> listRopa = new ArrayList<Ropa>();
			while (resultado.next()) {
				Ropa r = new Ropa();
				r.setTipo(resultado.getString("Tipo"));
				r.setColor(resultado.getString("Color"));
				r.setPrecio(resultado.getString("Precio"));
				r.setTalla(resultado.getString("Talla"));
				r.setSexo(resultado.getString("Sexo"));
				r.setReferencia(resultado.getString("Referencia"));
				r.setDescripcion(resultado.getString("Descripcion"));
				r.setId(resultado.getInt("id"));
				listRopa.add(r);

			}
			ropa = listRopa.toArray(new Ropa[listRopa.size()]);

		} catch (SQLException e) {
			System.out.println("error sql listar");
			System.out.println(e.getMessage());
		}

		return ropa;
	}
}
