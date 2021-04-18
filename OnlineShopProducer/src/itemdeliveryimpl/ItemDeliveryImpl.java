package itemdeliveryimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import delivery.Delivery;
import item.Item;
import itemdelivery.ItemDelivery;
import itemstorage.ItemStorage;

public class ItemDeliveryImpl implements ItemDelivery {
	
	Scanner scan = new Scanner(System.in);

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

	@Override
	public List<Item> itemList() {
		return ItemStorage.itemList;
	}

	@Override
	public List<Item> collectList() {

		ArrayList<Item> list = new ArrayList<Item>(), returningList = new ArrayList<Item>();
		int searchKey = 0, counter = 0, exit = 0;

		list = (ArrayList<Item>) this.itemList();

		do {
			counter = 0;
			System.out.println("\n*** Item List***\n");
			for (Item item : list) {
				System.out.println(counter++ + ":" + item.getItemId() + " - " + item.getItemName());
			}
			counter = 0;
			System.out.println("Enter item number to add to the list");
			searchKey = scan.nextInt();
			if (0 < searchKey && searchKey < list.size()) {
				returningList.add(list.get(searchKey));
				list.remove(searchKey);
				System.out.println("\nitem added\n***Delivery List***\n");
				for (Item item : returningList) {
					System.out.println(counter++ + ":" + item.getItemId() + " - " + item.getItemName());
				}
			} else {
				System.out.println("Entered number is invalid");
			}

			System.out.println("To continue adding items press 0 and to end press any number");
			exit = scan.nextInt();
		} while (exit == 0);
		return returningList;
	}

}
