package main;

import java.awt.*;
import javax.swing.*;
import java.io.*;
//COMMENTATA INTERAMENTE
public class ProdottoQuadratoMini extends JPanel{
	
	//Label per base del prodotto
	private JLabel base = new JLabel();
	//Label per numero quantità prodotto
	private JLabel N = new JLabel("0");
	//Button per aumentare N
	private JButton piu = new JButton();
	//Button per diminuire N
	private JButton meno = new JButton();
	//Button per comprare N elemtni del prodotto
	private JButton buy = new JButton();
	//variabili per inserire le immagini
	private ImageIcon icon;
	private Image iconScaled;
	//variabili per tenere traccia di N e di quanti elementi si ha già comprato del prodotto
	private int nAttuale = 0;
	private int nAcquistati = 0;
	//variabile per contenere la classe utente in cui viene creato
	private Utente utente;
	//string per tenere il nome del prodotto
	private String nomeProdotto;
	
	//costruttore che richiede le coordinate, il nome, la quantità disponibile e la classe utente in cui sta venendo creato
	public ProdottoQuadratoMini(int prX, int prY, String nomeProdotto, int acquistatiMag, Utente utente) {
		//setto le varie variabili
		nAcquistati = acquistatiMag;
		nAttuale = acquistatiMag;
		this.utente = utente;
		this.nomeProdotto = nomeProdotto;
		//setto il Panel
		setLayout(null);
		setBounds(prX, prY, 236, 236);
		setOpaque(false);
		//setto le varie Label e i vari Button
		setN();
		setPiu();
		setMeno();
		setBuy();
		setSfondo(nomeProdotto);
	}
	
	//metodo per settare la label base
	public void setSfondo(String nomeProdotto) {
		//imposto coordinate e grandezza della label
		base.setBounds(0, 0, 148, 148);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoProdottoQuadMini"+nomeProdotto+".png"));
		base.setIcon(icon);
		add(base);
	}

	//metodo per settare la label N
	public void setN() {
		//imposto coordinate e grandezza della label
		N.setBounds(88, 116, 23, 23);
		//personalizzo la label e il suo testo
		N.setText(""+nAttuale);
		N.setBackground(null);
		N.setFont(new Font("Arial", Font.PLAIN, 16));
		N.setHorizontalAlignment(JLabel.CENTER);
		add(N);
	}

	//metodo per settare il bottone piu
	public void setPiu() {
		//imposto le caratteristiche del bottone
		piu.setContentAreaFilled(false);		
		piu.setBorderPainted(false);
		piu.setBounds(111, 116, 23, 23);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonPiuQuadUtentePress.png"));
		iconScaled = icon.getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		piu.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonPiuQuadUtente.png"));
		iconScaled = icon.getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		piu.setIcon(icon);
		//aggiungo un actionlistener per aumentare nAttuale
		piu.addActionListener(e -> piuUno());
		add(piu);
	}

	//metodo per settare il bottone meno
	public void setMeno() {
		//imposto le caratteristiche del bottone
		meno.setContentAreaFilled(false);		
		meno.setBorderPainted(false);
		meno.setBounds(65, 116, 23, 23);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonMenoQuadUtentePress.png"));
		iconScaled = icon.getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		meno.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonMenoQuadUtente.png"));
		iconScaled = icon.getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		meno.setIcon(icon);
		//aggiungo un actionlistener per diminuire nAttuale
		meno.addActionListener(e -> menoUno());
		add(meno);
	}

	//metodo per settare il bottone buy
	public void setBuy() {
		//imposto le caratteristiche del bottone	
		buy.setContentAreaFilled(false);		
		buy.setBorderPainted(false);
		buy.setBounds(14, 116, 23, 23);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonCompraUtentePress.png"));
		iconScaled = icon.getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		buy.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonCompraUtente.png"));
		iconScaled = icon.getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		buy.setIcon(icon);
		//aggiungo un actionlistener per implementare il metodo buy()
		buy.addActionListener(e -> {
			try {
				buy();
			} catch(IOException y) {
				System.out.println("Error");
			}
		});
		add(buy);
	}

	//metodo per aumentare la variabile nAttuale in base al riferimento Label N
	public void piuUno() {
		//incremento nAttuale
		nAttuale++;
		//controllo che il numero non vada sopra nAcquistati
		if(nAttuale>nAcquistati) {
			nAttuale = nAcquistati;
		}
		N.setText(""+nAttuale);
	}
	
	//metodo per diminuire la variabile nAttuale in base al riferimento Label N
	public void menoUno() {
		//decremento nAttuale
		nAttuale--;
		//controllo che il numero non vada sotto lo 0
		if(nAttuale<0) {
			nAttuale = 0;
		}
		N.setText(""+nAttuale);
	}

	//metodo per passare la quantità scelta del prodotto al carrello
	public void buy() throws IOException{
		//boolean e for per verificare che il prodotto non sia già nel carrello
		boolean nonTrovato = true;
		for(InformazioniDaPassare control : utente.getArrayInfo()) {
			if(control.getNome().equals(nomeProdotto)) {
				//se è già presente aumenta la quantità che si sta comprando e decrementa le varie variabili e in N
				control.addQuantita(nAttuale);
				nAcquistati -= nAttuale;
				N.setText(""+nAcquistati);
				nAttuale = nAcquistati;
				nonTrovato = false;
				break;
			}
		}
		//se non è stato trovato lo aggiunge all'array e decrementa le varie variabili e in N
		if(nonTrovato) {
			utente.getArrayInfo().add(new InformazioniDaPassare(nomeProdotto, nAttuale));
			nAcquistati -= nAttuale;
			N.setText(""+nAcquistati);
			nAttuale = nAcquistati;
		}
		//rigenerea il carrello con i prodotti aggiornati
		utente.generaCarrello();
	}
	
	//metodo per aggiungere una quantità ad nAcquistati
	public void addNAcquistati(int n) {
		nAcquistati += n;
	}
	
	//metodo per ottenere il nome del prodotto
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	
	//metodo per aggiornare N
	public void aggiornaN() {
	    N.setText(""+nAcquistati);
	    nAttuale = nAcquistati;
	    N.revalidate();
	    N.repaint();
	}
}
