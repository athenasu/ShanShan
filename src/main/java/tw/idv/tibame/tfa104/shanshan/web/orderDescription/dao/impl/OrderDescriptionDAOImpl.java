package tw.idv.tibame.tfa104.shanshan.web.orderDescription.dao.impl;

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

import tw.idv.tibame.tfa104.shanshan.web.JDBCutil.JDBCUtil;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.dao.OrderDescriptionDAO;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescription;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;

@Repository
public class OrderDescriptionDAOImpl implements OrderDescriptionDAO{
//	新增 訂單明細 成功返回1，失敗返回0
	private static final String INSERT_STMT = "INSERT INTO Order_description(product_des_id, order_id, product_quantity, product_price) VALUES (?, ?, ?, ?) ";
//	更新 訂單明細 成功返回1，失敗返回0
	private static final String UPDATE_STMT = "UPDATE Order_description SET product_des_id = ?, order_id = ?, product_quantity = ?, product_price = ? WHERE order_des_id = ?";
//	刪除 訂單明細 成功返回1，失敗返回0
	private static final String DELETE_STMT = "DELETE FROM Order_description WHERE order_des_id = ?";
//	查詢 訂單明細 BY PK
	private static final String FIND_BY_PK = "SELECT * FROM Order_description WHERE order_des_id = ?";
//	查詢 全部訂單 按order_des_id倒序
	private static final String FIND_ALL = "SELECT * FROM Order_description Order by order_des_id desc";
//	查詢 特定訂單的訂單明細 按訂單明細編號 正序
	private static final String FIND_BY_ORDERID = "SELECT * FROM Order_description WHERE order_id = ? by order_des_id asc";
//	查詢 特定訂單的訂單明細BO 按訂單明細編號 正序
	private static final String BO_FIND_BY_ORDERID = "SELECT b.order_id, b.member_id, b.order_created_date, b.order_member_address, b.order_member_name, b.order_member_phone, b.order_status, a.product_quantity, a.product_price, b.order_sum_after, b.order_shipped_date, b.ship_number, b.payment_status, d.product_name, c.product_id, c.product_des_id, c.product_size, c.product_color, d.company_id, e.company_name, h.product_des_img FROM order_description a JOIN `order` b USING (order_id) JOIN product_description c USING (product_des_id) JOIN product d USING (product_id) JOIN company e USING (company_id) JOIN (select f.product_img_id, f.product_des_id, g.product_img product_des_img from ( select min(product_img_id) product_img_id , product_des_id from product_img group by product_des_id ) f join product_img g using (product_img_id)) h USING (product_des_id) WHERE order_id = ?";
//	查詢 特定訂單的訂單明細BO 按訂單明細編號 正序 (沒有圖片)
	private static final String BO_FIND_BY_ORDERID_NO_PIC = "SELECT b.order_id, b.member_id, b.order_created_date, b.order_member_address, b.order_member_name, b.order_member_phone, b.order_status, a.product_quantity, a.product_price, b.order_sum_after, b.order_shipped_date, b.ship_number, b.payment_status, d.product_name, c.product_id, c.product_des_id, c.product_size, c.product_color, d.company_id, e.company_name FROM order_description a JOIN `order` b USING (order_id) JOIN product_description c USING (product_des_id) JOIN product d USING (product_id) JOIN company e USING (company_id) WHERE order_id = ?";
//	查詢 特定訂單的訂單明細BO 按訂單明細編號 正序 (沒圖片，拿掉一些店家後台用的資料)
	private static final String BO_FIND_BY_ORDERID_NO_PIC_FOR_MEMBER_CENTER ="SELECT b.order_id, b.order_created_date, b.order_status, a.product_quantity, a.product_price, b.order_sum_after, b.order_shipped_date, b.ship_number, b.payment_status, d.product_name, c.product_id, c.product_des_id, c.product_size, c.product_color, e.company_name FROM order_description a JOIN `order` b USING (order_id) JOIN product_description c USING (product_des_id) JOIN product d USING (product_id) JOIN company e USING (company_id) WHERE order_id = ?";
//	查詢 特定會員的訂單+訂單明細BO 按訂單明細編號 正序
	private static final String BO_FIND_BY_MEMID_FOR_MEMBER_CENTER ="SELECT b.order_id, b.member_id, b.order_created_date, b.order_member_address, b.order_member_name, b.order_member_phone, b.order_status, a.product_quantity, a.product_price, a.subtotal_price, b.order_sum_after, b.order_shipped_date, b.ship_number, b.payment_status, d.product_name, c.product_id, c.product_des_id, c.product_size, c.product_color, d.company_id, e.company_name, f.product_img FROM order_description a JOIN `order` b USING (order_id) JOIN company e USING (company_id) JOIN product_description c USING (product_des_id) JOIN product d USING (product_id) JOIN (SELECT g.product_img_id,g.product_des_id, h.product_img FROM (SELECT min(product_img_id) product_img_id,product_des_id FROM product_img GROUP BY product_des_id) g JOIN product_img h USING (product_img_id)) f USING (product_des_id) WHERE member_id = ? AND order_id = ?";

