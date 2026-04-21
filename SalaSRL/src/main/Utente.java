package main;
import java.awt.Image;

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
	private Image iconScaled;

	//costruttore
	public Utente() {
		//setto il Panel
		setLayout(null);
		setBounds(0, 0, 1331, 768);
		//aggiungo il panel per il logout
		setPanelLogout();
		//setto i vari componenti
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
}
