package main;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Logout extends JPanel{

	//VARIABILI DI ISTANZA
	//jlabel usata per impostare lo sfondo del pannello logout
	private JLabel schermataLogout = new JLabel();
	//bottone per effettuare il logout
	private JButton logout = new JButton();
	//bottone per chiudere il pannello di logout
	private JButton chiudiLogout = new JButton();
	//label per inserire i dati dell'utente
	private JLabel labelNomeUtente = new JLabel();
	private JLabel labelPrivilegiUtente = new JLabel();
	private JLabel labelEmailUtente = new JLabel();
	//variabile usata come appoggio per poter caricare le immagini
	private ImageIcon immagine;
	private Image immScalata;
	//array che contiene il nome dei prodotti messi nel carrello
	private ArrayList<InformazioniDaPassare> resetProdottiNelCarrello = new ArrayList<>();
	
	//COSTRUTTORE
	public Logout() {
		//setto il Panel	
		setLayout(null);
		setOpaque(false);
		setBounds(920, 2, 391, 190);
		//imposto i bottoni del pannello
		setBottoneChiudiLogout();
		setBottoneLogout();
		//imposto le scritte del pannello
		setLabelNomeUtente();
		setLabelPrivilegiUtente();
		setLabelEmailUtente();
		//imposto lo sfondo
		setSchermataLogout();
		
	}
	
	//METODI DI ISTANZA	
	//metodo per impostare lo sfondo del pannello logout
	public void setSchermataLogout() {
		//imposto lo sfondo
		schermataLogout.setBounds(0, 0, 391, 190);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("SfondoPanelLogout.png"));
		schermataLogout.setIcon(immagine);
		add(schermataLogout);
	}
	
	//metodo per impostare le caratteristiche del bottone per chiudere il pannello
	public void setBottoneChiudiLogout() {
		//imposto le caratteristiche del bottone
		chiudiLogout.setContentAreaFilled(false);
		chiudiLogout.setBorderPainted(false);
		chiudiLogout.setBounds(12, 12, 37, 37);
		//carico sul bottone le immagini per il tasto di chiusura
		immagine = new ImageIcon(getClass().getClassLoader().getResource("EscPanelLogout.png"));
		immScalata = immagine.getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		chiudiLogout.setIcon(immagine);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("EscPanelLogoutPress.png"));
		immScalata = immagine.getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		chiudiLogout.setPressedIcon(immagine);	
		//aggiungo un actionlistener per cambiare pannello
		chiudiLogout.addActionListener(e -> Collegamenti.fromLogoutToOther());
		add(chiudiLogout);
	}
	//metodo per impostare le caratteristiche del bottone per il logout
	public void setBottoneLogout() {
		//imposto le caratteristiche del bottone
		logout.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		logout.setBounds(12, 141, 128, 37);
		//carico sul bottone le immagini per il tasto di chiusura
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoLogout.png"));
		immScalata = immagine.getImage().getScaledInstance(128, 37, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		logout.setIcon(immagine);
		immagine = new ImageIcon(getClass().getClassLoader().getResource("TastoLogoutPress.png"));
		immScalata = immagine.getImage().getScaledInstance(128, 37, Image.SCALE_SMOOTH);
		immagine = new ImageIcon(immScalata);
		logout.setPressedIcon(immagine);
		add(logout);
	}
	
	public void setLabelNomeUtente() {
		//imposto coordinate e grandezza della label
		labelNomeUtente.setBounds(0, 10, 391, 25);
		//personalizzo la label e il suo testo
		labelNomeUtente.setBackground(null);
		labelNomeUtente.setFont(new Font("Arial", Font.BOLD, 26));
		labelNomeUtente.setHorizontalAlignment(JLabel.CENTER);
		add(labelNomeUtente);
	}
	
	public void setLabelPrivilegiUtente() {
		//imposto coordinate e grandezza della label
		labelPrivilegiUtente.setBounds(0, 36, 391, 16);
		//personalizzo la label e il suo testo
		labelPrivilegiUtente.setBackground(null);
		labelPrivilegiUtente.setFont(new Font("Arial", Font.BOLD, 17));
		labelPrivilegiUtente.setHorizontalAlignment(JLabel.CENTER);
		add(labelPrivilegiUtente);
	}
	
	public void setLabelEmailUtente() {
		//imposto coordinate e grandezza della label
		labelEmailUtente.setBounds(151, 142, 221, 30);
		//personalizzo la label e il suo testo
		labelEmailUtente.setBackground(null);
		labelEmailUtente.setFont(new Font("Arial", Font.BOLD, 20));
		labelEmailUtente.setHorizontalAlignment(JLabel.RIGHT);
		add(labelEmailUtente);
	}
	
	public void setLabelTesto(String nomeUtente, String privilegi, String email) {
		labelNomeUtente.setText(nomeUtente);
		labelPrivilegiUtente.setText(privilegi);
		labelEmailUtente.setText(email);
	}
	
	public JButton getLogout() {
		return logout;
	}
	
	public void resetProdottiCarrello(ArrayList<InformazioniDaPassare> prodottiNelCarrello, JPanel panel) {
		prodottiNelCarrello.clear();
		panel.removeAll();
	}
	
}