	private static DataSource ds = null;
	
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

//	新增 訂單明細 成功返回1，失敗返回0
	@Override
	public int add(OrderDescription order_description) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, order_description.getProduct_des_id());
			pstmt.setInt(2, order_description.getOrder_id());
			pstmt.setInt(3, order_description.getProduct_quantity());
			pstmt.setInt(4, order_description.getProduct_price());
			pstmt.executeUpdate();
			

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,con);
		}
		return i;
	}

//	更新 訂單明細 成功返回1，失敗返回0
	@Override
	public int update(OrderDescription order_description) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {

//			DataSource ds = new ComboPooledDataSource();
		
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, order_description.getProduct_des_id());
			pstmt.setInt(2, order_description.getOrder_id());
			pstmt.setInt(3, order_description.getProduct_quantity());
			pstmt.setInt(4, order_description.getProduct_price());
			pstmt.setInt(5, order_description.getOrder_des_id());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,con);
		}
		return i;
	}

//	刪除 訂單明細 成功返回1，失敗返回0
	@Override
	public int delete(Integer order_des_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(DELETE_STMT);


			pstmt.setInt(1, order_des_id);
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,con);
		}
		return i;
	}

//	查詢 訂單明細 BY PK
	@Override
	public OrderDescription findByOrderDesId(Integer order_des_id) {
		OrderDescription order_description = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, order_des_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order_description = new OrderDescription();
				order_description.setOrder_des_id(rs.getInt("Order_des_id"));
				order_description.setProduct_des_id(rs.getInt("Product_des_id"));
				order_description.setOrder_id(rs.getInt("Order_id"));
				order_description.setProduct_quantity(rs.getInt("Product_quantity"));
				order_description.setProduct_price(rs.getInt("Product_price"));
			}

			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}

		return order_description;
	}

//	查詢 全部訂單 按order_des_id倒序
	@Override
	public List<OrderDescription> findAll() {
		List<OrderDescription> order_descriptionList = new ArrayList<>();
		OrderDescription order_description = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order_description = new OrderDescription();
				order_description.setOrder_des_id(rs.getInt("Order_des_id"));
				order_description.setProduct_des_id(rs.getInt("Product_des_id"));
				order_description.setOrder_id(rs.getInt("Order_id"));
				order_description.setProduct_quantity(rs.getInt("Product_quantity"));
				order_description.setProduct_price(rs.getInt("Product_price"));
				order_descriptionList.add(order_description);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return order_descriptionList;
	}

//	查詢 特定訂單的訂單明細 按訂單明細編號 正序
	@Override
	public OrderDescription findByOrderId(Integer order_id) {
		OrderDescription order_description = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_BY_ORDERID);
			pstmt.setInt(1, order_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				order_description = new OrderDescription();
				order_description.setOrder_des_id(rs.getInt("Order_des_id"));
				order_description.setProduct_des_id(rs.getInt("Product_des_id"));
				order_description.setOrder_id(rs.getInt("Order_id"));
				order_description.setProduct_quantity(rs.getInt("Product_quantity"));
				order_description.setProduct_price(rs.getInt("Product_price"));
			}

			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}

		return order_description;
	}

