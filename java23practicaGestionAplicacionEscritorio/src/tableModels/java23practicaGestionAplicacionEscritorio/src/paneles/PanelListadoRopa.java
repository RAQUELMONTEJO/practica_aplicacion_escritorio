package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import daos.RopaDAOImpl;
import modelo.Ropa;
import tableModels.TableModelRopa;

public class PanelListadoRopa extends JPanel{
	
	RopaDAOImpl daoRopa = new RopaDAOImpl();
	private Ropa[] ropa;
	JTable tabla ;
	
	public PanelListadoRopa() {
		this.add(new JLabel("soy el panel del listado de prendas"));
	}

	public void refrescarRopa(){
		this.ropa = daoRopa.obtenerPrenda();
		tabla = new JTable(new TableModelRopa(ropa));
		removeAll();//quito lo que tuvuera antes dentro del panel 
		
	    tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    tabla.setFillsViewportHeight(true);
	    JScrollPane scrollPane = new JScrollPane(tabla);
	    this.add(scrollPane);
	    SwingUtilities.updateComponentTreeUI(this);
	}

}
