package simp.myutil;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyDefaultTableCellRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		JCheckBox box= new JCheckBox();
		return box;
	}
}
