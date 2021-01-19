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
		// �ھ�̬��ʼ�����е���LookAndFeel������ˮ��Ƥ���� ��Ϊ��λ����������ǰ�������Ч��������Ҫ���������
		GUIUtil.useLNF();
	}

	// ���Ų��õ���ģʽ��Ϊ���Ǻ����ļ�����������������������ı�����
	public static MainPanel instance = new MainPanel();

	// Ȼ���ǰѸ��ְ�ť����Ϊpublic �����ԣ�ͬ��Ҳ��Ϊ�˺����ļ�����������������������ı�����
	public JToolBar tb = new JToolBar();
	public JButton bSpend = new JButton();
	public JButton bRecord = new JButton();
	public JButton bCategory = new JButton();
	public JButton bReport = new JButton();
	public JButton bConfig = new JButton();
	public JButton bBackup = new JButton();
	public JButton bRecover = new JButton();

	// ������壬���ڽ�����ʾ��ͬ�Ĺ�����塣 Ŀǰ��ʱ�ǿհ׵�
	public CenterPanel workingPanel;

	private MainPanel() {
		// ʹ��GUI.setImageIcon������Щ��ť��ͼ�ꡢ���ֺ���ʾ
		GUIUtil.setImageIcon(bSpend, "backup.png", "����һ��");
		GUIUtil.setImageIcon(bRecord, "record.png", "��һ��");
		GUIUtil.setImageIcon(bCategory, "category2.png", "���ѷ���");
		GUIUtil.setImageIcon(bReport, "report.png", "�����ѱ���");
		GUIUtil.setImageIcon(bConfig, "config.png", "����");
		GUIUtil.setImageIcon(bBackup, "backup.png", "����");
		GUIUtil.setImageIcon(bRecover, "restore.png", "�ָ�");

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
		// ���������ͬ�İ�ť���Ϳ����ڲ�ͬ�����֮�������л�
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
		// ���ʹ��GUIUtil.showPanel��������ʾ������ʵ�������������ǳ����㡣
		// ����"1" ��ʾ������ʾ
		GUIUtil.showPanel(MainPanel.instance, 1);
	}

}
