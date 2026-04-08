package main;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.*;

public class Admin extends JPanel {

	private JPanel[] schermate = new JPanel[3];
	
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
		schermate[0] = new Magazzino();
		//aggiungo un actionlistener per cambiare schermata in catalogo
		((Magazzino) schermate[0]).getCatalogoMag().addActionListener(e -> changeInCatalogo());
		//aggiungo un actionlistener per cambiare schermata in carrello
		((Magazzino) schermate[0]).getCarrellooMag().addActionListener(e -> changeInCarrello());
		add(schermate[0]);
	}
	
	//metodo per creare la schermata del catalogo
	public void creaCatalogo() {
		schermate[1] = new Catalogo();
		//aggiungo un actionlistener per cambiare schermata in magazzino
		((Catalogo) schermate[1]).getMagazzinoCat().addActionListener(e -> changeInMagazzino());
		//aggiungo un actionlistener per cambiare schermata in carrello
		((Catalogo) schermate[1]).getCarrelloCat().addActionListener(e -> changeInCarrello());
		add(schermate[1]);
	}
	
	//metodo per creare la schermata del carrello
	public void creaCarrello() {
		schermate[2] = new Carrello();
		//aggiungo un actionlistener per cambiare schermata in magazzino
		((Carrello) schermate[2]).getMagazzinoCar().addActionListener(e -> changeInMagazzino());
		//aggiungo un actionlistener per cambiare schermata in catalogo
		((Carrello) schermate[2]).getCatalogoCar().addActionListener(e -> changeInCatalogo());
		add(schermate[2]);
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
	
}
