package dao;

import java.util.List;

import model.Usuario;

public interface InterfacePersistencia<O> {
	
	
	public void create(O object);
	
	public void delete(O object);
	
	public void update(O object);
	
	public List<Usuario> find();

}
