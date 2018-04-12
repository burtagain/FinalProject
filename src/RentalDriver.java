
public class RentalDriver {

	public static void main(String[] args) {
		Movie diehard = new Movie();
		Movie diehard2 = new Movie();
		Customer Steven = new Customer("Steven", 1);
		Customer John = new Customer("John", 2);
		Customer Michaela = new Customer("Michaela", 3);
		diehard.customerList.insertLast(Steven);
		diehard.customerList.insertLast(John);
		diehard.customerList.displayList();
		diehard.setMovieTitle("DieHard");
		// diehard.customerList;
diehard2.customerList.insertLast(Michaela);
diehard2.customerList.insertLast(Michaela);
diehard2.customerList.displayList();


	}

}
