package util;

import java.awt.Color;

public class ColorUtil {
	public static Color blueColor = Color.decode("#3399FF");// ����ɫ
	public static Color grayColor = Color.decode("#999999");// ��ɫ
	public static Color backgroundColor = Color.decode("#eeeeee");// ����ɫ
	public static Color warningColor = Color.decode("#FF3333");// �����ɫ

	/**
	 * ���ݽ�����ʾ��ͬ����ɫ �������ǽӽ�0��ʱ�򣬾ͻ���ʾ��ɫ �����Ƚӽ�100��ʱ�򣬾ͻ���ʾ��ɫ ���ڲ�ͬ����ɫ�����
	 * 
	 * @param per
	 * @return
	 */
	public static Color getByPercentage(int per) {
		if (per > 100)
			per = 100;
		int r = 51;
		int g = 255;
		int b = 51;
		float rate = per / 100f;
		r = (int) ((255 - 51) * rate + 51);
		g = 255 - r + 51;
		Color color = new Color(r, g, b);
		return color;
	}
}