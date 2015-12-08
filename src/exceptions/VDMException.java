package exceptions;

import negocio.beans.Alternativa;

/**
 * UFRPE 2015.2 IP2
 * @author Matt_lackome
 * 
 */

public class VDMException extends Exception{
	
	private Alternativa[] alternativas;
	
	/**
	 * VDMException(Alternativa[] a)
	 * construtor da VDMException
	 * @param a - Alternativa[]
	 */
	
	public VDMException(Alternativa[] a){
		super("Mais de (ou nenhuma) uma alternativa correta!");
		this.alternativas = a;
	}
	
	public Alternativa[] getAlternativas(){
		return this.alternativas;
	}

}
