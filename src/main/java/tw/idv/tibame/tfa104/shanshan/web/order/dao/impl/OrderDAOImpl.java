package tw.idv.tibame.tfa104.shanshan.web.order.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.JDBCutil.JDBCUtil;
import tw.idv.tibame.tfa104.shanshan.web.order.dao.OrderDAO;
import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;

@Repository
public class OrderDAOImpl implements OrderDAO{

//	新增 訂單 成功返回1，失敗返回0
	private static final String INSERT_STMT = "INSERT INTO `Order`( member_id, order_member_address, order_member_name, order_member_phone, order_status, point_used, order_sum_before, order_sum_after, payment_status ,company_id) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	刪除 訂單 成功返回1，失敗返回0
	private static final String DELETE_STMT = "DELETE FROM `Order` WHERE order_id = ?";
//	更新 訂單全部欄位 成功返回1，失敗返回0
	private static final String UPDATE_STMT = "UPDATE `Order` SET member_id = ?, order_created_date = ?, order_member_address = ?, order_member_name = ?, order_member_phone = ?, order_status = ?, point_used = ?, order_sum_before = ?, order_sum_after = ?, order_shipped_date = ?, ship_number = ?, payment_status = ? WHERE order_id = ?";
//  更新 特定訂單的貨運單號
    private static final String UPDATE_SHIP_NUM= "update `order` SET ship_number = ?, order_shipped_date = ? where order_id =?";
//	更新 特定訂單的撥款狀態
	private static final String UPDATE_PAY_STATS = "update `order` SET payment_status = ? where order_id=?";
//	更新 特定訂單的訂單狀態
	private static final String UPDATE_ORDER_STATS = "update `order` set order_status = ? where order_id = ?";
//	查詢  特定訂單  BY 訂單編號
	private static final String FIND_BY_PK = "SELECT * FROM `Order` WHERE order_id = ?";
//	查詢 全部訂單
	private static final String FIND_ALL = "SELECT * FROM `Order`";
//	查詢 特定店家的特定訂單狀態的訂單 按order id 倒序
	private static final String FIND_ALL_BY_COMID_ORDERSTATS = "select * from `order` where order_status=? and company_id =? order by order_id desc";
//  **查詢 特定店家 已出貨的訂單 按order id 倒序** Lulu update
	private static final String FIND_ALL_SHIPPED = "select * from `order` where order_status != 1 and order_status != 0 and order_status != 6 and company_id = ? order by order_id desc;";
//	查詢 特定會員的特定訂單狀態的訂單 按order id 倒序
	private static final String FIND_ALL_BY_MEMID_ORDERSTATS = "select * from `order` where order_status=? and member_id=? order by order_id desc";
//	查詢 最新的訂單 參數為多少筆 按order id 倒序
	private static final String FIND_BY_LAST = "select * from `order` order by order_id desc limit ?";
//	查詢 特定店家的訂單 按order id 倒序
	private static final String FIND_ALL_BY_COMID = "select * from `order` where company_id=? order by order_id desc";
//	查詢 特定會員的訂單 按order id 倒序
	private static final String FIND_ALL_BY_MEMID = "select * from `order` where member_id=? order by order_id desc";
//	查詢 特定會員 使用點數不為零 的訂單 按order id 倒序
	private static final String FIND_ALL_BY_MEMID_USEPOINT_NOTZERO = "select * from `order` where member_id=? and point_used not =0 order by order_id desc";
//	查詢 特定店家的訂單號碼 BY LIKE %?% 按order id 正序
	private static final String FIND_ALL_BY_COMID_LIKE_INT = "select * from `order` where company id=? and order_id='%?%' order by order_id asc";
//	查詢 特定日期範圍 特定店家的訂單 按order id 倒序
	private static final String FIND_ALL_BY_DATERANGE_COMID = "select * from `order` where company_id =? and (order_created_date between ? and ?) order by order_id desc";
//	查詢 所有訂單的撥款狀態  按order id 倒序
	private static final String FIND_ALL_BY_PAYSTATS = "select * from `order` where payment_status=? order by order_id desc";
//	查詢 特定日期範圍的所有訂單的撥款狀態  按order id 倒序
	private static final String FIND_ALL_BY_DATERANGE_PAYSTATS = "select * from `order` where (order_created_date between ? and ?) and payment_status=? order by order_id desc";
//	查詢 特定日期範圍的特定店家的訂單撥款狀態  按order id 倒序
	private static final String FIND_ALL_BY_DATERANGE_COMID_PAYSTATS = "select * from `order` where company_id=? and payment_status =? and (order_created_date between ? and ?) order by order_id desc";
//	查詢 特定會員的最新一張訂單(用來 顯示結帳結果)
	private static final String FIND_LATEST_BY_MEMID = "select * from `order` where member_id=? order by order_id desc limit 0, 1";
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
//	新增 訂單 成功返回1，失敗返回0
	@Override
	public int add(Order order) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();

			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, order.getMember_id());
			pstmt.setString(2, order.getOrder_member_address());
			pstmt.setString(3, order.getOrder_member_name());
			pstmt.setString(4, order.getOrder_member_phone());
			pstmt.setInt(5, order.getOrder_status());
			pstmt.setInt(6, order.getPoint_used());
			pstmt.setInt(7, order.getOrder_sum_before());
			pstmt.setInt(8, order.getOrder_sum_after());
			pstmt.setInt(9, order.getPayment_status());
			pstmt.setInt(10, order.getCompany_id());

			i = pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,con);
		}
		return i;
	}

