package main;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Catalogo extends JPanel{
	
	//button per cambiare schermata
	private JButton magazzinoCat = new JButton();
	private JButton carrelloCat = new JButton();
	//button per aprire info profilo
	private JButton immagineProfiloCat = new JButton();
	//label per evidenziare schermata attuale
	private JLabel catalogoAttuale = new JLabel();
	//label per coprire
	private JLabel copriLineaCat = new JLabel();
	//label di contorno
	private JLabel strisciaSuperioreCat = new JLabel();
	//label dove appaiono i prodotti nel catalogo
	private JLabel baseCatalogo = new JLabel();
	//variabili usate per mettere le immagini
	private ImageIcon icon;
	private Image iconScaled;
	//array che contiene prodotti in catalogo
	private ProdottoQuadrato[] prodotti = new ProdottoQuadrato[70];
	//array che contiene il nome dei prodotti messi nel carrello
	private ArrayList<InformazioniDaPassare> prodottiNelCarrello = new ArrayList<>();
	//jscroll e panel per contenere i prodotti del catalogo
	private JPanel panelScrollCatalogo = new JPanel();
	private JScrollPane scrollCatalogo;
	//aggiungo il panel per il logout
	private Logout logout = new Logout();
	//bottone per passare alla schermata di elenco utenti
	private JButton gestioneUtenti = new JButton();
	
	//costruttore per creare la schermata del catalogo
	public Catalogo(String privilegi) {
		//setto il Panel
		setLayout(null);
		setBounds(0, 0, 1331, 768);
		//aggiungo il panel per il logout
		setPanelLogout();
		//aggingo i prodotti e la scrollbar personalizzata
		generaProdotti();
		//setto i vari componenti
		setImmagineProfiloCat();
		if(privilegi.equals("Creatore")) setGestioneUtenti();
		setCopriLineaCatalogo();
		setBaseCatalogo();
		setMagazzinoCat();
		setCarrelloCat();
		setCatalogoAttuale();
		setStrisciaSuperioreCat();
		setVisible(false);
	}
	
	//metodo per settare il button MagazzinoCat
	public void setMagazzinoCat() {
		//imposto le caratteristiche del bottone
		magazzinoCat.setContentAreaFilled(false);		
		magazzinoCat.setBorderPainted(false);
		magazzinoCat.setBounds(0, 60, 439, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzinoPress.png"));
		iconScaled = icon.getImage().getScaledInstance(439, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		magazzinoCat.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzino.png"));
		iconScaled = icon.getImage().getScaledInstance(439, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		magazzinoCat.setIcon(icon);
		add(magazzinoCat);
	}

	//metodo per settare il button carrelloCat
	public void setCarrelloCat() {
		//imposto le caratteristiche del bottone
		carrelloCat.setContentAreaFilled(false);		
		carrelloCat.setBorderPainted(false);
		carrelloCat.setBounds(877, 60, 438, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCarrelloPress.png"));
		iconScaled = icon.getImage().getScaledInstance(438, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		carrelloCat.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCarrello.png"));
		iconScaled = icon.getImage().getScaledInstance(438, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		carrelloCat.setIcon(icon);
		add(carrelloCat);
	}

	//metodo per settare il button immagineProfiloCat
	public void setImmagineProfiloCat() {
		//imposto le caratteristiche del bottone
		immagineProfiloCat.setContentAreaFilled(false);		
		immagineProfiloCat.setBorderPainted(false);
		immagineProfiloCat.setBounds(1255, 2, 56, 56);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfiloPress.png"));
		immagineProfiloCat.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfilo.png"));
		immagineProfiloCat.setIcon(icon);
		//aggiungo un actionlistener per aprire scheda profilo
		immagineProfiloCat.addActionListener(e -> Collegamenti.fromOtherToLogout() );
		add(immagineProfiloCat);
	}

	//metodi per gestire il pannello logout
	public Logout getPanelLogout() {
		return logout;
	}
	public void setPanelLogout() {
		//aggiungo un actionlistener per cambiare pannello
		logout.getLogout().addActionListener(e -> {
			Collegamenti.fromLogoutToLogin();
			logout.resetProdottiCarrello(prodottiNelCarrello, panelScrollCatalogo);
		});
		add(logout);
		logout.setVisible(false);
	}
	
	public void setLogout(String datiUtente) {
		String[] account = datiUtente.split(";");
		logout.setLabelTesto(account[0], account[2], account[1]);
	}

	//metodo per settare la label catalogoAttuale
	public void setCatalogoAttuale() {
		//imposto coordinate e grandezza della label
		catalogoAttuale.setBounds(439, 60, 438, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCatalogoAttuale.png"));
		iconScaled = icon.getImage().getScaledInstance(438, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		catalogoAttuale.setIcon(icon);
		add(catalogoAttuale);
	}
	
	//metodo per settare la label strisciaSuperioreCat
	public void setStrisciaSuperioreCat() {
		//imposto coordinate e grandezza della label
		strisciaSuperioreCat.setBounds(0, 0, 1331, 107);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("StrisciaSuperiore.png"));
		strisciaSuperioreCat.setIcon(icon);
		add(strisciaSuperioreCat);
	}

	//metodo per settare la label copriLineaCat
	public void setCopriLineaCatalogo() {
		//imposto coordinate e grandezza della label
		copriLineaCat.setBounds(441, 95, 434, 11);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("CopriLineaCatalogoCarrello.png"));
		iconScaled = icon.getImage().getScaledInstance(434, 11, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		copriLineaCat.setIcon(icon);
		add(copriLineaCat);
	}

	//metodo per settare la label baseCatalogo
	public void setBaseCatalogo() {
		//imposto coordinate e grandezza della label
		baseCatalogo.setBounds(0, 96, 1315, 672);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoCatalogoCarrello.png"));
		baseCatalogo.setIcon(icon);
		add(baseCatalogo);
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
		gestioneUtenti.addActionListener(e -> Collegamenti.fromCreatoreToGestioneUtenti());
		add(gestioneUtenti);
	}
	
	//metodo per generare i 70 prodotti nel catalogo
	public void generaProdotti() {
		//setto il panel con la grandezza totale che deve avere
		panelScrollCatalogo.setPreferredSize(new Dimension(1315, 3604));
		panelScrollCatalogo.setBackground(null);
		panelScrollCatalogo.setLayout(null);
		panelScrollCatalogo.setOpaque(false);
		//creo 70 diversi prodotti
		prodotti[0] = new ProdottoQuadrato(12, 20, "Pomodoro", "yes", this, 0);
		prodotti[1] = new ProdottoQuadrato(268, 20, "Mozzarella", "yes", this, 0);
		prodotti[2] = new ProdottoQuadrato(524, 20, "PastaRigatoni", "yes", this, 0);
		prodotti[3] = new ProdottoQuadrato(780, 20, "RisoBasmati", "yes", this, 0);
		prodotti[4] = new ProdottoQuadrato(1036, 20, "PaneIntegrale", "yes", this, 0);
		prodotti[5] = new ProdottoQuadrato(12, 276, "LatteParzialmenteScremato", "yes", this, 0);
		prodotti[6] = new ProdottoQuadrato(268, 276, "YogurtBianco", "yes", this, 0);
		prodotti[7] = new ProdottoQuadrato(524, 276, "Burro", "yes", this, 0);
		prodotti[8] = new ProdottoQuadrato(780, 276, "ParmigianoReggiano", "yes", this, 0);
		prodotti[9] = new ProdottoQuadrato(1036, 276, "ProsciuttoCotto", "yes", this, 0);
		prodotti[10] = new ProdottoQuadrato(12, 532, "ProsciuttoCrudo", "yes", this, 0);
		prodotti[11] = new ProdottoQuadrato(268, 532, "Bresaola", "yes", this, 0);
		prodotti[12] = new ProdottoQuadrato(524, 532, "SalameMilano", "yes", this, 0);
		prodotti[13] = new ProdottoQuadrato(780, 532, "PettoDiPollo", "yes", this, 0);
		prodotti[14] = new ProdottoQuadrato(1036, 532, "CarneTrita", "yes", this, 0);
		prodotti[15] = new ProdottoQuadrato(12, 788, "SalmoneAffumicato", "yes", this, 0);
		prodotti[16] = new ProdottoQuadrato(268, 788, "TonnoNaturale", "yes", this, 0);
		prodotti[17] = new ProdottoQuadrato(524, 788, "UovaFresche", "yes", this, 0);
		prodotti[18] = new ProdottoQuadrato(780, 788, "InsalataMista", "yes", this, 0);
		prodotti[19] = new ProdottoQuadrato(1036, 788, "Zucchine", "yes", this, 0);
		prodotti[20] = new ProdottoQuadrato(12, 1044, "Melanzane", "yes", this, 0);
		prodotti[21] = new ProdottoQuadrato(268, 1044, "Patate", "yes", this, 0);
		prodotti[22] = new ProdottoQuadrato(524, 1044, "Carote", "yes", this, 0);
		prodotti[23] = new ProdottoQuadrato(780, 1044, "CipolleDorate", "yes", this, 0);
		prodotti[24] = new ProdottoQuadrato(1036, 1044, "Aglio", "yes", this, 0);
		prodotti[25] = new ProdottoQuadrato(12, 1300, "Banane", "yes", this, 0);
		prodotti[26] = new ProdottoQuadrato(268, 1300, "MeleGolden", "yes", this, 0);
		prodotti[27] = new ProdottoQuadrato(524, 1300, "PereAbate", "yes", this, 0);
		prodotti[28] = new ProdottoQuadrato(780, 1300, "Arance", "yes", this, 0);
		prodotti[29] = new ProdottoQuadrato(1036, 1300, "Limoni", "yes", this, 0);
		prodotti[30] = new ProdottoQuadrato(12, 1556, "Fragole", "yes", this, 0);
		prodotti[31] = new ProdottoQuadrato(268, 1556, "Kiwi", "yes", this, 0);
		prodotti[32] = new ProdottoQuadrato(524, 1556, "UvaBianca", "yes", this, 0);
		prodotti[33] = new ProdottoQuadrato(780, 1556, "Pesche", "yes", this, 0);
		prodotti[34] = new ProdottoQuadrato(1036, 1556, "Albicocche", "yes", this, 0);
		prodotti[35] = new ProdottoQuadrato(12, 1812, "OlioExtravergine", "yes", this, 0);
		prodotti[36] = new ProdottoQuadrato(268, 1812, "AcetoDiVino", "yes", this, 0);
		prodotti[37] = new ProdottoQuadrato(524, 1812, "SaleFino", "yes", this, 0);
		prodotti[38] = new ProdottoQuadrato(780, 1812, "Zucchero", "yes", this, 0);
		prodotti[39] = new ProdottoQuadrato(1036, 1812, "Farina00", "yes", this, 0);
		prodotti[40] = new ProdottoQuadrato(12, 2068, "LievitoDiBirra", "yes", this, 0);
		prodotti[41] = new ProdottoQuadrato(268, 2068, "BiscottiIntegrali", "yes", this, 0);
		prodotti[42] = new ProdottoQuadrato(524, 2068, "FetteBiscottate", "yes", this, 0);
		prodotti[43] = new ProdottoQuadrato(780, 2068, "CornFlakes", "yes", this, 0);
		prodotti[44] = new ProdottoQuadrato(1036, 2068, "MarmellataDiFragole", "yes", this, 0);
		prodotti[45] = new ProdottoQuadrato(12, 2324, "Nutella", "yes", this, 0);
		prodotti[46] = new ProdottoQuadrato(268, 2324, "CioccolatoFondente", "yes", this, 0);
		prodotti[47] = new ProdottoQuadrato(524, 2324, "SuccoDiArancia", "yes", this, 0);
		prodotti[48] = new ProdottoQuadrato(780, 2324, "AcquaNaturale", "yes", this, 0);
		prodotti[49] = new ProdottoQuadrato(1036, 2324, "AcquaFrizzante", "yes", this, 0);
		prodotti[50] = new ProdottoQuadrato(12, 2580, "CocaCola", "yes", this, 0);
		prodotti[51] = new ProdottoQuadrato(268, 2580, "TheFreddo", "yes", this, 0);
		prodotti[52] = new ProdottoQuadrato(524, 2580, "CaffeMacinato", "yes", this, 0);
		prodotti[53] = new ProdottoQuadrato(780, 2580, "OrzoSolubile", "yes", this, 0);
		prodotti[54] = new ProdottoQuadrato(1036, 2580, "LegumiMisti", "yes", this, 0);
		prodotti[55] = new ProdottoQuadrato(12, 2836, "Lenticchie", "yes", this, 0);
		prodotti[56] = new ProdottoQuadrato(268, 2836, "FagioliBorlotti", "yes", this, 0);
		prodotti[57] = new ProdottoQuadrato(524, 2836, "Ceci", "yes", this, 0);
		prodotti[58] = new ProdottoQuadrato(780, 2836, "Piselli", "yes", this, 0);
		prodotti[59] = new ProdottoQuadrato(1036, 2836, "SpinaciSurgelati", "yes", this, 0);
		prodotti[60] = new ProdottoQuadrato(12, 3092, "PizzaMargherita", "yes", this, 0);
		prodotti[61] = new ProdottoQuadrato(268, 3092, "LasagneFresche", "yes", this, 0);
		prodotti[62] = new ProdottoQuadrato(524, 3092, "GnocchiDiPatate", "yes", this, 0);
		prodotti[63] = new ProdottoQuadrato(780, 3092, "RavioliRicottaESpinaci", "yes", this, 0);
		prodotti[64] = new ProdottoQuadrato(1036, 3092, "PiadinaRomagnola", "yes", this, 0);
		prodotti[65] = new ProdottoQuadrato(12, 3348, "HamburgerDiManzo", "yes", this, 0);
		prodotti[66] = new ProdottoQuadrato(268, 3348, "Salsiccia", "yes", this, 0);
		prodotti[67] = new ProdottoQuadrato(524, 3348, "FilettiDiMerluzzo", "yes", this, 0);
		prodotti[68] = new ProdottoQuadrato(780, 3348, "GelatoVaniglia", "yes", this, 0);
		prodotti[69] = new ProdottoQuadrato(1036, 3348, "Tiramisu", "yes", this, 0);
		for(int c = 0; c<70; c++) {
			panelScrollCatalogo.add(prodotti[c]);
		}
		//setto lo scrollpane con la grandezza da mostrare
		scrollCatalogo = new JScrollPane(panelScrollCatalogo, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCatalogo.setBounds(0, 100, 1279, 663);
		scrollCatalogo.setBackground(null);
		scrollCatalogo.setOpaque(false);
		scrollCatalogo.getViewport().setOpaque(false);
		scrollCatalogo.setBorder(null);
		scrollCatalogo.getVerticalScrollBar().setUnitIncrement(20);
		add(scrollCatalogo);
	}
	
	//metodo da usare per settare il cambio schermata
	public JButton getMagazzinoCat() {
		return magazzinoCat;
	}
	
	//metodo da usare per settare il cambio schermata
	public JButton getCarrelloCat() {
		return carrelloCat;
	}
	
	//metodo per ottenere l'array list prodottiNelCarrello
	public ArrayList<InformazioniDaPassare> getProdottiNelCarrello() {
		return prodottiNelCarrello;
	}
	
	//metodo per ottenere l'array list prodottiNelCarrello
	public ProdottoQuadrato[] getProdotti() {
		return prodotti;
	}

}
