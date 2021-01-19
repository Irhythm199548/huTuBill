package util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.panel.WorkingPanel;

public class CenterPanel extends JPanel {
	private double rate;// 拉伸比例
	private JComponent c; // 显示的组件
	private boolean strech;// 是否拉伸

	/**
	 * 
	 * @param rate
	 * @param strech
	 */
	public CenterPanel(double rate, boolean strech) {
		this.setLayout(null);
		this.rate = rate;// 表示拉伸比例，1就是填满，0.5就是填一半。
		this.strech = strech;// 表示是否拉伸
	}

	public CenterPanel(double rate) {
		this(rate, true);
	}

	/**
	 * 在repaint方法中，就会使用绝对定位的方式把组件放在中间位置。
	 * 如果strech是true，就会根据整个容器的大小，设置组件的大小，达到拉伸的效果 如果strech是false,
	 * 就使用组件的preferredSize，即非拉伸效果。
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
	 * 使用show方法显示组件,show方法中的思路是： 先把这个容器中的组件都移出，然后把新的组件加进来，并且调用updateUI进行界面渲染。
	 * updateUI会导致swing去调用repaint()方法。
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
