package ajptech.difundecev3;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws TwitterException
    {
        /*System.out.println( "Hello World!" );
        
        DatosVersion dv = new DatosVersionImpl();
        
        System.out.println(dv.getDirectorio());*/
        
        /*Twitter tw = new TwitterFactory().getInstance();
        
        User usuario = tw.verifyCredentials();
        
        System.out.println("Nombre: " + usuario.getName());
        System.out.println("Descripcion: " + usuario.getDescription());
        System.out.println("Id Usuario: " + usuario.getId());
        System.out.println("Número Seguidores: " + usuario.getFollowersCount());*/
        
        try {  
        	  Twitter twitter = new TwitterFactory().getInstance();           
        	  twitter.updateStatus("🔴 Tweet de prueba. \n\n⬇  Nº5");
        	  System.out.println("Publicado el tweet en la cuenta indicada.");
        	} catch (TwitterException te) {
        	  te.printStackTrace();
        	  System.out.println("Error en la conexión: " + te.getMessage());         
        	}
        
    	}
}
