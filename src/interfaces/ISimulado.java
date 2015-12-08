package interfaces;

import java.util.ArrayList;

import negocio.beans.Questao;
import exceptions.QUESTAOException;

/**
 * UFRPE 2015.2 IP2
 * @author Matt_lackome
 *
 */

/**
 * Interface ISimulado
 *apresenta m�todos necess�rios para a FachadaSimulado
 */

public interface ISimulado {
	
	Questao[] questoesRandom()throws QUESTAOException;
	
		
}
