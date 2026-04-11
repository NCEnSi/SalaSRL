package main;
import java.awt.event.*;

public class InvioTastieraLoginSignup implements KeyListener{

	@Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Tasto premuto: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Tasto rilasciato: " + e.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Tasto digitato: " + e.getKeyChar());
    }
	
	
	
	
	
}
