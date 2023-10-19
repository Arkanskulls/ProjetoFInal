package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class TelaUsuario extends TelaPadrao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel jlNome = new JLabel("Nome:\n ");
	public JLabel jlCpf = new JLabel("\nCpf: ");
	public JLabel jlIdade = new JLabel("\nIdade:\n ");
	public JLabel jlAltura = new JLabel("\nAltura:\n ");
	public JLabel jlPeso = new JLabel("\nPeso:\n ");
	public JTextField jtNome = new JTextField(20);
	public JTextField jtCpf = new JTextField(20);
	public JTextField jtIdade = new JTextField(20);
	public JTextField jtAltura = new JTextField(20);
	public JTextField jtPeso = new JTextField(20);
	public JButton jbCadastrar = new JButton("Cadastrar");
	public MaskFormatter mskCpf;
	public JComboBox<String> comboBox;

    
	public TelaUsuario() {
		super("Cadastro Usuario",300,300);
		Tela();
	}
	
	public void Tela (){

		setLayout(new FlowLayout(FlowLayout.LEFT));
		jbCadastrar.setToolTipText("Clique para concluir cadastro");
	//		try {
	//		mskCpf = new MaskFormatter("###.###.###-##");
	//	} catch (ParseException e) {
	//		e.printStackTrace();
	//	}
	//	jtCpf = new JFormattedTextField(mskCpf);
		
		String [] op = {" ","PostgreSQL","XML"};
		comboBox = new JComboBox<String>(op); 
		
		add(jlNome);
		add(jtNome);
		add(jlIdade);
		add(jtIdade);
		add(jlCpf);
		add(jtCpf);
		add(jlPeso);
		add(jtPeso);
		add(jlAltura);
		add(jtAltura);
		add(jbCadastrar);
		add(comboBox);
				
		setVisible(true);
	}
	
	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}


}


