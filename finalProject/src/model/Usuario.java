package model;



public class Usuario {
	private String cpf;
	private int idade;
	private float altura;
	private float peso;
    private String nome;
    private float imc;
    
    public Usuario(String string,String nome,int i,float p,float a )  {
  		// TODO Auto-generated constructor stub
  	}
    
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public int getIdade() {
		return idade;
	}
	public float getAltura() {
		return altura;
	}
	public float getPeso() {
		return peso;
	}
	public String getNome() {
		return nome;
	}
    //validar cpf
	@Override
	public boolean equals(Object o) {
		Usuario u = new Usuario(cpf, cpf, idade, altura, altura);
		u = (Usuario) o;
		return (this.getCpf().equals(u.getCpf()));
	}
	
//	 public String toString() { 
//	      return 
//	   }

}
