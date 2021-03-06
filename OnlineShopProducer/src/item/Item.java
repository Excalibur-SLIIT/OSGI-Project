package item;

public class Item {
	private int itemId;
	private String itemName;
	private double itemPrice;
	private double itemDiscountPercentage;
	private double itemPriceFinal;
	private double itemDiscount;

	public Item(int itemID, String itemName, double itemPrice, double itemDiscountPercentage) {
		super();
		this.itemId = itemID;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDiscountPercentage = itemDiscountPercentage;
		
		calculateItemDiscount(this.itemDiscountPercentage);
	}

	public int getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public double getItemDiscountPercentage() {
		return itemDiscountPercentage;
	}

	public double getItemPriceFinal() {
		return itemPriceFinal;
	}

	public double getItemDiscount() {
		return itemDiscount;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setItemDiscountPercentage(double itemDiscountPercentage) {
		this.itemDiscountPercentage = itemDiscountPercentage;
	}

	public void calculateItemDiscount(double discountPercentage) {
		this.itemDiscount = itemPrice * (itemDiscountPercentage / 100);
		calculateItemPriceFinal(this.itemDiscount);
	}
	
	public void calculateItemPriceFinal(double discountAmount) {
		this.itemPriceFinal = this.itemPrice - discountAmount;
	}

}
