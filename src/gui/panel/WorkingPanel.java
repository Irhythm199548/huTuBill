package gui.panel;

import javax.swing.JPanel;

public abstract class WorkingPanel extends JPanel {
	// WorkingPanel��һ�������࣬���������˷���addListener()��updateData().
	// ��ͬ������࣬��Ӧ�ü̳���������࣬���������ṩaddListener��updateData������
	public abstract void updateDate();

	public abstract void addListener();
}
