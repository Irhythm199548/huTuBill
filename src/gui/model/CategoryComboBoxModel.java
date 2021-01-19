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

	// ���췽���г�ʼ��ģ�����ݡ�
	public CategoryComboBoxModel() {
		if (!cs.isEmpty())
			c = cs.get(0);
	}

	// ��ȡ���������Ĵ�С������ǰ�涨����ַ������ϵĴ�С
	@Override
	public int getSize() {
		return cs.size();
	}

	// ��ȡָ��λ�õ�����
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

	// ��������ѡ����ĳһ����������ͻ�����������
	@Override
	public void setSelectedItem(Object anItem) {
		c = (Category) anItem;
	}

	// ��ȡ��ѡ�е�����
	@Override
	public Object getSelectedItem() {
		return c;
	}
}
