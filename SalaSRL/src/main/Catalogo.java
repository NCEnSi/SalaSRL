package main;

import java.awt.*;
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
	private ProdottoQuadrato[] prodotti = new ProdottoQuadrato[150];
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
		scorriCatalogo = new LineaScorrimento(1284, 102, scrollCatalogo);
		//aggiungo un changelistener per spostare il bottone di scorrimento laterale se non si usa quello ma la rotellina del mouse
		scrollCatalogo.getViewport().addChangeListener(e -> {
			valore = (int) scrollCatalogo.getVerticalScrollBar().getValue();
			//se il valore è 0 importa lo scorriCatalogo automaticamente in cima
			if(valore == 0) {
				//if per non far scattare lo scorriCatalogo
				if(!scorriCatalogo.getStoScorrendo()) {
					scorriCatalogo.setYTastoScorrimento(3, "no");
				}
			//se il valore è 0 importa lo scorriCatalogo automaticamente in fondo
			} else if(valore > 7030) {
				scrollCatalogo.getVerticalScrollBar().setValue(7030);
				//if per non far scattare lo scorriCatalogo
				if(!scorriCatalogo.getStoScorrendo()) {
					scorriCatalogo.setYTastoScorrimento(618, "no");
				}
			//se il valore non è 0 o 7030 calcola la cella in cui spostare lo scorriCatalogo
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
	
	//metodo per generare i 150 prodotti nel catalogo
	public void generaProdotti() {
		//setto il panel
		panelScrollCatalogo.setPreferredSize(new Dimension(1315, 8210));
		panelScrollCatalogo.setBackground(null);
		panelScrollCatalogo.setLayout(null);
		panelScrollCatalogo.setOpaque(false);
		//creo 150 diversi prodotti
		prodotti[0] = new ProdottoQuadrato(12, 20, "Pomodoro");
		prodotti[1] = new ProdottoQuadrato(268, 20, "Pomodoro");
		prodotti[2] = new ProdottoQuadrato(524, 20, "Pomodoro");
		prodotti[3] = new ProdottoQuadrato(780, 20, "Pomodoro");
		prodotti[4] = new ProdottoQuadrato(1036, 20, "Pomodoro");
		prodotti[5] = new ProdottoQuadrato(12, 276, "Pomodoro");
		prodotti[6] = new ProdottoQuadrato(268, 276, "Pomodoro");
		prodotti[7] = new ProdottoQuadrato(524, 276, "Pomodoro");
		prodotti[8] = new ProdottoQuadrato(780, 276, "Pomodoro");
		prodotti[9] = new ProdottoQuadrato(1036, 276, "Pomodoro");
		prodotti[10] = new ProdottoQuadrato(12, 532, "Pomodoro");
		prodotti[11] = new ProdottoQuadrato(268, 532, "Pomodoro");
		prodotti[12] = new ProdottoQuadrato(524, 532, "Pomodoro");
		prodotti[13] = new ProdottoQuadrato(780, 532, "Pomodoro");
		prodotti[14] = new ProdottoQuadrato(1036, 532, "Pomodoro");
		prodotti[15] = new ProdottoQuadrato(12, 788, "Pomodoro");
		prodotti[16] = new ProdottoQuadrato(268, 788, "Pomodoro");
		prodotti[17] = new ProdottoQuadrato(524, 788, "Pomodoro");
		prodotti[18] = new ProdottoQuadrato(780, 788, "Pomodoro");
		prodotti[19] = new ProdottoQuadrato(1036, 788, "Pomodoro");
		prodotti[20] = new ProdottoQuadrato(12, 1044, "Pomodoro");
		prodotti[21] = new ProdottoQuadrato(268, 1044, "Pomodoro");
		prodotti[22] = new ProdottoQuadrato(524, 1044, "Pomodoro");
		prodotti[23] = new ProdottoQuadrato(780, 1044, "Pomodoro");
		prodotti[24] = new ProdottoQuadrato(1036, 1044, "Pomodoro");
		prodotti[25] = new ProdottoQuadrato(12, 1300, "Pomodoro");
		prodotti[26] = new ProdottoQuadrato(268, 1300, "Pomodoro");
		prodotti[27] = new ProdottoQuadrato(524, 1300, "Pomodoro");
		prodotti[28] = new ProdottoQuadrato(780, 1300, "Pomodoro");
		prodotti[29] = new ProdottoQuadrato(1036, 1300, "Pomodoro");
		prodotti[30] = new ProdottoQuadrato(12, 1556, "Pomodoro");
		prodotti[31] = new ProdottoQuadrato(268, 1556, "Pomodoro");
		prodotti[32] = new ProdottoQuadrato(524, 1556, "Pomodoro");
		prodotti[33] = new ProdottoQuadrato(780, 1556, "Pomodoro");
		prodotti[34] = new ProdottoQuadrato(1036, 1556, "Pomodoro");
		prodotti[35] = new ProdottoQuadrato(12, 1812, "Pomodoro");
		prodotti[36] = new ProdottoQuadrato(268, 1812, "Pomodoro");
		prodotti[37] = new ProdottoQuadrato(524, 1812, "Pomodoro");
		prodotti[38] = new ProdottoQuadrato(780, 1812, "Pomodoro");
		prodotti[39] = new ProdottoQuadrato(1036, 1812, "Pomodoro");
		prodotti[40] = new ProdottoQuadrato(12, 2068, "Pomodoro");
		prodotti[41] = new ProdottoQuadrato(268, 2068, "Pomodoro");
		prodotti[42] = new ProdottoQuadrato(524, 2068, "Pomodoro");
		prodotti[43] = new ProdottoQuadrato(780, 2068, "Pomodoro");
		prodotti[44] = new ProdottoQuadrato(1036, 2068, "Pomodoro");
		prodotti[45] = new ProdottoQuadrato(12, 2324, "Pomodoro");
		prodotti[46] = new ProdottoQuadrato(268, 2324, "Pomodoro");
		prodotti[47] = new ProdottoQuadrato(524, 2324, "Pomodoro");
		prodotti[48] = new ProdottoQuadrato(780, 2324, "Pomodoro");
		prodotti[49] = new ProdottoQuadrato(1036, 2324, "Pomodoro");
		prodotti[50] = new ProdottoQuadrato(12, 2580, "Pomodoro");
		prodotti[51] = new ProdottoQuadrato(268, 2580, "Pomodoro");
		prodotti[52] = new ProdottoQuadrato(524, 2580, "Pomodoro");
		prodotti[53] = new ProdottoQuadrato(780, 2580, "Pomodoro");
		prodotti[54] = new ProdottoQuadrato(1036, 2580, "Pomodoro");
		prodotti[55] = new ProdottoQuadrato(12, 2836, "Pomodoro");
		prodotti[56] = new ProdottoQuadrato(268, 2836, "Pomodoro");
		prodotti[57] = new ProdottoQuadrato(524, 2836, "Pomodoro");
		prodotti[58] = new ProdottoQuadrato(780, 2836, "Pomodoro");
		prodotti[59] = new ProdottoQuadrato(1036, 2836, "Pomodoro");
		prodotti[60] = new ProdottoQuadrato(12, 3092, "Pomodoro");
		prodotti[61] = new ProdottoQuadrato(268, 3092, "Pomodoro");
		prodotti[62] = new ProdottoQuadrato(524, 3092, "Pomodoro");
		prodotti[63] = new ProdottoQuadrato(780, 3092, "Pomodoro");
		prodotti[64] = new ProdottoQuadrato(1036, 3092, "Pomodoro");
		prodotti[65] = new ProdottoQuadrato(12, 3348, "Pomodoro");
		prodotti[66] = new ProdottoQuadrato(268, 3348, "Pomodoro");
		prodotti[67] = new ProdottoQuadrato(524, 3348, "Pomodoro");
		prodotti[68] = new ProdottoQuadrato(780, 3348, "Pomodoro");
		prodotti[69] = new ProdottoQuadrato(1036, 3348, "Pomodoro");
		prodotti[70] = new ProdottoQuadrato(12, 3604, "Pomodoro");
		prodotti[71] = new ProdottoQuadrato(268, 3604, "Pomodoro");
		prodotti[72] = new ProdottoQuadrato(524, 3604, "Pomodoro");
		prodotti[73] = new ProdottoQuadrato(780, 3604, "Pomodoro");
		prodotti[74] = new ProdottoQuadrato(1036, 3604, "Pomodoro");
		prodotti[75] = new ProdottoQuadrato(12, 3860, "Pomodoro");
		prodotti[76] = new ProdottoQuadrato(268, 3860, "Pomodoro");
		prodotti[77] = new ProdottoQuadrato(524, 3860, "Pomodoro");
		prodotti[78] = new ProdottoQuadrato(780, 3860, "Pomodoro");
		prodotti[79] = new ProdottoQuadrato(1036, 3860, "Pomodoro");
		prodotti[80] = new ProdottoQuadrato(12, 4116, "Pomodoro");
		prodotti[81] = new ProdottoQuadrato(268, 4116, "Pomodoro");
		prodotti[82] = new ProdottoQuadrato(524, 4116, "Pomodoro");
		prodotti[83] = new ProdottoQuadrato(780, 4116, "Pomodoro");
		prodotti[84] = new ProdottoQuadrato(1036, 4116, "Pomodoro");
		prodotti[85] = new ProdottoQuadrato(12, 4372, "Pomodoro");
		prodotti[86] = new ProdottoQuadrato(268, 4372, "Pomodoro");
		prodotti[87] = new ProdottoQuadrato(524, 4372, "Pomodoro");
		prodotti[88] = new ProdottoQuadrato(780, 4372, "Pomodoro");
		prodotti[89] = new ProdottoQuadrato(1036, 4372, "Pomodoro");
		prodotti[90] = new ProdottoQuadrato(12, 4628, "Pomodoro");
		prodotti[91] = new ProdottoQuadrato(268, 4628, "Pomodoro");
		prodotti[92] = new ProdottoQuadrato(524, 4628, "Pomodoro");
		prodotti[93] = new ProdottoQuadrato(780, 4628, "Pomodoro");
		prodotti[94] = new ProdottoQuadrato(1036, 4628, "Pomodoro");
		prodotti[95] = new ProdottoQuadrato(12, 4884, "Pomodoro");
		prodotti[96] = new ProdottoQuadrato(268, 4884, "Pomodoro");
		prodotti[97] = new ProdottoQuadrato(524, 4884, "Pomodoro");
		prodotti[98] = new ProdottoQuadrato(780, 4884, "Pomodoro");
		prodotti[99] = new ProdottoQuadrato(1036, 4884, "Pomodoro");
		prodotti[100] = new ProdottoQuadrato(12, 5140, "Pomodoro");
		prodotti[101] = new ProdottoQuadrato(268, 5140, "Pomodoro");
		prodotti[102] = new ProdottoQuadrato(524, 5140, "Pomodoro");
		prodotti[103] = new ProdottoQuadrato(780, 5140, "Pomodoro");
		prodotti[104] = new ProdottoQuadrato(1036, 5140, "Pomodoro");
		prodotti[105] = new ProdottoQuadrato(12, 5396, "Pomodoro");
		prodotti[106] = new ProdottoQuadrato(268, 5396, "Pomodoro");
		prodotti[107] = new ProdottoQuadrato(524, 5396, "Pomodoro");
		prodotti[108] = new ProdottoQuadrato(780, 5396, "Pomodoro");
		prodotti[109] = new ProdottoQuadrato(1036, 5396, "Pomodoro");
		prodotti[110] = new ProdottoQuadrato(12, 5652, "Pomodoro");
		prodotti[111] = new ProdottoQuadrato(268, 5652, "Pomodoro");
		prodotti[112] = new ProdottoQuadrato(524, 5652, "Pomodoro");
		prodotti[113] = new ProdottoQuadrato(780, 5652, "Pomodoro");
		prodotti[114] = new ProdottoQuadrato(1036, 5652, "Pomodoro");
		prodotti[115] = new ProdottoQuadrato(12, 5908, "Pomodoro");
		prodotti[116] = new ProdottoQuadrato(268, 5908, "Pomodoro");
		prodotti[117] = new ProdottoQuadrato(524, 5908, "Pomodoro");
		prodotti[118] = new ProdottoQuadrato(780, 5908, "Pomodoro");
		prodotti[119] = new ProdottoQuadrato(1036, 5908, "Pomodoro");
		prodotti[120] = new ProdottoQuadrato(12, 6164, "Pomodoro");
		prodotti[121] = new ProdottoQuadrato(268, 6164, "Pomodoro");
		prodotti[122] = new ProdottoQuadrato(524, 6164, "Pomodoro");
		prodotti[123] = new ProdottoQuadrato(780, 6164, "Pomodoro");
		prodotti[124] = new ProdottoQuadrato(1036, 6164, "Pomodoro");
		prodotti[125] = new ProdottoQuadrato(12, 6420, "Pomodoro");
		prodotti[126] = new ProdottoQuadrato(268, 6420, "Pomodoro");
		prodotti[127] = new ProdottoQuadrato(524, 6420, "Pomodoro");
		prodotti[128] = new ProdottoQuadrato(780, 6420, "Pomodoro");
		prodotti[129] = new ProdottoQuadrato(1036, 6420, "Pomodoro");
		prodotti[130] = new ProdottoQuadrato(12, 6676, "Pomodoro");
		prodotti[131] = new ProdottoQuadrato(268, 6676, "Pomodoro");
		prodotti[132] = new ProdottoQuadrato(524, 6676, "Pomodoro");
		prodotti[133] = new ProdottoQuadrato(780, 6676, "Pomodoro");
		prodotti[134] = new ProdottoQuadrato(1036, 6676, "Pomodoro");
		prodotti[135] = new ProdottoQuadrato(12, 6932, "Pomodoro");
		prodotti[136] = new ProdottoQuadrato(268, 6932, "Pomodoro");
		prodotti[137] = new ProdottoQuadrato(524, 6932, "Pomodoro");
		prodotti[138] = new ProdottoQuadrato(780, 6932, "Pomodoro");
		prodotti[139] = new ProdottoQuadrato(1036, 6932, "Pomodoro");
		prodotti[140] = new ProdottoQuadrato(12, 7188, "Pomodoro");
		prodotti[141] = new ProdottoQuadrato(268, 7188, "Pomodoro");
		prodotti[142] = new ProdottoQuadrato(524, 7188, "Pomodoro");
		prodotti[143] = new ProdottoQuadrato(780, 7188, "Pomodoro");
		prodotti[144] = new ProdottoQuadrato(1036, 7188, "Pomodoro");
		prodotti[145] = new ProdottoQuadrato(12, 7444, "Pomodoro");
		prodotti[146] = new ProdottoQuadrato(268, 7444, "Pomodoro");
		prodotti[147] = new ProdottoQuadrato(524, 7444, "Pomodoro");
		prodotti[148] = new ProdottoQuadrato(780, 7444, "Pomodoro");
		prodotti[149] = new ProdottoQuadrato(1036, 7444, "Pomodoro");
		for(int c = 0; c<150; c++) {
			panelScrollCatalogo.add(prodotti[c]);
		}
		//setto lo scrollpane
		scrollCatalogo = new JScrollPane(panelScrollCatalogo, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCatalogo.setBounds(0, 100, 1279, 663);
		scrollCatalogo.setBackground(null);
		scrollCatalogo.setOpaque(false);
		scrollCatalogo.getViewport().setOpaque(false);
		scrollCatalogo.setBorder(null);
		scrollCatalogo.getVerticalScrollBar().setUnitIncrement(20);
		add(scrollCatalogo);
	}
	
	public JButton getMagazzinoCat() {
		return magazzinoCat;
	}
	
	public JButton getCarrelloCat() {
		return carrelloCat;
	}

}
