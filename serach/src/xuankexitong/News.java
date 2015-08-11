package xuankexitong;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class News {

	public static void serach(String q) {
		String m = Messages.getString("News.0"); //$NON-NLS-1$
		// TODO Auto-generated method stub
		try {
			// 1、加载JDBC驱动程序：
			Class.forName(Messages.getString("News.1")); //$NON-NLS-1$
			// 提供url
			String url = Messages.getString("News.2"); //$NON-NLS-1$
			Connection conn = null;
			// 创建数据库的连接
			conn = (Connection) DriverManager.getConnection(url);
			/*
			 * 创建一个Statement •要执行SQL语句，必须获得java.sql.Statement实例，Statement实例分为以下3
			 * 种类型： 1、执行静态SQL语句。通常通过Statement实例实现。
			 * 2、执行动态SQL语句。通常通过PreparedStatement实例实现。
			 * 3、执行数据库存储过程。通常通过CallableStatement实例实现。 具体的实现方式： Statement stmt =
			 * con.createStatement() ; PreparedStatement pstmt =
			 * con.prepareStatement(sql) ; CallableStatement cstmt =
			 * con.prepareCall("{CALL demoSp(? , ?)}") ;
			 */

			Statement stmt = (Statement) conn.createStatement();
			String sql = Messages.getString("News.3"); //$NON-NLS-1$
			// 5、执行SQL语句
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				m += rs.getString(Messages.getString("News.4")) + Messages.getString("News.5"); // 此方法比较高效 //$NON-NLS-1$ //$NON-NLS-2$
				m += rs.getString(Messages.getString("News.6")) + Messages.getString("News.7"); // 此方法比较高效 //$NON-NLS-1$ //$NON-NLS-2$
				m += rs.getString(Messages.getString("News.8")) + Messages.getString("News.9"); // 此方法比较高效 //$NON-NLS-1$ //$NON-NLS-2$
				m += rs.getString(Messages.getString("News.10")) + Messages.getString("News.11"); // 此方法比较高效 //$NON-NLS-1$ //$NON-NLS-2$
				m += Messages.getString("News.12"); // 此方法比较高效 //$NON-NLS-1$

			}
			/*
			 * 1、关闭记录集 2、关闭声明 3、关闭连接对象
			 */
			if (rs != null) { // 关闭记录集
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) { // 关闭声明
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) { // 关闭连接对象
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (q.equals(Messages.getString("News.13"))) { //$NON-NLS-1$
			System.out.println(m);
		} else {
			String ms[] = m.split(Messages.getString("News.14")); //$NON-NLS-1$
			for (String string : ms) {
				if (string.indexOf(q) > -1) {
					System.out.println(string.replaceAll(q, Messages.getString("News.15") + q + Messages.getString("News.16"))); //$NON-NLS-1$ //$NON-NLS-2$
				}

			}

		}
	}

}
