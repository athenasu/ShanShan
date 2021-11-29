package tw.idv.tibame.tfa104.shanshan.web.productImg.dao.impl;

import java.io.FileInputStream;
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

import tw.idv.tibame.tfa104.shanshan.web.productImg.dao.ProductImgDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.productImg.entity.ProductImgVO;


public class ProductImgDAO_impl implements ProductImgDAO_interface {
	
	
	private static final String INSERT = "INSERT INTO product_img"+
	"(product_img_id,product_des_id,product_img)"+
	"VALUES(?, ?, ?)";
	private static final String UPDATE = "UPDATE product_img SET product_img = ? WHERE product_img_id = ?" ;
	private static final String DELETE = "DELETE FROM product_img WHERE product_img_id = ?" ;
	
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ShanShan");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void insert(ProductImgVO productImgVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, productImgVO.getProductImgId());
			pstmt.setInt(2, productImgVO.getProductDesId());
			//setting picture >set Bytes
			byte[] pic = getPictureByteArray("/Users/luciechen/Documents/shanshan/products/womenClothes-shop1use/8-1.jpeg");
			pstmt.setBytes(3,pic);
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void update(ProductImgVO productImgVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			//setting picture >set Bytes
			byte[] pic = getPictureByteArray("/Users/luciechen/Documents/shanshan/products/womenClothes-shop1use/13-1.jpg");
			pstmt.setBytes(1,pic);
			pstmt.setInt(2, productImgVO.getProductImgId());
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete(int productImgId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, productImgId);
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
	}



	//-----------------------------傳照片methods------------------------------
	// 使用byte[] upload picture
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}
}
