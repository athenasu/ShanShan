package tw.idv.tibame.tfa104.shanshan.web.productImg.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import tw.idv.tibame.tfa104.shanshan.web.JDBCutil.JDBCUtil;
import tw.idv.tibame.tfa104.shanshan.web.productImg.dao.ProductImgBODAO;
import tw.idv.tibame.tfa104.shanshan.web.productImg.entity.ProductImgBO;


public class ProductImgBODAOImpl implements ProductImgBODAO {
	
//	查詢特定商品明細編號的第1/2/3/4/5張圖片 變數為product_des_i = ? / limit = ? ,1 (0是第1張圖片, 1是第二章圖片以此類推)
	private static final String GET_PIC = "SELECT * FROM product_img WHERE product_des_id = ? order by product_img_id limit ? , 1";
//	查詢特定商品編號的第一個商品明細編號的第一張圖片
	private static final String GET_PRODUCT_FIRST_PIC = "select pro.product_id, img.product_des_id, img.product_img_id, img.product_first_pic from (select a.product_des_id, a.product_id from ( select min(product_des_id) product_des_id , product_id from product_description group by product_id ) a join product_description b using (product_des_id)) pro join( select c.product_img_id, c.product_des_id, d.product_img product_first_pic from ( select min(product_img_id) product_img_id , product_des_id from product_img group by product_des_id ) c join product_img d using (product_img_id))img using (product_des_id) where product_id = ?";
//	查詢特定商品明細編號的全部圖片 按product_img_id 正序
	private static final String GET_ALL_PRODUCT_PIC = "";
//	查詢特定商品編號的全部圖片 按product_img_id 正序
	private static final String GET_ALL_PRODUCT_DES_PIC = "";

	private static DataSource ds = null;
	
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

//	查詢特定商品明細編號的第1/2/3/4/5張圖片 變數為product_des_i = ? / limit = ? ,1 (0是第1張圖片, 1是第二章圖片以此類推)
	@Override
	public ProductImgBO getPic(Integer product_des_id ,Integer ingore_num_pic) {
		ProductImgBO productImgBO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_PIC);
			pstmt.setInt(1, product_des_id);
			pstmt.setInt(2, ingore_num_pic);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productImgBO = new ProductImgBO();
				productImgBO.setProduct_img_id(rs.getInt("product_img_id"));
				productImgBO.setProduct_des_id(rs.getInt("product_des_id"));
				productImgBO.setProduct_des_pic(rs.getBytes("product_des_pic"));
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

//	查詢特定商品明細編號的全部圖片 按product_img_id 正序
	@Override
	public List<ProductImgBO> getAllProPic() {
		return null;
	}

//	查詢特定商品編號的全部圖片 按product_img_id 正序
	@Override
	public List<ProductImgBO> getAllProDesPic() {
		return null;
	}
	
	
}
