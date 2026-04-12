package main;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Admin extends JPanel {

	private JPanel[] schermate = new JPanel[3];
	
	//costruttore
	public Admin(String privilegi) {		
		//setto il Panel	
		setLayout(null);
		setBounds(0, 0, 1331, 768);
		//creo le 3 schermate
		creaCatalogo(privilegi);
		creaMagazzino(privilegi);
		creaCarrello(((Catalogo) schermate[1]), privilegi);
	}
	
	//metodo per creare la schermata del magazzino
	public void creaMagazzino(String privilegi) {
		schermate[0] = new Magazzino(privilegi);
		//aggiungo un actionlistener per cambiare schermata in catalogo
		((Magazzino) schermate[0]).getCatalogoMag().addActionListener(e -> changeInCatalogo());
		//aggiungo un actionlistener per cambiare schermata in carrello
		((Magazzino) schermate[0]).getCarrellooMag().addActionListener(e -> changeInCarrello(((Catalogo) schermate[1]).getProdottiNelCarrello()));
		add(schermate[0]);
	}
	
	//metodo per creare la schermata del catalogo
	public void creaCatalogo(String privilegi) {
		schermate[1] = new Catalogo(privilegi);
		//aggiungo un actionlistener per cambiare schermata in magazzino
		((Catalogo) schermate[1]).getMagazzinoCat().addActionListener(e -> changeInMagazzino());
		//aggiungo un actionlistener per cambiare schermata in carrello
		((Catalogo) schermate[1]).getCarrelloCat().addActionListener(e -> changeInCarrello(((Catalogo) schermate[1]).getProdottiNelCarrello()));
		add(schermate[1]);
	}
	
	//metodo per creare la schermata del carrello
	public void creaCarrello(Catalogo catalogo, String privilegi) {
		schermate[2] = new Carrello(catalogo, privilegi);
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
	public void changeInCarrello(ArrayList<InformazioniDaPassare> prodotti) {
		((Carrello) schermate[2]).generaProdotti(prodotti, "no");
		schermate[0].setVisible(false);
		schermate[1].setVisible(false);
		schermate[2].setVisible(true);
	}
	
	public void setLogouts(String datiUtente) {
		((Magazzino) schermate[0]).setLogout(datiUtente);
		((Catalogo) schermate[1]).setLogout(datiUtente);
		((Carrello) schermate[2]).setLogout(datiUtente);
	}
	
	public void showLogouts() {
		((Magazzino) schermate[0]).getPanelLogout().setVisible(true);
		((Catalogo) schermate[1]).getPanelLogout().setVisible(true);
		((Carrello) schermate[2]).getPanelLogout().setVisible(true);
	}
	
	public void unShowLogouts() {
		((Magazzino) schermate[0]).getPanelLogout().setVisible(false);
		((Catalogo) schermate[1]).getPanelLogout().setVisible(false);
		((Carrello) schermate[2]).getPanelLogout().setVisible(false);
	}
	
}
