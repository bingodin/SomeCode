package xuankexitong;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/*
 * 用觉jdbc连接mysql
 */
public class TestJdbc {
	public static void test(String[] args) {

		try {
			// 1、加载JDBC驱动程序：
			Class.forName("com.mysql.jdbc.Driver");
			// 提供url
			String url = "jdbc:mysql://localhost:3306/test?user=root&password=root";
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
			String sql = "select * from users where name='' or 1=1";
			// 5、执行SQL语句
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("name");
				String pass = rs.getString(1); // 此方法比较高效
				System.out.println(name + " " + pass);
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

	}
}
