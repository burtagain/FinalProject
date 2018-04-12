
public class Movie {
	
	private String movieTitle;
	private String director;
	public LinkedList customerList = new LinkedList();
	private Customer currentCustomer;
	
	public Movie () {
		
	}

public Movie (String intTitle, String intDir) {
		movieTitle = intTitle;
		director = intDir;
		
	}



public String getMovieTitle() {
	return movieTitle;
}

public void setMovieTitle(String movieTitle) {
	this.movieTitle = movieTitle;
}

public String getDirector() {
	return director;
}

public void setDirector(String director) {
	this.director = director;
}
	


}
