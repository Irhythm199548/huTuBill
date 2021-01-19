package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import gui.entity.Category;
import service.CategoryService;

public class CategoryTableModel implements TableModel {
	String[] columnNames = new String[] { "分类名称", "消费次数" };
	// 1. 存放的数据由String集合，改为了Category集合，并且从CategoryService的list()方法获取数据
	public List<Category> cs = new CategoryService().list();

	@Override
	public int getRowCount() {
		return cs.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	// 2. getValueAt方法，第一列取Category 对象的name值，第二列取recordNumber值。
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Category h = cs.get(rowIndex);
		if (0 == columnIndex)
			return h.name;
		if (1 == columnIndex)
			return h.recordNuber;
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}
}
