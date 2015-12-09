package controladores;

import interfaces.IRepositorioQuestao;

import java.util.ArrayList;

import negocio.beans.Alternativa;
import negocio.beans.Questao;
import negocio.beans.TiposEnum;
import dados.RepositorioQuestao;
import exceptions.QUESTAOException;




public class SimuladoController{
	
	
	private IRepositorioQuestao repositorio;
	private final int numeroDeQuestoes = 4;
	
	
	
	public SimuladoController(){
		this.repositorio = new RepositorioQuestao();
	}
	
	public Questao[] getArraySimulado() throws QUESTAOException{
		if(  this.repositorio.listarQuestoes().size() >= numeroDeQuestoes && numeroDeQuestoes > 0){
			Questao[] resultado = new Questao[numeroDeQuestoes];
			
			ArrayList<Integer> ids = this.getIds();
			
			for(int i = 0;i < numeroDeQuestoes ; i++){
				resultado[i] = this.repositorio.listarQuestoes().get(ids.get(i));
			}
			return resultado;
			
		}
		else
			throw new QUESTAOException("Não existem questões o suficiente para gerar um simulado");
	}
	public ArrayList<Integer> getIds(){
		
		ArrayList<Integer> resultados = new ArrayList<Integer>();
		int aleatorio; 
		
		while(resultados.size() < numeroDeQuestoes){
			aleatorio = (int ) (Math.random() * this.repositorio.listarQuestoes().size());
			if(resultados.contains(aleatorio) == false){
				
				resultados.add(aleatorio);
			}
			
		}
		return resultados;
	}
	
	
	
    public int calcularAcertos(TiposEnum tipoQuestao,Questao[] questoes,Alternativa[] respostas){
    		int resultado = 0;
    	    for(int i = 0; i< respostas.length;i++){
    	    	
    			if(respostas[i] != null && questoes[i].getTipo().equals(tipoQuestao)){
    				
    				if(questoes[i].getCorreta().getId().equals(respostas[i].getId())){
    					
    				   resultado +=1;
    				}
    			}
    		}
    	    return resultado;
    }
    public int calcularErros(TiposEnum tipoQuestao,Questao[] questoes,Alternativa[] respostas){
		int resultado = 0;
	    for(int i = 0; i< respostas.length;i++){
	    	
			if(respostas[i] != null && questoes[i].getTipo().equals(tipoQuestao)){
				if(questoes[i].getCorreta().getId().equals(respostas[i].getId()) == false){
				   resultado +=1;
				}
			}
		}
	    return resultado;
    }  
    public int calcularNaoRespondidas(Questao[] questoes,Alternativa[] respostas){
		int resultado = 0;
	    for(int i = 0; i< respostas.length;i++){
	    	
			if(respostas[i] == null){
				   resultado +=1;
			}
		}
	    return resultado;
    }
}