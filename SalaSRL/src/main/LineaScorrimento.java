package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LineaScorrimento extends JPanel{
	
	/*//panel per contenere il tasto
	private JLabel base = new JLabel();
	//tasto per scorrere un JScrollPane
	private JLabel tastoScorrimento = new JLabel();
	//variabili per inserire le immagini
	private ImageIcon icon;
	private Image iconScaled;
	//variabili per spostare il JScrollPane
	Point xyVecchia;
	int yNuova, xNuova;
	//suddividendo la base e il JScrollPane associato in 100 celle riesco ad associare il movimento di uno al movimento dell'altro
	private double cellaScroll;
	private double cellaScorrimento;
	//variabile usata per non far scattare tastoScorrimento
	private boolean stoScorrendo = false;
	//variabili da settare con switch in base al tipo
	private int grandezza, altezza, yMaxTastoScorrimento, yMaxScrollPane;

	//costruttore, richiede (coordinata x, coordinata y, JScrollPane che sposta)
	public LineaScorrimento(int x, int y, JScrollPane scroll, String tipo) {
		//switch per decidere che tipo di LineaScorrimento inserire
		switch(tipo) {
		case "AdminCatalogo":
			grandezza = 26;
			altezza = 661;
			yMaxTastoScorrimento = 618;
			yMaxScrollPane = 7037;
			break;
		case "AdminCarrello":
			grandezza = 26;
			altezza = 568;
			yMaxTastoScorrimento = 525;
			yMaxScrollPane = 11126;
			break;
		}
		//setto il Panel
		setLayout(null);
		setBounds(x, y, grandezza, altezza);
		//setto i vari componenti
		setTastoScorrimento(scroll);
		setBase(tipo);
	}
	
	public void setBase(String tipo) {
		//imposto coordinate e grandezza della label
		base.setBounds(0, 0, grandezza, altezza);
		//imposto l'immagine da dargli	
		icon = new ImageIcon(getClass().getClassLoader().getResource("baseScorrimento"+tipo+".png"));
		iconScaled = icon.getImage().getScaledInstance(grandezza, altezza, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		base.setIcon(icon);
		add(base);
	}
	
	public void setTastoScorrimento(JScrollPane scroll) {
		//imposto coordinate e grandezza della label
		tastoScorrimento.setBounds(3, 3, 20, 40);
		//imposto l'immagine da dargli	
		icon = new ImageIcon(getClass().getClassLoader().getResource("TastoPerScorrere.png"));
		iconScaled = icon.getImage().getScaledInstance(20, 40, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		tastoScorrimento.setIcon(icon);
		//aggiungo un mousemotionlistener e un mouselistener per aggiornare il JScrollPane associato
		tastoScorrimento.addMouseListener(new MouseAdapter() {
			@Override
			//prendo la vecchia posizione di tastoScorrimento
			public void mousePressed(MouseEvent e) {
				xyVecchia = e.getPoint();
			}
		});
		tastoScorrimento.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				stoScorrendo = true;
				scorri(e);
				//uso la y trovata per muovere tastoScorrimento
				tastoScorrimento.setLocation(3, yNuova);
				setYScrollPane(scroll);
				stoScorrendo = false;
				}
		});
		add(tastoScorrimento);
	}
	
	//metodo per ricavare la nuova y di tastoScorrimento
	public void scorri(MouseEvent e) {
		yNuova = (int) (tastoScorrimento.getY() + e.getY() - xyVecchia.getY());
		if(yNuova<3) {
			yNuova = 3;
		} else if(yNuova>yMaxTastoScorrimento) {
			yNuova = yMaxTastoScorrimento;
		}
	}
	
	//metodo per settare la posizione dello scrollPane associato
	public void setYScrollPane(JScrollPane scroll) {
		cellaScorrimento = yNuova / (yMaxTastoScorrimento/100) - 1;
		cellaScroll = cellaScorrimento * (yMaxScrollPane/100);
		if(cellaScorrimento == 99) {
			scroll.getVerticalScrollBar().setValue(yMaxScrollPane);
		} else {
			scroll.getVerticalScrollBar().setValue((int) cellaScroll);
		}
	}
	
	//metodo per reimpostare la posizione del tastoScorrimento, se si inserisce "yes" la posizione viene moltiplicata per 6 altrimenti no (usato per gli estremi del JSCrollPane)
	public void setYTastoScorrimento(int n, String yes) {
		if(yes.equals("yes")) {
			n = n * (yMaxTastoScorrimento/100);
		}
		tastoScorrimento.setLocation(3, n);
	}
	
	//metodo per ottenere il valore di stoScorrendo
	public boolean getStoScorrendo() {
		return stoScorrendo;
	}*/
	
}
