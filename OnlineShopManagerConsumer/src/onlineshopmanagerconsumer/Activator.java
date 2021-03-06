package onlineshopmanagerconsumer;

import java.util.List;
import java.util.Scanner;
import onlineshopmanager.OnlineShopManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import item.Item;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	Scanner userInput = new Scanner(System.in);

	boolean quit = false;
	int option = 0;
	int reLoop = -1;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("*****Online Shop Manager Consumer Started*****");
		serviceReference = context.getServiceReference(OnlineShopManager.class.getName());

		OnlineShopManager onlineShopManager = (OnlineShopManager) context.getService(serviceReference);

		do {

			System.out.println("**********Welcome To Online Shop Item Management**********");

			System.out.println("Please select an option:");
			System.out.println("1.Add item");
			System.out.println("2.Update item");
			System.out.println("3.Delete item");
			System.out.println("4.Search item");
			System.out.println("5.List all items");
			System.out.println("6.Quit");

			System.out.println("Enter respective option number: ");
			option = userInput.nextInt();

			switch (option) {

			case 1: {
				do {
					userInput.nextLine();
					
					System.out.println("Enter item name:");
					String itemName = userInput.nextLine();

					System.out.println("Enter item price:");
					double itemPrice = userInput.nextDouble();

					System.out.println("Enter item discount percentage:");
					double itemDiscount = userInput.nextDouble();

					int result = onlineShopManager.addItem(itemName, itemPrice, itemDiscount);

					if (result == 0) {
						System.out.println("Item added successfully!");
					} else {
						System.out.println("Item add unsccessfull!");
					}

					System.out.println("Enter '0' to add another item or enter any number to go to main menu: ");
					reLoop = userInput.nextInt();
				} while (reLoop == 0);

				break;
			}
			case 2: {
				do {
					userInput.nextLine();
					
					System.out.println("Enter old item Name:");
					String outdatedItemName = userInput.nextLine();

					System.out.println("Enter new item Name:");
					String updatedItemName = userInput.nextLine();

					System.out.println("Enter new item Price: ");
					double updatedItemPrice = userInput.nextDouble();

					System.out.println("Enter item discount percentage: ");
					double updatedItemDiscount = userInput.nextDouble();
					userInput.nextLine();

					int result = onlineShopManager.updateItem(outdatedItemName, updatedItemName, updatedItemPrice,
							updatedItemDiscount);
					if (result == 0) {
						System.out.println("Item update successfully!");
					} else {
						System.out.println("Item update unsccessfull!");
					}

					System.out.println("Enter '0' to update another item or enter any number to go to main menu: ");
					reLoop = userInput.nextInt();
				} while (reLoop == 0);
				break;
			}
			case 3: {
				do {
					userInput.nextLine();
					
					System.out.println("Enter the item name:");
					String itemName = userInput.nextLine();

					int result = onlineShopManager.removeItem(itemName);
					if (result == 0) {
						System.out.println("Item removed successfully!");
					} else {
						System.out.println("Item removed unsccessfull!");
					}

					System.out.println("Enter '0' to remove another item or enter any number to go to main menu: ");
					reLoop = userInput.nextInt();
				} while (reLoop == 0);

				break;
			}
			case 4: {
				do {
					userInput.nextLine();

					System.out.println("Enter the item name:");
					String itemName = userInput.nextLine();

					int result = onlineShopManager.searchItem(itemName);
					if (result == 0) {
						System.out.println("Item found!");
					} else {
						System.out.println("Item not found!");
					}

					System.out.println("Enter '0' to search another item or enter any number to go to main menu: ");
					reLoop = userInput.nextInt();
				} while (reLoop == 0);
				break;
			}
			case 5: {

				do {
					List<Item> itemsList = onlineShopManager.itemList();
					System.out.println(
							"-----------------------------------Item list--------------------------------------------");
					System.out.println("Item ID:" + "\t" + "Item Name:" + "\t" + "Item Price:" + "\t"
							+ "Discount Amount:" + "\t" + "Item Final Price:" + "\t");

					for (Item tempItem : itemsList) {
						System.out.println(tempItem.getItemId() + "\t         " + tempItem.getItemName() + "\t         "
								+ tempItem.getItemPrice() + "\t         " + tempItem.getItemDiscount()
								+ "\t                  " + tempItem.getItemPriceFinal() + "\t" + "\n");

					}
					System.out.println(
							"-----------------------------------------------------------------------------------------");

					System.out.println("Enter '0' to view item list again or enter any number to go to main menu: ");
					reLoop = userInput.nextInt();
				} while (reLoop == 0);
				break;

			}
			case 6: {
				quit = true;
				break;
			}
			default:
				System.out.println("Please enter a valid option number!");
			}

		} while (quit == false);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("============online shop manager consumer stopped.============");
		context.ungetService(serviceReference);
	}

}
