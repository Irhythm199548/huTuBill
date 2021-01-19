package starup;

import javax.swing.SwingUtilities;

import gui.panel.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;

public class Bootstrap {
	public static void main(String[] args) throws Exception {
		// 设置皮肤。 一旦在这里设置了皮肤，其他的Panel类里就不需要进行皮肤设置了。
		GUIUtil.useLNF();
		// 使用SwingUtilities.invokeAndWait的方式启动图形界面
		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				// 显示主窗体，并让主面板下方的workingPanel显示消费一览Panel
				MainFrame.instance.setVisible(true);
				MainPanel.instance.workingPanel.show(SpendPanel.instance);
			}
		});
	}
}
