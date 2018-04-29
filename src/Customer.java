import org.omg.PortableServer.ThreadPolicyOperations;

public class Customer {

	private String name;
	private String city;
	private String state;
	private String favoriteGenre;
	private int customerID;
	private Movie currentMovie;
	public CustomerMovieQueue movieQueue = new CustomerMovieQueue();

	/**
	 * Default constructor method
	 */
	public Customer() {

	}

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

		if (inMovie.customerList.inList(this) == true || inMovie.getCurrentCustomer() == this) // guard rail statement
																								// that prevents the
																								// same user from being
																								// in the customer queue
																								// for a movie multiple
																								// times
			return;

		if (inMovie.getCurrentCustomer() == null & currentMovie == null) { // if statement that delivers movie to
																			// customer if customer has no out standing
																			// rental and the Movie is currently being
																			// rented

			if (inMovie.customerList.isEmpty() == false) {
				if (this == inMovie.customerList.getFirst()) {// if statement determines if customer is first on movies
																// customer list, if so it removes the customer before
																// they are placed as the current customer property
					inMovie.customerList.deleteFirst();
				}
			}
			currentMovie = inMovie;
			inMovie.setCurrentCustomer(this);

		}

		else { // else statement adds movie to users queue and adds customer to Movies queue
			this.movieQueue.insert(inMovie);
			inMovie.customerList.insertLast(this);
		}

	}

	// simplify method
	public void returnCurrentMovie() {
		Movie returnMovie = this.currentMovie;
		Customer nextCustomer;

		returnMovie.setCurrentCustomer(null); // clears current customer and movie values

		if (returnMovie.customerList.isEmpty() == false) {

			if (returnMovie.customerList.getFirst().currentMovie == null) { // check if first person on movie wait list
																			// already has a movie checked out
				nextCustomer = returnMovie.customerList.getFirst();
				returnMovie.customerList.deleteFirst(); // removes customer from movie wait list as they are now
														// actively renting movie
				nextCustomer.Rent(this.currentMovie); // rents movie
			}
		}

		this.currentMovie = null; // clears current movie value for user

		if (this.movieQueue.isEmpty()) // checks customers movie queue, takes no action if it is empty
			return;
		if (this.movieQueue.peekFront().getCurrentCustomer() == null) { // checks if next movie on list is currently
																		// checked out

			if (this.movieQueue.peekFront().customerList.isEmpty() == false) { // checks if list is empty
				this.movieQueue.peekFront().customerList.deleteFirst(); // if list is not empty this deletes the first
																		// object in the list which would be the current
																		// user
				this.Rent(this.movieQueue.peekFront()); // runs rent method
			}

		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFavoriteGenre() {
		return favoriteGenre;
	}

	public void setFavoriteGenre(String favoriteGenre) {
		this.favoriteGenre = favoriteGenre;
	}

	public int getCustomerID() {
		return customerID;
	}

	public Movie getCurrentMovie() {
		return currentMovie;
	}

}
