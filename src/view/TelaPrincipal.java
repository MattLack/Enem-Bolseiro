package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.QUESTAOException;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				TelaPrincipal frame = new TelaPrincipal();
				frame.setVisible(true);
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSimulado = new JButton("SIMULADO");
		btnSimulado.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 18));
		btnSimulado.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent Arg0){
				
				try {
					
					new TelaQuestoes();
					dispose();
				} catch (QUESTAOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSimulado.setBounds(326, 150, 136, 61);
		contentPane.add(btnSimulado);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TelaCadastro cadastro = new TelaCadastro();
				setVisible(false);
				cadastro.setVisible(true);
			}
		});
		btnCadastrar.setBounds(342, 243, 107, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnBuscaralterarremover = new JButton("Buscar/Alterar/Remover");
		btnBuscaralterarremover.setBounds(304, 276, 181, 35);
		contentPane.add(btnBuscaralterarremover);
	}
}
