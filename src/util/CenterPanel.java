package util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.panel.WorkingPanel;

public class CenterPanel extends JPanel {
	private double rate;// �������
	private JComponent c; // ��ʾ�����
	private boolean strech;// �Ƿ�����

	/**
	 * 
	 * @param rate
	 * @param strech
	 */
	public CenterPanel(double rate, boolean strech) {
		this.setLayout(null);
		this.rate = rate;// ��ʾ���������1����������0.5������һ�롣
		this.strech = strech;// ��ʾ�Ƿ�����
	}

	public CenterPanel(double rate) {
		this(rate, true);
	}

	/**
	 * ��repaint�����У��ͻ�ʹ�þ��Զ�λ�ķ�ʽ����������м�λ�á�
	 * ���strech��true���ͻ�������������Ĵ�С����������Ĵ�С���ﵽ�����Ч�� ���strech��false,
	 * ��ʹ�������preferredSize����������Ч����
	 */
	public void repaint() {
		if (null != c) {
			Dimension containerSize = this.getSize();
			Dimension componentSize = c.getPreferredSize();

			if (strech)
				c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
			else
				c.setSize(componentSize);
			c.setLocation(containerSize.width / 2 - c.getSize().width / 2,
					containerSize.height / 2 - c.getSize().height / 2);
		}
		super.repaint();
	}

	/**
	 * ʹ��show������ʾ���,show�����е�˼·�ǣ� �Ȱ���������е�������Ƴ���Ȼ����µ�����ӽ��������ҵ���updateUI���н�����Ⱦ��
	 * updateUI�ᵼ��swingȥ����repaint()������
	 * 
	 * @param p
	 */
	public void show(JComponent p) {
		this.c = p;
		Component[] cs = getComponents();
		for (Component c : cs) {
			remove(c);
		}
		add(p);
		if (p instanceof WorkingPanel)
			((WorkingPanel) p).updateDate();
		this.updateUI();
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(200, 200);
		f.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(0.85, true);
		f.setContentPane(cp);
		f.setVisible(true);
		JButton b = new JButton("abc");
		cp.show(b);
	}
}
