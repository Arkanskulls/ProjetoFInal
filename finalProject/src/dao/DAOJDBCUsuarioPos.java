package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Usuario;


public class DAOJDBCUsuarioPos extends DAOJDBCPos implements InterfacePersistencia<Usuario>{
	
	@Override
	public void create(Usuario object) {
	String sql = "INSERT INTO usuario(cpf,nome,idade,peso,altura) VALUES (?, ?, ?, ?, ?)";
	if (object != null) {
		conectar();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, object.getCpf());
			statement.setString(2, object.getNome());
			statement.setInt(3,object.getIdade());
			statement.setFloat(4, object.getPeso());
			statement.setFloat(5, object.getAltura());			
			statement.executeUpdate();
			
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	}
}

	@Override
	public void delete(Usuario object) {
		String sql = "delete  from usuario where cpf = ?";
		if (object != null) {
			conectar();
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, object.getCpf());
				statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close();
		}
		
		
	}

	@Override
	public void update(Usuario object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> find() {
		String sql = "select * from usuario";
		List<Usuario> lista = new ArrayList<Usuario>();
		
			
		conectar();
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				
				while (rs.next()){
					
					Usuario u = new Usuario(null,null, 0, 0, 0);
					u.setCpf(rs.getString("cpf"));
					u.setNome(rs.getString("nome"));
					u.setIdade(rs.getInt("idade"));
					u.setPeso(rs.getFloat("peso"));
					u.setAltura(rs.getFloat("altura"));
					lista.add(u);
					
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close();
		
		return  lista;
		
	}





	
	
}
