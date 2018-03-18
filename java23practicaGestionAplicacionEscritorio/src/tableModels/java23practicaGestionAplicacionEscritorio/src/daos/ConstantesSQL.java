package daos;

public class ConstantesSQL {
	final static String sqlInsercionCliente = "insert into tabla_clientes (nombre, domicilio, poblacion, codigo_postal, telefono)"
			+ "values (?,?,?,?,?)";
	final static String sqlSeleccionCliente = "select * from tabla_clientes";
	final static String sqlBorradoCliente = "delete from tabla_clientes where id=? ";

	final static String sqlInsercionPrenda = "insert into tabla_ropa (tipo, color, precio, talla, sexo, referencia, descripcion) values("
				+ "?, ?, ?, ?, ?, ?, ?)";
	final static String sqlSeleccionPrenda = "select * from tabla_ropa";
	final static String sqlBorradoPrenda = "delete from tabla_ropa where id=? ";
}
