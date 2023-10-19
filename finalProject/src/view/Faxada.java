package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import control.ControllerGrid;
import control.ControllerUsuario;

public class Faxada extends TelaPadrao {

	public Faxada(String titulo) {
		super("Tela escola",400,400);
		Tela();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// TODO Auto-generated constructor stub
	}

	public void Tela(){
		CadastrarAction cadastrar = new CadastrarAction();
		MostrarAction ver = new MostrarAction();
		MostrarAction2 ver2 = new MostrarAction2();
		SairAction sair = new SairAction();
		 JButton bt1 = new JButton("Cadastrar Usuario");
		 JButton bt2 = new JButton("ver Usuarios XML");
		 JButton bt3 = new JButton("ver Usuarios B Relacional");
		 JButton bt4 = new JButton("SAIR");
		
		 getContentPane().setLayout(new GridLayout(2,2));

	     getContentPane().add(bt1);
	     bt1.addActionListener(cadastrar);
	     getContentPane().add(bt2);
	     bt2.addActionListener(ver);
	     getContentPane().add(bt3);
	     bt3.addActionListener(ver2);
	     getContentPane().add(bt4);
	     bt4.addActionListener(sair);
	     
	     
	     setVisible(true);
		
	}
	private class CadastrarAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
                 new ControllerUsuario();
		}
		
	}
	private class MostrarAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new ControllerGrid(1);
			
		}
	}
	private class MostrarAction2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new ControllerGrid(2);
			
		}
	}
		
		private class SairAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);				
			}
	}
}

