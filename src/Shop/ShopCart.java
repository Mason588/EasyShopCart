/**
 * 購物車類，實現商品的添加，刪除，總價，清空等功能
 */
package Shop;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import java.util.Iterator;

public class ShopCart {
	//用Map可快速查找，用來存放商品信息和數量，等於暫時的存放空間
	Map<Product, Integer> productMap;
	
	//算總價
	BigDecimal totalPrice = BigDecimal.valueOf(0,0);
	
	public ShopCart() {
		productMap = new HashMap<>(); 
	}
	
	//向購物車添加商品和數量
	public void add(Product product, int num) {
		//判斷map中是否包含當前商品，如果不包含則直接將商品和數量添加到map裡面
		if(!productMap.containsKey(product)) {
			productMap.put(product,num);
		} else {
			//如果程式到這邊，說明之前已經添加過該商品
			//需要將商品做相加運算
			int before = productMap.get(product); //取得之前購物車的商品數量
			//加總
			int after = before + num;
			//改變數量
			productMap.put(product, after);
		}
		
		//總價 = 商品單價  * 數量
		totalPrice = totalPrice.add(product.getPrice().multiply(BigDecimal.valueOf(num)));
	}
	
	//從購物車中刪除商品和數量 product是品項，num是數量
	public void remove(Product product, int num) {
		//獲取購物車中的當前商品數量
		int before = productMap.get(product);
		if(num >= before) {
			//將該商品從購物車中刪除
			productMap.remove(product);
			//總價要減掉 商品單價  * 數量
			totalPrice = totalPrice.subtract(product.getPrice().multiply(BigDecimal.valueOf(before)));
			
		} else {
			//剩餘的商品數量
			int after = before - num ;
			productMap.put(product, after) ;
			//總價要減掉 商品單價  * 數量
			totalPrice = totalPrice.subtract(product.getPrice().multiply(BigDecimal.valueOf(num)));
		}
	}
	
	//清空購物車
	public void clear() {
		productMap.clear();
		totalPrice = BigDecimal.valueOf(0.0);
	}
	
	//列印商品清單
	public void print() {
		System.out.println("Shop List:");
		System.out.println("*******************************************************************");
		Set<Product> key = productMap.keySet();
		Iterator<Product> iter = key.iterator();
		while(iter.hasNext()) {
			Product p = iter.next();
			Integer i = productMap.get(p);
			System.out.println(i + " commodity\t " + p +"\t" + p.getPrice().multiply(BigDecimal.valueOf(i)));
		}
		System.out.println("*******************************************************************");
		System.out.println("Total Price: " +totalPrice + " $");
	}
}
