package dados;

import interfaces.IRepositorioQuestao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import negocio.beans.Questao;



public class RepositorioQuestao implements IRepositorioQuestao{
	
	private List<Questao> questoes;
	
	public RepositorioQuestao(){
		
	
			this.questoes = new ArrayList<Questao>();
			if(new File("questoes.dat").canRead() == true){
				this.lerArquivo();
			}
			else{
				this.salvarArquivo();
			}
		
	}
	
	public int tamanhoRepositorio(){
		return this.questoes.size();
	}
	
	
	private void lerArquivo() {
		
		if(new File("questoes.dat").canRead() == true){
			
			FileInputStream inc;
			try {
				inc = new FileInputStream("questoes.dat");
				ObjectInputStream ois = new ObjectInputStream(inc);
				
				ArrayList <Questao> quest = (ArrayList <Questao>) ois.readObject();
				for(int i = 0; i< quest.size(); i++){
					this.questoes.add(quest.get(i));
				}
				
			} 
			catch (IOException | ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} 
	  }
  }
	
	private void salvarArquivo() {
		FileOutputStream FOS = null;
		ObjectOutputStream OUS = null;
		try
		{
		    FOS = new FileOutputStream("questoes.dat");
			OUS = new ObjectOutputStream(FOS);
			
			OUS.writeObject(questoes);
			OUS.close();
		}
		catch( IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally{
			try {
				FOS.close();
				OUS.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private int procurarIndice(Questao q){
		
		int indice = -1;

		for (int i = 0; i < this.questoes.size(); i++){
			
			if (this.questoes.get(i).equals(q)) 
			{
				indice = i;
			}
		}
		return indice;
	}
	
	public Questao existe(Long id){
		
		Questao que = null;
		for(int i = 0; i<questoes.size();i++){
			if(questoes.get(i).getId().equals(id)){
				que = questoes.get(i);
			}
		}
		return que;
	}
	
	public void cadastrar(Questao q) {
      
		 q.setId((long) this.questoes.size() +1 );
		 q.getAlternativas()[0].setQuestaoId(q.getId()); 	
		 q.getAlternativas()[1].setQuestaoId(q.getId());
		 q.getAlternativas()[2].setQuestaoId(q.getId()); 
		 q.getAlternativas()[3].setQuestaoId(q.getId()); 
		 q.getAlternativas()[4].setQuestaoId(q.getId());
         this.questoes.add(q);
         this.salvarArquivo();
       
	}
	
	
	public void remover(Questao q) {
		
		
		  this.questoes.remove(q);
		  this.salvarArquivo();

	}
	
	public void alterar(Questao q)  {
    
   
       this.questoes.set(this.procurarIndice(q), q);
       this.salvarArquivo();
    
 }
	


	
	public ArrayList<Questao> listarQuestoes() 
	{
		
		return (ArrayList<Questao>) this.questoes;
	}


}
