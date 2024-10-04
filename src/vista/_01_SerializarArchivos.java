package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import modelo.Modelo;

public class _01_SerializarArchivos extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JTextField txtContenidoObjeto;
	private JButton btnAgregarObjeto;
	private JLabel lblVolver;
	private JLabel lblTitulo;
	private JLabel lblTituloTextField;
	private JLabel lblExito;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public _01_SerializarArchivos() {

		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().setBackground(new Color(173, 216, 230));
		getContentPane().setLayout(null);

		lblExito = new JLabel("Objeto serializado con éxito");
		lblExito.setForeground(new Color(0, 128, 0));
		lblExito.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblExito.setBounds(310, 399, 266, 31);
		lblExito.setVisible(false);
		getContentPane().add(lblExito);

		lblTitulo = new JLabel("Agregar Objeto");
		lblTitulo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 33));
		lblTitulo.setBounds(295, 30, 296, 44);
		getContentPane().add(lblTitulo);

		btnAgregarObjeto = new JButton("Agregar");
		btnAgregarObjeto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnAgregarObjeto.setEnabled(false);
		btnAgregarObjeto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAgregarObjeto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnAgregarObjeto.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		btnAgregarObjeto.setBounds(651, 270, 89, 23);
		getContentPane().add(btnAgregarObjeto);
		btnAgregarObjeto.setBackground(Color.white);
		btnAgregarObjeto.setBorder(null);

		txtContenidoObjeto = new JTextField();
		txtContenidoObjeto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				btnAgregarObjeto.setEnabled(comprobarCampo(txtContenidoObjeto.getText().toString()));
				lblExito.setVisible(false);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				btnAgregarObjeto.setEnabled(comprobarCampo(txtContenidoObjeto.getText().toString()));
				lblExito.setVisible(false);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				btnAgregarObjeto.setEnabled(comprobarCampo(txtContenidoObjeto.getText().toString()));
				lblExito.setVisible(false);
			}
		});
		txtContenidoObjeto.setBounds(149, 270, 492, 23);
		getContentPane().add(txtContenidoObjeto);
		txtContenidoObjeto.setColumns(10);
		txtContenidoObjeto.setBorder(null);
		txtContenidoObjeto.setBorder(BorderFactory.createCompoundBorder(txtContenidoObjeto.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));

		lblTituloTextField = new JLabel("Contenido a serializar:");
		lblTituloTextField.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
		lblTituloTextField.setBounds(148, 245, 256, 23);
		getContentPane().add(lblTituloTextField);

		lblVolver = new JLabel("");
		lblVolver.setIcon(new ImageIcon(".\\img\\flechaAtras.png"));
		lblVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblExito.setVisible(false);
				miControlador.cambiarVentana(1, 0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblVolver.setBounds(817, 11, 61, 44);
		getContentPane().add(lblVolver);

		btnAgregarObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean serializacionCorrecta = false;
				int salida = miControlador.crearArchivo();
				if (salida >= 0) {
					serializacionCorrecta = miControlador.serializarObjeto(txtContenidoObjeto.getText().toString(), salida);
				}
				
				if (serializacionCorrecta) {
					txtContenidoObjeto.setText("");
					lblExito.setVisible(true);
				}
			}
		});

	}

	public boolean comprobarCampo(String texto) {

		if (!texto.equals("")) {
			return true;
		} else {
			return false;
		}

	}
}
