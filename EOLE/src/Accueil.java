import java.awt.Font;
import java.awt.Window;

import javax.swing.*;

public class Accueil extends JFrame{
	private Window window;
	private JLabel JImageBateau = new JLabel(new ImageIcon("bateau2.gif"));
	private JPanel cpImage = new JPanel();
	
	public Accueil(Window window){
		this.window= window;
	}
	
	public void createAccueil(){
		this.cpImage.setBounds(0, 0, window.getWidth(), window.getHeight());
		this.cpImage.add(JImageBateau);
		this.window.add(cpImage);
	}

}
