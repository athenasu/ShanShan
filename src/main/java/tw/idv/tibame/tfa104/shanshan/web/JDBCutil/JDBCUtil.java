package tw.idv.tibame.tfa104.shanshan.web.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCUtil {

	//釋放連接 方法
	public static void close(PreparedStatement pstmt, Connection con) {

		close(null, pstmt, con);
		
	};

	//釋放連接 方法
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
	
		if (rs != null) {
			try {
				rs.close();
//				System.out.println("成功釋放rs連線資源");
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
//				System.out.println("成功釋放pstmt連線資源");
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
//				System.out.println("成功釋放con連線資源");
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	};


	
}
