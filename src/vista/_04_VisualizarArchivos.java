package vista;

import javax.swing.JFrame;

import controlador.Controlador;
import modelo.Modelo;

public class _04_VisualizarArchivos extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public _04_VisualizarArchivos() {

		getContentPane().setLayout(null);
		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		setLocationRelativeTo(null);

	}

}
