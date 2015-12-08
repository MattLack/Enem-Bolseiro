package negocio.beans;

import java.io.Serializable;

/**
 * UFRPE 2015.2 IP2
 * @author Matt_lackome
 *
 */

/**
 * classe Imagem
 * implementa parâmetros que definem o uso de uma imagem no projeto
 * @param Long id - id único para a imagem
 * @param Long questaoId - id da questão a qual essa imagem pertence
 * @param String caminho - guarda em uma sting o caminho de disco para o local da imagem
 *
 */

public class Imagem implements Serializable{
	private Long id;
	private Long questaoId;
	private String caminho;
	
	/**
	 * Imagem(){}
	 * construtor default
	 */
	
	public Imagem() {}
	
	/**
	 * construtor passando os parâmetros caminho, id e questaoId
	 * Imagem(String caminho, Long id, Long questaoId)
	 * @param caminho
	 * @param id
	 * @param questaoId
	 */
	
	public Imagem(String caminho, Long id, Long questaoId) {
		this.setCaminho(caminho);
		this.setId(id);
		this.setQuestaoId(questaoId);
	}
	
	/**
	 * gets and sets referentes aos parâmetros da classe
	 */
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getQuestaoId() {
		return this.questaoId;
	}
	
	public void setQuestaoId(Long questaoId) {
		this.questaoId = questaoId;
	}

	public String getCaminho() {
		return this.caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	@Override
	public String toString() {
		return this.getId().toString();
	}
	
	/**
	 * Método equals
	 */

	@Override
	public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Imagem other = (Imagem) obj;
	if (caminho == null) {
		if (other.caminho != null)
		return false;
	} else if (!caminho.equals(other.caminho))
		return false;
	if (id == null) {
		if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
		return false;
	if (questaoId == null) {
		if (other.questaoId != null)
		return false;
	} else if (!questaoId.equals(other.questaoId))
		return false;
	return true;
	}
	
	
}
