package ajptech.difundecev3;

import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

public class DatosVersionImpl implements DatosVersion {
	
	private static final String NOMBRE = "DifundeCEV";
	private static final String VERSION = "Versión v1.2.0.2";
	private static final String FECHA = "Última actualización: 07/07/2022";
	
	//private static final String DIRECTORIO = "C:/Archivos de programa/AJPalma Estampitas/Data/";
	private String v, f, dir1, n;
	private Image icono;
	
	public DatosVersionImpl(){
		n = NOMBRE;
		v = VERSION;
		f = FECHA;
		Path currentRelativePath = Paths.get("");
		String ejem = currentRelativePath.toAbsolutePath().toString();
		ejem.replace("\\","/");
		dir1 = ejem+"/Data/";
		icono = new ImageIcon(getClass().getResource("favCEV2.png")).getImage();

		//dir = DIRECTORIO;
		//i = icono;
	}

	public String getVersion() {
		return v;
	}

	public String getFecha() {
		return f;
	}
	
	public String getDirectorio(){
		return dir1;
	}

	public Image getIcono() {
		return icono;
	}

	public String getNombre() {
		return n;
	}

	public String getCabecera() {
		return n+" - "+v+" - "+f;
	}

}
