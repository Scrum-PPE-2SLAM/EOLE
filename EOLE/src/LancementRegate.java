import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JPanel panelSelRegate, panelChrono, panelInfoRegate;
	private JLabel lblSelRegate, lblNomRegate, lblDate, lblLieuDepart, lblLieuArrivee, lblDistance, label;
	private JTextField tfNomRegate, tfLieuDepart, tfLieuArrivee, tfDistance;
	private JComboBox<String> cboSelRegate;
	private JDateChooser cboDate;
	private DTimer chrono;
	private Window window;
	private String[] listeRegate;

	public LancementRegate(Window window, String[] listeRegate) {
		this.window = window;
		this.listeRegate = listeRegate;
	}
	
	public void creationPanelSelRegate() {
		
		panelSelRegate = new JPanel();
		panelSelRegate.setBounds(10, 11, 764, 57);
		window.add(panelSelRegate);
		panelSelRegate.setLayout(null);
		
		lblSelRegate = new JLabel("Selectionner la régate à lancer : ");
		lblSelRegate.setBounds(217, 14, 156, 14);
		panelSelRegate.add(lblSelRegate);
		
		cboSelRegate = new JComboBox<String>(listeRegate);
		cboSelRegate.setBounds(383, 11, 161, 20);
		panelSelRegate.add(cboSelRegate);
	}
	
	public void creationPanelInfoRegate() {
		panelInfoRegate = new JPanel();
		panelInfoRegate.setBorder(new TitledBorder(null, "R\u00E9gate", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfoRegate.setBounds(10, 79, 370, 234);
		window.add(panelInfoRegate);
		
		lblNomRegate = new JLabel("Nom de la régate : ");
		lblNomRegate.setBounds(29, 21, 96, 43);
		lblDate = new JLabel("Date : ");
		lblDate.setBounds(87, 52, 38, 43);
		lblLieuDepart = new JLabel("Lieu de départ : ");
		lblLieuDepart.setBounds(46, 92, 79, 43);
		lblLieuArrivee = new JLabel("Lieu d'arrivée : ");
		lblLieuArrivee.setBounds(51, 130, 74, 43);
		lblDistance = new JLabel("Distance : ");
		lblDistance.setBounds(68, 165, 57, 43);
		tfNomRegate = new JTextField(15); 
		tfNomRegate.setBounds(135, 29, 185, 26);
		tfLieuDepart = new JTextField(15);
		tfLieuDepart.setBounds(135, 100, 185, 26);
		tfLieuArrivee = new JTextField(15);
		tfLieuArrivee.setBounds(135, 138, 185, 26);
		tfDistance = new JTextField(15);
		tfDistance.setBounds(135, 173, 185, 26);
		cboDate = new JDateChooser();
		cboDate.setBounds(135, 64, 118, 26);
		panelInfoRegate.setLayout(null);
		
		panelInfoRegate.add(lblNomRegate);
		panelInfoRegate.add(tfNomRegate);
		panelInfoRegate.add(lblDate);
		panelInfoRegate.add(cboDate);
		panelInfoRegate.add(lblLieuDepart);
		panelInfoRegate.add(tfLieuDepart);
		panelInfoRegate.add(lblLieuArrivee);
		panelInfoRegate.add(tfLieuArrivee);
		panelInfoRegate.add(lblDistance);
		panelInfoRegate.add(tfDistance);
	}
	
	public void creationPanelChrono() {
		chrono = new DTimer(this);
		
		panelChrono = new JPanel();
		panelChrono.setBorder(new TitledBorder(null, "Chronom\u00E8tre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChrono.setBounds(10, 334, 370, 157);
		window.add(panelChrono);
		panelChrono.setLayout(null);
		

		
		JButton btnFin = new JButton("FIN");
		btnFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chrono.stopDTimer();
			}
		});
		btnFin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFin.setBounds(272, 42, 88, 59);
		panelChrono.add(btnFin);
		
		JButton btnNewButton_2 = new JButton("Reinitialiser");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chrono.reinitDTimer();
				label.setText("00:00:00");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(171, 112, 189, 23);
		panelChrono.add(btnNewButton_2);
		btnNewButton_2.setToolTipText("");
		
		label = new JLabel("00:00:00");
		label.setFont(new Font("Tahoma", Font.PLAIN, 37));
		label.setBounds(10, 42, 171, 76);
		panelChrono.add(label);	
		
		JButton btnNewButton_1 = new JButton("DEPART");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chrono.startDTimer();
			}
		});
		btnNewButton_1.setBounds(174, 42, 88, 59);
		panelChrono.add(btnNewButton_1);
	}
	
	public void creationPanelTableau() {
		
		JPanel panelTableParticipant = new JPanel();
		panelTableParticipant.setBorder(new TitledBorder(null, "Participants", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTableParticipant.setBounds(404, 79, 370, 412);
		window.add(panelTableParticipant);
		panelTableParticipant.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 350, 357);
		panelTableParticipant.add(scrollPane);
		
		tableParticipants = new JTable(20,5);
		tableParticipants.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(tableParticipants);
		tableParticipants.setFillsViewportHeight(true);
		tableParticipants.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {"Participant", "Arriv\u00E9e", "Abandon", "Temp r\u00E9el", "Temp compens\u00E9"}
		) {

			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tableParticipants.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableParticipants.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableParticipants.getColumnModel().getColumn(3).setPreferredWidth(70);
		tableParticipants.getColumnModel().getColumn(4).setPreferredWidth(70);
	}
	
	public void setChrono(int timeCount) {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		this.label.setText(df.format(timeCount - 3.6 * Math.pow(10,6)));
		
	}
}