package ventanas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import paneles.PanelAyuda;
import paneles.PanelBorrarCliente;
import paneles.PanelBorrarRopa;
import paneles.PanelListadoClientes;
import paneles.PanelListadoRopa;
import paneles.PanelPresentacion;
import paneles.PanelRegistroCliente;
import paneles.PanelResgistroRopa;

public class VentanaPrincipal extends JFrame implements ActionListener {

	Font font = new Font("Agency FB", Font.BOLD, 14);

	// paneles de ventana:
	private FlowLayout contentmenu = new FlowLayout();
	
	private PanelPresentacion panelpresentacion = new PanelPresentacion();

	private PanelRegistroCliente panelregistrocliente = new PanelRegistroCliente();
	private PanelListadoClientes panellistadoclientes = new PanelListadoClientes();
	private PanelBorrarCliente panelborrarcliente = new PanelBorrarCliente();

	private PanelResgistroRopa panelregistroropa = new PanelResgistroRopa();
	private PanelListadoRopa panellistadoropa = new PanelListadoRopa();
	private PanelBorrarRopa panelborrarropa = new PanelBorrarRopa();

	private PanelAyuda panelayuda = new PanelAyuda();

	// barra de menu
	private JMenuBar barrademenu = new JMenuBar();
	private JMenu menuclientes = new JMenu("Clientes");
	private JMenuItem menuayuda = new JMenuItem("Ayuda");
	private JMenu menuRopa = new JMenu("Ropa");

	public VentanaPrincipal() {

		// preparar la barra de menu:
		JMenuItem clientesinsertar = new JMenuItem("Insertar Cliente");
		JMenuItem clienteslistar = new JMenuItem("Listar Clientes");
		JMenuItem clientesborrar = new JMenuItem("Borrar Clientes");
		menuclientes.add(clientesinsertar);
		menuclientes.add(clienteslistar);
		menuclientes.add(clientesborrar);

		JMenuItem ropainsertar = new JMenuItem("Insertar prendas");
		JMenuItem ropalistar = new JMenuItem("Listar prendas");
		JMenuItem ropaborrar = new JMenuItem("Borrar prendas");
		menuRopa.add(ropainsertar);
		menuRopa.add(ropalistar);
		menuRopa.add(ropaborrar);

		barrademenu.add(menuclientes);
		barrademenu.add(menuRopa);
		barrademenu.add(menuayuda);
		this.setJMenuBar(barrademenu);

		// voy a decir a las opciones de menu quien las va a atender cuando se
		// les haga un click
		clientesinsertar.addActionListener(this);
		clienteslistar.addActionListener(this);
		clientesborrar.addActionListener(this);
		ropainsertar.addActionListener(this);
		ropalistar.addActionListener(this);
		ropaborrar.addActionListener(this);
		menuayuda.addActionListener(this);

		barrademenu.setBackground(Color.PINK);
		menuayuda.setBackground(Color.PINK);
		
		barrademenu.setOpaque(true);

		// preparacion de la ventana principal
		setIconImage(new ImageIcon("icono.png").getImage());
		this.setSize(650, 423);
		this.setLocation(400, 100);
		this.setTitle("TIENDA DE ROPA");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// vamos a decir que cuando arranque esta ventana se muestre el panel de
		// registro cliente
		this.setContentPane(panelpresentacion);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("atiendo a: " + e.getActionCommand());
		if (e.getActionCommand().equals("Insertar Cliente")) {
			setContentPane(panelregistrocliente);
		} else if (e.getActionCommand().equals("Listar Clientes")) {
			setContentPane(panellistadoclientes);
			panellistadoclientes.refrescarClientes();
		} else if (e.getActionCommand().equals("Borrar Clientes")) {
			setContentPane(panelborrarcliente);
			panelborrarcliente.refrescarClientes();
		}else if (e.getActionCommand().equals("Insertar prendas")) {
			setContentPane(panelregistroropa);
		} else if (e.getActionCommand().equals("Listar prendas")) {
			setContentPane(panellistadoropa);
			panellistadoropa.refrescarRopa();
		} else if (e.getActionCommand().equals("Borrar prendas")) {
			setContentPane(panelborrarropa);
			panelborrarropa.refrescarRopa();
		}
		System.out.println("atiendo a: " + e.getActionCommand());
		if (e.getActionCommand().equals("Ayuda")) {
			setContentPane(panelayuda);
		}
		SwingUtilities.updateComponentTreeUI(this);
	}

}// end class
