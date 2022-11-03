package tw.idv.tibame.tfa104.shanshan.web.article.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.article.dao.ArticleDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;
import tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.ArticlePictureVO;

public class ArticleJDBCDAO implements ArticleDAO_interface {


	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/ShanShan?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = "INSERT INTO article (member_id, mountain_id, article_title, article_content, event_date,recommendation,other_mtn) VALUES (?,?, ?, ?, ?,?,?)";
	private static final String UPDATE = "UPDATE article set mountain_id=?, article_title=?, article_content=?, event_date=?,recommendation=?,other_mtn=? WHERE article_id = ?";
	private static final String GET_ONE_STMT = "SELECT article_id,member_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn,aritcle_viewer,article_points_recieved FROM article WHERE article_id = ?";

//	private static final String GET_ONE_STMT = "SELECT mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn,article_points_recieved FROM article WHERE article_id = ?";
	private static final String GET_ALL_STMT = "SELECT mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn,article_points_recieved FROM article ORDER BY article_id";
	private static final String DELETE = "DELETE FROM article where article_id = ?";
	private static final String updatepoints = "UPDATE article set article_points_recieved = ? where article_id = ?";

	// 顯示瀏覽數、打賞數

	private static final String views = "SELECT article_viewer FROM article where article_id = ?";
	private static final String recievedPoints = "SELECT article_points_recieved FROM article where article_id = ?";

	// 排序:日期、瀏覽數、打賞數、推薦度
	private static final String orderByDate = "SELECT article_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn FROM article ORDER BY article_date_created desc";
	private static final String orderByViewer = "SELECT article_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn FROM article ORDER BY aritcle_viewer desc";
	private static final String orderByRecievedPoints = "SELECT article_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn FROM article ORDER BY article_points_recieved desc";
	private static final String orderByRecomm = "SELECT article_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn FROM article ORDER BY recommendation desc";

	// 複合查詢後補
	private static final String search ="SELECT * FROM article a join member m on a.member_id = m.member_id join mountain mt on a.mountain_id = mt.mountain_id WHERE article_title like ? or article_content like ? or member_name like ? or mountain_name like ?";

	// 給member後台使用 to athnea
//	private static final String findByMemIdGiveAll ="select a.member_id, a.article_id, a.article_title,a.article_date_created,a.event_date,a.mountain_id,a.other_mtn,m.mountain_name,m.mountain_district,m.mountain_latitude,m.mountain_longitude,a.article_points_recieved,a.article_content,min(p.article_picture)from article a  join article_picture p on a.article_id = p.article_id join mountain m on a.mountain_id = m.mountain_id  where a.member_id= ?  group by a.article_id " ;
	private static final String findByMemIdGiveAll ="select *,article_picture_id,p.article_id,article_picture from article_picture p join article a on p.article_id = a.article_id  join mountain m on a.mountain_id = m.mountain_id where p.article_picture_id = (select min(article_picture_id) from article_picture where article_id = p.article_id group by article_id) and member_id=? " ;
	private static final String memIdRecievedPoints = "select member_id,sum(article_points_recieved) from article group by member_id=? ";

	// 網誌狀態 to owen
	private static final String updateArticleStatus = "UPDATE article set article_status=? WHERE article_id = ?";
	
	@Override
	public void insert(ArticleVO ArticleVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, ArticleVO.getMember_id());
			pstmt.setInt(2, ArticleVO.getMountain_id());
			pstmt.setString(3, ArticleVO.getArticle_title());
			pstmt.setString(4, ArticleVO.getArticle_content());
			pstmt.setDate(5, ArticleVO.getEvent_date());
			pstmt.setInt(6, ArticleVO.getRecommendation());
			pstmt.setString(7, ArticleVO.getOther_mtn());

