package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import modelo.Cliente;
import tableModels.TableModelClientes;
import daos.ClientesDAOImpl;

public class PanelBorrarCliente extends JPanel implements ActionListener {

	ClientesDAOImpl daoClientes = new ClientesDAOImpl();
	private Cliente[] clientes;
	JTable tabla;
	JButton botonBorrar = new JButton("BORRAR");
	

	public PanelBorrarCliente() {
		this.add(new JLabel("soy el panel de borrado de clientes"));
	}
	
	public void refrescarClientes(){
		this.clientes = daoClientes.obtenerClientes();
		tabla = new JTable(new TableModelClientes(clientes));
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 100));
	    tabla.setFillsViewportHeight(true);
	    tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		   
	    JScrollPane scrollPane = new JScrollPane(tabla);		
		this.removeAll();//quito todo lo que tuviera antes dentro del panel
		this.add(botonBorrar);
		this.add(scrollPane);
		//voy a a atender al boton borrar desde la instancia de esta clase
		botonBorrar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(tabla.getSelectedRow()==-1){
			return;
		}
		JOptionPane.showMessageDialog(null,
				"borrar " + clientes[tabla.getSelectedRow()].toString());
		daoClientes.borrarCliente(clientes[tabla.getSelectedRow()].getId());
		refrescarClientes();
		SwingUtilities.updateComponentTreeUI(this);
	}

}
