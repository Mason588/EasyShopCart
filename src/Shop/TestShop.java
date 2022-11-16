package Shop;

import java.math.BigDecimal;

public class TestShop {

	public static void main(String[] args) {
		//創建購物車
		ShopCart cart = new ShopCart();
		
		//商品
		Product book1 = new Product(01,"Good book",BigDecimal.valueOf(200));
		Product book2 = new Product(02,"SQL SERVER",BigDecimal.valueOf(300));
		Product book3 = new Product(03,"JAVA8 SE",BigDecimal.valueOf(450));
		
		//開始購物
		cart.add(book1, 1);
		cart.add(book2, 2);
		cart.add(book3, 3);
		
		//打印清單
		cart.print();

	}

}
