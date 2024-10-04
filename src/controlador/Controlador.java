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

	public List<Objetos> deserializarObjeto() {
		return miModelo.deserializarObjeto();
	}

	public int contarArchivos() {

		File carpeta = new File(".\\archivos");

		if (carpeta.isDirectory()) {
			File[] listaArchivos = carpeta.listFiles();
			return listaArchivos.length;
		}
		return -1;
	}

	public int crearArchivo() {

		try {
			int numeroArchivos = contarArchivos();
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

}
