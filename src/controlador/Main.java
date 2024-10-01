package controlador;

import modelo.Modelo;
import vista.Vista;
import vista._00_InicioAplicacion;
import vista._01_AgregarArchivo;
import vista._02_DeserializarArchivos;
import vista._03_ComprimirDescomprimir;
import vista._04_VisualizarArchivos;
import vista._05_EliminarArchivos;

public class Main {
	
	public static void main(String[] args) {
		
		Modelo miModelo = new Modelo();
		Vista[] misVistas = new Vista[6];
		Controlador miControlador = new Controlador();
		
		misVistas[0] = new _00_InicioAplicacion();
		misVistas[1] = new _01_AgregarArchivo();
		misVistas[2] = new _02_DeserializarArchivos();
		misVistas[3] = new _03_ComprimirDescomprimir();
		misVistas[4] = new _04_VisualizarArchivos();
		misVistas[5] = new _05_EliminarArchivos();

		miModelo.setVista(misVistas);
		miControlador.setVista(misVistas);
		miControlador.setModelo(miModelo);

		for (Vista vista : misVistas) {
			vista.setModelo(miModelo);
			vista.setControlador(miControlador);
		}
		
		
	}

}
