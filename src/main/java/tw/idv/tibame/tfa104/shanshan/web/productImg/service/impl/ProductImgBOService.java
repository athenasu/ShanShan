package tw.idv.tibame.tfa104.shanshan.web.productImg.service.impl;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.productImg.entity.ProductImgBO;


public interface ProductImgBOService {

//	查詢特定商品明細編號的第1/2/3/4/5張圖片 變數為product_des_i = ? / limit = ? ,1 (0是第1張圖片, 1是第二章圖片, 以此類推)
    public ProductImgBO getPic(Integer product_des_id ,Integer ingore_num_pic);
    
//	查詢特定商品編號的第一個商品明細編號的第一張圖片
    public ProductImgBO getProDesFirstPic(Integer product_id);

//	查詢特定商品明細編號的全部圖片 按product_img_id 正序
    public List<ProductImgBO> getAllProPic();
    
//	查詢特定商品編號的全部圖片 按product_img_id 正序
    public List<ProductImgBO> getAllProDesPic();
}


