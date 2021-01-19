package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import gui.entity.Category;
import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class RecordPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}

	public static RecordPanel instance = new RecordPanel();
	JLabel lSpend = new JLabel("花费（￥）");
	JLabel lCategory = new JLabel("分类");
	JLabel lComment = new JLabel("备注");
	JLabel lDate = new JLabel("日期");

	public JTextField tfSpend = new JTextField("0");

	// 下拉框用到了JComboBox，在创建这个下拉框的时候，
	// 借助了类似于TableModel的形式，使用ComboBoxModel
	// 把数据分离开来，这样做的目的是为了便于下拉框中分类信息的更新。 因为在后续的开发中，分类信息是从数据库中取出来的，很有可能发生变化。
	public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
	public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
	public JTextField tfComent = new JTextField();
	// 本面板使用到了JXDatePicker 这个日期控件，用于显示当前日期。
	public JXDatePicker datepick = new JXDatePicker(new Date());

	JButton bSubmit = new JButton("记一笔");

	public RecordPanel() {
		GUIUtil.setColor(ColorUtil.grayColor, lSpend, lCategory, lComment, lDate);
		GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
		JPanel pInput = new JPanel();
		JPanel pSubmit = new JPanel();
		int gap = 40;
		pInput.setLayout(new GridLayout(4, 2, gap, gap));

		pInput.add(lSpend);
		pInput.add(tfSpend);
		pInput.add(lCategory);
		pInput.add(cbCategory);
		pInput.add(lComment);
		pInput.add(tfComent);
		pInput.add(lDate);
		pInput.add(datepick);

		pSubmit.add(bSubmit);

		// 这个面板采用BorderLayout 分为北面和中间。
		// 北面是一个JPanel，中间也是一个JPanel。
		// 北面的JPanel使用4行2列的 GridLayout。
		// 中间的JPanel使用默认的FlowLayout,
		this.setLayout(new BorderLayout());
		this.add(pInput, BorderLayout.NORTH);
		this.add(pSubmit, BorderLayout.CENTER);

		addListener();
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(RecordPanel.instance);
	}

	public Category getSelectedCategory() {
		return (Category) cbCategory.getSelectedItem();
	}

	@Override
	public void updateDate() {
		cbModel.cs = new CategoryService().list();
		cbCategory.updateUI();
		resetInput();
		tfSpend.grabFocus();
	}

	public void resetInput() {
		tfSpend.setText("0");
		tfComent.setText("");
		if (0 != cbModel.cs.size())
			cbCategory.setSelectedIndex(0);
		datepick.setDate(new Date());
	}

	@Override
	public void addListener() {
		RecordListener listener = new RecordListener();
		bSubmit.addActionListener(listener);
	}
}
