
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
		John.Rent(diehard);
		John.Rent(diehard2);
		//System.out.println(Steven.movieQueue.peekFront().getMovieTitle());
		//diehard.customerList.insertLast(John);
	    //John.Rent(diehard2);
		diehard.setMovieTitle("DieHard");
		diehard.customerList.displayList();
		diehard2.customerList.displayList();
		
		John.returnCurrentMovie();
		Steven.returnCurrentMovie();
		System.out.println(Steven.getCurrentMovie().getMovieTitle());
		John.movieQueue.displayMovieList();
		
		diehard.customerList.displayList();
		//System.out.println(diehard.getCurrentCustomer().getName()); 
		
		diehard2.customerList.displayList();
		//System.out.println(diehard2.getCurrentCustomer().getName()); 
       // System.out.println(Steven.movieQueue.peekFront().getMovieTitle());
        
        
		
		
		
		
		
		// diehard.customerList;
//diehard2.customerList.displayList();


	}

}
