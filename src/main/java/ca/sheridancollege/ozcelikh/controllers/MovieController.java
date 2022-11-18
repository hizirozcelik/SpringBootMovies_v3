package ca.sheridancollege.ozcelikh.controllers;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.ozcelikh.beans.Movie;
import ca.sheridancollege.ozcelikh.repository.MovieList;

/**
 * 
 * @author Hizir Ozcelik, October 2021
 */

@Controller
public class MovieController {

	private MovieList movieList;

	public MovieController(MovieList movieList) {

		super();
// Reviews are retrieved and adapted from https://www.vulture.com/article/best-movies-2021.html		
		movieList.getMovieList().add(new Movie(Long.valueOf(1), "Saint Maud", "Amazon Prime", "Alison Willmore",
				LocalDateTime.parse("2021-10-01T17:48:23"),
				"Maud, the hospice nurse played with electric conviction "
						+ "by Morfydd Clark, is either possessed by the Holy Spirit or something darker. What’s so cunning about writer-director "
						+ "Rose Glass’s debut is how little that matters, because Maud’s newfound religious fervor has an intensity that’s "
						+ "terrifying either way. Having reinvented herself after a traumatic work incident as an ecstatic ascetic who believes "
						+ "that God has a special purpose in store for her, Maud gloms onto her latest client, a choreographer with terminal "
						+ "lymphoma played by Jennifer Ehle, sure that she’s supposed to save the embittered bohemian’s soul. Disaster seems "
						+ "inevitable, but what makes Saint Maud so nail-bitingly tense is that it’s impossible to guess the form in which it’ll "
						+ "come, especially as we become immersed in Maud’s warped, hallucinatory way of seeing the world."));

		movieList.getMovieList().add(new Movie(Long.valueOf(2), "The Dig", "Netflix", "Bilge Ebiri",
				LocalDateTime.parse("2021-10-02T18:48:23"),
				"Simon Stone’s The Dig opens sometime in the 1930s with humble "
						+ "excavator and amateur archeologist Basil Brown (Ralph Fiennes) being called to the stately Suffolk home of wealthy "
						+ "widow Edith Pretty (Carey Mulligan) to dig up a series of large, mysterious mounds on her property. Soon enough, "
						+ "he’s uncovering something far grander than anyone previously imagined — an entire ship buried underground, the "
						+ "tomb of an ancient Anglo-Saxon king and proof that the people who inhabited this land were more than mere Vikings. "
						+ "As the dig goes on and our characters learn more about the past and the people who came before them, the small "
						+ "gestures of their own lives begin to feel both inconsequential and seismic. To convey these seemingly paradoxical "
						+ "ideas, Stone and screenwriter Moira Buffini adopt an elliptical, glancing style that treats the present almost as "
						+ "if it were already a memory. Scenes weave in and out of each other. Conversations happen without anyone moving "
						+ "their mouths, the sounds of one intimate moment intruding on the images of another. Time jumps backward and forward. "
						+ "Death is intercut with passion, as tragedy and glory tangle onscreen. It’s as if the dig itself radiates out a "
						+ "new understanding of existence, revealing both the broad arc of history and the curlicues of love, loyalty, and l"
						+ "oss that abound within it."));

		movieList.getMovieList().add(new Movie(Long.valueOf(3), "Acasa, My Home", "Google Play", "B.E",
				LocalDateTime.parse("2021-10-03T17:48:23"),
				"Initially intended to be the site of a reservoir "
						+ "but never actually filled up, Vacaresti Nature Park has stood in the center of the Romanian capital of Bucharest "
						+ "for decades, neglected by bureaucrats and slowly emerging as a rich marshland with startling biodiversity, the "
						+ "largest urban wilderness in Europe. It’s also the unofficial home of a man named Gica Enache, who, with his wife "
						+ "and nine children — not to mention a few pigeons, chickens, dogs, cats, and pigs — has resided here for nearly 20 "
						+ "years, away from the world in a kind of impoverished, idyllic life off the grid. Shot over three years, "
						+ "Radu Ciorniciuc’s film follows Gica and his family as their existence is interrupted by the growing demands of "
						+ "the modern world. But Acasa is not exactly a movie about paradise lost. Ciorniciuc seamlessly blends intimacy "
						+ "and lyricism with a clear-eyed honesty about what he’s depicting. The film comes in at under an hour and a half,"
						+ " but we see Vacaresti transformed and the Enache family sent into an existential tailspin. Over and over in this "
						+ "poisoned pastoral, the lost dream of the idyll clashes with the sad workings of reality."));

		this.movieList = movieList;
	}

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("movie", new Movie());
		model.addAttribute("movieList", movieList.getMovieList());

		return "index";
	}

	@PostMapping("/addMovie")
	public String addMovie(Model model, @ModelAttribute Movie movie) {

		movie.setDateTime(LocalDateTime.now().withNano(0));

		movieList.getMovieList().add(movie);

		model.addAttribute("movie", new Movie());
		model.addAttribute("movieList", movieList.getMovieList());

		return "index";
	}

}