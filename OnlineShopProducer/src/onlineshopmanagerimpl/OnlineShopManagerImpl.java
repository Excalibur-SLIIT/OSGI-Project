package onlineshopmanagerimpl;

import java.util.List;

import item.Item;
import itemstorage.ItemStorage;
import onlineshopmanager.OnlineShopManager;

public class OnlineShopManagerImpl implements OnlineShopManager {

	@Override
	public synchronized int addItem(String itemName, double itemPrice, double itemDiscountPercentage) {
		Item item = new Item(ItemStorage.itemList.size() + 1, itemName, itemPrice, itemDiscountPercentage);
		ItemStorage.itemList.add(item);
		return 0;
	}

	@Override
	public synchronized int updateItem(String outdatedItemName, String updatedItemName, double updatedItemPrice,
			double updatedItemDiscountPercentage) {
		
		Item itemOutdated = null;
		boolean itemFound = false;
		int count = 0;

		for (Item itemTemp : ItemStorage.itemList) {
			if (itemTemp.getItemName().equalsIgnoreCase(outdatedItemName)) {

				itemOutdated = itemTemp;
				itemFound = true;
				break;
			}
			count++;
		}
		if (itemFound) {
			itemOutdated.setItemName(updatedItemName);
			itemOutdated.setItemPrice(updatedItemPrice);
			itemOutdated.setItemDiscountPercentage(updatedItemDiscountPercentage);

			ItemStorage.itemList.set(count + 1, itemOutdated);
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public int removeItem(String itemName) {
		boolean itemFound = false;
		int count = 0;

		for (Item itemTemp : ItemStorage.itemList) {
			if (itemTemp.getItemName().equalsIgnoreCase(itemName)) {

				itemFound = true;
				break;
			}
			count++;
		}
		if (itemFound) {
			ItemStorage.itemList.remove(count + 1);
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public int searchItem(String itemName) {

		boolean itemFound = false;

		for (Item itemTemp : ItemStorage.itemList) {
			if (itemTemp.getItemName().equalsIgnoreCase(itemName)) {

				itemFound = true;
				break;
			}
		}
		if (itemFound) {
			return 0;
		} else {
			return -1;
		}

	}

	@Override
	public List<Item> itemList() {
		return ItemStorage.itemList;
	}

}
