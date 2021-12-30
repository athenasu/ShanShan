package tw.idv.tibame.tfa104.shanshan.web.productImg.dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
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

import tw.idv.tibame.tfa104.shanshan.web.productImg.dao.ProductImgDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.productImg.entity.ProductImgVO;

@Repository
public class ProductImgDAO_impl implements ProductImgDAO_interface {
	
	
	private static final String INSERT = "INSERT INTO product_img"+
	"(product_des_id,product_img)"+
	"VALUES(?, ?)";
	private static final String UPDATE = "UPDATE product_img SET product_img = ? WHERE product_des_id = ?" ;
	private static final String DELETE = "DELETE FROM product_img WHERE product_des_id = ?" ;
	private static final String FIND_BY_PRODES = "SELECT * FROM product_img WHERE product_des_id = ?" ;
//	private static final String GET_PRODUCT_ALL_PIC = "SELECT product_id, product_des_id, product_img_id, product_img FROM product_img JOIN product_description USING (product_des_id) WHERE product_des_id = ? ORDER BY product_img_id";
	
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
	public ProductImgVO addProImg(ProductImgVO productImgVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);
			//pstmt.setInt(1, productImgVO.getProductImgId());
			pstmt.setInt(1, productImgVO.getProductDesId());
			//setting picture >set Bytes
			//byte[] pic = getPictureByteArray("/Users/luciechen/Documents/shanshan/products/womenClothes-shop1use/8-1.jpeg");
			pstmt.setBytes(2,productImgVO.getProductImg());
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
		return productImgVO;
		
	}

	@Override
	public ProductImgVO update(ProductImgVO productImgVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			//setting picture >set Bytes
			//byte[] pic = getPictureByteArray("/Users/luciechen/Documents/shanshan/products/womenClothes-shop1use/13-1.jpg");
			pstmt.setBytes(1,productImgVO.getProductImg());
			pstmt.setInt(2, productImgVO.getProductDesId());
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
		return productImgVO;
	}

	@Override
	public Integer delete(Integer productImgId) {
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
		return 1;
		
	}

	@Override
	public List<ProductImgVO> findByproDes(Integer productDesId) {
		List<ProductImgVO> img = new ArrayList<ProductImgVO>();
		ProductImgVO pro = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_BY_PRODES);
			pstmt.setInt(1,productDesId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pro = new ProductImgVO();
				pro.setProductImgId(rs.getInt("product_img_id"));
				pro.setProductImg(rs.getBytes("product_img"));
				pro.setProductDesId(rs.getInt("product_des_id"));

				img.add(pro);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
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

		return img;
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
