package main;

import java.awt.Image;
import javax.swing.*;

public class Admin extends JPanel {

	private JButton catalogoMag = new JButton();
	private JButton carrelloMag = new JButton();
	private JButton MagazzinoCat = new JButton();
	private JButton carrelloCat = new JButton();
	private JButton MagazzinoCar = new JButton();
	private JButton catalogoCar = new JButton();
	private JButton immagineProfiloMag = new JButton();
	private JButton immagineProfiloCat = new JButton();
	private JButton immagineProfiloCar = new JButton();
	private JLabel magazzinoAttuale = new JLabel();
	private JLabel catalogoAttuale = new JLabel();
	private JLabel carrelloAttuale = new JLabel();
	private JLabel copriLineaMag = new JLabel();
	private JLabel copriLineaCat = new JLabel();
	private JLabel copriLineaCar = new JLabel();
	private JLabel luogoProdotti = new JLabel();
	private JLabel spazioMagazzino = new JLabel();
	private JLabel strisciaSuperioreMag = new JLabel();
	private JLabel strisciaSuperioreCat = new JLabel();
	private JLabel strisciaSuperioreCar = new JLabel();
	private JLabel baseCatalogo = new JLabel();
	private JLabel baseCarrello = new JLabel();
	private JPanel[] schermate = new JPanel[3];
	private ImageIcon icon;
	private Image iconScaled;

	public Admin() {	
		setLayout(null);
		setBounds(0, 0, 1331, 768);
		creaMagazzino();
		creaCatalogo();
		creaCarrello();
	}
	
	public void creaMagazzino() {
		schermate[0] = new JPanel();
		schermate[0].setLayout(null);
		schermate[0].setBounds(0, 0, 1331, 768);
		setImmagineProfiloMag();
		setCopriLineaMagazzino();
		setLuogoProdotti();
		setSpazioMagazzino();
		setCatalogoMag();
		setCarrelloMag();
		setMagazzinoAttuale();
		setStrisciaSuperioreMag();
		add(schermate[0]);
	}
	
	public void creaCatalogo() {
		schermate[1] = new JPanel();
		schermate[1].setLayout(null);
		schermate[1].setBounds(0, 0, 1331, 768);
		setImmagineProfiloCat();
		setCopriLineaCatalogo();
		setBaseCatalogo();
		setMagazzinoCat();
		setCarrelloCat();
		setCatalogoAttuale();
		setStrisciaSuperioreCat();
		add(schermate[1]);
		schermate[1].setVisible(false);
	}
	
	public void creaCarrello() {
		schermate[2] = new JPanel();
		schermate[2].setLayout(null);
		schermate[2].setBounds(0, 0, 1331, 768);
		setImmagineProfiloCar();
		setCopriLineaCarrello();
		setBaseCarrello();
		setMagazzinoCar();
		setCatalogoCar();
		setCarrelloAttuale();
		setStrisciaSuperioreCar();
		add(schermate[2]);
		schermate[2].setVisible(false);
		
	}
	
	public void setCatalogoMag() {
		catalogoMag.setContentAreaFilled(false);		
		catalogoMag.setBorderPainted(false);
		catalogoMag.setBounds(439, 60, 438, 157);
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCatalogoPress.png"));
		catalogoMag.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCatalogo.png"));
		catalogoMag.setIcon(icon);
		catalogoMag.addActionListener(e -> changeInCatalogo());
		schermate[0].add(catalogoMag);
	}
	
	public void setCarrelloMag() {
		carrelloMag.setContentAreaFilled(false);		
		carrelloMag.setBorderPainted(false);
		carrelloMag.setBounds(877, 60, 438, 157);
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCarrelloPress.png"));
		carrelloMag.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCarrello.png"));
		carrelloMag.setIcon(icon);
		carrelloMag.addActionListener(e -> changeInCarrello());
		schermate[0].add(carrelloMag);
	}
	
