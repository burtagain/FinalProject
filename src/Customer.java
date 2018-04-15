
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
	 * This method accepts a movie object as input and determines if the movie should be delivered or added to the users movie queue
	 */
	public void Rent(Movie inMovie) {

		if (inMovie.customerList.inList(this) == true || inMovie.getCurrentCustomer() == this) //guard rail statement that prevents the same user from being in the customer queue for a movie multiple times
			return;

		if (inMovie.getCurrentCustomer() == null & currentMovie == null) {  //if statement that delivers movie to customer if customer has no out standing rental and the Movie is currently being rented

			currentMovie = inMovie;
			inMovie.setCurrentCustomer(this);

		}

		else {                                 //else statement adds movie to users queue and adds customer to Movies queue
			this.movieQueue.insert(inMovie);
			inMovie.customerList.insertLast(this);
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
