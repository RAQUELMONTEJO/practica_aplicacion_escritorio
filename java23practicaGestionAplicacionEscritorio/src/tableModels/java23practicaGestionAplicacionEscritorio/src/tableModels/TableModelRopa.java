package tableModels;

import javax.swing.table.AbstractTableModel;

import modelo.Cliente;
import modelo.Ropa;

public class TableModelRopa extends AbstractTableModel{

	private String[] columnas = { "Tipo", "Color", "Precio", "Talla", "Sexo",
			"Referencia", "Descripción" };
	private String[][] datos = null;

	public TableModelRopa(Ropa[] prendas) {
		datos = new String[prendas.length][columnas.length];
		for (int i = 0; i < prendas.length; i++) {
			Ropa r = prendas[i];
			datos[i][0] = r.getTipo();
			datos[i][1] = r.getColor();
			datos[i][2] = r.getPrecio();
			datos[i][3] = r.getTalla();
			datos[i][4] = r.getSexo();
			datos[i][5] = r.getReferencia();
			datos[i][6] = r.getDescripcion();
		}
	}

	public int getRowCount() {
		return datos.length;
	}

	public int getColumnCount() {
		return columnas.length;
	}

	public String getColumnName(int numeroColumna) {
		return columnas[numeroColumna];
	}

	public Object getValueAt(int indiceFila, int indiceColumna) {
		return datos[indiceFila][indiceColumna];
	}

}
