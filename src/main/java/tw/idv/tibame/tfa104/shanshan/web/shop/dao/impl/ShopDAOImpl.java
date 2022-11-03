package tw.idv.tibame.tfa104.shanshan.web.shop.dao.impl;

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
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.Page;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.ProductImgBO;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProduct;

@Repository
public class ShopDAOImpl implements ShopDAO{
//		回傳10個 PopularProduct , 熱門商品 (?個)  按總銷售數 正序
//	private static final String FIND_10POPULAR_PRODUCT = "SELECT pf.product_id, pf.product_name, pf.product_price, pf.company_name, pf.product_first_pic FROM (SELECT product_des_id, SUM(product_quantity) total_qty FROM order_description GROUP BY product_des_id ORDER BY total_qty DESC LIMIT ?) pop JOIN (SELECT b.product_id, a.product_des_id, b.product_name, a.product_price, c.company_name, img.product_first_pic FROM product_description a JOIN (SELECT * FROM product WHERE `status` = 1) b USING (product_id) JOIN company c USING (company_id) JOIN (SELECT a.product_img_id, a.product_des_id, b.product_img product_first_pic FROM (SELECT MIN(product_img_id) product_img_id, product_des_id FROM product_img GROUP BY product_des_id) a JOIN product_img b USING (product_img_id)) img USING (product_des_id)) pf USING (product_des_id)";
	private static final String FIND_10POPULAR_PRODUCT = "SELECT * FROM (SELECT product_id, SUM(product_quantity) total_qty FROM order_description JOIN product_description USING (product_des_id) WHERE `status` = 1 GROUP BY product_id ORDER BY total_qty DESC LIMIT ?) e JOIN (SELECT a.product_name, a.product_id, a.product_price, company_id, company_name FROM product a JOIN product_description b USING (product_id) JOIN company c USING (company_id)) d USING (product_id) GROUP BY product_id";
//		山友搜尋商品名字功能 條件product_name like '%?%'  按product_id 正序 
	private static final String FIND_PRODUCT_BY_PRO_NAME = "SELECT product_id, company_name, product_price, product_name FROM product JOIN company USING (company_id) WHERE product_name LIKE '%?%' AND `status` = 1 ORDER BY product_id";
//		山友搜尋店家名字功能 條件company_name like '%?%'  按company_id 正序 
	private static final String FIND_COMPANY_BY_COM_NAME = "SELECT product_id, company_name, product_price, product_name FROM product JOIN company USING (company_id) WHERE company_name LIKE '%?%' AND `status` = 1 ORDER BY product_id";
// 		顯示全部店家 按company_id 正序 
	private static final String FIND_ALL_COMPANY = "select company_name, company_id, company_banner,company_intro from company WHERE company_status = 1 order by company_id asc";
//		顯示特定商品資訊 商品單頁
	private static final String FIND_PORDUCT_BY_PRO_ID = "SELECT pd.product_id, pd.product_des_id, pd.product_size, pd.product_color, c.company_id, c.company_name, p.product_name, p.product_type, pd.product_price, p.product_intro FROM product_description pd JOIN product p USING (product_id) JOIN company c USING (company_id) WHERE pd.product_id = ? AND pd.status = 1";
//		顯示特定商品明細資訊 購物車
	private static final String FIND_PORDUCT_BY_PRO_DES_ID = "SELECT pd.product_id, pd.product_des_id, pd.product_size, pd.product_color, c.company_id, c.company_name, p.product_name, pd.product_price FROM product_description pd JOIN product p USING (product_id) JOIN company c USING (company_id) WHERE pd.product_des_id = ? AND pd.status = 1";
//		顯示特定商家商品?個+分頁功能 按照product_id 正序
	private static final String FIND_PORDUCT_BY_COM_ID = "SELECT product_id, company_name, product_name, product_price FROM product JOIN company USING (company_id) where company_id = ?  and `status` = 1 ORDER BY product_id ASC LIMIT ? , ?";
//		顯示指定商品類別的商品?個+分頁功能 按照product_id 正序
	private static final String FIND_PRODUCT_BY_TYPE = "SELECT product_id, company_name, product_name, product_price,product_type FROM product JOIN company USING (company_id) where product_type = ?  and `status` = 1 ORDER BY product_id ASC LIMIT ? , ?";
//		顯示全部商品?個+分頁功能 按照product_id 正序
	private static final String FIND_ALL_PRODUCT = "SELECT product_id, company_name, product_name, product_price FROM product JOIN company USING (company_id) WHERE `status`=1 ORDER BY product_id ASC LIMIT ? , ? ";
//		顯示特定店家的資訊
	private static final String FIND_COMPANY_BY_COMID = "select company_id,company_name,company_intro,company_banner from company where company_id =? and company_status = 1";

//	取得總商品資料條數
	private static final String FIND_TOTAL_PRODUCT_RECORD = "SELECT count(*) as totalRecord FROM product;";
//	取得商品類別 總商品資料條數
	private static final String FIND_TOTAL_PRODUCT_RECORD_BY_TYPE = "SELECT count(*) as totalRecord FROM product where product_type = ?;";

//	查詢特定商品編號的第?張圖片 變數為product_des_id = ? / limit = ? ,1 (?是第1張圖片)
	private static final String GET_PIC = "SELECT product_id, product_des_id, product_img_id, product_img FROM product_img JOIN product_description USING (product_des_id) WHERE product_id = ? ORDER BY product_img_id ASC LIMIT ? , 1";
//	查詢特定商品編號的第一個商品明細編號的第一張圖片
	private static final String GET_PRODUCT_FIRST_PIC = "select pro.product_id, img.product_des_id, img.product_img_id, img.product_first_pic from (select a.product_des_id, a.product_id from ( select min(product_des_id) product_des_id , product_id from product_description group by product_id ) a join product_description b using (product_des_id)) pro join( select c.product_img_id, c.product_des_id, d.product_img product_first_pic from ( select min(product_img_id) product_img_id , product_des_id from product_img group by product_des_id ) c join product_img d using (product_img_id))img using (product_des_id) where product_id = ?";
//	查詢特定商品明細編號的全部圖片 按product_img_id 正序
//	private static final String GET_PRODUCT_DES_ALL_PIC = "SELECT * FROM product_img WHERE product_des_id = ? ORDER BY product_img_id";
//	查詢特定商品編號的全部圖片 按product_img_id 正序
	private static final String GET_PRODUCT_ALL_PIC = "SELECT product_id, product_des_id, product_img_id, product_img FROM product_img JOIN product_description USING (product_des_id) WHERE product_id = ? ORDER BY product_img_id";
//  查詢特定會員的WishlistProduct list
	private static final String GET_ALL_WISH_PRODUCT_BY_MEMID ="SELECT * FROM wishlist_product WHERE member_id = ?";
	
	
	
//	更新 山山點數 欄位member_points_sum 條件member_id="?" 
//private static final String UPDATE_MEM_POINTS_BY_MEMID = "UPDATE member SET member_points_sum = (-?) WHERE member_id = ?";
//	查詢點數 選擇member_points_sum 條件member_id = "?" 
//private static final String FIND_MEM_POINTS_BY_MEMID = "select member_points_sum,member_id from member where member_id = ?";
	
