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
		this.add(new JLabel("soy el panel de listado de clientes"));
	}

	public void borrarCliente() {
		this.clientes = daoClientes.obtenerClientes();
		JTable tabla = new JTable(new TableModelClientes(clientes));

		tabla.setPreferredScrollableViewportSize(new Dimension(400, 60));
		tabla.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tabla);
		removeAll();// quito lo que tuvuera antes dentro del panel
		this.add(scrollPane);
		System.out.println(botonBorrar);
		this.add(botonBorrar);
		botonBorrar.addActionListener(this);
	}
	
	public void refrecarClientes(){
		this.clientes = daoClientes.obtenerClientes();
		JTable tabla = new JTable(new TableModelClientes(clientes));
		removeAll();//quito lo que tuvuera antes dentro del panel 
		
	    tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    tabla.setFillsViewportHeight(true);
	    JScrollPane scrollPane = new JScrollPane(tabla);
	    this.add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(tabla.getSelectedRow()==-1){
			return;
		}
		JOptionPane.showMessageDialog(null,
				"borrar " + clientes[tabla.getSelectedRow()].toString());
		daoClientes.borrarCliente(clientes[tabla.getSelectedRow()].getId());
		refrecarClientes();
		SwingUtilities.updateComponentTreeUI(this);
	}

}
