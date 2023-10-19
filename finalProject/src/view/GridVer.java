package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GridVer extends TelaPadrao {
	
	public JButton btnIMC, btnExcluir,btnLocaliza;
	public JPanel pnlgrid;
	public JTable grid;
	public DefaultTableModel dtm;
	public JScrollPane scr;
	public JComboBox<String> comboBox;
	
	public GridVer() {
		super("Usuarios",800,500);
		initComponents();
		initEvents();
		setVisible(true);
	}
	

	
	private void initComponents() {
		
		//Botões
				setLayout(null);
				btnLocaliza = new JButton("Localizar");
				btnLocaliza.setBounds(20, 20, 100, 30);
				btnLocaliza.setToolTipText("Excluir cliente selecionado");
				add(btnLocaliza);
				
				btnIMC = new JButton("IMC");
				btnIMC.setBounds(226, 20, 100, 30);
				add(btnIMC);
				
				btnExcluir = new JButton("EXCLUIR");
				btnExcluir.setBounds(340, 20, 100, 30);
				btnExcluir.setEnabled(false);
				add(btnExcluir);
				
				String [] op = {" ","Brasil","Argentina","Chile"};
				comboBox = new JComboBox<String>(op);
				comboBox.setBounds(460, 20, 100, 30);
				add(comboBox);
				
				
				//Grid
				scr = new JScrollPane();
				
				pnlgrid = new JPanel(); //Painel
				pnlgrid.setBorder(new TitledBorder("USUARIOS"));
				pnlgrid.setBackground(new Color(30, 144, 255));
				pnlgrid.setLayout(new BorderLayout());
				
				String[] colunas ={"Nome", "CPF", "Idade", "altura", "peso"};
				
				dtm = new DefaultTableModel(colunas, 0){ 
				

					@Override
					public boolean isCellEditable(int row, int col) {
							return false;
					}
					
				};
				grid = new JTable(dtm);
				
				for (int i = 0; i < colunas.length; i++) {
					grid.getColumnModel().getColumn(i).setPreferredWidth(200); 
					grid.getColumnModel().getColumn(i).setResizable(false);
				}
				grid.getTableHeader().setReorderingAllowed(false);
				DefaultTableCellRenderer alinCentro = new DefaultTableCellRenderer();
				alinCentro.setHorizontalAlignment(SwingConstants.CENTER);
				
				for (int i = 0; i < colunas.length; i++) {
					grid.getColumnModel().getColumn(i).setCellRenderer(alinCentro);
				}
				
				grid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				grid.setCellSelectionEnabled(false);
				grid.setRowSelectionAllowed(true);
				
				pnlgrid.add(grid);
				pnlgrid.add(scr);
				scr.setViewportView(grid);

				pnlgrid.setBounds(20, 80, 750, 360);
				add(pnlgrid);
	
				repaint();
	}
				
			private void initEvents(){
				grid.getSelectionModel().addListSelectionListener(
						/*Pegar linha selecionada*/
						new ListSelectionListener() {

							@Override
							public void valueChanged(ListSelectionEvent e) {
								if (e.getValueIsAdjusting()) {
									return;
								}
							}
				});
				
				grid.getSelectionModel().addListSelectionListener(new ListSelectionListener() { 
					/*Habilitar botoes se tiver uma linha selecionada*/
					@Override
					public void valueChanged(ListSelectionEvent e) {
						ListSelectionModel lsm = (ListSelectionModel) e.getSource();
						btnExcluir.setEnabled(!lsm.isSelectionEmpty());
						btnIMC.setEnabled(!lsm.isSelectionEmpty());
					}
				});
				
			}
			
			public JComboBox<String> getComboBox() {
				return comboBox;
			}
			public void setComboBox(JComboBox<String> comboBox) {
				this.comboBox = comboBox;
			}
			
				

} 
