package tw.idv.tibame.tfa104.shanshan.web.articleReport.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.articleReport.dao.ArticleReportDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.articleReport.entity.ArticleReportVO;
@Repository
public class ArticleReportDAO implements ArticleReportDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String insert = "insert into article_report (member_id,article_id,article_report_reason,article_report_date) values(?,?,?,?) ";
	private static final String updateArticleRepo = "update article_report set member_id=?,article_id=?,article_report_status=?,article_report_reason=?,case_done=? where article_report_id=? ";
	private static final String deleteArticleRepo = "delete from article_report where article_report_id=?";
	private static final String findByArticleRepoPK = "select article_report_id,member_id,article_id,article_report_status,article_report_reason,article_report_date,case_done from ArticleReport where article_report_id = ?";
	private static final String getAllArticleRepo = "select article_report_id, member_id,article_id,article_report_status,article_report_reason,article_report_date,case_done from ArticleReport order by article_report_id";

	// to Owen
	// 檢舉狀態 (0:未處理 1:已刪除 2:未通過)
	private static final String findArticleRepoByStatus = "select article_report_id,member_id,article_id,article_report_status,article_report_reason,article_report_date,case_done from article_report where article_report_status = ?";
	private static final String findRepoByRepoPK ="select a.article_report_id,a.member_id,a.article_id, a.article_report_status, a.article_report_reason, a.case_done, b.article_title, b.article_content, c.member_name from article_report a join article b on a.article_id = b.article_id join member c on a.member_id = c.member_id where article_report_id = ?";
	// 改變狀態
	private static final String updateArticleRepoStatus = "update article_report set article_report_status=?,case_done=? where article_id=? ";

	@Override
	public void insert(ArticleReportVO ArticleReportVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(insert);

			pstmt.setInt(1, ArticleReportVO.getMember_id());
			pstmt.setInt(2, ArticleReportVO.getArticle_id());
			pstmt.setInt(3, ArticleReportVO.getArticle_report_reason());
			pstmt.setTimestamp(4, ArticleReportVO.getArticle_report_date());
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public ArticleReportVO findByArticleRepoPK(Integer article_report_id) {

		ArticleReportVO ArticleReportVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(findByArticleRepoPK);
			pstmt.setInt(1, article_report_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleReportVO = new ArticleReportVO();
				ArticleReportVO.setArticle_report_id(rs.getInt("Article_report_id"));
				ArticleReportVO.setMember_id(rs.getInt("Member_id"));
				ArticleReportVO.setArticle_id(rs.getInt("Article_id"));
				ArticleReportVO.setArticle_report_status(rs.getInt("Article_report_status"));
				ArticleReportVO.setArticle_report_reason(rs.getInt("Article_report_reason"));
				ArticleReportVO.setArticle_report_date(rs.getTimestamp("Article_report_date"));
				ArticleReportVO.setCase_done(rs.getDate("Case_done"));
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return ArticleReportVO;
	}

	@Override
	public List<ArticleReportVO> getAllArticleRepo() {

		List<ArticleReportVO> list = new ArrayList<ArticleReportVO>();
		ArticleReportVO ArticleReportVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(getAllArticleRepo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleReportVO = new ArticleReportVO();
				ArticleReportVO.setArticle_report_id(rs.getInt("Article_report_id"));
				ArticleReportVO.setMember_id(rs.getInt("Member_id"));
				ArticleReportVO.setArticle_id(rs.getInt("Article_id"));
				ArticleReportVO.setArticle_report_status(rs.getInt("Article_report_status"));
				ArticleReportVO.setArticle_report_reason(rs.getInt("Article_report_reason"));
				ArticleReportVO.setArticle_report_date(rs.getTimestamp("Article_report_date"));
				ArticleReportVO.setCase_done(rs.getDate("Case_done"));
				list.add(ArticleReportVO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public List<ArticleReportVO> findArticleRepoByStatus(Integer article_report_status) {

		List<ArticleReportVO> list = new ArrayList<ArticleReportVO>();
		ArticleReportVO ArticleReportVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(findArticleRepoByStatus);
			pstmt.setInt(1, article_report_status);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleReportVO = new ArticleReportVO();
				ArticleReportVO.setArticle_report_id(rs.getInt("Article_report_id"));
				ArticleReportVO.setMember_id(rs.getInt("Member_id"));
				ArticleReportVO.setArticle_id(rs.getInt("Article_id"));
				ArticleReportVO.setArticle_report_status(rs.getInt("Article_report_status"));
				ArticleReportVO.setArticle_report_reason(rs.getInt("Article_report_reason"));
				ArticleReportVO.setArticle_report_date(rs.getTimestamp("Article_report_date"));
				ArticleReportVO.setCase_done(rs.getDate("Case_done"));
				list.add(ArticleReportVO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@SuppressWarnings("finally")
	@Override
	public int updateArticleRepoStatus(Integer article_report_status,Date case_done , Integer article_id) {

		Connection con = null;
		PreparedStatement pstmt = null;
		int result = -1;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(updateArticleRepoStatus);
			pstmt.setInt(1, article_report_status);
			pstmt.setDate(2, case_done);
			pstmt.setInt(3, article_id);

			result = pstmt.executeUpdate();

		} catch (SQLException se) {
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. " + excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
			return result;
		}
	}

	@Override
	public void updateArticleRepo(ArticleReportVO ArticleReportVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(updateArticleRepo);
			pstmt.setInt(1, ArticleReportVO.getMember_id());
			pstmt.setInt(2, ArticleReportVO.getArticle_id());
			pstmt.setInt(3, ArticleReportVO.getArticle_report_status());
			pstmt.setInt(4, ArticleReportVO.getArticle_report_reason());
			pstmt.setDate(5, ArticleReportVO.getCase_done());
			pstmt.setInt(6, ArticleReportVO.getArticle_id());

			pstmt.executeUpdate();

		} catch (SQLException se) {

			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}

		}
	}

	@Override
	public void deleteArticleRepo(Integer article_report_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(deleteArticleRepo);
			pstmt.setInt(1, article_report_id);
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	
	public List<ArticleReportVO> findRepoByRepoPK(Integer article_report_id) {

		List<ArticleReportVO> list = new ArrayList<ArticleReportVO>();
		ArticleReportVO ArticleReportVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(findRepoByRepoPK);
			pstmt.setInt(1, article_report_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleReportVO = new ArticleReportVO();
				ArticleReportVO.setArticle_report_id(rs.getInt("Article_report_id"));
				ArticleReportVO.setMember_id(rs.getInt("Member_id"));
				ArticleReportVO.setArticle_id(rs.getInt("Article_id"));
				ArticleReportVO.setArticle_report_status(rs.getInt("Article_report_status"));
				ArticleReportVO.setArticle_report_reason(rs.getInt("Article_report_reason"));
				ArticleReportVO.setArticle_report_date(rs.getTimestamp("Article_report_date"));
				ArticleReportVO.setCase_done(rs.getDate("Case_done"));
				ArticleReportVO.setArticle_title(rs.getString("article_title"));
				ArticleReportVO.setArticle_content(rs.getString("article_content"));
				ArticleReportVO.setMember_name(rs.getString("member_name"));
				list.add(ArticleReportVO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

}
