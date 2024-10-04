package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import modelo.Modelo;
import javax.swing.JScrollPane;

public class _03_VisualizarEliminarComprimir extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JTextField txtContenidoObjeto;
	private JButton btnAgregarObjeto;
	private JLabel lblVolver;
	private JLabel lblTitulo;
	private JLabel lblTituloTextField;
	private JButton btnEliminar;
	private JButton btnDescomprimir;
	private JButton btnComprimir;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public _03_VisualizarEliminarComprimir() {

		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().setBackground(new Color(173, 216, 230));
		getContentPane().setLayout(null);

		lblNewLabel = new JLabel("Visualizar, Descomprimir y Comprimir Archivos");
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
		lblNewLabel.setBounds(32, 11, 767, 63);
		getContentPane().add(lblNewLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 108, 542, 390);
		getContentPane().add(scrollPane);

		btnComprimir = new JButton("Comprimir");
		btnComprimir.setBackground(new Color(38, 251, 86));
		btnComprimir.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		btnComprimir.setBounds(32, 133, 193, 43);
		getContentPane().add(btnComprimir);
		btnComprimir.setBorder(null);

		btnDescomprimir = new JButton("Descomprimir");
		btnDescomprimir.setBackground(new Color(108, 196, 253));
		btnDescomprimir.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		btnDescomprimir.setBounds(32, 283, 193, 43);
		getContentPane().add(btnDescomprimir);
		btnDescomprimir.setBorder(null);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(255, 77, 62));
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		btnEliminar.setBounds(32, 433, 193, 43);
		getContentPane().add(btnEliminar);
		btnEliminar.setBorder(null);

		lblVolver = new JLabel("");
		lblVolver.setIcon(new ImageIcon(".\\img\\flechaAtras.png"));
		lblVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarVentana(3, 0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblVolver.setBounds(830, 32, 48, 44);
		getContentPane().add(lblVolver);

	}
}
