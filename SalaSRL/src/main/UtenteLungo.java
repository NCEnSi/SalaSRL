package main;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class UtenteLungo extends JPanel{
	
	//VARIABILI DI ISTANZA
	//jlabel che contiene lo username
	private JLabel username = new JLabel();
	//bottoni per mostrare il grado dell'account
	private JButton utente = new JButton();
	private JButton admin = new JButton();
	private JButton creatore = new JButton();
	//variabili booleane usate per abilitare e non i bottoni
	private boolean utenteEnabled;
	private boolean adminEnabled;
	private boolean creatoreEnabled;
	//variabile usata come appoggio per poter caricare le immagini sui bottoni
	private ImageIcon immagine;
	//creo le variabili per poter gli oggetti per interagire con il file txt
	private BufferedWriter scrittura;
	private BufferedReader lettura;
	
	
	//COSTRUTTORE
	public UtenteLungo(int prY, String nome, String priv, boolean attivo) {	
		//setto il Panel
		setLayout(null);
		setBounds(0, prY, 1249, 60);
		setOpaque(false);
		
		//imposto la scitta del nome dell'account
		setUsername(nome);
		//imposto i bottoni utente, admin e creatore
		setBottoneUtente(priv, attivo);
		setBottoneAdmin(priv, attivo);
		setBottoneCreatore(priv, attivo);
	}
	
	
	//METODI DI ISTANZA
	//metodo per mostrare il nome username dell'account
	public void setUsername(String nome) {
		//posizione della jlabel
		username.setBounds(20, 5, 560, 50);
		//caratteristiche della jlabel
		username.setBackground(null);
		username.setFont(new Font("Open Sans", Font.BOLD, 31));
		username.setForeground(Color.WHITE);
		username.setHorizontalAlignment(JLabel.LEFT);
		//assegno l'username
		username.setText(nome);
		
		add(username);
	}
	//metodo per impostare il bottone utente
	public void setBottoneUtente(String priv, boolean attivo) {
		//imposto le caratteristiche del bottone
		utente.setContentAreaFilled(false);
		utente.setBorderPainted(false);
		utente.setBounds(602, 5, 202, 50);
		//controllo se il bottone deve essere attivo oppure no
		if(priv.equals("Utente")) {
			//imposto l'immagine da dargli
			immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoUtentePress.png"));
			utente.setIcon(immagine);
			//disabilito il bottone
			utenteEnabled = false;
		} else {
			//imposto l'immagine da dargli
			immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoUtente.png"));
			utente.setIcon(immagine);
			//abilito il bottone
			utenteEnabled = true;
		}
		//imposto l'immagine da dargli
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoUtentePress.png"));
		utente.setPressedIcon(immagine);
		
		utente.addActionListener(e -> {
			try {
				//controllo se l'account sta provando a modificare il suo stesso privilegio
				if(attivo) {
					//prima controllo se il bottone è abilitato o no
					if(utenteEnabled) modifyInUtente();
				}
			}catch(IOException ioe) {
				System.out.println("boh non so che mettere tanto non serve");
			}
		});
		add(utente);
	}
	//metodo per impostare il bottone admin
	public void setBottoneAdmin(String priv, boolean attivo) {
		//imposto le caratteristiche del bottone
		admin.setContentAreaFilled(false);
		admin.setBorderPainted(false);
		admin.setBounds(824, 5, 202, 50);
		//controllo se il bottone deve essere attivo oppure no
		if(priv.equals("Admin")) {
			//imposto l'immagine da dargli
			immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoAdminPress.png"));
			admin.setIcon(immagine);
			//disabilito il bottone
			adminEnabled = false;
		} else {
			//imposto l'immagine da dargli
			immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoAdmin.png"));
			admin.setIcon(immagine);
			//abilito il bottone
			adminEnabled = true;
		}
		//imposto l'immagine da dargli
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoAdminPress.png"));
		admin.setPressedIcon(immagine);
		
		admin.addActionListener(e -> {
			try {
				//controllo se l'account sta provando a modificare il suo stesso privilegio
				if(attivo) {
					//prima controllo se il bottone è abilitato o no
					if(adminEnabled) modifyInAdmin();
				}
			}catch(IOException ioe) {
				System.out.println("boh non so che mettere tanto non serve");
			}
		});
		add(admin);
	}
	//metodo per impostare il bottone creatore
	public void setBottoneCreatore(String priv, boolean attivo) {
		//imposto le caratteristiche del bottone
		creatore.setContentAreaFilled(false);
		creatore.setBorderPainted(false);
		creatore.setBounds(1046, 5, 202, 50);
		//controllo se il bottone deve essere attivo oppure no
		if(priv.equals("Creatore")) {
			//imposto l'immagine da dargli
			immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoCreatorePress.png"));
			creatore.setIcon(immagine);
			//disabilito il bottone
			creatoreEnabled = false;
		} else {
			//imposto l'immagine da dargli
			immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoCreatore.png"));
			creatore.setIcon(immagine);
			//abilito il bottone
			creatoreEnabled = true;
		}
		//imposto l'immagine da dargli
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoCreatorePress.png"));
		creatore.setPressedIcon(immagine);
		
		creatore.addActionListener(e -> {
			try {
				//controllo se l'account sta provando a modificare il suo stesso privilegio
				if(attivo) {
					//prima controllo se il bottone è abilitato o no
					if(creatoreEnabled) modifyInCreatore();	
				}
			}catch(IOException ioe) {
				System.out.println("boh non so che mettere tanto non serve");
			}
		});
		add(creatore);
	}
	
	//metodo per impostare l'account ad utente
	public void modifyInUtente() throws IOException{
		//modifico l'immagine in modo che sia mostrata quella più scura
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoUtentePress.png"));
		utente.setIcon(immagine);
		
		//modifico l'immagine in modo che sia mostrata quella più chiara
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoAdmin.png"));
		admin.setIcon(immagine);
		
		//modifico l'immagine in modo che sia mostrata quella più chiara
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoCreatore.png"));
		creatore.setIcon(immagine);
		
		//disabilito il bottone e riattivo gli altri
		utenteEnabled = false;
		adminEnabled = true;
		creatoreEnabled = true;
		
		//modifico opportunamente il file txt
		modificaFileTxt("Utente");
	}
	//metodo per impostare l'account ad admin
	public void modifyInAdmin() throws IOException{
		//modifico l'immagine in modo che sia mostrata quella più chiara
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoUtente.png"));
		utente.setIcon(immagine);
		
		//modifico l'immagine in modo che sia mostrata quella più scura
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoAdminPress.png"));
		admin.setIcon(immagine);
		
		//modifico l'immagine in modo che sia mostrata quella più chiara
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoCreatore.png"));
		creatore.setIcon(immagine);
		
		//disabilito il bottone e riattivo gli altri
		utenteEnabled = true;
		adminEnabled = false;
		creatoreEnabled = true;
		
		//modifico opportunamente il file txt
		modificaFileTxt("Admin");
	}
	//metodo per impostare l'account a creatore
	public void modifyInCreatore() throws IOException{
		//modifico l'immagine in modo che sia mostrata quella più chiara
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoUtente.png"));
		utente.setIcon(immagine);
		
		//modifico l'immagine in modo che sia mostrata quella più chiara
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoAdmin.png"));
		admin.setIcon(immagine);
		
		//modifico l'immagine in modo che sia mostrata quella più scura
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoCreatorePress.png"));
		creatore.setIcon(immagine);
		
		//disabilito il bottone e riattivo gli altri
		utenteEnabled = true;
		adminEnabled = true;
		creatoreEnabled = false;
		
		//modifico opportunamente il file txt
		modificaFileTxt("Creatore");
	}
	
	//metodo per modificare il file txt
	public void modificaFileTxt(String nuovoPriv) throws IOException{
		//oggetto per leggere tutto il file
		lettura = new BufferedReader(new FileReader("Credenziali.txt"));
		//array dove salvo ogni riga letta in un arraylist
		ArrayList<String> righe = new ArrayList<>();
		//ciclo per salvare ogni riga
		String riga;
		//controllo ogni riga del file txt
		while ((riga = lettura.readLine()) != null) {
			//creo un array dove ogni componente contiene un'informazione dell'account sapendo le loro posizioni
			String[] credenziali = riga.split(";");
			//controllo se la modifica da effettuare riguarda questo account
			if(credenziali[0].equals(username.getText())) {
				//modifico il privilegio dell'account
				credenziali[3] = nuovoPriv;
			}
			//ricreo la riga
			riga = credenziali[0] +";"+ credenziali[1] +";"+ credenziali[2] +";"+ credenziali[3];
			//salvo la riga nell'array
			righe.add(riga);
		}
		//chiudo la lettura
		lettura.close();
		
		//oggetto per riscrivere tutto il file
		scrittura = new BufferedWriter(new FileWriter("Credenziali.txt"));
		//ciclo per riscrivere tutto il file
		for(int i = 0; i < righe.size(); i++) {
			//scrivo la prima riga nel file
			scrittura.write(righe.get(i));
			//evito di lasciare una riha vuota finale
			if(i < righe.size()-1) {
				scrittura.newLine();
			}
		}
		scrittura.close();		
	}
	
	
	
	
	
	
	
	
	
}
