import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import net.proteanit.sql.DbUtils;

public class MainFrame {

	private JFrame frmk;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textDoB;
	private JTextField textEmail;
	private JTextField textCity;
	private JTable tableSearchResults;
	private JList listProfession;
    private JComboBox comboBoxByCity;
    private JComboBox comboBoxByAgeFrom;
    private JComboBox comboBoxByAgeTo;
    private JComboBox comboBoxByProfession;
    private static Datasource ds = Datasource.getInstance();
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmk = new JFrame();
		frmk.setTitle("HR2k35 Human Resources");
		frmk.setBounds(100, 100, 832, 451);
		frmk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{432, 0};
		gridBagLayout.rowHeights = new int[]{10, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		frmk.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frmk.getContentPane().add(panel, gbc_panel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		frmk.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel tabInsert = new JPanel();
		tabbedPane.addTab("Insert Candidate", null, tabInsert, null);
		tabInsert.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(67dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("34dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("56dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(47dlu;default)"),
				ColumnSpec.decode("max(24dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(62dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("66dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(24dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(16dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("15dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("6dlu"),
				RowSpec.decode("max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("8dlu:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(10dlu;default)"),}));
		
		
		
		JLabel labelInsertCandidate = new JLabel("Insert a New Candidate");
		labelInsertCandidate.setFont(new Font("Tahoma", Font.BOLD, 16));
		tabInsert.add(labelInsertCandidate, "9, 2, 6, 1, center, top");
		
		JLabel labelProfession = new JLabel("Profession");
		labelProfession.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabInsert.add(labelProfession, "14, 4, 4, 1, center, default");
		
		JLabel labelName = new JLabel("Full Name");
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabInsert.add(labelName, "4, 6, right, default");
		
		textName = new JTextField();
		textName.setToolTipText("e.g. Sam Smith");
		tabInsert.add(textName, "6, 6, 5, 1, fill, default");
		textName.setColumns(10);
		
		JScrollPane scrollPaneProfession = new JScrollPane();
		scrollPaneProfession.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneProfession.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tabInsert.add(scrollPaneProfession, "15, 6, 3, 17, fill, fill");
		
		JList listProfession = new JList();
		listProfession.setModel(new AbstractListModel() {
			String[] values = new String[] {"Back-End Developer", "Front-End Developer", "Full-Stack Developer", "Games Developer", "Android Developer", "iOS Developer", "Data Scientist", "DevOps Developer", "Tools Developer", "API Developer", "Blockchain Engineer", "Electrical Engineer", "Embedded Systems Engineer", "Security Developer", "Software Tester", "System Administrator", "Scrum Master", "IT Project Manager"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPaneProfession.setViewportView(listProfession);
		
		JLabel labelCity = new JLabel("City");
		labelCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabInsert.add(labelCity, "4, 10, right, default");
		
		textCity = new JTextField();
		textCity.setToolTipText("e.g. Thessaloniki");
		textCity.setColumns(10);
		tabInsert.add(textCity, "6, 10, 5, 1, fill, default");
		
		JLabel labelDoB = new JLabel("Date of Birth");
		labelDoB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabInsert.add(labelDoB, "4, 14, right, default");
		
		textDoB = new JTextField();
		textDoB.setText("YYYY-MM-DD");
		textDoB.setToolTipText("e.g. 1978-06-05");
		tabInsert.add(textDoB, "6, 14, 5, 1, fill, top");
		textDoB.setColumns(10);
		
		JLabel labelPhone = new JLabel("Phone");
		labelPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabInsert.add(labelPhone, "4, 18, right, bottom");
		
		textPhone = new JTextField();
		textPhone.setToolTipText("e.g. 6978899000");
		tabInsert.add(textPhone, "6, 18, 5, 1, fill, default");
		textPhone.setColumns(10);
		
		JLabel labelEmail = new JLabel("E-mail");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabInsert.add(labelEmail, "4, 22, right, default");
		
		textEmail = new JTextField();
		textEmail.setToolTipText("e.g. myemail@mydomain.com");
		tabInsert.add(textEmail, "6, 22, 5, 1, fill, top");
		textEmail.setColumns(10);
		
		JButton buttonInsert = new JButton("Insert");
		buttonInsert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// make a candidate object out of gui fields
				String name 	   = textName.getText();
				String email 	   = textEmail.getText();
				String phone 	   = textPhone.getText();
				String dob   	   = textDoB.getText();
				Object professiono = listProfession.getModel().getElementAt(listProfession.getSelectedIndex());
				String profession  = professiono.toString();
				String city		   = textCity.getText();
				Candidate c = new Candidate(name, email, phone, dob, profession, city);

				// insert a candidate on db; if there's no error, clear the fields
				ds.open();
				if (ds.insertCandidate(c)) {
					// clear the fields after a successful candidate insertion
					textName.setText("");
					textCity.setText("");
					textDoB.setText("YYYY-MM-DD");
					textPhone.setText("");
					textEmail.setText("");
					listProfession.clearSelection();
					// popup
					JOptionPane.showMessageDialog(null, "Candidate was inserted succesfully.", "Candidate inserted", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "There was a problem inserting the Candidate.", "Insertion error!", JOptionPane.ERROR_MESSAGE);
				}
				ds.close();
				//populate cities here to not have ds.close() conflicts or exceptions
				populateCitiesOnSearchTab();
			}
		});
		tabInsert.add(buttonInsert, "15, 26, 4, 1, center, center");
		
		JPanel tabSearch = new JPanel();
		tabbedPane.addTab("Search Candidate", null, tabSearch, null);
		tabSearch.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(28dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(30dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("42dlu:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(44dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(42dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(42dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(41dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(77dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(30dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(28dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(42dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(26dlu;default)"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel label = new JLabel("Search for a Candidate");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		tabSearch.add(label, "9, 2, 6, 1, center, top");
		
		comboBoxByCity = new JComboBox();
		comboBoxByCity.setToolTipText("Filter by a City");
		comboBoxByCity.setEnabled(false);
		populateCitiesOnSearchTab();   // populate cities
		tabSearch.add(comboBoxByCity, "5, 8, fill, default");

		JCheckBox checkboxByCity = new JCheckBox("By City");
		checkboxByCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxByCity.setEnabled( checkboxByCity.isSelected() );				
			}			
		});
		tabSearch.add(checkboxByCity, "5, 6");
		
		comboBoxByAgeFrom = new JComboBox();
		comboBoxByAgeFrom.setToolTipText("Fitler by the Minimum Age");
		comboBoxByAgeFrom.setModel(new DefaultComboBoxModel(new String[] {
				"18",
				"22",
				"26",
				"30",
				"34",
				"38",
				"42",
				"46",
				"50",
		}));
		comboBoxByAgeFrom.setEnabled(false);
		tabSearch.add(comboBoxByAgeFrom, "9, 8, fill, default");
		
		comboBoxByAgeTo = new JComboBox();
		comboBoxByAgeTo.setToolTipText("Filter by the Maximum Age");
		comboBoxByAgeTo.setModel(new DefaultComboBoxModel(new String[] {
				"20",
				"24",
				"28",
				"32",
				"36",
				"40",
				"44",
				"48",
				"52",
				"60",
		}));
		comboBoxByAgeTo.setEnabled(false);
		tabSearch.add(comboBoxByAgeTo, "11, 8, fill, default");
		
		JCheckBox checkboxByAge = new JCheckBox("By Age");
		checkboxByAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxByAgeFrom.setEnabled( checkboxByAge.isSelected() );
				comboBoxByAgeTo.setEnabled( checkboxByAge.isSelected() );
			}
		});	
		tabSearch.add(checkboxByAge, "9, 6");
		
		comboBoxByProfession = new JComboBox();
		comboBoxByProfession.setToolTipText("Filter by a Profession");
		comboBoxByProfession.setModel(new DefaultComboBoxModel(new String[] {
				"Back-End Developer",
				"Front-End Developer",
				"Full-Stack Developer",
				"Games Developer",
				"Android Developer",
				"iOS Developer",
				"Data Scientist",
				"DevOps Developer",
				"Tools Developer",
				"API Developer",
				"Blockchain Engineer",
				"Electrical Engineer",
				"Embedded Systems Engineer",
				"Security Developer",
				"Software Tester",
				"System Administrator",
				"Scrum Master",
				"IT Project Manager"}));
		comboBoxByProfession.setEnabled(false);
		tabSearch.add(comboBoxByProfession, "15, 8, fill, default");
		
		JCheckBox checkBoxByProfession = new JCheckBox("By Profession");
		checkBoxByProfession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxByProfession.setEnabled( checkBoxByProfession.isSelected() );
			}
		});
		tabSearch.add(checkBoxByProfession, "15, 6");
		
		JButton buttonSearch = new JButton("Search");
		tabSearch.add(buttonSearch, "11, 10");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String city = "";
				String profession = "";
				String ageFrom = "";
				String ageTo = "";
				ds.open();
				if (checkboxByCity.isSelected() || checkboxByAge.isSelected() || checkBoxByProfession.isSelected()) {
					city = (checkboxByCity.isSelected() ? comboBoxByCity.getSelectedItem().toString() : "");
					ageFrom = (checkboxByAge.isSelected() ? comboBoxByAgeFrom.getSelectedItem().toString() : "");
					ageTo = (checkboxByAge.isSelected() ? comboBoxByAgeTo.getSelectedItem().toString() : "");
					profession = (checkBoxByProfession.isSelected() ? comboBoxByProfession.getSelectedItem().toString() : "");
				}
				ResultSet rs = ds.queryCandidatesByFiltersAndGetResultSet(city, profession, ageFrom, ageTo);
				tableSearchResults.setModel(DbUtils.resultSetToTableModel(rs));
				ds.close();
			}
		});
		