//	查詢 特定訂單的訂單明細BO 按訂單明細編號 正序 (圖片是pro_des第一張圖)
	@Override
	public List<OrderDescriptionBO> BOfindByOrderId(Integer order_id) {

		List<OrderDescriptionBO> listOrderDesBO = new ArrayList<>();
		OrderDescriptionBO orderDesBO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(BO_FIND_BY_ORDERID);
			pstmt.setInt(1, order_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderDesBO = new OrderDescriptionBO();
				orderDesBO.setOrder_id(rs.getInt("order_id"));
				orderDesBO.setMember_id(rs.getInt("member_id"));
				orderDesBO.setOrder_created_date(rs.getDate("order_created_date"));
				orderDesBO.setOrder_member_address(rs.getString("order_member_address"));
				orderDesBO.setOrder_member_name(rs.getString("order_member_name"));
				orderDesBO.setOrder_member_phone(rs.getInt("order_member_phone"));
				orderDesBO.setOrder_status(rs.getInt("order_status"));
				orderDesBO.setOrder_sum_after(rs.getInt("order_sum_after"));
				orderDesBO.setOrder_shipped_date(rs.getDate("order_shipped_date"));
				orderDesBO.setShip_number(rs.getInt("ship_number"));
				orderDesBO.setPayment_status(rs.getInt("payment_status"));
				orderDesBO.setProduct_id(rs.getInt("product_id"));
				orderDesBO.setProdes_id(rs.getInt("product_des_id"));
				orderDesBO.setCompany_id(rs.getInt("company_id"));
				orderDesBO.setCompany_name(rs.getString("company_name"));
				orderDesBO.setProduct_name(rs.getString("product_name"));
				orderDesBO.setProduct_size(rs.getInt("product_size"));
				orderDesBO.setProduct_color(rs.getString("product_color"));
				orderDesBO.setOrder_description_price(rs.getInt("product_price"));
				orderDesBO.setProduct_first_pic(rs.getBytes("product_des_img"));
				orderDesBO.setProduct_quantity(rs.getInt("product_quantity"));

				listOrderDesBO.add(orderDesBO);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return listOrderDesBO;
	}

	
//	查詢 特定訂單的訂單明細BO 按訂單明細編號 正序 (沒有圖片)
	@Override
	public List<OrderDescriptionBO> BOfindByOrderIdNopic(Integer order_id) {

		List<OrderDescriptionBO> listOrderDesBO2 = new ArrayList<>();
		OrderDescriptionBO orderDesBO2 = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(BO_FIND_BY_ORDERID_NO_PIC_FOR_MEMBER_CENTER);
			pstmt.setInt(1, order_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderDesBO2 = new OrderDescriptionBO();
				orderDesBO2.setOrder_id(rs.getInt("order_id"));
				orderDesBO2.setMember_id(rs.getInt("member_id"));
				orderDesBO2.setOrder_created_date(rs.getDate("order_created_date"));
				orderDesBO2.setOrder_member_address(rs.getString("order_member_address"));
				orderDesBO2.setOrder_member_name(rs.getString("order_member_name"));
				orderDesBO2.setOrder_member_phone(rs.getInt("order_member_phone"));
				orderDesBO2.setOrder_status(rs.getInt("order_status"));
				orderDesBO2.setOrder_sum_after(rs.getInt("order_sum_after"));
				orderDesBO2.setOrder_shipped_date(rs.getDate("order_shipped_date"));
				orderDesBO2.setShip_number(rs.getInt("ship_number"));
				orderDesBO2.setPayment_status(rs.getInt("payment_status"));
				orderDesBO2.setProduct_id(rs.getInt("product_id"));
				orderDesBO2.setProdes_id(rs.getInt("product_des_id"));
				orderDesBO2.setCompany_id(rs.getInt("company_id"));
				orderDesBO2.setCompany_name(rs.getString("company_name"));
				orderDesBO2.setProduct_name(rs.getString("product_name"));
				orderDesBO2.setProduct_size(rs.getInt("product_size"));
				orderDesBO2.setProduct_color(rs.getString("product_color"));
				orderDesBO2.setOrder_description_price(rs.getInt("product_price"));
				orderDesBO2.setProduct_quantity(rs.getInt("product_quantity"));


				listOrderDesBO2.add(orderDesBO2);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return listOrderDesBO2;
	}

	
//	查詢 特定訂單的訂單明細BO 按訂單明細編號 正序 (沒有圖片)
	@Override
	public List<OrderDescriptionBO> BOfindByOrderIdForMemCentr(Integer order_id) {

		List<OrderDescriptionBO> listOrderDesBO3 = new ArrayList<>();
		OrderDescriptionBO orderDesBO3 = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(BO_FIND_BY_ORDERID_NO_PIC);
			pstmt.setInt(1, order_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderDesBO3 = new OrderDescriptionBO();
				orderDesBO3.setOrder_id(rs.getInt("order_id"));
//				orderDesBO3.setMember_id(rs.getInt("member_id"));
				orderDesBO3.setOrder_created_date(rs.getDate("order_created_date"));
//				orderDesBO3.setOrder_member_address(rs.getString("order_member_address"));
//				orderDesBO3.setOrder_member_name(rs.getString("order_member_name"));
//				orderDesBO3.setOrder_member_phone(rs.getInt("order_member_phone"));
				orderDesBO3.setOrder_status(rs.getInt("order_status"));
				orderDesBO3.setOrder_sum_after(rs.getInt("order_sum_after"));
				orderDesBO3.setOrder_shipped_date(rs.getDate("order_shipped_date"));
				orderDesBO3.setShip_number(rs.getInt("ship_number"));
				orderDesBO3.setPayment_status(rs.getInt("payment_status"));
				orderDesBO3.setProduct_id(rs.getInt("product_id"));
				orderDesBO3.setProdes_id(rs.getInt("product_des_id"));
//				orderDesBO3.setCompany_id(rs.getInt("company_id"));
				orderDesBO3.setCompany_name(rs.getString("company_name"));
				orderDesBO3.setProduct_name(rs.getString("product_name"));
				orderDesBO3.setProduct_size(rs.getInt("product_size"));
				orderDesBO3.setProduct_color(rs.getString("product_color"));
				orderDesBO3.setOrder_description_price(rs.getInt("product_price"));
				orderDesBO3.setProduct_quantity(rs.getInt("product_quantity"));


				listOrderDesBO3.add(orderDesBO3);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return listOrderDesBO3;
	}

//	查詢 特定會員的訂單+訂單明細BO 按訂單明細編號 正序 
	@Override
	public List<OrderDescriptionBO> BOfindByMemIdForMembCentr(Integer member_id, Integer order_id) {

		List<OrderDescriptionBO> listOrderDesBO3 = new ArrayList<>();
		OrderDescriptionBO orderDesBO3 = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try {

			//		DataSource ds = new ComboPooledDataSource();

			con = ds.getConnection();

			pstmt = con.prepareStatement(BO_FIND_BY_MEMID_FOR_MEMBER_CENTER);
			pstmt.setInt(1, member_id);
			pstmt.setInt(2, order_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderDesBO3 = new OrderDescriptionBO();
				orderDesBO3.setOrder_id(rs.getInt("order_id"));
				orderDesBO3.setMember_id(rs.getInt("member_id"));
				orderDesBO3.setOrder_created_date(rs.getDate("order_created_date"));
				orderDesBO3.setOrder_member_address(rs.getString("order_member_address"));
				orderDesBO3.setOrder_member_name(rs.getString("order_member_name"));
				orderDesBO3.setOrder_member_phone(rs.getInt("order_member_phone"));
				orderDesBO3.setOrder_status(rs.getInt("order_status"));
				orderDesBO3.setOrder_sum_after(rs.getInt("order_sum_after"));
				orderDesBO3.setOrder_shipped_date(rs.getDate("order_shipped_date"));
				orderDesBO3.setShip_number(rs.getInt("ship_number"));
				orderDesBO3.setPayment_status(rs.getInt("payment_status"));
				orderDesBO3.setProduct_id(rs.getInt("product_id"));
				orderDesBO3.setProdes_id(rs.getInt("product_des_id"));
				orderDesBO3.setCompany_id(rs.getInt("company_id"));
				orderDesBO3.setCompany_name(rs.getString("company_name"));
				orderDesBO3.setProduct_name(rs.getString("product_name"));
				orderDesBO3.setProduct_size(rs.getInt("product_size"));
				orderDesBO3.setProduct_color(rs.getString("product_color"));
				orderDesBO3.setOrder_description_price(rs.getInt("product_price"));
				orderDesBO3.setProduct_quantity(rs.getInt("product_quantity"));
				orderDesBO3.setSubtotal_price(rs.getInt("subtotal_price"));
				orderDesBO3.setProduct_first_pic(rs.getBytes("product_img"));

				listOrderDesBO3.add(orderDesBO3);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return listOrderDesBO3;
	}

	
	
}
