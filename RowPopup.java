import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RowPopup extends JPopupMenu {
	// private static final long serialVersionUID = 1L;
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

	/**
	 * Deletes Candidate from JTable in GUI and in database
	 */
	public void deleteCandidate() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int selectedRow = table.getSelectedRow();
		String s = model.getValueAt(selectedRow, 0).toString();
		Datasource ds = Datasource.getInstance();
		ds.open();
		ds.deleteCandidate(Integer.parseInt(s));
		ds.close();
		try {
			model.removeRow(selectedRow);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please select a Candidate to delete");
		}

	}
}
