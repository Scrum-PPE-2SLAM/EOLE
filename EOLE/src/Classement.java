import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Classement extends JFrame {
	
	private Window window;
	private JPanel panelSelRegate;
	private JLabel lblSelRegate;
	private JTable tableClassement;
	private JComboBox<String> cboSelRegate;
	
	public Classement(Window window){
		
		this.window = window;
	}
	
	public void createClassement(){	
		JPanel paneltableClassement = new JPanel();
		paneltableClassement.setBorder(new TitledBorder(null, "Classement", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paneltableClassement.setBounds(10, 91, 765, 400);
		window.add(paneltableClassement);
		paneltableClassement.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 20, 700, 357);
		paneltableClassement.add(scrollPane);
		
		
		tableClassement = new JTable(20,5);
		tableClassement.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(tableClassement);
		tableClassement.setFillsViewportHeight(true);
		tableClassement.setModel(new DefaultTableModel(
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
		
		tableClassement.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableClassement.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableClassement.getColumnModel().getColumn(3).setPreferredWidth(70);
		tableClassement.getColumnModel().getColumn(4).setPreferredWidth(70);
	}
	
public void createPanelSelRegate(String categorie) {
		
		panelSelRegate = new JPanel();
		panelSelRegate.setBounds(10, 11, 764, 57);
		window.add(panelSelRegate);
		panelSelRegate.setLayout(null);
		
		lblSelRegate = new JLabel("Classement "+ categorie + ": ");
		lblSelRegate.setBounds(217, 14, 156, 14);
		panelSelRegate.add(lblSelRegate);
		if(categorie == "Général"){
			cboSelRegate = new JComboBox<String>(window.getListeRegate());
		}else{
			cboSelRegate = new JComboBox<String>(window.getListeType());
		}
		
		cboSelRegate.setBounds(383, 11, 161, 20);
		panelSelRegate.add(cboSelRegate);
	}

}

