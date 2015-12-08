package exceptions;

import negocio.beans.Questao;

/**
 * UFRPE 2015.2 IP2
 * @author Matt_lackome
 *
 */

/**
 * classe exception QUESTAOException
 * levanta um objeto do tipo questao e um texto com uma mensagem referente ao tipo de erro
 * exception geral para Questao
 *
 */

public class QUESTAOException extends Exception{
	
	private String texto;
	private Questao questao;
	
	public QUESTAOException (String mensagem){
		super(mensagem);
	}
	
	public QUESTAOException (String texto, Questao q){
		super("ERRO QUESTAO EXCEPTION!");
		this.texto=texto;
		this.questao=q;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Questao getQuestao() {
		return this.questao;
	}

	public void setQuestao(Questao q) {
		this.questao = q;
	}
	
}
