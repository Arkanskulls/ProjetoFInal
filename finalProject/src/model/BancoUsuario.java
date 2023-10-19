package model;

import java.util.ArrayList;

import dao.PersistenciaXML;



public class BancoUsuario implements Iterator{
	private static BancoUsuario banco; 
	private int pos;

	public static synchronized BancoUsuario getBanco() {
		PersistenciaXML p = PersistenciaXML.getPersistencia();
		if (banco == null) {
			banco = p.recuperar();
		}
		return banco;
	}
	
	private  ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public  ArrayList<Usuario> getUsuario() {
		return usuarios;
	}
	
	
	//remover Cliente
	public void removeC(int i){
		usuarios.remove(i);
	}
	//adicionar cliente
	public void add(Usuario c){
		usuarios.add(c);
	}
	
	public void setCliente(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Object next() {
		return usuarios.get(++pos);
	}
	
	public boolean hasNext() {
		try {
			usuarios.get(pos+1);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void zerarHash() {
		pos = -1;
	}
	
	
}