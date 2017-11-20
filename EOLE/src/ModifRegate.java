import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ModifRegate extends JFrame {

	private static final long serialVersionUID = 1L;
	private Window window;
	private JLabel lblSelRegate;
	private JComboBox<String> cboSelRegate;
	private AjoutRegate ajoutRegate;
	
	public ModifRegate(Window window) {
		this.window = window;
		
		ajoutRegate = new AjoutRegate(window);
		ajoutRegate.creationPanelAjoutRegate();
		ajoutRegate.creationPanelTableau();
		ajoutRegate.creationPanelTitre("MODIFICATION REGATE");
	}
	
	public void ajoutCombo(String[] listeRegate) {
		
		this.lblSelRegate = new JLabel("Selectionner la régate à modifier : ");
		this.lblSelRegate.setBounds(175, 68, 380, 14);
		this.ajoutRegate.panelTitreRegate.add(lblSelRegate);
		
		this.cboSelRegate = new JComboBox<String>(listeRegate);
		this.cboSelRegate.setBounds(383, 65, 161, 20);
		this.ajoutRegate.panelTitreRegate.add(cboSelRegate);
	}
	
}