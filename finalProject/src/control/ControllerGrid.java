package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.DAOJDBCUsuarioPos;
import dao.PersistenciaXML;
import view.GridVer;
import model.BancoUsuario;
import model.IMCAgentina;
import model.IMCBrasil;
import model.IMCChile;
import model.Usuario;

public class ControllerGrid {

	GridVer gridUsuario;
	public int delete;
	public DAOJDBCUsuarioPos banco = new DAOJDBCUsuarioPos();

	
	public ControllerGrid(int escolha) {
		
		gridUsuario = new GridVer();
		initEvents();
        chargeScreen(escolha);
		gridUsuario.grid.clearSelection(); //Foi adicionado esse m√©todo para que o grid n„o venha com nenhuma linha selecionada
	};
	
	private void initEvents(){		
		gridUsuario.btnExcluir.addActionListener(new ActionListener() { //Excluir usuario selecionado
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Usuario u = new Usuario(null, null, 0, 0, 0);
				int posicao = gridUsuario.grid.getSelectedRow();
				if(delete == 1){
				BancoUsuario.getBanco().removeC(posicao);//Exclui o usuario com indice correspondente
				((DefaultTableModel) gridUsuario.grid.getModel()).removeRow(posicao); //Exclui a linha
				PersistenciaXML.getPersistencia().salvar();
				}else{
					u.setCpf(gridUsuario.dtm.getValueAt(posicao, 0).toString());
					((DefaultTableModel) gridUsuario.grid.getModel()).removeRow(posicao);
					banco.delete(u);
					
				}
			}
			
		});
		gridUsuario.btnIMC.addActionListener(new ActionListener() { //
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int posicao = gridUsuario.grid.getSelectedRow();
				float peso = (float) gridUsuario.grid.getValueAt(posicao, 4);
				float altura = (float) gridUsuario.grid.getValueAt(posicao, 3);
				
				switch(gridUsuario.getComboBox().getSelectedIndex()){
					case 1:
						IMCBrasil brasil = new IMCBrasil();
						brasil.calculo(peso, altura);
						
					break;
					case 2:
						IMCAgentina ag = new IMCAgentina();
						ag.calculo(peso, altura);
						
					break;
					case 3:
						IMCChile chile = new IMCChile();
						chile.calculo(peso, altura);
						
					break;
					default:
						  JOptionPane.showMessageDialog(null,"escolha um pais");	
				}
   
			}
			
		});
		gridUsuario.btnLocaliza.addActionListener(new ActionListener() { //
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int resposta;
				String cpf;
				cpf = JOptionPane.showInputDialog("digite o cpf");
				for(int i = 0; i < gridUsuario.grid.getRowCount(); i++){
					if(cpf.equals(gridUsuario.grid.getValueAt(i,1))){
						resposta = JOptionPane.showConfirmDialog(null,"InformaÁoes do Usuario\n nome: "+gridUsuario.grid.getValueAt(i,0)+"\nCPF: "
								+gridUsuario.grid.getValueAt(i,1)+"\nIdade: "+gridUsuario.grid.getValueAt(i,2)+"\nAltura: "+gridUsuario.grid.getValueAt(i,3)+"\n Peso: "
								+gridUsuario.grid.getValueAt(i,4)+"\nDeseja calcular o IMC??");
						if (resposta == JOptionPane.YES_OPTION) {
							float peso = (float) gridUsuario.grid.getValueAt(i, 4);
							float altura = (float) gridUsuario.grid.getValueAt(i, 3);
							JOptionPane.showMessageDialog(null,"seu IMC È de: "+peso/(altura * altura));
						}else{
							JOptionPane.showMessageDialog(null,"Obrigado por consultar!");
						}
						
					}
					
				}
   
			}
			
		});
		
	}
	
	public void chargeScreen(int escolha){ 
		/*Carregar janela, foi criado apenas para 
		n√£o ter que ficar instanciando o mesmo arraylist toda hora*/
		if(escolha == 1)
		refreshGridXML(ControllerUsuario.usuarioDB);			
		else
			refreshGridPosgre();
			this.delete = 2;
	}
	
	public void refreshGridXML(ArrayList<Usuario> lista){ 
		/*Atualizar grid quando usuario fechar a tela de ediÁ„o e/ou
			quando houverem clientes no arraylist*/
		
		lista = BancoUsuario.getBanco().getUsuario();		
		int x = gridUsuario.dtm.getRowCount();
		while (x > 0) {
			x--;
			gridUsuario.dtm.removeRow(x);
		}

		for (Usuario u : lista) {
			gridUsuario.dtm.addRow(new Object[] { u.getNome(), u.getCpf(), u.getIdade(), u.getAltura(), u.getPeso()  });
		}
		if (gridUsuario.dtm.getRowCount() > 0) {
			gridUsuario.grid.setRowSelectionInterval(0, 0);
		}
	}
	public void refreshGridPosgre(){ 

		
		int x = gridUsuario.dtm.getRowCount();
		while (x > 0) {
			x--;
			gridUsuario.dtm.removeRow(x);
		}

		for (Usuario u : banco.find()) {
			
			gridUsuario.dtm.addRow(new Object[] { u.getCpf(),u.getNome(), u.getIdade(), u.getAltura(), u.getPeso() });
			
		}
		
		if (gridUsuario.dtm.getRowCount() > 0) {
			gridUsuario.grid.setRowSelectionInterval(0, 0);
		}
		
	}
	
}

