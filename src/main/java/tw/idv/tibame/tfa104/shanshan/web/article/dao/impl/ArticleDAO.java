package tw.idv.tibame.tfa104.shanshan.web.article.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.article.dao.ArticleDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;
@Repository
public class ArticleDAO implements ArticleDAO_interface {


	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO Article (member_id, mountain_id, article_title, article_content, event_date,recommendation,other_mtn) VALUES (?,?, ?, ?, ?,?,?)";
	private static final String UPDATE = "UPDATE Article set mountain_id=?, article_title=?, article_content=?, event_date=?,recommendation=?,other_mtn=? WHERE article_id = ?";
	private static final String GET_ONE_STMT = "SELECT article_id,member_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn,aritcle_viewer FROM Article WHERE article_id = ?";
	private static final String GET_ALL_STMT = "SELECT article_id,member_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn,aritcle_viewer FROM Article ORDER BY article_date_created desc";
	private static final String DELETE = "DELETE FROM Article where article_id = ?";

	// 顯示瀏覽數、打賞數

	private static final String views = "SELECT article_viewer FROM Article where article_id = ?";
	private static final String recievedPoints = "SELECT article_points_recieved FROM Article where article_id = ?";

	// 排序:日期、瀏覽數、打賞數、推薦度
	private static final String orderByDate = "SELECT member_id,article_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn FROM Article ORDER BY article_date_created desc";
	private static final String orderByViewer = "SELECT member_id,article_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn,aritcle_viewer FROM Article ORDER BY aritcle_viewer desc limit 5 ";
	private static final String orderByRecievedPoints = "SELECT member_id,article_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn FROM Article ORDER BY article_points_recieved desc";
	private static final String orderByRecomm = "SELECT member_id,article_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn FROM Article ORDER BY recommendation desc";

	// 複合查詢後補

	// 給member後台使用 to athnea
	private static final String memIdRecievedPoints = "select member_id,sum(article_points_recieved) from article group by member_id=? ";
	private static final String findByMemIdGiveAll ="select *,article_picture_id,p.article_id,article_picture from article_picture p join article a on p.article_id = a.article_id  join mountain m on a.mountain_id = m.mountain_id where p.article_picture_id = (select min(article_picture_id) from article_picture where article_id = p.article_id group by article_id) and member_id=? " ;
	// 網誌狀態 to owen
	private static final String updateArticleStatus = "UPDATE Article set article_status=? WHERE article_id = ?";

