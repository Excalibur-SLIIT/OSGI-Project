package onlineshopmanagerconsumer;

import java.util.Scanner;
import onlineshopmanager.OnlineShopManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

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
			System.out.println("Enter item name: ");
			String itemName = userInput.nextLine();

			System.out.println("Enter item price: ");
			double itemPrice = userInput.nextDouble();

			System.out.println("Enter item discount percentage: ");
			double itemDiscount = userInput.nextDouble();

			int result = onlineShopManager.addItem(itemName, itemPrice, itemDiscount);

			if (result == 0) {
				System.out.println("Item added successfully!");
			} else {
				System.out.println("Item add unsccessfull!");
			}
			
			System.out.println("Enter 0 to add another item: ");
			reLoop = userInput.nextInt();
			}while(reLoop == 0);
		}
		case 2: {

			break;
		}
		case 3: {
			break;
		}
		case 4: {
			break;
		}
		case 5: {
			break;
		}
		case 6: {
			break;
		}
		default:
			System.out.println("Please enter a valid option number!");
		}

	}

	@Override
	public void stop(BundleContext context) throws Exception {

	}

}