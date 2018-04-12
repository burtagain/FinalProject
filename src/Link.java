
/**
 * @author Link Class that specifies a link object which contains a Movie object
 */
public class Link {

	public Customer Customer;
	
	

	public Link next;

	public Link(Customer inCustomer) {

		Customer = inCustomer;

	}

	/**
	 * Displays can object stored in Link
	 */
	public void displayLink() {
		
		System.out.print("{" + Customer.getName() + "} ");
		
	}
}
