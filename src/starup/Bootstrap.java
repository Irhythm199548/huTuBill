package starup;

import javax.swing.SwingUtilities;

import gui.panel.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;

public class Bootstrap {
	public static void main(String[] args) throws Exception {
		// ����Ƥ���� һ��������������Ƥ����������Panel����Ͳ���Ҫ����Ƥ�������ˡ�
		GUIUtil.useLNF();
		// ʹ��SwingUtilities.invokeAndWait�ķ�ʽ����ͼ�ν���
		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				// ��ʾ�����壬����������·���workingPanel��ʾ����һ��Panel
				MainFrame.instance.setVisible(true);
				MainPanel.instance.workingPanel.show(SpendPanel.instance);
			}
		});
	}
}
