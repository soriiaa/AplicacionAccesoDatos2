package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.Controlador;
import modelo.Modelo;

public class _05_EliminarArchivos extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnEliminar;
	private JLabel lblVolver;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public _05_EliminarArchivos() {

		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().setBackground(new Color(173, 216, 230));
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Eliminar Archivos");
		lblTitulo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
		lblTitulo.setBounds(294, 35, 300, 61);
		getContentPane().add(lblTitulo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 163, 360, 271);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnEliminar.setBounds(535, 462, 89, 23);
		getContentPane().add(btnEliminar);
		btnEliminar.setBackground(Color.white);
		btnEliminar.setBorder(null);

		lblVolver = new JLabel("");
		lblVolver.setBounds(836, 35, 42, 35);
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
