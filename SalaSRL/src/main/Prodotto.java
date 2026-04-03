package main;

import java.awt.*;
import javax.swing.*;

public class Prodotto extends JPanel{
	
	private JLabel sfondo = new JLabel();
	private JLabel img = new JLabel();
	private JLabel title = new JLabel();
	private JLabel N = new JLabel("0");
	private JLabel sfondoN = new JLabel();
	private JButton piu = new JButton();
	private JButton meno = new JButton();
	private JButton buy = new JButton();
	private ImageIcon icon;
	private Image iconScaled;
	private int nAttuale = 0;
	private int nProdotti = 0;
	
	//coordinate, nome Immagine prodotto, nome Immagine nome prodotto, nome prodotto
	public Prodotto(int prX, int prY, String prImg, String prTitle, String nomeProdotto) {	
		setLayout(null);
		setBounds(prX, prY, 243, 243);
		setImg(prImg);
		setTitle(prTitle);
		setSfondoN();
		setPiu(nomeProdotto);
		setMeno(nomeProdotto);
		setBuy(nomeProdotto);
		setSfondo();
	}
	
	public void setSfondo() {
		sfondo.setBounds(0, 0, 243, 243);
		icon = new ImageIcon(getClass().getClassLoader().getResource("SfondoProdotto.png"));
		sfondo.setIcon(icon);
		add(sfondo);
	}
	
	public void setImg(String img) {
		this.img.setBounds(62, 62, 117, 121);
		icon = new ImageIcon(getClass().getClassLoader().getResource(img));
		this.img.setIcon(icon);
		add(this.img);
	}

	public void setTitle(String title) {
		this.title.setBounds(35, 14, 173, 38);
		icon = new ImageIcon(getClass().getClassLoader().getResource(title));
		iconScaled = icon.getImage().getScaledInstance(173, 38, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		this.title.setIcon(icon);
		add(this.title);
	}
	
	public void setSfondoN() {
		sfondoN.setBounds(140, 190, 38, 38);
		icon = new ImageIcon(getClass().getClassLoader().getResource("nProdotto.png"));
		iconScaled = icon.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		sfondoN.setIcon(icon);
		N.setBounds(140, 190, 38, 38);
		N.setFont(new Font("Arial", Font.PLAIN, 24));
		N.setHorizontalAlignment(JLabel.CENTER);
		N.setBackground(null);
		add(N);
		add(sfondoN);
	}
	
	public void setPiu(String nomeProdotto) {
		piu.setContentAreaFilled(false);		
		piu.setBorderPainted(false);
		piu.setBounds(183, 190, 38, 38);
		icon = new ImageIcon(getClass().getClassLoader().getResource("PiuProdottoPress.png"));
		iconScaled = icon.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		piu.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("PiuProdotto.png"));
		iconScaled = icon.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		piu.setIcon(icon);
		piu.addActionListener(e -> piuUno(nomeProdotto));
		add(piu);
	}
	
	public void setMeno(String nomeProdotto) {
		meno.setContentAreaFilled(false);		
		meno.setBorderPainted(false);
		meno.setBounds(97, 190, 38, 38);
		icon = new ImageIcon(getClass().getClassLoader().getResource("MenoProdottoPress.png"));
		iconScaled = icon.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		meno.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("MenoProdotto.png"));
		iconScaled = icon.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		meno.setIcon(icon);
		meno.addActionListener(e -> menoUno(nomeProdotto));
		add(meno);
	}
	
	public void setBuy(String nomeProdotto) {	
		buy.setContentAreaFilled(false);		
		buy.setBorderPainted(false);
		buy.setBounds(23, 190, 38, 38);
		icon = new ImageIcon(getClass().getClassLoader().getResource("BuyProdottoPress.png"));
		iconScaled = icon.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		buy.setPressedIcon(icon);	
		icon = new ImageIcon(getClass().getClassLoader().getResource("BuyProdotto.png"));
		iconScaled = icon.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconScaled);
		buy.setIcon(icon);
		buy.addActionListener(e -> buy(nomeProdotto));
		add(buy);
	}
	
	public void piuUno(String nomeProdotto) {
		nAttuale++;
		if(nAttuale>9) {
			nAttuale = 9;
		}
		N.setText(""+nAttuale);
		System.out.println("Stai comprando "+nAttuale+" "+nomeProdotto);
	}
	
	public void menoUno(String nomeProdotto) {
		nAttuale--;
		if(nAttuale<0) {
			nAttuale = 0;
		}
		N.setText(""+nAttuale);
		System.out.println("Stai comprando "+nAttuale+" "+nomeProdotto);
	}
	
	public void buy(String nomeProdotto) {
		nProdotti += nAttuale;
		if(nProdotti<0) {
			nProdotti = 0;
		}
		System.out.println("In totale hai comprato "+nProdotti+" "+nomeProdotto);
	}
	
	public static void main(String[]gg) {
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(1331, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setLayout(null);
		Admin admin = new Admin();
		frame.add(admin);
		frame.setVisible(true);
	}
}
