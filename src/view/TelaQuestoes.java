package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import negocio.beans.Alternativa;
import negocio.beans.LetrasEnum;
import negocio.beans.Questao;
import exceptions.QUESTAOException;
import front.Fachada;

public class TelaQuestoes extends JFrame {
	
	private static TelaQuestoes instance = null;
	private int posQuestaoAtual = 0;
	private Fachada sistema;
	private Questao[] questoes;
	private Alternativa[] respostas;
   

	private JPanel contentPane;
	
	private JLabel lbNumeroQuestao;
	private JLabel lbQuestao;
	private ButtonGroup rbgAternativas;
	private JRadioButton rbAlternativaA;
	private JRadioButton rbAlternativaB;
	private JRadioButton rbAlternativaC;
	private JRadioButton rbAlternativaD;
	private JRadioButton rbAlternativaE;
	
	private JButton btFinalizar;
	private JButton btAnterior;
	private JButton btProxima;
	
	
	
	public TelaQuestoes() throws QUESTAOException {
		
		this.sistema = Fachada.getInstance();  
		this.questoes = sistema.questoesRandom();
		this.respostas = new Alternativa[this.questoes.length];
		this.posQuestaoAtual = 0;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() 
        {
          @Override
          public void windowClosing(WindowEvent e)
          {
             
             int confirm = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair do simulado sem terminá-lo?",null,JOptionPane.OK_CANCEL_OPTION);
              if (confirm == 0) 
              {
            	   setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
                   instance = null;
                   TelaPrincipal tela = new TelaPrincipal();
                   tela.setVisible(true);
                   dispose();
                   
              }
              else
              {
                  setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
              }
              
           }
         });
		
		lbNumeroQuestao = new JLabel("");
		lbNumeroQuestao.setBounds(29, 48, 107, 39);
		contentPane.add(lbNumeroQuestao);
		
		lbQuestao = new JLabel("");
		lbQuestao.setBounds(146, 46, 405, 113);
		contentPane.add(lbQuestao);
		
		rbAlternativaA = new JRadioButton("");
		rbAlternativaA.setBounds(29, 196, 209, 23);
		contentPane.add(rbAlternativaA);
		
		rbAlternativaB = new JRadioButton("");
		rbAlternativaB.setBounds(29, 222, 309, 23);
		contentPane.add(rbAlternativaB);
		
		rbAlternativaC = new JRadioButton("");
		rbAlternativaC.setBounds(29, 248, 309, 23);
		contentPane.add(rbAlternativaC);
		
		rbAlternativaD = new JRadioButton("");
		rbAlternativaD.setBounds(29, 274, 309, 23);
		contentPane.add(rbAlternativaD);
		
		rbAlternativaE = new JRadioButton("");
		rbAlternativaE.setBounds(29, 300, 309, 23);
		contentPane.add(rbAlternativaE);
		
		rbgAternativas = new ButtonGroup();
		rbgAternativas.add(rbAlternativaA);
		rbgAternativas.add(rbAlternativaB);
		rbgAternativas.add(rbAlternativaC);
		rbgAternativas.add(rbAlternativaD);
		rbgAternativas.add(rbAlternativaE);
		
		btFinalizar = new JButton("Finalizar");
		btFinalizar.setBounds(94, 352, 89, 23);
		btFinalizar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				salvarResposta();
				if(verificaNaoRespondidas() == true){
				    int confirm = JOptionPane.showConfirmDialog(null,"Ainda existem questões não respondidas. \n Você deseja realmente calcular as respostas?",null,JOptionPane.OK_CANCEL_OPTION);
	                if (confirm == 0) 
	                {
	            	   
	            	   TelaResultado tela = new TelaResultado(questoes,respostas);
	            	   tela.show();
	                   hide();
	                }
	                
				}
				else{
					   
	            	   TelaResultado tela = new TelaResultado(questoes,respostas);
	            	   tela.show();
	                   hide();
				}
			}
		});
		contentPane.add(btFinalizar);
		
		btAnterior = new JButton("Anterior");
		btAnterior.setBounds(400, 352, 89, 23);
		btAnterior.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(posQuestaoAtual  > 0){
					salvarResposta();
					posQuestaoAtual--;
				  setQuestao(questoes[posQuestaoAtual]);
				  carregarResposta(posQuestaoAtual);
				}
			}
		});
		contentPane.add(btAnterior);
		
		
		btProxima = new JButton("Próxima");
		btProxima.setBounds(508, 352, 89, 23);
		btProxima.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(posQuestaoAtual < questoes.length -1){
					salvarResposta();
					posQuestaoAtual ++;	
				    setQuestao(questoes[posQuestaoAtual]);
				    carregarResposta(posQuestaoAtual);
				}
			}
		});
		contentPane.add(btProxima);
		
		setQuestao(questoes[0]);
	}
	
	
	private void setQuestao(Questao questao){
		
		
		this.lbNumeroQuestao.setText("Questao " + (this.posQuestaoAtual + 1));
		
		this.lbQuestao.setText( questao.getTexto());
		this.rbAlternativaA.setText(questao.getAlternativas()[0].getTexto());
		this.rbAlternativaB.setText(questao.getAlternativas()[1].getTexto());
		this.rbAlternativaC.setText(questao.getAlternativas()[2].getTexto());
		this.rbAlternativaD.setText(questao.getAlternativas()[3].getTexto());
		this.rbAlternativaE.setText(questao.getAlternativas()[4].getTexto());
		
		
	}
	private void salvarResposta(){
		
		if(rbgAternativas.getSelection() != null){
			LetrasEnum alternativa = null;
			
			if(rbAlternativaA.isSelected() == true){
				alternativa = LetrasEnum.A;
			}
			if(rbAlternativaB.isSelected() == true){
				alternativa = LetrasEnum.B;
			}
			if(rbAlternativaC.isSelected() == true){
				alternativa = LetrasEnum.C;
			}
			if(rbAlternativaD.isSelected()== true){
				alternativa = LetrasEnum.D;
			}
			if(rbAlternativaE.isSelected() == true){
				alternativa = LetrasEnum.E;
			}
			this.respostas[this.posQuestaoAtual] = new Alternativa(alternativa,this.questoes[posQuestaoAtual].getId());
			
		}	
		
	}
	private void carregarResposta(int posicaoArray){
		
		if(this.respostas[posicaoArray] != null && this.respostas[posicaoArray].getId() != null){
			
			if(this.respostas[posicaoArray].getId().equals(LetrasEnum.A)){
				this.rbAlternativaA.setSelected(true);	
			}
			if(this.respostas[posicaoArray].getId().equals(LetrasEnum.B)){
				this.rbAlternativaB.setSelected(true);	
			}
			if(this.respostas[posicaoArray].getId().equals(LetrasEnum.C)){
				this.rbAlternativaC.setSelected(true);	
			}
			if(this.respostas[posicaoArray].getId().equals(LetrasEnum.D)){
				this.rbAlternativaD.setSelected(true);	
			}
			if(this.respostas[posicaoArray].getId().equals(LetrasEnum.E)){
				this.rbAlternativaE.setSelected(true);	
			}
		}
		else{
			
			this.rbgAternativas.clearSelection();
			
		}
	}
	
	public boolean verificaNaoRespondidas(){
		boolean resultado = false;
		for(int i = 0; i< this.respostas.length;i++){
			if(respostas[i] == null){
				resultado = true;
			}
		}
		return resultado;
	}
}


