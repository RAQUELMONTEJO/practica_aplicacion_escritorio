package paneles;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import modelo.Cliente;
import modelo.Ropa;
import daos.ClientesDAOImpl;
import daos.RopaDAOImpl;

public class PanelResgistroRopa extends JPanel implements ActionListener {

	// Creamos los elementos que serán añadidos a la pantalla:
	ButtonGroup grupoSexo = new ButtonGroup();
	JRadioButton campoSexoF = new JRadioButton("Femenino");
	JRadioButton campoSexoM = new JRadioButton("Masculino");
	JComboBox<String> campoTipo = new JComboBox<String>();
	JComboBox<String> campoColor = new JComboBox<String>();
	JTextField campoPrecio = new JTextField(15);
	JComboBox<String> campoTalla = new JComboBox<String>();
	JTextField campoReferencia = new JTextField(15);
	JTextField campoDescripcion = new JTextField(25);

	public PanelResgistroRopa() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		// primera fila:
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(new JLabel("INTRODUCE LOS DATOS DE LA PRENDA"), gbc);
		// vuelvo a decir que cada componente solo ocupe un elemento:
		gbc.gridwidth = 1;

		// segunda fila:
		// Grupo sexo:
		grupoSexo.add(campoSexoF);
		grupoSexo.add(campoSexoM);
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("Sexo: "), gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoSexoF, gbc);
		gbc.gridy = 1;
		gbc.gridx = 2;
		this.add(campoSexoM, gbc);

		// tercera fila:
		// Campo tipo:
		campoTipo.addItem("CAMISETAS");
		campoTipo.addItem("CAMISAS");
		campoTipo.addItem("PANTALONES");
		campoTipo.addItem("JERSEYS");
		campoTipo.addItem("ZAPATOS");
		campoTipo.addItem("ABRIGOS");
		campoTipo.addItem("FALDAS");
		campoTipo.addItem("VESTIDOS");
		campoTipo.addItem("COMPLEMENTOS");
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Tipo de prenda: "), gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoTipo, gbc);

		// cuarta fila:
		// Campo color:
		campoColor.addItem("ROJO");
		campoColor.addItem("ROSA");
		campoColor.addItem("AZUL");
		campoColor.addItem("VERDE");
		campoColor.addItem("AMARILLO");
		campoColor.addItem("NEGRO");
		campoColor.addItem("BLANCO");
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("Color: "), gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoColor, gbc);

		// quinta fila:
		// Campo precio:
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("Precio: "), gbc);
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoPrecio, gbc);

		// sexta fila:
		// Campo talla
		campoTalla.addItem("S");
		campoTalla.addItem("M");
		campoTalla.addItem("L");
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("Talla: "), gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoTalla, gbc);

		// OCTAVA fila:
		// Campo referencia
		gbc.gridy = 6;
		gbc.gridx = 0;
		this.add(new JLabel("Referencia: "), gbc);
		gbc.gridy = 6;
		gbc.gridx = 1;
		this.add(campoReferencia, gbc);

		// SEPTIMA fila:
		// Campo descripcion:
		gbc.gridy = 7;
		gbc.gridx = 0;
		this.add(new JLabel("Descripcion: "), gbc);
		gbc.gridy = 7;
		gbc.gridx = 1;
		this.add(campoDescripcion, gbc);

		// novena fila
		JButton botonRegistroCliente = new JButton("REGISTRAR");
		botonRegistroCliente.addActionListener(this);
		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroCliente, gbc);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed del PanelRegistroRopa");
		String sexo = "";
		if(campoSexoF.isSelected()==true){ 
			sexo = campoSexoF.getText();
		}else if(campoSexoM.isSelected()){
			sexo = campoSexoM.getText();
		}
		String tipo = campoTipo.getSelectedItem().toString();
		String color = campoColor.getSelectedItem().toString();
		String precio = campoPrecio.getText();
		String talla = campoTalla.getSelectedItem().toString();
		String referencia = campoReferencia.getText();
		String descripcion = campoDescripcion.getText();
		// ahora habria que validad estos datos
		// ... TODO
		// una vez validados todos los datos registramos en base de datos
		Ropa ropaAregistrar = new Ropa(tipo, color, precio, talla,
				sexo, referencia, descripcion);
		System.out.println("voy a registrar: " + ropaAregistrar.toString());
		RopaDAOImpl ropaDAO = new RopaDAOImpl();
		ropaDAO.registrarPrenda(ropaAregistrar);

	}

}
