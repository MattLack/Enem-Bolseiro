package negocio.beans;

/**
 * UFRPE 2015.2 IP2
 * @author Matt_lackome
 *
 */

/**
 * Classe TiposEnum
 * define as �reas de conhecimentos existentes no Enem
 *
 */

public enum TiposEnum {
	
	CIENCNATURE(1), CIENCHUMAN(2), LANGUAGE(3), ENGL(4), SPAN(5), MATH(6);
	
	private final int valor;
	
	/**
	 * TiposEnum(int valor)
	 * define um valor para facilitar na consulta ou manipula��o do Enum
	 * @param valor
	 */
	
	TiposEnum(int valor){
		this.valor = valor;
	}
	
	/**
	 * get valor()
	 * retorna o valor do Enum em quest�o
	 * @return valor
	 */
	
	public float getValor(){
		return valor;
	}
	
	

}
