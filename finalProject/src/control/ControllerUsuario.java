package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import dao.DAOJDBCPos;
import dao.DAOJDBCUsuarioPos;
import dao.PersistenciaXML;
import view.TelaUsuario;
import model.BancoUsuario;
import model.Usuario;



public class ControllerUsuario {
	public TelaUsuario form;
	public Usuario u;
	public static ArrayList <Usuario> usuarioDB = new ArrayList<>();
	public static ArrayList <Usuario> recupera = BancoUsuario.getBanco().getUsuario();
	
	
	public ControllerUsuario() {
		 form = new TelaUsuario();
		validacaoDeUsuariosExistente();
	}
	
	public void validacaoDeUsuariosExistente(){ 
		/*Verificar se o Usuarios esta cadastrados no programa
		 * Esse programa possui uma sobrescrita do metodo "equals" onde
		 * compara-se apenas o nome, e n„o o objeto inteiro*/ 
		form.jbCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				u = new Usuario(null, null, 0, 0, 0);
//				u.setCpf(form.jtCpf.getText());
//					if(recupera.contains(u)){
//						JOptionPane.showMessageDialog(null, "Usuario ja existe !");
//					}else{
						validacaoDeCamposNulos();
						
//					}
			}
		});
	}
	
	private void validacaoDeCamposNulos(){
        /*Verificar se n√£o h√° nehum campo vazio ou nulo, para evitar armazenamento de dados nulos no cadastro*/
                if ((form.jtNome.getText() == null || form.jtNome.getText().trim().isEmpty()) ||
                        (form.jtAltura.getText() == null || form.jtAltura.getText().trim().isEmpty()) ||
                        (form.jtPeso.getText() == null || form.jtPeso.getText().trim().isEmpty()) ||
                        (form.jtIdade.getText() == null || form.jtIdade.getText().trim().isEmpty()) || 
                        (form.jtCpf.getText() == null || form.jtCpf.getText().trim().isEmpty()))
                {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos !");
                } else {
                    eventosForm();
                }
            }
		 
	
	private void eventosForm(){
		/*Metodo que s„o sera° chamado depois das validaÁoes*/
				DAOJDBCUsuarioPos banco = new DAOJDBCUsuarioPos();
				Usuario usuario = new Usuario(null, null, 0, 0, 0);
				usuario.setNome(form.jtNome.getText());
				usuario.setAltura(Float.parseFloat(form.jtAltura.getText()));
				usuario.setIdade(Integer.parseInt(form.jtIdade.getText()));
				usuario.setCpf(form.jtCpf.getText());
				usuario.setPeso(Integer.parseInt(form.jtPeso.getText()));
			
				switch(form.getComboBox().getSelectedIndex()){
				case 1:
					banco.create(usuario);
					banco.close();
					JOptionPane.showMessageDialog(null, "Cadastro efetuado !");
					form.setVisible(false);
					
				break;
				case 2:
					
					usuarioDB.add(usuario);
					BancoUsuario.getBanco().add(usuario);
					PersistenciaXML.getPersistencia().salvar();
					JOptionPane.showMessageDialog(null, "Cadastro efetuado !");
					form.setVisible(false);
					
				break;

				default:
					  JOptionPane.showMessageDialog(null,"escolha um banco");
			
				break;
			}
				
				
			}
		
}
