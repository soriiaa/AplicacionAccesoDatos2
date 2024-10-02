package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import modelo.Modelo;

public class _01_AgregarArchivo extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JTextField txtNombreDelArchivo;
	private JButton btnAgregarArchivo;
	private JLabel lblVolver;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public _01_AgregarArchivo() {

		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().setBackground(new Color(173, 216, 230));
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Agregar Archivo");
		lblTitulo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 33));
		lblTitulo.setBounds(291, 11, 306, 44);
		getContentPane().add(lblTitulo);

		btnAgregarArchivo = new JButton("Agregar");
		btnAgregarArchivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAgregarArchivo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnAgregarArchivo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnAgregarArchivo.setBounds(645, 269, 89, 23);
		getContentPane().add(btnAgregarArchivo);
		btnAgregarArchivo.setBackground(Color.white);
		btnAgregarArchivo.setBorder(null);

		txtNombreDelArchivo = new JTextField();
		txtNombreDelArchivo.setBounds(149, 270, 492, 23);
		getContentPane().add(txtNombreDelArchivo);
		txtNombreDelArchivo.setColumns(10);
		txtNombreDelArchivo.setBorder(null);

		JLabel lblNewLabel = new JLabel("Nombre del archivo\r\n:");
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
		lblNewLabel.setBounds(148, 245, 233, 23);
		getContentPane().add(lblNewLabel);

		lblVolver = new JLabel("");
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
