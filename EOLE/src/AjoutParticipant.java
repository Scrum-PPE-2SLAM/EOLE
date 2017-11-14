import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class AjoutParticipant extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel panelInfoRegate;
	private JLabel lblNomRegate, lblDate, lblLieuDepart, lblLieuArrivee, lblDistance;
	private JTextField tfNomRegate, tfLieuDepart, tfLieuArrivee, tfDistance;
	private JDateChooser cboDate;
	private Window window;

	public AjoutParticipant(Window window) {
		this.window = window;
	}
	
	public void creationPanelInfoRegate() {
		this.panelInfoRegate = new JPanel();
		this.panelInfoRegate.setBorder(new TitledBorder(null, "R\u00E9gate", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelInfoRegate.setBounds(10, 79, 370, 234);
		this.window.add(panelInfoRegate);
		
		this.lblNomRegate = new JLabel("Nom de la régate : ");
		this.lblNomRegate.setBounds(29, 21, 96, 43);
		this.lblDate = new JLabel("Date : ");
		this.lblDate.setBounds(87, 52, 38, 43);
		this.lblLieuDepart = new JLabel("Lieu de départ : ");
		this.lblLieuDepart.setBounds(46, 92, 79, 43);
		this.lblLieuArrivee = new JLabel("Lieu d'arrivée : ");
		this.lblLieuArrivee.setBounds(51, 130, 74, 43);
		this.lblDistance = new JLabel("Distance : ");
		this.lblDistance.setBounds(68, 165, 57, 43);
		this.tfNomRegate = new JTextField(15); 
		this.tfNomRegate.setEditable(false);
		this.tfNomRegate.setBounds(135, 29, 185, 26);
		this.tfLieuDepart = new JTextField(15);
		this.tfLieuDepart.setEditable(false);
		this.tfLieuDepart.setBounds(135, 100, 185, 26);
		this.tfLieuArrivee = new JTextField(15);
		this.tfLieuArrivee.setEditable(false);
		this.tfLieuArrivee.setBounds(135, 138, 185, 26);
		this.tfDistance = new JTextField(15);
		this.tfDistance.setEditable(false);
		this.tfDistance.setBounds(135, 173, 185, 26);
		this.cboDate = new JDateChooser();
		this.cboDate.setBounds(135, 64, 118, 26);
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
}
