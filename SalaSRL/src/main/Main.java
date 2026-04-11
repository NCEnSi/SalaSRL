package main;
import java.io.*;
import javax.swing.*;

public class Main {
	
	//da non cancellare grazie
	static Collegamenti finestra;
	
	public static void main(String[] nmf) throws IOException {
		finestra = new Collegamenti();
		
		//CORREZIONI:
		//sistemare grandezze e calcoli scrollbar in carrello e in gestione utenti <--OPZIONALE
		//sistemare il fatto che, una volta effettuato il logout, tutti gli altri pannelli non vengono resettati <--DA FARE
		
		//LOGIN:
		//se premi invio passa al campo successivo, se si preme quando si è nel campo password è come premere invia <--OPZIONALE
		//mettere un limite di caratteri per email per non farli uscire dalla schermata di logout <--OPZIONALE
		
		//MAGAZZINO:
		//tutto <--DA FARE
		
		//CATALOGO:
		//potremmo cambiare qualche prodotto tipo in vino e alcool <--OPZIONALE
		
		//CARRELLO:
		//far funzionare il tasto conferma ordine <--DA FARE
		//se schiacci su un prodotto far apparire le informazioni nella label apposita <--PARZIALMENTE OPZIONALE
		//mettere un massimo di (spazioLiberoMagazzino) nel carrello <--PARZIALMENTE OPZIONALE
		
		//GESTIONE UTENTI:
		//mettere che solo i creatori vedono il pulsante per andarci <--OPZIONALE
		//il creatore che accede alla gestione utenti non può modificare il suo stato <--OPZIONALE
		//i ruoli si aggiornano in tempo reale <--OPZIONALE
				
		//UTENTE:
		//tutto <--DA FARE
		
		//PRODOTTI:
		//preparare grafica tasti premuti del carrello admin <--OPZIONALE
		//preparare info di ogni prodotto <--PARZIALMENTE OPZIONALE
		//pensare alla grafica informazioni del carrello admin <--PARZIALMENTE OPZIONALE
		
	}
}
