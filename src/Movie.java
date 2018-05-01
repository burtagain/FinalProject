
/**
 * @author Burt Movie Class that defines properties and methods for Movie
 *         Objects
 */
public class Movie {

	private String movieTitle; // title of Movie
	private String director; // director of movie
	public LinkedList customerList = new LinkedList(); // new linked list to be used to store customers
	private Customer currentCustomer; // stores current customer value

	/**
	 * Default movie constructor
	 */
	public Movie() {

	}

	/**
	 * @param intTitle
	 * @param intDir
	 *            Constructor that populates movie title and movie director
	 */
	public Movie(String intTitle, String intDir) {
		movieTitle = intTitle;
		director = intDir;

	}

	/**
	 * @return returns Movie Title
	 */
	public String getMovieTitle() {
		return movieTitle;
	}

	/**
	 * @param movieTitle
	 *            Sets Movie title
	 */
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	/**
	 * @return returns Director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director
	 *            Sets Director
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return returns Current Customer
	 */
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	/**
	 * @param currentCustomer
	 *            Sets Current Customer
	 */
	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

}
