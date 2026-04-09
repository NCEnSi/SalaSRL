package main;
import java.io.*;
import javax.swing.*;

public class Main {
	public static void main(String[] nmf) throws IOException {
		//new Collegamenti();
		
		JFrame finestra = new JFrame();
		
		//impostazioni delle caratteristiche della finestra
		finestra.setResizable(false);
				//1331 e 807 sono le grandezze definitive (mangia rispettivamente 16 e 39 px)
		finestra.setSize(1331, 807);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		finestra.setLayout(null);
		
		Logout logout = new Logout();
		
		finestra.add(logout);
		finestra.setVisible(true);

		
		//CORREZIONI:
		//sistemare grandezze e calcoli scrollbar
		//mettere un massimo di (spazioLiberoMagazzino) nel carrello
		
		//MAGAZZINO:
		
		//LOGIN:
		//dividere le due schermate in 2 classi
		
		//PRODOTTI:
		//preparare tasti premuti
		//preparare info di ogni prodotto
		//grafica informazioni del carrelo
		
		//SCHERMATA GESTIONE UTENTI:
		//creare una schermata per cambiare grado da utente ad admin e viceversa che possono vedere solo gli account "creatori"
		
		//PANNELLO DI LOGOUT:
		//quando clicchi l'icona del profilo apre un mini pannello per fare il logout
		
		//UTENTE:
		
	}
}
