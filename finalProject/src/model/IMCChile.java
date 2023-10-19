package model;

import javax.swing.JOptionPane;

public class IMCChile implements InterfaceIMC {

	@Override
	public void calculo(float p, float a) {
		JOptionPane.showMessageDialog(null,"seu IMC é de: "+p/(a * a));
		if(p/(a * a) > 30){
			JOptionPane.showMessageDialog(null,"de la muerte de su Obezo");
			
		}if (p/(a * a) < 30 &&  p/(a * a) >= 20 ){
			JOptionPane.showMessageDialog(null,"Parabens esta en el peso ideal");
		}else{
			JOptionPane.showMessageDialog(null,"que es lo que mas me gusta.");
		}

		
	}

}
