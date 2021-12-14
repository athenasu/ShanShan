package tw.idv.tibame.tfa104.shanshan.web.shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;

public class Cart {

//		建立一個空的CartItem的map集合，該集合key以productId命名，value是對應的CartItem物件，進去購物車頁面時，可以調用到這個空的HashMap集合
	private Map<String, CartItem> mapCartItem = new HashMap<String, CartItem>();
	private Integer totalPrice = 0;
//  購物車icon的數字
	@SuppressWarnings("unused")
	private Integer totalItemQTY = 0;
	
//	EL表達式中，取值的方法是透過物件的get方法，去掉get,屬性名改小寫，取到該get方法的值。
	public Collection<CartItem> getCartItems() {
		return mapCartItem.values();
	}

	public Integer getTotalPrice() {

//		把CartItem的map集合轉成list集合
		List<CartItem> listCartItem = new ArrayList<CartItem>(mapCartItem.values());

//		遍歷購物車項目list集合，次數為list集合長度
		Integer sum = 0;
		for (Integer i = 0; i < listCartItem.size(); i++) {
//			取得購物車項目價錢
			Integer itemSubtotal = listCartItem.get(i).getSubtotalPrice();
//			進行加總
			sum += itemSubtotal;
		}
		return sum;
	}

//  改變購物車icon的數字
	public Integer getTotalItemQTY() {
		int sum = mapCartItem.size();
		return sum;
	}

	public void setTotalItemQTY(Integer totalItemQTY) {
		this.totalItemQTY = totalItemQTY;
	}
	public Cart() {
		super();
	}

	public Map<String, CartItem> getMapCartItem() {
		return mapCartItem;
	}

	public void setMapCartItem(Map<String, CartItem> mapCartItem) {
		this.mapCartItem = mapCartItem;
	}


	public void setTotalPrice(Integer totalPrice) {;
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [mapCartItem=" + mapCartItem + ", totalPrice=" + totalPrice + "]";
	}

//		添加購物車項目
	public void addCartItem(Cart cart, Integer productDesId, Integer itemQTY) {
//		取得商品明細物件
		ShopService service = new ShopServiceImpl();
		ProductBO productBO = service.findProductByProDesId(productDesId);

//		新增CartItem物件
		CartItem cartItem = new CartItem();
//		封裝productBO資料到CartItem物件
		cartItem.setProductId(productBO.getProductId());
		cartItem.setProdesId(productDesId);
		cartItem.setProductName(productBO.getProductName());
		cartItem.setCompanyId(productBO.getCompanyId());
		cartItem.setCompanyName(productBO.getCompanyName());
		cartItem.setProductSize(productBO.getProductSize());
		cartItem.setProductColor(productBO.getProductColor());
		cartItem.setProductPrice(productBO.getProductPrice());
		cartItem.setItemQTY(itemQTY);
		cartItem.setSubtotalPrice();

//		把productDesId轉成字串
		String str = Integer.toString(productDesId);

//		放新的cartItem到mapCartItem裡面
		mapCartItem.put(str, cartItem);
		
//		放mapCartItem到購物車裡
		cart.setMapCartItem(mapCartItem);

//		更新總價
		cart.setTotalPrice(getTotalPrice());

	}

//	移除購物車項目
	public void removeCartItem(Cart cart, Integer productDesId) {

		// 調用方法，清空購物車MapCartItem
		String productDesIdStr = Integer.toString(productDesId);
		mapCartItem.remove(productDesIdStr);
//		更新總價
		cart.setTotalPrice(getTotalPrice());

	}

//	刪除全部購物車項目
	public void cleanCartItem(Cart cart) {
		mapCartItem.clear();
//		更新總價
		cart.setTotalPrice(cart.getTotalPrice());
	}

//	更改購物車項目數量
	public void changeItemQTY(Cart cart, Integer productDesId ,Integer itemQTY) {
		
//		把productDesId轉成字串
		String productDesIdStr = Integer.toString(productDesId);
//		取出對應的購物車項目
		CartItem cartItem = mapCartItem.get(productDesIdStr);
//		設定對應購物車項目的數量
		cartItem.setItemQTY(itemQTY);
//		把購物車項目塞回mapCartItem
		mapCartItem.put(productDesIdStr ,cartItem);

//		List<CartItem> listCartItem = new ArrayList<CartItem>(mapCartItem.values());
		
//		更新總價
		cart.setTotalPrice(cart.getTotalPrice());
	}

}
