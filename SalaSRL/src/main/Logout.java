package main;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Logout extends JPanel{

	//VARIABILI DI ISTANZA
	//jlabel usata per impostare lo sfondo del pannello logout
	private JLabel schermataLogout = new JLabel();
	//bottone per effettuare il logout
	private JButton logout = new JButton();
	//bottone per chiudere il pannello di logout
	private JButton chiudiLogout = new JButton();
	//variabile usata come appoggio per poter caricare le immagini
	private ImageIcon immagine;
	private Image immScalata;
	
	
	
	//COSTRUTTORE
	public Logout() {
		//setto il Panel	
		setLayout(null);
		setBounds(937, 2, 391, 190);
		
		//imposto i bottoni del pannello
		setBottoneChiudiLogout();
		setBottoneLogout();
		//imposto lo sfondo
		setSchermataLogout();
		
		//imposto i campi dove inserisco le informazioni dell'account
		
		
	}
	
	
	
	//METODI DI ISTANZA	
	//metodo per impostare lo sfondo del pannello logout
	public void setSchermataLogout() {
		//imposto lo sfondo
		schermataLogout.setBounds(0, 0, 391, 190);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("SfondoPanelLogout.png"));
		schermataLogout.setIcon(immagine);
		add(schermataLogout);
	}
	
	//metodo per impostare le caratteristiche del bottone per chiudere il pannello
	public void setBottoneChiudiLogout() {
		//imposto le caratteristiche del bottone
		chiudiLogout.setContentAreaFilled(false);
		chiudiLogout.setBorderPainted(false);
		chiudiLogout.setBounds(12, 12, 37, 37);
		//carico sul bottone le immagini per il tasto di chiusura
		immagine = new ImageIcon(getClass().getClassLoader().getResource("EscPanelLogout.png"));
		immScalata = immagine.getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		chiudiLogout.setIcon(immagine);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("EscPanelLogoutPress.png"));
		immScalata = immagine.getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		chiudiLogout.setPressedIcon(immagine);	
		//aggiungo un actionlistener per cambiare pannello
		chiudiLogout.addActionListener(e -> Collegamenti.fromLogoutToOther());
		add(chiudiLogout);
	}
	//metodo per impostare le caratteristiche del bottone per il logout
	public void setBottoneLogout() {
		//imposto le caratteristiche del bottone
		logout.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		logout.setBounds(12, 141, 128, 37);
		//carico sul bottone le immagini per il tasto di chiusura
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoLogout.png"));
		immScalata = immagine.getImage().getScaledInstance(128, 37, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		logout.setIcon(immagine);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoLogoutPress.png"));
		immScalata = immagine.getImage().getScaledInstance(128, 37, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		logout.setPressedIcon(immagine);	
		//aggiungo un actionlistener per cambiare pannello
		logout.addActionListener(e -> Collegamenti.fromLogoutToLogin());
		add(logout);
	}
	
	
	
	
	
}
