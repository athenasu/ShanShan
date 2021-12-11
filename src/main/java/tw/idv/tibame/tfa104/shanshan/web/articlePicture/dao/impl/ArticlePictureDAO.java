package tw.idv.tibame.tfa104.shanshan.web.articlePicture.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import tw.idv.tibame.tfa104.shanshan.web.articlePicture.dao.ArticlePictureDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.ArticlePictureVO;

@Repository
public class ArticlePictureDAO implements ArticlePictureDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String insert = "INSERT INTO article_picture (article_id, article_picture) VALUES (?,?)";
	private static final String findByArtId = "Select article_picture_id, article_id, article_picture from article_picture where article_id=?";
	private static final String findByPicId = "Select article_picture_id, article_id, article_picture from article_picture where article_picture_id=?";
	private static final String getOnePic = "Select article_picture_id, article_id, article_picture from article_picture where article_id=? limit 1";
	private static final String update = "update article_picture set article_picture =? where article_id=? ";
	private static final String delete = "delete from article_picture where article_picture_id=? ";
	private static final String getAllArtPic = "Select article_picture_id, article_id, article_picture from article_picture order by article_picture_id ";

	@Override
	public void insert(ArticlePictureVO ArticlePictureVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(insert);

			pstmt.setInt(1, ArticlePictureVO.getArticle_id());
			pstmt.setBytes(2, ArticlePictureVO.getArticle_picture());

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
	public String update(ArticlePictureVO ArticlePictureVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(update);
			pstmt.setBytes(1, ArticlePictureVO.getArticle_picture());
			pstmt.setInt(2, ArticlePictureVO.getArticle_id());
			pstmt.executeUpdate();

		} catch (SQLException se) {
			if (con != null) {
				try {
					con.rollback();
					return "fail";
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
		}
		return "success";
	}

	@Override
	public ArticlePictureVO findByPicId(Integer article_picture_id) {
		ArticlePictureVO ArticlePictureVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(findByPicId);
			pstmt.setInt(1, article_picture_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticlePictureVO = new ArticlePictureVO();
				ArticlePictureVO.setArticle_picture_id(rs.getInt("article_picture_id"));
				ArticlePictureVO.setArticle_id(rs.getInt("article_id"));
				ArticlePictureVO.setArticle_picture(rs.getBytes("article_picture"));
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
		return ArticlePictureVO;
	}
	
	public List<ArticlePictureVO> findByArtId(Integer article_id) {
		List<ArticlePictureVO> list = new ArrayList<ArticlePictureVO>();
		ArticlePictureVO ArticlePictureVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(findByArtId);
			pstmt.setInt(1, article_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticlePictureVO = new ArticlePictureVO();
				ArticlePictureVO.setArticle_picture_id(rs.getInt("article_picture_id"));
				ArticlePictureVO.setArticle_id(rs.getInt("article_id"));
				ArticlePictureVO.setArticle_picture(rs.getBytes("article_picture"));
				list.add(ArticlePictureVO);
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
	public void delete(Integer article_picture_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, article_picture_id);
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
	public List<ArticlePictureVO> getAllArtPic() {
		List<ArticlePictureVO> list = new ArrayList<ArticlePictureVO>();
		ArticlePictureVO ArticlePictureVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(getAllArtPic);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticlePictureVO = new ArticlePictureVO();
				ArticlePictureVO.setArticle_picture_id(rs.getInt("article_picture_id"));
				ArticlePictureVO.setArticle_id(rs.getInt("article_id"));
				ArticlePictureVO.setArticle_picture(rs.getBytes("article_picture"));

				list.add(ArticlePictureVO);
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
	public ArticlePictureVO getOnePic(Integer article_id) {
		ArticlePictureVO ArticlePictureVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(getOnePic);
			pstmt.setInt(1, article_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticlePictureVO = new ArticlePictureVO();
				ArticlePictureVO.setArticle_picture_id(rs.getInt("article_picture_id"));
				ArticlePictureVO.setArticle_id(rs.getInt("article_id"));
				ArticlePictureVO.setArticle_picture(rs.getBytes("article_picture"));

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
		return ArticlePictureVO;
	}

	@Override
//	public void  insert2(ArticlePictureVO articlePictureVO,Connection con) {
//		PreparedStatement pstmt = null;
//		System.out.println("=====================================");
//		System.out.println(articlePictureVO);
//		ArticlePictureVO articlePicVO = new ArticlePictureVO();
//		System.out.println(articlePicVO);
//		try {
			//多張圖片測試
//			ArticlePictureVO article = new ArticlePictureVO();
//			for(int i=0;i<articlePictureVO.size();i++) {
//				article=articlePictureVO.get(i);
////				System.out.println(articlePictureVO.get(i).getArticle_id());
//				pstmt = con.prepareStatement(insert);
//				pstmt.setInt(1, article.getArticle_id());
//				pstmt.setBytes(2, article.getArticle_picture());
//				
//			}
//			articlePictureVO.add(article);
//				pstmt.executeUpdate();
		public void  insert2(ArticlePictureVO articlePictureVO,Connection con) {
			PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, articlePictureVO.getArticle_id());
			pstmt.setBytes(2, articlePictureVO.getArticle_picture());
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					System.err.print("Transaction is being ");
					System.err.println("rolled back from picDao");
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
	}
}
