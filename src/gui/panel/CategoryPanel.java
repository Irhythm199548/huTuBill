package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.entity.Category;
import gui.listener.CategoryListener;
import gui.listener.ConfigListener;
import gui.model.CategoryTableModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class CategoryPanel extends WorkingPanel {
	static {
		// ����Ƥ��
		GUIUtil.useLNF();
	}

	public static CategoryPanel instance = new CategoryPanel();

	public JButton bAdd = new JButton("����");
	public JButton bEdit = new JButton("�༭");
	public JButton bDelete = new JButton("ɾ��");
	String columNames[] = new String[] { "��������", "���Ѵ���" };

	public CategoryTableModel ctm = new CategoryTableModel();
	public JTable t = new JTable(ctm);

	public CategoryPanel() {
		GUIUtil.setColor(ColorUtil.blueColor, bAdd, bEdit, bDelete);
		JScrollPane sp = new JScrollPane(t);
		JPanel pSubmit = new JPanel();
		pSubmit.add(bAdd);
		pSubmit.add(bEdit);
		pSubmit.add(bDelete);

		// �����ͬ������BorderLayout,�־��к����档
		// ����ʹ�õ���JScrollPane�����з���JTable��
		// ����ʹ��һ��JPanel�������3����ť��
		this.setLayout(new BorderLayout());
		this.add(sp, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);

		addListener();
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(CategoryPanel.instance);
	}

	// 1. ΪCategoryPanel������һ��getSelectedCategory�������ȡJTable�ϵ�ǰѡ�е�Category����
	public Category getSelectedCategory() {
		int index = t.getSelectedRow();
		return ctm.cs.get(index);
	}

	// 2. ����һ��updateData���������������ӣ�ɾ�������޸�֮�󣬸��±���е���Ϣ����Ĭ��ѡ�е�һ�С�
	// ����֮�⣬�������жϣ���������û�����ݣ�ɾ�����޸İ�ť����ʹ�á�
	@Override
	public void updateDate() {
		ctm.cs = new CategoryService().list();
		t.updateUI();
		t.getSelectionModel().setSelectionInterval(0, 0);

		if (0 == ctm.cs.size()) {
			bEdit.setEnabled(false);
			bDelete.setEnabled(false);
		} else {
			bEdit.setEnabled(true);
			bDelete.setEnabled(true);
		}
	}

	// Ϊ3����ť���ϼ�����
	@Override
	public void addListener() {
		CategoryListener litener = new CategoryListener();
		bAdd.addActionListener(litener);
		bEdit.addActionListener(litener);
		bDelete.addActionListener(litener);
	}

}
