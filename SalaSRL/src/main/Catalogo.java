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
	private ArrayList<String> prodottiNelCarrello = new ArrayList<>();
	//jscroll e panel per contenere i prodotti del catalogo
	private JPanel panelScrollCatalogo = new JPanel();
	private JScrollPane scrollCatalogo;
	//JPanel usata per scorrere i prodotti nel catalogo
	private LineaScorrimento scorriCatalogo;
	//variabili usate per settare scrollCatalogo e scorriCatalogo
	private int valore;
	private int cellaScorrimento;
	
	//costruttore per creare la schermata del catalogo
	public Catalogo() {
		//setto il Panel
		setLayout(null);
		setBounds(0, 0, 1331, 768);
		//aggingo i prodotti e la scrollbar personalizzata
		generaProdotti();
		setScorriCatalogo();
		//setto i vari componenti
		setImmagineProfiloCat();
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
		//carrello.addActionListener(e -> piuUno(nomeProdotto));
		add(immagineProfiloCat);
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

	//metodo per settare il panel scorriCatalogo
	public void setScorriCatalogo() {
		//setto la posizione di scorriCatalogo, il JScrollPane associato e il tipo di LineaScorrimento che deve essere
		scorriCatalogo = new LineaScorrimento(1284, 102, scrollCatalogo, "AdminCatalogo");
		//aggiungo un changelistener per spostare il bottone di scorrimento laterale se non si usa quello ma la rotellina del mouse
		scrollCatalogo.getViewport().addChangeListener(e -> {
			valore = (int) scrollCatalogo.getVerticalScrollBar().getValue();
			//se il valore è 0 imposta lo scorriCatalogo automaticamente in cima
			if(valore == 0) {
				//if per non far scattare lo scorriCatalogo
				if(!scorriCatalogo.getStoScorrendo()) {
					scorriCatalogo.setYTastoScorrimento(3, "no");
				}
			//se il valore è uguale alla y massima che può raggiungere il pane dentro lo scroll imposta lo scorriCatalogo automaticamente in fondo
			} else if(valore == 7037) {
				//if per non far scattare lo scorriCatalogo
				if(!scorriCatalogo.getStoScorrendo()) {
					scorriCatalogo.setYTastoScorrimento(618, "no");
				}
			//se il valore non è 0 o 7037 calcola la cella in cui spostare lo scorriCatalogo
			} else {
				cellaScorrimento = valore / 70 - 1;
				//if per non far scattare lo scorriCatalogo
				if(!scorriCatalogo.getStoScorrendo()) {
					scorriCatalogo.setYTastoScorrimento(cellaScorrimento, "yes");
				}
			}
		});
		add(scorriCatalogo);
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
	
	//metodo per generare i 70 prodotti nel catalogo
	public void generaProdotti() {
		//setto il panel con la grandezza totale che deve avere
		panelScrollCatalogo.setPreferredSize(new Dimension(1315, 7700));
		panelScrollCatalogo.setBackground(null);
		panelScrollCatalogo.setLayout(null);
		panelScrollCatalogo.setOpaque(false);
		//creo 70 diversi prodotti
		prodotti[0] = new ProdottoQuadrato(12, 20, "Pomodoro", "yes");
		prodotti[1] = new ProdottoQuadrato(268, 20, "Mozzarella", "yes");
		prodotti[2] = new ProdottoQuadrato(524, 20, "PastaRigatoni", "yes");
		prodotti[3] = new ProdottoQuadrato(780, 20, "RisoBasmati", "yes");
		prodotti[4] = new ProdottoQuadrato(1036, 20, "PaneIntegrale", "yes");
		prodotti[5] = new ProdottoQuadrato(12, 276, "LatteParzialmenteScremato", "yes");
		prodotti[6] = new ProdottoQuadrato(268, 276, "YogurtBianco", "yes");
		prodotti[7] = new ProdottoQuadrato(524, 276, "Burro", "yes");
		prodotti[8] = new ProdottoQuadrato(780, 276, "ParmigianoReggiano", "yes");
		prodotti[9] = new ProdottoQuadrato(1036, 276, "ProsciuttoCotto", "yes");
		prodotti[10] = new ProdottoQuadrato(12, 532, "ProsciuttoCrudo", "yes");
		prodotti[11] = new ProdottoQuadrato(268, 532, "Bresaola", "yes");
		prodotti[12] = new ProdottoQuadrato(524, 532, "SalameMilano", "yes");
		prodotti[13] = new ProdottoQuadrato(780, 532, "PettoDiPollo", "yes");
		prodotti[14] = new ProdottoQuadrato(1036, 532, "CarneTrita", "yes");
		prodotti[15] = new ProdottoQuadrato(12, 788, "SalmoneAffumicato", "yes");
		prodotti[16] = new ProdottoQuadrato(268, 788, "TonnoNaturale", "yes");
		prodotti[17] = new ProdottoQuadrato(524, 788, "UovaFresche", "yes");
		prodotti[18] = new ProdottoQuadrato(780, 788, "InsalataMista", "yes");
		prodotti[19] = new ProdottoQuadrato(1036, 788, "Zucchine", "yes");
		prodotti[20] = new ProdottoQuadrato(12, 1044, "Melanzane", "yes");
		prodotti[21] = new ProdottoQuadrato(268, 1044, "Patate", "yes");
		prodotti[22] = new ProdottoQuadrato(524, 1044, "Carote", "yes");
		prodotti[23] = new ProdottoQuadrato(780, 1044, "CipolleDorate", "yes");
		prodotti[24] = new ProdottoQuadrato(1036, 1044, "Aglio", "yes");
		prodotti[25] = new ProdottoQuadrato(12, 1300, "Banane", "yes");
		prodotti[26] = new ProdottoQuadrato(268, 1300, "MeleGolden", "yes");
		prodotti[27] = new ProdottoQuadrato(524, 1300, "PereAbate", "yes");
		prodotti[28] = new ProdottoQuadrato(780, 1300, "Arance", "yes");
		prodotti[29] = new ProdottoQuadrato(1036, 1300, "Limoni", "yes");
		prodotti[30] = new ProdottoQuadrato(12, 1556, "Fragole", "yes");
		prodotti[31] = new ProdottoQuadrato(268, 1556, "Kiwi", "yes");
		prodotti[32] = new ProdottoQuadrato(524, 1556, "UvaBianca", "yes");
		prodotti[33] = new ProdottoQuadrato(780, 1556, "Pesche", "yes");
		prodotti[34] = new ProdottoQuadrato(1036, 1556, "Albicocche", "yes");
		prodotti[35] = new ProdottoQuadrato(12, 1812, "OlioExtravergine", "yes");
		prodotti[36] = new ProdottoQuadrato(268, 1812, "AcetoDiVino", "yes");
		prodotti[37] = new ProdottoQuadrato(524, 1812, "SaleFino", "yes");
		prodotti[38] = new ProdottoQuadrato(780, 1812, "Zucchero", "yes");
		prodotti[39] = new ProdottoQuadrato(1036, 1812, "Farina00", "yes");
		prodotti[40] = new ProdottoQuadrato(12, 2068, "LievitoDiBirra", "yes");
		prodotti[41] = new ProdottoQuadrato(268, 2068, "BiscottiIntegrali", "yes");
		prodotti[42] = new ProdottoQuadrato(524, 2068, "FetteBiscottate", "yes");
		prodotti[43] = new ProdottoQuadrato(780, 2068, "CornFlakes", "yes");
		prodotti[44] = new ProdottoQuadrato(1036, 2068, "MarmellataDiFragole", "yes");
		prodotti[45] = new ProdottoQuadrato(12, 2324, "Nutella", "yes");
		prodotti[46] = new ProdottoQuadrato(268, 2324, "CioccolatoFondente", "yes");
		prodotti[47] = new ProdottoQuadrato(524, 2324, "SuccoDiArancia", "yes");
		prodotti[48] = new ProdottoQuadrato(780, 2324, "AcquaNaturale", "yes");
		prodotti[49] = new ProdottoQuadrato(1036, 2324, "AcquaFrizzante", "yes");
		prodotti[50] = new ProdottoQuadrato(12, 2580, "CocaCola", "yes");
		prodotti[51] = new ProdottoQuadrato(268, 2580, "TheFreddo", "yes");
		prodotti[52] = new ProdottoQuadrato(524, 2580, "CaffeMacinato", "yes");
		prodotti[53] = new ProdottoQuadrato(780, 2580, "OrzoSolubile", "yes");
		prodotti[54] = new ProdottoQuadrato(1036, 2580, "LegumiMisti", "yes");
		prodotti[55] = new ProdottoQuadrato(12, 2836, "Lenticchie", "yes");
		prodotti[56] = new ProdottoQuadrato(268, 2836, "FagioliBorlotti", "yes");
		prodotti[57] = new ProdottoQuadrato(524, 2836, "Ceci", "yes");
		prodotti[58] = new ProdottoQuadrato(780, 2836, "Piselli", "yes");
		prodotti[59] = new ProdottoQuadrato(1036, 2836, "SpinaciSurgelati", "yes");
		prodotti[60] = new ProdottoQuadrato(12, 3092, "PizzaMargherita", "yes");
		prodotti[61] = new ProdottoQuadrato(268, 3092, "LasagneFresche", "yes");
		prodotti[62] = new ProdottoQuadrato(524, 3092, "GnocchiDiPatate", "yes");
		prodotti[63] = new ProdottoQuadrato(780, 3092, "RavioliRicottaESpinaci", "yes");
		prodotti[64] = new ProdottoQuadrato(1036, 3092, "PiadinaRomagnola", "yes");
		prodotti[65] = new ProdottoQuadrato(12, 3348, "HamburgerDiManzo", "yes");
		prodotti[66] = new ProdottoQuadrato(268, 3348, "Salsiccia", "yes");
		prodotti[67] = new ProdottoQuadrato(524, 3348, "FilettiDiMerluzzo", "yes");
		prodotti[68] = new ProdottoQuadrato(780, 3348, "GelatoVaniglia", "yes");
		prodotti[69] = new ProdottoQuadrato(1036, 3348, "Tiramisu", "yes");
		for(int c = 0; c<70; c++) {
			panelScrollCatalogo.add(prodotti[c]);
			setPassToCarello(prodotti[c]);
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
	
	//metodo per settare il passaggio dei prodotti acquistati al carrello
	public void setPassToCarello(ProdottoQuadrato prodotto) {
		prodotto.getBuyButton().addActionListener(e -> {
			boolean giaPresente = false;
			if(prodotto.getNAttuale()>0) {
				if(prodottiNelCarrello.contains(prodotto.getNomeProdotto())) {
					giaPresente = true;
				}
				if(!giaPresente) {
					prodottiNelCarrello.add(prodotto.getNomeProdotto());
				}
			}
		});
	}

}
