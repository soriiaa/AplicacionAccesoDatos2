package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

import archivos.Objetos;
import controlador.Controlador;
import vista.Vista;

public class Modelo {

	private Vista[] misVistas;
	private Controlador miControlador;

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setVista(Vista[] misVistas) {
		this.misVistas = misVistas;
	}

	public boolean serializarObjeto(String contenido, int numeroArchivo) {

		Objetos objeto = new Objetos(contenido);

		try (FileOutputStream fos = new FileOutputStream(".\\archivos\\archivo" + numeroArchivo + ".txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(objeto);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Objetos> deserializarObjeto() {

		try {
			FileInputStream fileIn = new FileInputStream(".\\archivos\\archivo.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			List<Objetos> objetos = (List<Objetos>) in.readObject();
			return objetos;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;

	}

	private static class AppendableObjectOutputStream extends ObjectOutputStream {

		public AppendableObjectOutputStream(OutputStream out) throws IOException {
			super(out);
		}

		@Override
		protected void writeStreamHeader() throws IOException {
			reset();
		}
	}

}
