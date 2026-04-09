package main;
import javax.swing.*;
import java.io.*;

public class Collegamenti extends JFrame {

	//VARIABILI DI ISTANZA
	//array che contiene tutte le schermate di cui è composto il progetto
	static JPanel[] schermateCompl = new JPanel[4];
	
	
	
	//COSTRUTTORE
	public Collegamenti() throws IOException{
		//impostazioni delle caratteristiche della finestra
		setResizable(false);
		//1331 e 807 sono le grandezze definitive (mangia rispettivamente 16 e 39 px)
		setSize(1331, 807);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setLayout(null);
		
		//metodo per creare in automatico le schermate
		creaSchermate();
		
		setVisible(true);
	}
	
	
	//METODI DI CLASSE
	//metodo usato per inizializzare l'array con le schermate
	public void creaSchermate() throws IOException{
		//creo le tre schermate
		schermateCompl[0] = new Login();
		schermateCompl[1] = new Admin();
		schermateCompl[2] = new Utente();
		schermateCompl[3] = new Logout();
		
		//faccio vedere solo login
		schermateCompl[0].setVisible(false);
		schermateCompl[1].setVisible(true);
		schermateCompl[2].setVisible(false);
		schermateCompl[3].setVisible(false);
		
		//aggiungo le schermate alla finestra
		add(schermateCompl[0]);
		add(schermateCompl[1]);
		add(schermateCompl[2]);
		add(schermateCompl[3]);
	}
	
	//metodo usato per passare dalla schermata di login alla pagina dedicata all'admin
	public static void fromLoginToAdmin() {
		//faccio in modo che si vedano solo le schermate admin
		schermateCompl[0].setVisible(false);
		schermateCompl[1].setVisible(true);
		schermateCompl[2].setVisible(false);
	}
	//metodo usato per passare dalla schermata di login alla pagina dedicata all'utente
	public static void fromLoginToUtente() {
		//faccio in modo che si vedano solo le schermate utente
		schermateCompl[0].setVisible(false);
		schermateCompl[1].setVisible(false);
		schermateCompl[2].setVisible(true);
	}
	
	//metodo usato per passare dalla schermata di logout alla pagina dedicata al login
	public static void fromLogoutToLogin() {
		//faccio in modo che si vedano solo le schermate login
		schermateCompl[0].setVisible(true);
		schermateCompl[1].setVisible(false);
		schermateCompl[2].setVisible(false);
		schermateCompl[3].setVisible(false);
	}
	//metodo usato per passare dalla schermata di logout alla pagina admin o utente
	public static void fromLogoutToOther() {
		//faccio in modo che si vedano solo le schermate admin e utente
		schermateCompl[3].setVisible(false);
	}
	//metodo usato per passare dalla schermata di admin o utente alla pagina dedicata al logout
	public static void fromOtherToLogout() {
		//faccio in modo che si vedano solo le schermate admin o utente e logout
		schermateCompl[3].setVisible(true);
	}
	
	
}
