package main;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class Signup extends JPanel implements KeyListener{

	//VARIABILI DI ISTANZA
	//bottone che uso per passare da un pannello a un altro
	private JButton confermaSignup = new JButton();
	//bottone per scegliere se la password è visibile oppure no
	private JButton passwordVisibleSignup = new JButton();
	//jlabel usato per lo sfondo di ogni schermata pannello
	private JLabel schermataSignup = new JLabel();
	//jtextfield usati per inserire i diversi campi (username, email e password)
	private JTextField usernameSignup = new JTextField();
	private JTextField emailSignup = new JTextField();
	private JPasswordField passwordSignup = new JPasswordField();
	//jbutton per tornare alla schermata di login
	private JButton indietroSignup = new JButton();
	//immagini del bottone per nascondere la password
	private ImageIcon nascosta;
	private ImageIcon visibile;
	//salvo il carattere usato di default per mascherare la password
	private char charHidden = passwordSignup.getEchoChar();
	//creo le variabili per gli oggetti per interagire con il file txt
	private BufferedWriter scrittura;
	private BufferedReader lettura;
	//jlabel usati per mandare eventuali messaggi d'errore
	private JLabel erroriSignup = new JLabel();
	//variabile usata come appoggio per poter caricare le immagini sui bottoni
	private ImageIcon immagine;
	private Image immScalata;
	//array che contiene le due schermate pannelli
	private JPanel[] schermate;
		
	
	
	//COSTRUTTORE
	public Signup(JPanel[] sc) throws IOException {
		schermate = sc;
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
		
		//imposto lo sfondo
		setSchermataSignup();
		//imposto la sezione dei messaggi d'errore
		setErroriSignup();
		//imposto i bottoni		
		setBottoneConfermaToLogin();
		setBottoneIndietro();
		setBottonePasswordSignup();
		//imposto i diversi campi dove inserire i dati richiesti
		setUsernameSignup();
		setEmailSignup();
		setPasswordSignup();
		
		requestFocusInWindow();
		//faccio in modo che all'inizio non sia visibile in quanto c'è quella di login
		setVisible(false);
	}
	
	
	
	//METODI
	//metodo per impostare lo sfondo del pannello signin
	public void setSchermataSignup() {
		//imposto lo sfondo
		schermataSignup.setBounds(0, 0, 1331, 768);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("SchermataSignup.png"));
		schermataSignup.setIcon(immagine);
		add(schermataSignup);
	}	
	//metodo per impostare il messaggio d'errore signin
	public void setErroriSignup() {
		//imposto le caratteristiche della casella per gli errori
		erroriSignup.setFont(new Font("Arial", Font.BOLD, 24));
		erroriSignup.setHorizontalAlignment(SwingConstants.CENTER);		
		erroriSignup.setBounds(0, 632, 1331, 30);
		
		//erroriSignin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		schermataSignup.add(erroriSignup);
	}
	
	
	
	//METODI PER IMPOSTARE I BOTTONI
	//metodo per impostare il bottone conferma
	public void setBottoneConfermaToLogin() {
		//imposto le caratteristiche del bottone
		confermaSignup.setContentAreaFilled(false);
		confermaSignup.setBorderPainted(false);
		confermaSignup.setBounds(687, 587, 94, 31);
		//imposto l'immagine da dargli
		immagine = new ImageIcon(getClass().getClassLoader().getResource("ConfermaSigninLogin.png"));
		immScalata = immagine.getImage().getScaledInstance(94, 31, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		confermaSignup.setIcon(immagine);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("ConfermaSigninLoginPress.png"));
		immScalata = immagine.getImage().getScaledInstance(94, 31, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		confermaSignup.setPressedIcon(immagine);	
		//aggiungo un actionlistener per cambiare pannello
		confermaSignup.addActionListener(e -> {
			try {
				toLogin();
			}catch(IOException ioe) {
				System.out.println("boh non so che mettere tanto non serve");
			}
		});
		schermataSignup.add(confermaSignup);
	}
	//metodo per impostare il bottone per tornare alla schermata di login
	public void setBottoneIndietro() {
		//imposto le caratteristiche del bottone
		indietroSignup.setContentAreaFilled(false);
		indietroSignup.setBorderPainted(false);
		indietroSignup.setBorder(null);
		indietroSignup.setBounds(534, 587, 77, 31);
		//imposto l'immagine da dargli
		immagine = new ImageIcon(getClass().getClassLoader().getResource("Indietro.png"));
		immScalata = immagine.getImage().getScaledInstance(77, 31, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		indietroSignup.setIcon(immagine);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("IndietroPress.png"));
		immScalata = immagine.getImage().getScaledInstance(77, 31, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		indietroSignup.setPressedIcon(immagine);
		//aggiungo un actionlistener per cambiare pannello
		indietroSignup.addActionListener(e -> backToLogin());
		schermataSignup.add(indietroSignup);
	}
	//metodo per impostare il bottone della visibilità della password
	public void setBottonePasswordSignup() {
		//imposto le caratteristiche del bottone
		passwordVisibleSignup.setContentAreaFilled(false);
		passwordVisibleSignup.setBorderPainted(false);
		passwordVisibleSignup.setBorder(null);
		passwordVisibleSignup.setBounds(740, 533, 33, 33);
		//imposto l'immagine da dargli
		passwordVisibleSignup.setIcon(nascosta);
		//aggiungo un actionlistener per cambiare pannello
		passwordVisibleSignup.addActionListener(e -> toVisibilityPassSignup());
		schermataSignup.add(passwordVisibleSignup);
	}
	
	//metodo per cambiare pannello da signup a login 
	public void backToLogin() {
		//faccio in modo che si vedi solo la schermata di login
		schermate[0].setVisible(true);
		schermate[1].setVisible(false);
		
		//svuoto tutte le caselle di testo della schermata di signup
		usernameSignup.setText("");
		emailSignup.setText("");
		passwordSignup.setText("");
		erroriSignup.setText("");
	}
	
	//metodo per cambiare pannello da signup a login quando crei un account
	public void toLogin() throws IOException{
		//controllo se è possibile salvare o no l'account
		if(creaAccount()) {
			//creo l'oggetto usato per salvare le diverse informazioni degli account
			scrittura = new BufferedWriter(new FileWriter("Credenziali.txt", true));
			//ricavo la password dal jpasswordfield
			String password = new String(passwordSignup.getPassword());			
			//salvo le diverse informazioni sul file txt
			String account = usernameSignup.getText() +";"+ emailSignup.getText() +";"+ password +";Utente";
			scrittura.newLine();
			scrittura.write(account);
			scrittura.close();
			//invio un messaggio di conferma
			Login.setTestoErroriLogin("Account creato con successo!");
		} else {
			return;
		}
		
		//rendo visibile solo la schermata di login
		schermate[0].setVisible(true);
		schermate[1].setVisible(false);
		//svuoto tutte le caselle di testo della schermata di signup
		usernameSignup.setText("");
		emailSignup.setText("");
		passwordSignup.setText("");
		erroriSignup.setText("");
	}
	
	//metodo per rendere invisibile la password e viceversa
	public void toVisibilityPassSignup() {
		//controllo se la password attualmente è nascosta oppure no
		if(passwordVisibleSignup.getIcon() == nascosta) {
			//modifico l'immagine del bottone
			passwordVisibleSignup.setIcon(visibile);
			//modifico la visibilità della password
			passwordSignup.setEchoChar((char) 0);
		} else {
			//modifico l'immagine del bottone
			passwordVisibleSignup.setIcon(nascosta);
			//modifico la visibilità della password
			passwordSignup.setEchoChar(charHidden);
		}
	}
	
	
	
	//METODI PER IMPOSTARE LE ZONE DI SCRITTURA
	//metodo per impostare il campo dell'username
	public void setUsernameSignup() {
		//imposto le caratteristiche della casella per l'username
		usernameSignup.setOpaque(false);
		usernameSignup.setBorder(null);
		usernameSignup.setFont(new Font("Arial", Font.PLAIN, 20));
		usernameSignup.setBounds(543, 357, 230, 30);
		//faccio in modo che, se cliccato invio, passi al jtextfield successivo
		usernameSignup.addActionListener(e -> {
			emailSignup.requestFocusInWindow();
		});
				
		schermataSignup.add(usernameSignup);
	}
	//metodo per impostare il campo dell'email
	public void setEmailSignup() {
		//imposto le caratteristiche della casella per l'email
		emailSignup.setOpaque(false);
		emailSignup.setBorder(null);
		emailSignup.setFont(new Font("Arial", Font.PLAIN, 20));
		emailSignup.setBounds(543, 446, 230, 30);
		//faccio in modo che, se cliccato invio, passi al jtextfield successivo
		emailSignup.addActionListener(e -> {
			passwordSignup.requestFocusInWindow();
		});
				
		schermataSignup.add(emailSignup);
	}
	//metodo per impostare il campo della password
	public void setPasswordSignup() {
		//imposto le caratteristiche della casella per la password
		passwordSignup.setOpaque(false);
		passwordSignup.setBorder(null);
		passwordSignup.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordSignup.setBounds(543, 535, 197, 30);
		//faccio in modo che, se cliccato invio, passi alla pagina successiva
		passwordSignup.addActionListener(e -> {
			try {
				toLogin();
			}catch(IOException ioe) {
				System.out.println("boh non so che mettere tanto non serve");
			}
		});
		
		schermataSignup.add(passwordSignup);
	}
	
	
	
	//METODI DI CONTROLLO
	//metodo per creare un nuovo account
	public boolean creaAccount() throws IOException{
		boolean ok = true;
		//ricavo la password dal jpasswordfield
		String password = new String(passwordSignup.getPassword());
		//controllo se sono stati inseriti tutti i campi richiesti
		if(usernameSignup.getText().equals("") || emailSignup.getText().equals("") || password.trim().isEmpty()) {
			//messaggio d'errore e impedisco il passaggio alla pagina successiva
			erroriSignup.setText("Riempire tutti i campi richiesti!");
			ok = false;
		} else {
			//controllo che non esista già un account con lo stesso username
			if(checkPresenzaUsername()) {
				//messaggio d'errore e impedisco il passaggio alla pagina successiva
				erroriSignup.setText("Account con questo username già esistente!");
				//impedisco che venga salvato l'account
				ok = false;
			} else {
				//controllo che non sia troppo lungo l'username
				if(checkFormatoUsername()) {
					//messaggio d'errore e impedisco il passaggio alla pagina successiva
					erroriSignup.setText("Username troppo lungo!");
					//impedisco che venga salvato l'account
					ok = false;
				} else {
					//controllo che il formato della email inserita sia valido
					if(checkFormatoEmail() == false) {
						//impedisco che venga salvato l'account
						ok = false;
					} else {
						//controllo che non esista già un account con la stessa email
						if(checkPresenzaEmail()) {
							//messaggio d'errore e impedisco il passaggio alla pagina successiva
							erroriSignup.setText("Account con questa email già esistente!");
							//impedisco che venga salvato l'account
							ok = false;
						}
					}
				}
			}
		}
		return ok;
	}
	//metodo per controllare se il formato dell'email è corretto
	public boolean checkFormatoEmail() {
		boolean ok = true;
		//controllo se il numero di caratteri della email non sia troppo lungo
		if(emailSignup.getText().length() < 17) {
			//divido l'email in due token usando il simbolo @
			StringTokenizer email = new StringTokenizer(emailSignup.getText(), "@");
			//controllo se sono presenti solo due token
			if(email.countTokens() == 2) {
				//scarto il primo token, ovvero la prima parte della mail
				email.nextToken();
				//divido la seconda parte della mail
				StringTokenizer secondaParte = new StringTokenizer(email.nextToken(), ".");
				//controllo se ci sono almeno due parti, quindi se è presente almeno 1 punto
				if(secondaParte.countTokens() >= 2) {
					ok = true;
				} else {
					//messaggio d'errore e impedisco il passaggio alla pagina successiva
					erroriSignup.setText("Email non valida!");
					ok = false;
				}
			} else {
				//messaggio d'errore e impedisco il passaggio alla pagina successiva
				erroriSignup.setText("Email non valida!");
				ok = false;
			}
		} else {
			//messaggio d'errore e impedisco il passaggio alla pagina successiva
			erroriSignup.setText("Email troppo lunga!");
			ok = false;
		}
		
		return ok;
	}
	//metodo per controllare se la lunghezza dell'username è corretta
	public boolean checkFormatoUsername() {
		boolean ok = false;
		//controllo che non superi 19 caratteri
		if(usernameSignup.getText().length() > 19) {
			ok = true;
		}
		return ok;
	}
	
	//metodo per controllare se esiste già un account con quell'username
	public boolean checkPresenzaUsername() throws IOException{
		boolean ok = false;
		//variabile usata per salvarmi ogni riga del file txt
		String riga = "";
		//creo l'oggetto che legge il file txt
		lettura = new BufferedReader(new FileReader("Credenziali.txt"));
		//controllo ogni riga del file txt
		while ((riga = lettura.readLine()) != null) {
			//creo un array dove ogni componente contiene un'informazione dell'account sapendo le loro posizioni
			String[] credenziali = riga.split(";");
			//controllo se l'username inserito è già stato usato
			if(usernameSignup.getText().equals(credenziali[0])) {
				//interrompo i controlli e impedisco la creazione dell'account
				ok = true;
				break;
			}
		}
		//chiudo la lettura
		lettura.close();
		return ok;
	}
	//metodo per controllare se esiste già un account con quella email
	public boolean checkPresenzaEmail() throws IOException{
		boolean ok = false;
		//variabile usata per salvarmi ogni riga del file txt
		String riga = "";
		//creo l'oggetto che legge il file txt
		lettura = new BufferedReader(new FileReader("Credenziali.txt"));
		//controllo ogni riga del file txt
		while ((riga = lettura.readLine()) != null) {
			//creo un array dove ogni componente contiene un'informazione dell'account sapendo le loro posizioni
			String[] credenziali = riga.split(";");
			//controllo se la email inserita è già stata usata (signin)
			if(emailSignup.getText().equals(credenziali[1])) {
				//interrompo i controlli e impedisco la creazione dell'account
				ok = true;
				break;
			}
		}
		//chiudo la lettura
		lettura.close();
		return ok;
	}
	
	
	
	//METODI DI CONTROLLO TASTIERA
	//metodo per controllare quando è stato cliccato enter
	@Override
	public void keyPressed(KeyEvent e) {
		//controllo se è stato cliccato invio
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			//controllo se uno dei tre componenti ha il focus
			if(usernameSignup.hasFocus() || emailSignup.hasFocus() || passwordSignup.hasFocus()) {
				//controllo se è il campo username ad avere il focus
				if(usernameSignup.hasFocus()) {
					//passo il focus al campo email
					emailSignup.requestFocusInWindow();
				} else {
					//controllo se è il campo username ad avere il focus
					if(emailSignup.hasFocus()) {
						//passo il focus al campo password
						passwordSignup.requestFocusInWindow();
					} else {
						//controllo se è il campo password ad avere il focus
						if(passwordSignup.hasFocus()) {
							//passo alla schermata successiva
							try {
								toLogin();
							}catch(IOException ioe) {
								System.out.println("boh non so che mettere tanto non serve");
							}
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
