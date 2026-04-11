package main;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Carrello extends JPanel{
	
	//button per cambiare schermata
	private JButton magazzinoCar = new JButton();
	private JButton catalogoCar = new JButton();
	//button per aprire info profilo
	private JButton immagineProfiloCar = new JButton();
	//label per evidenziare schermata attuale
	private JLabel carrelloAttuale = new JLabel();
	//label per coprire
	private JLabel copriLineaCar = new JLabel();
	//label di contorno
	private JLabel strisciaSuperioreCar = new JLabel();
	//label dove verrà visualizzato il carrello
	private JLabel baseCarrello = new JLabel();
	//variabili usate per mettere le immagini
	private ImageIcon icon;
	private Image iconScaled;
	//button per confermare l'ordine
	private JButton confermaOrdine = new JButton();
	//label per lista prodotti nel carrello e informazioni di essi
	private JLabel sfondoProdotti = new JLabel();
	private JLabel informazioni = new JLabel();
	//jscroll e panel per contenere i prodotti del carrello
	private int altezzaPanelScrollCarrello, yMax;
	private JPanel panelScrollCarrello = new JPanel();
	private JScrollPane scrollCarrello;
	//JPanel usata per scorrere i prodotti nel carrello
	private LineaScorrimento scorriCarrello;
	//array che contiene prodotti in catalogo
	private ArrayList<ProdottoLungo> prodotti = new ArrayList<>();
	private int valore;
	private int cellaScorrimento;
	//label per contenere lo sfondo delle info dei prodotti nel carrello
	private Catalogo catalogo;
	//aggiungo il panel per il logout
	private Logout logout = new Logout();
	//bottone per passare alla schermata di elenco utenti
	private JButton gestioneUtenti = new JButton();

	//costruttore per creare la schermata del carrello
	public Carrello(Catalogo catalogo) {
		this.catalogo = catalogo;
		//setto il Panel
		setLayout(null);
		setBounds(0, 0, 1331, 768);
		//aggiungo il panel per il logout
		setPanelLogout();
		//aggingo i prodotti e la scrollbar personalizzata
		addComponentiScroll();
		setScorriCarrello();
		//setto i vari componenti
		setImmagineProfiloCar();
		setGestioneUtenti();
		setCopriLineaCarrello();
		setSfondoProdotti();
		setInformazioni();
		setConfermaOrdine();
		setBaseCarrello();
		setMagazzinoCar();
		setCatalogoCar();
		setCarrelloAttuale();
		setStrisciaSuperioreCar();
		setVisible(false);
		
	}

	//metodo per settare il button MagazzinoCar
	public void setMagazzinoCar() {
		//imposto le caratteristiche del bottone
		magazzinoCar.setContentAreaFilled(false);		
		magazzinoCar.setBorderPainted(false);
		magazzinoCar.setBounds(0, 60, 439, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzinoPress.png"));
		iconScaled = icon.getImage().getScaledInstance(439, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		magazzinoCar.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzino.png"));
		iconScaled = icon.getImage().getScaledInstance(439, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		magazzinoCar.setIcon(icon);
		add(magazzinoCar);
	}

	//metodo per settare il button catalogoCar
	public void setCatalogoCar() {
		//imposto le caratteristiche del bottone
		catalogoCar.setContentAreaFilled(false);		
		catalogoCar.setBorderPainted(false);
		catalogoCar.setBounds(439, 60, 438, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCatalogoPress.png"));
		iconScaled = icon.getImage().getScaledInstance(438, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		catalogoCar.setPressedIcon(icon);
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCatalogo.png"));
		iconScaled = icon.getImage().getScaledInstance(438, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		catalogoCar.setIcon(icon);
		add(catalogoCar);
	}
	
	//metodo per settare la label carrelloAttuale
	public void setCarrelloAttuale() {
		//imposto coordinate e grandezza della label
		carrelloAttuale.setBounds(877, 60, 438, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCarrelloAttuale.png"));
		iconScaled = icon.getImage().getScaledInstance(438, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		carrelloAttuale.setIcon(icon);
		add(carrelloAttuale);
	}
	
	//metodo per settare la label strisciaSuperioreCar
	public void setStrisciaSuperioreCar() {
		//imposto coordinate e grandezza della label
		strisciaSuperioreCar.setBounds(0, 0, 1331, 107);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("StrisciaSuperiore.png"));
		strisciaSuperioreCar.setIcon(icon);
		add(strisciaSuperioreCar);
	}
	
	//metodo per settare la label copriLineaCar
	public void setCopriLineaCarrello() {
		//imposto coordinate e grandezza della label
		copriLineaCar.setBounds(879, 95, 434, 11);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("CopriLineaCatalogoCarrello.png"));
		iconScaled = icon.getImage().getScaledInstance(434, 11, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		copriLineaCar.setIcon(icon);
		add(copriLineaCar);
	}
	
	//metodo per settare la label baseCarrello
	public void setBaseCarrello() {
		//imposto coordinate e grandezza della label
		baseCarrello.setBounds(0, 96, 1315, 672);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoCatalogoCarrello.png"));
		baseCarrello.setIcon(icon);
		add(baseCarrello);
	}
	
	//metodo per settare il button immagineProfiloCar
	public void setImmagineProfiloCar() {
		//imposto le caratteristiche del bottone
		immagineProfiloCar.setContentAreaFilled(false);		
		immagineProfiloCar.setBorderPainted(false);
		immagineProfiloCar.setBounds(1255, 2, 56, 56);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfiloPress.png"));
		immagineProfiloCar.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfilo.png"));
		immagineProfiloCar.setIcon(icon);
		//aggiungo un actionlistener per aprire scheda profilo
		immagineProfiloCar.addActionListener(e -> Collegamenti.fromOtherToLogout());
		add(immagineProfiloCar);
	}
	
	//metodo per settare il bottone elencoUtenti
	public void setGestioneUtenti() {
		//imposto le caratteristiche del bottone
		gestioneUtenti.setContentAreaFilled(false);		
		gestioneUtenti.setBorderPainted(false);
		gestioneUtenti.setBounds(22, 14, 262, 32);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonAmministrazionePress.png"));
		iconScaled = icon.getImage().getScaledInstance(262, 32, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		gestioneUtenti.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ButtonAmministrazione.png"));
		iconScaled = icon.getImage().getScaledInstance(262, 32, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		gestioneUtenti.setIcon(icon);
		//aggiungo un actionlistener per aprire scheda profilo
		gestioneUtenti.addActionListener(e -> Collegamenti.fromAdminToGestioneUtenti());
		add(gestioneUtenti);
	}
	
	//metodi per gestire il pannello logout
	public Logout getPanelLogout() {
		return logout;
	}
	public void setPanelLogout() {
		add(logout);
		logout.setVisible(false);
	}
	public void setLogout(String datiUtente) {
		String[] account = datiUtente.split(";");
		logout.setLabelTesto(account[0], account[2], account[1]);
	}
	
	//metodo da usare per settare il cambio schermata
	public JButton getMagazzinoCar() {
		return magazzinoCar;
	}
	
	//metodo da usare per settare il cambio schermata
	public JButton getCatalogoCar() {
		return catalogoCar;
	}
	
	//metodo per aggiungere subito questi due componenti se no vengono coperti
	public void addComponentiScroll() {
		panelScrollCarrello.setPreferredSize(new Dimension(804, 584));
		panelScrollCarrello.setBackground(null);
		panelScrollCarrello.setLayout(null);
		panelScrollCarrello.setOpaque(false);
		scrollCarrello = new JScrollPane(panelScrollCarrello, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCarrello.setBounds(42, 140, 804, 584);
		scrollCarrello.setBackground(null);
		scrollCarrello.setOpaque(false);
		scrollCarrello.getViewport().setOpaque(false);
		scrollCarrello.setBorder(null);
		scrollCarrello.getVerticalScrollBar().setUnitIncrement(20);
		altezzaPanelScrollCarrello = 0;
		add(scrollCarrello);
	}
	
	//metodo per generare i 70 prodotti nel catalogo
	public void generaProdotti(ArrayList<InformazioniDaPassare> prodotti, String yes) {
		if(yes.equals("yes")) {
			prodotti.clear();
			for(ProdottoLungo prod : this.prodotti) {
				prodotti.add(new InformazioniDaPassare(prod.getNome(), prod.getNAcquistati()));
			}
		}
		this.prodotti.clear();
		panelScrollCarrello.removeAll();
		//genero i prodotti
		int y = 10; 
		for(InformazioniDaPassare info : prodotti) {
			this.prodotti.add(new ProdottoLungo(10, y, info.getNome(), info.getQuantita(), this, prodotti, catalogo));
			y += 78;
		}
		//setto il panel con la grandezza totale che deve avere
		if(this.prodotti.size()==0) {
			altezzaPanelScrollCarrello = 0;
		} else {
			altezzaPanelScrollCarrello = 10+78*this.prodotti.size();
		}
		panelScrollCarrello.setPreferredSize(new Dimension(804, altezzaPanelScrollCarrello));
		for(ProdottoLungo prodotto : this.prodotti) {
			panelScrollCarrello.add(prodotto);
		}
		//setto lo scrollpane con la grandezza da mostrare
		scrollCarrello.setBounds(42, 140, 804, 584);
	}
	
	//metodo per settare il panel scorriCatalogo
	public void setScorriCarrello() {
		//setto la posizione di scorriCarrello, il JScrollPane associato e il tipo di LineaScorrimento che deve essere
		scorriCarrello = new LineaScorrimento(850, 148, scrollCarrello, "AdminCarrello");
		//aggiungo un changelistener per spostare il bottone di scorrimento laterale se non si usa quello ma la rotellina del mouse
		scrollCarrello.getViewport().addChangeListener(e -> {
			valore = (int) scrollCarrello.getVerticalScrollBar().getValue();
			//se il valore è 0 imposta lo scorriCatalogo automaticamente in cima
			if(valore == 0) {
				//if per non far scattare lo scorriCatalogo
				if(!scorriCarrello.getStoScorrendo()) {
					scorriCarrello.setYTastoScorrimento(3, "no");
				}
			//se il valore è uguale alla y massima che può raggiungere il pane dentro lo scroll imposta lo scorriCatalogo automaticamente in fondo
				yMax = altezzaPanelScrollCarrello - 584;
			} else if(valore == yMax) {
				//if per non far scattare lo scorriCatalogo
				if(yMax>0) {
					if(!scorriCarrello.getStoScorrendo()) {
						scorriCarrello.setYTastoScorrimento(525, "no");
					}
				}
			//se il valore non è 0 o 11126 calcola la cella in cui spostare lo scorriCatalogo
			} else {
				cellaScorrimento = valore / 111;
				//if per non far scattare lo scorriCatalogo
				if(!scorriCarrello.getStoScorrendo()) {
					scorriCarrello.setYTastoScorrimento(cellaScorrimento, "yes");
				}
			}
		});
		add(scorriCarrello);
	}
	
	//metodo per settare la label strisciaSuperioreCar
	public void setSfondoProdotti() {
		//imposto coordinate e grandezza della label
		sfondoProdotti.setBounds(42, 138, 844, 588);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoListaCarrello.png"));
		sfondoProdotti.setIcon(icon);
		add(sfondoProdotti);
	}
	
	private void setInformazioni() {
		//imposto coordinate e grandezza della label
		informazioni.setBounds(928, 138, 345, 463);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoInformazioniCarrello.png"));
		informazioni.setIcon(icon);
		add(informazioni);
	}
	
	private void setConfermaOrdine() {
		//imposto le caratteristiche del bottone
		confermaOrdine.setContentAreaFilled(false);		
		confermaOrdine.setBorderPainted(false);
		confermaOrdine.setBounds(928, 630, 345, 96);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ConfermaOrdineCarrelloPress.png"));
		confermaOrdine.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ConfermaOrdineCarrello.png"));
		confermaOrdine.setIcon(icon);
		add(confermaOrdine);
	}
	
	//metodo per ottenere l'array list prodottiNelCarrello
	public ArrayList<ProdottoLungo> getProdottiNelCarrello() {
		return prodotti;
	}

}
