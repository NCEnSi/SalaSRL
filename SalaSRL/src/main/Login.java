package main;
import java.awt.*;
import javax.swing.*;

public class Login extends JPanel{

	//VARIABILI DI ISTANZA
	//bottoni che uso per passare da un pannello a un altro
	private JButton confermaLogin = new JButton();
	private JButton confermaSignin = new JButton();
	private JButton signin = new JButton();
	//bottoni per scegliere se la password è visibile oppure no
	private JButton passwordVisibleLogin = new JButton();
	private JButton passwordVisibleSignin = new JButton();
	//jlabel usati per lo sfondo di ogni schermata pannello
	private JLabel schermataLogin = new JLabel();
	private JLabel schermataSignin = new JLabel();
	//jtextfield usati per inserire i diversi campi (username, email e password)
	private JTextField emailLogin = new JTextField();
	private JPasswordField passwordLogin = new JPasswordField();
	private JTextField usernameSignin = new JTextField();
	private JTextField emailSignin = new JTextField();
	private JPasswordField passwordSignin = new JPasswordField();
	//immagini del bottone per nascondere la password
	private ImageIcon nascosta;
	private ImageIcon visibile;
	//salvo il carattere usato di default per mascherare la password
	private char charHidden = passwordLogin.getEchoChar();
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
		
		//salvo le immagini per i bottoni delle password
		immagine = new ImageIcon(getClass().getClassLoader().getResource("NoViewPass.png"));
		immScalata = immagine.getImage().getScaledInstance(33, 33, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		nascosta = immagine;
		immagine = new ImageIcon(getClass().getClassLoader().getResource("ViewPass.png"));
		immScalata = immagine.getImage().getScaledInstance(31, 19, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		visibile = immagine;
		
		//creo le diverse "schermate" in modo tale da aggiornare la finestra in automatico quando viene cliccato un bottone
		creaLogin();
		creaSignin();
	}
	
	
	
	//METODI PER CREARE I PANNELLI
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
		setBottoneConfermaToAccount();
		setBottonePasswordLogin();
		//imposto i diversi campi dove inserire i dati richiesti
		setEmailLogin();
		setPasswordLogin();
		
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
		//imposto i bottoni		
		setBottoneConfermaToLogin();
		setBottonePasswordSignin();
		//imposto i diversi campi dove inserire i dati richiesti
		setUsernameSignin();
		setEmailSignin();
		setPasswordSignin();
		
		add(schermate[1]);
		//faccio in modo che all'inizio non sia visibile in quanto c'è quella di login
		schermate[1].setVisible(false);
	}
	
	
	
	//METODI PER IMPOSTARE GLI SFONDI
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
	
	
	
