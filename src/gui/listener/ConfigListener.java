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
		// 1.首先判断输入的预算值是否是整数
		if (!GUIUtil.checkNumber(p.tfBudget, "本月预算")) {
			return;
		}
		String mysqlPath = p.tfMysqlPath.getText();
		if (0 != mysqlPath.length()) {
			File commandFile = new File(mysqlPath, "bin/mysql.exe");
			// 2.接着判断输入的MYSQL安装路径是否正确。判断办法是看路径对应的bin子目录下是否有mysql.exe文件存在
			if (!commandFile.exists()) {
				JOptionPane.showMessageDialog(p, "Mysql路径不正确");
				p.tfMysqlPath.grabFocus();
				return;
			}
		}
		// 3.调用业务类ConfigService进行数据更新
		/**
		 * 更明显的体现业务类ConfigService的好处。 如果不使用ConfigService，那么就需要自己创建Config对象，
		 * 对象是否存在的校验，设置属性等等，看上去就会显示比较繁杂。 而使用业务类，看上去就会比较简练。
		 */
		ConfigService cs = new ConfigService();
		cs.update(ConfigService.budget, p.tfBudget.getText());
		cs.update(ConfigService.mysqlPath, mysqlPath);
		// 4.最后提示设置修改成功
		/**
		 * 在这里进一步体现了界面类单例化和组件设置为public的好处， 即获取非常的方便，比之传统的匿名类方式快捷很多，维护起来也更容易
		 */
		JOptionPane.showMessageDialog(p, "设置修改成功");
	}

}
