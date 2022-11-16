/**
 * Product類，描述商品的一些基本屬性
 */
package Shop;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
	//設定基本商品屬性
	
	private String name;
	private BigDecimal price;
	
	public Product() {}
	//建構子，初始化資訊
	public Product(int no, String name,BigDecimal price) 
	{
		this.no = no;
		this.name = name;
		this.price = price;
	}
	
	private int no;
	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", price=" + price + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, no, price);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name) && no == other.no && Objects.equals(price, other.price);
	}
	
	
	
}
