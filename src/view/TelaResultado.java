package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import negocio.beans.Alternativa;
import negocio.beans.Questao;
import negocio.beans.TiposEnum;
import front.Fachada;

public class TelaResultado extends JFrame{

	private int AcertosCIENCNATURE ;
	private int AcertosCIENCHUMAN ;
	private int AcertosLANGUAGE ;
	private int AcertosENGL ;
	private int AcertosSPAN;
	private int AcertosMATH;
	
	private int ErrosCIENCNATURE;
	private int ErrosCIENCHUMAN;
	private int ErrosLANGUAGE;
	private int ErrosENGL;
	private int ErrosSPAN;
	private int ErrosMATH;
	private int naoRespondidas;
	
	private JLabel lbTotalDeQuestoes;
	private JLabel lbAcertos;
	private JLabel lbErros;
	private JButton btSair;
	
	public TelaResultado(Questao[] questoes,Alternativa[] respostas){
	    AcertosCIENCNATURE = Fachada.getInstance().calcularAcertosTipo(TiposEnum.CIENCNATURE, questoes, respostas);
	    AcertosCIENCHUMAN = Fachada.getInstance().calcularAcertosTipo(TiposEnum.CIENCHUMAN, questoes, respostas);
		AcertosLANGUAGE = Fachada.getInstance().calcularAcertosTipo(TiposEnum.LANGUAGE, questoes, respostas);
		AcertosENGL = Fachada.getInstance().calcularAcertosTipo(TiposEnum.ENGL, questoes, respostas);
		AcertosSPAN = Fachada.getInstance().calcularAcertosTipo(TiposEnum.SPAN, questoes, respostas);;
		AcertosMATH = Fachada.getInstance().calcularAcertosTipo(TiposEnum.MATH, questoes, respostas);
		
		ErrosCIENCNATURE = Fachada.getInstance().calcularErrosTipo(TiposEnum.CIENCNATURE, questoes, respostas);
	    ErrosCIENCHUMAN = Fachada.getInstance().calcularErrosTipo(TiposEnum.CIENCHUMAN, questoes, respostas);
		ErrosLANGUAGE = Fachada.getInstance().calcularErrosTipo(TiposEnum.LANGUAGE, questoes, respostas);
		ErrosENGL = Fachada.getInstance().calcularErrosTipo(TiposEnum.ENGL, questoes, respostas);
		ErrosSPAN = Fachada.getInstance().calcularErrosTipo(TiposEnum.SPAN, questoes, respostas);
		ErrosMATH = Fachada.getInstance().calcularErrosTipo(TiposEnum.MATH, questoes, respostas);;
		
		naoRespondidas = Fachada.getInstance().calcularNaoRespondidas(questoes, respostas);
		this.setSize(900,600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		lbTotalDeQuestoes = new JLabel();
		lbTotalDeQuestoes.setLayout(null);
		lbTotalDeQuestoes.setBounds(30,30,500,30);
		lbTotalDeQuestoes.setText("<html><p>Total de questões: " + questoes.length + "</p><p> Questões náo respondidas : " + naoRespondidas + "</p></html>");
		this.add(lbTotalDeQuestoes);
		
		lbAcertos = new JLabel();
		lbAcertos.setLayout(null);
		lbAcertos.setBounds(20, 70, 300, 400);
		lbAcertos.setText(setTextAcertos());
		this.add(lbAcertos);
		
		lbErros = new JLabel();
		lbErros.setLayout(null);
		lbErros.setBounds(600, 70, 300, 400);
		lbErros.setText(this.setTextErros());
		this.add(lbErros);
		
		btSair = new JButton("OK");
		btSair.setLayout(null);
		btSair.setBounds(350,500 ,200, 50);
		btSair.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal menu = new TelaPrincipal();
				menu.setVisible(true);
				setVisible(false);
				
			}
			
		});
		btSair.setVisible(true);
		add(btSair);
		
	}
	private String setTextAcertos(){
		String resultado = "<html>";
		 
		
		if(this.AcertosCIENCNATURE > 0){
			resultado += "<p> Acertos Ciencias da Natureza: "+ this.AcertosCIENCNATURE + "</p>";
		}
		if(this.AcertosCIENCHUMAN > 0){
			resultado += "<p> Acertos Ciencias Humanas: "+ this.AcertosCIENCHUMAN + "</p>";
		}
		if(this.AcertosLANGUAGE > 0){
			resultado += "<p>Acertos Linguagens: "+ this.AcertosLANGUAGE + "</p>";
		}
		if(this.AcertosENGL > 0){
			resultado += "<p>Acertos Inglês: "+ this.AcertosENGL + "</p>";
		}
		if(this.AcertosSPAN > 0){
			resultado += "<p>Acertos Espanhol: "+ this.AcertosSPAN + "</p>";
		}
		if(this.AcertosMATH > 0){
			resultado += "<p>Acertos Inglês: "+ this.AcertosMATH + "</p";
		}
		resultado += "<p>Total de acertos : "+ (this.AcertosCIENCHUMAN + this.AcertosCIENCNATURE + this.AcertosLANGUAGE + 
				this.AcertosENGL + this.AcertosSPAN + this.AcertosMATH + "</p> </html>");
		return resultado;
	}
	private String setTextErros(){
		String resultado = "<html>";
		 
		
		if(this.ErrosCIENCNATURE > 0){
			resultado += "<p>Erros Ciencias da Natureza: "+ this.ErrosCIENCNATURE + "\n";
		}
		if(this.ErrosCIENCHUMAN > 0){
			resultado += "<p>Erros Ciencias Humanas: "+ this.ErrosCIENCHUMAN + "\n";
		}
		if(this.ErrosLANGUAGE > 0){
			resultado += "<p>Erros Linguagens: "+ this.ErrosLANGUAGE + "\n";
		}
		if(this.ErrosENGL > 0){
			resultado += "<p>Erros Inglês: "+ this.ErrosENGL + "\n";
		}
		if(this.ErrosSPAN > 0){
			resultado += "<p>Erros Espanhol: "+ this.ErrosSPAN + "\n";
		}
		if(this.ErrosMATH > 0){
			resultado += "<p>Erros Matemática: "+ this.ErrosMATH + "\n";
		}
		resultado += "<p>Total de erros : "+ (this.ErrosCIENCHUMAN + this.ErrosCIENCNATURE + this.ErrosLANGUAGE + 
				this.ErrosENGL + this.ErrosSPAN + this.ErrosMATH + "</p></html>");
		return resultado;
	}
}
