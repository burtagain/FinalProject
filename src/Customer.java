
public class Customer {

	private String name;
	private String city;
	private String state;
	private String favoriteGenre; 
	
	/**
	 * Default constructor method
	 */
	public Customer() {
		
	}
	
	public Customer(String intName, String intCity, String intState, String intFavGene) {
		
		name = intName;
		city = intCity;
		state = intState;
		favoriteGenre = intFavGene;
		
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
	
	
	
}
