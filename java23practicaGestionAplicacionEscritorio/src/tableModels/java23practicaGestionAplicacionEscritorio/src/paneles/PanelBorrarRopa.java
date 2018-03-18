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

import modelo.Ropa;
import tableModels.TableModelClientes;
import tableModels.TableModelRopa;
import daos.RopaDAOImpl;

public class PanelBorrarRopa extends JPanel implements ActionListener{

	RopaDAOImpl daoRopa = new RopaDAOImpl();
	private Ropa[] ropa;
	JTable tabla;
	JButton botonBorrar = new JButton("BORRAR");
	
	public PanelBorrarRopa() {
		this.add(new JLabel("soy el panel del borrado de prendas"));
	}
	
	public void refrescarRopa(){
		this.ropa = daoRopa.obtenerPrenda();
		tabla = new JTable(new TableModelRopa(ropa));
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
				"borrar " + ropa[tabla.getSelectedRow()].toString());
		daoRopa.borrarPrenda(ropa[tabla.getSelectedRow()].getId());
		refrescarRopa();
		SwingUtilities.updateComponentTreeUI(this);
		
	}
}
