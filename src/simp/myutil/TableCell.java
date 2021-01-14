package simp.myutil;

import java.awt.Checkbox;
import java.awt.Component;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TableCell extends AbstractCellEditor implements TableCellEditor,TableCellRenderer {

	JCheckBox jc;
	
	public TableCell() {
		jc = new JCheckBox();
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return jc;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return jc;
	}


}
