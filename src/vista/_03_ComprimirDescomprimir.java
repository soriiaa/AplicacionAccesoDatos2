package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import controlador.Controlador;
import modelo.Modelo;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class _03_ComprimirDescomprimir extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblTitulo;
	private JButton btnDescomprimir;
	private JButton btnComprimir;
	private JLabel lblVolver;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public _03_ComprimirDescomprimir() {

		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().setBackground(new Color(173, 216, 230));
		getContentPane().setLayout(null);

		lblTitulo = new JLabel("Comprimir y Descomprimir Archivos");
		lblTitulo.setBounds(148, 51, 591, 63);
		lblTitulo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
		getContentPane().add(lblTitulo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(230, 159, 428, 257);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		btnDescomprimir = new JButton("Descomprimir");
		btnDescomprimir.setBounds(537, 427, 121, 23);
		btnDescomprimir.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		getContentPane().add(btnDescomprimir);
		btnDescomprimir.setBorder(null);
		btnDescomprimir.setBackground(Color.white);

		btnComprimir = new JButton("Comprimir\r\n");
		btnComprimir.setBounds(406, 427, 121, 23);
		btnComprimir.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnComprimir.setBorder(null);
		btnComprimir.setBackground(Color.WHITE);
		getContentPane().add(btnComprimir);

		lblVolver = new JLabel("");
		lblVolver.setBounds(817, 36, 61, 44);
		getContentPane().add(lblVolver);
		lblVolver.setIcon(new ImageIcon(".\\img\\flechaAtras.png"));
		lblVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarVentana(1, 0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		getContentPane().add(lblVolver);

	}

}
