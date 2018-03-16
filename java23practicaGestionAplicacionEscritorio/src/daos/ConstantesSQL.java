package daos;

public class ConstantesSQL {
	final static String sqlInsercionCliente = "insert into tabla_clientes (nombre, domicilio, poblacion, codigo_postal, telefono)"+
				"values (?,?,?,?,?)";
	final static String sqlSeleccionCliente = "select * from tabla_clientes";
}
