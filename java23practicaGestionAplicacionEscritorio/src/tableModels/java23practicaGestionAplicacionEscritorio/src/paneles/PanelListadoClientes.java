package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import tableModels.TableModelClientes;
import modelo.Cliente;
import daos.ClientesDAOImpl;

public class PanelListadoClientes extends JPanel{
	
	ClientesDAOImpl daoClientes = new ClientesDAOImpl();
	private Cliente[] clientes;

	public PanelListadoClientes() {
		this.add(new JLabel("soy el panel de listado de clientes"));
	}

	public void refrescarClientes(){
		this.clientes = daoClientes.obtenerClientes();
		JTable tabla = new JTable(new TableModelClientes(clientes));
		removeAll();//quito lo que tuvuera antes dentro del panel 
		
	    tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    tabla.setFillsViewportHeight(true);
	    JScrollPane scrollPane = new JScrollPane(tabla);
	    this.add(scrollPane);
	    SwingUtilities.updateComponentTreeUI(this);
	}//end refrescarClientes

}
