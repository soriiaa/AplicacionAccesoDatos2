package vista;

import javax.swing.JFrame;

import controlador.Controlador;
import modelo.Modelo;

public class _05_EliminarArchivos extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public _05_EliminarArchivos() {

		getContentPane().setLayout(null);
		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		setLocationRelativeTo(null);

	}

}
