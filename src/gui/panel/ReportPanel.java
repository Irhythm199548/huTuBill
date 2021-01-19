package gui.panel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.entity.Record;
import service.ReportService;
import util.ChartUtil;
import util.GUIUtil;

public class ReportPanel extends WorkingPanel {
	static {
		// 设置皮肤
		GUIUtil.useLNF();
	}

	// 使用的是ChartUtil现成的方法生成了当月的模拟数据
	public static ReportPanel instance = new ReportPanel();

	public JLabel l = new JLabel();

	// 在构造其中获取图表，并把图表设置在Label上，然后显示这个Label
	public ReportPanel() {
		this.setLayout(new BorderLayout());
		Image i = ChartUtil.getImage(400, 300);
		ImageIcon icon = new ImageIcon(i);
		l.setIcon(icon);
		this.add(l);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(ReportPanel.instance);
	}

	@Override
	public void updateDate() {
		List<Record> rs = new ReportService().listThisMonthRecords();
		Image i = ChartUtil.getImage(rs, 350, 250);
		ImageIcon icon = new ImageIcon(i);
		l.setIcon(icon);
	}

	@Override
	public void addListener() {

	}
}
