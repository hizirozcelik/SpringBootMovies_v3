package ca.sheridancollege.ozcelikh.repository;

import java.util.List;

import ca.sheridancollege.ozcelikh.beans.Movie;

/**
 * 
 * @author Hizir Ozcelik, October 2021
 */

public interface MovieList {

	public List<Movie> getMovieList();

	public void setMovieList(List<Movie> movieList);
	
	public void emptyList();

}
