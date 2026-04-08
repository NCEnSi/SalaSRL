package main;

public class InformazioniDaPassare {

	private String nome;
	private int quantita;
	
	public InformazioniDaPassare(String nome, int quantita) {
		this.nome = nome;
		this.quantita = quantita;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
}
