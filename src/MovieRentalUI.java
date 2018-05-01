import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Label;

public class MovieRentalUI {

	protected Shell shell;
	private Table tblMovies;
	private MovieListSorted sortedMovies;
	private CustomerListSorted sortedCustomers;
	private Button btnRent;
	private Table tblCustomers;
	private TableItem tableItem;
	private List list;
	private Label lblMovies;
	private Label lblCustomers;
	private Label lblCurrentQueue;
	private Label lblCustomersMovieQueue;
	private Button btnReturn;
	private Label lblViewMovie;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			MovieRentalUI window = new MovieRentalUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();

			}
		}
	}

	/**
	 * Creates and sorts Movie objects to be used in program
	 */
	public void createMovies() {
		final int MAX = 10;

		sortedMovies = new MovieListSorted(MAX);
		Movie diehard = new Movie("Die Hard", "John McTiernan");
		Movie diehard2 = new Movie("Die Hard 2", "Renny Harlin");
		Movie ironMan = new Movie("Iron Man", "Jon Favreau");
		Movie bossBaby = new Movie("Boss Baby", "Tom McGrath");
		Movie bladeRunner = new Movie("Blade Runner", "Ridley Scott");
		Movie thor = new Movie("Thor", "Ridley Scott");
		Movie devilsPond = new Movie("Devil's Pond", "Joel Viertel");
		sortedMovies.insert(devilsPond);
		sortedMovies.insert(diehard);
		sortedMovies.insert(thor);
		sortedMovies.insert(bladeRunner);
		sortedMovies.insert(bossBaby);
		sortedMovies.insert(ironMan);
		sortedMovies.insert(diehard2);
		sortedMovies.insertionSort();

	}

	/**
	 * returns customer based on currently selected index in customers table
	 * 
	 * @return
	 */
	public Customer getCustomer() {
		Customer returncust = sortedCustomers.customerArray[tblCustomers.getSelectionIndex()];
		return returncust;
	}

	/**
	 * returns Movie based on currently selected index in Movie's table
	 * 
	 * @return
	 */
	public Movie getMovie() {
		Movie returnMovie = sortedMovies.movieArray[tblMovies.getSelectionIndex()];
		return returnMovie;
	}

	/**
	 * Creates and sorts Customer objects that will be used in program
	 */
	public void createCustomers() {
		final int MAX = 5;

		sortedCustomers = new CustomerListSorted(MAX);
		Customer richard = new Customer("Richard Elias", 0);
		Customer max = new Customer("Max Turner", 1);
		Customer kobe = new Customer("Kobe Slumer", 2);
		Customer martin = new Customer("Martin Jonas", 3);
		Customer Whitney = new Customer("Whitney Swain", 4);
		sortedCustomers.insert(Whitney);
		sortedCustomers.insert(martin);
		sortedCustomers.insert(kobe);
		sortedCustomers.insert(max);
		sortedCustomers.insert(richard);
		sortedCustomers.insertionSort();
	}

	/**
	 * populates visual elements in movie table
	 */
	public void populateMovieTable() {
		TableItem[] tableArray = new TableItem[7];
		for (int i = 0; i < 7; i++) {
			tableArray[i] = new TableItem(tblMovies, SWT.NONE);
			tableArray[i].setText(sortedMovies.movieArray[i].getMovieTitle());
			tableArray[i].setData(i);

		}
	}

	/**
	 * populates visual elements in Customer table
	 */
	public void populateCustomerTable() {
		TableItem[] tableArray2 = new TableItem[5];
		for (int i = 0; i < 5; i++) {
			tableArray2[i] = new TableItem(tblCustomers, SWT.NONE);
			tableArray2[i].setText(sortedCustomers.customerArray[i].getName());
			tableArray2[i].setData(i);
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		createMovies(); // calls create Movies method
		createCustomers(); // calls create customers method

		shell = new Shell();
		shell.setSize(754, 400);
		shell.setText("Burt's ultra rare VHS rental simulator");
		MessageBox message = new MessageBox(shell);
		tblMovies = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);

		tblMovies.setBounds(10, 10, 92, 228);
		tblMovies.setHeaderVisible(true);
		tblMovies.setLinesVisible(true);

		populateMovieTable(); // calls populate Movie table method

		Label lblViewCustomer = new Label(shell, SWT.NONE);
		lblViewCustomer.setBounds(124, 74, 213, 129);
		tblMovies.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc) event listener that runs method to change label to reflect the
			 * customer queue of the currently selected movie
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {

				int i = Integer.parseInt(e.item.getData().toString()); // gets current selected item from event and
																		// references it to the movie array
				if (sortedMovies.movieArray[i].getCurrentCustomer() == null
						& sortedMovies.movieArray[i].customerList.isEmpty()) {
					lblViewCustomer.setText("No one is currentely renting this movie");
				}

				else {

					if (sortedMovies.movieArray[i].getCurrentCustomer() != null) {
						lblViewCustomer.setText(
								"Currently rented: " + sortedMovies.movieArray[i].getCurrentCustomer().getName()
										+ sortedMovies.movieArray[i].customerList.displayList());
					}

					else {
						lblViewCustomer.setText("Currently rented To: No one. "
								+ sortedMovies.movieArray[i].customerList.displayList());
					}

				}
			}
		});

		btnRent = new Button(shell, SWT.NONE);

		btnRent.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc) tests if a selection has been made the customer and user, if so
			 * it runs rent method
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {

				if (tblMovies.getSelectionIndex() == -1 || tblCustomers.getSelectionIndex() == -1) {

					message.setMessage("Please Select a Movie and a user before clicking the rent button");
					message.open();

				}

				else {

					getCustomer().Rent(getMovie());
					message.setMessage((getCustomer().getAddMessage()));
					message.open();
				}

			}
		});
		btnRent.setBounds(262, 283, 75, 25);
		btnRent.setText("Rent Movie");

		tblCustomers = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tblCustomers.setBounds(619, 10, 98, 228);
		tblCustomers.setHeaderVisible(true);
		tblCustomers.setLinesVisible(true);

		tblCustomers.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc) (non-Javadoc) event listener that runs method to change label
			 * to reflect the movie queue of the currently selected customer
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {

				int i = Integer.parseInt(e.item.getData().toString());
				if (sortedCustomers.customerArray[i].getCurrentMovie() == null
						& sortedCustomers.customerArray[i].movieQueue.isEmpty()) {
					lblViewMovie.setText("This Customer has no Movies Checked out");
				}

				else {

					if (sortedCustomers.customerArray[i].getCurrentMovie() != null) {
						lblViewMovie.setText("Currently rented: "
								+ sortedCustomers.customerArray[i].getCurrentMovie().getMovieTitle()
								+ sortedCustomers.customerArray[i].movieQueue.displayList());
					}

					else {
						lblViewMovie.setText(
								"Currently rented: None " + sortedCustomers.customerArray[i].movieQueue.displayList());
					}
				}

			}
		});

		lblMovies = new Label(shell, SWT.NONE);
		lblMovies.setBounds(28, 259, 55, 15);
		lblMovies.setText("Movies");

		lblCustomers = new Label(shell, SWT.NONE);
		lblCustomers.setBounds(635, 259, 57, 15);
		lblCustomers.setText("Customers");

		lblCurrentQueue = new Label(shell, SWT.NONE);
		lblCurrentQueue.setBounds(144, 223, 148, 15);
		lblCurrentQueue.setText("Movie's customer queue");

		lblCustomersMovieQueue = new Label(shell, SWT.NONE);
		lblCustomersMovieQueue.setBounds(400, 223, 137, 15);
		lblCustomersMovieQueue.setText("Customer's Movie Queue");

		btnReturn = new Button(shell, SWT.NONE);
		btnReturn.addSelectionListener(/**
										 * @author Burt method that controls response from return button. runs a check
										 *         to see if a user selection has been made, then it runs return
										 *         routine.
										 */
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						if (tblCustomers.getSelectionIndex() == -1) {
							message.setMessage("Please Select a customer first to initate a return");
							message.open();
						}

				else {
							getCustomer().returnCurrentMovie();
							message.setMessage(getCustomer().getReturnMessage());
							message.open();
						}
					}
				});
		btnReturn.setBounds(362, 283, 83, 25);
		btnReturn.setText("Return Movie");

		lblViewMovie = new Label(shell, SWT.NONE);
		lblViewMovie.setBounds(362, 74, 239, 129);

		populateCustomerTable(); // populates customer table

	}
}
