package vista;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Modelo;

public class _02_DeserializarObjetos extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblVolver;
	private JLabel lblTitulo;
	private JTable tableArchivos;
	private JLabel lblContenidoArchivo;
	private JTextPane txtContenidoDeserializado;
	private DefaultTableModel model;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public _02_DeserializarObjetos() {

		getContentPane().setLayout(null);

		lblTitulo = new JLabel("Deserializar Archivos");
		lblTitulo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
		lblTitulo.setBounds(260, 34, 365, 52);
		getContentPane().add(lblTitulo);
		setResizable(false);
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		setLocationRelativeTo(null);

		lblVolver = new JLabel("");
		lblVolver.setIcon(new ImageIcon(".\\img\\flechaAtras.png"));
		lblVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarVentana(2, 0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblVolver.setBounds(817, 11, 61, 44);
		getContentPane().add(lblVolver);

		txtContenidoDeserializado = new JTextPane();
		txtContenidoDeserializado.setEditable(false);
		txtContenidoDeserializado.setBounds(214, 402, 458, 71);
		getContentPane().add(txtContenidoDeserializado);

		lblContenidoArchivo = new JLabel("Contenido del Archivo deserializado:");
		lblContenidoArchivo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
		lblContenidoArchivo.setBounds(214, 362, 410, 30);
		getContentPane().add(lblContenidoArchivo);

		model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
		model.addColumn("Nombre Archivos");
		tableArchivos = new JTable(model);
		tableArchivos.setBounds(214, 125, 458, 193);
		tableArchivos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(tableArchivos);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

				File[] archivos = miControlador.cogerArchivos();

				if (archivos != null) {
					for (File archivo : archivos) {
						model.addRow(new Object[]{archivo.getName()});
					}
				}

			}
		});

	}
}
