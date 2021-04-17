package itemdeliveryimpl;

import itemdelivery.ItemDelivery;

public class ItemDeliveryImpl implements ItemDelivery{

	@Override
	public synchronized int addDelivery(String customerName, String customerAddress) {
		return 0;
	}

	@Override
	public synchronized int removeDelivery(String customerName) {
		return 0;
	}

	@Override
	public synchronized int updateDelivery(String updatedCustomerName, String updatedCustomerAddress) {
		return 0;
	}

	@Override
	public String[][] viewDelivery() {
		return null;
	}

}