//	刪除 訂單 成功返回1，失敗返回0
	@Override
	public int delete(Integer order_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, order_id);

			i = pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,con);
		}
		return i;
	}
 
//	更新 訂單全部欄位 成功返回1，失敗返回0
	@Override
	public int update(Order order) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, order.getMember_id());
			pstmt.setDate(2, order.getOrder_created_date());
			pstmt.setInt(3, order.getCompany_id());
			pstmt.setString(4, order.getOrder_member_address());
			pstmt.setString(5, order.getOrder_member_name());
			pstmt.setString(6, order.getOrder_member_phone());
			pstmt.setInt(7, order.getOrder_status());
			pstmt.setInt(8, order.getPoint_used());
			pstmt.setInt(9, order.getOrder_sum_before());
			pstmt.setInt(10, order.getOrder_sum_after());
			pstmt.setDate(11, order.getOrder_shipped_date());
			pstmt.setString(12, order.getShip_number());
			pstmt.setInt(13, order.getPayment_status());
			pstmt.setInt(14, order.getOrder_id());

			i = pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,con);
		}
		return i;
	}
	
//	更新 特定訂單的貨運單號 成功返回1，失敗返回0
	@Override
    public int updateShipNumDateByOrderId(String ship_number,Date order_shipped_date, Integer order_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;
		
		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(UPDATE_SHIP_NUM);

			pstmt.setString(1, ship_number);
            pstmt.setDate(2, order_shipped_date);
            pstmt.setInt(3, order_id);
			
			i = pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,con);
		}
		
		return i;
		
	}

//	更新 特定訂單的撥款狀態 成功返回1，失敗返回0
	@Override
	public int updatePayStatsByOrderId(Integer payment_status, Integer order_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;
		

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(UPDATE_PAY_STATS);

			pstmt.setInt(1, payment_status);
			pstmt.setInt(2, order_id);
			
			i = pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,con);
		}
		
		return i;
	}

//	更新 特定訂單的訂單狀態 成功返回1，失敗返回0
	@Override
	public int updateOrderStatsByOrderId(Integer order_status,Integer order_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;
		

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(UPDATE_ORDER_STATS);

			pstmt.setInt(1, order_status);
			pstmt.setInt(2, order_id);
			
			i = pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,con);
		}
		
		return i;
	}

//	查詢  特定訂單  BY 訂單編號
	@Override
	public Order findByOrderId(Integer order_id) {
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, order_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}

		return order;
	}

//	查詢 全部訂單
	@Override
	public List<Order> findAll() {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				orderList.add(order);
				

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return orderList;
	}
	
//	查詢 特定店家的特定訂單狀態的訂單
	@Override
	public List<Order> findAllByComIdOrderStatus(Integer order_status, Integer company_id) {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_ALL_BY_COMID_ORDERSTATS);
			pstmt.setInt(1, order_status);
			pstmt.setInt(2, company_id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				orderList.add(order);
				

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return orderList;
	}
	
//  **查詢 特定店家 已出貨的訂單 按order id 倒序** Lulu update
	@Override
	public List<Order> findAllShippedByComId(Integer company_id) {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement( FIND_ALL_SHIPPED);
			pstmt.setInt(1, company_id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				orderList.add(order);
				

			}
		}catch(SQLException se){
			se.printStackTrace();
		}finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return orderList;
	}
//	查詢 特定會員的特定訂單狀態的訂單
	@Override
	public List<Order> findAllByMemIdOrderStatus(Integer order_status, Integer member_id) {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_ALL_BY_MEMID_ORDERSTATS);
			pstmt.setInt(1, order_status);
			pstmt.setInt(2, member_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				orderList.add(order);
				

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return orderList;
	}

