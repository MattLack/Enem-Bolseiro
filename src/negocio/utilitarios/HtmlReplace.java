package negocio.utilitarios;

public abstract class HtmlReplace {

	private static int limite;
	
	public static final String tratarLimites(String entrada){
    	limite = 70;
    	String resultado = "<html>";
    	String auxiliar = "";
    	int ultimaPosicao = 0;
    	
    	while(resultado.length() < entrada.length()){
    		
    		if(entrada.substring(ultimaPosicao, entrada.length()).length() > limite )
    		{
    			
    			auxiliar += entrada.substring(ultimaPosicao, limite);
    			limite = limite + 70;
    			ultimaPosicao = ultimaPosicao + auxiliar.length();
    			resultado += "<p>" + replaceLast(auxiliar," ","</p>");
    			auxiliar = "";
    			
    			if(resultado.length() > entrada.length() ){
    				resultado += "</html>";
    				break;
    			}
    			
    		}
    		else{
    			break;
    		}
    		
    		
    	}
    	if(resultado.length() <= entrada.length()){
    		resultado = entrada;
    	}
    	
    		
    	return resultado;
    }
	private static final String replaceLast(String text, String regex, String replacement) {
	       return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
	}
}
