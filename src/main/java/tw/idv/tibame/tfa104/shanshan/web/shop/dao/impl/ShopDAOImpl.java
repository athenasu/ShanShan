package tw.idv.tibame.tfa104.shanshan.web.shop.dao.impl;

import java.lang.reflect.Member;
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
import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.shop.dao.ShopDAO;

@Repository
public class ShopDAOImpl implements ShopDAO{
//		回傳10個 PopularProduct , 熱門商品 (10個)  按總銷售數 正序
	private static final String FIND_10POPULAR_PRODUCT = "SELECT pf.product_id, pf.product_name, pf.product_price, pf.company_name, pf.product_first_pic FROM (SELECT product_des_id, SUM(product_quantity) total_qty FROM order_description GROUP BY product_des_id ORDER BY total_qty DESC LIMIT 10) pop JOIN (SELECT b.product_id, a.product_des_id, b.product_name, a.product_price, c.company_name, img.product_first_pic FROM product_description a JOIN (select * from product WHERE `status` = 1) b USING (product_id) JOIN company c USING (company_id) JOIN (SELECT a.product_img_id, a.product_des_id, b.product_img product_first_pic FROM (SELECT MIN(product_img_id) product_img_id, product_des_id FROM product_img GROUP BY product_des_id) a JOIN product_img b USING (product_img_id)) img USING (product_des_id)) pf USING (product_des_id)";
////		山友搜尋商品名字功能 條件product_name like '%?%' ,20個 按product_id 正序 
//	private static final String FIND_PRODUCT_BY_PRO_NAME = "select * from product where product_name like '%?%' order by product_id";
////		山友搜尋店家名字功能 條件company_name like '%?%',20個  按company_id 正序 
//	private static final String FIND_COMPANY_BY_COM_NAME = "select * from product where company like '%?%' order by company_id";
////		更新 山山點數 欄位member_points_sum 條件member_id="?" 
//	private static final String UPDATE_MEM_POINTS_BY_MEMID = "UPDATE member SET member_points_sum = (-?) WHERE member_id = ?";
////		查詢點數 選擇member_points_sum 條件member_id = "?" 
//	private static final String FIND_MEM_POINTS_BY_MEMID = "select member_points_sum,member_id from member where member_id = ?";
//// 		顯示全部店家 按company_id 正序 
//	private static final String FIND_COMPANY_ID = "select company_name, company_id, company_banner,company_intro from company order by company_id asc";
////		顯示特定商品資訊 商品單頁
//	private static final String FIND_PORDUCT_BY_PRO_ID = "select * from product where product_id";
////		顯示特定商家商品10個+分頁功能 按照product_id 正序
//	private static final String FIND_PORDUCT_BY_COM_ID = "select * from product where company_id = ? order by product_id asc limit 10";
////		顯示指定商品類別的商品20個+分頁功能 按照product_id 正序
//	private static final String FIND_PRODUCT_BY_TYPE = "select * from product where product_type = ? order by product_id asc limit ?, 20 ";
////		顯示全部商品20個+分頁功能 按照product_id 正序
//	private static final String FIND_ALL_PRODUCT = "select * from product order by product_id asc limit ?, 20 ";
////		顯示特定店家的資訊
//	private static final String FIND_COMPANY_BY_COMID = "select company_id,company_name,company_intro,company_banner from company where company_id =1 and company_status = 0";

	
	private static DataSource ds = null;
	
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	//	回傳10個 ProductBO , 熱門商品 (10個)  按總銷售數 正序
	@Override
	public List<ProductBO> findpopular10() {

		List<ProductBO> popular10 = new ArrayList<>();
		ProductBO popular = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_10POPULAR_PRODUCT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				popular = new ProductBO();
				popular.setProductId(rs.getInt("product_id"));
				popular.setProductName(rs.getString("product_name"));
				popular.setProductPrice(rs.getInt("product_price"));
				popular.setCompanyName(rs.getString("company_name"));
				popular.setProductImg(rs.getBytes("product_first_pic"));
				popular10.add(popular);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		
		return popular10;
	}

//  山友搜尋商品名字功能 條件product_name like '%?%' ,20個 按product_id 正序 
//	@Override
//	public List<ProductBO> findProductByProName() {
//		return null;
//	}
//
////	山友搜尋店家名字功能 條件company_name like '%?%',20個  按company_id 正序 
//	@Override
//	public List<ProductBO> findCompanyByComName() {
//		return null;
//	}
//
////	更新 山山點數 欄位member_points_sum 條件member_id="?" 
//	@Override
//	public void UpdateMembPointsByMemId(Integer member_id) {
//		
//	}
//
////	查詢點數 選擇member_points_sum 條件member_id = "?" 
//	@Override
//	public Member findMembPointsByMemId(Integer member_id) {
//		return null;
//	}
//
//// 	顯示全部店家 按company_id 正序 
//	@Override
//	public List<CompanyVO> findAllCompany() {
//		return null;
//	}
//
////	顯示特定商品資訊 商品單頁
//	@Override
//	public List<ProductBO> findProductByProId() {
//		return null;
//	}
//
////	顯示特定商家商品10個+分頁功能 按照product_id 正序
//	@Override
//	public List<ProductBO> findProductByComId() {
//		return null;
//	}
//	
////	顯示指定商品類別的商品20個+分頁功能 按照product_id 正序
//	@Override
//	public List<ProductBO> findProductByType() {
//		return null;
//	}
//
////	顯示全部商品20個+分頁功能 按照product_id 正序
//	@Override
//	public List<ProductBO> findAllProduct() {
//		return null;
//	}
////	顯示特定店家的資訊
//	@Override
//	public List<CompanyVO> findCompanyByComId() {
//		return null;
//	}

	

	
	
	
	
}
