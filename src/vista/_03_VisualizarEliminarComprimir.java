package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Modelo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _03_VisualizarEliminarComprimir extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;

	private JLabel lblVolver;
	private JButton btnEliminar;
	private JButton btnDescomprimir;
	private JButton btnComprimir;
	private JLabel lblTitulo;
	private JTable tableArchivos;
	private DefaultTableModel model;
	private JLabel lblComprimidoExito;
	private JLabel lblEliminadoExito;
	private JLabel lblDescomprimidoExito;
	private JLabel lblComprimidoError;
	private JLabel lblEliminadoError;
	private JLabel lblDescomprimidoError;
	private JButton btnActualizar;

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
		
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("Nombre Archivos");

		tableArchivos = new JTable(model);
		
		tableArchivos.setBounds(316, 119, 506, 391);
		tableArchivos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(tableArchivos);
		
		lblComprimidoExito = new JLabel("Archivo Comprimido con Éxito");
		lblComprimidoExito.setForeground(new Color(0, 128, 0));
		lblComprimidoExito.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblComprimidoExito.setBounds(404, 520, 340, 30);
		lblComprimidoExito.setVisible(false);
		getContentPane().add(lblComprimidoExito);
		
		lblComprimidoError = new JLabel("Error al Comprimir Archivo");
		lblComprimidoError.setForeground(new Color(199, 0, 0));
		lblComprimidoError.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblComprimidoError.setBounds(404, 520, 340, 30);
		lblComprimidoError.setVisible(false);
		getContentPane().add(lblComprimidoError);
		
		lblEliminadoExito = new JLabel("Archivo Eliminado con Éxito");
		lblEliminadoExito.setForeground(new Color(0, 128, 0));
		lblEliminadoExito.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEliminadoExito.setBounds(414, 520, 319, 30);
		lblEliminadoExito.setVisible(false);
		getContentPane().add(lblEliminadoExito);
		
		lblEliminadoError = new JLabel("Error al Eliminar el Archivo");
		lblEliminadoError.setForeground(new Color(199, 0, 0));
		lblEliminadoError.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEliminadoError.setBounds(414, 520, 319, 30);
		lblEliminadoError.setVisible(false);
		getContentPane().add(lblEliminadoError);
		
		lblDescomprimidoExito = new JLabel("Archivo Descomprimido con Éxito");
		lblDescomprimidoExito.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDescomprimidoExito.setForeground(new Color(0, 128, 0));
		lblDescomprimidoExito.setBounds(381, 520, 382, 33);
		lblDescomprimidoExito.setVisible(false);
		getContentPane().add(lblDescomprimidoExito);
		
		lblDescomprimidoError = new JLabel("Error al Descomprimir Archivo");
		lblDescomprimidoError.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDescomprimidoError.setForeground(new Color(199, 0, 0));
		lblDescomprimidoError.setBounds(381, 520, 382, 33);
		lblDescomprimidoError.setVisible(false);
		getContentPane().add(lblDescomprimidoError);

		lblTitulo = new JLabel("Visualizar, Descomprimir y Comprimir Archivos");
		lblTitulo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
		lblTitulo.setBounds(32, 11, 767, 63);
		getContentPane().add(lblTitulo);

		btnComprimir = new JButton("Comprimir");
		
		btnComprimir.setEnabled(false);
		btnComprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnComprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				if (btnComprimir.isEnabled()) {
					btnComprimir.setBackground(new Color(38, 201, 86));
				}
			}
		});
		btnComprimir.setBackground(new Color(38, 251, 86));
		btnComprimir.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		btnComprimir.setBounds(32, 133, 193, 43);
		getContentPane().add(btnComprimir);
		btnComprimir.setBorder(null);

		btnDescomprimir = new JButton("Descomprimir");
		
		btnDescomprimir.setEnabled(false);
		btnDescomprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDescomprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				if (btnDescomprimir.isEnabled()) {
					btnDescomprimir.setBackground(new Color(60, 146, 203));
				}
			}
		});
		btnDescomprimir.setBackground(new Color(108, 196, 253));
		btnDescomprimir.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		btnDescomprimir.setBounds(32, 283, 193, 43);
		getContentPane().add(btnDescomprimir);
		btnDescomprimir.setBorder(null);

		btnEliminar = new JButton("Eliminar");
		
		btnEliminar.setEnabled(false);
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				if (btnEliminar.isEnabled()) {
					btnEliminar.setBackground(new Color(205, 27, 12));
				}

			}
		});
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
		
		btnActualizar = new JButton("Actualizar");
		
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnActualizar.setBounds(316, 84, 97, 21);
		btnActualizar.setBorder(null);
		btnActualizar.setBackground(new Color(255, 255, 255));
		getContentPane().add(btnActualizar);

		
		
		

		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnComprimir.setBackground(new Color(38, 251, 86));
				btnDescomprimir.setBackground(new Color(108, 196, 253));
				btnEliminar.setBackground(new Color(255, 77, 62));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				tableArchivos.clearSelection();
				deshabilitarBotones();
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

				File[] archivos = miControlador.cogerArchivos();

				if (archivos != null) {
					model.setRowCount(0);
					for (File archivo : archivos) {
						model.addRow(new Object[] { archivo.getName() });
					}
				}

			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int numeroFila = tableArchivos.getSelectedRow();
				
				boolean respuesta = miControlador.eliminarArchivo(tableArchivos.getValueAt(numeroFila, 0).toString());
				desabilidarEtiquetas();
				actualizarTabla();
				
				if (respuesta) {
					lblEliminadoExito.setVisible(true);
				} else {
					lblEliminadoError.setVisible(true);
				}
			}
		});
		
		btnComprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int numeroFila = tableArchivos.getSelectedRow();
				boolean salida = miControlador.comprimir(tableArchivos.getValueAt(numeroFila, 0).toString());
				desabilidarEtiquetas();
				actualizarTabla();
				
				if (salida) {
					lblComprimidoExito.setVisible(true);
				} else {
					lblComprimidoError.setVisible(true);
				}
				
			}
		});
		
		btnDescomprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int numeroFila = tableArchivos.getSelectedRow();
				boolean respuesta = miControlador.descomprimirZip(tableArchivos.getValueAt(numeroFila, 0).toString());
				
				desabilidarEtiquetas();
				actualizarTabla();
				
				if (respuesta) {
					lblDescomprimidoExito.setVisible(true);
				} else {
					lblDescomprimidoError.setVisible(true);
				}
				
				
				
			}
		});
		
		tableArchivos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int numeroFila = tableArchivos.getSelectedRow();
				if (tableArchivos.getValueAt(numeroFila, 0).toString().contains(".txt")) {
					btnComprimir.setEnabled(true);
					btnEliminar.setEnabled(true);
				} else {
					btnDescomprimir.setEnabled(true);
					btnEliminar.setEnabled(true);
				}
			}
		});
		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla();
			}
		});
		
	}
	
	public void actualizarTabla() {
		File[] archivos = miControlador.cogerArchivos();

		if (archivos != null) {
			model.setRowCount(0);
			for (File archivo : archivos) {
				model.addRow(new Object[] { archivo.getName() });
			}
		}
	}

	public void deshabilitarBotones() {
		btnComprimir.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnDescomprimir.setEnabled(false);
	}
	
	public void desabilidarEtiquetas() {
		lblComprimidoError.setVisible(false);
		lblComprimidoExito.setVisible(false);
		lblDescomprimidoError.setVisible(false);
		lblDescomprimidoExito.setVisible(false);
		lblEliminadoError.setVisible(false);
		lblEliminadoExito.setVisible(false);
	}
}
