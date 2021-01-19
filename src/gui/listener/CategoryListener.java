package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import gui.entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

//1. �������ToolBarListener ���Ƶģ������¼��ķ���Դ���ж����ĸ���ť�����������������������Ӧ�Ĺ��ܡ�
public class CategoryListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		CategoryPanel p = CategoryPanel.instance;

		JButton b = (JButton) e.getSource();
		// 2. ��������ӣ����������У���������ݲ�Ϊ�պ�ͨ��CategoryService.add()��ӵ����ݿ⡣
		if (b == p.bAdd) {
			String name = JOptionPane.showInputDialog(null);
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(p, "�������Ʋ���Ϊ��");
				return;
			}

			new CategoryService().add(name);
		}
		// 3. ����Ǳ༭�����������У���������ݲ�Ϊ�պ󣬸���CategoryPanel��getSelectedCategory()��ȡid,
		// Ȼ����ͨ��CategoryService.update���µ����ݿ�
		if (b == p.bEdit) {
			Category c = p.getSelectedCategory();
			int id = c.id;
			String name = JOptionPane.showInputDialog("�޸ķ�������");
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(p, "�������Ʋ���Ϊ��");
			}

			new CategoryService().update(id, name);
		}
		// 4. �����ɾ���������ж��Ƿ������Ѽ�¼����������Ѽ�¼������ɾ����
		// ���Ž���ɾ��ȷ����ʾ��ȷ�Ϻ�ͨ��CategoryService.delete()����ɾ����
		if (b == p.bDelete) {
			Category c = p.getSelectedCategory();
			if (0 != c.recordNuber) {
				JOptionPane.showMessageDialog(p, "�������������Ѽ�¼���ڣ�����ɾ��");
				return;
			}
			if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "ȷ��Ҫɾ��")) {
				return;
			}
			int id = c.id;
			new CategoryService().delete(id);
		}
		// 5. ������p.updateData();��������
		p.updateDate();
	}

}
