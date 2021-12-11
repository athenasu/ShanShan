package tw.idv.tibame.tfa104.shanshan.web.cabinVacancy.dao.impl;

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

import tw.idv.tibame.tfa104.shanshan.web.cabinVacancy.dao.CabinVacancyDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.cabinVacancy.entity.CabinVacancyVO;
@Repository
public class CabinVacancyDAO implements CabinVacancyDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String insertCabinVacancy = "INSERT INTO cabin_vacancy (cabin_id,date, cabin_vacancy) VALUES (?,?,?)";
	private static final String update = "update cabin_vacancy set cabin_id =? ,date=?,cabin_vacancy=? where cabin_id=? and date=? ";
	private static final String deleteCabinVacancy = "delete from cabin_vacancy where cabin_id=? and date=?";
	private static final String getAllCabinVacancy = "select cabin_id,date, cabin_vacancy,update_time from cabin_vacancy oder by cabin_id";
	private static final String findByCabin = "Select cabin_id,date, cabin_vacancy,update_time from cabin_vacancy where cabin_id=?";

	@Override
	public void insertCabinVacancy(CabinVacancyVO CabinVacancyVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(insertCabinVacancy);
			pstmt.setInt(1, CabinVacancyVO.getCabin_id());
			pstmt.setDate(2, CabinVacancyVO.getDate());
			pstmt.setInt(3, CabinVacancyVO.getCabin_vacancy());

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
	public void update(CabinVacancyVO CabinVacancyVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(update);
			pstmt.setInt(1, CabinVacancyVO.getCabin_id());
			pstmt.setDate(2, CabinVacancyVO.getDate());
			pstmt.setInt(3, CabinVacancyVO.getCabin_vacancy());
			pstmt.setInt(4, CabinVacancyVO.getCabin_id());
			pstmt.setDate(5, CabinVacancyVO.getDate());
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
	public void deleteCabinVacancy(Integer cabin_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(deleteCabinVacancy);
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
	public CabinVacancyVO findByCabin(Integer cabin_id) {
		CabinVacancyVO CabinVacancyVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(findByCabin);
			pstmt.setInt(1, cabin_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CabinVacancyVO = new CabinVacancyVO();
				CabinVacancyVO.setCabin_id(rs.getInt("cabin_id"));
				CabinVacancyVO.setDate(rs.getDate("date"));
				CabinVacancyVO.setCabin_vacancy(rs.getInt("cabin_vacancy"));
				CabinVacancyVO.setUpdate_time(rs.getDate("update_time"));
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
		return CabinVacancyVO;
	}

	@Override
	public List<CabinVacancyVO> getAllCabinVacancy() {
		List<CabinVacancyVO> list = new ArrayList<CabinVacancyVO>();
		CabinVacancyVO CabinVacancyVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(getAllCabinVacancy);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CabinVacancyVO = new CabinVacancyVO();
				CabinVacancyVO.setCabin_id(rs.getInt("cabin_id"));
				CabinVacancyVO.setDate(rs.getDate("date"));
				CabinVacancyVO.setCabin_vacancy(rs.getInt("cabin_vacancy"));
				CabinVacancyVO.setUpdate_time(rs.getDate("update_time"));
				list.add(CabinVacancyVO); 
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
