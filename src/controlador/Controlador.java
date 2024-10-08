package controlador;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;

import archivos.Objetos;
import modelo.Modelo;
import vista.Vista;

public class Controlador {

	private Modelo miModelo;
	private Vista[] misVistas;

	public Controlador() {
		super();
	}

	public void setVista(Vista[] misVistas) {
		this.misVistas = misVistas;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void cambiarVentana(int desde, int hasta) {
		((JFrame) misVistas[desde]).setVisible(false);
		((JFrame) misVistas[hasta]).setVisible(true);
	}

	public boolean serializarObjeto(String contenido, int numeroArchivo) {
		return miModelo.serializarObjeto(contenido, numeroArchivo);
	}

	public String deserializarObjeto(String nombreArchivo) {
		return miModelo.deserializarObjeto(nombreArchivo);
	}

	public int contarArchivosTxt() {

		File carpeta = new File(".\\archivos");
		
		int contador = 0;

		if (carpeta.isDirectory()) {
			File[] listaArchivos = carpeta.listFiles();
			
			if (listaArchivos.length != 0) {
				for (File archivo : listaArchivos) {
					if (archivo.getName().toString().contains(".txt")) {
						contador++;
					}
				}
			}
			return contador;
		}
		return -1;
	}
	
	public int contarArchivosZip() {

		File carpeta = new File(".\\archivos");
		
		int contador = 0;

		if (carpeta.isDirectory()) {
			File[] listaArchivos = carpeta.listFiles();
			
			if (listaArchivos.length != 0) {
				for (File archivo : listaArchivos) {
					if (archivo.getName().toString().contains(".zip")) {
						contador++;
					}
				}
			}
			return contador;
		}
		return -1;
	}
	
	public File[] cogerArchivos() {

		File carpeta = new File(".\\archivos");

		if (carpeta.isDirectory()) {
			File[] listaArchivos = carpeta.listFiles();
			return listaArchivos;
		}
		return null;
	}

	public int crearArchivo() {

		try {
			
			int numeroArchivos = contarArchivosTxt();
			
			File[] archivos = cogerArchivos();
			
			for (File archivo : archivos) {
				if (archivo.getName().equals("archivo" + numeroArchivos + ".txt")) {
					numeroArchivos++;
				}
			}
			
			File archivo = new File(".\\archivos\\archivo" + numeroArchivos + ".txt");

			if (archivo.createNewFile()) {
				return numeroArchivos;
			} else {
				return -1;
			}
		} catch (IOException e) {
			System.out.println("Ocurrió un error al crear el archivo.");
			e.printStackTrace();
			return -1;
		}

	}

	public boolean eliminarArchivo(String nombreArchivo) {
		
		return miModelo.eliminarArchivo(nombreArchivo);
		
	}

	public boolean comprimir(String nombreArchivo) {
		
		return miModelo.comprimir(nombreArchivo, contarArchivosZip());
		
	}

	public boolean descomprimirZip(String nombreZip) {
		
		return miModelo.descomprimirZip(nombreZip, contarArchivosTxt(), cogerArchivos());
		
	}

}
