package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static String ip = "127.0.0.1";
	static int port = 3306;
	static String database = "hutubill";
	static String encoding = "UTF-8";
	static String loginName = "root";
	static String password = "admin";

	// 驱动初始化放在了静态初始化块里，
	// 因为这行代码需要先执行，而且只需要执行一次就足够了。
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 提供了一个静态的public的getConnection方法获取连接
	public static Connection getConnection() throws SQLException {
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
		return DriverManager.getConnection(url, loginName, password);
	}
}
