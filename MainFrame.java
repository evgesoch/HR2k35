import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTabbedPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.AbstractListModel;
import java.awt.FlowLayout;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainFrame {

	private JFrame frmk;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textDoB;
	private JTextField textEmail;
	private JTextField textCity;
	private JTable tableSearchResults;

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
		textDoB.setToolTipText("e.g. YYYY-MM-DD");
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
				Datasource ds = Datasource.getInstance();
				ds.open();
				
				String name 	   = textName.getText();
				String email 	   = textEmail.getText();
				String phone 	   = textPhone.getText();
				String dob   	   = textDoB.getText();
				Object professiono = listProfession.getModel().getElementAt(listProfession.getSelectedIndex());
				String profession  = professiono.toString();
				String city		   = textCity.getText();
				
				Candidate c = new Candidate(name, email, phone, dob, profession, city);
				
				ds.insertCandidate(c);
				ds.close();		
				
				JOptionPane.showMessageDialog(null,
						"Candidate was inserted succesfully.",
						"Candidate inserted ",JOptionPane.INFORMATION_MESSAGE);
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
		
		JCheckBox checkboxByCity = new JCheckBox("By City");
		tabSearch.add(checkboxByCity, "5, 6");
		
		JCheckBox checkboxByAge = new JCheckBox("By Age");
		tabSearch.add(checkboxByAge, "9, 6");
		
		JCheckBox checkBoxByProfession = new JCheckBox("By Profession");
		tabSearch.add(checkBoxByProfession, "15, 6");
		
		JComboBox comboBoxByCity = new JComboBox();
		comboBoxByCity.setModel(new DefaultComboBoxModel(new String[] {"City"}));
		tabSearch.add(comboBoxByCity, "5, 8, fill, default");
		
		JComboBox comboBoxByAgeFrom = new JComboBox();
		comboBoxByAgeFrom.setModel(new DefaultComboBoxModel(new String[] {"From"}));
		tabSearch.add(comboBoxByAgeFrom, "9, 8, fill, default");
		
		JComboBox comboBoxByAgeTo = new JComboBox();
		comboBoxByAgeTo.setModel(new DefaultComboBoxModel(new String[] {"To"}));
		tabSearch.add(comboBoxByAgeTo, "11, 8, fill, default");
		
		JComboBox comboBoxByProfession = new JComboBox();
		comboBoxByProfession.setModel(new DefaultComboBoxModel(new String[] {"Profession"}));
		tabSearch.add(comboBoxByProfession, "15, 8, fill, default");
		
		JButton buttonSearch = new JButton("Search");
		tabSearch.add(buttonSearch, "11, 10");
		
		JScrollPane scrollPaneSearchResults = new JScrollPane();
		tabSearch.add(scrollPaneSearchResults, "3, 12, 15, 13, fill, fill");
		
		tableSearchResults = new JTable();
		tableSearchResults.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, "", null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Name", "E-mail", "Phone", "Date of Birth", "Profession", "City"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPaneSearchResults.setViewportView(tableSearchResults);
	}

}
