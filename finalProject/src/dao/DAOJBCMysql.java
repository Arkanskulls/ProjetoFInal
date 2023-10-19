package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Conexao;
import model.Usuario;

public class DAOJBCMysql implements Conexao {
	public Connection connection;
	public Statement statement;
	public Boolean status = false;
	private String endereco;
	private String bd;
	private String usuario;
	private String senha;
	Connection conn  = null;
	
	public  DAOJBCMysql() {
		this.endereco = "127.0.0.1:3306";
		this.bd = "imc";
		this.usuario = "root";
		this.senha = "";
	}

	@Override
	public void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =  DriverManager.getConnection("jdbc:mysql://"+endereco+"/"+bd , usuario, senha);
			statement = connection.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			conectar();
		}
		status = true;
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
		
		@Override
		public boolean StatusConectar(){
			return status;
		}

}
