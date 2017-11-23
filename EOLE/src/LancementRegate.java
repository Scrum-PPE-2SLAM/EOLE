import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class LancementRegate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tableParticipants;
	private JPanel panelSelRegate, panelChrono, panelInfoRegate, panelTableParticipant;
	private JLabel lblSelRegate, lblNomRegate, lblDate, lblLieuDepart, lblLieuArrivee, lblDistance, lblChrono;
	private JTextField tfNomRegate, tfLieuDepart, tfLieuArrivee, tfDistance;
	private JComboBox<String> cboSelRegate;
	private JDateChooser cboDate;
	private DTimer chrono;
	private Window window;
	private ArrayList<String> listeRegate;
	private JButton btnFin, btnReinit, btnDepart, btnSelectionner;
	private JScrollPane scrollPane;
	SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
	private Bdd maBdd;
	

	public LancementRegate(Window window, Bdd maBdd) {
		this.window = window;
		this.maBdd = maBdd;
	}
	
	public void createAll(){
		creationPanelSelRegate();
		creationPanelInfoRegate();
		creationPanelChrono();
		creationPanelTableau();
	}
	
	public void creationPanelSelRegate() {
		
		this.panelSelRegate = new JPanel();
		this.panelSelRegate.setBounds(10, 11, 764, 57);
		this.window.add(panelSelRegate);
		this.panelSelRegate.setLayout(null);
		
		this.lblSelRegate = new JLabel("Selectionner la régate à lancer : ");
		this.lblSelRegate.setBounds(217, 14, 156, 14);
		this.panelSelRegate.add(lblSelRegate);
		
		this.cboSelRegate = new JComboBox<String>(maBdd.getlisteRegate().toArray(new String[0]));
		this.cboSelRegate.setBounds(383, 11, 161, 20);
		this.panelSelRegate.add(cboSelRegate);
		
		this.btnSelectionner = new JButton("Valider");
		this.btnSelectionner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNomRegate.setText(maBdd.getlisteRegate().get(cboSelRegate.getSelectedIndex())); 
				tfLieuDepart.setText(maBdd.getListeLieuDepart().get(cboSelRegate.getSelectedIndex()));
				tfLieuArrivee.setText(maBdd.getListeLieuArrivee().get(cboSelRegate.getSelectedIndex()));
				tfDistance.setText(""+maBdd.getListeDistance().get(cboSelRegate.getSelectedIndex()));
				
			}
		});
		this.btnSelectionner.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.btnSelectionner.setBounds(550, 11, 100, 20);
		this.panelSelRegate.add(btnSelectionner);
		
		
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
	
	public void creationPanelChrono() {
		this.chrono = new DTimer(this);
		
		this.panelChrono = new JPanel();
		this.panelChrono.setBorder(new TitledBorder(null, "Chronom\u00E8tre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelChrono.setBounds(10, 334, 370, 157);
		this.window.add(panelChrono);
		this.panelChrono.setLayout(null);
		

		
		this.btnFin = new JButton("FIN");
		this.btnFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chrono.stopDTimer();
			}
		});
		this.btnFin.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.btnFin.setBounds(272, 42, 88, 59);
		this.panelChrono.add(btnFin);
		
		this.btnReinit = new JButton("Reinitialiser");
		this.btnReinit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chrono.reinitDTimer();
				lblChrono.setText("00:00:00");
			}
		});
		this.btnReinit.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.btnReinit.setBounds(171, 112, 189, 23);
		this.panelChrono.add(btnReinit);
		this.btnReinit.setToolTipText("");
		
		this.lblChrono = new JLabel("00:00:00");
		this.lblChrono.setFont(new Font("Tahoma", Font.PLAIN, 37));
		this.lblChrono.setBounds(10, 42, 171, 76);
		this.panelChrono.add(lblChrono);	
		
		this.btnDepart = new JButton("DEPART");
		this.btnDepart.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.btnDepart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chrono.startDTimer();
			}
		});
		this.btnDepart.setBounds(174, 42, 88, 59);
		this.panelChrono.add(btnDepart);
	}
	
	public void creationPanelTableau() {
		
		this.panelTableParticipant = new JPanel();
		this.panelTableParticipant.setBorder(new TitledBorder(null, "Participants", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelTableParticipant.setBounds(404, 79, 370, 412);
		this.window.add(panelTableParticipant);
		this.panelTableParticipant.setLayout(null);
		
		scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 20, 350, 383);
		this.panelTableParticipant.add(scrollPane);
		
		this.tableParticipants = new JTable(20,5);
		this.tableParticipants.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.scrollPane.setViewportView(tableParticipants);
		this.tableParticipants.setFillsViewportHeight(true);
		this.tableParticipants.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				{null, "✔", "✘", null, null},
				
			},
			new String[] {"Participant", "Arriv\u00E9e", "Abandon", "Temp r\u00E9el", "Temp compens\u00E9"}
		) {

			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, true, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tableParticipants.getColumn("Arriv\u00E9e").setCellRenderer(new ButtonRenderer());
		tableParticipants.getColumn("Arriv\u00E9e").setCellEditor(
		        new ButtonEditor(new JCheckBox(), this));
		tableParticipants.getColumn("Abandon").setCellRenderer(new ButtonRenderer());
		tableParticipants.getColumn("Abandon").setCellEditor(
		        new ButtonEditor(new JCheckBox(), this));
		
		this.tableParticipants.getColumnModel().getColumn(1).setPreferredWidth(45);
		this.tableParticipants.getColumnModel().getColumn(2).setPreferredWidth(45);
		this.tableParticipants.setRowHeight(18);
	}
	
	public void setChrono(int timeCount) {
		this.lblChrono.setText(df.format(timeCount - 3.6 * Math.pow(10,6)));
		
	}
	
	public void setTime(boolean arrivee) {
		int ligne = tableParticipants.getSelectedRow();
			if ((chrono.isRunning()) && (tableParticipants.getValueAt(ligne, 3) == null)) {
				if (arrivee == true) {
					tableParticipants.setValueAt(df.format(chrono.getTime() - 3.6 * Math.pow(10,6)), ligne, 3);
				}else {
					tableParticipants.setValueAt("NC", ligne, 3);
				}
				}else if  (tableParticipants.getValueAt(ligne, 3) != null){
					JOptionPane.showMessageDialog(null, "Ce participant est déjà arrivé ou a abandoné", "Erreur", JOptionPane.ERROR_MESSAGE);
				}else if  (!chrono.isRunning()){
					JOptionPane.showMessageDialog(null, "Le chronomètre n'est pas lancé", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
}