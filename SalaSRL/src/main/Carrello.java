package main;

import java.awt.*;
import javax.swing.*;

public class Carrello extends JPanel{
	
	//button per cambiare schermata
	private JButton magazzinoCar = new JButton();
	private JButton catalogoCar = new JButton();
	//button per aprire info profilo
	private JButton immagineProfiloCar = new JButton();
	//label per evidenziare schermata attuale
	private JLabel carrelloAttuale = new JLabel();
	//label per coprire
	private JLabel copriLineaCar = new JLabel();
	//label di contorno
	private JLabel strisciaSuperioreCar = new JLabel();
	//label dove verrà visualizzato il carrello
	private JLabel baseCarrello = new JLabel();
	//variabili usate per mettere le immagini
	private ImageIcon icon;
	private Image iconScaled;

	//costruttore per creare la schermata del carrello
	public Carrello() {
		//setto il Panel
		setLayout(null);
		setBounds(0, 0, 1331, 768);
		//setto i vari componenti
		setImmagineProfiloCar();
		setCopriLineaCarrello();
		setBaseCarrello();
		setMagazzinoCar();
		setCatalogoCar();
		setCarrelloAttuale();
		setStrisciaSuperioreCar();
		setVisible(false);
		
	}
	
	//metodo per settare il button MagazzinoCar
	public void setMagazzinoCar() {
		//imposto le caratteristiche del bottone
		magazzinoCar.setContentAreaFilled(false);		
		magazzinoCar.setBorderPainted(false);
		magazzinoCar.setBounds(0, 60, 439, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzinoPress.png"));
		iconScaled = icon.getImage().getScaledInstance(439, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		magazzinoCar.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzino.png"));
		iconScaled = icon.getImage().getScaledInstance(439, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		magazzinoCar.setIcon(icon);
		add(magazzinoCar);
	}

	//metodo per settare il button catalogoCar
	public void setCatalogoCar() {
		//imposto le caratteristiche del bottone
		catalogoCar.setContentAreaFilled(false);		
		catalogoCar.setBorderPainted(false);
		catalogoCar.setBounds(439, 60, 438, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCatalogoPress.png"));
		iconScaled = icon.getImage().getScaledInstance(438, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		catalogoCar.setPressedIcon(icon);
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCatalogo.png"));
		iconScaled = icon.getImage().getScaledInstance(438, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		catalogoCar.setIcon(icon);
		add(catalogoCar);
	}
	
	//metodo per settare la label carrelloAttuale
	public void setCarrelloAttuale() {
		//imposto coordinate e grandezza della label
		carrelloAttuale.setBounds(877, 60, 438, 36);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCarrelloAttuale.png"));
		iconScaled = icon.getImage().getScaledInstance(438, 36, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		carrelloAttuale.setIcon(icon);
		add(carrelloAttuale);
	}
	
	//metodo per settare la label strisciaSuperioreCar
	public void setStrisciaSuperioreCar() {
		//imposto coordinate e grandezza della label
		strisciaSuperioreCar.setBounds(0, 0, 1331, 107);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("StrisciaSuperiore.png"));
		strisciaSuperioreCar.setIcon(icon);
		add(strisciaSuperioreCar);
	}
	
	//metodo per settare la label copriLineaCar
	public void setCopriLineaCarrello() {
		//imposto coordinate e grandezza della label
		copriLineaCar.setBounds(879, 95, 434, 11);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("CopriLineaCatalogoCarrello.png"));
		iconScaled = icon.getImage().getScaledInstance(434, 11, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		copriLineaCar.setIcon(icon);
		add(copriLineaCar);
	}
	
	//metodo per settare la label baseCarrello
	public void setBaseCarrello() {
		//imposto coordinate e grandezza della label
		baseCarrello.setBounds(0, 96, 1315, 672);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoCatalogoCarrello.png"));
		baseCarrello.setIcon(icon);
		add(baseCarrello);
	}
	
	//metodo per settare il button immagineProfiloCar
	public void setImmagineProfiloCar() {
		//imposto le caratteristiche del bottone
		immagineProfiloCar.setContentAreaFilled(false);		
		immagineProfiloCar.setBorderPainted(false);
		immagineProfiloCar.setBounds(1255, 2, 56, 56);
		//imposto l'immagine da dargli
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfiloPress.png"));
		immagineProfiloCar.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfilo.png"));
		immagineProfiloCar.setIcon(icon);
		//aggiungo un actionlistener per aprire scheda profilo
		//carrello.addActionListener(e -> piuUno(nomeProdotto));
		add(immagineProfiloCar);
	}
	
	public JButton getMagazzinoCar() {
		return magazzinoCar;
	}
	
	public JButton getCatalogoCar() {
		return catalogoCar;
	}
	
}
