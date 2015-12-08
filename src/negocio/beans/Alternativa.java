package negocio.beans;

import java.io.Serializable;

/**
 * UFRPE 2015.2 IP2
 * @author Matt_lackome
 *
 */

/**
 * Classe Alternativa
 * Define par�metros necess�rios para definir uma alternativa no projeto
 * @param LetrasEnum id - Define unicamente op��es para a letra de uma alternativa
 * (se ela � do tipo A/B/C...)
 * @param Long questaoId - guarda o id da quest�o a qual esta alternativa pertence
 * @param String texto - texto da alternativa
 * @param Boolean isCorreta - se true significa que a alternativa em quest�o � correta
 *
 */

public class Alternativa implements Serializable{
	
	
	private LetrasEnum id;
	private long questaoId;
	private String texto;
	private Boolean isCorreta;
	
	/**
	 * Alternativa(){}
	 * construtor default
	 */
	
	public Alternativa(LetrasEnum id,long questaoId) {
		this.setId(id);
		this.setQuestaoId(questaoId);
	}

	/**
	 * Alternativa(LetrasEnum id, String texto, Boolean isCorreta)
	 * @param id - seta id passado no construtor
	 * @param texto - seta texto passado no construtor
	 * @param isCorreta - seta boolean passado no construtor
	 */
	
	public Alternativa(LetrasEnum id, String texto, Boolean isCorreta) {
		
		this.setId(id);
		this.setTexto(texto);
		this.setIsCorreta(isCorreta);
	}
	
	/**
	 * gets and sets para os par�metros anteriores
	 * 
	 */
	
	public LetrasEnum getId() {
		return this.id;
	}
	
	public void setId(LetrasEnum id) {
		this.id = id;
	}
	
	

	public long getQuestaoId() {
		return questaoId;
	}

	public void setQuestaoId(long questaoId) {
		this.questaoId = questaoId;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Boolean getIsCorreta() {
		return this.isCorreta;
	}

	public void setIsCorreta(Boolean isCorreta) {
		this.isCorreta = isCorreta;
	}
	
	
	/**
	 * Metodo equals
	 */

	@Override
	public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Alternativa other = (Alternativa) obj;
	if (id != other.id)
		return false;
	if (isCorreta == null) {
		if (other.isCorreta != null)
		return false;
	} else if (!isCorreta.equals(other.isCorreta))
		return false;
	
	if (texto == null) {
		if (other.texto != null)
		return false;
	} else if (!texto.equals(other.texto))
		return false;
	return true;
	}
	
	
}
