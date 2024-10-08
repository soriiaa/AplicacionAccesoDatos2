package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

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

	public String deserializarObjeto(String nombreArchivo) {

		try {
			FileInputStream fileIn = new FileInputStream(".\\archivos\\" + nombreArchivo);
			if (!nombreArchivo.contains(".zip")) {
				ObjectInputStream in = new ObjectInputStream(fileIn);
				Object objetoDeserializado = in.readObject();
				String stringObjeto = "";
				stringObjeto = ((Objetos) objetoDeserializado).getContenido().toString();
				return stringObjeto;
			} else {
				return "Error";
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;

	}

	public boolean eliminarArchivo(String nombreArchivo) {

		String rutaArchivo = ".\\archivos\\" + nombreArchivo;

		File archivo = new File(rutaArchivo);

		if (archivo.delete()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean comprimir(String nombreArchivo, int numeroArchivos) {

		// Ruta del archivo que deseas comprimir
		String archivoParaComprimir = ".\\archivos\\" + nombreArchivo;
		// Ruta donde deseas guardar el archivo comprimido
		String archivoZip = ".\\archivos\\archivo_comprimido" + numeroArchivos + ".zip";

		byte[] buffer = new byte[1024];

		try {
			// Crear un FileOutputStream para el archivo comprimido
			FileOutputStream fos = new FileOutputStream(archivoZip);
			// Crear un ZipOutputStream para escribir el archivo comprimido
			ZipOutputStream zos = new ZipOutputStream(fos);

			// Crear una entrada de zip para el archivo .txt
			ZipEntry zipEntry = new ZipEntry("archivo.txt");
			zos.putNextEntry(zipEntry);

			// Leer el archivo de texto
			FileInputStream fis = new FileInputStream(archivoParaComprimir);

			int longitud;
			// Leer el archivo y escribirlo en el zip
			while ((longitud = fis.read(buffer)) > 0) {
				zos.write(buffer, 0, longitud);
			}

			// Cerrar las entradas
			fis.close();
			zos.closeEntry();
			zos.close();

			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean descomprimirZip(String nombreZip, int numeroDeTxt, File[] archivos) {

		// Ruta del archivo ZIP
		String archivoZip = ".\\archivos\\" + nombreZip;
		// Directorio donde deseas descomprimir el archivo
		String carpetaDestino = ".\\archivos\\";

		byte[] buffer = new byte[1024];

		try {
			// Crear un ZipInputStream para leer el archivo ZIP
			ZipInputStream zis = new ZipInputStream(new FileInputStream(archivoZip));
			ZipEntry entradaZip = zis.getNextEntry();

			// Iterar sobre las entradas del ZIP
			while (entradaZip != null) {

				for (File archivo : archivos) {
					if (archivo.getName().equals("archivo" + numeroDeTxt + ".txt")) {
						numeroDeTxt++;
					}
				}

				// Obtener el nombre de la entrada
				String nombreArchivo = "archivo" + numeroDeTxt + ".txt";
				// Crear un archivo para la entrada
				File archivoNuevo = new File(carpetaDestino + nombreArchivo);

				// Crear directorios si es necesario
				new File(archivoNuevo.getParent()).mkdirs();

				// Si la entrada es un archivo, extraerlo
				if (!entradaZip.isDirectory()) {
					FileOutputStream fos = new FileOutputStream(archivoNuevo);
					int longitud;
					while ((longitud = zis.read(buffer)) > 0) {
						fos.write(buffer, 0, longitud);
					}
					fos.close();
				}

				// Cerrar la entrada actual y pasar a la siguiente
				entradaZip = zis.getNextEntry();
			}

			// Cerrar el ZipInputStream
			zis.closeEntry();
			zis.close();

			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

}
