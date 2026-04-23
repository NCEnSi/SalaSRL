package main;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class Utente extends JPanel{
	
	private JLabel sfondoBase = new JLabel();
	private JLabel strisciaSuperiore = new JLabel();
	private JLabel sfondoProdotti = new JLabel();
	private JLabel sfondoCarrello = new JLabel();
	private JButton confermaOrdine = new JButton();
	//button per aprire info profilo
	private JButton immagineProfiloMag = new JButton();
	//aggiungo il panel per il logout
	private Logout logout = new Logout();
	//variabili usate per mettere le immagini
	private ImageIcon icon;
	//jscroll e panel per contenere i prodotti del carrello utente
	private int altezzaPanelScrollCatalogoUtenteInt;
	private int altezzaPanelScrollCatalogoUtenteDouble;
	private JPanel panelScrollCatalogoUtente = new JPanel();
	private JScrollPane scrollCatalogoUtente;
	//jscroll e panel per contenere i prodotti del carrello utente
	private int altezzaPanelScrollCarrelloUtenteInt;
	private int altezzaPanelScrollCarrelloUtenteDouble;
	private JPanel panelScrollCarrelloUtente = new JPanel();
	private JScrollPane scrollCarrelloUtente;
	//variabili usate per aggiungere i prodotti nel magazzino
	private int i = 0;
	private int x = 0, y = 10;
	//creo le variabili per gli oggetti per interagire con il file txt
	private BufferedWriter scrittura;
	private BufferedReader lettura;
	//array che contiene il nome dei prodotti messi nel magazzino
	private ArrayList<ProdottoQuadratoMini> prodottiInCatalogoUtente = new ArrayList<>();
	private ArrayList<ProdottoQuadratoMini> prodottiInCarrelloUtente = new ArrayList<>();

	//costruttore
	public Utente() {
		//setto il Panel
		setLayout(null);
		setBounds(0, 0, 1331, 768);
		//aggiungo il panel per il logout
		setPanelLogout();
		//setto i vari componenti
		addComponentiScroll();
		setImmagineProfiloMag();
		setConfermaOrdine();
		setStrisciaSuperiore();
		setSfondoProdotti();
		setSfondoCarrello();
		setSfondoBase();
	}
	
	//metodo per settare il button immagineProfiloMag
	public void setImmagineProfiloMag() {
		//imposto le caratteristiche del bottone
		immagineProfiloMag.setContentAreaFilled(false);		
		immagineProfiloMag.setBorderPainted(false);
		immagineProfiloMag.setBounds(1255, 2, 56, 56);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfiloPress.png"));
		immagineProfiloMag.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfilo.png"));
		immagineProfiloMag.setIcon(icon);
		//aggiungo un actionlistener per aprire scheda profilo
		immagineProfiloMag.addActionListener(e -> Collegamenti.fromOtherToLogout());
		add(immagineProfiloMag);
	}
	
	//metodo per settare il button immagineProfiloMag
	public void setConfermaOrdine() {
		//imposto le caratteristiche del bottone
		confermaOrdine.setContentAreaFilled(false);		
		confermaOrdine.setBorderPainted(false);
		confermaOrdine.setBounds(928, 642, 345, 96);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ConfermaOrdineUtentePress.png"));
		confermaOrdine.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ConfermaOrdineUtente.png"));
		confermaOrdine.setIcon(icon);
		//aggiungo un actionlistener per aprire scheda profilo
		//confermaOrdine.addActionListener(e -> Collegamenti.fromOtherToLogout());
		add(confermaOrdine);
	}
	
	//metodo per settare la label magazzinoAttuale
	public void setSfondoBase() {
		//imposto coordinate e grandezza della label
		sfondoBase.setBounds(0, 60, 1315, 708);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BaseUtente.png"));
		sfondoBase.setIcon(icon);
		add(sfondoBase);
	}
	
	//metodo per settare la label magazzinoAttuale
	public void setStrisciaSuperiore() {
		//imposto coordinate e grandezza della label
		strisciaSuperiore.setBounds(0, 0, 1331, 60);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("StrisciaSuperioreUtente.png"));
		strisciaSuperiore.setIcon(icon);
		add(strisciaSuperiore);
	}
	
	//metodo per settare la label magazzinoAttuale
	public void setSfondoProdotti() {
		//imposto coordinate e grandezza della label
		sfondoProdotti.setBounds(42, 89, 844, 650);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoProdottiUtente.png"));
		sfondoProdotti.setIcon(icon);
		add(sfondoProdotti);
	}
	
	//metodo per settare la label magazzinoAttuale
	public void setSfondoCarrello() {
		//imposto coordinate e grandezza della label
		sfondoCarrello.setBounds(928, 89, 345, 524);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoCarrelloUtente.png"));
		sfondoCarrello.setIcon(icon);
		add(sfondoCarrello);
	}

	public void setPanelLogout() {
		//aggiungo un actionlistener per cambiare pannello
		logout.getLogout().addActionListener(e -> Collegamenti.fromLogoutToLogin());
		add(logout);
		logout.setVisible(false);
	}
	
	public void setLogout(String datiUtente) {
		String[] account = datiUtente.split(";");
		logout.setLabelTesto(account[0], account[2], account[1]);
	}
	
	public void showLogouts() {
		logout.setVisible(true);
	}
	
	public void unShowLogouts() {
		logout.setVisible(false);
	}
	
	//metodo per aggiungere subito questi due componenti se no vengono coperti
	public void addComponentiScroll() {
		panelScrollCatalogoUtente.setPreferredSize(new Dimension(808, 650));
		panelScrollCatalogoUtente.setBackground(null);
		panelScrollCatalogoUtente.setLayout(null);
		panelScrollCatalogoUtente.setOpaque(false);
		scrollCatalogoUtente = new JScrollPane(panelScrollCatalogoUtente, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCatalogoUtente.setBounds(42, 91, 808, 646);
		scrollCatalogoUtente.setBackground(null);
		scrollCatalogoUtente.setOpaque(false);
		scrollCatalogoUtente.getViewport().setOpaque(false);
		scrollCatalogoUtente.setBorder(null);
		scrollCatalogoUtente.getVerticalScrollBar().setUnitIncrement(20);
		add(scrollCatalogoUtente);
	}

	public void generaProdotti() throws IOException{
		panelScrollCatalogoUtente.removeAll();
		prodottiInCatalogoUtente.clear();
		//variabile usata per salvarmi ogni riga del file txt
		String riga = "";
		//creo l'oggetto che legge il file txt
		lettura = new BufferedReader(new FileReader("Magazzino.txt"));
		//controllo ogni riga del file txt
		i = 0;
		y = 10;
		while ((riga = lettura.readLine()) != null) {
			i++;
			switch(i) {
			case 1:
				x = 10;
				break;

			case 2:
				x = 170;
				break;

			case 3:
				x = 330;
				break;

			case 4:
				x = 490;
				break;

			case 5:
				x = 650;
				break;
			}
			//creo un array dove ogni componente contiene un'informazione del prodotto sapendo le loro posizioni
			String[] datiProdotto = riga.split(";");
			prodottiInCatalogoUtente.add(new ProdottoQuadratoMini(x, y, datiProdotto[1], Integer.valueOf(datiProdotto[0])));

			if(i==5) {
				i = 0;
				y += 158;
			}
		}
		for(ProdottoQuadratoMini prodotto : prodottiInCatalogoUtente) {
			panelScrollCatalogoUtente.add(prodotto);
		}
		panelScrollCatalogoUtente.setPreferredSize(new Dimension(808, calcolaAltezzaPanel()));
		System.out.println(calcolaAltezzaPanel());
		panelScrollCatalogoUtente.revalidate();
		panelScrollCatalogoUtente.repaint();
		//chiudo la lettura
		lettura.close();
		scrollCatalogoUtente.getVerticalScrollBar().setValue(0);
	}
	
	public int calcolaAltezzaPanel() {
		if(prodottiInCatalogoUtente.size() % 5 == 0) {
			altezzaPanelScrollCatalogoUtenteDouble = prodottiInCatalogoUtente.size() / 5 * 158 + 10;
		} else {
			altezzaPanelScrollCatalogoUtenteDouble = (prodottiInCatalogoUtente.size() / 5 + 1) * 158 + 10;
		}
		altezzaPanelScrollCatalogoUtenteInt = (int) altezzaPanelScrollCatalogoUtenteDouble;
		if(altezzaPanelScrollCatalogoUtenteInt<altezzaPanelScrollCatalogoUtenteDouble) {
			altezzaPanelScrollCatalogoUtenteInt++;
		}
		return altezzaPanelScrollCatalogoUtenteInt;
	}
	
	
}
