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
import tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.ArticlePictureVO;
import tw.idv.tibame.tfa104.shanshan.web.articlePicture.service.impl.ArticlePictureService;

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
	private static final String GET_ONE_STMT = "SELECT article_id,member_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn,aritcle_viewer,article_points_recieved FROM Article WHERE article_id = ?";
	private static final String GET_ALL_STMT = "SELECT article_id,member_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn,aritcle_viewer,article_points_recieved FROM Article ORDER BY article_date_created desc";
	private static final String DELETE = "DELETE FROM Article where article_id = ?";
	private static final String updateviews = "UPDATE Article set aritcle_viewer=? where article_id = ?";
	private static final String updatepoints = "UPDATE Article set article_points_recieved=? where article_id = ?";
	// 顯示瀏覽數、打賞數

	private static final String views = "SELECT article_viewer FROM Article where article_id = ?";
	private static final String recievedPoints = "SELECT article_points_recieved FROM Article where article_id = ?";

	// 排序:日期、瀏覽數、打賞數、推薦度
	private static final String orderByDate = "SELECT article_id,member_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn,aritcle_viewer,article_points_recieved FROM Article ORDER BY article_date_created desc";
	private static final String orderByViewer = "SELECT article_id,member_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn,aritcle_viewer,article_points_recieved FROM Article ORDER BY aritcle_viewer desc limit 5 ";
	private static final String orderByRecievedPoints = "SELECT article_id,member_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn,aritcle_viewer,article_points_recieved FROM Article ORDER BY article_points_recieved desc";
	private static final String orderByRecomm = "SELECT article_id,member_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn,aritcle_viewer,article_points_recieved FROM Article ORDER BY recommendation desc";

	// 查詢
	private static final String search ="SELECT * FROM Article a join member m on a.member_id = m.member_id join mountain mt on a.mountain_id = mt.mountain_id WHERE article_title like ? or article_content like ? or member_name like ? or mountain_name like ? ";

	// 給member後台使用 to athnea
	private static final String memIdRecievedPoints = "select member_id,sum(article_points_recieved) from article group by member_id=? ";
	private static final String findByMemIdGiveAll = "select *,article_picture_id,p.article_id,article_picture from article_picture p join article a on p.article_id = a.article_id  join mountain m on a.mountain_id = m.mountain_id where p.article_picture_id = (select min(article_picture_id) from article_picture where article_id = p.article_id group by article_id) and member_id=? ";
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
				ArticleVO.setArticle_id(rs.getInt("article_id"));
				ArticleVO.setMember_id(rs.getInt("member_id"));
				ArticleVO.setMountain_id(rs.getInt("mountain_id"));
				ArticleVO.setArticle_title(rs.getString("article_title"));
				ArticleVO.setArticle_content(rs.getString("article_content"));
				ArticleVO.setArticle_date_created(rs.getTimestamp("article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("event_date"));
				ArticleVO.setRecommendation(rs.getInt("recommendation"));
				ArticleVO.setOther_mtn(rs.getString("other_mtn"));
				ArticleVO.setAritcle_viewer(rs.getInt("aritcle_viewer"));
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
				ArticleVO.setArticle_date_created(rs.getTimestamp("article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("event_date"));
				ArticleVO.setRecommendation(rs.getInt("recommendation"));
				ArticleVO.setOther_mtn(rs.getString("other_mtn"));
				ArticleVO.setAritcle_viewer(rs.getInt("aritcle_viewer"));
				ArticleVO.setArticle_points_recieved(rs.getInt("article_points_recieved"));
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
				ArticleVO.setArticle_id(rs.getInt("article_id"));
				ArticleVO.setMember_id(rs.getInt("member_id"));
				ArticleVO.setMountain_id(rs.getInt("mountain_id"));
				ArticleVO.setArticle_title(rs.getString("article_title"));
				ArticleVO.setArticle_content(rs.getString("article_content"));
				ArticleVO.setArticle_date_created(rs.getTimestamp("article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("event_date"));
				ArticleVO.setRecommendation(rs.getInt("recommendation"));
				ArticleVO.setOther_mtn(rs.getString("other_mtn"));
				ArticleVO.setAritcle_viewer(rs.getInt("aritcle_viewer"));
				ArticleVO.setArticle_points_recieved(rs.getInt("article_points_recieved"));
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
				ArticleVO.setArticle_id(rs.getInt("article_id"));
				ArticleVO.setMember_id(rs.getInt("member_id"));
				ArticleVO.setMountain_id(rs.getInt("mountain_id"));
				ArticleVO.setArticle_title(rs.getString("article_title"));
				ArticleVO.setArticle_content(rs.getString("article_content"));
				ArticleVO.setArticle_date_created(rs.getTimestamp("article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("event_date"));
				ArticleVO.setRecommendation(rs.getInt("recommendation"));
				ArticleVO.setOther_mtn(rs.getString("other_mtn"));
				ArticleVO.setAritcle_viewer(rs.getInt("aritcle_viewer"));
				ArticleVO.setArticle_points_recieved(rs.getInt("article_points_recieved"));
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
				ArticleVO.setArticle_id(rs.getInt("article_id"));
				ArticleVO.setMember_id(rs.getInt("member_id"));
				ArticleVO.setMountain_id(rs.getInt("mountain_id"));
				ArticleVO.setArticle_title(rs.getString("article_title"));
				ArticleVO.setArticle_content(rs.getString("article_content"));
				ArticleVO.setArticle_date_created(rs.getTimestamp("article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("event_date"));
				ArticleVO.setRecommendation(rs.getInt("recommendation"));
				ArticleVO.setOther_mtn(rs.getString("other_mtn"));
				ArticleVO.setAritcle_viewer(rs.getInt("aritcle_viewer"));
				ArticleVO.setArticle_points_recieved(rs.getInt("article_points_recieved"));
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
				ArticleVO.setArticle_id(rs.getInt("article_id"));
				ArticleVO.setMember_id(rs.getInt("member_id"));
				ArticleVO.setMountain_id(rs.getInt("mountain_id"));
				ArticleVO.setArticle_title(rs.getString("article_title"));
				ArticleVO.setArticle_content(rs.getString("article_content"));
				ArticleVO.setArticle_date_created(rs.getTimestamp("article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("event_date"));
				ArticleVO.setRecommendation(rs.getInt("recommendation"));
				ArticleVO.setOther_mtn(rs.getString("other_mtn"));
				ArticleVO.setAritcle_viewer(rs.getInt("aritcle_viewer"));
				ArticleVO.setArticle_points_recieved(rs.getInt("article_points_recieved"));
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
				ArticleVO.setArticle_date_created(rs.getTimestamp("article_date_created"));
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

	@Override
	public String insertWithPic(ArticleVO ArticleVO, List<ArticlePictureVO> articlePictureVO) {
//		public String insertWithPic(ArticleVO ArticleVO, ArticlePictureVO articlePictureVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			con.setAutoCommit(false);

			String cols[] = { "article_id" };

			pstmt = con.prepareStatement(INSERT_STMT, cols);
			pstmt.setInt(1, ArticleVO.getMember_id());
			pstmt.setInt(2, ArticleVO.getMountain_id());
			pstmt.setString(3, ArticleVO.getArticle_title());
			pstmt.setString(4, ArticleVO.getArticle_content());
			pstmt.setDate(5, ArticleVO.getEvent_date());
			pstmt.setInt(6, ArticleVO.getRecommendation());
			pstmt.setString(7, ArticleVO.getOther_mtn());

			pstmt.executeUpdate();

			// 對應的自增主鍵值
			String next_article_id = null;
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				next_article_id = rs.getString(1);
			}
			rs.close();

			// 再同時新增圖片
			
//			多張圖片
			ArticlePictureVO articlePicvo  = new ArticlePictureVO();
			ArticlePictureService ArticlePictureSvc = new ArticlePictureService();

			for(int i=0; i < articlePictureVO.size() ; i++) {
//				System.out.println(i);
				articlePicvo = articlePictureVO.get(i);
				articlePicvo.setArticle_id(new Integer(next_article_id));
//				System.out.println(articlePicvo);
				ArticlePictureSvc.insert2(articlePicvo, con);
			}
						

//			單張圖片
//		ArticlePictureService ArticlePictureService = new ArticlePictureService();
//		articlePictureVO.setArticle_id(new Integer(next_article_id));
//		
//			ArticlePictureService.insert2(articlePictureVO, con);

			con.commit();
			con.setAutoCommit(true);

		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					System.err.print("Transaction is being ");
					System.err.println("rolled back articleDao");
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. " + excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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
		return "ok";
	}

	@Override
	public void updateviews(Integer aritcle_viewer, Integer article_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(updateviews);
			pstmt.setInt(1, aritcle_viewer);
			pstmt.setInt(2, article_id);
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
	public void updatepoints(Integer article_points_recieved, Integer article_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ArticleVO ArticleVO = null;
		int originPoints;
		try {

			con = ds.getConnection();
			
			pstmt = con.prepareStatement(recievedPoints);
			pstmt.setInt(1, article_id);
			rs = pstmt.executeQuery();		
			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setArticle_points_recieved(rs.getInt("article_points_recieved"));
			}
			
			originPoints = ArticleVO.getArticle_points_recieved();

			pstmt2 = con.prepareStatement(updatepoints);
			pstmt2.setInt(1, originPoints+article_points_recieved);
			pstmt2.setInt(2, article_id);
			pstmt2.executeUpdate();

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
	public List<ArticleVO> search(String article_title,String article_content, String member_name,String mountain_name) {
		
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		ArticleVO articleVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(search);
			pstmt.setString(1, "%"+article_title+"%");
			pstmt.setString(2, "%"+article_content+"%");
			pstmt.setString(3, "%"+member_name+"%");
			pstmt.setString(4, "%"+mountain_name+"%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				articleVO = new ArticleVO();
				articleVO.setArticle_id(rs.getInt("article_id"));
				articleVO.setMember_id(rs.getInt("member_id"));
				articleVO.setMember_name(rs.getString("member_name"));
				articleVO.setMountain_id(rs.getInt("mountain_id"));
				articleVO.setMountain_name(rs.getString("mountain_name"));
				articleVO.setArticle_title(rs.getString("article_title"));
				articleVO.setArticle_content(rs.getString("article_content"));
				articleVO.setArticle_date_created(rs.getTimestamp("article_date_created"));
				articleVO.setEvent_date(rs.getDate("event_date"));
				articleVO.setRecommendation(rs.getInt("recommendation"));
				articleVO.setOther_mtn(rs.getString("other_mtn"));
				articleVO.setAritcle_viewer(rs.getInt("aritcle_viewer"));
				list.add(articleVO);

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