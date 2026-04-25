package main;
//COMMENTATA INTERAMENTE
public class InformazioniDaPassare {

	//variabili per contenere il nome e la quantità in questione di un prodotto
	private String nome;
	private int quantita;
	
	//costruttore in cui passo i vari dati
	public InformazioniDaPassare(String nome, int quantita) {
		this.nome = nome;
		this.quantita = quantita;
	}
	
	//metodo set per settare il nome
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//metodo set per settare la quantità
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	//metodo per incrementare la quantità già presente con un'altra desiderata
	public void addQuantita(int quantita) {
		this.quantita += quantita;
	}
	
	//metodo per decrementare la quantità già presente con un'altra desiderata
	public void subQuantita(int quantita) {
		this.quantita -= quantita;
	}
	
	//metodo get per restituire il nome
	public String getNome() {
		return nome;
	}
	
	//metodo get per restituire la quantità
	public int getQuantita() {
		return quantita;
	}
	
}
