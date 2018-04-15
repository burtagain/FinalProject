
public class RentalDriver {

	public static void main(String[] args) {
		Movie diehard = new Movie();
		Movie diehard2 = new Movie();
		Customer Steven = new Customer("Steven", 1);
		Customer John = new Customer("John", 2);
		Customer Michaela = new Customer("Michaela", 3);
		diehard.setMovieTitle("DieHard");
		diehard2.setMovieTitle("Die Hard 2");
		Steven.Rent(diehard);
		Steven.Rent(diehard2);
		System.out.println(Steven.movieQueue.peekFront().getMovieTitle());
		Steven.Rent(diehard);
		diehard.customerList.insertLast(John);
	    John.Rent(diehard2);
		diehard.customerList.displayList();
		diehard.setMovieTitle("DieHard");
		
		// diehard.customerList;
diehard2.customerList.displayList();
System.out.println(diehard.getCurrentCustomer().getName()); 
System.out.println(diehard2.getCurrentCustomer().getName()); 


	}

}
