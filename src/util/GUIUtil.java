package util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIUtil {
	private static String imageFolder = "D:/project/huTuBillDemo/src/img";

	/**
	 * ����ť����ͼ����ı��Լ���ʾ����
	 * 
	 * @param b
	 * @param fileName
	 * @param tip
	 */
	public static void setImageIcon(JButton b, String fileName, String tip) {
		ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
		b.setIcon(i);
		b.setPreferredSize(new Dimension(6, 81));
		b.setToolTipText(tip);
		b.setVerticalTextPosition(JButton.BOTTOM);
		b.setHorizontalTextPosition(JButton.CENTER);
		b.setText(tip);
	}

	/**
	 * ������������ǰ��ɫ
	 * 
	 * @param color
	 * @param cs
	 */
	public static void setColor(Color color, JComponent... cs) {
		for (JComponent c : cs) {
			c.setForeground(color);
		}
	}

	/**
	 * @param p
	 * @param strechRate
	 *            �������1��ʶ����Ļ
	 */
	public static void showPanel(JPanel p, double strechRate) {
		// GUIUtil.useLNF();
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(strechRate);
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		cp.show(p);
	}

	public static void showPanel(JPanel p) {
		showPanel(p, 0.85);
	}

	/**
	 * У��һ����������Ƿ������ָ�ʽ
	 * 
	 * @param tf
	 * @param input
	 * @return
	 */
	public static boolean checkNumber(JTextField tf, String input) {
		if (!checkEmpty(tf, input))
			return false;
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException el) {
			JOptionPane.showMessageDialog(null, input + "��Ҫ������");
			tf.grabFocus();
			return false;
		}
	}

	/**
	 * У��һ������������Ƿ�����
	 * 
	 * @param tf
	 * @param input
	 * @return
	 */
	public static boolean checkZero(JTextField tf, String input) {
		if (!checkNumber(tf, input))
			return false;
		String text = tf.getText();

		if (0 == Integer.parseInt(text)) {
			JOptionPane.showMessageDialog(null, input + "����Ϊ��");
		}
		return true;
	}

	/**
	 * У��һ������������Ƿ��ǿ�
	 * 
	 * @param tf
	 * @param input
	 * @return
	 */
	public static boolean checkEmpty(JTextField tf, String input) {
		String text = tf.getText().trim();
		if (0 == text.length()) {
			JOptionPane.showMessageDialog(null, input + " ����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;

	}

	public static int getInt(JTextField tf) {
		return Integer.parseInt(tf.getText());
	}

	/**
	 * ʹ��ˮ��Ƥ���� Java�ṩ�ܶ���Ƥ��,���Ǵ󲿷ֶ��Ƚ��ѿ���ˮ��Ƥ�������ǿ��ù�ȥ��һ��
	 */
	public static void useLNF() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
