package entidades.sistema;

public class Roteador {

	private String nome;
	
	private String marca;

	private int qtdAntenas;
	
	private double preco;

	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public String getMarca() {
		return marca;
	}
	public int getQtdAntenas() {
		return qtdAntenas;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setQtdAntenas(int qtdAntenas) {
		this.qtdAntenas = qtdAntenas;
	}

}
