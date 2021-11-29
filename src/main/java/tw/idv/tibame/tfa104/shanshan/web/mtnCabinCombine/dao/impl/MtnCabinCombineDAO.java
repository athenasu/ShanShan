package tw.idv.tibame.tfa104.shanshan.web.mtnCabinCombine.dao.impl;

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

import tw.idv.tibame.tfa104.shanshan.web.mtnCabinCombine.dao.MtnCabinCombineDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.mtnCabinCombine.entity.MtnCabinCombineVO;


public class MtnCabinCombineDAO implements MtnCabinCombineDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String insert = "INSERT INTO mtn_cabin_combine (mountain_id,cabin_id) VALUES (?,?)";
	private static final String update = "update mtn_cabin_combine set mountain_id=?,cabin_id=? where combine_id=? ";
	private static final String delete = "delete from mtn_cabin_combine where combine_id=? ";
	private static final String getAll = "select combine_id,mountain_id,cabin_id from mtn_cabin_combine oder by combine_id";
	private static final String findByPK = "Select ccombine_id,mountain_id,cabin_id from mtn_cabin_combine where combine_id=?";

	@Override
	public void insert(MtnCabinCombineVO MtnCabinCombineVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, MtnCabinCombineVO.getMountain_id());
			pstmt.setInt(2, MtnCabinCombineVO.getCabin_id());
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
	public void update(MtnCabinCombineVO MtnCabinCombineVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(update);
			pstmt.setInt(1, MtnCabinCombineVO.getMountain_id());
			pstmt.setInt(2, MtnCabinCombineVO.getCabin_id());
			pstmt.setInt(3, MtnCabinCombineVO.getCombine_id());
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
	public void delete(Integer combine_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, combine_id);
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
	public MtnCabinCombineVO findByPK(Integer combine_id) {
		MtnCabinCombineVO MtnCabinCombineVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(findByPK);
			pstmt.setInt(1, combine_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MtnCabinCombineVO = new MtnCabinCombineVO();
				MtnCabinCombineVO.setCombine_id(rs.getInt("combine_id"));
				MtnCabinCombineVO.setMountain_id(rs.getInt("mountain_id"));
				MtnCabinCombineVO.setCabin_id(rs.getInt("cabin_id"));
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
		return MtnCabinCombineVO;
	}

	@Override
	public List<MtnCabinCombineVO> getAll() {
		List<MtnCabinCombineVO> list = new ArrayList<MtnCabinCombineVO>();
		MtnCabinCombineVO MtnCabinCombineVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(getAll);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MtnCabinCombineVO = new MtnCabinCombineVO();
				MtnCabinCombineVO.setCombine_id(rs.getInt("combine_id"));
				MtnCabinCombineVO.setMountain_id(rs.getInt("mountain_id"));
				MtnCabinCombineVO.setCabin_id(rs.getInt("cabin_id"));
				list.add(MtnCabinCombineVO); 
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

	
	

}
