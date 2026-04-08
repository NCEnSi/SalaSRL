package main;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class ProdottoLungo extends JPanel{
	
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
	
	//costruttore, richiede (coordinata x, coordinata y, nome prodotto)
	public ProdottoLungo(int prX, int prY, String nomeProdotto, int nAcquistati) {
		this.nAcquistati = nAcquistati;
		N.setText(""+nAcquistati);
		nAttuale = nAcquistati;
		//setto il Panel
		setLayout(null);
		setBounds(prX, prY, 788, 68);
		setOpaque(false);
		//setto le varie Label e i vari Button
		setN();
		setPiu(nomeProdotto);
		setMeno(nomeProdotto);
		setBuy(nomeProdotto);
		setSfondo(nomeProdotto);
	}
	
	//metodo per settare la label base
	public void setSfondo(String nomeProdotto) {
		//imposto coordinate e grandezza della label
		base.setBounds(0, 0, 788, 68);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoProdottoLung"+nomeProdotto+".png"));
		base.setIcon(icon);
		add(base);
	}

	//metodo per settare la label N
	public void setN() {
		//imposto coordinate e grandezza della label
		N.setBounds(651, 18, 32, 32);
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
		piu.setBounds(686, 18, 32, 32);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("PiuProdottoLungPress.png"));
		iconScaled = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		piu.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("PiuProdottoLung.png"));
		iconScaled = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
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
		meno.setBounds(616, 18, 32, 32);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("MenoProdottoLungPress.png"));
		iconScaled = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		meno.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("MenoProdottoLung.png"));
		iconScaled = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		meno.setIcon(icon);
		//aggiungo un actionlistener per diminuire nAttuale
		meno.addActionListener(e -> menoUno(nomeProdotto));
		add(meno);
	}

	//metodo per settare il bottone buy
	public void setBuy(String nomeProdotto) {
		//imposto le caratteristiche del bottone	
		canc.setContentAreaFilled(false);		
		canc.setBorderPainted(false);
		canc.setBounds(731, 18, 32, 32);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("CancProdottoLungPress.png"));
		iconScaled = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		canc.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("CancProdottoLung.png"));
		iconScaled = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		canc.setIcon(icon);
		//aggiungo un actionlistener per acquistare il numero di elementi selezionato, e quindi sommare nAttuale a nAcquistati
		canc.addActionListener(e -> canc(nomeProdotto));
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
		System.out.println("Stai eliminando "+nAttuale+" "+nomeProdotto);
	}
	
	//metodo per diminuire la variabile nAttuale in base al riferimento Label N
	public void menoUno(String nomeProdotto) {
		nAttuale--;
		//controllo che il numero non vada sotto lo 0
		if(nAttuale<0) {
			nAttuale = 0;
		}
		N.setText(""+nAttuale);
		System.out.println("Stai eliminando "+nAttuale+" "+nomeProdotto);
	}

	//metodo per sommare il numero di elementi comprati del prodotto
	public void canc(String nomeProdotto) {
		nAcquistati -= nAttuale;
		if(nAcquistati<0) {
			nAcquistati = 0;
		}
		System.out.println("In totale hai comprato "+nAcquistati+" "+nomeProdotto);
	}
}
