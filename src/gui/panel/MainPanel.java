package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.plaf.metal.MetalBorders.ToolBarBorder;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

public class MainPanel extends JPanel {
	static {
		// 在静态初始化块中调用LookAndFeel，设置水晶皮肤。 因为这段话必须放在最前面才能生效，所以需要在这里调用
		GUIUtil.useLNF();
	}

	// 接着采用单例模式，为的是后续的监听器访问这个容器里的组件的便利性
	public static MainPanel instance = new MainPanel();

	// 然后是把各种按钮声明为public 的属性，同样也是为了后续的监听器访问这个容器里的组件的便利性
	public JToolBar tb = new JToolBar();
	public JButton bSpend = new JButton();
	public JButton bRecord = new JButton();
	public JButton bCategory = new JButton();
	public JButton bReport = new JButton();
	public JButton bConfig = new JButton();
	public JButton bBackup = new JButton();
	public JButton bRecover = new JButton();

	// 工作面板，用于将来显示不同的功能面板。 目前暂时是空白的
	public CenterPanel workingPanel;

	private MainPanel() {
		// 使用GUI.setImageIcon设置这些按钮的图标、文字和提示
		GUIUtil.setImageIcon(bSpend, "backup.png", "消费一览");
		GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
		GUIUtil.setImageIcon(bCategory, "category2.png", "消费分类");
		GUIUtil.setImageIcon(bReport, "report.png", "月消费报表");
		GUIUtil.setImageIcon(bConfig, "config.png", "设置");
		GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
		GUIUtil.setImageIcon(bRecover, "restore.png", "恢复");

		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);
		tb.setFloatable(false);

		workingPanel = new CenterPanel(0.8);

		setLayout(new BorderLayout());
		add(tb, BorderLayout.NORTH);
		add(workingPanel, BorderLayout.CENTER);
		// 这样点击不同的按钮，就可以在不同的面板之间来回切换
		addListener();
	}

	public void addListener() {
		ToolBarListener listener = new ToolBarListener();
		bSpend.addActionListener(listener);
		bRecord.addActionListener(listener);
		bCategory.addActionListener(listener);
		bReport.addActionListener(listener);
		bConfig.addActionListener(listener);
		bBackup.addActionListener(listener);
		bRecover.addActionListener(listener);
	}

	public static void main(String[] args) {
		// 最后使用GUIUtil.showPanel方法，显示这个面板实例，测试起来非常方便。
		// 参数"1" 表示满屏显示
		GUIUtil.showPanel(MainPanel.instance, 1);
	}

}
