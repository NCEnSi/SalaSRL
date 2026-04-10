package main;
import java.awt.Image;

import javax.swing.*;

public class Utente extends JPanel{
	
	private JLabel magazzinoAttuale = new JLabel();
	//variabili usate per mettere le immagini
	private ImageIcon icon;
	private Image iconScaled;

	//hey ciao nicolò fammi un piacere: fa lo stesso ragionamento che hai fatto per admin, ovvero se crei più classi poi mettile insieme sotto questa perchè si
	//costruttore
		public Utente() {
			//setto il Panel	
			setLayout(null);
			setBounds(0, 0, 1331, 768);
			//creo le 3 schermate
			setMagazzinoAttuale();
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
}
