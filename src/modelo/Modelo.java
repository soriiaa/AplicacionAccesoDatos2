package modelo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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

	public void serializarArchivo(String contenido) {
		
		Objetos objeto = new Objetos(contenido);
		
		try {
            FileOutputStream fos = new FileOutputStream(".\\archivos\\archivo.txt", true);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(objeto);
            
            out.close();
            fos.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
		
	}

}