			pstmt.executeUpdate();

		} catch (Exception se) {
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, ArticleVO.getMountain_id());
			pstmt.setString(2, ArticleVO.getArticle_title());
			pstmt.setString(3, ArticleVO.getArticle_content());
			pstmt.setDate(4, ArticleVO.getEvent_date());
			pstmt.setInt(5, ArticleVO.getRecommendation());
			pstmt.setString(6, ArticleVO.getOther_mtn());
			pstmt.setInt(7, ArticleVO.getArticle_id());

			pstmt.executeUpdate();

		} catch (Exception se) {
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, article_id);

			pstmt.executeUpdate();

		} catch (Exception se) {
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);			
			pstmt = con.prepareStatement(recievedPoints);
			pstmt.setInt(1, article_id);
			rs = pstmt.executeQuery();		
			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setArticle_points_recieved(rs.getInt("article_points_recieved"));
			}
			originPoints=ArticleVO.getArticle_points_recieved();
			System.out.println(originPoints);
			
			pstmt2 = con.prepareStatement(updatepoints);
			pstmt2.setInt(1, originPoints + article_points_recieved);
			pstmt2.setInt(2, article_id);
			pstmt2.executeUpdate();

		} catch (Exception se) {
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, article_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setMember_id(rs.getInt("Member_id"));
				ArticleVO.setArticle_id(rs.getInt("article_id"));
				ArticleVO.setMountain_id(rs.getInt("Mountain_id"));
				ArticleVO.setArticle_title(rs.getString("Article_title"));
				ArticleVO.setArticle_content(rs.getString("Article_content"));
				ArticleVO.setArticle_date_created(rs.getTimestamp("Article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("Event_date"));
				ArticleVO.setRecommendation(rs.getInt("Recommendation"));
				ArticleVO.setOther_mtn(rs.getString("Other_mtn"));
				ArticleVO.setArticle_points_recieved(rs.getInt("article_points_recieved"));
			}

		} catch (Exception se) {
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setMember_id(rs.getInt("Member_id"));
				ArticleVO.setMountain_id(rs.getInt("Mountain_id"));
				ArticleVO.setArticle_title(rs.getString("Article_title"));
				ArticleVO.setArticle_content(rs.getString("Article_content"));
				ArticleVO.setArticle_date_created(rs.getTimestamp("Article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("Event_date"));
				ArticleVO.setRecommendation(rs.getInt("Recommendation"));
				ArticleVO.setOther_mtn(rs.getString("Other_mtn"));
				list.add(ArticleVO);
			}

		} catch (Exception se) {
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(views);
			rs = pstmt.executeQuery();


			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setAritcle_viewer(rs.getInt("aritcle_viewer"));

			}

		} catch (Exception se) {
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(recievedPoints);

			pstmt.setInt(1, article_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setArticle_points_recieved(rs.getInt("article_points_received"));
			}

		} catch (Exception se) {
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(orderByDate);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setMember_id(rs.getInt("Member_id"));
				ArticleVO.setMountain_id(rs.getInt("Mountain_id"));
				ArticleVO.setArticle_title(rs.getString("Article_title"));
				ArticleVO.setArticle_content(rs.getString("Article_content"));
				ArticleVO.setArticle_date_created(rs.getTimestamp("Article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("Event_date"));
				ArticleVO.setRecommendation(rs.getInt("Recommendation"));
				ArticleVO.setOther_mtn(rs.getString("Other_mtn"));
				list.add(ArticleVO);
			}

		} catch (Exception se) {
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(orderByViewer);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setMember_id(rs.getInt("Member_id"));
				ArticleVO.setMountain_id(rs.getInt("Mountain_id"));
				ArticleVO.setArticle_title(rs.getString("Article_title"));
				ArticleVO.setArticle_content(rs.getString("Article_content"));
				ArticleVO.setArticle_date_created(rs.getTimestamp("Article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("Event_date"));
				ArticleVO.setRecommendation(rs.getInt("Recommendation"));
				ArticleVO.setOther_mtn(rs.getString("Other_mtn"));
				list.add(ArticleVO);
			}

		} catch (Exception se) {
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(orderByRecievedPoints);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setMember_id(rs.getInt("Member_id"));
				ArticleVO.setMountain_id(rs.getInt("Mountain_id"));
				ArticleVO.setArticle_title(rs.getString("Article_title"));
				ArticleVO.setArticle_content(rs.getString("Article_content"));
				ArticleVO.setArticle_date_created(rs.getTimestamp("Article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("Event_date"));
				ArticleVO.setRecommendation(rs.getInt("Recommendation"));
				ArticleVO.setOther_mtn(rs.getString("Other_mtn"));
				list.add(ArticleVO);
			}

		} catch (Exception se) {
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(orderByRecomm);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setMember_id(rs.getInt("Member_id"));
				ArticleVO.setMountain_id(rs.getInt("Mountain_id"));
				ArticleVO.setArticle_title(rs.getString("Article_title"));
				ArticleVO.setArticle_content(rs.getString("Article_content"));
				ArticleVO.setArticle_date_created(rs.getTimestamp("Article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("Event_date"));
				ArticleVO.setRecommendation(rs.getInt("Recommendation"));
				ArticleVO.setOther_mtn(rs.getString("Other_mtn"));
				list.add(ArticleVO);
			}

		} catch (Exception se) {
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
//	public ArticleVO findByMemIdGiveAll(Integer member_id) {
		public List<ArticleVO> findByMemIdGiveAll(Integer member_id) {
			
			List<ArticleVO> list = new ArrayList<ArticleVO>();
			
		ArticleVO ArticleVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
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
				// article picture table
				ArticleVO.setArticle_picture_id(rs.getInt("article_picture_id"));
				ArticleVO.setArticle_picture(rs.getBytes("article_picture"));
				list.add(ArticleVO);
			}

		} catch (Exception se) {
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(memIdRecievedPoints);
			pstmt.setInt(1, member_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setMember_id(rs.getInt("Member_id"));
				ArticleVO.setArticle_points_recieved(rs.getInt("Article_points_recieved"));

			}

		} catch (Exception se) {
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
		int xxx = -1;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			con = ds.getConnection();
			pstmt = con.prepareStatement(updateArticleStatus);
			pstmt.setInt(1, article_status);
			pstmt.setInt(2, article_id);
			xxx = pstmt.executeUpdate();


		} catch (Exception se) {
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
			return xxx;//回傳成功比數，等於0就是失敗
		}}
	
		@Override
		public List<ArticleVO> search(String article_title,String article_content, String member_name,String mountain_name) {
			List<ArticleVO> list = new ArrayList<ArticleVO>();
			ArticleVO ArticleVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

					
			try {
				
				Class.forName(driver);
				
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(search);

				pstmt.setString(1, "%"+article_title+"%");
				pstmt.setString(2, "%"+article_content+"%");
				pstmt.setString(3, "%"+member_name+"%");
				pstmt.setString(4, "%"+mountain_name+"%");
				rs = pstmt.executeQuery();

				while (rs.next()) {
					ArticleVO = new ArticleVO();
					ArticleVO.setArticle_id(rs.getInt("article_id"));
					ArticleVO.setMember_id(rs.getInt("member_id"));
					ArticleVO.setMember_name(rs.getString("member_name"));
					ArticleVO.setMountain_id(rs.getInt("mountain_id"));
					ArticleVO.setMountain_name(rs.getString("mountain_name"));
					ArticleVO.setArticle_title(rs.getString("article_title"));
					ArticleVO.setArticle_content(rs.getString("article_content"));
					ArticleVO.setArticle_date_created(rs.getTimestamp("article_date_created"));
					ArticleVO.setEvent_date(rs.getDate("event_date"));
					ArticleVO.setRecommendation(rs.getInt("recommendation"));
					ArticleVO.setOther_mtn(rs.getString("other_mtn"));
					ArticleVO.setAritcle_viewer(rs.getInt("aritcle_viewer"));
					list.add(ArticleVO);

				}

			} catch (Exception se) {
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
	
		
	
	public static void main(String[] args) {

		ArticleJDBCDAO dao= new ArticleJDBCDAO();
//
//		// 新增

//
//		// 修改
		ArticleVO ArticleVO = new ArticleVO();
//		ArticleVO.setArticle_points_recieved(5);;
//		ArticleVO.setArticle_id(2023);;
//		dao.updatepoints(7, 2001);
//		System.out.println(dao);
//
//		// 刪除
//		dao.delete(7014);
//
//		// 查詢
//		ArticleVO = dao.findByMtn(2);
		List<ArticleVO> list=dao.findByMtn(2);
		System.out.print(list);

//		System.out.print(ArticleVO.getArticle_id() + ",");
//		System.out.print(ArticleVO.getMember_id() + ",");
//		System.out.print(ArticleVO.getMountain_id() + ",");
//		System.out.print(ArticleVO.getMountain_name() + ",");
//		System.out.print(ArticleVO.getArticle_picture() + ",");
//		System.out.print(ArticleVO.getArticle_points_recieved() + ",");
//
//		System.out.println("---------------------");

		// 查詢
//		List<ArticleVO> list = dao.search("天向", "天向", "天向", "天向");
//		System.out.print(list);
//		for (ArticleVO art : list) {
//			System.out.print(art.getMember_name() + ",");
//			System.out.print(art.getMountain_name() + ",");
//			System.out.print(art.getArticle_content() + ",");
//			System.out.print(art.getArticle_title() + ",");
//			System.out.print(art.getEvent_date() + ",");
//
//		}
	}

	@Override
	public void updateviews(Integer aritcle_viewer, Integer article_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String insertWithPic(ArticleVO ArticleVO, List<ArticlePictureVO> articlePictureVO) {
		// TODO Auto-generated method stub
		return null;
	}
	private static final String findByMtn = "SELECT article_id,member_id,mountain_id, article_title, article_content, article_date_created,event_date,recommendation,other_mtn,aritcle_viewer,article_points_recieved FROM article WHERE mountain_id = ?";

	@Override
	public List<ArticleVO> findByMtn(Integer mountain_id) {
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		ArticleVO ArticleVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

				
		try {
			
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(findByMtn);

			pstmt.setInt(1, mountain_id);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO = new ArticleVO();
				ArticleVO.setMember_id(rs.getInt("Member_id"));
				ArticleVO.setArticle_id(rs.getInt("article_id"));
				ArticleVO.setMountain_id(rs.getInt("Mountain_id"));
				ArticleVO.setArticle_title(rs.getString("Article_title"));
				ArticleVO.setArticle_content(rs.getString("Article_content"));
				ArticleVO.setArticle_date_created(rs.getTimestamp("Article_date_created"));
				ArticleVO.setEvent_date(rs.getDate("Event_date"));
				ArticleVO.setRecommendation(rs.getInt("Recommendation"));
				ArticleVO.setOther_mtn(rs.getString("Other_mtn"));
				ArticleVO.setArticle_points_recieved(rs.getInt("article_points_recieved"));
				list.add(ArticleVO);

			}

		} catch (Exception se) {
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

//art.getArticle_id()
//art.getMember_id()
//art.getMountain_id()
//art.getArticle_title()
//art.getArticle_content()
//art.getArticle_date_created()
//art.getEvent_date()
//art.getRecommendation()
//art.getArticle_points_recieved()
//art.getArticle_status()
//art.getAritcle_viewer()
//art.getOther_mtn()
//
//art.getMountain_district()
//art.getMountain_name()
//art.getMountain_longitude()
//art.getMountain_latitude()
//
//art.getArticle_picture_id()
//art.getArticle_picture()
