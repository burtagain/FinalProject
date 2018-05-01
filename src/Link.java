
/**
 * @author polymorphic Link Class that specifies a link object which contains a
 *         Movie or Customer object object
 */
public class Link {

	public Customer Customer; // field for storing customer object
	public Movie Movie; // field for storing Movie object
	public Link next; // field for linking to next object
	private String sep = System.lineSeparator(); // creates line separator for returned strings

	/**
	 * @param inCustomer
	 *            Constructor for creating link object with Customer object as data
	 */
	public Link(Customer inCustomer) {

		Customer = inCustomer;

	}

	/**
	 * @param inMovie
	 *            Constructor for creating link object with Movie object as data
	 */
	public Link(Movie inMovie) {

		Movie = inMovie;

	}

	/**
	 * Displays can object stored in Link
	 */
	public String displayLink() {
		// checks if object is a Movie or Customer object and returns the appropriate
		// value
		String outString = "";
		if (Movie != null) {
			outString = ("{" + Movie.getMovieTitle() + "} " + sep);
		}

		else if (Customer != null) {
			outString = ("{" + Customer.getName() + "} " + sep);
		}

		return outString;
	}

}
