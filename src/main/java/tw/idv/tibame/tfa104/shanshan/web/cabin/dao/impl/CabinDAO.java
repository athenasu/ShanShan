package tw.idv.tibame.tfa104.shanshan.web.cabin.dao.impl;

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

import tw.idv.tibame.tfa104.shanshan.web.cabin.dao.CabinDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.cabin.entity.CabinVO;
@Repository
public class CabinDAO implements CabinDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String insertCabin = "INSERT INTO cabin (cabin_name,cabin_pic) VALUES (?,?,?)";
	private static final String updateCabin = "update cabin set cabin_name=?,cabin_pic=? where cabin_id=? ";
	private static final String deleteCabin = "delete from cabin where cabin_id=? ";
	private static final String getAllCabin = "select cabin_id,cabin_name,cabin_pic from cabin oder by cabin_id";

	private static final String findByCabinId = "Select cabin_id,cabin_name,cabin_pic from cabin where cabin_id=?";

	@Override
	public void insertCabin(CabinVO CabinVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(insertCabin);
			pstmt.setString(1, CabinVO.getCabin_name());
			pstmt.setBytes(2, CabinVO.getCabin_pic());
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
	public void updateCabin(CabinVO CabinVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(updateCabin);
			pstmt.setString(1, CabinVO.getCabin_name());
			pstmt.setBytes(2, CabinVO.getCabin_pic());
			pstmt.setInt(3, CabinVO.getCabin_id());
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
	public void deleteCabin(Integer cabin_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(deleteCabin);
			pstmt.setInt(1, cabin_id);
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
	public List<CabinVO> getAllCabin() {
		List<CabinVO> list = new ArrayList<CabinVO>();
		CabinVO CabinVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(getAllCabin);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CabinVO = new CabinVO();
				CabinVO.setCabin_id(rs.getInt("cabin_id"));
				CabinVO.setCabin_name(rs.getString("cabin_name"));
				CabinVO.setCabin_pic(rs.getBytes("cabin_pic"));
				list.add(CabinVO); 
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
	public CabinVO findByCabinId(Integer cabin_id) {
		CabinVO CabinVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(findByCabinId);
			pstmt.setInt(1, cabin_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CabinVO = new CabinVO();
				CabinVO.setCabin_id(rs.getInt("cabin_id"));
				CabinVO.setCabin_name(rs.getString("cabin_name"));
				CabinVO.setCabin_pic(rs.getBytes("cabin_pic"));
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
		return CabinVO;
	}

	
}
