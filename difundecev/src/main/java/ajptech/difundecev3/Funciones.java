package ajptech.difundecev3;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class Funciones {
	
	// Obtiene el titular de la noticia a traves del enlace de la publicacion
	public static String traduceURL2(String url1) throws IOException {
		
		InputStream response = null;
		String nombre = "";
		try {
			response = new URL(url1).openStream();
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(response);
			String responseBody = scanner.useDelimiter("\\A").next();
			nombre = responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		//return nombre.replaceFirst("&#8211; CofradÃ­as El Viso", " ");
		String res = nombre.replaceAll("Ãº", "ú").replaceAll("Ã³", "ó").replaceFirst("Ã±", "ñ").replaceAll("&#8211;", "-")
				.replaceAll("Ã­", "í").replaceAll("Ã¡", "á").replaceAll("Ã©", "é").replaceAll("&#8220;", "'")
				.replaceAll("&#8221;", "'").replaceAll("Ã", "Á").replaceAll("Ã‰", "É").replaceAll("Ã", "Í")
				.replaceAll("Ã“", "Ó").replaceAll("Ãš", "Ú").replaceAll("Ã‘", "Ñ").replaceAll("Âª", "ª")
				.replaceAll("Â«","«").replaceAll("Â»", "»")
				.replaceFirst(" - Cofradías El Viso", " ");
		return res;

	}
	
	// Comprueba que no hay errores de consistencia si se quiere añadir una cuenta no registrada
	public static boolean compruebaOtros(JCheckBox marca, JTextField texto) {
		boolean res = false;
		if(marca.isSelected() && texto.getText().equals("")) {
			res = true;
		}else if(!marca.isSelected() && !texto.getText().equals("")) {
			res = true;
		}
		
		return res;
	}


}
