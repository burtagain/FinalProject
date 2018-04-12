
public class LinkedWishList {

	private Link first;
	private Link last;
	
	/**
	 * Default constructor
	 */
	public LinkedWishList() {
		first = null;
		last = null;
	}
	
	/**
	 * @return
	 * Tests to see if LinkedList is empty
	 */
	public boolean isEmpty() {
		return (first==null);
	}
	
	/**
	 * @param inCan
	 * inserts new can object into LinkedList
	 */
	public void insertLast(Customer inCustomer) {
		Link newLink = new Link (inCustomer);
		if (isEmpty())
			first = newLink;
		else last.next = newLink;
		last = newLink;
		
	}
	
	/**
	 * @return
	 * removes first object from beginning of Linked List
	 */
	public Customer deleteFirst() {
		Link temp = first;
		if (first.next == null)
			last = null;
		first = first.next;
		
		return temp.Customer;
	}
	


	/**
	 * @return
	 * returns first object in linked List
	 */
	public Customer getFirst() {
		return first.Customer;
	}
	
	/**
	 * prints all objects in Linked LIst
	 */
	public void displayList() {
		System.out.print("List (first -->last: ");
	    Link current = first;
	    while (current != null) {
	    	current.displayLink();
	    	current = current.next;
	    }
	}
	
	public Boolean inList(Customer inCustomer) {
		Link current = first;
		Boolean present = false;
		while (current != null) { 
			if (current.Customer.getCustomerID() == inCustomer.getCustomerID()) {
				present = true;
				
			}
			current = current.next;
			
		}
		return present;
	}
	
	/**
	 * @return
	 * Shows current size of Linked LIst
	 */
	public int size() {
		int counter = 0;
		Link current = first;
		while (current != null) {
			counter++;
			current = current.next;
		}
		
		return counter;
	
	}
}
