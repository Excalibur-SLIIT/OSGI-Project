package delivery;

import java.util.ArrayList;
import java.util.List;

import item.Item;

public class Delivery {

	private int deliveryId;
	private String customerName;
	private String customerAddress;
	private String customerOrderDate;
	private List<Item> customerItemList = new ArrayList<Item>();

	public Delivery(int deliveryId, String customerName, String customerAddress, String customerOrderDate,
			List<Item> customerItemList) {
		super();
		this.deliveryId = deliveryId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerOrderDate = customerOrderDate;
		this.customerItemList = customerItemList;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerOrderDate() {
		return customerOrderDate;
	}

	public void setCustomerOrderDate(String customerOrderDate) {
		this.customerOrderDate = customerOrderDate;
	}

	public List<Item> getCustomerItemList() {
		return customerItemList;
	}

	public void setCustomerItemList(List<Item> customerItemList) {
		this.customerItemList = customerItemList;
	}

}
