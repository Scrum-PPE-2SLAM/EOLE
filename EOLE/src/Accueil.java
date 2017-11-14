import java.awt.Font;

import javax.swing.*;

public class Accueil extends JFrame{
	private Window window;
	private JLabel JImageBateau= new JLabel(new ImageIcon("bateau2.gif"));
	private JPanel panImage;
	private JLabel lblTitle;
	
	public Accueil(Window window){
		this.window= window;
	}
	
	public void createAccueil(){
		panImage = new JPanel();
		panImage.add(JImageBateau);
		panImage.setLayout(null);
		this.window.add(panImage);
		
		lblTitle = new JLabel("AJOUT PARTICIPANT");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTitle.setBounds(10, 14, 744, 32);
		this.panImage.add(lblTitle);
		
	
	}

}
