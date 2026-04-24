package main;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

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
	
	private Utente utente;
	//string per tenere il nome del prodotto
	private String nomeProdotto;
	//private Catalogo catalogo;
	
	//costruttore, richiede (coordinata x, coordinata y, nome prodotto)
	public ProdottoQuadratoMini(int prX, int prY, String nomeProdotto, int acquistatiMag, Utente utente) {
		nAcquistati = acquistatiMag;
		nAttuale = acquistatiMag;
		this.utente = utente;
		this.nomeProdotto = nomeProdotto;
		//setto il Panel
		setLayout(null);
		setBounds(prX, prY, 236, 236);
		setOpaque(false);
		//setto le varie Label e i vari Button
		setNCatalogo();
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

	//metodo per settare la label N nel catalogo
	public void setNCatalogo() {
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
		//aggiungo un actionlistener per acquistare il numero di elementi selezionato, e quindi sommare nAttuale a nAcquistati
		buy.addActionListener(e -> buy());
		add(buy);
	}

	//metodo per aumentare la variabile nAttuale in base al riferimento Label N
	public void piuUno() {
		if(nAcquistati != 0) {
			nAttuale++;
			//controllo che il numero non vada sopra il 9
			if(nAttuale>nAcquistati) {
				nAttuale = nAcquistati;
			}
			N.setText(""+nAttuale);
		}
	}
	
	//metodo per diminuire la variabile nAttuale in base al riferimento Label N
	public void menoUno() {
		if(nAcquistati != 0) {
			nAttuale--;
			//controllo che il numero non vada sotto lo 0
			if(nAttuale<0) {
				nAttuale = 0;
			}
			N.setText(""+nAttuale);
		}
	}

	//metodo per sommare il numero di elementi comprati del prodotto
	public void buy() {
		if(nAcquistati != 0) {
			boolean nonTrovato = true;
			for(InformazioniDaPassare control : utente.getArrayInfo()) {
				if(control.getNome().equals(nomeProdotto)) {
					control.addQuantita(nAttuale);
					nAcquistati -= nAttuale;
					N.setText(""+nAcquistati);
					nAttuale = nAcquistati;
					nonTrovato = false;
					break;
				}
			}
			if(nonTrovato) {
				utente.getArrayInfo().add(new InformazioniDaPassare(nomeProdotto, nAttuale));
				nAcquistati -= nAttuale;
				N.setText(""+nAcquistati);
				nAttuale = nAcquistati;
			}
			utente.generaCarrello();
		}
	}
	
	//metodo per resettare nAcquistati
	/*public void resetNAcquistati() {
		nAcquistati = 0;
	}
	
	//metodo per diminuire nAcquistati se si elimina dal carrello
	public void delNAcquistati(int n) {
		nAcquistati -= n;
	}

	//metodo per ottenere nAttuale
	public int getNAttuale() {
		return nAttuale;
	}
	
	//metodo per ottenere nAcquistati
	public int getNAcquistati() {
		return nAcquistati;
	}
	
	//metodo per ottenere nAcquistati
	public void addNAcquistati(int n) {
		nAcquistati += n;
	}
	
	//metodo per ottenere il nome del prodotto
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	
	//metodo per ottenere il tasto buy
	public JButton getBuyButton() {
		return buy;
	}
	
	public void aggiornaN() {
	    N.setText(""+nAcquistati);
	    N.revalidate();
	    N.repaint();
	}*/
}
