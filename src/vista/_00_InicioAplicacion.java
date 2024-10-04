package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Controlador;
import modelo.Modelo;

public class _00_InicioAplicacion extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JButton btnAgregarObjeto;
	private JButton btnDeserializarArchivos;
	private JButton btnVisualizarArchivos;
	private JLabel lblTitulo;

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public _00_InicioAplicacion() {
		
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().setBackground(new Color(173, 216, 230));
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		lblTitulo = new JLabel("Gestor de Archivos Avanzado");
		lblTitulo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
		lblTitulo.setBounds(191, 50, 506, 34);
		lblTitulo.requestFocus(true);
		getContentPane().add(lblTitulo);
		
		btnAgregarObjeto = new JButton("Agregar Objeto");
		btnAgregarObjeto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAgregarObjeto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarVentana(0,1);
			}
		});
		btnAgregarObjeto.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		btnAgregarObjeto.setBounds(38, 228, 228, 51);
		getContentPane().add(btnAgregarObjeto);
		btnAgregarObjeto.setBackground(Color.white);
		btnAgregarObjeto.setBorder(null);
		
		
		btnDeserializarArchivos = new JButton("Deserializar Archivos");
		btnDeserializarArchivos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDeserializarArchivos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarVentana(0, 2);
			}
		});
		btnDeserializarArchivos.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		btnDeserializarArchivos.setBounds(615, 228, 228, 51);
		getContentPane().add(btnDeserializarArchivos);
		btnDeserializarArchivos.setBackground(Color.white);
		btnDeserializarArchivos.setBorder(null);
		
		btnVisualizarArchivos = new JButton("Visualizar Archivos");
		btnVisualizarArchivos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVisualizarArchivos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarVentana(0, 3);
			}
		});
		btnVisualizarArchivos.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		btnVisualizarArchivos.setBounds(329, 355, 228, 51);
		getContentPane().add(btnVisualizarArchivos);
		btnVisualizarArchivos.setBackground(Color.white);
		btnVisualizarArchivos.setBorder(null);
		
	}
}
