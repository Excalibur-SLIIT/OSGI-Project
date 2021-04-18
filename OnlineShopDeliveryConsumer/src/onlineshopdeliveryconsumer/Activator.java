package onlineshopdeliveryconsumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import item.Item;
import itemdelivery.ItemDelivery;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	Scanner scan = new Scanner(System.in);
	int quit = 0;
	int option = 0;
	int reLoop = -1;

	public void start(BundleContext context) throws Exception {

		System.out.println("*****Online Shop Delivery Consumer Started*****");
		serviceReference = context.getServiceReference(ItemDelivery.class.getName());

		ItemDelivery itemDelivery = (ItemDelivery) context.getService(serviceReference);

		do {

			System.out.println("Please select an option:");
			System.out.println("1.Add item to the delivery list");
			System.out.println("2.Update item in the delivery list");
			System.out.println("3.Delete item in the delivery list");
			System.out.println("4.Search item in the delivery list");
			System.out.println("5.List all items");
			System.out.println("6.Quit");

			System.out.println("Enter respective option number: ");
			option = scan.nextInt();

			switch (option) {
			case 1:
				do {
					System.out.println("Enter customer name: ");
					String name = scan.nextLine();
					System.out.println("Enter customer address: ");
					String address = scan.nextLine();
					System.out.println("Enter order date: ");
					String date = scan.nextLine();
					List<Item> list = itemDelivery.collectList();

					itemDelivery.addDelivery(name, address, date, list);

					System.out.println("Enter 0  to end adding items to delivery list or press any key to enter again");

				} while (reLoop == 0);
				break;
			default:
				System.out.println("invalid number");
				break;
			}

			System.out.println("To Quit press 0 or to continue press any other key");
			quit = scan.nextInt();
		} while (quit != 0);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("============online shop delivery consumer stopped.============");
		context.ungetService(serviceReference);
	}

}
