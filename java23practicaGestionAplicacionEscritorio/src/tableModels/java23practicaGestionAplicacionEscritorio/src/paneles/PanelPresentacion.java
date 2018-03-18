package paneles;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPresentacion extends JPanel{
	
	private Image tiendaropa = null;

	public PanelPresentacion() {
		try {
			tiendaropa = ImageIO.read(new File("tiendaRopa.jpg"));
		} catch (IOException e) {
			System.out.println("No pude cargar la imagen.");
		}
	}
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		
		g.drawImage(tiendaropa, 0, 0, null);
		
	}
	
}
