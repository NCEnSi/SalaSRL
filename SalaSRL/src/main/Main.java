package main;
import java.io.*;
import javax.swing.*;

public class Main {
	public static void main(String[] nmf) throws IOException {
		JFrame frame = new JFrame();
		frame.setResizable(false);
		//1331 e 807 sono le grandezze definitive (mangia rispettivamente 16 e 39 px)
		frame.setSize(1331, 807);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setLayout(null);
		
		Login login = new Login();
		frame.add(login);
		
		//ProdottoQuadrato prod = new ProdottoQuadrato(0, 0, "Pomodoro");
		//frame.add(prod);
		
		//ProdottoLungo prod = new ProdottoLungo(0, 0, "Pomodoro");
		//frame.add(prod);
		
		//Admin admin = new Admin();
		//frame.add(admin);
		frame.setVisible(true);
	}
}
