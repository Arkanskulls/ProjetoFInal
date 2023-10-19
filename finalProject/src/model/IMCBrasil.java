package model;

import javax.swing.JOptionPane;

public class IMCBrasil implements InterfaceIMC {

	@Override
	public void calculo(float p, float a) {
		JOptionPane.showMessageDialog(null,"seu IMC é de: "+p/(a * a));
		if(p/(a * a) > 30){
			JOptionPane.showMessageDialog(null,"vai para acdemia seu Obz");
			
		}if (p/(a * a) < 30 &&  p/(a * a) >= 20 ){
			JOptionPane.showMessageDialog(null,"Parabens esta no Peso Ideal");
		}else{
			JOptionPane.showMessageDialog(null,"ta mt magro meu peixe.");
		}
		
	}
}
