package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Conexao;

import javax.swing.JOptionPane;

public abstract class DAOJDBCPos  implements Conexao {

	public Boolean status = false;
	Connection conn  = null;

	public void conectar() {
		if (conn == null) {
			try {
				
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/IMC", "postgres", "4321"); 
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			status = true;
			JOptionPane.showMessageDialog(null,"conectado");
		}
	}
	
	public void close() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			status = false;
		}
	}
	public  boolean  StatusConectar(){
		return this.status;
	}
	

	
}
