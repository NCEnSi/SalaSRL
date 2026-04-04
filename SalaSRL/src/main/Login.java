package main;
import java.awt.*;
import javax.swing.*;
import java.awt.Image;

public class Login extends JPanel{

	//VARIABILI DI ISTANZA
	//bottoni che uso per passare da un pannello a un altro
	private JButton conferma = new JButton();
	private JButton signin = new JButton();
	//bottone per scegliere se la password è visibile oppure no
	private JButton passwordVisible = new JButton();
	//jlabel usati per lo sfondo di ogni schermata pannello
	private JLabel schermataLogin = new JLabel();
	private JLabel schermataSignin = new JLabel();
	//variabile usata come appoggio per poter caricare le immagini sui bottoni
	private ImageIcon immagine;
	private Image immScalata;
	//array che contiene le due schermate pannelli
	private JPanel[] schermate = new JPanel[2];
	
	
	//COSTRUTTORE
	public Login() {
		//imposto le dimensioni del pannello "schermo"
		setLayout(null);
		setBounds(0, 0, 1331, 768);
		//creo le diverse "schermate" in modo tale da aggiornare la finestra in automatico quando viene cliccato un bottone
		creaLogin();
		creaSignin();
	}
	
	
	//METODI
	//metodo per creare il pannello di login iniziale
	public void creaLogin() {
		//creo e imposto il pannello che corrisponde alla schermata di login
		schermate[0] = new JPanel();
		schermate[0].setLayout(null);
		schermate[0].setBounds(0, 0, 1331, 768);
		//imposto lo sfondo
		setSchermataLogin();
		//imposto i bottoni
		setBottoneSignin();
		setBottoneConferma();
		
		
		
		add(schermate[0]);
	}
	
	//metodo per creare il pannello di signin
	public void creaSignin() {
		//creo e imposto il pannello che corrisponde alla schermata di signin
		schermate[1] = new JPanel();
		schermate[1].setLayout(null);
		schermate[1].setBounds(0, 0, 1331, 768);
		//imposto lo sfondo
		setSchermataSignin();
				
				
				
		
		add(schermate[1]);
		//faccio in modo che all'inizio non sia visibile in quanto c'è quella di login
		schermate[1].setVisible(false);
	}
	
	
	//metodo per impostare lo sfondo del pannello login
	public void setSchermataLogin() {
		//imposto lo sfondo
		schermataLogin.setBounds(0, 0, 1331, 768);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("SchermataLogin.png"));
		schermataLogin.setIcon(immagine);
		schermate[0].add(schermataLogin);
	}
	//metodo per impostare lo sfondo del pannello login
	public void setSchermataSignin() {
		//imposto lo sfondo
		schermataSignin.setBounds(0, 0, 1331, 768);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("SchermataSignin.png"));
		schermataSignin.setIcon(immagine);
		schermate[1].add(schermataSignin);
	}
	
	//metodo per impostare il bottone signin
	public void setBottoneSignin() {
		//imposto le caratteristiche del bottone
		signin.setContentAreaFilled(false);
		signin.setBorderPainted(false);
		signin.setBounds(534, 496, 67, 31);
		//imposto l'immagine da dargli
		immagine = new ImageIcon(getClass().getClassLoader().getResource("Signin.png"));
		immScalata = immagine.getImage().getScaledInstance(67, 31, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		signin.setIcon(immagine);
		
		schermate[0].add(signin);
	}
	//metodo per impostare il bottone conferma
	public void setBottoneConferma() {
		//imposto le caratteristiche del bottone
		
		
		
	}
	


}
