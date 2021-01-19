package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.page.SpendPage;
import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class SpendPanel extends WorkingPanel {
	// ���Ȼ�������Ƥ��
	static {
		GUIUtil.useLNF();
	}

	// ���ŵ���������������Ŀ����Ϊ�˼����������ȡ���
	// ֱ������һ��SpendPanel���͵ľ�̬���ԣ���ָ��ǰʵ��
	public static SpendPanel instance = new SpendPanel();

	// Ȼ���Ǹ��������������Ϊpublic���ԣ�Ҳ��Ϊ�˼����������ȡ���
	public JLabel lMonthSpend = new JLabel("��������");
	public JLabel lTodaySpend = new JLabel("��������");
	public JLabel lAvgSpendPerDay = new JLabel("�վ�����");
	public JLabel lMonthLeft = new JLabel("����ʣ��");
	public JLabel lDayAvgAvailable = new JLabel("�վ�����");
	public JLabel lMonthLeftDay = new JLabel("������ĩ");

	public JLabel vMonthSpend = new JLabel("��2300");
	public JLabel vTodaySpend = new JLabel("��25");
	public JLabel vAvgSpendPerDay = new JLabel("��120");
	public JLabel vMonthAvailable = new JLabel("��2084");
	public JLabel vDayAvgAvailable = new JLabel("��389");
	public JLabel vMonthLeftDay = new JLabel("15��");

	CircleProgressBar bar;

	private SpendPanel() {
		this.setLayout(new BorderLayout());
		bar = new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.blueColor);

		// Ϊ��ͬ������ϲ�ͬ����ɫ
		GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
				lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
		GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);

		// ��������
		vMonthSpend.setFont(new Font("΢���ź�", Font.BOLD, 23));
		vTodaySpend.setFont(new Font("΢���ź�", Font.BOLD, 23));

		// ���Ȱ�������һ��BorderLayerout
		// �м���һ��Panel�����õ�BorderLayerout.CENTER
		// ����Ҳ��һ��Panel�����õ�BorderLayerout.SOUTH
		this.add(center(), BorderLayout.CENTER);
		this.add(south(), BorderLayout.SOUTH);
	}

	// �������Panel������Ҳ���õ�BorderLayout
	// ������������������
	// CENTER��ֱ��ʹ�õĻ��ν�����
	private JPanel center() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(west(), BorderLayout.WEST);
		p.add(east());

		return p;
	}

	private Component east() {
		return bar;
	}

	// WEST ʹ�õ���һ��JPanel�����JPanel�õ���4��1�е�GridLayout
	private Component west() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 1));
		p.add(lMonthSpend);
		p.add(vMonthSpend);
		p.add(lTodaySpend);
		p.add(vTodaySpend);
		return p;

	}

	// �����ⲿ��ʹ�õ���GridLayerout�����õ���2��4�е����񲼾���
	private JPanel south() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 4));
		p.add(lAvgSpendPerDay);
		p.add(lMonthLeft);
		p.add(lDayAvgAvailable);
		p.add(lMonthLeftDay);
		p.add(vAvgSpendPerDay);
		p.add(vMonthAvailable);
		p.add(vDayAvgAvailable);
		p.add(vMonthLeftDay);
		return p;
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(SpendPanel.instance);
	}

	@Override
	public void updateDate() {
		// ��updateData()�����и���SpendService��ȡҳ�����
		SpendPage spend = new SpendService().getSpendPage();
		// Ȼ������ҳ������ֵ�����µ�����
		vMonthSpend.setText(spend.monthSpend);
		vTodaySpend.setText(spend.todaySpend);
		vAvgSpendPerDay.setText(spend.avgSpendPerDay);
		vMonthAvailable.setText(spend.monthAvailable);
		vDayAvgAvailable.setText(spend.dayAvgAvailable);
		vMonthLeftDay.setText(spend.monthLeftDay);
		// �����֧�ˣ���ô�Ͱ���Ӧ���������Ϊ��ɫ�����������������ɫ
		bar.setProgress(spend.usagePercentage);
		if (spend.isOverSpend) {
			vMonthAvailable.setForeground(ColorUtil.warningColor);
			vMonthSpend.setForeground(ColorUtil.warningColor);
			vTodaySpend.setForeground(ColorUtil.warningColor);
		} else {
			vMonthAvailable.setForeground(ColorUtil.grayColor);
			vTodaySpend.setForeground(ColorUtil.blueColor);
			vTodaySpend.setForeground(ColorUtil.blueColor);
		}
		bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
		addListener();
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub

	}
}