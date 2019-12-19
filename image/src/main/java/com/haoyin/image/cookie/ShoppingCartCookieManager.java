package com.haoyin.image.cookie;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.haoyin.cookie.CookieManager;
import com.haoyin.cookie.CookieMapping;
import com.haoyin.cookie.rw.CookieReader;
import com.haoyin.cookie.rw.CookieWriter;
import com.haoyin.image.entity.ShoppingCartItem;





/**
 * <p>
 * 购物车 Cookie 管理类
 * </p>
 * 
 * @author summer
 */
public class ShoppingCartCookieManager {

	private final static Logger log = LoggerFactory.getLogger(ShoppingCartCookieManager.class);

	private ShoppingCartCookieManager() {
	}

	/**
	 * <p>
	 * 将购物车数据写入用户浏览器 Cookie
	 * </p>
	 * 
	 * @param cars
	 */
	public static void writeShoppingCars(ShoppingCartItem[] items) {
		CookieWriter writer = CookieManager.newCookieWriter(CookieName.CG_SHOPPING_CART);
		writer.addCookie(CookieName.CN_SHOPPING_CAR, items);

		if (items != null) {
			int len = items.length;
			for (ShoppingCartItem car : items) {
				if (car.getItemId() == null) {
					len--;
				}
			}
			writer.addCookie(CookieName.CN_SHOPPING_NUMBER, len);
		}
		ServletRequestAttributes  requestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletResponse				response=requestAttributes.getResponse();
		writer.write(response);
	}

	/**
	 * 修改购物车数量
	 * @Description: 
	 * @author Sunny
	 * @date 2015年11月25日 上午10:51:43 
	 * @return void
	 */
	public static void writeShoppingNumber(Integer number){
		CookieWriter writer = CookieManager.newCookieWriter(CookieName.CG_SHOPPING_CART);
		writer.addCookie(CookieName.CN_SHOPPING_NUMBER, number);
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = requestAttributes.getResponse();
		writer.write(response);
	}
	
	
	/**
	 * 清空购物车信息
	 * 
	 * @return
	 */
	public static void clearShoppingCart() {
		writeShoppingCars(null);
	}

	/**
	 * <p>
	 * 删除购物车中的某条数据
	 * </p>
	 * 
	 * @param String
	 */
	public static void deleteItemFromShoppingCart(String ids) {
		if (ids == null) {
			return;
		}
		
		String[] itemIds = ids.split(",");
		if (itemIds == null || itemIds.length == 0) {
			return;
		}

		ShoppingCartItem[] cars = getCookieShoppingCarts();
		if (cars == null || cars.length == 0) {
			return;
		}

		for (int i = 0; i < itemIds.length; i++) {
			String itemId = itemIds[i];

			for (int j = 0; j < cars.length; j++) {
				String id = cars[j].getItemId();
				
				if (id != null && id.equals(itemId)) {
					cars[j].setItemId(null);
				}
			}
		}

		writeShoppingCars(cars);
	}
	
	/**
	 * <p>
	 * 删除购物车中的某条数据
	 * </p>
	 * 
	 * @param list
	 */
	public static void deleteItemFromShoppingCart(List<String> list) {
		if (null == list) {
			return;
		}

		ShoppingCartItem[] cars = getCookieShoppingCarts();
		if (cars == null || cars.length == 0) {
			return;
		}

		for (String rid : list) {
			for (int j = 0; j < cars.length; j++) {
				String id = cars[j].getItemId();
				
				if (id != null && id.equals(rid)) {
					cars[j].setItemId(null);
				}
			}
		}

		writeShoppingCars(cars);
	}

	/**
	 * <p>
	 * 获取用户的购物车数据
	 * </p>
	 * 
	 * @return
	 */
	public static ShoppingCartItem[] getCookieShoppingCarts() {
		CookieReader reader = CookieManager.newCookieReader(CookieName.CG_SHOPPING_CART);
		CookieMapping mapping = WebCookieManager.getCookieMapping();
		if (!reader.readCookies(mapping, WebCookieManager.getresponse())) {
			log.warn("read shopping car data cause error, cannot read shopping cookies value");
			return new ShoppingCartItem[0];
		}
		return (ShoppingCartItem[]) reader.getOriginalValue(CookieName.CN_SHOPPING_CAR);
	}

	public static int getCookieShoppingCartsCount() {
		CookieReader reader = CookieManager.newCookieReader(CookieName.CG_SHOPPING_CART);
		CookieMapping mapping = WebCookieManager.getCookieMapping();
		if (!reader.readCookies(mapping, WebCookieManager.getresponse())) {
			log.warn("read shopping car data cause error, cannot read shopping cookies value");
			return 0;
		}
		Integer count = (Integer) reader.getOriginalValue(CookieName.CN_SHOPPING_NUMBER);
		if (count == null) {
			return 0;
		}
		return count;
	}
}
