package main;

import java.awt.*;
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
	private JPanel panelScrollCarrello = new JPanel();
	private JScrollPane scrollCarrello;
	//JPanel usata per scorrere i prodotti nel carrello
	private LineaScorrimento scorriCarrello;
	//array che contiene prodotti in catalogo
	private ProdottoLungo[] prodotti = new ProdottoLungo[70];
	private int valore;
	private int cellaScorrimento;

	//costruttore per creare la schermata del carrello
	public Carrello() {
		//setto il Panel
		setLayout(null);
		setBounds(0, 0, 1331, 768);
		//aggingo i prodotti e la scrollbar personalizzata
		generaProdotti();
		setScorriCarrello();
		//setto i vari componenti
		setImmagineProfiloCar();
		setCopriLineaCarrello();
		setSfondoProdotti();
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
		//carrello.addActionListener(e -> piuUno(nomeProdotto));
		add(immagineProfiloCar);
	}
	
	public JButton getMagazzinoCar() {
		return magazzinoCar;
	}
	
	public JButton getCatalogoCar() {
		return catalogoCar;
	}
	
	//metodo per generare i 150 prodotti nel catalogo
	public void generaProdotti() {
		//setto il panel con la grandezza totale che deve avere
		panelScrollCarrello.setPreferredSize(new Dimension(804, 11710));
		panelScrollCarrello.setBackground(null);
		panelScrollCarrello.setLayout(null);
		panelScrollCarrello.setOpaque(false);
		//creo 150 diversi prodotti
		prodotti[0] = new ProdottoLungo(10, 10, "Pomodoro");
		prodotti[1] = new ProdottoLungo(10, 88, "Pomodoro");
		prodotti[2] = new ProdottoLungo(10, 166, "Pomodoro");
		prodotti[3] = new ProdottoLungo(10, 244, "Pomodoro");
		prodotti[4] = new ProdottoLungo(10, 322, "Pomodoro");
		prodotti[5] = new ProdottoLungo(10, 400, "Pomodoro");
		prodotti[6] = new ProdottoLungo(10, 478, "Pomodoro");
		prodotti[7] = new ProdottoLungo(10, 556, "Pomodoro");
		prodotti[8] = new ProdottoLungo(10, 634, "Pomodoro");
		prodotti[9] = new ProdottoLungo(10, 712, "Pomodoro");
		prodotti[10] = new ProdottoLungo(10, 790, "Pomodoro");
		prodotti[11] = new ProdottoLungo(10, 868, "Pomodoro");
		prodotti[12] = new ProdottoLungo(10, 946, "Pomodoro");
		prodotti[13] = new ProdottoLungo(10, 1024, "Pomodoro");
		prodotti[14] = new ProdottoLungo(10, 1102, "Pomodoro");
		prodotti[15] = new ProdottoLungo(10, 1180, "Pomodoro");
		prodotti[16] = new ProdottoLungo(10, 1258, "Pomodoro");
		prodotti[17] = new ProdottoLungo(10, 1336, "Pomodoro");
		prodotti[18] = new ProdottoLungo(10, 1414, "Pomodoro");
		prodotti[19] = new ProdottoLungo(10, 1492, "Pomodoro");
		prodotti[20] = new ProdottoLungo(10, 1570, "Pomodoro");
		prodotti[21] = new ProdottoLungo(10, 1648, "Pomodoro");
		prodotti[22] = new ProdottoLungo(10, 1726, "Pomodoro");
		prodotti[23] = new ProdottoLungo(10, 1804, "Pomodoro");
		prodotti[24] = new ProdottoLungo(10, 1882, "Pomodoro");
		prodotti[25] = new ProdottoLungo(10, 1960, "Pomodoro");
		prodotti[26] = new ProdottoLungo(10, 2038, "Pomodoro");
		prodotti[27] = new ProdottoLungo(10, 2116, "Pomodoro");
		prodotti[28] = new ProdottoLungo(10, 2194, "Pomodoro");
		prodotti[29] = new ProdottoLungo(10, 2272, "Pomodoro");
		prodotti[30] = new ProdottoLungo(10, 2350, "Pomodoro");
		prodotti[31] = new ProdottoLungo(10, 2428, "Pomodoro");
		prodotti[32] = new ProdottoLungo(10, 2506, "Pomodoro");
		prodotti[33] = new ProdottoLungo(10, 2584, "Pomodoro");
		prodotti[34] = new ProdottoLungo(10, 2662, "Pomodoro");
		prodotti[35] = new ProdottoLungo(10, 2740, "Pomodoro");
		prodotti[36] = new ProdottoLungo(10, 2818, "Pomodoro");
		prodotti[37] = new ProdottoLungo(10, 2896, "Pomodoro");
		prodotti[38] = new ProdottoLungo(10, 2974, "Pomodoro");
		prodotti[39] = new ProdottoLungo(10, 3052, "Pomodoro");
		prodotti[40] = new ProdottoLungo(10, 3130, "Pomodoro");
		prodotti[41] = new ProdottoLungo(10, 3208, "Pomodoro");
		prodotti[42] = new ProdottoLungo(10, 3286, "Pomodoro");
		prodotti[43] = new ProdottoLungo(10, 3364, "Pomodoro");
		prodotti[44] = new ProdottoLungo(10, 3442, "Pomodoro");
		prodotti[45] = new ProdottoLungo(10, 3520, "Pomodoro");
		prodotti[46] = new ProdottoLungo(10, 3598, "Pomodoro");
		prodotti[47] = new ProdottoLungo(10, 3676, "Pomodoro");
		prodotti[48] = new ProdottoLungo(10, 3754, "Pomodoro");
		prodotti[49] = new ProdottoLungo(10, 3832, "Pomodoro");
		prodotti[50] = new ProdottoLungo(10, 3910, "Pomodoro");
		prodotti[51] = new ProdottoLungo(10, 3988, "Pomodoro");
		prodotti[52] = new ProdottoLungo(10, 4066, "Pomodoro");
		prodotti[53] = new ProdottoLungo(10, 4144, "Pomodoro");
		prodotti[54] = new ProdottoLungo(10, 4222, "Pomodoro");
		prodotti[55] = new ProdottoLungo(10, 4300, "Pomodoro");
		prodotti[56] = new ProdottoLungo(10, 4378, "Pomodoro");
		prodotti[57] = new ProdottoLungo(10, 4456, "Pomodoro");
		prodotti[58] = new ProdottoLungo(10, 4534, "Pomodoro");
		prodotti[59] = new ProdottoLungo(10, 4612, "Pomodoro");
		prodotti[60] = new ProdottoLungo(10, 4690, "Pomodoro");
		prodotti[61] = new ProdottoLungo(10, 4768, "Pomodoro");
		prodotti[62] = new ProdottoLungo(10, 4846, "Pomodoro");
		prodotti[63] = new ProdottoLungo(10, 4924, "Pomodoro");
		prodotti[64] = new ProdottoLungo(10, 5002, "Pomodoro");
		prodotti[65] = new ProdottoLungo(10, 5080, "Pomodoro");
		prodotti[66] = new ProdottoLungo(10, 5158, "Pomodoro");
		prodotti[67] = new ProdottoLungo(10, 5236, "Pomodoro");
		prodotti[68] = new ProdottoLungo(10, 5314, "Pomodoro");
		prodotti[69] = new ProdottoLungo(10, 5392, "Pomodoro");

		for(int c = 0; c<70; c++) {
			panelScrollCarrello.add(prodotti[c]);
		}
		//setto lo scrollpane con la grandezza da mostrare
		scrollCarrello = new JScrollPane(panelScrollCarrello, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCarrello.setBounds(42, 140, 804, 584);
		scrollCarrello.setBackground(null);
		scrollCarrello.setOpaque(false);
		scrollCarrello.getViewport().setOpaque(false);
		scrollCarrello.setBorder(null);
		scrollCarrello.getVerticalScrollBar().setUnitIncrement(20);
		add(scrollCarrello);
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
			} else if(valore == 11126) {
				//if per non far scattare lo scorriCatalogo
				if(!scorriCarrello.getStoScorrendo()) {
					scorriCarrello.setYTastoScorrimento(525, "no");
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
	
}
