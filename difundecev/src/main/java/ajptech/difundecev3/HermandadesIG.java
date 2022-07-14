package ajptech.difundecev3;

public enum HermandadesIG {
	
		NOVALUE(" "),
		REYES("@nazarenoviso "),
		ROCIO("@rociodeelviso "),
		CARMEN("@parroquiasantamariadelalcor "), 
		PATRONA("@stamariaalcor "), 
		BORRIQUITA("@sagradaentradaviso "),
		ESPERANZA("@redencionyesperanza "),
		CAUTIVO("@hdadcautivoviso "),
		VERACRUZ("@hdadveracruzyrosarioviso "),
		PIEDAD("@hdadpiedadviso "),
		NAZARENO("@nazarenoviso "),
		DOLORES("@hdaddoloresviso "),
		PARROQUIA("@parroquiasantamariadelalcor "),
		AYUNTAMIENTO("@elvisodelalcor_ "),
		MERCED("@bctmercedviso "),
		BANDAVISO("@bandavisoalcor "),
		RAMONMARTIN("@sculpture_ramon_martin "),
		JOSEANTONIO("@artesacro_leonredondo "),
		SFJ("@hdadveracruzyrosarioviso "),
		MISERICORDIA("@nazarenoviso "),
		CORAZON("@parroquiasantamariadelalcor "),
		ARZOBISPADO("@archisevilla "),
		CONSEJO("@consejodehermandades.elviso ");
		
		public static HermandadesIG hayHdad(String hdad){
			 
		     try {
		        return valueOf(hdad);
		     }catch (IllegalArgumentException ex) {
		        return NOVALUE;
		     }
		     
		 }
		 
		 private final String display;
		    private HermandadesIG(String s) {
		        display = s;
		 }
		 
		    @Override
		 public String toString() {
		    return display;
		 }

}