		JScrollPane scrollPaneSearchResults = new JScrollPane();
		tabSearch.add(scrollPaneSearchResults, "3, 12, 15, 13, fill, fill");
		
		tableSearchResults = new JTable();
		scrollPaneSearchResults.setViewportView(tableSearchResults);
		
		final RowPopup pop = new RowPopup(tableSearchResults);
		
		tableSearchResults.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if(SwingUtilities.isRightMouseButton(me)){
					pop.show(me.getComponent(), me.getX(), me.getY());
				}
			}
		});
		//pop.setVisible(true);
	}
	
	private boolean populateCitiesOnSearchTab() {
		ds.open();
		ResultSet rs = ds.fetchAllCities();
		try {
			// remove all dropbox items first
			comboBoxByCity.removeAllItems();
			while (rs.next()) {
				String name = rs.getString("city");
				comboBoxByCity.addItem(name);
			}
		} catch(SQLException e) {
            System.out.println("Error populating cities: " + e.getMessage());
            e.printStackTrace();
            return false;
		}
		ds.close();
		return true;
	}
	
	class RowPopup extends JPopupMenu{
		private JTable table;
		
		
		public RowPopup(JTable jtable) {
			this.table = jtable;
			JMenuItem delete = new JMenuItem("Delete");
			delete.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete Candidate?",
							"Delete Candidate", JOptionPane.YES_NO_OPTION);
					if (YesOrNo == 0) { // YES
						// getselected field
						deleteCandidate();
					} else {

					}
				}
			});
			add(delete);
			
		}
		
		public void deleteCandidate() {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int selectedRow = table.getSelectedRow();
			String s = model.getValueAt(selectedRow, 0).toString();
			Datasource ds = Datasource.getInstance();
			ds.open();
			ds.deleteCandidate(Integer.parseInt(s));
			ds.close();
			try{
				model.removeRow(selectedRow);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Please select a Candidate to delete");
			}
			
		}
	}

}