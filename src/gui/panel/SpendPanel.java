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
	// 首先还是设置皮肤
	static {
		GUIUtil.useLNF();
	}

	// 接着单例化，单例化的目的是为了监听器方便获取组件
	// 直接声明一个SpendPanel类型的静态属性，并指向当前实例
	public static SpendPanel instance = new SpendPanel();

	// 然后是各种组件，组件设计为public属性，也是为了监听器方便获取组件
	public JLabel lMonthSpend = new JLabel("本月消费");
	public JLabel lTodaySpend = new JLabel("今日消费");
	public JLabel lAvgSpendPerDay = new JLabel("日均消费");
	public JLabel lMonthLeft = new JLabel("本月剩余");
	public JLabel lDayAvgAvailable = new JLabel("日均可用");
	public JLabel lMonthLeftDay = new JLabel("距离月末");

	public JLabel vMonthSpend = new JLabel("￥2300");
	public JLabel vTodaySpend = new JLabel("￥25");
	public JLabel vAvgSpendPerDay = new JLabel("￥120");
	public JLabel vMonthAvailable = new JLabel("￥2084");
	public JLabel vDayAvgAvailable = new JLabel("￥389");
	public JLabel vMonthLeftDay = new JLabel("15天");

	CircleProgressBar bar;

	private SpendPanel() {
		this.setLayout(new BorderLayout());
		bar = new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.blueColor);

		// 为不同的组件上不同的颜色
		GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
				lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
		GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);

		// 设置字体
		vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
		vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));

		// 首先把整体是一个BorderLayerout
		// 中间是一个Panel，采用的BorderLayerout.CENTER
		// 下面也是一个Panel，采用的BorderLayerout.SOUTH
		this.add(center(), BorderLayout.CENTER);
		this.add(south(), BorderLayout.SOUTH);
	}

	// 北面这个Panel，本身也是用的BorderLayout
	// 其自身分中西两部分
	// CENTER就直接使用的环形进度条
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

	// WEST 使用的是一个JPanel，这个JPanel用的是4行1列的GridLayout
	private Component west() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 1));
		p.add(lMonthSpend);
		p.add(vMonthSpend);
		p.add(lTodaySpend);
		p.add(vTodaySpend);
		return p;

	}

	// 南面这部分使用的是GridLayerout，采用的是2行4列的网格布局器
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
		// 在updateData()方法中根据SpendService获取页面对象
		SpendPage spend = new SpendService().getSpendPage();
		// 然后把这个页面对象的值，更新到组件里。
		vMonthSpend.setText(spend.monthSpend);
		vTodaySpend.setText(spend.todaySpend);
		vAvgSpendPerDay.setText(spend.avgSpendPerDay);
		vMonthAvailable.setText(spend.monthAvailable);
		vDayAvgAvailable.setText(spend.dayAvgAvailable);
		vMonthLeftDay.setText(spend.monthLeftDay);
		// 如果超支了，那么就把相应的组件设置为红色，否则就是正常的颜色
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
