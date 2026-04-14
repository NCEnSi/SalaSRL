package main;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ProdottoQuadrato extends JPanel{
	
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
	//string per tenere il nome del prodotto
	private String nomeProdotto;
	
	private Catalogo catalogo;
	
	//costruttore, richiede (coordinata x, coordinata y, nome prodotto)
	public ProdottoQuadrato(int prX, int prY, String nomeProdotto, String compra, Catalogo catalogo, int acquistatiMag) {
		this.catalogo = catalogo;
		this.nomeProdotto = nomeProdotto;
		//setto il Panel
		setLayout(null);
		setBounds(prX, prY, 236, 236);
		setOpaque(false);
		//setto le varie Label e i vari Button
		switch(compra) {
		case "yes":
			setNCatalogo();
			setPiu(nomeProdotto);
			setMeno(nomeProdotto);
			setBuy(nomeProdotto);
			setSfondo(nomeProdotto);
			break;
			
		case "no":
			setNMagazzino(acquistatiMag);
			setSfondo(nomeProdotto);
			break;
		}
		
	}
	
	//metodo per settare la label base
	public void setSfondo(String nomeProdotto) {
		//imposto coordinate e grandezza della label
		base.setBounds(0, 0, 236, 236);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoProdottoQuad"+nomeProdotto+".png"));
		base.setIcon(icon);
		add(base);
	}

	//metodo per settare la label N nel catalogo
	public void setNCatalogo() {
		//imposto coordinate e grandezza della label
		N.setBounds(139, 185, 37, 37);
		//personalizzo la label e il suo testo
		N.setBackground(null);
		N.setFont(new Font("Arial", Font.PLAIN, 24));
		N.setHorizontalAlignment(JLabel.CENTER);
		add(N);
	}
	
	//metodo per settare la label N nel magazzino
	public void setNMagazzino(int nAcquistati) {
		//imposto coordinate e grandezza della label
		N.setBounds(139, 185, 37, 37);
		//personalizzo la label e il suo testo
		N.setBackground(null);
		N.setFont(new Font("Arial", Font.PLAIN, 24));
		N.setHorizontalAlignment(JLabel.CENTER);
		N.setText(""+nAcquistati);
		add(N);
	}

	//metodo per settare il bottone piu
	public void setPiu(String nomeProdotto) {
		//imposto le caratteristiche del bottone
		piu.setContentAreaFilled(false);		
		piu.setBorderPainted(false);
		piu.setBounds(179, 185, 37, 37);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("PiuProdottoQuadPress.png"));
		iconScaled = icon.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		piu.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("PiuProdottoQuad.png"));
		iconScaled = icon.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
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
		meno.setBounds(99, 185, 37, 37);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("MenoProdottoQuadPress.png"));
		iconScaled = icon.getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		meno.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("MenoProdottoQuad.png"));
		iconScaled = icon.getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		meno.setIcon(icon);
		//aggiungo un actionlistener per diminuire nAttuale
		meno.addActionListener(e -> menoUno(nomeProdotto));
		add(meno);
	}

	//metodo per settare il bottone buy
	public void setBuy(String nomeProdotto) {
		//imposto le caratteristiche del bottone	
		buy.setContentAreaFilled(false);		
		buy.setBorderPainted(false);
		buy.setBounds(20, 185, 37, 37);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BuyProdottoQuadPress.png"));
		iconScaled = icon.getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		buy.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BuyProdottoQuad.png"));
		iconScaled = icon.getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		buy.setIcon(icon);
		//aggiungo un actionlistener per acquistare il numero di elementi selezionato, e quindi sommare nAttuale a nAcquistati
		buy.addActionListener(e -> buy(nomeProdotto));
		add(buy);
	}

	//metodo per aumentare la variabile nAttuale in base al riferimento Label N
	public void piuUno(String nomeProdotto) {
		nAttuale++;
		//controllo che il numero non vada sopra il 9
		if(nAttuale>9) {
			nAttuale = 9;
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
	public void buy(String nomeProdotto) {
		//DOPO SISTEMARE SE NO SOMMA SEMPRE NEL CARRELLO
		nAcquistati += nAttuale;
		boolean giaPresente = false;
		if(getNAttuale()>0) {
			for(InformazioniDaPassare info : catalogo.getProdottiNelCarrello()) {
				String nome = info.getNome();
				if(nome.equals(getNomeProdotto())) {
					giaPresente = true;
					//aggiorno nAcquistati se no rimane uguale al primo acquisto
					for(InformazioniDaPassare e : catalogo.getProdottiNelCarrello()) {
						if(info.getNome().equals(e.getNome())) {
							info.setQuantita(nAcquistati);
							break;
						}
					}
					if(info.getQuantita()>=99) {
						info.setQuantita(99);
					}
					break;
				}
			}
			if(!giaPresente) {
				InformazioniDaPassare info = new InformazioniDaPassare(getNomeProdotto(), getNAcquistati());
				catalogo.getProdottiNelCarrello().add(info);
			}
		}
	}
	
	//metodo per resettare nAcquistati
	public void resetNAcquistati() {
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
}
