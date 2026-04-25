package main;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
//COMMENTATA INTERAMENTE
public class Utente extends JPanel{
	
	//label per lo sfondo della schermata
	private JLabel sfondoBase = new JLabel();
	//label per la striscia blu in alto
	private JLabel strisciaSuperiore = new JLabel();
	//label per lo sfondo dei prodotti disponibili
	private JLabel sfondoProdotti = new JLabel();
	//label per lo sfondo dei prodotti nel carrello
	private JLabel sfondoCarrello = new JLabel();
	//button per confermare l'ordine
	private JButton confermaOrdine = new JButton();
	//button per aprire info profilo
	private JButton immagineProfiloMag = new JButton();
	//aggiungo il panel per il logout
	private Logout logout = new Logout();
	//variabili usate per mettere le immagini
	private ImageIcon icon;
	//jscroll e panel per contenere i prodotti del carrello utente
	private int altezzaPanelScrollCatalogoUtente;
	private JPanel panelScrollCatalogoUtente = new JPanel();
	private JScrollPane scrollCatalogoUtente;
	//jscroll e panel per contenere i prodotti del carrello utente
	private int altezzaPanelScrollCarrelloUtente;
	private JPanel panelScrollCarrelloUtente = new JPanel();
	private JScrollPane scrollCarrelloUtente;
	//variabili usate per aggiungere i prodotti nelle posizioni corrette nel catalogo
	private int i = 0;
	private int x = 0, y = 10;
	//creo le variabili per gli oggetti per interagire con il file txt
	private BufferedWriter scrittura;
	private BufferedReader lettura;
	//array dove ogni componente contiene un'informazione di un prodotto sapendo le loro posizioni
	private String[] datiProdotto;
	//array che contengono i prodotti nel catalogo e nel carrello 
	private ArrayList<ProdottoQuadratoMini> prodottiInCatalogoUtente = new ArrayList<>();
	private ArrayList<ProdottoLungoMini> prodottiInCarrelloUtente = new ArrayList<>();
	//array che contiene il nome dei prodotti messi nel carrello
	private ArrayList<InformazioniDaPassare> info = new ArrayList<>();
	
	//costruttore
	public Utente() throws IOException{
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
	
	//metodo per settare il button confermaOrdine
	public void setConfermaOrdine() throws IOException{
		//imposto le caratteristiche del bottone
		confermaOrdine.setContentAreaFilled(false);		
		confermaOrdine.setBorderPainted(false);
		confermaOrdine.setBounds(928, 642, 345, 96);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ConfermaOrdineUtentePress.png"));
		confermaOrdine.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ConfermaOrdineUtente.png"));
		confermaOrdine.setIcon(icon);
		//aggiungo un actionlistener per usare il metodo confermaOrdine()
		confermaOrdine.addActionListener(e -> {
		try{
			confermaOrdine();
		} catch(Exception i) {
			System.out.println("Error");
		}
		});
		add(confermaOrdine);
	}
	
	//metodo per settare la label sfondoBase
	public void setSfondoBase() {
		//imposto coordinate e grandezza della label
		sfondoBase.setBounds(0, 60, 1315, 708);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BaseUtente.png"));
		sfondoBase.setIcon(icon);
		add(sfondoBase);
	}
	
	//metodo per settare la label strisciaSuperiore
	public void setStrisciaSuperiore() {
		//imposto coordinate e grandezza della label
		strisciaSuperiore.setBounds(0, 0, 1331, 60);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("StrisciaSuperioreUtente.png"));
		strisciaSuperiore.setIcon(icon);
		add(strisciaSuperiore);
	}
	
	//metodo per settare la label sfondoProdotti
	public void setSfondoProdotti() {
		//imposto coordinate e grandezza della label
		sfondoProdotti.setBounds(42, 89, 844, 650);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoProdottiUtente.png"));
		sfondoProdotti.setIcon(icon);
		add(sfondoProdotti);
	}
	
	//metodo per settare la label sfondoCarrello
	public void setSfondoCarrello() {
		//imposto coordinate e grandezza della label
		sfondoCarrello.setBounds(928, 89, 345, 524);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoCarrelloUtente.png"));
		sfondoCarrello.setIcon(icon);
		add(sfondoCarrello);
	}

	//metodo per far funzionare il logout
	public void setPanelLogout() {
		//aggiungo un actionlistener per usare il metodo che permette il logout
		logout.getLogout().addActionListener(e -> Collegamenti.fromLogoutToLogin());
		add(logout);
		logout.setVisible(false);
	}
	
	//metodo per settare le informazioni nel panel logout
	public void setLogout(String datiUtente) {
		//separo le informazioni e le inserico nel posto giusto tramite il metodo setLabelTesto()
		String[] account = datiUtente.split(";");
		logout.setLabelTesto(account[0], account[2], account[1]);
	}
	
