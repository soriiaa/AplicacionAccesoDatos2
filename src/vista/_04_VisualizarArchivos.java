package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controlador.Controlador;
import modelo.Modelo;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class _04_VisualizarArchivos extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JTable table;
	private JLabel lblVolver;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public _04_VisualizarArchivos() {

		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().setBackground(new Color(173, 216, 230));
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Visualizar Archivos\r\n");
		lblTitulo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
		lblTitulo.setBounds(275, 22, 337, 68);
		getContentPane().add(lblTitulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(275, 151, 337, 290);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		lblVolver = new JLabel("");
		lblVolver.setBounds(817, 22, 42, 35);
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
		lblVolver.setBounds(817, 11, 61, 44);
		getContentPane().add(lblVolver);

		

	}

}
