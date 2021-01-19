package huTuBillDemo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class HutuMainFrame {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(500, 450);
		f.setTitle("一本糊涂账");
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JToolBar tb = new JToolBar();
		JButton bSpend = new JButton("消费一览");
		JButton bRecord = new JButton("记一笔");
		JButton bCategory = new JButton("消费分类");
		JButton bReport = new JButton("月消费报表");
		JButton bConfig = new JButton("设置");
		JButton bBackup = new JButton("备份");
		JButton bRecover = new JButton("恢复");

		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);
		f.setLayout(new BorderLayout());
		f.add(tb, BorderLayout.NORTH);
		// 这是下方用于显示各种功能界面的JPanel。 目前这是一个空白Panel, 为了将来显示各种功能，可以想象，这一块的代码会变得非常的复杂
		f.add(new JPanel(), BorderLayout.CENTER);

		f.setVisible(true);
		/**
		 * 这是给各个按钮加监听器，目前都还是没有任何实际功能的空白监听器，一旦将来把各种功能都加上去之后，代码会变得非常冗长和难以阅读
		 * 为了使得代码变得更加维护，避免陷入代码冗长的泥坑里，我们需要对代码进行科学的规划。
		 * 由于预见到了直接在main中编写JFrame带来的代码的冗长和难以维护性的增加。
		 * 
		 * 我们需要把界面相关的类，独立出来，并且放在不同的包下面进行管理和维护。 首先是Frame
		 * 整个程序只有一个主Frame，所以把这个类规划到包gui.frame下 然后是Panel
		 * JFrame本身有一个Panel，然后每一个功能模块都有一个Panel，所以把这些Panel规划到gui.panel下面去
		 * 接着是Listener 把所有的监听器，都做成独立的类，实现ActionListener接口，并放在gui.listener包下
		 * 最后是Model Model用于存放数据，在这个项目中会用到TableModel和ComboBoxModel，放在gui.model包下
		 * 
		 * 如图MainFrame 主窗体类，规划在gui.frame包下 SpendPanel 消费一览面板类，规划在gui.panel包下
		 * RecordPanel 记一笔面板类，规划在gui.panel包下 ToolBarListener
		 * 工具条监听器类，规划在gui.listener包下 BackupListener 备份监听器类，规划在gui.listener包下
		 * CategoryComboBoxModel 分类下拉框Model类，规划在gui.model包下 CategoryTableModel
		 * 分类表格Model类，规划在gui.model包下 等等
		 */
		bSpend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bRecover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
}
