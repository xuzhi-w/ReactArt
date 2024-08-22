package esb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class ShippingNextDayActivator {
	@Autowired
	RestTemplate restTemplate;

	public void ship(Order order) {
		System.out.println("shipping next day: "+ order.toString());
		restTemplate.postForLocation("http://localhost:8086/orders", order);
	}
}
