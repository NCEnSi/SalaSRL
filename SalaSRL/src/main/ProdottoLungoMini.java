package main;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class ProdottoLungoMini extends JPanel{
	
	//Label per base del prodotto
	private JLabel base = new JLabel();
	//Label per numero quantità prodotto
	private JLabel N = new JLabel();
	//Button per aumentare N
	private JButton piu = new JButton();
	//Button per diminuire N
	private JButton meno = new JButton();
	//Button per comprare N elemtni del prodotto
	private JButton canc = new JButton();
	//variabili per inserire le immagini
	private ImageIcon icon;
	private Image iconScaled;
	//variabili per tenere traccia di N e di quanti elementi si ha già comprato del prodotto
	private int nAttuale = 0;
	private int nAcquistati = 10;
	//stringa per tenere il nome del prodotto
	private String nomeProdotto;
	//private Catalogo catalogo;
	
	//costruttore, richiede (coordinata x, coordinata y, nome prodotto)
	public ProdottoLungoMini(int prX, int prY, String nomeProdotto, int nAcquistati) {
		this.nAcquistati = nAcquistati;
		nAttuale = nAcquistati;
		this.nomeProdotto = nomeProdotto;
		N.setText(""+nAttuale);
		//nAttuale = nAcquistati;
		//setto il Panel
		setLayout(null);
		setBounds(prX, prY, 303, 68);
		setOpaque(false);
		//setto le varie Label e i vari Button
		setN();
		setPiu(this.nomeProdotto);
		setMeno(this.nomeProdotto);
		setCanc();
		setSfondo(this.nomeProdotto);
	}
	
	//metodo per settare la label base
	public void setSfondo(String nomeProdotto) {
		//imposto coordinate e grandezza della label
		base.setBounds(0, 0, 303, 68);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoProdottoLungMini"+nomeProdotto+".png"));
		base.setIcon(icon);
		add(base);
	}

	//metodo per settare la label N
	public void setN() {
		//imposto coordinate e grandezza della label
		N.setBounds(210, 20, 20, 20);
		//personalizzo la label e il suo testo
		N.setBackground(null);
		N.setFont(new Font("Arial", Font.PLAIN, 20));
		N.setHorizontalAlignment(JLabel.CENTER);
		add(N);
	}

	//metodo per settare il bottone piu
	public void setPiu(String nomeProdotto) {
		//imposto le caratteristiche del bottone
		piu.setContentAreaFilled(false);		
		piu.setBorderPainted(false);
		piu.setBounds(230, 20, 20, 20);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonPiuLungUtentePress.png"));
		iconScaled = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		piu.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonPiuLungUtente.png"));
		iconScaled = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		piu.setIcon(icon);
		//aggiungo un actionlistener per aumentare nAttuale
		piu.addActionListener(e -> piuUno(nomeProdotto));
		add(piu);
	}

	//metodo per settare il bottone meno
	public void setMeno(String nomeProdotto) {
		//imposto le caratteristiche del bottone
		meno.setContentAreaFilled(false);		
		meno.setBorderPainted(false);
		meno.setBounds(190, 20, 20, 20);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonMenoLungUtentePress.png"));
		iconScaled = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		meno.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonMenoLungUtente.png"));
		iconScaled = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		meno.setIcon(icon);
		//aggiungo un actionlistener per diminuire nAttuale
		meno.addActionListener(e -> menoUno(nomeProdotto));
		add(meno);
	}

	//metodo per settare il bottone buy
	public void setCanc() {
		//imposto le caratteristiche del bottone	
		canc.setContentAreaFilled(false);		
		canc.setBorderPainted(false);
		canc.setBounds(270, 20, 20, 20);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonDelUtentePress.png"));
		iconScaled = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		canc.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonDelUtente.png"));
		iconScaled = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		canc.setIcon(icon);
		//aggiungo un actionlistener per acquistare il numero di elementi selezionato, e quindi sommare nAttuale a nAcquistati
		canc.addActionListener(e -> canc());
		add(canc);
	}

	//metodo per aumentare la variabile nAttuale in base al riferimento Label N
	public void piuUno(String nomeProdotto) {
		nAttuale++;
		//controllo che il numero non vada sopra il 9
		if(nAttuale>nAcquistati) {
			nAttuale = nAcquistati;
		}
		N.setText(""+nAttuale);
	}
	
	//metodo per diminuire la variabile nAttuale in base al riferimento Label N
	public void menoUno(String nomeProdotto) {
		nAttuale--;
		//controllo che il numero non vada sotto lo 0
		if(nAttuale<0) {
			nAttuale = 0;
		}
		N.setText(""+nAttuale);
	}

	//metodo per sommare il numero di elementi comprati del prodotto
	public void canc() {
		
	}
	
	public String getNome() {
		return nomeProdotto;
	}
	
	public int getNAcquistati() {
		return nAcquistati;
	}
	
	public int getNAttuale() {
		return nAttuale;
	}
}