	public void setMagazzinoCat() {
		MagazzinoCat.setContentAreaFilled(false);		
		MagazzinoCat.setBorderPainted(false);
		MagazzinoCat.setBounds(0, 60, 439, 157);
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzinoPress.png"));
		MagazzinoCat.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzino.png"));
		MagazzinoCat.setIcon(icon);
		MagazzinoCat.addActionListener(e -> changeInMagazzino());
		schermate[1].add(MagazzinoCat);
	}
	
	public void setCarrelloCat() {
		carrelloCat.setContentAreaFilled(false);		
		carrelloCat.setBorderPainted(false);
		carrelloCat.setBounds(877, 60, 438, 157);
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCarrelloPress.png"));
		carrelloCat.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCarrello.png"));
		carrelloCat.setIcon(icon);
		carrelloCat.addActionListener(e -> changeInCarrello());
		schermate[1].add(carrelloCat);
	}
	
	public void setMagazzinoCar() {
		MagazzinoCar.setContentAreaFilled(false);		
		MagazzinoCar.setBorderPainted(false);
		MagazzinoCar.setBounds(0, 60, 439, 157);
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzinoPress.png"));
		MagazzinoCar.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzino.png"));
		MagazzinoCar.setIcon(icon);
		MagazzinoCar.addActionListener(e -> changeInMagazzino());
		schermate[2].add(MagazzinoCar);
	}
	
	public void setCatalogoCar() {
		catalogoCar.setContentAreaFilled(false);		
		catalogoCar.setBorderPainted(false);
		catalogoCar.setBounds(439, 60, 438, 157);
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCatalogoPress.png"));
		catalogoCar.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCatalogo.png"));
		catalogoCar.setIcon(icon);
		catalogoCar.addActionListener(e -> changeInCatalogo());
		schermate[2].add(catalogoCar);
	}
	
	public void setImmagineProfiloMag() {
		immagineProfiloMag.setContentAreaFilled(false);		
		immagineProfiloMag.setBorderPainted(false);
		immagineProfiloMag.setBounds(1255, 2, 56, 56);
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfiloPress.png"));
		immagineProfiloMag.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfilo.png"));
		immagineProfiloMag.setIcon(icon);
		//carrello.addActionListener(e -> piuUno(nomeProdotto));
		schermate[0].add(immagineProfiloMag);
	}
	
	public void setImmagineProfiloCat() {
		immagineProfiloCat.setContentAreaFilled(false);		
		immagineProfiloCat.setBorderPainted(false);
		immagineProfiloCat.setBounds(1255, 2, 56, 56);
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfiloPress.png"));
		immagineProfiloCat.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfilo.png"));
		immagineProfiloCat.setIcon(icon);
		//carrello.addActionListener(e -> piuUno(nomeProdotto));
		schermate[1].add(immagineProfiloCat);
	}
	
