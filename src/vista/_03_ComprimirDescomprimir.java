package vista;

import javax.swing.JFrame;

import controlador.Controlador;
import modelo.Modelo;

public class _03_ComprimirDescomprimir extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public _03_ComprimirDescomprimir() {

		getContentPane().setLayout(null);
		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		setLocationRelativeTo(null);

	}

}