	private static DataSource ds = null;
	
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	//	回傳10個 ProductBO , 熱門商品 (?個)  按總銷售數 正序
	@Override
	public List<ProductBO> findpopular10(Integer showNum) {

		List<ProductBO> popular10 = new ArrayList<>();
		ProductBO popular = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_10POPULAR_PRODUCT);
			pstmt.setInt(1, showNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				popular = new ProductBO();
				popular.setProductId(rs.getInt("product_id"));
				popular.setProductName(rs.getString("product_name"));
				popular.setProductPrice(rs.getInt("product_price"));
				popular.setCompanyName(rs.getString("company_name"));
//				popular.setProductImg(rs.getBytes("product_first_pic"));
				popular10.add(popular);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		
		return popular10;
	}

//  山友搜尋商品名字功能 條件product_name like '%?%'  按product_id 正序 
	@Override
	public List<ProductBO> findProductByProName(String search_str) {
		List<ProductBO> listproductBO = new ArrayList<>();
		ProductBO productBO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_PRODUCT_BY_PRO_NAME);
			pstmt.setString(1, search_str);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productBO = new ProductBO();
				productBO.setProductId(rs.getInt("product_id"));
				productBO.setProductName(rs.getString("product_name"));
				productBO.setProductPrice(rs.getInt("product_price"));
				productBO.setCompanyName(rs.getString("company_name"));
//				productBO.setProductImg(rs.getBytes("product_first_pic"));
				listproductBO.add(productBO);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return listproductBO;
	}

//	山友搜尋店家名字功能 條件company_name like '%?%'  按company_id 正序 
	@Override
	public List<ProductBO> findCompanyByComName(String search_str) {
		List<ProductBO> listproductBO = new ArrayList<>();
		ProductBO productBO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_COMPANY_BY_COM_NAME);
			pstmt.setString(1, search_str);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productBO = new ProductBO();
				productBO.setProductId(rs.getInt("product_id"));
				productBO.setProductName(rs.getString("product_name"));
				productBO.setProductPrice(rs.getInt("product_price"));
				productBO.setCompanyName(rs.getString("company_name"));
