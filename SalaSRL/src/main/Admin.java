package main;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.*;

public class Admin extends JPanel {

	//button per cambiare schermata
	private JButton catalogoMag = new JButton();
	private JButton carrelloMag = new JButton();
	private JButton MagazzinoCat = new JButton();
	private JButton carrelloCat = new JButton();
	private JButton MagazzinoCar = new JButton();
	private JButton catalogoCar = new JButton();
	//button per aprire info profilo
	private JButton immagineProfiloMag = new JButton();
	private JButton immagineProfiloCat = new JButton();
	private JButton immagineProfiloCar = new JButton();
	//label per evidenziare schermata attuale
	private JLabel magazzinoAttuale = new JLabel();
	private JLabel catalogoAttuale = new JLabel();
	private JLabel carrelloAttuale = new JLabel();
	//label per coprire
	private JLabel copriLineaMag = new JLabel();
	private JLabel copriLineaCat = new JLabel();
	private JLabel copriLineaCar = new JLabel();
	//label dove appaiono i prodotti in magazzino
	private JLabel luogoProdotti = new JLabel();
	//label che fa vedere lo spazio nel magazzino
	private JLabel spazioMagazzino = new JLabel();
	//label di contorno
	private JLabel strisciaSuperioreMag = new JLabel();
	private JLabel strisciaSuperioreCat = new JLabel();
	private JLabel strisciaSuperioreCar = new JLabel();
	//label dove appaiono i prodotti nel catalogo
	private JLabel baseCatalogo = new JLabel();
	//label dove verrà visualizzato il carrello
	private JLabel baseCarrello = new JLabel();
	//array che contiene le 3 schermate
	private JPanel[] schermate = new JPanel[3];
	//variabili usate per mettere le immagini
	private ImageIcon icon;
	private Image iconScaled;
	//array che contiene prodotti in catalogo
	private Prodotto[] prodotti = new Prodotto[150];
	//jscroll e panel per contenere i prodotti del catalogo
	private JPanel panelScrollCatalogo = new JPanel();
	private JScrollPane scrollCatalogo;

	//costruttore
	public Admin() {
		//setto il Panel	
		setLayout(null);
		setBounds(0, 0, 1331, 768);
		//creo le 3 schermate
		creaMagazzino();
		creaCatalogo();
		creaCarrello();
	}
	
	//metodo per creare la schermata del magazzino
	public void creaMagazzino() {
		//setto il Panel
		schermate[0] = new JPanel();
		schermate[0].setLayout(null);
		schermate[0].setBounds(0, 0, 1331, 768);
		//setto i vari componenti
		setImmagineProfiloMag();
		setCopriLineaMagazzino();
		setLuogoProdotti();
		setSpazioMagazzino();
		setCatalogoMag();
		setCarrelloMag();
		setMagazzinoAttuale();
		setStrisciaSuperioreMag();
		add(schermate[0]);
	}
	
	//metodo per creare la schermata del catalogo
	public void creaCatalogo() {
		//setto il Panel
		schermate[1] = new JPanel();
		schermate[1].setLayout(null);
		schermate[1].setBounds(0, 0, 1331, 768);
		//aggingo i prodotti
		generaProdotti();
		//setto i vari componenti
		setImmagineProfiloCat();
		setCopriLineaCatalogo();
		setBaseCatalogo();
		setMagazzinoCat();
		setCarrelloCat();
		setCatalogoAttuale();
		setStrisciaSuperioreCat();
		add(schermate[1]);
		schermate[1].setVisible(false);
	}
	
	//metodo per creare la schermata del carrello
	public void creaCarrello() {
		//setto il Panel
		schermate[2] = new JPanel();
		schermate[2].setLayout(null);
		schermate[2].setBounds(0, 0, 1331, 768);
		//setto i vari componenti
		setImmagineProfiloCar();
		setCopriLineaCarrello();
		setBaseCarrello();
		setMagazzinoCar();
		setCatalogoCar();
		setCarrelloAttuale();
		setStrisciaSuperioreCar();
		add(schermate[2]);
		schermate[2].setVisible(false);
		
	}
	