	//METODI PER IMPOSTARE I BOTTONI
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
		immagine = new ImageIcon(getClass().getClassLoader().getResource("SigninPress.png"));
		immScalata = immagine.getImage().getScaledInstance(67, 31, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		signin.setPressedIcon(immagine);	
		//aggiungo un actionlistener per cambiare pannello
		signin.addActionListener(e -> toSignin());
		schermataLogin.add(signin);
	}
	//metodo per impostare il bottone conferma
	public void setBottoneConfermaToAccount() {
		//imposto le caratteristiche del bottone
		confermaLogin.setContentAreaFilled(false);
		confermaLogin.setBorderPainted(false);
		confermaLogin.setBounds(687, 496, 94, 31);
		//imposto l'immagine da dargli
		immagine = new ImageIcon(getClass().getClassLoader().getResource("ConfermaSigninLogin.png"));
		immScalata = immagine.getImage().getScaledInstance(94, 31, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		confermaLogin.setIcon(immagine);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("ConfermaSigninLoginPress.png"));
		immScalata = immagine.getImage().getScaledInstance(94, 31, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		confermaLogin.setPressedIcon(immagine);	
		//aggiungo un actionlistener per cambiare pannello
		confermaLogin.addActionListener(e -> toAccount());
		schermataLogin.add(confermaLogin);
	}
	//metodo per impostare il bottone conferma
	public void setBottoneConfermaToLogin() {
		//imposto le caratteristiche del bottone
		confermaSignin.setContentAreaFilled(false);
		confermaSignin.setBorderPainted(false);
		confermaSignin.setBounds(687, 587, 94, 31);
		//imposto l'immagine da dargli
		immagine = new ImageIcon(getClass().getClassLoader().getResource("ConfermaSigninLogin.png"));
		immScalata = immagine.getImage().getScaledInstance(94, 31, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		confermaSignin.setIcon(immagine);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("ConfermaSigninLoginPress.png"));
		immScalata = immagine.getImage().getScaledInstance(94, 31, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		confermaSignin.setPressedIcon(immagine);	
		//aggiungo un actionlistener per cambiare pannello
		confermaSignin.addActionListener(e -> toLogin());
		schermataSignin.add(confermaSignin);
	}
	//metodo per impostare il bottone della visibilità della password
	public void setBottonePasswordLogin() {
		//imposto le caratteristiche del bottone
		passwordVisibleLogin.setContentAreaFilled(false);
		passwordVisibleLogin.setBorderPainted(false);
		passwordVisibleLogin.setBounds(740, 444, 33, 33);
		//imposto l'immagine da dargli
		passwordVisibleLogin.setIcon(nascosta);
		//aggiungo un actionlistener per cambiare pannello
		passwordVisibleLogin.addActionListener(e -> toVisibilityPass());
		schermataLogin.add(passwordVisibleLogin);
	}
	//metodo per impostare il bottone della visibilità della password
	public void setBottonePasswordSignin() {
		//imposto le caratteristiche del bottone
		passwordVisibleSignin.setContentAreaFilled(false);
		passwordVisibleSignin.setBorderPainted(false);
		passwordVisibleSignin.setBounds(740, 533, 33, 33);
		//imposto l'immagine da dargli
		passwordVisibleSignin.setIcon(nascosta);
		//aggiungo un actionlistener per cambiare pannello
		passwordVisibleSignin.addActionListener(e -> toVisibilityPass());
		schermataSignin.add(passwordVisibleSignin);
	}
	
	//metodo per cambiare pannello da login a signin
	public void toSignin() {
		schermate[0].setVisible(false);
		schermate[1].setVisible(true);
	}
	//metodo per cambiare pannello da signin a login
	public void toLogin() {
		schermate[0].setVisible(true);
		schermate[1].setVisible(false);
	}
	//metodo per cambiare pannello da login a admin o utente
	public void toAccount() {
		schermate[0].setVisible(false);
		schermate[1].setVisible(false);
		
		//AGGIUNGERE COLLEGAMENTO ALLA PARTE DI NICOLO'
		
		
	}
	//metodo per rendere invisibile la password e viceversa
	public void toVisibilityPass() {
		//controllo quale delle due scermate è visibile
		if(schermate[0].isVisible()) {
			//controllo se la password attualmente è nascosta oppure no
			if(passwordVisibleLogin.getIcon() == nascosta) {
				//modifico l'immagine del bottone
				passwordVisibleLogin.setIcon(visibile);
				//modifico la visibilità della password
				passwordLogin.setEchoChar((char) 0);
			} else {
				//modifico l'immagine del bottone
				passwordVisibleLogin.setIcon(nascosta);
				//modifico la visibilità della password
				passwordLogin.setEchoChar(charHidden);
			}
		} else {
			//controllo se la password attualmente è nascosta oppure no
			if(passwordVisibleSignin.getIcon() == nascosta) {
				//modifico l'immagine del bottone
				passwordVisibleSignin.setIcon(visibile);
				//modifico la visibilità della password
				passwordSignin.setEchoChar((char) 0);
			} else {
				//modifico l'immagine del bottone
				passwordVisibleSignin.setIcon(nascosta);
				//modifico la visibilità della password
				passwordSignin.setEchoChar(charHidden);
			}
		}
	}
	
	
	
	//METODI PER IMPOSTARE LE ZONE DI SCRITTURA
	//metodo per impostare il campo dell'email
	public void setEmailLogin() {
		//imposto le caratteristiche della casella per l'email
		emailLogin.setOpaque(false);
		emailLogin.setBorder(null);
		emailLogin.setFont(new Font("Arial", Font.PLAIN, 20));
		emailLogin.setBounds(543, 357, 230, 30);
		
		
		
		
		schermataLogin.add(emailLogin);
	}
	//metodo per impostare il campo della password
	public void setPasswordLogin() {
		//imposto le caratteristiche della casella per la password
		passwordLogin.setOpaque(false);
		passwordLogin.setBorder(null);
		passwordLogin.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordLogin.setBounds(543, 446, 197, 30);

		
		
		
		schermataLogin.add(passwordLogin);
	}
	//metodo per impostare il campo dell'username
	public void setUsernameSignin() {
		//imposto le caratteristiche della casella per l'username
		usernameSignin.setOpaque(false);
		usernameSignin.setBorder(null);
		usernameSignin.setFont(new Font("Arial", Font.PLAIN, 20));
		usernameSignin.setBounds(543, 357, 230, 30);

		
		
		
		schermataSignin.add(usernameSignin);
	}
	//metodo per impostare il campo dell'email
	public void setEmailSignin() {
		//imposto le caratteristiche della casella per l'email
		emailSignin.setOpaque(false);
		emailSignin.setBorder(null);
		emailSignin.setFont(new Font("Arial", Font.PLAIN, 20));
		emailSignin.setBounds(543, 446, 230, 30);

		
		
		
		schermataSignin.add(emailSignin);
	}
	//metodo per impostare il campo della password
	public void setPasswordSignin() {
		//imposto le caratteristiche della casella per la password
		passwordSignin.setOpaque(false);
		passwordSignin.setBorder(null);
		passwordSignin.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordSignin.setBounds(543, 535, 197, 30);

		
		
		
		schermataSignin.add(passwordSignin);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	 


}
