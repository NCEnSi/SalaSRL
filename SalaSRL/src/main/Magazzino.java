package main;

import java.awt.*;
import javax.swing.*;

public class Magazzino extends JPanel{
	
	//button per cambiare schermata
	private JButton catalogoMag = new JButton();
	private JButton carrelloMag = new JButton();
	//button per aprire info profilo
	private JButton immagineProfiloMag = new JButton();
	//label per evidenziare schermata attuale
	private JLabel magazzinoAttuale = new JLabel();
	//label per coprire
	private JLabel copriLineaMag = new JLabel();
	//label dove appaiono i prodotti in magazzino
	private JLabel luogoProdotti = new JLabel();
	//label che fa vedere lo spazio nel magazzino
	private JLabel spazioMagazzino = new JLabel();
	//label di contorno
	private JLabel strisciaSuperioreMag = new JLabel();
	//variabili usate per mettere le immagini
	private ImageIcon icon;
	private Image iconScaled;
	//aggiungo il panel per il logout
	private Logout logout = new Logout();
	//bottone per passare alla schermata di elenco utenti
	private JButton gestioneUtenti = new JButton();


	//costruttore per creare la schermata del magazzino
	public Magazzino(String privilegi) {
		//setto il Panel
		setLayout(null);
		setBounds(0, 0, 1331, 768);
		//aggiungo il panel per il logout
		setPanelLogout();
		//setto i vari componenti
		setImmagineProfiloMag();
		if(privilegi.equals("Creatore")) setGestioneUtenti();
		setCopriLineaMagazzino();
		setLuogoProdotti();
		setSpazioMagazzino();
		setCatalogoMag();
		setCarrelloMag();
		setMagazzinoAttuale();
		setStrisciaSuperioreMag();
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
		
		add(catalogoMag);
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
		add(carrelloMag);
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
		add(magazzinoAttuale);
	}
	
	//metodo per settare la label spazioMagazzino
	public void setSpazioMagazzino() {
		//imposto coordinate e grandezza della label
		spazioMagazzino.setBounds(0, 96, 1315, 58);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SpazioMagazzino.png"));
		spazioMagazzino.setIcon(icon);
		add(spazioMagazzino);
	}
	
	//metodo per settare la label luogoProdotti
	public void setLuogoProdotti() {
		//imposto coordinate e grandezza della label
		luogoProdotti.setBounds(0, 152, 1315, 619);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("LuogoProdotti.png"));
		luogoProdotti.setIcon(icon);
		add(luogoProdotti);
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
		add(copriLineaMag);
	}
	
	//metodo per settare la label strisciaSuperioreMag
	public void setStrisciaSuperioreMag() {
		//imposto coordinate e grandezza della label
		strisciaSuperioreMag.setBounds(0, 0, 1331, 107);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("StrisciaSuperiore.png"));
		strisciaSuperioreMag.setIcon(icon);
		add(strisciaSuperioreMag);
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
	public JButton getCatalogoMag() {
		return catalogoMag;
	}
	
	//metodo da usare per settare il cambio schermata
	public JButton getCarrellooMag() {
		return carrelloMag;
	}
}
