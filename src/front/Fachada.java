package front;

import interfaces.ISimulado;
import negocio.beans.Alternativa;
import negocio.beans.Questao;
import negocio.beans.TiposEnum;
import controladores.CRUDController;
import controladores.SimuladoController;
import exceptions.QUESTAOException;



public class Fachada implements ISimulado{
	
	private static Fachada instance = null;
	private SimuladoController simulado;
	private CRUDController crud;
	
	private Fachada(){
		
		simulado = new SimuladoController();
		crud = new CRUDController();
	}
	
	
	
    public static Fachada getInstance(){
		if(instance == null){
			instance = new Fachada();
		}
		return instance;
	}
	
	public Questao[] questoesRandom() throws QUESTAOException{
		return this.simulado.getArraySimulado();
	}
	public int calcularAcertosTipo(TiposEnum tipoQuestao,Questao[] questoes,Alternativa[] respostas){
		return this.simulado.calcularAcertos(tipoQuestao,questoes, respostas);
	}
	public int calcularErrosTipo(TiposEnum tipoQuestao,Questao[] questoes,Alternativa[] respostas){
		return this.simulado.calcularErros(tipoQuestao,questoes, respostas);
	}
	public int calcularNaoRespondidas(Questao[] questoes,Alternativa[] respostas){
		return this.simulado.calcularNaoRespondidas( questoes, respostas);
	}
	
	public void cadastrar(Questao q) throws QUESTAOException{
		this.crud.cadastrar(q);
	}
	
	public void alterar(Questao q) throws QUESTAOException{
		this.crud.alterar(q);
	}
	
	public void excluir(Questao q) throws QUESTAOException{
		this.crud.remover(q);
	}

	
	
	
}
