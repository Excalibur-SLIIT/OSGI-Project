package onlineshopproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import itemcheckout.ItemCheckOut;
import itemcheckoutimpl.ItemCheckOutImpl;
import onlineshopmanager.OnlineShopManager;
import onlineshopmanagerimpl.OnlineShopManagerImpl;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("*****Online Shopping Producer Service Started****");

		OnlineShopManager shopProducer = new OnlineShopManagerImpl();
		serviceRegistration = context.registerService(OnlineShopManager.class.getName(), shopProducer, null);

		ItemCheckOut itemCheckOut = new ItemCheckOutImpl();
		serviceRegistration = context.registerService(ItemCheckOut.class.getName(), itemCheckOut, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("*****Online Shopping Producer Service Closed****");

		serviceRegistration.unregister();

	}

}