//				productBO.setProductImg(rs.getBytes("product_first_pic"));
				listproductBO.add(productBO);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return listproductBO;
	}


// 	顯示全部店家 按company_id 正序 
	@Override
	public List<CompanyVO> findAllCompany() {
		List<CompanyVO> listcompanyVO = new ArrayList<>();
		CompanyVO companyVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_ALL_COMPANY);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				companyVO = new CompanyVO();
				companyVO.setCompanyId(rs.getInt("company_id"));
				companyVO.setCompanyName(rs.getString("company_name"));
				companyVO.setCompanyIntro(rs.getString("company_intro"));
				companyVO.setCompanyBanner(rs.getBytes("company_banner"));
				listcompanyVO.add(companyVO);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		
		return listcompanyVO;
	}

//	顯示特定商品資訊 商品單頁
	@Override
	public List<ProductBO> findProductByProId(Integer product_id) {
		List<ProductBO> listproductBO = new ArrayList<>();
		ProductBO productBO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_PORDUCT_BY_PRO_ID);
			pstmt.setInt(1, product_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productBO = new ProductBO();
				productBO.setProductId(rs.getInt("product_id"));
				productBO.setProductName(rs.getString("product_name"));
				productBO.setProductPrice(rs.getInt("product_price"));
				productBO.setCompanyName(rs.getString("company_name"));
				productBO.setProductType(rs.getInt("product_type"));
				productBO.setProductIntro(rs.getString("product_intro"));
//				productBO.setProductImg(rs.getBytes("product_first_pic"));
				productBO.setProdesId(rs.getInt("product_des_id"));
				productBO.setCompanyId(rs.getInt("company_id"));
				productBO.setProductSize(rs.getInt("product_size"));
				productBO.setProductColor(rs.getString("product_color"));
				listproductBO.add(productBO);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return listproductBO;
	}

//	顯示特定商品明細資訊 購物車
	
	@Override
	public ProductBO findProductByProDesId(Integer product_des_id) {
		ProductBO productBO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_PORDUCT_BY_PRO_DES_ID);
			pstmt.setInt(1, product_des_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productBO = new ProductBO();
				productBO.setProductId(rs.getInt("product_id"));
				productBO.setProductName(rs.getString("product_name"));
				productBO.setProductPrice(rs.getInt("product_price"));
				productBO.setCompanyName(rs.getString("company_name"));
				productBO.setProdesId(rs.getInt("product_des_id"));
				productBO.setCompanyId(rs.getInt("company_id"));
				productBO.setProductSize(rs.getInt("product_size"));
				productBO.setProductColor(rs.getString("product_color"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return productBO;
	}

//	顯示特定商家商品?個+分頁功能 按照product_id 正序
	@Override
	public List<ProductBO> findProductByComId(Integer company_id, Integer ingoreNum, Integer showNum ) {
		List<ProductBO> listproductBO = new ArrayList<>();
		ProductBO productBO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_PORDUCT_BY_COM_ID);
			pstmt.setInt(1, company_id);
			pstmt.setInt(2, ingoreNum);
			pstmt.setInt(3, showNum);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productBO = new ProductBO();
				productBO.setProductId(rs.getInt("product_id"));
				productBO.setProductName(rs.getString("product_name"));
				productBO.setProductPrice(rs.getInt("product_price"));
				productBO.setCompanyName(rs.getString("company_name"));
//				productBO.setProductImg(rs.getBytes("product_first_pic"));
				listproductBO.add(productBO);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return listproductBO;
	}
	

	//	顯示指定商品類別的商品?個+分頁功能 按照product_id 正序
	@Override
	public List<ProductBO> findProductByType(Integer product_type, Integer ingoreNum,Integer showNum) {
		List<ProductBO> listproductBO = new ArrayList<>();
		ProductBO productBO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_PRODUCT_BY_TYPE);
			pstmt.setInt(1, product_type);
			pstmt.setInt(2, ingoreNum);
			pstmt.setInt(3, showNum);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productBO = new ProductBO();
				productBO.setProductId(rs.getInt("product_id"));
				productBO.setProductName(rs.getString("product_name"));
				productBO.setProductPrice(rs.getInt("product_price"));
				productBO.setCompanyName(rs.getString("company_name"));
				productBO.setProductType(rs.getInt("product_type"));
//				productBO.setProductImg(rs.getBytes("product_first_pic"));
				listproductBO.add(productBO);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return listproductBO;
	}