//	查詢 最新的訂單
	@Override
	public List<Order> findByLastest(Integer sequence) {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_BY_LAST);
			pstmt.setInt(1, sequence);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}

		return orderList;
	}
	
//	查詢 特定店家的訂單
	@Override
	public List<Order> findAllByComId(Integer company_id) {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_ALL_BY_COMID);
			pstmt.setInt(1, company_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				orderList.add(order);
				

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return orderList;
	}


//	查詢 特定會員的訂單
	@Override
	public List<Order> findAllByMemId(Integer member_id) {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_ALL_BY_MEMID);
			pstmt.setInt(1, member_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				orderList.add(order);
				

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return orderList;
	}


//	查詢 特定會員 使用點數不為零 的訂單
	@Override
	public List<Order> findAllByMemIdUsePointNotZero(Integer member_id) {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_ALL_BY_MEMID_USEPOINT_NOTZERO);
			pstmt.setInt(1, member_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				orderList.add(order);
				

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return orderList;
	}

//	查詢 特定店家的訂單號碼 BY LIKE %?%
	@Override
	public List<Order> findAllByComIdLikeInt(Integer company_id, String keyword) {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_ALL_BY_COMID_LIKE_INT);
			pstmt.setInt(1, company_id);
			pstmt.setString(2, keyword);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				orderList.add(order);
				

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return orderList;
	}


//	查詢 特定日期範圍 特定店家的訂單
	@Override
	public List<Order> findAllByDateRangeComId(Integer company_id, String from_date, String to_date) {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();

			pstmt = con.prepareStatement(FIND_ALL_BY_DATERANGE_COMID);
			pstmt.setInt(1, company_id);
			pstmt.setDate(2, java.sql.Date.valueOf(from_date));
			pstmt.setDate(3, java.sql.Date.valueOf(to_date));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				orderList.add(order);
				

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return orderList;
	}
	
//	查詢 所有訂單的撥款狀態
	@Override
	public List<Order> findAllByPayStatus(Integer payment_status) {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_ALL_BY_PAYSTATS);
			pstmt.setInt(1, payment_status);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				orderList.add(order);
				

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return orderList;
	}

//	查詢 特定日期範圍的所有訂單的撥款狀態
	@Override
	public List<Order> findAllByDateRangePayStatus(String from_date, String to_date,Integer payment_status) {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_ALL_BY_DATERANGE_PAYSTATS);
			pstmt.setDate(1, java.sql.Date.valueOf(from_date));
			pstmt.setDate(2, java.sql.Date.valueOf(to_date));
			pstmt.setInt(3, payment_status);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				orderList.add(order);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return orderList;
	}
	
//	查詢 特定日期範圍的特定店家的訂單撥款狀態
	@Override
	public List<Order> findAllByDateRangeComIdPayStatus(Integer company_id,Integer payment_status, String from_date, String to_date) {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();

			pstmt = con.prepareStatement(FIND_ALL_BY_DATERANGE_COMID_PAYSTATS);
			pstmt.setInt(1, company_id);
			pstmt.setInt(2, payment_status);
			pstmt.setDate(3, java.sql.Date.valueOf(from_date));
			pstmt.setDate(4, java.sql.Date.valueOf(to_date));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
				orderList.add(order);

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return orderList;
	}

	@Override
	public Order findLatestByMemId(Integer member_id) {
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			//		DataSource ds = new ComboPooledDataSource();

			con = ds.getConnection();

			pstmt = con.prepareStatement(FIND_LATEST_BY_MEMID);
			pstmt.setInt(1, member_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setMember_id(rs.getInt("Member_id"));
				order.setCompany_id(rs.getInt("company_id"));
				order.setOrder_created_date(rs.getDate("Order_created_date"));
				order.setOrder_member_address(rs.getString("Order_member_address"));
				order.setOrder_member_name(rs.getString("Order_member_name"));
				order.setOrder_member_phone(rs.getString("Order_member_phone"));
				order.setOrder_status(rs.getInt("Order_status"));
				order.setPoint_used(rs.getInt("Point_used"));
				order.setOrder_sum_before(rs.getInt("Order_sum_before"));
				order.setOrder_sum_after(rs.getInt("Order_sum_after"));
				order.setOrder_shipped_date(rs.getDate("Order_shipped_date"));
				order.setShip_number(rs.getString("Ship_number"));
				order.setPayment_status(rs.getInt("Payment_status"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return order;
	}

	

	
}
