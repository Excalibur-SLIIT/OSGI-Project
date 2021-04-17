package itemcheckout;

import java.util.List;

import item.Item;

public interface ItemCheckOut {

	public List<Item> itemDisplay();

	public int billCalculation(int itemId, int itemQuantity);

	public double getFinalBill();

	public String[][] billDisplay();

}
