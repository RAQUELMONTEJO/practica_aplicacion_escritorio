package tableModels;

import javax.swing.table.AbstractTableModel;

import modelo.Cliente;

public class TableModelClientes extends AbstractTableModel {
	private String[] columnas = { "nombre", "direccion", "poblacion",
			"codigoPostal", "telefono" };
	private String[][] datos = null;

	public TableModelClientes(Cliente[] clientes) {
		datos = new String[clientes.length][columnas.length];
		for (int i = 0; i < clientes.length; i++) {
			Cliente c = clientes[i];
			datos[i][0] = c.getNombre();
			datos[i][1] = c.getDomicilio();
			datos[i][2] = c.getPoblacion();
			datos[i][3] = c.getCodigoPostal();
			datos[i][4] = c.getTelefono();
		}
	}
	
	public int getRowCount() {
		return datos.length;
	}
	
	public int getColumnCount() {
		return columnas.length;
	}



	public Object getValueAt(int indiceFila, int indiceColumna) {
		return datos[indiceFila][indiceColumna];
	}

}
