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
		f.setTitle("һ����Ϳ��");
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JToolBar tb = new JToolBar();
		JButton bSpend = new JButton("����һ��");
		JButton bRecord = new JButton("��һ��");
		JButton bCategory = new JButton("���ѷ���");
		JButton bReport = new JButton("�����ѱ���");
		JButton bConfig = new JButton("����");
		JButton bBackup = new JButton("����");
		JButton bRecover = new JButton("�ָ�");

		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);
		f.setLayout(new BorderLayout());
		f.add(tb, BorderLayout.NORTH);
		// �����·�������ʾ���ֹ��ܽ����JPanel�� Ŀǰ����һ���հ�Panel, Ϊ�˽�����ʾ���ֹ��ܣ�����������һ��Ĵ�����÷ǳ��ĸ���
		f.add(new JPanel(), BorderLayout.CENTER);

		f.setVisible(true);
		/**
		 * ���Ǹ�������ť�Ӽ�������Ŀǰ������û���κ�ʵ�ʹ��ܵĿհ׼�������һ�������Ѹ��ֹ��ܶ�����ȥ֮�󣬴�����÷ǳ��߳��������Ķ�
		 * Ϊ��ʹ�ô����ø���ά����������������߳�������������Ҫ�Դ�����п�ѧ�Ĺ滮��
		 * ����Ԥ������ֱ����main�б�дJFrame�����Ĵ�����߳�������ά���Ե����ӡ�
		 * 
		 * ������Ҫ�ѽ�����ص��࣬�������������ҷ��ڲ�ͬ�İ�������й����ά���� ������Frame
		 * ��������ֻ��һ����Frame�����԰������滮����gui.frame�� Ȼ����Panel
		 * JFrame������һ��Panel��Ȼ��ÿһ������ģ�鶼��һ��Panel�����԰���ЩPanel�滮��gui.panel����ȥ
		 * ������Listener �����еļ������������ɶ������࣬ʵ��ActionListener�ӿڣ�������gui.listener����
		 * �����Model Model���ڴ�����ݣ��������Ŀ�л��õ�TableModel��ComboBoxModel������gui.model����
		 * 
		 * ��ͼMainFrame �������࣬�滮��gui.frame���� SpendPanel ����һ������࣬�滮��gui.panel����
		 * RecordPanel ��һ������࣬�滮��gui.panel���� ToolBarListener
		 * �������������࣬�滮��gui.listener���� BackupListener ���ݼ������࣬�滮��gui.listener����
		 * CategoryComboBoxModel ����������Model�࣬�滮��gui.model���� CategoryTableModel
		 * ������Model�࣬�滮��gui.model���� �ȵ�
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
