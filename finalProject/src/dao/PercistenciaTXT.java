package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.Conexao;
import model.Usuario;

public class PercistenciaTXT implements Conexao {

	private  ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private String nome;
	public Boolean status = false;
	
	public PercistenciaTXT() {
		this.usuarios = new ArrayList<Usuario>();
	}

	@Override
	public void conectar() {
		this.nome = "usuario.txt";
		this.recuperarTXT();
		status = true;
		
	}
	
	public  ArrayList<Usuario> getUsuario() {
		return usuarios;
	}
	private void salvar() {
		String texto = "------------------------\n";
		
		for (Usuario usuario : this.usuarios) {
			usuarios.add(usuario);
		}
		
		File arquivo = new File(this.nome);
		
		try {
			if(!arquivo.exists()) {
				arquivo.createNewFile();
			}
			PrintWriter gravar = new PrintWriter(arquivo);
			gravar.print(texto);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
private void recuperarTXT() {
		
		try {
			FileReader arq = new FileReader(this.nome);
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine();
			String r = "";
			while (linha != null) {
				r += linha +"\n";
				linha = lerArq.readLine();
			}
			
			arq.close();
			String[] vetor = r.split("\n");
			
			for (int i = 1; i < vetor.length; i += 10) {
				
				this.usuarios.addAll(getUsuario());
			}
			
		} catch (IOException e) {
			this.salvar();
			this.recuperarTXT();
		}
	}

	@Override
	public boolean StatusConectar() {
		
		return status;
	}


	
}
