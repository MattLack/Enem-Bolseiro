package controladores;

import interfaces.IRepositorioQuestao;

import java.util.ArrayList;

import negocio.beans.Questao;
import dados.RepositorioQuestao;
import exceptions.QUESTAOException;

public class CRUDController {
	
	private IRepositorioQuestao reposit; 
	
	
	public CRUDController(){
		this.reposit = new RepositorioQuestao();
	}
	
	
	
	
	public void cadastrar(Questao q) throws QUESTAOException {
		if(q.getTexto().trim().length() > 10){ 
			
			this.reposit.cadastrar(q);
			 
		}
		else{
			throw new QUESTAOException("O texto da quest�o � iv�lido");
		}
	}
	
	
	
	public void remover(Questao q) throws QUESTAOException {
		if(this.reposit.existe(q.getId()) != null){
		 this.reposit.remover(q);
		}
		else
			throw new QUESTAOException("A quest�o n�o existe");
	}
	
	
	
	public void alterar(Questao q) throws QUESTAOException{
		if(this.reposit.existe(q.getId()) != null){
			 this.reposit.alterar(q);
			}
			else
				throw new QUESTAOException("A quest�o n�o existe");
	}
	
	public ArrayList<Questao> listarQuestoes(){
		return this.reposit.listarQuestoes();
	}
	
	public Questao buscar(Long id){
		return this.reposit.existe(id);
	}
	
	

}
