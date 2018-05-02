import org.omg.PortableServer.ThreadPolicyOperations;

public class Customer {

	private String name;

	private int customerID;
	private Movie currentMovie;
	// public CustomerMovieQueue movieQueue = new CustomerMovieQueue();
	public LinkedList movieQueue = new LinkedList();
	private String addMessage; //this is a string that is passed to the UI to show status events during rent method
	private String returnMessage; //this is a string that is passed to the UI to show status events during return method

	/**
	 * Default constructor method
	 */
	public Customer() {

	}

	/**
	 * @param intName
	 * @param inCustomerID
	 *            Constructor that instantiates customer name and ID number
	 */
	public Customer(String intName, int inCustomerID) {

		name = intName;
		customerID = inCustomerID;

	}

	/**
	 * @param inMovie
	 *            This method accepts a movie object as input and determines if the
	 *            movie should be delivered or added to the users movie queue
	 */
	public void Rent(Movie inMovie) {
		// due to the complexity of this method I have visually divided it up to make it
		// easier to follow its logic
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// test if user already has movie rented
		if (inMovie.customerList.inList(this) == true || inMovie.getCurrentCustomer() == this) { 
			addMessage = this.name + "already has " + inMovie.getMovieTitle() + " Checked out or in their queue"; 
			// guard rail statement																																																						// the
			// prevents same user from being
			// in the customer queue
			// for a movie multiple
			// times
			return;
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Checks out current movie if customer and movie are both free
		if (inMovie.getCurrentCustomer() == null & currentMovie == null) { // if statement that delivers movie to
																			// customer if customer has no out standing
																			// rental and the Movie is currently being
																			// rented

			if (inMovie.customerList.isEmpty() == false) {
				if (this == inMovie.customerList.getFirstCust()) {// if statement determines if customer is first on
																	// movies customer list,
																	//  if so it removes the customer
																	// before they are placed
																	//  as the current customer property
					inMovie.customerList.deleteFirst();

				}
			}
			currentMovie = inMovie; // sets movie as current movie user is renting

			inMovie.setCurrentCustomer(this); // sets customer as current renter of movie on Movie object

			if (this.movieQueue.isEmpty() == false) { // checks if movie being rented is the same as the first on list,
														// if so removes it
				if (this.movieQueue.getFirstMov() == inMovie)
					this.movieQueue.deleteFirst();
			}

			addMessage = this.getName() + " Rented " + inMovie.getMovieTitle(); // sends message to say that movie has
																				// been rented
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// If customer and user are not free, user and movie is added to queues
		else { // else statement adds movie to users queue and adds customer to Movies queue
			this.movieQueue.insertLast(inMovie);
			inMovie.customerList.insertLast(this);
			addMessage = this.getName() + "Has placed " + inMovie.getMovieTitle() + " In their queue.";
		}

	}

	/**
	 * runs process to return current Movie
	 */
	public void returnCurrentMovie() {
		if (this.currentMovie != null) {
			processReturnedMovie();
			processNextCustomerRental();
		}

		else {
			returnMessage = this.name + " does not have any movies currently checked out"; // sets return message text
		}

	}

	/**
	 * subprocess used by return current movie method processes returned movie and
	 * checks it out to next customer if they are available
	 */
	public void processReturnedMovie() {
		Movie returnMovie = this.currentMovie;
		Customer nextCustomer;

		returnMessage = this.name + " returned " + this.currentMovie.getMovieTitle(); // sets return
		returnMovie.setCurrentCustomer(null); // clears current customer and movie values

		if (returnMovie.customerList.isEmpty() == false) {

			if (returnMovie.customerList.getFirstCust().currentMovie == null) { // check if first person on movie wait
																				// list
				// already has a movie checked out
				nextCustomer = returnMovie.customerList.getFirstCust();
				returnMovie.customerList.deleteFirst(); // removes customer from movie wait list as they are now
														// actively renting movie
				nextCustomer.Rent(this.currentMovie); // rents movie

			}
		}

		this.currentMovie = null; // clears current movie value for user
	}

	/**
	 * @return returns movie return message
	 */
	public String getReturnMessage() {
		return returnMessage;
	}

	/**
	 * Processes next customer rental
	 */
	public void processNextCustomerRental() {

		if (this.movieQueue.isEmpty()) // checks customers movie queue, takes no action if it is empty
			return;
		if (this.movieQueue.getFirstMov().getCurrentCustomer() == null) { // checks if next movie on list is currently
																			// checked out

			if (this.movieQueue.getFirstMov().customerList.isEmpty() == false) { // checks if list is empty
				this.movieQueue.getFirstMov().customerList.deleteFirst(); // if list is not empty this deletes the first
				// object in the list which would be the current
				// user
				this.Rent(this.movieQueue.getFirstMov()); // runs rent method
			}

		}
	}

	/**
	 * @return returns customers name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            sets customer name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return returns customer's ID number
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * @return returns customers currently checked out movie
	 */
	public Movie getCurrentMovie() {

		return currentMovie;
	}

	/**
	 * @return returns message for when movie is rented
	 */
	public String getAddMessage() {
		return addMessage;
	}

}
