package archivos;

import java.io.Serializable;

public class Objetos implements Serializable {

	private static final long serialVersionUID = 1L;

	private String contenido;

	public Objetos(String contenido) {
		this.contenido = contenido;
	}

	public String getContenido() {
		return contenido;
	}

	@Override
	public String toString() {
		return "Contenido: " + contenido;
	}

}
