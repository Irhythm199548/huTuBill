package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import gui.entity.Category;
import service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel<Category> {
	public List<Category> cs = new CategoryService().list();

	Category c;

	// 构造方法中初始化模拟数据。
	public CategoryComboBoxModel() {
		if (!cs.isEmpty())
			c = cs.get(0);
	}

	// 获取这个下拉框的大小，就是前面定义的字符串集合的大小
	@Override
	public int getSize() {
		return cs.size();
	}

	// 获取指定位置的数据
	@Override
	public Category getElementAt(int index) {
		return cs.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {

	}

	@Override
	public void removeListDataListener(ListDataListener l) {

	}

	// 当界面上选中了某一个下拉框项，就会调用这个方法
	@Override
	public void setSelectedItem(Object anItem) {
		c = (Category) anItem;
	}

	// 获取被选中的数据
	@Override
	public Object getSelectedItem() {
		return c;
	}
}
