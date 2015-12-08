package negocio.beans;

import java.io.Serializable;


/**
 * UFRPE 2015.2 IP2
 * @author Matt_lackome
 *
 */

/**
 * Classe Questao
 * engloba tipos das classes anteriores para compor o corpo dos parâmetros
 * possiveis de uma questão
 * @param Long id - id da questão
 * @param String texto - texto da questão
 * @param TiposEnum tipo - tipo da questão (Matemática/Inglês...)
 * @param Imagem imagem - imagem para a questão
 *
 */

public class Questao implements Serializable{
	private Long id;
	private String texto;
	private TiposEnum tipo;
	private Imagem imagem;
	private Alternativa[] alternativas = new Alternativa[5];
	
	

	/**
	 * Questao(){}
	 * construtor default
	 */
	
	public Questao(){}
	
	/**
	 * construtor setando texto, tipo para questão, id para questão, imagem, e array de alternativas
	 * Questao(String texto, TiposEnum tipo, Imagem imagem, Alternativa[] alternativas)
	 * @param texto
	 * @param tipo
	 * @param imagem
	 * @param alternativas - array de alternativas
	 * o id da questão é setado emcima do valor de objetos contidos no repositório
	 */
	
	public Questao(String texto, TiposEnum tipo, Alternativa[] alternativas) {
		this.setTexto(texto);
		this.setTipo(tipo);
		//this.setImagem(imagem);
		this.setAlternativas(alternativas);
	}
	
	/**
	 * gets and sets para os parâmetros anteriores
	 */
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public TiposEnum getTipo() {
		return tipo;
	}

	public void setTipo(TiposEnum tipo) {
		this.tipo = tipo;
	}
	
	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public Alternativa[] getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(Alternativa[] alternativas) {
		this.alternativas = alternativas;
	}
	public Alternativa getCorreta(){
		
		Alternativa resultado = null;
		for(int i =0;i< this.alternativas.length;i++){
			if(this.alternativas[i].getIsCorreta() == true){
				resultado = this.alternativas[i];
				
			}
		}
		return resultado;
	}
	
	/**
	 * método equals
	 */

	@Override
	public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Questao other = (Questao) obj;
	if (id == null) {
		if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
		return false;
	if (texto == null) {
		if (other.texto != null)
		return false;
	} else if (!texto.equals(other.texto))
		return false;
	return true;
	}
     
	
	@Override
	public String toString(){
		return this.texto;
	}


}