//	顯示全部商品20個+分頁功能 按照product_id 正序
	@Override
	public List<ProductBO> findAllProduct(Integer ingoreNum, Integer showNum) {
		List<ProductBO> listproductBO = new ArrayList<>();
		ProductBO productBO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_ALL_PRODUCT);
			pstmt.setInt(1, ingoreNum);
			pstmt.setInt(2, showNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productBO = new ProductBO();
				productBO.setProductId(rs.getInt("product_id"));
				productBO.setProductName(rs.getString("product_name"));
				productBO.setProductPrice(rs.getInt("product_price"));
				productBO.setCompanyName(rs.getString("company_name"));
//				productBO.setProductImg(rs.getBytes("product_first_pic"));
				listproductBO.add(productBO);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}

		return listproductBO;
	}
//	顯示特定店家的資訊
	@Override
	public CompanyVO findCompanyByComId(Integer company_id) {
		CompanyVO companyVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			

//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_COMPANY_BY_COMID);
			pstmt.setInt(1, company_id);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				companyVO = new CompanyVO();
				companyVO.setCompanyId(rs.getInt("company_id"));
				companyVO.setCompanyName(rs.getString("company_name"));
				companyVO.setCompanyIntro(rs.getString("company_intro"));
				companyVO.setCompanyBanner(rs.getBytes("company_banner"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		
		return companyVO;
	}
	
//	取得總商品資料條數
	@Override
	public int getTotalProRecord() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalRecord = 0;
		try {
			
//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_TOTAL_PRODUCT_RECORD);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Page page= new Page();
				page.setTotalRecord(rs.getInt("totalRecord"));
				totalRecord = page.getTotalRecord();
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		
		return totalRecord;
	}

//	取得商品類別 總商品資料條數
	@Override
	public int getTotalProRecordByType(Integer product_type) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalRecord = 0;
		try {
			
//			DataSource ds = new ComboPooledDataSource();
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(FIND_TOTAL_PRODUCT_RECORD_BY_TYPE);
			pstmt.setInt(1, product_type);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Page page= new Page();
				page.setTotalRecord(rs.getInt("totalRecord"));
				totalRecord = page.getTotalRecord();
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		
		return totalRecord;
	}


//	查詢特定商品編號的第?張圖片 變數為product_des_i = ? / limit = ? ,1 (?是第1張圖片)
	@Override
	public ProductImgBO getPic(Integer product_id ,Integer num_pic) {
		ProductImgBO productImgBO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_PIC);
			pstmt.setInt(1, product_id);
			pstmt.setInt(2, num_pic-1); // 第1張圖忽略圖片為0, 所以要-1
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productImgBO = new ProductImgBO();
				productImgBO.setProduct_img_id(rs.getInt("product_img_id"));
				productImgBO.setProduct_des_id(rs.getInt("product_des_id"));
				productImgBO.setProduct_the_pic(rs.getBytes("product_img"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,con);
		}
		return productImgBO;
	}

//	查詢特定商品編號的第一個商品明細編號的第一張圖片
	@Override
	public ProductImgBO getProDesFirstPic(Integer product_id) {
		ProductImgBO productImgBO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_PRODUCT_FIRST_PIC);
			pstmt.setInt(1, product_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productImgBO = new ProductImgBO();
				productImgBO.setProduct_img_id(rs.getInt("product_img_id"));
				productImgBO.setProduct_des_id(rs.getInt("product_des_id"));
				productImgBO.setProduct_first_pic(rs.getBytes("product_first_pic"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,con);
		}
		return productImgBO;
	}

//	查詢特定商品編號的全部圖片 按product_img_id 正序
	@Override
	public List<ProductImgBO> getAllProPic(Integer product_id) {
		List<ProductImgBO> listProductImgBO = new ArrayList<>();
		ProductImgBO productImgBO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_PRODUCT_ALL_PIC);
			pstmt.setInt(1, product_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productImgBO = new ProductImgBO();
				productImgBO.setProduct_id(rs.getInt("product_id"));
				productImgBO.setProduct_des_id(rs.getInt("product_des_id"));
				productImgBO.setProduct_img_id(rs.getInt("product_img_id"));
				productImgBO.setProduct_the_pic(rs.getBytes("product_img"));
				listProductImgBO.add(productImgBO);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,con);
		}
		return listProductImgBO;
	}
	
//  查詢特定會員的WishlistProduct list
	@Override
	public List<WishlistProduct> getWishlistProductsByMemberId(Integer memberId) {
		List<WishlistProduct> listWishlistProduct = new ArrayList<>();
		WishlistProduct wishlistProduct = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_WISH_PRODUCT_BY_MEMID);
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				wishlistProduct = new WishlistProduct();
				wishlistProduct.setMemberId(rs.getInt("member_id"));
				wishlistProduct.setProductId(rs.getInt("product_id"));
				wishlistProduct.setWishlistProductId(rs.getInt("wishlist_product_id"));
				listWishlistProduct.add(wishlistProduct);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt,con);
		}
		return listWishlistProduct;
	}
}
