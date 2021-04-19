package onlineshopitemcheckoutconsumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import item.Item;
import itemcheckout.ItemCheckOut;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	Scanner userInput = new Scanner(System.in);

	boolean quit = false;
	int option = 0;
	int reLoop = -1;
	int count = -1;
	int calculateBill = -1;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("*****Online Shop Item Check Out Consumer Started*****");
		serviceReference = context.getServiceReference(ItemCheckOut.class.getName());

		ItemCheckOut itemCheckOut = (ItemCheckOut) context.getService(serviceReference);
		do {

			System.out.println("**********Welcome To Online Shop Item Check Out**********");

			System.out.println("Please select an option:");
			System.out.println("1.View item list");
			System.out.println("2.Generate bill");
			System.out.println("3.Quit");

			System.out.println("Enter respective option number: ");
			option = userInput.nextInt();

			switch (option) {
			case 1: {
				do {
					List<Item> itemsList = itemCheckOut.itemDisplay();
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
			case 2: {
				do {
					do {
						System.out.println("**********Customer Billing section**********" + "\n");

						System.out.println("Enter item id");
						int itemId = userInput.nextInt();

						System.out.println("Item Quantity");
						int quantity = userInput.nextInt();

						int result = itemCheckOut.billCalculation(itemId, quantity);

						if (result == -1) {
							System.out.println("Invalid value");
						} else {
							count++;
						}

						userInput.nextLine();
						System.out.println("Enter '0' to add another item or enter any number to calculate total bill");
						calculateBill = userInput.nextInt();
					} while (calculateBill == 0);

					System.out.println(
							"------------------------------------------Receipt----------------------------------------");
					String[][] bill = itemCheckOut.billDisplay();

					String format = "%-20s";
					System.out.printf(format, "ID:");
					System.out.printf(format, "Name:");
					System.out.printf(format, "Quantity:");
					System.out.printf(format, "Total amount:");
					System.out.println("");

					for (int a = 0; a <= count; a++) {
						for (int b = 0; b < 4; b++) {
							System.out.printf(format, bill[a][b]);
						}
						System.out.println("");
					}
					System.out.println("Total Amount: " + itemCheckOut.getFinalBill());
					count = -1;
					System.out.println("Enter '0' to view item list again or enter any number to go to main menu: ");
					reLoop = userInput.nextInt();
				} while (reLoop == 0);
				break;
			}
			case 3: {
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
		System.out.println("*****Online Shop Item Check Out Consumer Stopped*****");
		context.ungetService(serviceReference);

	}

}
