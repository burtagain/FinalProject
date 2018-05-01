
/**
 * @author Burt
 *
 *         Class that sorts Customer List with insertion sort
 */
public class CustomerListSorted {

	public Customer[] customerArray; // ref to array, public to be accessed by UI build
	private int nElems; // number of data items

	/**
	 * @param max
	 *            Constructor that sets the MAX array size
	 */
	public CustomerListSorted(int max) {
		customerArray = new Customer[max]; // create the array
		nElems = 0; // no items yet
	}

	/**
	 * @param value
	 *            inserts customer into array
	 */
	public void insert(Customer value) // put element into array
	{
		customerArray[nElems] = value; // insert it
		nElems++; // increment size
	}

	/**
	 * displays array contents
	 */
	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(customerArray[j].getName() + " "); // display it
		System.out.println("");
	}

	/**
	 * Initiates sort
	 */
	public void insertionSort() {
		int in, out;

		for (out = 1; out < nElems; out++) // out is dividing line
		{
			String tempName = customerArray[out].getName();
			Customer temp = customerArray[out];// remove marked item
			in = out; // start shifts at out
			while (in > 0 && customerArray[in - 1].getName().compareToIgnoreCase(tempName) >= 0) // until one is
																									// smaller,
			{
				customerArray[in] = customerArray[in - 1]; // shift item to right
				--in; // go left one position
			}
			customerArray[in] = temp; // insert marked item
		} // end for
	} // end insertionSort()
	// --------------------------------------------------------------
}
