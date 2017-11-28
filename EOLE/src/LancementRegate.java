import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
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

public class LancementRegate extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTable tableParticipants;
	private JPanel panelSelRegate, panelChrono, panelInfoRegate, panelTableParticipant;
	private JLabel lblSelRegate, lblNomRegate, lblDate, lblLieuDepart, lblLieuArrivee, lblDistance, lblChrono;
	private JTextField tfNomRegate, tfLieuDepart, tfLieuArrivee, tfDistance;
	private JComboBox<String> cboSelRegate;
	private JTextField tfDate;
	private DTimer chrono;
	private Window window;
	private JButton btnFin, btnReinit, btnDepart, btnSelectionner;
	private JScrollPane scrollPane;
	private ArrayList<ArrayList<String>> lesParticipants;
	private SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
	private Bdd maBdd;
	

	public LancementRegate(Window window, Bdd maBdd) 
	{
		this.window = window;
		this.maBdd = maBdd;
	}
	
	public void createAll()
	{
		creationPanelSelRegate();
		creationPanelInfoRegate();
		creationPanelChrono();
		creationPanelTableau();
	}
	
	public void creationPanelSelRegate() 
	{
		this.panelSelRegate = new JPanel();
		this.panelSelRegate.setBounds(10, 11, 764, 57);
		this.panelSelRegate.setLayout(null);
		this.window.add(panelSelRegate);
		
		this.lblSelRegate = new JLabel("Selectionner la régate à lancer : ");
		this.lblSelRegate.setBounds(190, 14, 220, 14);
		this.panelSelRegate.add(lblSelRegate);
		
		this.cboSelRegate = new JComboBox<String>(maBdd.getListeNomRegate().toArray(new String[0]));
		this.cboSelRegate.setBounds(383, 11, 161, 20);
		this.panelSelRegate.add(cboSelRegate);
		
		this.btnSelectionner = new JButton("Valider");
		this.btnSelectionner.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				chargerInfoRegate();
				ajoutParticipantsTableau();
			}
		});
		
		this.btnSelectionner.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.btnSelectionner.setBounds(550, 11, 100, 20);
		this.panelSelRegate.add(btnSelectionner);
	}
	
	public void creationPanelInfoRegate() 
	{
		this.panelInfoRegate = new JPanel();
		this.panelInfoRegate.setBorder(new TitledBorder(null, "R\u00E9gate", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelInfoRegate.setBounds(10, 79, 370, 234);
		this.window.add(panelInfoRegate);
		this.panelInfoRegate.setLayout(null);
		
		this.lblNomRegate = new JLabel("Nom de la régate : ");
		this.lblNomRegate.setBounds(20, 21, 150, 43);
		
		this.lblDate = new JLabel("Date : ");
		this.lblDate.setBounds(20, 52, 150, 43);
		
		this.lblLieuDepart = new JLabel("Lieu de départ : ");
		this.lblLieuDepart.setBounds(20, 92, 150, 43);
		
		this.lblLieuArrivee = new JLabel("Lieu d'arrivée : ");
		this.lblLieuArrivee.setBounds(20, 130, 150, 43);
		
		this.lblDistance = new JLabel("Distance : ");
		this.lblDistance.setBounds(20, 165, 150, 43);
		
		this.tfNomRegate = new JTextField(15); 
		this.tfNomRegate.setEditable(false);
		this.tfNomRegate.setBounds(160, 29, 185, 26);
		
		this.tfLieuDepart = new JTextField(15);
		this.tfLieuDepart.setEditable(false);
		this.tfLieuDepart.setBounds(160, 100, 185, 26);
		
		this.tfLieuArrivee = new JTextField(15);
		this.tfLieuArrivee.setEditable(false);
		this.tfLieuArrivee.setBounds(160, 138, 185, 26);
		
		this.tfDistance = new JTextField(15);
		this.tfDistance.setEditable(false);
		this.tfDistance.setBounds(160, 173, 185, 26);
		
		this.tfDate = new JTextField();
		this.tfDate.setBounds(160, 64, 118, 26);
		this.tfDate.setEditable(false);
		
		this.panelInfoRegate.add(lblNomRegate);
		this.panelInfoRegate.add(tfNomRegate);
		this.panelInfoRegate.add(lblDate);
		this.panelInfoRegate.add(tfDate);
		this.panelInfoRegate.add(lblLieuDepart);
		this.panelInfoRegate.add(tfLieuDepart);
		this.panelInfoRegate.add(lblLieuArrivee);
		this.panelInfoRegate.add(tfLieuArrivee);
		this.panelInfoRegate.add(lblDistance);
		this.panelInfoRegate.add(tfDistance);
	}
	
	public void creationPanelChrono() 
	{
		this.chrono = new DTimer(this);
		
		this.panelChrono = new JPanel();
		this.panelChrono.setBorder(new TitledBorder(null, "Chronom\u00E8tre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelChrono.setBounds(10, 334, 370, 157);
		this.panelChrono.setLayout(null);
		this.window.add(panelChrono);
		
		this.btnFin = new JButton("FIN");
		this.btnFin.addActionListener(new ActionListener() 	
		{
			public void actionPerformed(ActionEvent e) 
			{
				chrono.stopDTimer();
			}
		});
		
		this.btnFin.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.btnFin.setBounds(272, 42, 88, 59);
		this.panelChrono.add(btnFin);
		
		this.btnReinit = new JButton("Reinitialiser");
		this.btnReinit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				chrono.reinitDTimer();
				lblChrono.setText("00:00:00");
			}
		});
		
		this.btnReinit.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.btnReinit.setBounds(171, 112, 189, 23);
		this.btnReinit.setToolTipText("");
		this.panelChrono.add(btnReinit);
		
		this.lblChrono = new JLabel("00:00:00");
		this.lblChrono.setFont(new Font("Tahoma", Font.PLAIN, 37));
		this.lblChrono.setBounds(10, 42, 171, 76);
		this.panelChrono.add(lblChrono);	
		
		this.btnDepart = new JButton("DEPART");
		this.btnDepart.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.btnDepart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				chrono.startDTimer();
			}
		});
		
		this.btnDepart.setBounds(174, 42, 88, 59);
		this.panelChrono.add(btnDepart);
	}
	
	public void creationPanelTableau() 
	{	
		this.panelTableParticipant = new JPanel();
		this.panelTableParticipant.setBorder(new TitledBorder(null, "Participants", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelTableParticipant.setBounds(404, 79, 370, 412);
		this.panelTableParticipant.setLayout(null);
		this.window.add(panelTableParticipant);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 20, 350, 383);
		this.panelTableParticipant.add(scrollPane);
		
		this.tableParticipants = new JTable(20,5);
		this.tableParticipants.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.scrollPane.setViewportView(tableParticipants);
		this.tableParticipants.setFillsViewportHeight(true);
		this.tableParticipants.setModel(new DefaultTableModel(new Object[][] 
				{
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
				{null, null, "✔", "✘", null},
			},new String[] {"Participant", "Voilier", "Arriv\u00E9e", "Abandon", "Temps"}) 
		{
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {false, false, true, true, false};
			
			public boolean isCellEditable(int row, int column) 
			{
				return columnEditables[column];
			}
		});
		
		tableParticipants.getColumn("Arriv\u00E9e").setCellRenderer(new ButtonRenderer());
		tableParticipants.getColumn("Arriv\u00E9e").setCellEditor(new ButtonEditor(new JCheckBox(), this));
		tableParticipants.getColumn("Abandon").setCellRenderer(new ButtonRenderer());
		tableParticipants.getColumn("Abandon").setCellEditor(new ButtonEditor(new JCheckBox(), this));
		
		this.tableParticipants.getColumnModel().getColumn(2).setPreferredWidth(40);
		this.tableParticipants.getColumnModel().getColumn(3).setPreferredWidth(40);
		this.tableParticipants.getColumnModel().getColumn(4).setPreferredWidth(40);
		this.tableParticipants.getColumnModel().getColumn(1).setPreferredWidth(40);
		this.tableParticipants.setRowHeight(18);
	}
	
	public void setChrono(int timeCount) 
	{
		this.lblChrono.setText(df.format(timeCount - 3.6 * Math.pow(10,6)));
	}
	
	public void setTime(boolean arrivee) 
	{
		int ligne = tableParticipants.getSelectedRow();
			if ((chrono.isRunning()) && (tableParticipants.getValueAt(ligne, 4) == null)) 
			{
				if (arrivee == true) 
				{
					tableParticipants.setValueAt(df.format(chrono.getTime() - 3.6 * Math.pow(10,6)), ligne, 4);
				}else 
				{
					tableParticipants.setValueAt("NC", ligne, 4);
				}
				}else if  (tableParticipants.getValueAt(ligne, 4) != null)
				{
					JOptionPane.showMessageDialog(null, "Ce participant est déjà arrivé ou a abandoné", "Erreur", JOptionPane.ERROR_MESSAGE);
				}else if  (!chrono.isRunning())
				{
					JOptionPane.showMessageDialog(null, "Le chronomètre n'est pas lancé", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
	
	public void chargerInfoRegate() 
	{
		tfNomRegate.setText(maBdd.getlisteRegate().get(cboSelRegate.getSelectedIndex()).getNomRegate()); 
		tfLieuDepart.setText(maBdd.getlisteRegate().get(cboSelRegate.getSelectedIndex()).getLieuDepart()); 
		tfLieuArrivee.setText(maBdd.getlisteRegate().get(cboSelRegate.getSelectedIndex()).getLieuArrive()); 
		tfDistance.setText(Integer.toString(maBdd.getlisteRegate().get(cboSelRegate.getSelectedIndex()).getDistance())); 
		tfDate.setText(maBdd.getlisteRegate().get(cboSelRegate.getSelectedIndex()).getDateRegate()); 
	}
	
	public void ajoutParticipantsTableau() 
	{
		lesParticipants = new ArrayList<ArrayList<String>>();
		lesParticipants = maBdd.getParticipantRegate(maBdd.getlisteRegate().get(cboSelRegate.getSelectedIndex()).getIdRegate());
		for (int i=0; i < lesParticipants.size(); i++) 
		{
			tableParticipants.setValueAt(lesParticipants.get(i).get(2) + " " + lesParticipants.get(i).get(1), i, 0);
			tableParticipants.setValueAt(lesParticipants.get(i).get(3), i, 1);
		}
	}
}