
/**
 * @author Link Class that specifies a link object which contains a Movie object
 */
public class Link {

	public Movie movie;

	public Link next;

	public Link(Movie inMovie) {

		movie = inMovie;

	}

	/**
	 * Displays can object stored in Link
	 */
	public void displayLink() {
		System.out.print("{" + movie + "} ");
	}
}
