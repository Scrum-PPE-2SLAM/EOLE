import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Accueil extends JFrame{
	private JLabel JImageBateau = new JLabel(new ImageIcon("bateau2.gif"));
	private JPanel cpImage = new JPanel();
	Window window;
	
	
	public Accueil(Window window){
		this.window= window;
	}
	
	public void createAccueil(){
		this.cpImage.setBounds(0, 0, window.getWidth(), window.getHeight());
		this.cpImage.add(JImageBateau);
		
		
		JButton btnValider = new JButton("Valider ");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnValider.setBounds(440, 440, 115, 30);
		cpImage.add(btnValider);
		this.window.add(cpImage);
	}

	
}
