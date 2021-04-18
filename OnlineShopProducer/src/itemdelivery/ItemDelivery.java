package itemdelivery;

import java.util.List;

import delivery.Delivery;
import item.Item;

public interface ItemDelivery {
	public int addDelivery(String customerName, String customerAddress, String customerOrderDate,
			List<Item> customerItemList);

	public int updateDelivery(String outdatedCustomerName, String updatedCustomerName, String updatedCustomerAddress,
			String updatedCustomerOrderDate, List<Item> updatedCustomerItemList);

	public int removeDelivery(int deliveryId);

	public int searchDelivery(String customerName);

	public List<Delivery> deliveryList();

	public List<Item> itemList();

	public List<Item> collectList();

}
