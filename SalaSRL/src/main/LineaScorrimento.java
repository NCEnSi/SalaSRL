package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LineaScorrimento extends JPanel {

	//label per contenere lo sfondo della scrollbar
    private JLabel base = new JLabel();
    //label per il tasto che scorre
    private JLabel tastoScorrimento = new JLabel();
    //variabili usate per inserire le immagini
    private ImageIcon icon;
    private Image iconScaled;
    //variabile che contiene la posizione prima che tastoScorrimento venga spostato
    private Point xyVecchia;
    //variabile che contiene la posizione dopo che tastoScorrimento venga spostato
    private int yNuova;
    //rapporto pixel del tastoScorrimento rispetto al scrollpane
    private double cellaScroll;
    //boolean per non far scattare tastoScorrimento
    private boolean stoScorrendo = false;
    //variabili contenente le varie coordinate e grandezze
    private int grandezza, altezza, yMaxTastoScorrimento, yMaxScrollPane;

    //costruttore
    public LineaScorrimento(int x, int y, JScrollPane scroll, String tipo, int yMaxScrollPane) {
    	//in base al tipo di pagina si usa una stringa diversa
    	this.yMaxScrollPane = yMaxScrollPane;
        switch (tipo) {
        case "AdminCatalogo":
            grandezza = 26;
            altezza = 661;
            break;
        case "AdminCarrello":
            grandezza = 26;
            altezza = 568;
            break;
        case "GestioneUtenti":
            grandezza = 26;
            altezza = 688;
            break;
        case "UtenteCatalogo":
            grandezza = 26;
            altezza = 629;
            break;
        case "UtenteCarrello":
            grandezza = 26;
            altezza = 514;
            break;
        }
        //calcolo il rapposto
        yMaxTastoScorrimento = altezza - 43;
        cellaScroll = (double) yMaxScrollPane / (yMaxTastoScorrimento - 3);
        //setto il pane
        setLayout(null);
        setBounds(x, y, grandezza, altezza);
        setTastoScorrimento(scroll);
        setBase(tipo);
    }

    //setto base
    public void setBase(String tipo) {
        base.setBounds(0, 0, grandezza, altezza);
        icon = new ImageIcon(getClass().getClassLoader().getResource("baseScorrimento" + tipo + ".png"));
        iconScaled = icon.getImage().getScaledInstance(grandezza, altezza, Image.SCALE_SMOOTH);
        icon = new ImageIcon(iconScaled);
        base.setIcon(icon);
        add(base);
    }

    //setto tastoScorrimento
    public void setTastoScorrimento(JScrollPane scroll) {
        tastoScorrimento.setBounds(3, 3, 20, 40);
        icon = new ImageIcon(getClass().getClassLoader().getResource("TastoPerScorrere.png"));
        iconScaled = icon.getImage().getScaledInstance(20, 40, Image.SCALE_SMOOTH);
        icon = new ImageIcon(iconScaled);
        tastoScorrimento.setIcon(icon);
        //gli aggiungo un listener per prendere la posizione prima che venga spostato
        tastoScorrimento.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xyVecchia = e.getPoint();
            }
        });
        //gli aggiungo un listener per spostare tastoScorrimento e di conseguenza la scrollpane
        tastoScorrimento.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                stoScorrendo = true;
                scorri(e);
                tastoScorrimento.setLocation(3, yNuova);
                setYScrollPane(scroll);
                stoScorrendo = false;
            }
        });

        //gli aggiungo un listener per spostare tastoScorrimento se muovo lo scrollpane con la rotellina
        scroll.getVerticalScrollBar().addAdjustmentListener(e -> {
        	//if per non creare conflitti tra rotellina e spostamento
            if (!stoScorrendo) {
                int scrollVal = scroll.getVerticalScrollBar().getValue();
                //faccio la conversione opposta
                int nuovaYTasto = (int) (scrollVal / cellaScroll) + 3;
                if(nuovaYTasto<3) {
                	nuovaYTasto = 3;
                } else if(nuovaYTasto>yMaxTastoScorrimento) {
                	nuovaYTasto = yMaxTastoScorrimento;
                }
                //setto la nuova posizione del tastoScorrimento
                tastoScorrimento.setLocation(3, nuovaYTasto);
            }
        });

        add(tastoScorrimento);
    }

    //metodo per calcolare la nuova posizione di tastoScorrimento
    public void scorri(MouseEvent e) {
        yNuova = (int) (tastoScorrimento.getY() + e.getY() - xyVecchia.getY());
        if(yNuova<3) {
        	yNuova = 3;
        } else if(yNuova>yMaxTastoScorrimento) {
        	yNuova = yMaxTastoScorrimento;
        }
    }

    //metodo per settare l'alteza di visualizzazione del scrollpane
    public void setYScrollPane(JScrollPane scroll) {
    	//calcolo posizione tasto
        int posizioneTasto = yNuova - 3;
        //se è uguale a 0 lo setta a 0
        if (posizioneTasto <= 0) {
            scroll.getVerticalScrollBar().setValue(0);
        //se è uguale al massimo setta l'altezza al massimo
        } else if (yNuova >= yMaxTastoScorrimento) {
            scroll.getVerticalScrollBar().setValue(yMaxScrollPane);
        //altrimenti adegua tramite operazione
        } else {
            int valoreScroll = (int) (posizioneTasto * cellaScroll);
            scroll.getVerticalScrollBar().setValue(valoreScroll);
        }
    }

    //metodo per restituire stoScorrendo
    public boolean getStoScorrendo() {
        return stoScorrendo;
    }
    
    public void modifyYMaxScrollPane(int yMaxScrollPane) {
    	this.yMaxScrollPane = yMaxScrollPane;
        cellaScroll = (double) yMaxScrollPane / (yMaxTastoScorrimento - 3);
    }
}