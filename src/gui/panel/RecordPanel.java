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
	JLabel lSpend = new JLabel("���ѣ�����");
	JLabel lCategory = new JLabel("����");
	JLabel lComment = new JLabel("��ע");
	JLabel lDate = new JLabel("����");

	public JTextField tfSpend = new JTextField("0");

	// �������õ���JComboBox���ڴ�������������ʱ��
	// ������������TableModel����ʽ��ʹ��ComboBoxModel
	// �����ݷ��뿪������������Ŀ����Ϊ�˱����������з�����Ϣ�ĸ��¡� ��Ϊ�ں����Ŀ����У�������Ϣ�Ǵ����ݿ���ȡ�����ģ����п��ܷ����仯��
	public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
	public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
	public JTextField tfComent = new JTextField();
	// �����ʹ�õ���JXDatePicker ������ڿؼ���������ʾ��ǰ���ڡ�
	public JXDatePicker datepick = new JXDatePicker(new Date());

	JButton bSubmit = new JButton("��һ��");

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

		// ���������BorderLayout ��Ϊ������м䡣
		// ������һ��JPanel���м�Ҳ��һ��JPanel��
		// �����JPanelʹ��4��2�е� GridLayout��
		// �м��JPanelʹ��Ĭ�ϵ�FlowLayout,
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
