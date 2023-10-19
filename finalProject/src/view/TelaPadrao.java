package view;

import javax.swing.JFrame;

public class TelaPadrao extends JFrame {
	
	public TelaPadrao(String titulo, int x,int y){
		setTitle(titulo);
		setSize(x,y);
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(true);	
		
	}

}
