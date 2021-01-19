package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;

public class RecoverListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		BackupPanel p = BackupPanel.instance;
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		// 1. �����ж�MYSQL��װ·���Ƿ�����
		if (0 == mysqlPath.length()) {
			JOptionPane.showMessageDialog(p, "�ָ�ǰ��������mysql��·��");
			MainPanel.instance.workingPanel.show();
			ConfigPanel.instance.tfMysqlPath.grabFocus();
			return;
		}
		// 2. ���ļ�ѡ������ָ��Ҫ�򿪵��ļ�
		// �ļ���Ĭ������Ϊhutubill.sql
		// ���ݺ�׺��.sql�����ļ�
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(new File("hutubill.sql"));
		fc.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return ".sql";
			}

			@Override
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".sql");
			}
		});
		// 3. ����MysqlUtil ���лָ�
		int returnVal = fc.showOpenDialog(p);
		File file = fc.getSelectedFile();
		System.out.println(file);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// 4. ��ʾ�ָ��ɹ�
			try {
				MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
				JOptionPane.showMessageDialog(p, "�ָ��ɹ�");
			} catch (Exception el) {
				el.printStackTrace();
				JOptionPane.showMessageDialog(p, "�ָ�ʧ��\r\n,����:\r\n");
			}
		}
	}
}
