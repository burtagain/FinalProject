
/**
 * @author Burt LinkedList class used for Customer and Movie objects
 */
public class LinkedList {
	private Link first;
	private Link last;

	/**
	 * Default constructor
	 */
	public LinkedList() {
		first = null;
		last = null;
	}

	/**
	 * @return Tests to see if LinkedList is empty
	 */
	public boolean isEmpty() {
		return (first == null);
	}

	/**
	 * @param inCan
	 *            inserts new Customer object into LinkedList
	 */
	public void insertLast(Customer inCustomer) {
		Link newLink = new Link(inCustomer);
		if (isEmpty())
			first = newLink;
		else
			last.next = newLink;
		last = newLink;

	}

	/**
	 * @param inMovie
	 *            inserts new Movie object into LinkedList
	 */
	public void insertLast(Movie inMovie) {
		Link newLink = new Link(inMovie);
		if (isEmpty())
			first = newLink;
		else
			last.next = newLink;
		last = newLink;

	}

	/**
	 * @return removes first object from beginning of Linked List
	 */
	public Customer deleteFirst() {
		Link temp = first;
		if (first.next == null)
			last = null;
		first = first.next;

		return temp.Customer;
	}

	/**
	 * @return returns first Customer object in linked List
	 */
	public Customer getFirstCust() {

		return first.Customer;
	}

	/**
	 * @return returns first Movie object in linked List
	 */
	public Movie getFirstMov() {
		return first.Movie;
	}

	/**
	 * prints all objects in Linked LIst
	 */
	public String displayList() {
		String sep = System.lineSeparator();
		String stringOut = (sep + "List (first -->last: " + sep);
		Link current = first;
		while (current != null) {
			stringOut = stringOut + current.displayLink();
			current = current.next;

		}
		return stringOut;
	}

	/**
	 * @param inCustomer
	 *            Returns true if customer present in Queue
	 * @return
	 */
	public Boolean inList(Customer inCustomer) {
		Link current = first;
		Boolean present = false;
		while (current != null) {
			if (current.Customer == inCustomer) {
				present = true;

			}
			current = current.next;

		}
		return present;
	}

	/**
	 * @param inMovie
	 *            Returns true if Movie present in Queue
	 * @return
	 */
	public Boolean inList(Movie inMovie) {
		Link current = first;
		Boolean present = false;
		while (current != null) {
			if (current.Movie == inMovie) {
				present = true;

			}
			current = current.next;

		}
		return present;
	}

	/**
	 * @return Shows current size of Linked LIst
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
