package main;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Login extends JPanel{

	//VARIABILI DI ISTANZA
	//bottoni che uso per passare da un pannello a un altro
	private JButton confermaLogin = new JButton();
	private JButton confermaSignup = new JButton();
	private JButton signin = new JButton();
	//bottoni per scegliere se la password è visibile oppure no
	private JButton passwordVisibleLogin = new JButton();
	private JButton passwordVisibleSignup = new JButton();
	//jlabel usati per lo sfondo di ogni schermata pannello
	private JLabel schermataLogin = new JLabel();
	private JLabel schermataSignup = new JLabel();
	//jtextfield usati per inserire i diversi campi (username, email e password)
	private JTextField emailLogin = new JTextField();
	private JPasswordField passwordLogin = new JPasswordField();
	private JTextField usernameSignup = new JTextField();
	private JTextField emailSignup = new JTextField();
	private JPasswordField passwordSignup = new JPasswordField();
	//immagini del bottone per nascondere la password
	private ImageIcon nascosta;
	private ImageIcon visibile;
	//salvo il carattere usato di default per mascherare la password
	private char charHidden = passwordLogin.getEchoChar();
	//creo le variabili per poter gli oggetti per interagire con il file txt
	private BufferedWriter scrittura;
	private BufferedReader lettura;
	//jlabel usati per mandare eventuali messaggi d'errore
	private JLabel erroriLogin = new JLabel();
	private JLabel erroriSignup = new JLabel();
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
		
		//creo le diverse "schermate" in modo tale da aggiornare la finestra in automatico quando viene cliccato un bottone
		creaLogin();
		creaSignin();
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
	//metodo per creare il pannello di signin
	public void creaSignin() {
		//creo e imposto il pannello che corrisponde alla schermata di signin
		schermate[1] = new JPanel();
		schermate[1].setLayout(null);
		schermate[1].setBounds(0, 0, 1331, 768);
		//imposto lo sfondo
		setSchermataSignin();
		//imposto la sezione dei messaggi d'errore
		setErroriSignin();
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
	
	
	
	//METODI PER IMPOSTARE I JLABEL
	//metodo per impostare lo sfondo del pannello login
	public void setSchermataLogin() {
		//imposto lo sfondo
		schermataLogin.setBounds(0, 0, 1331, 768);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("SchermataLogin.png"));
		schermataLogin.setIcon(immagine);
		schermate[0].add(schermataLogin);
	}
	//metodo per impostare lo sfondo del pannello signin
	public void setSchermataSignin() {
		//imposto lo sfondo
		schermataSignup.setBounds(0, 0, 1331, 768);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("SchermataSignin.png"));
		schermataSignup.setIcon(immagine);
		schermate[1].add(schermataSignup);
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
	//metodo per impostare il messaggio d'errore signin
	public void setErroriSignin() {
		//imposto le caratteristiche della casella per gli errori
		erroriSignup.setFont(new Font("Arial", Font.BOLD, 24));
		erroriSignup.setHorizontalAlignment(SwingConstants.CENTER);		
		erroriSignup.setBounds(0, 632, 1331, 30);
		
		//erroriSignin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		schermataSignup.add(erroriSignup);
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
		passwordVisibleLogin.addActionListener(e -> toVisibilityPass());
		schermataLogin.add(passwordVisibleLogin);
	}
	//metodo per impostare il bottone della visibilità della password
	public void setBottonePasswordSignin() {
		//imposto le caratteristiche del bottone
		passwordVisibleSignup.setContentAreaFilled(false);
		passwordVisibleSignup.setBorderPainted(false);
		passwordVisibleSignup.setBorder(null);
		passwordVisibleSignup.setBounds(740, 533, 33, 33);
		//imposto l'immagine da dargli
		passwordVisibleSignup.setIcon(nascosta);
		//aggiungo un actionlistener per cambiare pannello
		passwordVisibleSignup.addActionListener(e -> toVisibilityPass());
		schermataSignup.add(passwordVisibleSignup);
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
	//metodo per cambiare pannello da signup a login
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
			erroriLogin.setText("Account creato con successo!");
		} else {
			return;
		}
		
		//rendo visibile solo la schermata di login
		schermate[0].setVisible(true);
		schermate[1].setVisible(false);
		//svuoto tutte le caselle di testo della schermata di login
		usernameSignup.setText("");
		emailSignup.setText("");
		passwordSignup.setText("");
		erroriSignup.setText("");
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
		
		//passo alla sezione admin o utente
		if(account[2].equals("Admin")) {
			Collegamenti.fromLoginToAdmin(answer);
		} else {
			Collegamenti.fromLoginToUtente(answer);
		}
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
		usernameSignup.setOpaque(false);
		usernameSignup.setBorder(null);
		usernameSignup.setFont(new Font("Arial", Font.PLAIN, 20));
		usernameSignup.setBounds(543, 357, 230, 30);

		schermataSignup.add(usernameSignup);
	}
	//metodo per impostare il campo dell'email
	public void setEmailSignin() {
		//imposto le caratteristiche della casella per l'email
		emailSignup.setOpaque(false);
		emailSignup.setBorder(null);
		emailSignup.setFont(new Font("Arial", Font.PLAIN, 20));
		emailSignup.setBounds(543, 446, 230, 30);

		schermataSignup.add(emailSignup);
	}
	//metodo per impostare il campo della password
	public void setPasswordSignin() {
		//imposto le caratteristiche della casella per la password
		passwordSignup.setOpaque(false);
		passwordSignup.setBorder(null);
		passwordSignup.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordSignup.setBounds(543, 535, 197, 30);

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
				//controllo che il formato della email inserita sia valido
				if(checkFormatoEmail() == false) {
					//messaggio d'errore e impedisco il passaggio alla pagina successiva
					erroriSignup.setText("Email non valida!");
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
		return ok;
	}
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
			risultato = "null;vero";
		} else {
			risultato = risultato +"falso";
		}
		return risultato;
	}
	//metodo per controllare se il formato dell'email è corretto
	public boolean checkFormatoEmail() {
		boolean ok = true;
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
				ok = false;
			}
		} else {
			ok = false;
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
			//controllo quale delle due schermate è attiva
			if(schermate[0].isVisible()) {
				//controllo se la email inserita è già stata usata (login)
				if(emailLogin.getText().equals(credenziali[1])) {
					//interrompo i controlli e confermo la presenza di un account con quella email
					ok = true;
					break;
				}
			} else {
				//controllo se la email inserita è già stata usata (signin)
				if(emailSignup.getText().equals(credenziali[1])) {
					//interrompo i controlli e impedisco la creazione dell'account
					ok = true;
					break;
				}
			}
		}
		//chiudo la lettura
		lettura.close();
		return ok;
	}
	
	public void resetLoginLabel() {
		passwordLogin.setText("");
		emailLogin.setText("");
	}
	
	
	 


}
