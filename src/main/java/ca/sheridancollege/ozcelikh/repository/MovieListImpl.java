package ca.sheridancollege.ozcelikh.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import ca.sheridancollege.ozcelikh.beans.Movie;


/**
 * 
 * @author Hizir Ozcelik, October 2021
 */

@Component
public class MovieListImpl implements MovieList {

	public List<Movie> movieList = new CopyOnWriteArrayList<Movie>();

	public List<Movie> getMovieList() {
		return movieList;
	};

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	};
	
	public void emptyList() {
		movieList.clear();
	}

}
