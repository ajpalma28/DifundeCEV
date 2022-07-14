package ajptech.difundecev3;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Ventana extends JFrame {
	
	static Ventana difunde;
	private static final long serialVersionUID = 1L;
	JLabel labelURL, introdzHdad, revise, introdzAno;
	static JTextField extraeURL, meteOtros;
	static JButton twittear, cancelar, txtInsta, txtTg;
	static JComboBox<HermandadesTW> hdadPedido;
	JCheckBox reyes, rocio, alcora, carmen, borriquita, esperanza, cautivo, veracruz, piedad, nazareno, dolores,
		ayuntamiento, consejo, rmartin, parroquia, sfj, misericordia, corazon, arzobis, bmvisoalcor, ccttmerced,
		leonredondo, others;
    FileReader fr = null;
    BufferedReader br = null;
	
	public Ventana(){
		
		setLayout(null);
		
		final DatosVersion datosprog = new DatosVersionImpl();
		setIconImage(datosprog.getIcono());
        setTitle(datosprog.getCabecera());

		labelURL = new JLabel("Introduzca la URL:");
		labelURL.setBounds(10,0+92+10,350,30);
		add(labelURL);
		extraeURL = new JTextField();
		extraeURL.setBounds(10,30+92+10,345+300,30);
		add(extraeURL);
		/*
		hdadPedido = new JComboBox<Hermandades>();
        extracted1();
        hdadPedido.setBounds(10,90,350,30);
        hdadPedido.setBackground(Color.WHITE);*/
		
		rocio = new JCheckBox("ROCÍO");
        add(rocio); rocio.setBounds(15, 90+92, 85, 25);
        
        carmen = new JCheckBox("CARMEN");
        add(carmen); carmen.setBounds(100, 90+92, 85, 25);
        
        alcora = new JCheckBox("ALCORA");
        add(alcora); alcora.setBounds(185,90+92,85,25);
        
        borriquita = new JCheckBox("BORRIQUITA");
        add(borriquita); borriquita.setBounds(270, 90+92, 100, 25);
        
        esperanza = new JCheckBox("ESPERANZA");
        add(esperanza); esperanza.setBounds(370, 90+92, 100, 25);
        
        cautivo = new JCheckBox("CAUTIVO");
        add(cautivo); cautivo.setBounds(470, 90+92, 85, 25);
        
        veracruz = new JCheckBox("VERA-CRUZ");
        add(veracruz); veracruz.setBounds(555, 90+92, 100, 25);
        
        piedad = new JCheckBox("PIEDAD");
        add(piedad); piedad.setBounds(15, 120+92, 85, 25);
        
        nazareno = new JCheckBox("NAZARENO");
        add(nazareno); nazareno.setBounds(100, 120+92, 100, 25);
        
        dolores = new JCheckBox("DOLORES");
        add(dolores); dolores.setBounds(200, 120+92, 85, 25);
        
        parroquia = new JCheckBox("PARROQUIA");
        add(parroquia); parroquia.setBounds(285, 120+92, 100, 25);
        
        ayuntamiento = new JCheckBox("AYUNTAMIENTO");
        add(ayuntamiento); ayuntamiento.setBounds(385, 120+92, 120, 25);
        
        rmartin = new JCheckBox("R. MARTIN");
        add(rmartin); rmartin.setBounds(505, 120+92, 85, 25);
        
        bmvisoalcor = new JCheckBox("Banda Sta María del Alcor");
        add(bmvisoalcor); bmvisoalcor.setBounds(15, 150+92, 180, 25);
        
        ccttmerced = new JCheckBox("Banda de la Merced");
        add(ccttmerced); ccttmerced.setBounds(195, 150+92, 150, 25);
        
        sfj = new JCheckBox("SAN FRANCISCO JAVIER");
        add(sfj); sfj.setBounds(345, 150+92, 170, 25);
        
        misericordia = new JCheckBox("MISERICORDIA");
        add(misericordia); misericordia.setBounds(515, 150+92, 120, 25);
        
        corazon = new JCheckBox("CORAZÓN DE JESÚS");
        add(corazon); corazon.setBounds(15, 180+92, 150, 25);
        
        arzobis = new JCheckBox("ARZOBISPADO");
        add(arzobis); arzobis.setBounds(165, 180+92, 120, 25);
        
        consejo = new JCheckBox("CONSEJO");
        add(consejo); consejo.setBounds(285, 180+92, 100, 25);
        
        reyes = new JCheckBox("REYES");
        add(reyes); reyes.setBounds(385, 180+92, 80, 25);
        
        leonredondo = new JCheckBox("LEÓN REDONDO");
        add(leonredondo); leonredondo.setBounds(465, 180+92, 120, 25);
        
        others = new JCheckBox("OTROS");
        add(others); others.setBounds(15, 210+92+2, 80, 25);
        
        meteOtros = new JTextField();
        meteOtros.setBounds(100,210+92,345+100,30);
		add(meteOtros);
		
        twittear = new JButton("Publicar Tweet");
        //twittear.setBounds(130,230+92+30,120,30);
        twittear.setBounds(45,230+92+30,120,30);
        add(twittear);
        cancelar = new JButton("Cancelar");
        txtInsta = new JButton("Texto Instagram");
        //cancelar.setBounds(430, 230+92+30, 120, 30);
        cancelar.setBounds(495, 230+92+30, 120, 30);
        //txtInsta.setBounds(280,230+92+30,120,30);
        txtInsta.setBounds(195,230+92+30,120,30);
        txtTg = new JButton("Texto Telegram");
        txtTg.setBounds(345, 230+92+30, 120, 30);
        add(txtInsta);
        add(cancelar);
        add(txtTg);
        
        JLabel abajo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("banner-up.png")).getImage()));
        abajo.setBounds(0,0,675,92);
        getContentPane().add(abajo, null);
        
        twittear.addActionListener (new ActionListener () {
        	public void actionPerformed (ActionEvent e) {
        		//Hermandades hdad = (Hermandades) hdadPedido.getSelectedItem();
        		if(extraeURL.getText().equals("")) {
        			JOptionPane.showMessageDialog(null,"Por favor, introduzca el enlace de la entrada",
        					"URL no encontrada",JOptionPane.ERROR_MESSAGE,
    						new ImageIcon(getClass().getResource("MensajeError.png")));
        		} else if (Funciones.compruebaOtros(others, meteOtros)) {
        			JOptionPane.showMessageDialog(null,"Por favor, compruebe que el apartado OTROS es correcto, marcando la casilla y añadiendo las menciones",
        					"Inconsistencia con otras cuentas",JOptionPane.ERROR_MESSAGE,
    						new ImageIcon(getClass().getResource("MensajeError.png")));
        		} else {
        			
        			String menciones = generaMencionesTW(); 
            		String titular = "";
            		String url = extraeURL.getText();
            		
            		try {
            			
    					titular = Funciones.traduceURL2(url);
    					
    				} catch (FileNotFoundException e1) {
    					
    					JOptionPane.showMessageDialog(null,"Por favor, revise el enlace de la entrada. Entrada no válida.",
            					"URL no encontrada",JOptionPane.ERROR_MESSAGE,
        						new ImageIcon(getClass().getResource("MensajeError.png")));
    					e1.printStackTrace();
    					
    				} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
            		
            		String tweet = "🔴 "+titular+"\n\n⬇ "+menciones+"\n"+url;
            		
            		try {  
            		  ConfigurationBuilder cb = new ConfigurationBuilder();
            		  cb.setDebugEnabled(true)
            		  	.setOAuthConsumerKey("dL3ckuVSpgolw1sWIvbL4b301")
            		  	.setOAuthConsumerSecret("IQi73s7DrgCeboIaUikOGK6IRADhNZURBLiXo0a06yrYfNk490")
            		  	.setOAuthAccessToken("4091811677-X5ANICT0ecHDFXwjgIzzQMQt6umSQfePBMUSNU2")
            		  	.setOAuthAccessTokenSecret("UyscrV8VKU0SdhqOGf7fVlTG5232B6N9bMNGClgDjgLg9");
            		  TwitterFactory tf = new TwitterFactory(cb.build());
            		  Twitter twitter = tf.getInstance();
                  	  /*Twitter twitter = new TwitterFactory().getInstance();*/           
                  	  twitter.updateStatus(tweet);
                  	  JOptionPane.showMessageDialog(null,tweet,"Tweet publicado",JOptionPane.INFORMATION_MESSAGE,
    						new ImageIcon(getClass().getResource("MensajeOK.png")));
    				  reiniciaProceso();
                  	} catch (TwitterException te) {
                  	  te.printStackTrace();
                  	  JOptionPane.showMessageDialog(null,"ERROR. No se ha podido publicar el tweet.",
        					"Tweet no publicado",JOptionPane.ERROR_MESSAGE,
    						new ImageIcon(getClass().getResource("MensajeError.png")));
                  	  //System.out.println("Error en la conexión: " + te.getMessage());         
                  	} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,e1.toString(),
	        					"Tweet no publicado",JOptionPane.ERROR_MESSAGE,
	    						new ImageIcon(getClass().getResource("MensajeError.png")));
					} 
            		
            		//System.out.println(tweet);
            		            		
        		}
        		
        		
        	}
        }); 
        
        txtInsta.addActionListener (new ActionListener () {
        	public void actionPerformed (ActionEvent e) {
        		if(extraeURL.getText().equals("")) {
        			JOptionPane.showMessageDialog(null,"Por favor, introduzca el enlace de la entrada",
        					"URL no encontrada",JOptionPane.ERROR_MESSAGE,
    						new ImageIcon(getClass().getResource("MensajeError.png")));
        		} else if (Funciones.compruebaOtros(others, meteOtros)) {
        			JOptionPane.showMessageDialog(null,"Por favor, compruebe que el apartado OTROS es correcto, marcando la casilla y añadiendo las menciones",
        					"Inconsistencia con otras cuentas",JOptionPane.ERROR_MESSAGE,
    						new ImageIcon(getClass().getResource("MensajeError.png")));
        		} else {
        			
        			String menciones = generaMencionesIG(); 
            		String titular = "";
            		String url = extraeURL.getText();
            		
            		try {
            			
    					titular = Funciones.traduceURL2(url);
    					
    				} catch (FileNotFoundException e1) {
    					
    					JOptionPane.showMessageDialog(null,"Por favor, revise el enlace de la entrada. Entrada no válida.",
            					"URL no encontrada",JOptionPane.ERROR_MESSAGE,
        						new ImageIcon(getClass().getResource("MensajeError.png")));
    					e1.printStackTrace();
    					
    				} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		
            		String tweet = "🔴 "+titular+"\n\n⬇ "+menciones+"\n"+url+"\n#cofradiaselviso #elvisodelalcor";
            		
            		StringSelection sS = new StringSelection(tweet);
            		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
            		clip.setContents(sS, null);
            		
            		//System.out.println(tweet);
            		
            		JOptionPane.showMessageDialog(null,tweet,"El texto para la publicación de Instagram se ha creado y copiado correctamente",
            				JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("MensajeOK.png")));
    				reiniciaProceso();
            		            		
        		}
        		
        	}
        }); 
        
        txtTg.addActionListener (new ActionListener () {
        	public void actionPerformed (ActionEvent e) {
        		if(extraeURL.getText().equals("")) {
        			JOptionPane.showMessageDialog(null,"Por favor, introduzca el enlace de la entrada",
        					"URL no encontrada",JOptionPane.ERROR_MESSAGE,
    						new ImageIcon(getClass().getResource("MensajeError.png")));
        		} else {
        			
            		String titular = "";
            		String url = extraeURL.getText();
            		
            		try {
            			
    					titular = Funciones.traduceURL2(url);
    					
    				} catch (FileNotFoundException e1) {
    					
    					JOptionPane.showMessageDialog(null,"Por favor, revise el enlace de la entrada. Entrada no válida.",
            					"URL no encontrada",JOptionPane.ERROR_MESSAGE,
        						new ImageIcon(getClass().getResource("MensajeError.png")));
    					e1.printStackTrace();
    					
    				} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		            		
            		String tweet = "🔴 "+titular.toUpperCase()+"\n\n"+url;
            		
            		StringSelection sS = new StringSelection(tweet);
            		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
            		clip.setContents(sS, null);
            		
            		//System.out.println(tweet);
            		
            		JOptionPane.showMessageDialog(null,tweet,"El texto para la publicación de Telegram se ha creado y copiado correctamente",
            				JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("MensajeOK.png")));
    				reiniciaProceso();
            		            		
        		}
        		
        	}
        }); 
        
		cancelar.setActionCommand("Cancelar");
        
        cancelar.addActionListener (new ActionListener () {
        	public void actionPerformed (ActionEvent e) {
        		System.exit(0);
        	}
        	
        });
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza el programa cuando se da click en la X

	}
	
	/*private void extracted1() {
		hdadPedido.setModel(new DefaultComboBoxModel<HermandadesTW>(HermandadesTW.values()));
	}*/
	
	/*private void extracted2() {
		DatosVersion datosprog = new DatosVersionImpl();
		File directorio = new File(datosprog.getDirectorio());
		Integer[] años = new Integer[directorio.list().length];
		for(int i=0; i<directorio.list().length; i++){
			años[i] = Integer.parseInt(directorio.list()[i]);
		}
		//añoPedido.setModel(new DefaultComboBoxModel<Año>(Año.values()));
		añoPedido.setModel(new DefaultComboBoxModel<Integer>(años));
	}*/

	public static void main(String[] args) {
		try{	  
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		}
			catch (Exception e)
		{
			e.printStackTrace();
		}
		difunde = new Ventana();
		difunde.setBounds(445,330,380+300,310+100+30);
        difunde.setVisible(true);
        difunde.setLocationRelativeTo(null); 
	}
	
	
	public String generaMencionesTW() {
		String menciones = "";
		
		if(rocio.isSelected()) {
			menciones = menciones + HermandadesTW.ROCIO.toString();
		}
		
		if(carmen.isSelected()) {
			menciones = menciones + HermandadesTW.CARMEN.toString();
		}
		
		if(alcora.isSelected()) {
			menciones = menciones + HermandadesTW.PATRONA.toString();
		}
		
		if(borriquita.isSelected()) {
			menciones = menciones + HermandadesTW.BORRIQUITA.toString();
		}
		
		if(esperanza.isSelected()) {
			menciones = menciones + HermandadesTW.ESPERANZA.toString();
		}
		
		if(cautivo.isSelected()) {
			menciones = menciones + HermandadesTW.CAUTIVO.toString();
		}
		
		if(veracruz.isSelected()) {
			String name = HermandadesTW.VERACRUZ.toString(); 
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}	
		}
		
		if(piedad.isSelected()) {
			menciones = menciones + HermandadesTW.PIEDAD.toString();
		}
		
		if(nazareno.isSelected()) {
			String name = HermandadesTW.NAZARENO.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		
		if(dolores.isSelected()) {
			menciones = menciones + HermandadesTW.DOLORES.toString();
		}
		
		if(parroquia.isSelected()) {
			String name = HermandadesTW.PARROQUIA.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		
		if(ayuntamiento.isSelected()) {
			String name = HermandadesTW.AYUNTAMIENTO.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + HermandadesTW.AYUNTAMIENTO.toString();
			}
		}
		
		if(rmartin.isSelected()) {
			menciones = menciones + HermandadesTW.RAMONMARTIN.toString();
		}
		
		if(leonredondo.isSelected()) {
			menciones = menciones + HermandadesTW.JOSEANTONIO.toString();
		}
		
		if(bmvisoalcor.isSelected()) {
			menciones = menciones + HermandadesTW.BANDAVISO.toString();
		}
		
		if(ccttmerced.isSelected()) {
			menciones = menciones + HermandadesTW.MERCED.toString();
		}
		
		if(sfj.isSelected()) {
			String name = HermandadesTW.SFJ.toString(); 
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		
		if(misericordia.isSelected()) {
			String name = HermandadesTW.MISERICORDIA.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		
		if(corazon.isSelected()) {
			String name = HermandadesTW.CORAZON.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		
		if(arzobis.isSelected()) {
			menciones = menciones + HermandadesTW.ARZOBISPADO.toString();
		}
		
		if(consejo.isSelected()) {
			String name = HermandadesTW.CONSEJO.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		
		if(reyes.isSelected()) {
			String name = HermandadesTW.REYES.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		
		if(others.isSelected()) {
			String auxi = meteOtros.getText();
			if (auxi.length()>3) {
				menciones = menciones + añadeOtros(auxi);
			}
		}
		
		return menciones;
	}
	
	public String generaMencionesIG() {
		String menciones = "";
		if(rocio.isSelected()) {
			menciones = menciones + HermandadesIG.ROCIO.toString();
		}
		if(carmen.isSelected()) {
			menciones = menciones + HermandadesIG.CARMEN.toString();
		}
		if(alcora.isSelected()) {
			menciones = menciones + HermandadesIG.PATRONA.toString();
		}
		if(borriquita.isSelected()) {
			menciones = menciones + HermandadesIG.BORRIQUITA.toString();
		}
		if(esperanza.isSelected()) {
			menciones = menciones + HermandadesIG.ESPERANZA.toString();
		}
		if(cautivo.isSelected()) {
			menciones = menciones + HermandadesIG.CAUTIVO.toString();
		}
		if(veracruz.isSelected()) {
			String name = HermandadesIG.VERACRUZ.toString(); 
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}	
		}
		if(piedad.isSelected()) {
			menciones = menciones + HermandadesIG.PIEDAD.toString();
		}
		if(nazareno.isSelected()) {
			String name = HermandadesIG.NAZARENO.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		if(dolores.isSelected()) {
			menciones = menciones + HermandadesIG.DOLORES.toString();
		}
		if(parroquia.isSelected()) {
			String name = HermandadesIG.PARROQUIA.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		if(ayuntamiento.isSelected()) {
			String name = HermandadesIG.AYUNTAMIENTO.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		if(rmartin.isSelected()) {
			menciones = menciones + HermandadesIG.RAMONMARTIN.toString();
		}
		if(leonredondo.isSelected()) {
			menciones = menciones + HermandadesIG.JOSEANTONIO.toString();
		}
		if(bmvisoalcor.isSelected()) {
			menciones = menciones + HermandadesIG.BANDAVISO.toString();
		}
		if(ccttmerced.isSelected()) {
			menciones = menciones + HermandadesIG.MERCED.toString();
		}
		if(sfj.isSelected()) {
			String name = HermandadesIG.SFJ.toString(); 
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		if(misericordia.isSelected()) {
			String name = HermandadesIG.MISERICORDIA.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		if(corazon.isSelected()) {
			String name = HermandadesIG.CORAZON.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		if(arzobis.isSelected()) {
			menciones = menciones + HermandadesIG.ARZOBISPADO.toString();
		}
		if(consejo.isSelected()) {
			String name = HermandadesIG.CONSEJO.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		if(reyes.isSelected()) {
			String name = HermandadesIG.REYES.toString();
			if(!menciones.contains(name)) {
				menciones = menciones + name;
			}
		}
		if(others.isSelected()) {
			String auxi = meteOtros.getText();
			if (auxi.length()>3) {
				menciones = menciones + añadeOtros(auxi);
			}
		}
		return menciones;
	}
	
	
	public void reiniciaProceso() {
		List<JCheckBox> checks = new ArrayList<JCheckBox>();
		checks.add(alcora); checks.add(ayuntamiento); checks.add(carmen); checks.add(ccttmerced);
		checks.add(consejo); checks.add(dolores); checks.add(esperanza); checks.add(misericordia);
		checks.add(nazareno); checks.add(piedad); checks.add(reyes); checks.add(veracruz);
		checks.add(arzobis); checks.add(bmvisoalcor); checks.add(borriquita); checks.add(cautivo);
		checks.add(corazon); checks.add(parroquia); checks.add(rmartin); checks.add(rocio);
		checks.add(sfj); checks.add(leonredondo); checks.add(others);
		
		checks.stream().forEach(new Consumer<JCheckBox>() {
			@Override
			public void accept(JCheckBox x) {
				x.setSelected(false);
			}
		});
		
		extraeURL.setText("");
		meteOtros.setText("");
	}
	
	public String añadeOtros(String texto) {
		String res = "";
		String[] aux = null;
		if(texto.contains(" ")) {
			aux = texto.split(" ");
		} else {
			aux = new String[] {""};
			aux[0] = texto;
		}
		for(String s: aux) {
			s.trim();
			if(!s.startsWith("@")) {
				s = "@"+s;
			}
			res = res + s + " ";
		}
		return res;
	}
	
	// TODO
	// Métodos que simplifiquen el código, por ejemplo:
	// Meter los JCheckBox en una lista, crear un algoritmo que recorra todos los elementos de la lista
	// y vaya añadiendo si no están. POR EJEMPLO
	// OTRA OPCIÓN: Un método auxiliar que compruebe que una mención no está ya incluida
	
	// SIGUIENTES PASOS:
	// Automatizar la publicación en Telegram mediante un Bot
	
}