	//metodo per rendere visibile logout
	public void showLogouts() {
		logout.setVisible(true);
	}
	
	//metodo per non rendere visibile logout
	public void unShowLogouts() {
		logout.setVisible(false);
	}
	
	//metodo per settare i JScroll e i panel all'interno
	public void addComponentiScroll() {
		//setto e aggiungo il jscroll e il panel della parte catalogo
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
		//setto e aggiungo il jscroll e il panel della parte carrello
		panelScrollCarrelloUtente.setPreferredSize(new Dimension(345, 524));
		panelScrollCarrelloUtente.setBackground(null);
		panelScrollCarrelloUtente.setLayout(null);
		panelScrollCarrelloUtente.setOpaque(false);
		scrollCarrelloUtente = new JScrollPane(panelScrollCarrelloUtente, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCarrelloUtente.setBounds(928, 91, 345, 520);
		scrollCarrelloUtente.setBackground(null);
		scrollCarrelloUtente.setOpaque(false);
		scrollCarrelloUtente.getViewport().setOpaque(false);
		scrollCarrelloUtente.setBorder(null);
		scrollCarrelloUtente.getVerticalScrollBar().setUnitIncrement(20);
		add(scrollCarrelloUtente);
	}

	//metodo per generare i prodotti nella sezione catalogo
	public void generaProdotti() throws IOException{
		//rimuovo tutto dal panel e dall'array per riaggiungerli da capo e non rischiare sovrapposizioni
		panelScrollCatalogoUtente.removeAll();
		prodottiInCatalogoUtente.clear();
		//variabile usata per salvarmi ogni riga del file txt analizzato
		String riga = "";
		//creo l'oggetto che legge il file txt Magazzino
		lettura = new BufferedReader(new FileReader("Magazzino.txt"));
		//setto le variabili per posizionare i prodotti nella posizione corretta
		i = 0;
		y = 10;
		//controllo ogni riga del file e aggiungo di conseguenza i prodotti
		while ((riga = lettura.readLine()) != null) {
			//in base alla variabile i setto la x del prodotto
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
			
			//divido le informazioni del prodotto analizzato
			datiProdotto = riga.split(";");
			//aggiungo all'array un nuovo prodotto passandogli le coordinate, le informazioni prese dal file txt e questa stessa classe utente
			prodottiInCatalogoUtente.add(new ProdottoQuadratoMini(x, y, datiProdotto[1], Integer.valueOf(datiProdotto[0]), this));
			
			//if per controllare se sono stati aggiunti 5 prodotti in una riga
			if(i==5) {
				//se è vero resetto i e incremento y per creare a capo i nuovi prodotti
				i = 0;
				y += 158;
			}
		}
		//aggiungo al panel tutti i prodotti creati
		for(ProdottoQuadratoMini prodotto : prodottiInCatalogoUtente) {
			panelScrollCatalogoUtente.add(prodotto);
		}
		//setto la nuova altezza del panel tramite il metodo calcolaAltezzaPanelCatalogo() e aggiorno la grafica
		panelScrollCatalogoUtente.setPreferredSize(new Dimension(808, calcolaAltezzaPanelCatalogo()));
		panelScrollCatalogoUtente.revalidate();
		panelScrollCatalogoUtente.repaint();
		//chiudo la lettura
		lettura.close();
		//setto la posizione di visualizzazione del jscroll in cima
		scrollCatalogoUtente.getVerticalScrollBar().setValue(0);
	}
	
	//metodo per calcolare l'altezza del panel prodottiInCatalogoUtente
	public int calcolaAltezzaPanelCatalogo() {
		//controllo che il numero di prodotti sia un multiplo di 5
		if(prodottiInCatalogoUtente.size() % 5 == 0) {
			//se lo è calcola il numero di righe di prodotti, lo moltiplica per l'altezza di ogni riga e aggiunge il bordo finale
			altezzaPanelScrollCatalogoUtente = prodottiInCatalogoUtente.size() / 5 * 158 + 10;
		} else {
			//se non lo è calcola il numero di righe di prodotti aggiungendo 1 a causa dell'arrotondamento di int, lo moltiplica per l'altezza di ogni riga e aggiunge il bordo finale
			altezzaPanelScrollCatalogoUtente = (prodottiInCatalogoUtente.size() / 5 + 1) * 158 + 10;
		}
		return altezzaPanelScrollCatalogoUtente;
	}
	
	//metodo per calcolare l'altezza del panel prodottiInCarrelloUtente
	public int calcolaAltezzaPanelCarrello() {
		//moltiplica il numero di prodotti per l'altezza di ogni prodotto e aggiunge il bordo finale
		altezzaPanelScrollCarrelloUtente = prodottiInCarrelloUtente.size() * 78 + 10;
		return altezzaPanelScrollCarrelloUtente;
	}
	
	//metodo per restituire info
	public ArrayList<InformazioniDaPassare> getArrayInfo() {
		return info;
	}
	
	//metodo per generare i prodotti nel carrello
	public void generaCarrello() throws IOException {
		//rimuovo tutto dal panel e dall'array per riaggiungerli da capo e non rischiare sovrapposizioni
		panelScrollCarrelloUtente.removeAll();
		prodottiInCarrelloUtente.clear();
		//setto le variabili per posizionare i prodotti nella posizione corretta
		x = 10;
		y = 10;
		//for per aggiungere creare e aggiungere all'array tutti i prodotti contenuti in info
		for(InformazioniDaPassare control : info) {
			//aggiungo all'array un nuovo prodotto passandogli le coordinate, le informazioni prese dall'array e questa stessa classe utente
			prodottiInCarrelloUtente.add(new ProdottoLungoMini(x, y, control.getNome(), control.getQuantita(), this));
			//incremento y per posizionare correttamente il prodotti successivo
			y += 78;
		}
		//aggiungo al panel tutti i prodotti creati
		for(ProdottoLungoMini prod : prodottiInCarrelloUtente) {
			panelScrollCarrelloUtente.add(prod);
		}
		//setto la nuova altezza del panel tramite il metodo calcolaAltezzaPanelCatalogo() e aggiorno la grafica
		panelScrollCarrelloUtente.setPreferredSize(new Dimension(345, calcolaAltezzaPanelCarrello()));
		panelScrollCarrelloUtente.revalidate();
		panelScrollCarrelloUtente.repaint();
		//setto la posizione di visualizzazione del jscroll in cima
		scrollCarrelloUtente.getVerticalScrollBar().setValue(0);
	}
	
	//metodo per confermare l'ordine e rimuovere dal catalogo utente i prodotti ormai acquistati
	public void confermaOrdine() throws IOException {
		//variabile usata per salvarmi ogni riga del file txt analizzato
		String riga = "";
		//creo l'oggetto che legge il file txt Magazzino
		lettura = new BufferedReader(new FileReader("Magazzino.txt"));
		//creo l'oggetto che scriva il file txt AppMagazzino
		scrittura = new BufferedWriter(new FileWriter("AppMagazzino.txt"));
		//controllo ogni riga del file
		while ((riga = lettura.readLine()) != null) {
			//divido le informazioni del prodotto analizzato
			datiProdotto = riga.split(";");
			//for e if per controllare se il prodotto della riga analizzata del file è presente nel carrello al momento della conferma
			for(InformazioniDaPassare control : info) {
				if(control.getNome().equals(datiProdotto[1])) {
					//se è presente aggiorno il valore sottraendo la quantità acquistata e modificando di conseguenzaz la prima cella dell'array
					int valoreProdottoFile = Integer.valueOf(datiProdotto[0]);
					valoreProdottoFile -= control.getQuantita();
					datiProdotto[0] = ""+valoreProdottoFile;
					break;
				}
			}
			//riscrivo il prodotto con la nuova quantità
			scrittura.write(datiProdotto[0]+";"+datiProdotto[1]);
			scrittura.newLine();
		}
		//chiudo la lettura e la scrittura
		lettura.close();
		scrittura.close();
		//creo l'oggetto che legge il file txt AppMagazzino
		lettura = new BufferedReader(new FileReader("AppMagazzino.txt"));
		//creo l'oggetto che scriva il file txt Magazzino
		scrittura = new BufferedWriter(new FileWriter("Magazzino.txt"));
		//controllo ogni riga del file
		while ((riga = lettura.readLine()) != null) {
			//divido le informazioni del prodotto analizzato
			datiProdotto = riga.split(";");
			//se la quantità non è uguale a 0 lo riaggiunge al file del magazzino
			if(!datiProdotto[0].equals("0")) {
				scrittura.write(riga);
				scrittura.newLine();
			}
		}
		//chiudo la lettura e la scrittura
		lettura.close();
		scrittura.close();
		//svuoto l'array con le info dei prodotti nel carrello, il panel con i prodotti e aggiorno la grafica
		info.clear();
		panelScrollCarrelloUtente.removeAll();
		panelScrollCarrelloUtente.revalidate();
		panelScrollCarrelloUtente.repaint();
		//rigenero i prodotti nel catalogo nel caso alcuni non fossero più presenti o avessero quantità disponibili minori
		generaProdotti();
	}
	
	//metodo per restituire prodottiInCatalogoUtente
	public ArrayList<ProdottoQuadratoMini> getArrayProdottiCatalogo(){
		return prodottiInCatalogoUtente;
	}
}
