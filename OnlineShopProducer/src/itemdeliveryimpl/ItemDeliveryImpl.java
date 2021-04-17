package itemdeliveryimpl;

import java.util.List;

import delivery.Delivery;
import item.Item;
import itemdelivery.ItemDelivery;

public class ItemDeliveryImpl implements ItemDelivery {

	@Override
	public int addDelivery(String customerName, String customerAddress, String customerOrderDate,
			List<Item> customerItemList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDelivery(String updatedCustomerName, String updatedCustomerAddress,
			String updatedCustomerOrderDate, List<Item> updatedCustomerItemList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeDelivery(int deliveryId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int searchDelivery(String customerName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Delivery> deliveryList() {
		// TODO Auto-generated method stub
		return null;
	}

}
