package service;

import dao.ConfigDAO;
import gui.entity.Config;

public class ConfigService {
	public static final String budget = "budget";
	public static final String mysqlPath = "mysqlPath";
	public static final String default_budget = "500";

	static ConfigDAO dao = new ConfigDAO();

	static {
		// ��ʼ��
		/**
		 * ��Ϊ������Ϣ�����������ݣ�һ����Ԥ�㣬һ����Mysql·���� ��������Ϣ��������ζ�Ӧ���Ǵ������ݿ��еġ�
		 * ���Ի����init����������ʼ����
		 */
		init();

	}

	// ��Ϊ������Ϣ�����������ݣ�һ����Ԥ�㣬һ����Mysql·����
	// ��������Ϣ��������ζ�Ӧ���Ǵ������ݿ��еġ� ���Ի����init����������ʼ����
	/**
	 * 1. ��ʼ�� init()
	 */
	public static void init() {
		init(budget, default_budget);
		init(mysqlPath, "");
	}

	// ���ȸ���keyȥ���ң���������ڣ���ʹ��value��ֵ����һ�����ݡ�
	private static void init(String key, String value) {
		Config config = dao.getByKey(key);
		if (config == null) {
			Config c = new Config();
			c.setKey(key);
			c.setValue(value);
			dao.add(c);
		}
	}

	// ���ݼ���ȡ��Ӧ��ֵ
	public String get(String key) {
		Config config = dao.getByKey(key);
		return config.getValue();
	}

	// ���¼���Ӧ��ֵ
	public void update(String key, String value) {
		Config config = dao.getByKey(key);
		config.setValue(value);
		dao.update(config);
	}

	public int getIntBudget() {
		return Integer.parseInt(get(budget));
	}
}