	@Override
	public void insert(ArticleVO ArticleVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, ArticleVO.getMember_id());
			pstmt.setInt(2, ArticleVO.getMountain_id());
			pstmt.setString(3, ArticleVO.getArticle_title());
			pstmt.setString(4, ArticleVO.getArticle_content());
			pstmt.setDate(5, ArticleVO.getEvent_date());
			pstmt.setInt(6, ArticleVO.getRecommendation());
			pstmt.setString(7, ArticleVO.getOther_mtn());

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
	public void update(ArticleVO ArticleVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, ArticleVO.getMountain_id());
			pstmt.setString(2, ArticleVO.getArticle_title());
			pstmt.setString(3, ArticleVO.getArticle_content());
			pstmt.setDate(4, ArticleVO.getEvent_date());
			pstmt.setInt(5, ArticleVO.getRecommendation());
			pstmt.setString(6, ArticleVO.getOther_mtn());
			pstmt.setInt(7, ArticleVO.getArticle_id());

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
	public void delete(Integer article_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, article_id);

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
	public ArticleVO findByPrimaryKey(Integer article_id) {

		ArticleVO ArticleVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, article_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setArticle_id(rs.getInt("member_id"));
				ArticleVO.setMember_id(rs.getInt("article_id"));
				ArticleVO.setMountain_id(rs.getInt("mountain_id"));
				ArticleVO.setArticle_title(rs.getString("article_title"));
				ArticleVO.setArticle_content(rs.getString("article_content"));
				ArticleVO.setArticle_date_created(rs.getDate("article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("event_date"));
				ArticleVO.setRecommendation(rs.getInt("recommendation"));
				ArticleVO.setOther_mtn(rs.getString("other_mtn"));
				ArticleVO.setAritcle_viewer(rs.getInt("aritcle_viewer"));
				
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
		return ArticleVO;
	}

	@Override
	public List<ArticleVO> getAll() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		ArticleVO ArticleVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setArticle_id(rs.getInt("article_id"));
				ArticleVO.setMember_id(rs.getInt("member_id"));
				ArticleVO.setMountain_id(rs.getInt("mountain_id"));
				ArticleVO.setArticle_title(rs.getString("article_title"));
				ArticleVO.setArticle_content(rs.getString("article_content"));
				ArticleVO.setArticle_date_created(rs.getDate("article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("event_date"));
				ArticleVO.setRecommendation(rs.getInt("recommendation"));
				ArticleVO.setOther_mtn(rs.getString("other_mtn"));
				ArticleVO.setAritcle_viewer(rs.getInt("aritcle_viewer"));
				list.add(ArticleVO);
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
	public ArticleVO views(Integer article_id) {

		ArticleVO ArticleVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(views);

			pstmt.setInt(1, article_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setAritcle_viewer(rs.getInt("aritcle_viewer"));

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
		return ArticleVO;
	}

	@Override
	public ArticleVO recievedPoints(Integer article_id) {
		ArticleVO ArticleVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(recievedPoints);

			pstmt.setInt(1, article_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setArticle_points_recieved(rs.getInt("article_points_received"));
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
		return ArticleVO;
	}

	@Override
	public List<ArticleVO> orderByDate() {

		List<ArticleVO> list = new ArrayList<ArticleVO>();
		ArticleVO ArticleVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(orderByDate);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setMember_id(rs.getInt("member_id"));
				ArticleVO.setArticle_id(rs.getInt("article_id"));

				ArticleVO.setMountain_id(rs.getInt("mountain_id"));
				ArticleVO.setArticle_title(rs.getString("article_title"));
				ArticleVO.setArticle_content(rs.getString("article_content"));
				ArticleVO.setArticle_date_created(rs.getDate("article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("event_date"));
				ArticleVO.setRecommendation(rs.getInt("recommendation"));
				ArticleVO.setOther_mtn(rs.getString("other_mtn"));
				list.add(ArticleVO);
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
	public List<ArticleVO> orderByViewer() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		ArticleVO ArticleVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(orderByViewer);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setMember_id(rs.getInt("member_id"));
				ArticleVO.setArticle_id(rs.getInt("article_id"));
				ArticleVO.setMountain_id(rs.getInt("mountain_id"));
				ArticleVO.setArticle_title(rs.getString("article_title"));
				ArticleVO.setArticle_content(rs.getString("article_content"));
				ArticleVO.setArticle_date_created(rs.getDate("article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("event_date"));
				ArticleVO.setRecommendation(rs.getInt("recommendation"));
				ArticleVO.setOther_mtn(rs.getString("other_mtn"));
				ArticleVO.setAritcle_viewer(rs.getInt("aritcle_viewer"));			
				list.add(ArticleVO);
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
	public List<ArticleVO> orderByRecievedPoints() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		ArticleVO ArticleVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(orderByRecievedPoints);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setMember_id(rs.getInt("member_id"));
				ArticleVO.setArticle_id(rs.getInt("article_id"));

				ArticleVO.setMountain_id(rs.getInt("mountain_id"));
				ArticleVO.setArticle_title(rs.getString("article_title"));
				ArticleVO.setArticle_content(rs.getString("article_content"));
				ArticleVO.setArticle_date_created(rs.getDate("article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("event_date"));
				ArticleVO.setRecommendation(rs.getInt("recommendation"));
				ArticleVO.setOther_mtn(rs.getString("other_mtn"));
				list.add(ArticleVO);
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
	public List<ArticleVO> orderByRecomm() {
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		ArticleVO ArticleVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(orderByRecomm);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setMember_id(rs.getInt("member_id"));
				ArticleVO.setArticle_id(rs.getInt("article_id"));

				ArticleVO.setMountain_id(rs.getInt("mountain_id"));
				ArticleVO.setArticle_title(rs.getString("article_title"));
				ArticleVO.setArticle_content(rs.getString("article_content"));
				ArticleVO.setArticle_date_created(rs.getDate("article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("event_date"));
				ArticleVO.setRecommendation(rs.getInt("recommendation"));
				ArticleVO.setOther_mtn(rs.getString("other_mtn"));
				list.add(ArticleVO);
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

	// 給member後台使用 to athnea

	@Override
	public List<ArticleVO> findByMemIdGiveAll(Integer member_id) {
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		ArticleVO ArticleVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(findByMemIdGiveAll);

			pstmt.setInt(1, member_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setArticle_id(rs.getInt("article_id"));
				ArticleVO.setMember_id(rs.getInt("member_id"));
				ArticleVO.setMountain_id(rs.getInt("mountain_id"));
				ArticleVO.setArticle_title(rs.getString("article_title"));
				ArticleVO.setArticle_content(rs.getString("article_content"));
				ArticleVO.setArticle_date_created(rs.getDate("article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("event_date"));
				ArticleVO.setArticle_points_recieved(rs.getInt("article_points_recieved"));
				ArticleVO.setOther_mtn(rs.getString("other_mtn"));
				// mountain table
				ArticleVO.setMountain_district(rs.getInt("mountain_district"));
				ArticleVO.setMountain_name(rs.getString("mountain_name"));
				ArticleVO.setMountain_longitude(rs.getBigDecimal("mountain_longitude"));
				ArticleVO.setMountain_latitude(rs.getBigDecimal("mountain_latitude"));
				// Article picture table
				ArticleVO.setArticle_picture_id(rs.getInt("article_picture_id"));
				ArticleVO.setArticle_picture(rs.getBytes("article_picture"));
				list.add(ArticleVO);
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
	public ArticleVO memIdRecievedPoints(Integer member_id) {

		ArticleVO ArticleVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(memIdRecievedPoints);
			pstmt.setInt(1, member_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setMember_id(rs.getInt("member_id"));
				ArticleVO.setArticle_points_recieved(rs.getInt("article_points_recieved"));

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
		return ArticleVO;
	}

	// 網誌狀態 to owen

	
	@SuppressWarnings("finally")
	@Override
	public int updateArticleStatus(Integer article_status, Integer article_id) {

		Connection con = null;
		PreparedStatement pstmt = null;
		int result = -1;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(updateArticleStatus);
			pstmt.setInt(1, article_status);
			pstmt.setInt(2, article_id);
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

}
