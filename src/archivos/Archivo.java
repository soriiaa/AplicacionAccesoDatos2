package archivos;

import java.io.Serializable;

public class Archivo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String contenido;

	public Archivo(String nombre, String contenido) {
		this.nombre = nombre;
		this.contenido = contenido;
	}

	public String getNombre() {
		return nombre;
	}

	public String getContenido() {
		return contenido;
	}

	@Override
	public String toString() {
		return "Archivo: " + nombre + ", Contenido: " + contenido;
	}

}
