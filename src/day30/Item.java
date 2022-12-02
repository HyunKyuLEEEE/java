package day30;

import java.util.Date;

import lombok.Data;

//(분류(과자,학용품), 제품명, 수량, 구매가격, 판매가격)
@Data
public class Item {
	private String category, name;
	private int amount, buyPrice, sellPrice;
	private Date sellDate;
	
	public Item(String category, String name, int amount, int buyPrice, int sellPrice) {
		this.category = category;
		this.name = name;
		this.amount = amount;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}
	
	
}
