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
		// ����Ƥ��
		GUIUtil.useLNF();
	}

	// ʹ�õ���ChartUtil�ֳɵķ��������˵��µ�ģ������
	public static ReportPanel instance = new ReportPanel();

	public JLabel l = new JLabel();

	// �ڹ������л�ȡͼ������ͼ��������Label�ϣ�Ȼ����ʾ���Label
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
