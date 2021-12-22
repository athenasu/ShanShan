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

import tw.idv.tibame.tfa104.shanshan.web.cabin.dao.MtnForCabinDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.mountain.entity.Mountain;
@Repository
public class MtnForCabinDAO implements MtnForCabinDAO_interface{

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//for mtn from mtn
	private static final String findByDistrict ="select mountain_id,mountain_district,mountain_name,mountain_longitude,mountain_latitude,mountain_pic,mountain_info from mountain where mountain_district =? ";
	//for mtn from event
	private static final String eventByMtn ="select mountain_id ,event_name,event_id from event where mountain_id=?";
	@Override
	public List<Mountain> findByDistrict(Integer moutainDistrict) {
		List<Mountain> list = new ArrayList<Mountain>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(findByDistrict);
			pstmt.setInt(1, moutainDistrict);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Mountain mtn = new Mountain();
				mtn.setMountainId(rs.getInt("mountain_id"));;
				mtn.setMountainName(rs.getString("mountain_name"));
				mtn.setMoutainDistrict(rs.getInt("mountain_district"));
				mtn.setMountainLatitude(rs.getBigDecimal("mountain_latitude"));
				mtn.setMountainLongitude(rs.getBigDecimal("mountain_longitude"));
				mtn.setMountainPic(rs.getBytes("mountain_pic"));
				mtn.setMountainInfo(rs.getString("mountain_info"));
				list.add(mtn);
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
	
	//for mtn from event
	public List<Event> eventByMtn(Integer mountain_id) {
		List<Event> list = new ArrayList<Event>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(eventByMtn);
			pstmt.setInt(1, mountain_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Event event = new Event();
				event.setMountainId(rs.getInt("mountain_id"));;
				event.setEventId(rs.getInt("event_id"));;
				event.setEventName(rs.getString("event_name"));
				list.add(event);
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
