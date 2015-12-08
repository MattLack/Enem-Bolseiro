/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.beans.Alternativa;
import negocio.beans.LetrasEnum;
import negocio.beans.Questao;
import negocio.beans.TiposEnum;
import exceptions.QUESTAOException;
import front.Fachada;

/**
 *
 * @author Matt_lackome
 * @param <T>
 */
public class TelaCadastro extends javax.swing.JFrame {

	private JButton jButton1;
    private JComboBox cbTipoQuestao;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JTextArea txaTextoDaQuestao;
    private JLabel lblAlternativaA;
    private JLabel lblAlternativaB;
    private JLabel lblAlternativaC;
    private JLabel lblAlternativaD;
    private JLabel lblAlternativaE;
    private JTextField tfAlternativaA;
    private JTextField tfAlternativaB;
    private JTextField tfAlternativaC;
    private JTextField tfAlternativaD;
    private JTextField tfAlternativaE;
    
    private ButtonGroup grupo;
    private JRadioButton rbAlternativaA;
    private JRadioButton rbAlternativaB;
    private JRadioButton rbAlternativaC;
    private JRadioButton rbAlternativaD;
    private JRadioButton rbAlternativaE;
    
    private JLabel lblMarqueACorreta;
    private JButton btnCadastrar;
    private JButton btnVoltar;
    private JLabel lblIdDaNova;
    
    
    public TelaCadastro() {
        initComponents();
    }

                         
    private void initComponents() {
    	
        jScrollPane1 = new JScrollPane();
        txaTextoDaQuestao = new JTextArea(10,40);
        cbTipoQuestao = new JComboBox();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton1 = new JButton();

        

        txaTextoDaQuestao.setTabSize(4);
        //jTextArea1.setRows(1);
        jScrollPane1.setViewportView(txaTextoDaQuestao);

        cbTipoQuestao.setModel(new DefaultComboBoxModel(TiposEnum.values()));
        

        jLabel1.setText("TEXTO DA QUESTÃO");

        jLabel2.setText("TIPO DA QUESTÃO");

        jButton1.setText("INSERIR IMAGEM");
        
        tfAlternativaA = new JTextField();
        tfAlternativaA.setColumns(10);
        
        tfAlternativaB = new JTextField();
        tfAlternativaB.setColumns(10);
        
        tfAlternativaC = new JTextField();
        tfAlternativaC.setColumns(10);
        
        tfAlternativaD = new JTextField();
        tfAlternativaD.setColumns(10);
        
        tfAlternativaE = new JTextField();
        tfAlternativaE.setColumns(10);
        
        lblAlternativaA = new JLabel("Alternativa A");
        
        lblAlternativaB = new JLabel("Alternativa B");
        
        lblAlternativaC = new JLabel("Alternativa C");
        
        lblAlternativaD = new JLabel("Alternativa D");
        
        lblAlternativaE = new JLabel("Alternativa E");
        
        rbAlternativaA = new JRadioButton("");
        
        rbAlternativaB  = new JRadioButton("");
        
        rbAlternativaC  = new JRadioButton("");
        
        rbAlternativaD  = new JRadioButton("");
        
        rbAlternativaE  = new JRadioButton("");
        
        grupo = new ButtonGroup();
        grupo.add(rbAlternativaA);
        grupo.add(rbAlternativaB);
        grupo.add(rbAlternativaC);
        grupo.add(rbAlternativaD);
        grupo.add(rbAlternativaE);
        
        
        lblMarqueACorreta = new JLabel("Marque a Correta");
        
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent arg0){
        		try{
        			salvar();
        			JOptionPane.showMessageDialog(null, "Questão cadastrada","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        		}
        		catch(QUESTAOException e){
        			JOptionPane.showMessageDialog(null, e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent arg0){
        		TelaPrincipal tela = new TelaPrincipal();
        		setVisible(false);
        		tela.setVisible(true);
        	}
        });
        
        lblIdDaNova = new JLabel("Id da nova Quest\u00E3o:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(27)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblAlternativaA)
        						.addComponent(lblAlternativaB)
        						.addComponent(lblAlternativaC)
        						.addComponent(lblAlternativaD)
        						.addComponent(lblAlternativaE))
        					.addGap(33)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(tfAlternativaE)
        						.addComponent(tfAlternativaC)
        						.addComponent(tfAlternativaB)
        						.addComponent(tfAlternativaA)
        						.addComponent(tfAlternativaD)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(51)
        							.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
        							.addGap(47)
        							.addComponent(jLabel2)
        							.addGap(54)
        							.addComponent(cbTipoQuestao, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
        						.addComponent(btnVoltar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(22)
        							.addComponent(lblMarqueACorreta))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(54)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(rbAlternativaA)
        								.addComponent(rbAlternativaB)
        								.addComponent(rbAlternativaC)
        								.addComponent(rbAlternativaD)
        								.addComponent(rbAlternativaE)))))
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblIdDaNova)
        						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 598, GroupLayout.PREFERRED_SIZE))
        					.addGap(96)))
        			.addGap(88))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(104)
        			.addComponent(btnCadastrar)
        			.addContainerGap(742, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(29)
        			.addComponent(lblIdDaNova)
        			.addGap(17)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(60)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(101)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
        			.addGap(28)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jButton1)
        					.addComponent(jLabel2)
        					.addComponent(cbTipoQuestao, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        				.addComponent(lblMarqueACorreta))
        			.addGap(17)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(tfAlternativaD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblAlternativaA))
        				.addComponent(rbAlternativaA))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(rbAlternativaB)
        				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(tfAlternativaA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblAlternativaB)))
        			.addGap(17)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(tfAlternativaB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblAlternativaC))
        				.addComponent(rbAlternativaC))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(tfAlternativaC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblAlternativaD))
        				.addComponent(rbAlternativaD))
        			.addGap(17)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(tfAlternativaE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblAlternativaE))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(18)
        							.addComponent(btnCadastrar))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(10)
        							.addComponent(btnVoltar))))
        				.addComponent(rbAlternativaE))
        			.addContainerGap(21, Short.MAX_VALUE))
        			
        			
        );
        getContentPane().setLayout(layout);

        pack();
    }
    
    private void salvar() throws QUESTAOException{
    	
    	String texto = this.txaTextoDaQuestao.getText();
    	TiposEnum tipo = (TiposEnum) this.cbTipoQuestao.getSelectedItem();
    	
    	Alternativa alternativaA = new Alternativa(LetrasEnum.A,tfAlternativaA.getText(),false);
    	Alternativa alternativaB = new Alternativa(LetrasEnum.B,tfAlternativaB.getText(),false);
    	Alternativa alternativaC = new Alternativa(LetrasEnum.C,tfAlternativaC.getText(),false);
    	Alternativa alternativaD = new Alternativa(LetrasEnum.D,tfAlternativaD.getText(),false);
    	Alternativa alternativaE = new Alternativa(LetrasEnum.E,tfAlternativaE.getText(),false);
    	
    	if(rbAlternativaA.isSelected()){
    		alternativaA.setIsCorreta(true);
    	}
        if(rbAlternativaB.isSelected()){
        	alternativaB.setIsCorreta(true);
    	}
        if(rbAlternativaC.isSelected()){
        	alternativaC.setIsCorreta(true);
    	}
        if(rbAlternativaD.isSelected()){
        	alternativaD.setIsCorreta(true);
    	}
        if(rbAlternativaE.isSelected()){
        	alternativaE.setIsCorreta(true);
    	}
        
        
        Alternativa[] alternativas = new Alternativa[5]; 
        alternativas[0]= alternativaA;
        alternativas[1]= alternativaB;
        alternativas[2]= alternativaC;
        alternativas[3]= alternativaD;
        alternativas[4]= alternativaE;
        
        Questao questao = new Questao(texto,tipo,alternativas);
        
        if(questao.getCorreta() == null){
        	throw new QUESTAOException("Selecione uma resposta para a questão");
        }
        
        Fachada.getInstance().cadastrar(questao);
        zerarCampos();
    }
    
   public void zerarCampos(){
	   this.txaTextoDaQuestao.setText("");
	   this.tfAlternativaA.setText("");
	   this.tfAlternativaB.setText("");
	   this.tfAlternativaC.setText("");
	   this.tfAlternativaD.setText("");
	   this.tfAlternativaE.setText("");
	   this.grupo.clearSelection();
   }
    
}
