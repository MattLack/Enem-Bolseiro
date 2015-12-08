package interfaces;


import java.awt.List;
import java.util.ArrayList;

import negocio.beans.Questao;


/**
 * UFRPE 2015.2 IP2
 * @author Matt_lackome
 *
 */

/**
 * Interace IRepositorioQuestao
 * define os m�todos necess�rios para um reposit�rio nesse projeto
 * cadastrar/remover/alterar/existe quest�o/tamanho do reposit�rio
 */

public interface IRepositorioQuestao {

	public  void cadastrar(Questao q);
	public  void remover(Questao q) ;
	public  void alterar(Questao q) ;
	public  ArrayList<Questao> listarQuestoes();
	public  Questao existe(Long id);
	

}
