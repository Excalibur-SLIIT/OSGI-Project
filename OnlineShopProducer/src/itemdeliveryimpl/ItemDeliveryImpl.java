package itemdeliveryimpl;

import java.util.List;

import delivery.Delivery;
import item.Item;
import itemdelivery.ItemDelivery;
import itemstorage.ItemStorage;

public class ItemDeliveryImpl implements ItemDelivery {

	@Override
	public int addDelivery(String customerName, String customerAddress, String customerOrderDate,
			List<Item> customerItemList) {
		Delivery delivery = new Delivery(ItemStorage.deliveryList.size() + 1, customerOrderDate, customerOrderDate,
				customerOrderDate, customerItemList);
		ItemStorage.deliveryList.add(delivery);
		return 0;
	}

	@Override
	public int updateDelivery(String outdatedCustomerName, String updatedCustomerName, String updatedCustomerAddress,
			String updatedCustomerOrderDate, List<Item> updatedCustomerItemList) {

		Delivery deliveryOutdated = null;
		boolean deliveryFound = false;
		int count = -1;

		for (Delivery deliveryTemp : ItemStorage.deliveryList) {
			count++;
			if (deliveryTemp.getCustomerName().equalsIgnoreCase(outdatedCustomerName)) {

				deliveryOutdated = deliveryTemp;
				deliveryFound = true;
				break;
			}
		}
		if (deliveryFound) {
			deliveryOutdated.setCustomerName(updatedCustomerName);
			deliveryOutdated.setCustomerAddress(updatedCustomerAddress);
			deliveryOutdated.setCustomerOrderDate(updatedCustomerOrderDate);
			deliveryOutdated.setCustomerItemList(updatedCustomerItemList);

			ItemStorage.deliveryList.set(count, deliveryOutdated);
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public int removeDelivery(int deliveryId) {

		boolean deliveryFound = false;
		int count = -1;

		for (Delivery deliveryTemp : ItemStorage.deliveryList) {
			count++;
			if (deliveryTemp.getDeliveryId() == deliveryId) {

				deliveryFound = true;
				break;
			}
		}
		if (deliveryFound) {
			ItemStorage.deliveryList.remove(count + 1);
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public int searchDelivery(String customerName) {

		boolean deliveryFound = false;

		for (Delivery deliveryTemp : ItemStorage.deliveryList) {
			if (deliveryTemp.getCustomerName().equalsIgnoreCase(customerName)) {

				deliveryFound = true;
				break;
			}
		}
		if (deliveryFound) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public List<Delivery> deliveryList() {
		return ItemStorage.deliveryList;
	}

}