	public void setImmagineProfiloCar() {
		immagineProfiloCar.setContentAreaFilled(false);		
		immagineProfiloCar.setBorderPainted(false);
		immagineProfiloCar.setBounds(1255, 2, 56, 56);
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfiloPress.png"));
		immagineProfiloCar.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("ImmagineProfilo.png"));
		immagineProfiloCar.setIcon(icon);
		//carrello.addActionListener(e -> piuUno(nomeProdotto));
		schermate[2].add(immagineProfiloCar);
	}
	
	public void setMagazzinoAttuale() {
		magazzinoAttuale.setBounds(0, 60, 439, 157);
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneMagazzinoAttuale.png"));
		magazzinoAttuale.setIcon(icon);
		schermate[0].add(magazzinoAttuale);
	}
	
	public void setCatalogoAttuale() {
		catalogoAttuale.setBounds(439, 60, 438, 157);
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCatalogoAttuale.png"));
		catalogoAttuale.setIcon(icon);
		schermate[1].add(catalogoAttuale);
	}
	
	public void setCarrelloAttuale() {
		carrelloAttuale.setBounds(877, 60, 438, 157);
		icon = new ImageIcon(getClass().getClassLoader().getResource("BottoneCarrelloAttuale.png"));
		carrelloAttuale.setIcon(icon);
		schermate[2].add(carrelloAttuale);
	}
	
	public void setStrisciaSuperioreMag() {
		strisciaSuperioreMag.setBounds(0, 0, 1331, 107);
		icon = new ImageIcon(getClass().getClassLoader().getResource("StrisciaSuperiore.png"));
		strisciaSuperioreMag.setIcon(icon);
		schermate[0].add(strisciaSuperioreMag);
	}
	
	public void setStrisciaSuperioreCat() {
		strisciaSuperioreCat.setBounds(0, 0, 1331, 107);
		icon = new ImageIcon(getClass().getClassLoader().getResource("StrisciaSuperiore.png"));
		strisciaSuperioreCat.setIcon(icon);
		schermate[1].add(strisciaSuperioreCat);
	}
	
	public void setStrisciaSuperioreCar() {
		strisciaSuperioreCar.setBounds(0, 0, 1331, 107);
		icon = new ImageIcon(getClass().getClassLoader().getResource("StrisciaSuperiore.png"));
		strisciaSuperioreCar.setIcon(icon);
		schermate[2].add(strisciaSuperioreCar);
	}
	
	public void setCopriLineaMagazzino() {
		copriLineaMag.setBounds(2, 95, 435, 5);
		icon = new ImageIcon(getClass().getClassLoader().getResource("CopriLineaMagazzino.png"));
		iconScaled = icon.getImage().getScaledInstance(435, 5, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		copriLineaMag.setIcon(icon);
		schermate[0].add(copriLineaMag);
	}
	
	public void setCopriLineaCatalogo() {
		copriLineaCat.setBounds(441, 95, 434, 11);
		icon = new ImageIcon(getClass().getClassLoader().getResource("CopriLineaCatalogoCarrello.png"));
		iconScaled = icon.getImage().getScaledInstance(434, 11, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		copriLineaCat.setIcon(icon);
		schermate[1].add(copriLineaCat);
	}
	
	public void setCopriLineaCarrello() {
		copriLineaCar.setBounds(879, 95, 434, 11);
		icon = new ImageIcon(getClass().getClassLoader().getResource("CopriLineaCatalogoCarrello.png"));
		iconScaled = icon.getImage().getScaledInstance(434, 11, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		copriLineaCar.setIcon(icon);
		schermate[2].add(copriLineaCar);
	}
	
	public void setLuogoProdotti() {
		luogoProdotti.setBounds(0, 152, 1315, 619);
		icon = new ImageIcon(getClass().getClassLoader().getResource("LuogoProdotti.png"));
		luogoProdotti.setIcon(icon);
		schermate[0].add(luogoProdotti);
	}
	
	public void setSpazioMagazzino() {
		spazioMagazzino.setBounds(0, 96, 1315, 58);
		icon = new ImageIcon(getClass().getClassLoader().getResource("SpazioMagazzino.png"));
		spazioMagazzino.setIcon(icon);
		schermate[0].add(spazioMagazzino);
	}
	
	public void setBaseCatalogo() {
		baseCatalogo.setBounds(0, 96, 1315, 675);
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoCatalogoCarrello.png"));
		baseCatalogo.setIcon(icon);
		schermate[1].add(baseCatalogo);
	}
	
	public void setBaseCarrello() {
		baseCarrello.setBounds(0, 96, 1315, 675);
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoCatalogoCarrello.png"));
		baseCarrello.setIcon(icon);
		schermate[2].add(baseCarrello);
	}
	
	public void changeInMagazzino() {
		schermate[0].setVisible(true);
		schermate[1].setVisible(false);
		schermate[2].setVisible(false);
	}
	
	public void changeInCatalogo() {
		schermate[0].setVisible(false);
		schermate[1].setVisible(true);
		schermate[2].setVisible(false);
	}
	
	public void changeInCarrello() {
		schermate[0].setVisible(false);
		schermate[1].setVisible(false);
		schermate[2].setVisible(true);
	}
	
}
