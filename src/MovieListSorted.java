
/**
 * @author Burt Class that sorts Movie List with insertion sort
 */
public class MovieListSorted {

	public Movie[] movieArray; // ref to array, public to be accessed by UI build
	private int nElems; // number of data items

	/**
	 * @param max
	 *            Constructor that sets the MAX array size
	 */
	public MovieListSorted(int max) // constructor
	{
		movieArray = new Movie[max]; // create the array
		nElems = 0; // no items yet
	}

	/**
	 * @param value
	 *            inserts Movie into array
	 */
	public void insert(Movie value) // put element into array
	{
		movieArray[nElems] = value; // insert it
		nElems++; // increment size
	}

	/**
	 * displays array contents
	 */
	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(movieArray[j].getMovieTitle() + " "); // display it
		System.out.println("");
	}

	/**
	 * Initiates sort
	 */
	public void insertionSort() {
		int in, out;

		for (out = 1; out < nElems; out++) // out is dividing line
		{
			String tempName = movieArray[out].getMovieTitle();
			Movie temp = movieArray[out];// remove marked item
			in = out; // start shifts at out
			while (in > 0 && movieArray[in - 1].getMovieTitle().compareToIgnoreCase(tempName) >= 0) // until one is
																									// smaller,
			{
				movieArray[in] = movieArray[in - 1]; // shift item to right
				--in; // go left one position
			}
			movieArray[in] = temp; // insert marked item
		} // end for
	} // end insertionSort()

}
