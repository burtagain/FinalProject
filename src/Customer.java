
public class Customer {

	private String name;
	private String city;
	private String state;
	private String favoriteGenre; 
	private int customerID;
	private Movie currentMovie;
	
	/**
	 * Default constructor method
	 */
	public Customer() {
		
	}
	
	public Customer(String intName, int inCustomerID) {
		
		name = intName;
		customerID = inCustomerID;
		
	}
	
	public void Rent(Movie inMovie) {
		if (inMovie.customerList.inList(this) == false) {
			
			inMovie.customerList.insertLast(this);
			
			if (inMovie.customerList.getFirst() == this & currentMovie == null) {
				currentMovie = inMovie;
				
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
	
	
	
}
