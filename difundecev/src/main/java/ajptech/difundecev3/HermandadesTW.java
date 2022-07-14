package ajptech.difundecev3;

public enum HermandadesTW {
	
		NOVALUE(" "),
		REYES("@NazarenoViso "),
		ROCIO("@HdadRocioViso "),
		CARMEN("@HermandadCarmen "), 
		PATRONA("@StaMariaAlcor "), 
		BORRIQUITA("@SagradaEntradaV "),
		ESPERANZA("@Esperanza_Viso "),
		CAUTIVO("@HdadCautivoViso "),
		VERACRUZ("@HdadRosarioViso "),
		PIEDAD("@HdadPiedadViso "),
		NAZARENO("@NazarenoViso "),
		DOLORES("@HdadDoloresViso "),
		PARROQUIA("@sMariadelAlcor "),
		AYUNTAMIENTO("@ElVisodelAlcor_ "),
		MERCED("@BctMercedViso "),
		BANDAVISO("@bandavisoalcor "),
		RAMONMARTIN("@EscultorRMartin "),
		JOSEANTONIO(" "),
		SFJ("@HdadRosarioViso "),
		MISERICORDIA("@NazarenoViso "),
		CORAZON("@sMariadelAlcor "),
		ARZOBISPADO("@Archisevilla1 "),
		CONSEJO("@ElVisodelAlcor_ ");
		
		public static HermandadesTW hayHdad(String hdad){
			 
		     try {
		        return valueOf(hdad);
		     }catch (IllegalArgumentException ex) {
		        return NOVALUE;
		     }
		     
		 }
		 
		 private final String display;
		    private HermandadesTW(String s) {
		        display = s;
		 }
		 
		    @Override
		 public String toString() {
		    return display;
		 }

}
