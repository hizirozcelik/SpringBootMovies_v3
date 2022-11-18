package ca.sheridancollege.ozcelikh.beans;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Hizir Ozcelik, October 2021
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	
	private Long id;
	private String name;
	private String platform;
	private String userName;
	private @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime;
	private String review;
	

	
	
	

}
