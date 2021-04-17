package itemcheckoutimpl;

import java.util.List;

import item.Item;
import itemcheckout.ItemCheckOut;
import itemstorage.ItemStorage;

public class ItemCheckOutImpl implements ItemCheckOut {
	private List<Item> itemList = ItemStorage.itemList;
	private String[][] billDetails = new String[100][4];
	private double bill;
	private int count = 0;

	@Override
	public List<Item> itemDisplay() {
		return ItemStorage.itemList;
	}

	@Override
	public int billCalculation(int itemId, int itemQuantity) {
		boolean found = true;
		Item itemCurrent = null;
		for (Item itemTemp : itemList) {
			if (itemId == itemTemp.getItemId()) {
				itemCurrent = itemTemp;
				found = false;
				break;
			}
			count++;
		}
		if (!found) {
			this.bill = this.bill + (itemCurrent.getItemPriceFinal() * itemQuantity);

			billDetails[count][0] = Integer.toString(itemId);
			billDetails[count][1] = itemCurrent.getItemName();
			billDetails[count][2] = Integer.toString(itemQuantity);
			billDetails[count][3] = Double.toString(itemCurrent.getItemPriceFinal() * itemQuantity);
		}
		return 0;
	}

	@Override
	public double getFinalBill() {
		double billFinal = this.bill;
		newBill();

		return billFinal;
	}

	private void newBill() {
		this.bill = 0;
		this.count = 0;
	}

	@Override
	public String[][] billDisplay() {
		return billDetails;
	}

}
