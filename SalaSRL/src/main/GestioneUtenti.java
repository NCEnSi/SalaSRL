package main;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class GestioneUtenti extends JPanel{

	//VARIABILI DI ISTANZA
	
	//jlabel usata per lo sfondo della schermata
	private JLabel schermataGestioneUtenti = new JLabel();
	//bottone per tornare alla schermata precedente
	private JButton freccetta = new JButton();
	//button per aprire info profilo
	private JButton immagineProfiloGestUt = new JButton();
	//aggiungo il panel per il logout
	private Logout logout = new Logout();
	//variabile usata come appoggio per poter caricare le immagini sui bottoni
	private ImageIcon immagine;
	private Image immScalata;
	//JPanel usata per scorrere i prodotti nel catalogo
	private LineaScorrimento scorriGestioneUtenti;
	//jscroll e panel per contenere gli utenti dell'elenco
	private JPanel panelScrollGestUt = new JPanel();
	private JScrollPane scrollGestUt;
	//variabili usate per settare scrollGestUt e scorriGestioneUtenti
	private int valore;
	private int cellaScorrimento;
	//creo la variabile per gli oggetti per interagire con il file txt
	private BufferedReader lettura;
	
	
	//COSTRUTTORE
	public GestioneUtenti() throws IOException {
		//imposto le dimensioni del pannello "schermo"
		setLayout(null);
		setBounds(0, 0, 1331, 768);
		
		//aggiungo il panel per il logout
		setPanelLogout();
		//creo la lista degli utenti
		generaElencoUtenti();
		//aggiungo la scrollbar personalizzata
		setScorriGestioneUtenti();
		//imposto il bottone per le informazioni del profilo
		setImmagineProfiloGestUt();
		//imposto il bottone per tornare indietro
		setImmagineFreccetta();
		//imposto lo sfondo della schermata
		setSchermataGestioneUtenti();
		
		setVisible(false);
	}
	
	
	
	//METODI DI ISTANZA
	//metodo per impostare lo sfondo del pannello gestione utenti
	public void setSchermataGestioneUtenti() {
		//imposto lo sfondo
		schermataGestioneUtenti.setBounds(0, 0, 1331, 768);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("SfondoElencoUtenti.png"));
		schermataGestioneUtenti.setIcon(immagine);
		add(schermataGestioneUtenti);
	}
	//metodo per settare il button immagineProfiloCar
	public void setImmagineProfiloGestUt() {
		//imposto le caratteristiche del bottone
		immagineProfiloGestUt.setContentAreaFilled(false);		
		immagineProfiloGestUt.setBorderPainted(false);
		immagineProfiloGestUt.setBounds(1255, 2, 56, 56);
		//imposto l'immagine da dargli
		immagine = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfiloPress.png"));
		immagineProfiloGestUt.setPressedIcon(immagine);	
		immagine = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfilo.png"));
		immagineProfiloGestUt.setIcon(immagine);
		//aggiungo un actionlistener per aprire scheda profilo
		immagineProfiloGestUt.addActionListener(e -> toLogout());
		add(immagineProfiloGestUt);
	}
	//metodo per settare il button immagineProfiloCar
	public void setImmagineFreccetta() {
		//imposto le caratteristiche del bottone
		freccetta.setContentAreaFilled(false);		
		freccetta.setBorderPainted(false);
		freccetta.setBounds(20, 7, 57, 47);
		//imposto l'immagine da dargli
		immagine = new ImageIcon(getClass().getClassLoader().getResource("FrecciaIndietroPress.png"));
		freccetta.setPressedIcon(immagine);	
		immagine = new ImageIcon(getClass().getClassLoader().getResource("FrecciaIndietro.png"));
		freccetta.setIcon(immagine);
		//aggiungo un actionlistener per aprire scheda profilo
		freccetta.addActionListener(e -> Collegamenti.fromGestioneUtentiToAdmin());
		add(freccetta);
	}
	//metodo per settare il panel scorriCatalogo
	public void setScorriGestioneUtenti() {
		//setto la posizione di scorriCatalogo, il JScrollPane associato e il tipo di LineaScorrimento che deve essere
		scorriGestioneUtenti = new LineaScorrimento(1284, 102, scrollGestUt, "AdminCatalogo");
		//aggiungo un changelistener per spostare il bottone di scorrimento laterale se non si usa quello ma la rotellina del mouse
		scrollGestUt.getViewport().addChangeListener(e -> {
			valore = (int) scrollGestUt.getVerticalScrollBar().getValue();
			//se il valore è 0 imposta lo scorriCatalogo automaticamente in cima
			if(valore == 0) {
				//if per non far scattare lo scorriCatalogo
				if(!scorriGestioneUtenti.getStoScorrendo()) {
					scorriGestioneUtenti.setYTastoScorrimento(3, "no");
				}
			//se il valore è uguale alla y massima che può raggiungere il pane dentro lo scroll imposta lo scorriCatalogo automaticamente in fondo
			} else if(valore == 7037) {
				//if per non far scattare lo scorriCatalogo
				if(!scorriGestioneUtenti.getStoScorrendo()) {
					scorriGestioneUtenti.setYTastoScorrimento(618, "no");
				}
			//se il valore non è 0 o 7037 calcola la cella in cui spostare lo scorriCatalogo
			} else {
				cellaScorrimento = valore / 70 - 1;
				//if per non far scattare lo scorriCatalogo
				if(!scorriGestioneUtenti.getStoScorrendo()) {
					scorriGestioneUtenti.setYTastoScorrimento(cellaScorrimento, "yes");
				}
			}
		});
		add(scorriGestioneUtenti);
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
	public void toLogout() {
		logout.setVisible(true);
	}
	
	//metodo per creare l'elenco degli utenti
	public void generaElencoUtenti() throws IOException {
		//setto il panel con la grandezza totale che deve avere
		panelScrollGestUt.setPreferredSize(new Dimension(1315, 7700));
		panelScrollGestUt.setBackground(null);
		panelScrollGestUt.setLayout(null);
		panelScrollGestUt.setOpaque(false);
				
		//oggetto per leggere tutto il file
		lettura = new BufferedReader(new FileReader("Credenziali.txt"));
		//array dove salvo ogni username e privilegio degli account nel file
		ArrayList<String []> elencoUtenti = new ArrayList<>();
		//ciclo per salvare ogni riga
		String riga; String[] nomeANDpriv = new String[2];
		//controllo ogni riga del file txt
		while ((riga = lettura.readLine()) != null) {
			//array che contiene solo username e privilegio
			nomeANDpriv = new String[2];
			//creo un array dove ogni componente contiene un'informazione dell'account sapendo le loro posizioni
			String[] credenziali = riga.split(";");
			//salvo nome e privilegio
			nomeANDpriv[0] = credenziali[0];
			nomeANDpriv[1] = credenziali[3];
			//aggingo nell'arraylist
			elencoUtenti.add(nomeANDpriv);
		}
		//chiudo la lettura
		lettura.close();
		//variabile per impostare la coordinata y dei diversi pannelli utenti
		int prY = 40;
		//creo l'elenco utenti lungo
		for(int i = 0; i < elencoUtenti.size(); i++) {
			//per ogni componente dell'arraylist ricavo nome e privilegio
			nomeANDpriv = elencoUtenti.get(i);
			//creo l'oggetto utente lungo
			panelScrollGestUt.add(new UtenteLungo(prY, nomeANDpriv[0], nomeANDpriv[1]));
			prY += 65;
		}		
				
		//setto lo scrollpane con la grandezza da mostrare
		scrollGestUt = new JScrollPane(panelScrollGestUt, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollGestUt.setBounds(0, 100, 1279, 663);
		scrollGestUt.setBackground(null);
		scrollGestUt.setOpaque(false);
		scrollGestUt.getViewport().setOpaque(false);
		scrollGestUt.setBorder(null);
		scrollGestUt.getVerticalScrollBar().setUnitIncrement(20);
		add(scrollGestUt);
	}
	
	
}