	//metodo per settare il button catalogoMag
	public void setCatalogoMag() {
		//imposto le caratteristiche del bottone
		catalogoMag.setContentAreaFilled(false);		
		catalogoMag.setBorderPainted(false);
		catalogoMag.setBounds(439, 60, 438, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCatalogoPress.png"));
		iconScaled = icon.getImage().getScaledInstance(438, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		catalogoMag.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCatalogo.png"));
		iconScaled = icon.getImage().getScaledInstance(438, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		catalogoMag.setIcon(icon);
		//aggiungo un actionlistener per cambiare schermata in catalogo
		catalogoMag.addActionListener(e -> changeInCatalogo());
		schermate[0].add(catalogoMag);
	}

	//metodo per settare il button carrelloMag
	public void setCarrelloMag() {
		//imposto le caratteristiche del bottone
		carrelloMag.setContentAreaFilled(false);		
		carrelloMag.setBorderPainted(false);
		carrelloMag.setBounds(877, 60, 438, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCarrelloPress.png"));
		iconScaled = icon.getImage().getScaledInstance(438, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		carrelloMag.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCarrello.png"));
		iconScaled = icon.getImage().getScaledInstance(438, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		carrelloMag.setIcon(icon);
		//aggiungo un actionlistener per cambiare schermata in carrello
		carrelloMag.addActionListener(e -> changeInCarrello());
		schermate[0].add(carrelloMag);
	}

	//metodo per settare il button MagazzinoCat
	public void setMagazzinoCat() {
		//imposto le caratteristiche del bottone
		MagazzinoCat.setContentAreaFilled(false);		
		MagazzinoCat.setBorderPainted(false);
		MagazzinoCat.setBounds(0, 60, 439, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzinoPress.png"));
		iconScaled = icon.getImage().getScaledInstance(439, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		MagazzinoCat.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzino.png"));
		iconScaled = icon.getImage().getScaledInstance(439, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		MagazzinoCat.setIcon(icon);
		//aggiungo un actionlistener per cambiare schermata in magazzino
		MagazzinoCat.addActionListener(e -> changeInMagazzino());
		schermate[1].add(MagazzinoCat);
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
		//aggiungo un actionlistener per cambiare schermata in carrello
		carrelloCat.addActionListener(e -> changeInCarrello());
		schermate[1].add(carrelloCat);
	}

	//metodo per settare il button MagazzinoCar
	public void setMagazzinoCar() {
		//imposto le caratteristiche del bottone
		MagazzinoCar.setContentAreaFilled(false);		
		MagazzinoCar.setBorderPainted(false);
		MagazzinoCar.setBounds(0, 60, 439, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzinoPress.png"));
		iconScaled = icon.getImage().getScaledInstance(439, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		MagazzinoCar.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzino.png"));
		iconScaled = icon.getImage().getScaledInstance(439, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		MagazzinoCar.setIcon(icon);
		//aggiungo un actionlistener per cambiare schermata in magazzino
		MagazzinoCar.addActionListener(e -> changeInMagazzino());
		schermate[2].add(MagazzinoCar);
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
		//aggiungo un actionlistener per cambiare schermata in catalogo
		catalogoCar.addActionListener(e -> changeInCatalogo());
		schermate[2].add(catalogoCar);
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
		//carrello.addActionListener(e -> piuUno(nomeProdotto));
		schermate[0].add(immagineProfiloMag);
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
		schermate[1].add(immagineProfiloCat);
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
		//carrello.addActionListener(e -> piuUno(nomeProdotto));
		schermate[2].add(immagineProfiloCar);
	}

	//metodo per settare la label magazzinoAttuale
	public void setMagazzinoAttuale() {
		//imposto coordinate e grandezza della label
		magazzinoAttuale.setBounds(0, 60, 439, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzinoAttuale.png"));
		iconScaled = icon.getImage().getScaledInstance(439, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		magazzinoAttuale.setIcon(icon);
		schermate[0].add(magazzinoAttuale);
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
		schermate[1].add(catalogoAttuale);
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
		schermate[2].add(carrelloAttuale);
	}

	//metodo per settare la label strisciaSuperioreMag
	public void setStrisciaSuperioreMag() {
		//imposto coordinate e grandezza della label
		strisciaSuperioreMag.setBounds(0, 0, 1331, 107);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("StrisciaSuperiore.png"));
		strisciaSuperioreMag.setIcon(icon);
		schermate[0].add(strisciaSuperioreMag);
	}

	//metodo per settare la label strisciaSuperioreCat
	public void setStrisciaSuperioreCat() {
		//imposto coordinate e grandezza della label
		strisciaSuperioreCat.setBounds(0, 0, 1331, 107);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("StrisciaSuperiore.png"));
		strisciaSuperioreCat.setIcon(icon);
		schermate[1].add(strisciaSuperioreCat);
	}

	//metodo per settare la label strisciaSuperioreCar
	public void setStrisciaSuperioreCar() {
		//imposto coordinate e grandezza della label
		strisciaSuperioreCar.setBounds(0, 0, 1331, 107);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("StrisciaSuperiore.png"));
		strisciaSuperioreCar.setIcon(icon);
		schermate[2].add(strisciaSuperioreCar);
	}

	//metodo per settare la label copriLineaMag
	public void setCopriLineaMagazzino() {
		//imposto coordinate e grandezza della label
		copriLineaMag.setBounds(2, 95, 435, 5);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("CopriLineaMagazzino.png"));
		iconScaled = icon.getImage().getScaledInstance(435, 5, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		copriLineaMag.setIcon(icon);
		schermate[0].add(copriLineaMag);
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
		schermate[1].add(copriLineaCat);
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
		schermate[2].add(copriLineaCar);
	}

	//metodo per settare la label luogoProdotti
	public void setLuogoProdotti() {
		//imposto coordinate e grandezza della label
		luogoProdotti.setBounds(0, 152, 1315, 619);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("LuogoProdotti.png"));
		luogoProdotti.setIcon(icon);
		schermate[0].add(luogoProdotti);
	}

	//metodo per settare la label spazioMagazzino
	public void setSpazioMagazzino() {
		//imposto coordinate e grandezza della label
		spazioMagazzino.setBounds(0, 96, 1315, 58);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SpazioMagazzino.png"));
		spazioMagazzino.setIcon(icon);
		schermate[0].add(spazioMagazzino);
	}

	//metodo per settare la label baseCatalogo
	public void setBaseCatalogo() {
		//imposto coordinate e grandezza della label
		baseCatalogo.setBounds(0, 96, 1315, 675);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoCatalogoCarrello.png"));
		baseCatalogo.setIcon(icon);
		schermate[1].add(baseCatalogo);
	}

	//metodo per settare la label baseCarrello
	public void setBaseCarrello() {
		//imposto coordinate e grandezza della label
		baseCarrello.setBounds(0, 96, 1315, 675);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoCatalogoCarrello.png"));
		baseCarrello.setIcon(icon);
		schermate[2].add(baseCarrello);
	}
	
	//metodo per mostrare la schermata magazzino
	public void changeInMagazzino() {
		schermate[0].setVisible(true);
		schermate[1].setVisible(false);
		schermate[2].setVisible(false);
	}

	//metodo per mostrare la schermata catalogo
	public void changeInCatalogo() {
		schermate[0].setVisible(false);
		schermate[1].setVisible(true);
		schermate[2].setVisible(false);
	}

	//metodo per mostrare la schermata carrello
	public void changeInCarrello() {
		schermate[0].setVisible(false);
		schermate[1].setVisible(false);
		schermate[2].setVisible(true);
	}
	
	//metodo per generare i 150 prodotti nel catalogo
	public void generaProdotti() {
		//setto il panel
		panelScrollCatalogo.setPreferredSize(new Dimension(1315, 8210));
		panelScrollCatalogo.setBackground(null);
		panelScrollCatalogo.setLayout(null);
		panelScrollCatalogo.setOpaque(false);
		//creo 150 diversi prodotti
		prodotti[0] = new Prodotto(10, 20, "Pomodoro");
		prodotti[1] = new Prodotto(273, 20, "Pomodoro");
		prodotti[2] = new Prodotto(536, 20, "Pomodoro");
		prodotti[3] = new Prodotto(799, 20, "Pomodoro");
		prodotti[4] = new Prodotto(1062, 20, "Pomodoro");
		prodotti[5] = new Prodotto(10, 293, "Pomodoro");
		prodotti[6] = new Prodotto(273, 293, "Pomodoro");
		prodotti[7] = new Prodotto(536, 293, "Pomodoro");
		prodotti[8] = new Prodotto(799, 293, "Pomodoro");
		prodotti[9] = new Prodotto(1062, 293, "Pomodoro");
		prodotti[10] = new Prodotto(10, 566, "Pomodoro");
		prodotti[11] = new Prodotto(273, 566, "Pomodoro");
		prodotti[12] = new Prodotto(536, 566, "Pomodoro");
		prodotti[13] = new Prodotto(799, 566, "Pomodoro");
		prodotti[14] = new Prodotto(1062, 566, "Pomodoro");
		prodotti[15] = new Prodotto(10, 839, "Pomodoro");
		prodotti[16] = new Prodotto(273, 839, "Pomodoro");
		prodotti[17] = new Prodotto(536, 839, "Pomodoro");
		prodotti[18] = new Prodotto(799, 839, "Pomodoro");
		prodotti[19] = new Prodotto(1062, 839, "Pomodoro");
		prodotti[20] = new Prodotto(10, 1112, "Pomodoro");
		prodotti[21] = new Prodotto(273, 1112, "Pomodoro");
		prodotti[22] = new Prodotto(536, 1112, "Pomodoro");
		prodotti[23] = new Prodotto(799, 1112, "Pomodoro");
		prodotti[24] = new Prodotto(1062, 1112, "Pomodoro");
		prodotti[25] = new Prodotto(10, 1385, "Pomodoro");
		prodotti[26] = new Prodotto(273, 1385, "Pomodoro");
		prodotti[27] = new Prodotto(536, 1385, "Pomodoro");
		prodotti[28] = new Prodotto(799, 1385, "Pomodoro");
		prodotti[29] = new Prodotto(1062, 1385, "Pomodoro");
		prodotti[30] = new Prodotto(10, 1658, "Pomodoro");
		prodotti[31] = new Prodotto(273, 1658, "Pomodoro");
		prodotti[32] = new Prodotto(536, 1658, "Pomodoro");
		prodotti[33] = new Prodotto(799, 1658, "Pomodoro");
		prodotti[34] = new Prodotto(1062, 1658, "Pomodoro");
		prodotti[35] = new Prodotto(10, 1931, "Pomodoro");
		prodotti[36] = new Prodotto(273, 1931, "Pomodoro");
		prodotti[37] = new Prodotto(536, 1931, "Pomodoro");
		prodotti[38] = new Prodotto(799, 1931, "Pomodoro");
		prodotti[39] = new Prodotto(1062, 1931, "Pomodoro");
		prodotti[40] = new Prodotto(10, 2204, "Pomodoro");
		prodotti[41] = new Prodotto(273, 2204, "Pomodoro");
		prodotti[42] = new Prodotto(536, 2204, "Pomodoro");
		prodotti[43] = new Prodotto(799, 2204, "Pomodoro");
		prodotti[44] = new Prodotto(1062, 2204, "Pomodoro");
		prodotti[45] = new Prodotto(10, 2477, "Pomodoro");
		prodotti[46] = new Prodotto(273, 2477, "Pomodoro");
		prodotti[47] = new Prodotto(536, 2477, "Pomodoro");
		prodotti[48] = new Prodotto(799, 2477, "Pomodoro");
		prodotti[49] = new Prodotto(1062, 2477, "Pomodoro");
		prodotti[50] = new Prodotto(10, 2750, "Pomodoro");
		prodotti[51] = new Prodotto(273, 2750, "Pomodoro");
		prodotti[52] = new Prodotto(536, 2750, "Pomodoro");
		prodotti[53] = new Prodotto(799, 2750, "Pomodoro");
		prodotti[54] = new Prodotto(1062, 2750, "Pomodoro");
		prodotti[55] = new Prodotto(10, 3023, "Pomodoro");
		prodotti[56] = new Prodotto(273, 3023, "Pomodoro");
		prodotti[57] = new Prodotto(536, 3023, "Pomodoro");
		prodotti[58] = new Prodotto(799, 3023, "Pomodoro");
		prodotti[59] = new Prodotto(1062, 3023, "Pomodoro");
		prodotti[60] = new Prodotto(10, 3296, "Pomodoro");
		prodotti[61] = new Prodotto(273, 3296, "Pomodoro");
		prodotti[62] = new Prodotto(536, 3296, "Pomodoro");
		prodotti[63] = new Prodotto(799, 3296, "Pomodoro");
		prodotti[64] = new Prodotto(1062, 3296, "Pomodoro");
		prodotti[65] = new Prodotto(10, 3569, "Pomodoro");
		prodotti[66] = new Prodotto(273, 3569, "Pomodoro");
		prodotti[67] = new Prodotto(536, 3569, "Pomodoro");
		prodotti[68] = new Prodotto(799, 3569, "Pomodoro");
		prodotti[69] = new Prodotto(1062, 3569, "Pomodoro");
		prodotti[70] = new Prodotto(10, 3842, "Pomodoro");
		prodotti[71] = new Prodotto(273, 3842, "Pomodoro");
		prodotti[72] = new Prodotto(536, 3842, "Pomodoro");
		prodotti[73] = new Prodotto(799, 3842, "Pomodoro");
		prodotti[74] = new Prodotto(1062, 3842, "Pomodoro");
		prodotti[75] = new Prodotto(10, 4115, "Pomodoro");
		prodotti[76] = new Prodotto(273, 4115, "Pomodoro");
		prodotti[77] = new Prodotto(536, 4115, "Pomodoro");
		prodotti[78] = new Prodotto(799, 4115, "Pomodoro");
		prodotti[79] = new Prodotto(1062, 4115, "Pomodoro");
		prodotti[80] = new Prodotto(10, 4388, "Pomodoro");
		prodotti[81] = new Prodotto(273, 4388, "Pomodoro");
		prodotti[82] = new Prodotto(536, 4388, "Pomodoro");
		prodotti[83] = new Prodotto(799, 4388, "Pomodoro");
		prodotti[84] = new Prodotto(1062, 4388, "Pomodoro");
		prodotti[85] = new Prodotto(10, 4661, "Pomodoro");
		prodotti[86] = new Prodotto(273, 4661, "Pomodoro");
		prodotti[87] = new Prodotto(536, 4661, "Pomodoro");
		prodotti[88] = new Prodotto(799, 4661, "Pomodoro");
		prodotti[89] = new Prodotto(1062, 4661, "Pomodoro");
		prodotti[90] = new Prodotto(10, 4934, "Pomodoro");
		prodotti[91] = new Prodotto(273, 4934, "Pomodoro");
		prodotti[92] = new Prodotto(536, 4934, "Pomodoro");
		prodotti[93] = new Prodotto(799, 4934, "Pomodoro");
		prodotti[94] = new Prodotto(1062, 4934, "Pomodoro");
		prodotti[95] = new Prodotto(10, 5207, "Pomodoro");
		prodotti[96] = new Prodotto(273, 5207, "Pomodoro");
		prodotti[97] = new Prodotto(536, 5207, "Pomodoro");
		prodotti[98] = new Prodotto(799, 5207, "Pomodoro");
		prodotti[99] = new Prodotto(1062, 5207, "Pomodoro");
		prodotti[100] = new Prodotto(10, 5480, "Pomodoro");
		prodotti[101] = new Prodotto(273, 5480, "Pomodoro");
		prodotti[102] = new Prodotto(536, 5480, "Pomodoro");
		prodotti[103] = new Prodotto(799, 5480, "Pomodoro");
		prodotti[104] = new Prodotto(1062, 5480, "Pomodoro");
		prodotti[105] = new Prodotto(10, 5753, "Pomodoro");
		prodotti[106] = new Prodotto(273, 5753, "Pomodoro");
		prodotti[107] = new Prodotto(536, 5753, "Pomodoro");
		prodotti[108] = new Prodotto(799, 5753, "Pomodoro");
		prodotti[109] = new Prodotto(1062, 5753, "Pomodoro");
		prodotti[110] = new Prodotto(10, 6026, "Pomodoro");
		prodotti[111] = new Prodotto(273, 6026, "Pomodoro");
		prodotti[112] = new Prodotto(536, 6026, "Pomodoro");
		prodotti[113] = new Prodotto(799, 6026, "Pomodoro");
		prodotti[114] = new Prodotto(1062, 6026, "Pomodoro");
		prodotti[115] = new Prodotto(10, 6299, "Pomodoro");
		prodotti[116] = new Prodotto(273, 6299, "Pomodoro");
		prodotti[117] = new Prodotto(536, 6299, "Pomodoro");
		prodotti[118] = new Prodotto(799, 6299, "Pomodoro");
		prodotti[119] = new Prodotto(1062, 6299, "Pomodoro");
		prodotti[120] = new Prodotto(10, 6572, "Pomodoro");
		prodotti[121] = new Prodotto(273, 6572, "Pomodoro");
		prodotti[122] = new Prodotto(536, 6572, "Pomodoro");
		prodotti[123] = new Prodotto(799, 6572, "Pomodoro");
		prodotti[124] = new Prodotto(1062, 6572, "Pomodoro");
		prodotti[125] = new Prodotto(10, 6845, "Pomodoro");
		prodotti[126] = new Prodotto(273, 6845, "Pomodoro");
		prodotti[127] = new Prodotto(536, 6845, "Pomodoro");
		prodotti[128] = new Prodotto(799, 6845, "Pomodoro");
		prodotti[129] = new Prodotto(1062, 6845, "Pomodoro");
		prodotti[130] = new Prodotto(10, 7118, "Pomodoro");
		prodotti[131] = new Prodotto(273, 7118, "Pomodoro");
		prodotti[132] = new Prodotto(536, 7118, "Pomodoro");
		prodotti[133] = new Prodotto(799, 7118, "Pomodoro");
		prodotti[134] = new Prodotto(1062, 7118, "Pomodoro");
		prodotti[135] = new Prodotto(10, 7391, "Pomodoro");
		prodotti[136] = new Prodotto(273, 7391, "Pomodoro");
		prodotti[137] = new Prodotto(536, 7391, "Pomodoro");
		prodotti[138] = new Prodotto(799, 7391, "Pomodoro");
		prodotti[139] = new Prodotto(1062, 7391, "Pomodoro");
		prodotti[140] = new Prodotto(10, 7664, "Pomodoro");
		prodotti[141] = new Prodotto(273, 7664, "Pomodoro");
		prodotti[142] = new Prodotto(536, 7664, "Pomodoro");
		prodotti[143] = new Prodotto(799, 7664, "Pomodoro");
		prodotti[144] = new Prodotto(1062, 7664, "Pomodoro");
		prodotti[145] = new Prodotto(10, 7937, "Pomodoro");
		prodotti[146] = new Prodotto(273, 7937, "Pomodoro");
		prodotti[147] = new Prodotto(536, 7937, "Pomodoro");
		prodotti[148] = new Prodotto(799, 7937, "Pomodoro");
		prodotti[149] = new Prodotto(1062, 7937, "Pomodoro");
		for(int c = 0; c<150; c++) {
			panelScrollCatalogo.add(prodotti[c]);
		}
		//settp lo scrollpane
		scrollCatalogo = new JScrollPane(panelScrollCatalogo, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCatalogo.setBounds(0, 100, 1315, 631);
		scrollCatalogo.setBackground(null);
		scrollCatalogo.setOpaque(false);
		scrollCatalogo.getViewport().setOpaque(false);
		scrollCatalogo.setBorder(null);
		scrollCatalogo.getVerticalScrollBar().setUnitIncrement(10);
		schermate[1].add(scrollCatalogo);
	}
	
}
