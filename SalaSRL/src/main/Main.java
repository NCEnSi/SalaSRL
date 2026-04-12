package main;
import java.io.*;
import javax.swing.*;

public class Main {
	
	//da non cancellare grazie
	static Collegamenti finestra;
	
	public static void main(String[] nmf) throws IOException {
		finestra = new Collegamenti();
		
		//ScrollPersonalizzata:
		//rifarla da capo <--PARZIALMENTE OPZIONALE
		//aggiungerla a catalogo, carrello e gestione utenti <--OPZIONALE
		
		//LOGIN:
		//aggiungere tasto per passare dalla schermata registrazione a quella accesso senza l'obbligo di creare un account <--PARZIALMENTE OPZIONALE
		//suddividere per bene la schermata di login/signup <--OPZIONALE
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
				
		//UTENTE:
		//tutto <--DA FARE
		
		//PRODOTTI:
		//sistemare posizioni bottoni (solo modficare x, y) <--OPZIONALE
		//preparare grafica tasti premuti del carrello admin <--OPZIONALE
		//preparare info di ogni prodotto <--PARZIALMENTE OPZIONALE
		//pensare alla grafica informazioni del carrello admin <--PARZIALMENTE OPZIONALE
		
	}
}
