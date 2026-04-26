package main;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class Login extends JPanel implements KeyListener{

	//VARIABILI DI ISTANZA
	//bottoni che uso per passare da un pannello a un altro
	private JButton confermaLogin = new JButton();
	private JButton signup = new JButton();
	//bottoni per scegliere se la password è visibile oppure no
	private JButton passwordVisibleLogin = new JButton();
	//jlabel usati per lo sfondo di ogni schermata pannello
	private JLabel schermataLogin = new JLabel();
	//jtextfield usati per inserire i diversi campi (username, email e password)
	private JTextField emailLogin = new JTextField();
	private JPasswordField passwordLogin = new JPasswordField();
	//immagini del bottone per nascondere la password
	private ImageIcon nascosta;
	private ImageIcon visibile;
	//salvo il carattere usato di default per mascherare la password
	private char charHidden = passwordLogin.getEchoChar();
	//creo le variabili per poter gli oggetti per interagire con il file txt
	private BufferedReader lettura;
	//jlabel usati per mandare eventuali messaggi d'errore
	static JLabel erroriLogin = new JLabel();
	//variabile usata come appoggio per poter caricare le immagini sui bottoni
	private ImageIcon immagine;
	private Image immScalata;
	//array che contiene le due schermate pannelli
	private JPanel[] schermate = new JPanel[2];
	
	
	
	//COSTRUTTORE
	public Login() throws IOException {
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
		
		//aggiungo al pannello
		setFocusable(true);
		addKeyListener(this);
		
		//creo le diverse "schermate" in modo tale da aggiornare la finestra in automatico quando viene cliccato un bottone
		creaLogin();
		creaSignup();
		
		requestFocusInWindow();
	}
	
	
	
	//METODI PER CREARE I PANNELLI
	//metodo per creare il pannello di login iniziale
	public void creaLogin() throws IOException{
		//creo e imposto il pannello che corrisponde alla schermata di login
		schermate[0] = new JPanel();
		schermate[0].setLayout(null);
		schermate[0].setBounds(0, 0, 1331, 768);
		//imposto lo sfondo
		setSchermataLogin();
		//imposto la sezione dei messaggi d'errore
		setErroriLogin();
		//imposto i bottoni
		setBottoneSignin();
		setBottoneConfermaToAccount();
		setBottonePasswordLogin();
		//imposto i diversi campi dove inserire i dati richiesti
		setEmailLogin();
		setPasswordLogin();
		
		add(schermate[0]);
		//faccio in modo che all'inizio sia visibile la prima schermata di login
		schermate[0].setVisible(true);
	}
	//metodo per creare il pannello di signup
	public void creaSignup() throws IOException {
		//creo e imposto il pannello che corrisponde alla schermata di signin
		Signup signup = new Signup(schermate);
		schermate[1] = signup;
	
		add(schermate[1]);
	}
	
	
	
	//METODI PER IMPOSTARE I JLABEL
	//metodo per impostare lo sfondo del pannello login
	public void setSchermataLogin() {
		//imposto lo sfondo
		schermataLogin.setBounds(0, 0, 1331, 768);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("SchermataLogin.png"));
		schermataLogin.setIcon(immagine);
		schermate[0].add(schermataLogin);
	}
	//metodo per impostare il messaggio d'errore login
	public void setErroriLogin() {
		//imposto le caratteristiche della casella per gli errori
		erroriLogin.setFont(new Font("Arial", Font.BOLD, 24));
		erroriLogin.setHorizontalAlignment(SwingConstants.CENTER);		
		erroriLogin.setBounds(0, 560, 1331, 30);
		
		//erroriLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		schermataLogin.add(erroriLogin);
	}
	
	
	
	//METODI PER IMPOSTARE I BOTTONI
	//metodo per impostare il bottone signin
	public void setBottoneSignin() {
		//imposto le caratteristiche del bottone
		signup.setContentAreaFilled(false);
		signup.setBorderPainted(false);
		signup.setBounds(534, 496, 67, 31);
		//imposto l'immagine da dargli
		immagine = new ImageIcon(getClass().getClassLoader().getResource("Signup.png"));
		immScalata = immagine.getImage().getScaledInstance(67, 31, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		signup.setIcon(immagine);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("SignupPress.png"));
		immScalata = immagine.getImage().getScaledInstance(67, 31, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		signup.setPressedIcon(immagine);	
		//aggiungo un actionlistener per cambiare pannello
		signup.addActionListener(e -> toSignin());
		schermataLogin.add(signup);
	}
	//metodo per impostare il bottone conferma
	public void setBottoneConfermaToAccount() throws IOException{
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
		confermaLogin.addActionListener(e -> {
			try{
				toAccount();
			}catch(IOException ioe) {
				System.out.println("boh non so che mettere tanto non serve");
			}
		});
		schermataLogin.add(confermaLogin);
	}
	//metodo per impostare il bottone della visibilità della password
	public void setBottonePasswordLogin() {
		//imposto le caratteristiche del bottone
		passwordVisibleLogin.setContentAreaFilled(false);
		passwordVisibleLogin.setBorderPainted(false);
		passwordVisibleLogin.setBorder(null);
		passwordVisibleLogin.setBounds(740, 444, 33, 33);
		//imposto l'immagine da dargli
		passwordVisibleLogin.setIcon(nascosta);
		//aggiungo un actionlistener per cambiare pannello
		passwordVisibleLogin.addActionListener(e -> toVisibilityPassLogin());
		schermataLogin.add(passwordVisibleLogin);
	}
	
	//metodo per cambiare pannello da login a signin
	public void toSignin() {
		//rendo visibile il pannello con la schermata del signin
		schermate[0].setVisible(false);
		schermate[1].setVisible(true);
		//svuoto tutte le caselle di testo della schermata di login
		emailLogin.setText("");
		passwordLogin.setText("");
		erroriLogin.setText("");
	}
	
	//metodo per cambiare pannello da login a admin o utente
	public void toAccount() throws IOException{
		//ricavo la password dal jpasswordfield
		String password = new String(passwordLogin.getPassword());
		//controllo se sono stati inseriti tutti i campi richiesti
		if(emailLogin.getText().equals("") || password.trim().isEmpty()) {
			//messaggio d'errore e impedisco il passaggio alla pagina successiva
			erroriLogin.setText("Riempire tutti i campi richiesti!");
			return;
		}
		//controllo che esista l'account con le credenziali indicate
		String answer = accessoAccount(password);
		String[] account = answer.split(";");
		if(account[3].equals("vero")) return;
		
		//aggiorno la pagina di gestione utenti
		Collegamenti.schermateCompl[3] = new GestioneUtenti(account[0]);
		Main.finestra.add(Collegamenti.schermateCompl[3]);
		
		//passo alla sezione admin o utente o creatore
		if(account[2].equals("Creatore") || account[2].equals("Admin")) {
			//creo la nuova schermata admin o creatore in base al privilegio che ha l'account
			Collegamenti.schermateCompl[1] = new Admin(account[2]);
			Main.finestra.add(Collegamenti.schermateCompl[1]);
			//aggiungo i prodotti già presenti dallo scorso log nel magazzino
			Collegamenti.generaMagazzino();
			Collegamenti.fromLoginToCreatoreAdmin(answer);
		} else if(account[2].equals("Utente")) {
			Collegamenti.fromLoginToUtente(answer);
		}
	}
	
	//metodo per rendere invisibile la password e viceversa
	public void toVisibilityPassLogin() {
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
		
	}
	
	
	
	//METODI PER IMPOSTARE LE ZONE DI SCRITTURA
	//metodo per impostare il campo dell'email
	public void setEmailLogin() {
		//imposto le caratteristiche della casella per l'email
		emailLogin.setOpaque(false);
		emailLogin.setBorder(null);
		emailLogin.setFont(new Font("Arial", Font.PLAIN, 20));
		emailLogin.setBounds(543, 357, 230, 30);
		//faccio in modo che, se cliccato invio, passi al jtextfield successivo
		emailLogin.addActionListener(e -> {
			passwordLogin.requestFocusInWindow();
		});
		
		schermataLogin.add(emailLogin);
	}
	//metodo per impostare il campo della password
	public void setPasswordLogin() {
		//imposto le caratteristiche della casella per la password
		passwordLogin.setOpaque(false);
		passwordLogin.setBorder(null);
		passwordLogin.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordLogin.setBounds(543, 446, 197, 30);
		//faccio in modo che, se cliccato invio, passi alla pagina successiva
		passwordLogin.addActionListener(e -> {
			try{
				toAccount();
			}catch(IOException ioe) {
				System.out.println("boh non so che mettere tanto non serve");
			}
		});
		
		schermataLogin.add(passwordLogin);
	}
	
	
	
	//METODI DI CONTROLLO
	//metodo per controllare se sono state inserite le credenziali giuste dell'account
	public String accessoAccount(String password) throws IOException{
		//stringa usata per restituire due risultati contemporaneamente
		String risultato = "";
		//variabile usata per capire se esiste l'account indicato
		boolean ok = true;
		//variabile usata per salvarmi ogni riga del file txt
		String riga = "";
		//creo l'oggetto che legge il file txt
		lettura = new BufferedReader(new FileReader("Credenziali.txt"));
		//controllo ogni riga del file txt
		while ((riga = lettura.readLine()) != null) {
			//creo un array dove ogni componente contiene un'informazione dell'account sapendo le loro posizioni
			String[] credenziali = riga.split(";");
			//controllo se l'email usata esiste
			if(emailLogin.getText().equals(credenziali[1])) {
				//controllo se a quella email è associata la password inserita
				if(password.trim().equals(credenziali[2])) {
					ok = false;
					//mi salvo se l'account è utente o admin
					risultato = credenziali[0]+";"+credenziali[1]+";"+credenziali[3] +";";
				}
			}
		}
		//chiudo la lettura
		lettura.close();
		//se vale false significa che l'account non esiste oppure o la password o l'email sono sbagliati
		if(ok) {
			//messaggio d'errore e impedisco il passaggio alla pagina successiva
			erroriLogin.setText("Email o password errati!");
			risultato = "null;null;null;vero";
		} else {
			risultato = risultato +"falso";
		}
		return risultato;
	}
	
	public void resetLoginLabel() {
		passwordLogin.setText("");
		emailLogin.setText("");
		erroriLogin.setText("");
	}
	
	//metodo per restituire il jlabel degli errori
	public static void setTestoErroriLogin(String testo) {
		erroriLogin.setText(testo);
	}
	
	
	
	//METODI DI CONTROLLO TASTIERA
	//metodo per controllare quando è stato cliccato enter
	@Override
	public void keyPressed(KeyEvent e) {
		//controllo se è stato cliccato invio
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			//controllo se uno dei due componenti ha il focus
			if(emailLogin.hasFocus() || passwordLogin.hasFocus()) {
				//controllo se è il campo email ad avere il focus
				if(emailLogin.hasFocus()) {
					//passo il focus al campo email
					passwordLogin.requestFocusInWindow();
				} else {
					//controllo se è il campo password ad avere il focus
					if(passwordLogin.hasFocus()) {
						//passo alla schermata successiva
						try{
							toAccount();
						}catch(IOException ioe) {
							System.out.println("boh non so che mettere tanto non serve");
						}
					}
				}
			}
		}
	}
	//metodi non utilizzati
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	
}
