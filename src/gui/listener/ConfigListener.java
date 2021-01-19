package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import gui.entity.Config;
import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

public class ConfigListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		ConfigPanel p = ConfigPanel.instance;
		// 1.�����ж������Ԥ��ֵ�Ƿ�������
		if (!GUIUtil.checkNumber(p.tfBudget, "����Ԥ��")) {
			return;
		}
		String mysqlPath = p.tfMysqlPath.getText();
		if (0 != mysqlPath.length()) {
			File commandFile = new File(mysqlPath, "bin/mysql.exe");
			// 2.�����ж������MYSQL��װ·���Ƿ���ȷ���жϰ취�ǿ�·����Ӧ��bin��Ŀ¼���Ƿ���mysql.exe�ļ�����
			if (!commandFile.exists()) {
				JOptionPane.showMessageDialog(p, "Mysql·������ȷ");
				p.tfMysqlPath.grabFocus();
				return;
			}
		}
		// 3.����ҵ����ConfigService�������ݸ���
		/**
		 * �����Ե�����ҵ����ConfigService�ĺô��� �����ʹ��ConfigService����ô����Ҫ�Լ�����Config����
		 * �����Ƿ���ڵ�У�飬�������Եȵȣ�����ȥ�ͻ���ʾ�ȽϷ��ӡ� ��ʹ��ҵ���࣬����ȥ�ͻ�Ƚϼ�����
		 */
		ConfigService cs = new ConfigService();
		cs.update(ConfigService.budget, p.tfBudget.getText());
		cs.update(ConfigService.mysqlPath, mysqlPath);
		// 4.�����ʾ�����޸ĳɹ�
		/**
		 * �������һ�������˽����൥�������������Ϊpublic�ĺô��� ����ȡ�ǳ��ķ��㣬��֮��ͳ�������෽ʽ��ݺܶ࣬ά������Ҳ������
		 */
		JOptionPane.showMessageDialog(p, "�����޸ĳɹ�");
	}

}
