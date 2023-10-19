package dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.BancoUsuario;
import model.Conexao;


public class PersistenciaXML implements Conexao{
	private volatile static PersistenciaXML persistencia;
	public  XStream xstream = new XStream(new DomDriver(("ISO-8859-1")));
	public  File arquivo = new File("banco.xml");
	private Boolean status = false;
	public static synchronized PersistenciaXML getPersistencia() {
		if (persistencia == null) {
			persistencia = new PersistenciaXML();
		}
		return persistencia;
	}
	
	@Override
	public void conectar() {
		status = true;
		recuperar();	
	}

	public void salvar(){

		 String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
	        xml += xstream.toXML(BancoUsuario.getBanco());


		try {
			if(arquivo.exists())
				arquivo.createNewFile();
			PrintWriter gravar = new PrintWriter(arquivo);
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BancoUsuario recuperar(){

		try {
			if(arquivo.exists()){
				FileInputStream fis = new FileInputStream(arquivo);
				return(BancoUsuario) xstream.fromXML(arquivo);
			}	
		} catch (FileNotFoundException e) {
		}

		return new BancoUsuario();

	}
	
	@Override
	public boolean StatusConectar() {
		
		return status;
	}


	
}

