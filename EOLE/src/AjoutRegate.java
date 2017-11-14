import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class AjoutRegate extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel panelInfoRegate, panelTableParticipant, panelTitreRegate;
	private JLabel lblNomRegate, lblDate, lblLieuDepart, lblLieuArrivee, lblDistance, lblSelRegate;
	private JTextField tfNomRegate, tfLieuDepart, tfLieuArrivee, tfDistance;
	private JDateChooser cboDate;
	private Window window;

	public AjoutRegate(Window window) {
		this.window = window;
	}
	
	public void creationPanelAjoutRegate() {
		this.panelInfoRegate = new JPanel();
		this.panelInfoRegate.setBorder(new TitledBorder(null, "R\u00E9gate", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelInfoRegate.setBounds(10, 98, 370, 320);
		this.window.add(panelInfoRegate);
		
		this.lblNomRegate = new JLabel("Nom de la régate : ");
		this.lblNomRegate.setBounds(29, 70, 116, 43);
		this.lblDate = new JLabel("Date : ");
		this.lblDate.setBounds(97, 110, 58, 53);
		this.lblLieuDepart = new JLabel("Lieu de départ : ");
		this.lblLieuDepart.setBounds(40, 150, 99, 43);
		this.lblLieuArrivee = new JLabel("Lieu d'arrivée : ");
		this.lblLieuArrivee.setBounds(40, 190, 94, 43);
		this.lblDistance = new JLabel("Distance : ");
		this.lblDistance.setBounds(68, 230, 77, 43);
		this.tfNomRegate = new JTextField(15); 
		this.tfNomRegate.setBounds(145, 80, 185, 26);
		this.tfLieuDepart = new JTextField(15);
		this.tfLieuDepart.setBounds(145, 160, 185, 26);
		this.tfLieuArrivee = new JTextField(15);
		this.tfLieuArrivee.setBounds(145, 200, 185, 26);
		this.tfDistance = new JTextField(15);
		this.tfDistance.setBounds(145, 240, 185, 26);
		this.cboDate = new JDateChooser();
		this.cboDate.setBounds(145, 120, 118, 26);
		this.panelInfoRegate.setLayout(null);
		
		this.panelInfoRegate.add(lblNomRegate);
		this.panelInfoRegate.add(tfNomRegate);
		this.panelInfoRegate.add(lblDate);
		this.panelInfoRegate.add(cboDate);
		this.panelInfoRegate.add(lblLieuDepart);
		this.panelInfoRegate.add(tfLieuDepart);
		this.panelInfoRegate.add(lblLieuArrivee);
		this.panelInfoRegate.add(tfLieuArrivee);
		this.panelInfoRegate.add(lblDistance);
		this.panelInfoRegate.add(tfDistance);
	}
	
	public void creationPanelTableau() {
		
		this.panelTableParticipant = new JPanel();
		this.panelTableParticipant.setBorder(new TitledBorder(null, "Participants", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelTableParticipant.setBounds(404, 98, 370, 320);
		this.window.add(panelTableParticipant);
		this.panelTableParticipant.setLayout(null);
	}
	
	public void creationPanelTitre() {
		panelTitreRegate = new JPanel();
		panelTitreRegate.setBounds(10, 11, 764, 57);
		window.add(panelTitreRegate);
		panelTitreRegate.setLayout(null);
		
		lblSelRegate = new JLabel("AJOUT NOUVELLE REGATE ");
		lblSelRegate.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelRegate.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblSelRegate.setBounds(10, 14, 744, 32);
		panelTitreRegate.add(lblSelRegate);
	}
}
