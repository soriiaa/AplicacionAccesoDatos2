package vista;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import archivos.Objetos;
import controlador.Controlador;
import modelo.Modelo;

public class _02_DeserializarObjetos extends JFrame implements Vista {

	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblVolver;
	private JTextPane txtObjetos;
	private JLabel lblTitulo;
	private JScrollPane scrollPane;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public _02_DeserializarObjetos() {

		getContentPane().setLayout(null);

		lblTitulo = new JLabel("DeserializarObjetos");
		lblTitulo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 30));
		lblTitulo.setBounds(270, 34, 346, 52);
		getContentPane().add(lblTitulo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(214, 129, 458, 337);
		getContentPane().add(scrollPane);

		txtObjetos = new JTextPane();
		scrollPane.setViewportView(txtObjetos);
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
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
            	
                List<Objetos> objetos = miControlador.deserializarObjeto();
                StringBuilder texto = new StringBuilder();
                
                for (Objetos objeto : objetos) {
                	texto.append(objeto.toString());
                	texto.append("\n");
                }
                
                txtObjetos.setText(texto.toString());
                
            }
        });

	}
}
