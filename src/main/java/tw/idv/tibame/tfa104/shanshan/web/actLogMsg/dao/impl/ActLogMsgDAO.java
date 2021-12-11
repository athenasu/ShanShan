package tw.idv.tibame.tfa104.shanshan.web.actLogMsg.dao.impl;

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

import tw.idv.tibame.tfa104.shanshan.web.actLogMsg.dao.ActLogMsgDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.actLogMsg.entity.ActLogMsgVO;
@Repository
public class ActLogMsgDAO implements ActLogMsgDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String insertMsg = "INSERT INTO act_log_msg (article_id, member_id, msg_content) VALUES (?,?, ?)";
	private static final String update = "update act_log_msg set article_id=?, member_id=?, msg_content=? where act_msg_id=?";
	private static final String delete = "delect act_msg_id from act_log_msg where act_log_msg=?";
	private static final String findMsgPK = "Select act_msg_id, article_id, member_id, msg_time,msg_content,msg_status from act_log_msg  where act_msg_id=?";
	private static final String findMsgID = "Select act_msg_id, article_id, member_id, msg_time,msg_content,msg_status from act_log_msg  where article_id=?";
	private static final String getAllMsg = "Select act_msg_id, article_id, member_id, msg_time,msg_content,msg_status from act_log_msg  order by act_msg_id";
	
	
	private static final String findMsgByArtidStatus1 = "Select act_msg_id, article_id, member_id, msg_time,msg_content,msg_status from act_log_msg  where msg_status='1' and article_id=?";
	private static final String changeMsgStatus = "update act_log_msg set msg_status =? where act_msg_id=? ";

	@Override
	public void insertMsg(ActLogMsgVO ActLogMsgVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(insertMsg);

			pstmt.setInt(1, ActLogMsgVO.getArticle_id());
			pstmt.setInt(2, ActLogMsgVO.getMember_id());
			pstmt.setString(3, ActLogMsgVO.getMsg_content());

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
	public ActLogMsgVO findMsgByArtidStatus1(Integer article_id) {

		ActLogMsgVO ActLogMsgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(findMsgByArtidStatus1);
			pstmt.setInt(1, article_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ActLogMsgVO = new ActLogMsgVO();
				ActLogMsgVO.setAct_msg_id(rs.getInt("Act_msg_id"));
				ActLogMsgVO.setArticle_id(rs.getInt("Article_id"));
				ActLogMsgVO.setMember_id(rs.getInt("Member_id"));
				ActLogMsgVO.setMsg_time(rs.getDate("Msg_time"));
				ActLogMsgVO.setMsg_content(rs.getString("Msg_content"));
				ActLogMsgVO.setMsg_status(rs.getInt("Msg_status"));
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
		return ActLogMsgVO;
	}

	@Override
	public String changeMsgStatus(ActLogMsgVO ActLogMsgVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(changeMsgStatus);
			pstmt.setInt(1, ActLogMsgVO.getMsg_status());
			pstmt.setInt(2, ActLogMsgVO.getAct_msg_id());
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
	public void update(ActLogMsgVO ActLogMsgVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(update);
			pstmt.setInt(1, ActLogMsgVO.getArticle_id());
			pstmt.setInt(2, ActLogMsgVO.getMember_id());
			pstmt.setString(3, ActLogMsgVO.getMsg_content());
			pstmt.setInt(4, ActLogMsgVO.getAct_msg_id());

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
	public void delete(Integer act_msg_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, act_msg_id);
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
	public List<ActLogMsgVO> findMsgByPK(Integer act_msg_id) {
		List<ActLogMsgVO> list = new ArrayList<ActLogMsgVO>();

		ActLogMsgVO ActLogMsgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(findMsgPK);
			pstmt.setInt(1, act_msg_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ActLogMsgVO = new ActLogMsgVO();
				ActLogMsgVO.setAct_msg_id(rs.getInt("Act_msg_id"));
				ActLogMsgVO.setArticle_id(rs.getInt("Article_id"));
				ActLogMsgVO.setMember_id(rs.getInt("Member_id"));
				ActLogMsgVO.setMsg_time(rs.getDate("Msg_time"));
				ActLogMsgVO.setMsg_content(rs.getString("Msg_content"));
				ActLogMsgVO.setMsg_status(rs.getInt("Msg_status"));
				list.add(ActLogMsgVO);
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
	public List<ActLogMsgVO> getAllMsg() {
		List<ActLogMsgVO> list = new ArrayList<ActLogMsgVO>();
		ActLogMsgVO ActLogMsgVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(getAllMsg);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ActLogMsgVO = new ActLogMsgVO();
				ActLogMsgVO.setAct_msg_id(rs.getInt("Act_msg_id"));
				ActLogMsgVO.setArticle_id(rs.getInt("Article_id"));
				ActLogMsgVO.setMember_id(rs.getInt("Member_id"));
				ActLogMsgVO.setMsg_time(rs.getDate("Msg_time"));
				ActLogMsgVO.setMsg_content(rs.getString("Msg_content"));
				ActLogMsgVO.setMsg_status(rs.getInt("Msg_status"));
				list.add(ActLogMsgVO); 
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public List<ActLogMsgVO> findMsgByArtId(Integer article_id) {
		List<ActLogMsgVO> list = new ArrayList<ActLogMsgVO>();
		ActLogMsgVO ActLogMsgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(findMsgID);
			pstmt.setInt(1, article_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ActLogMsgVO = new ActLogMsgVO();
				ActLogMsgVO.setAct_msg_id(rs.getInt("Act_msg_id"));
				ActLogMsgVO.setArticle_id(rs.getInt("Article_id"));
				ActLogMsgVO.setMember_id(rs.getInt("Member_id"));
				ActLogMsgVO.setMsg_time(rs.getDate("Msg_time"));
				ActLogMsgVO.setMsg_content(rs.getString("Msg_content"));
				ActLogMsgVO.setMsg_status(rs.getInt("Msg_status"));
				list.add(ActLogMsgVO);
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
